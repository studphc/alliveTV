package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import android.util.Xml;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.XmlPullParserUtil;
import com.google.common.base.Ascii;
import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: classes.dex */
public class DashManifestParser extends DefaultHandler implements ParsingLoadable.Parser<DashManifest> {

    /* renamed from: b */
    public static final Pattern f11319b = Pattern.compile("(\\d+)(?:/(\\d+))?");

    /* renamed from: c */
    public static final Pattern f11320c = Pattern.compile("CC([1-4])=.*");

    /* renamed from: d */
    public static final Pattern f11321d = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");

    /* renamed from: e */
    public static final int[] f11322e = {-1, 1, 2, 3, 4, 5, 6, 8, 2, 3, 4, 7, 8, 24, 8, 12, 10, 12, 14, 12, 14};

    /* renamed from: a */
    public final XmlPullParserFactory f11323a;

    /* loaded from: classes.dex */
    public static final class RepresentationInfo {
        public final ImmutableList<BaseUrl> baseUrls;
        public final ArrayList<DrmInitData.SchemeData> drmSchemeDatas;

        @Nullable
        public final String drmSchemeType;
        public final List<Descriptor> essentialProperties;
        public final Format format;
        public final ArrayList<Descriptor> inbandEventStreams;
        public final long revisionId;
        public final SegmentBase segmentBase;
        public final List<Descriptor> supplementalProperties;

        public RepresentationInfo(Format format, List<BaseUrl> list, SegmentBase segmentBase, @Nullable String str, ArrayList<DrmInitData.SchemeData> arrayList, ArrayList<Descriptor> arrayList2, List<Descriptor> list2, List<Descriptor> list3, long j) {
            this.format = format;
            this.baseUrls = ImmutableList.copyOf((Collection) list);
            this.segmentBase = segmentBase;
            this.drmSchemeType = str;
            this.drmSchemeDatas = arrayList;
            this.inbandEventStreams = arrayList2;
            this.essentialProperties = list2;
            this.supplementalProperties = list3;
            this.revisionId = j;
        }
    }

    public DashManifestParser() {
        try {
            this.f11323a = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    public static void maybeSkipTag(XmlPullParser xmlPullParser) {
        if (!XmlPullParserUtil.isStartTag(xmlPullParser)) {
            return;
        }
        int i = 1;
        while (i != 0) {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser)) {
                i++;
            } else if (XmlPullParserUtil.isEndTag(xmlPullParser)) {
                i--;
            }
        }
    }

    public static int parseCea608AccessibilityChannel(List<Descriptor> list) {
        String str;
        for (int i = 0; i < list.size(); i++) {
            Descriptor descriptor = list.get(i);
            if ("urn:scte:dash:cc:cea-608:2015".equals(descriptor.schemeIdUri) && (str = descriptor.value) != null) {
                Matcher matcher = f11320c.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                Log.m3027w("MpdParser", "Unable to parse CEA-608 channel number from: " + descriptor.value);
            }
        }
        return -1;
    }

    public static int parseCea708AccessibilityChannel(List<Descriptor> list) {
        String str;
        for (int i = 0; i < list.size(); i++) {
            Descriptor descriptor = list.get(i);
            if ("urn:scte:dash:cc:cea-708:2015".equals(descriptor.schemeIdUri) && (str = descriptor.value) != null) {
                Matcher matcher = f11321d.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                Log.m3027w("MpdParser", "Unable to parse CEA-708 service block number from: " + descriptor.value);
            }
        }
        return -1;
    }

    public static long parseDateTime(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue == null) {
            return j;
        }
        return Util.parseXsDateTime(attributeValue);
    }

    public static Descriptor parseDescriptor(XmlPullParser xmlPullParser, String str) {
        String parseString = parseString(xmlPullParser, "schemeIdUri", "");
        String parseString2 = parseString(xmlPullParser, "value", null);
        String parseString3 = parseString(xmlPullParser, "id", null);
        do {
            xmlPullParser.next();
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, str));
        return new Descriptor(parseString, parseString2, parseString3);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int parseDolbyChannelConfiguration(XmlPullParser xmlPullParser) {
        char c;
        String attributeValue = xmlPullParser.getAttributeValue(null, "value");
        if (attributeValue == null) {
            return -1;
        }
        String lowerCase = Ascii.toLowerCase(attributeValue);
        lowerCase.getClass();
        switch (lowerCase.hashCode()) {
            case 1596796:
                if (lowerCase.equals("4000")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 2937391:
                if (lowerCase.equals("a000")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 3094035:
                if (lowerCase.equals("f801")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 3133436:
                if (lowerCase.equals("fa01")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 6;
            case 3:
                return 8;
            default:
                return -1;
        }
    }

    public static int parseDtsChannelConfiguration(XmlPullParser xmlPullParser) {
        int parseInt = parseInt(xmlPullParser, "value", -1);
        if (parseInt <= 0 || parseInt >= 33) {
            return -1;
        }
        return parseInt;
    }

    public static int parseDtsxChannelConfiguration(XmlPullParser xmlPullParser) {
        int bitCount;
        String attributeValue = xmlPullParser.getAttributeValue(null, "value");
        if (attributeValue == null || (bitCount = Integer.bitCount(Integer.parseInt(attributeValue, 16))) == 0) {
            return -1;
        }
        return bitCount;
    }

    public static long parseDuration(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue == null) {
            return j;
        }
        return Util.parseXsDuration(attributeValue);
    }

    public static String parseEac3SupplementalProperties(List<Descriptor> list) {
        for (int i = 0; i < list.size(); i++) {
            Descriptor descriptor = list.get(i);
            String str = descriptor.schemeIdUri;
            if (!"tag:dolby.com,2018:dash:EC3_ExtensionType:2018".equals(str) || !"JOC".equals(descriptor.value)) {
                if ("tag:dolby.com,2014:dash:DolbyDigitalPlusExtensionType:2014".equals(str) && MimeTypes.CODEC_E_AC3_JOC.equals(descriptor.value)) {
                    return MimeTypes.AUDIO_E_AC3_JOC;
                }
            } else {
                return MimeTypes.AUDIO_E_AC3_JOC;
            }
        }
        return MimeTypes.AUDIO_E_AC3;
    }

    public static float parseFloat(XmlPullParser xmlPullParser, String str, float f) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue != null) {
            return Float.parseFloat(attributeValue);
        }
        return f;
    }

    public static float parseFrameRate(XmlPullParser xmlPullParser, float f) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "frameRate");
        if (attributeValue != null) {
            Matcher matcher = f11319b.matcher(attributeValue);
            if (matcher.matches()) {
                int parseInt = Integer.parseInt(matcher.group(1));
                if (!TextUtils.isEmpty(matcher.group(2))) {
                    return parseInt / Integer.parseInt(r2);
                }
                return parseInt;
            }
            return f;
        }
        return f;
    }

    public static int parseInt(XmlPullParser xmlPullParser, String str, int i) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue != null) {
            return Integer.parseInt(attributeValue);
        }
        return i;
    }

    public static long parseLastSegmentNumberSupplementalProperty(List<Descriptor> list) {
        for (int i = 0; i < list.size(); i++) {
            Descriptor descriptor = list.get(i);
            if (Ascii.equalsIgnoreCase("http://dashif.org/guidelines/last-segment-number", descriptor.schemeIdUri)) {
                return Long.parseLong(descriptor.value);
            }
        }
        return -1L;
    }

    public static long parseLong(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue != null) {
            return Long.parseLong(attributeValue);
        }
        return j;
    }

    public static int parseMpegChannelConfiguration(XmlPullParser xmlPullParser) {
        int parseInt = parseInt(xmlPullParser, "value", -1);
        if (parseInt < 0) {
            return -1;
        }
        int[] iArr = f11322e;
        if (parseInt >= iArr.length) {
            return -1;
        }
        return iArr[parseInt];
    }

    public static String parseString(XmlPullParser xmlPullParser, String str, String str2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue != null) {
            return attributeValue;
        }
        return str2;
    }

    public static String parseText(XmlPullParser xmlPullParser, String str) {
        String str2 = "";
        do {
            xmlPullParser.next();
            if (xmlPullParser.getEventType() == 4) {
                str2 = xmlPullParser.getText();
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, str));
        return str2;
    }

    /* renamed from: a */
    public final long m2787a(ArrayList arrayList, long j, long j2, int i, long j3) {
        int ceilDivide;
        if (i >= 0) {
            ceilDivide = i + 1;
        } else {
            ceilDivide = (int) Util.ceilDivide(j3 - j, j2);
        }
        for (int i2 = 0; i2 < ceilDivide; i2++) {
            arrayList.add(buildSegmentTimelineElement(j, j2));
            j += j2;
        }
        return j;
    }

    public AdaptationSet buildAdaptationSet(int i, int i2, List<Representation> list, List<Descriptor> list2, List<Descriptor> list3, List<Descriptor> list4) {
        return new AdaptationSet(i, i2, list, list2, list3, list4);
    }

    public EventMessage buildEvent(String str, String str2, long j, long j2, byte[] bArr) {
        return new EventMessage(str, str2, j2, j, bArr);
    }

    public EventStream buildEventStream(String str, String str2, long j, long[] jArr, EventMessage[] eventMessageArr) {
        return new EventStream(str, str2, j, jArr, eventMessageArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Format buildFormat(@Nullable String str, @Nullable String str2, int i, int i2, float f, int i3, int i4, int i5, @Nullable String str3, List<Descriptor> list, List<Descriptor> list2, @Nullable String str4, List<Descriptor> list3, List<Descriptor> list4) {
        String str5;
        String str6;
        int i6;
        if (MimeTypes.isAudio(str2)) {
            str5 = MimeTypes.getAudioMediaMimeType(str4);
        } else if (MimeTypes.isVideo(str2)) {
            str5 = MimeTypes.getVideoMediaMimeType(str4);
        } else if (MimeTypes.isText(str2) || MimeTypes.isImage(str2)) {
            str5 = str2;
        } else if (MimeTypes.APPLICATION_MP4.equals(str2)) {
            str5 = MimeTypes.getMediaMimeType(str4);
            if (MimeTypes.TEXT_VTT.equals(str5)) {
                str5 = MimeTypes.APPLICATION_MP4VTT;
            }
        } else {
            str5 = null;
        }
        if (MimeTypes.AUDIO_E_AC3.equals(str5)) {
            str5 = parseEac3SupplementalProperties(list4);
            if (MimeTypes.AUDIO_E_AC3_JOC.equals(str5)) {
                str6 = MimeTypes.CODEC_E_AC3_JOC;
                int parseSelectionFlagsFromRoleDescriptors = parseSelectionFlagsFromRoleDescriptors(list);
                Format.Builder language = new Format.Builder().setId(str).setContainerMimeType(str2).setSampleMimeType(str5).setCodecs(str6).setPeakBitrate(i5).setSelectionFlags(parseSelectionFlagsFromRoleDescriptors).setRoleFlags(parseRoleFlagsFromRoleDescriptors(list) | parseRoleFlagsFromAccessibilityDescriptors(list2) | parseRoleFlagsFromProperties(list3) | parseRoleFlagsFromProperties(list4)).setLanguage(str3);
                if (!MimeTypes.isVideo(str5)) {
                    language.setWidth(i).setHeight(i2).setFrameRate(f);
                } else if (MimeTypes.isAudio(str5)) {
                    language.setChannelCount(i3).setSampleRate(i4);
                } else if (MimeTypes.isText(str5)) {
                    if (MimeTypes.APPLICATION_CEA608.equals(str5)) {
                        i6 = parseCea608AccessibilityChannel(list2);
                    } else if (MimeTypes.APPLICATION_CEA708.equals(str5)) {
                        i6 = parseCea708AccessibilityChannel(list2);
                    } else {
                        i6 = -1;
                    }
                    language.setAccessibilityChannel(i6);
                } else if (MimeTypes.isImage(str5)) {
                    language.setWidth(i).setHeight(i2);
                }
                return language.build();
            }
        }
        str6 = str4;
        int parseSelectionFlagsFromRoleDescriptors2 = parseSelectionFlagsFromRoleDescriptors(list);
        Format.Builder language2 = new Format.Builder().setId(str).setContainerMimeType(str2).setSampleMimeType(str5).setCodecs(str6).setPeakBitrate(i5).setSelectionFlags(parseSelectionFlagsFromRoleDescriptors2).setRoleFlags(parseRoleFlagsFromRoleDescriptors(list) | parseRoleFlagsFromAccessibilityDescriptors(list2) | parseRoleFlagsFromProperties(list3) | parseRoleFlagsFromProperties(list4)).setLanguage(str3);
        if (!MimeTypes.isVideo(str5)) {
        }
        return language2.build();
    }

    public DashManifest buildMediaPresentationDescription(long j, long j2, long j3, boolean z, long j4, long j5, long j6, long j7, @Nullable ProgramInformation programInformation, @Nullable UtcTimingElement utcTimingElement, @Nullable ServiceDescriptionElement serviceDescriptionElement, @Nullable Uri uri, List<Period> list) {
        return new DashManifest(j, j2, j3, z, j4, j5, j6, j7, programInformation, utcTimingElement, serviceDescriptionElement, uri, list);
    }

    public Period buildPeriod(@Nullable String str, long j, List<AdaptationSet> list, List<EventStream> list2, @Nullable Descriptor descriptor) {
        return new Period(str, j, list, list2, descriptor);
    }

    public RangedUri buildRangedUri(String str, long j, long j2) {
        return new RangedUri(str, j, j2);
    }

    public Representation buildRepresentation(RepresentationInfo representationInfo, @Nullable String str, @Nullable String str2, ArrayList<DrmInitData.SchemeData> arrayList, ArrayList<Descriptor> arrayList2) {
        String str3;
        Format.Builder buildUpon = representationInfo.format.buildUpon();
        if (str != null) {
            buildUpon.setLabel(str);
        }
        String str4 = representationInfo.drmSchemeType;
        if (str4 != null) {
            str2 = str4;
        }
        ArrayList<DrmInitData.SchemeData> arrayList3 = representationInfo.drmSchemeDatas;
        arrayList3.addAll(arrayList);
        if (!arrayList3.isEmpty()) {
            int i = 0;
            while (true) {
                if (i < arrayList3.size()) {
                    DrmInitData.SchemeData schemeData = arrayList3.get(i);
                    if (C0643C.CLEARKEY_UUID.equals(schemeData.uuid) && (str3 = schemeData.licenseServerUrl) != null) {
                        arrayList3.remove(i);
                        break;
                    }
                    i++;
                } else {
                    str3 = null;
                    break;
                }
            }
            if (str3 != null) {
                for (int i2 = 0; i2 < arrayList3.size(); i2++) {
                    DrmInitData.SchemeData schemeData2 = arrayList3.get(i2);
                    if (C0643C.COMMON_PSSH_UUID.equals(schemeData2.uuid) && schemeData2.licenseServerUrl == null) {
                        arrayList3.set(i2, new DrmInitData.SchemeData(C0643C.CLEARKEY_UUID, str3, schemeData2.mimeType, schemeData2.data));
                    }
                }
            }
            for (int size = arrayList3.size() - 1; size >= 0; size--) {
                DrmInitData.SchemeData schemeData3 = arrayList3.get(size);
                if (!schemeData3.hasData()) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= arrayList3.size()) {
                            break;
                        }
                        if (arrayList3.get(i3).canReplace(schemeData3)) {
                            arrayList3.remove(size);
                            break;
                        }
                        i3++;
                    }
                }
            }
            buildUpon.setDrmInitData(new DrmInitData(str2, arrayList3));
        }
        ArrayList<Descriptor> arrayList4 = representationInfo.inbandEventStreams;
        arrayList4.addAll(arrayList2);
        return Representation.newInstance(representationInfo.revisionId, buildUpon.build(), representationInfo.baseUrls, representationInfo.segmentBase, arrayList4, representationInfo.essentialProperties, representationInfo.supplementalProperties, null);
    }

    public SegmentBase.SegmentList buildSegmentList(RangedUri rangedUri, long j, long j2, long j3, long j4, @Nullable List<SegmentBase.SegmentTimelineElement> list, long j5, @Nullable List<RangedUri> list2, long j6, long j7) {
        return new SegmentBase.SegmentList(rangedUri, j, j2, j3, j4, list, j5, list2, Util.msToUs(j6), Util.msToUs(j7));
    }

    public SegmentBase.SegmentTemplate buildSegmentTemplate(RangedUri rangedUri, long j, long j2, long j3, long j4, long j5, List<SegmentBase.SegmentTimelineElement> list, long j6, @Nullable UrlTemplate urlTemplate, @Nullable UrlTemplate urlTemplate2, long j7, long j8) {
        return new SegmentBase.SegmentTemplate(rangedUri, j, j2, j3, j4, j5, list, j6, urlTemplate, urlTemplate2, Util.msToUs(j7), Util.msToUs(j8));
    }

    public SegmentBase.SegmentTimelineElement buildSegmentTimelineElement(long j, long j2) {
        return new SegmentBase.SegmentTimelineElement(j, j2);
    }

    public SegmentBase.SingleSegmentBase buildSingleSegmentBase(RangedUri rangedUri, long j, long j2, long j3, long j4) {
        return new SegmentBase.SingleSegmentBase(rangedUri, j, j2, j3, j4);
    }

    public UtcTimingElement buildUtcTimingElement(String str, String str2) {
        return new UtcTimingElement(str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0376 A[LOOP:0: B:2:0x0079->B:11:0x0376, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0334 A[EDGE_INSN: B:12:0x0334->B:13:0x0334 BREAK  A[LOOP:0: B:2:0x0079->B:11:0x0376], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AdaptationSet parseAdaptationSet(XmlPullParser xmlPullParser, List<BaseUrl> list, @Nullable SegmentBase segmentBase, long j, long j2, long j3, long j4, long j5, boolean z) {
        Object obj;
        Object obj2;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList<DrmInitData.SchemeData> arrayList6;
        String str;
        String str2;
        long j6;
        long j7;
        DashManifestParser dashManifestParser;
        int i;
        XmlPullParser xmlPullParser2;
        ArrayList arrayList7;
        ArrayList<Descriptor> arrayList8;
        long j8;
        int i2;
        List<BaseUrl> list2;
        List<BaseUrl> list3;
        long j9;
        ArrayList<Descriptor> arrayList9;
        DashManifestParser dashManifestParser2 = this;
        XmlPullParser xmlPullParser3 = xmlPullParser;
        int parseInt = parseInt(xmlPullParser3, "id", -1);
        int parseContentType = parseContentType(xmlPullParser);
        String attributeValue = xmlPullParser3.getAttributeValue(null, "mimeType");
        String attributeValue2 = xmlPullParser3.getAttributeValue(null, "codecs");
        int parseInt2 = parseInt(xmlPullParser3, "width", -1);
        int parseInt3 = parseInt(xmlPullParser3, "height", -1);
        float parseFrameRate = parseFrameRate(xmlPullParser3, -1.0f);
        int parseInt4 = parseInt(xmlPullParser3, "audioSamplingRate", -1);
        String str3 = "lang";
        String attributeValue3 = xmlPullParser3.getAttributeValue(null, "lang");
        String attributeValue4 = xmlPullParser3.getAttributeValue(null, "label");
        ArrayList<DrmInitData.SchemeData> arrayList10 = new ArrayList<>();
        ArrayList<Descriptor> arrayList11 = new ArrayList<>();
        ArrayList arrayList12 = new ArrayList();
        ArrayList arrayList13 = new ArrayList();
        ArrayList arrayList14 = new ArrayList();
        ArrayList arrayList15 = new ArrayList();
        ArrayList arrayList16 = new ArrayList();
        ArrayList arrayList17 = new ArrayList();
        SegmentBase segmentBase2 = segmentBase;
        String str4 = attributeValue4;
        String str5 = null;
        int i3 = -1;
        boolean z2 = false;
        String str6 = attributeValue3;
        long j10 = j2;
        long j11 = j3;
        while (true) {
            xmlPullParser.next();
            boolean z3 = true;
            if (XmlPullParserUtil.isStartTag(xmlPullParser3, "BaseURL")) {
                if (!z2) {
                    list3 = list;
                    j9 = dashManifestParser2.parseAvailabilityTimeOffsetUs(xmlPullParser3, j10);
                    arrayList9 = arrayList11;
                    z2 = true;
                } else {
                    list3 = list;
                    j9 = j10;
                    arrayList9 = arrayList11;
                }
                arrayList17.addAll(dashManifestParser2.parseBaseUrl(xmlPullParser3, list3, z));
                j8 = j11;
                j10 = j9;
                arrayList = arrayList17;
                arrayList7 = arrayList16;
                arrayList2 = arrayList15;
                arrayList3 = arrayList14;
                arrayList4 = arrayList13;
                arrayList5 = arrayList12;
                arrayList6 = arrayList10;
                str = str3;
                arrayList8 = arrayList9;
            } else {
                long j12 = j10;
                ArrayList<Descriptor> arrayList18 = arrayList11;
                if (XmlPullParserUtil.isStartTag(xmlPullParser3, "ContentProtection")) {
                    Pair<String, DrmInitData.SchemeData> parseContentProtection = parseContentProtection(xmlPullParser);
                    Object obj3 = parseContentProtection.first;
                    if (obj3 != null) {
                        str5 = (String) obj3;
                    }
                    Object obj4 = parseContentProtection.second;
                    if (obj4 != null) {
                        arrayList10.add((DrmInitData.SchemeData) obj4);
                    }
                    j8 = j11;
                    arrayList = arrayList17;
                    arrayList7 = arrayList16;
                    arrayList2 = arrayList15;
                    arrayList3 = arrayList14;
                    arrayList4 = arrayList13;
                    arrayList5 = arrayList12;
                    arrayList6 = arrayList10;
                    str = str3;
                    arrayList8 = arrayList18;
                    j10 = j12;
                } else {
                    if (XmlPullParserUtil.isStartTag(xmlPullParser3, "ContentComponent")) {
                        obj = null;
                        String attributeValue5 = xmlPullParser3.getAttributeValue(null, str3);
                        if (str6 == null) {
                            str6 = attributeValue5;
                        } else if (attributeValue5 != null) {
                            Assertions.checkState(str6.equals(attributeValue5));
                        }
                        int parseContentType2 = parseContentType(xmlPullParser);
                        if (parseContentType == -1) {
                            parseContentType = parseContentType2;
                        } else if (parseContentType2 != -1) {
                            if (parseContentType != parseContentType2) {
                                z3 = false;
                            }
                            Assertions.checkState(z3);
                        }
                        j8 = j11;
                    } else {
                        obj = null;
                        if (XmlPullParserUtil.isStartTag(xmlPullParser3, "Role")) {
                            arrayList13.add(parseDescriptor(xmlPullParser3, "Role"));
                        } else if (XmlPullParserUtil.isStartTag(xmlPullParser3, "AudioChannelConfiguration")) {
                            j8 = j11;
                            i3 = parseAudioChannelConfiguration(xmlPullParser);
                        } else if (XmlPullParserUtil.isStartTag(xmlPullParser3, "Accessibility")) {
                            arrayList12.add(parseDescriptor(xmlPullParser3, "Accessibility"));
                        } else if (XmlPullParserUtil.isStartTag(xmlPullParser3, "EssentialProperty")) {
                            arrayList14.add(parseDescriptor(xmlPullParser3, "EssentialProperty"));
                        } else if (XmlPullParserUtil.isStartTag(xmlPullParser3, "SupplementalProperty")) {
                            arrayList15.add(parseDescriptor(xmlPullParser3, "SupplementalProperty"));
                        } else {
                            if (XmlPullParserUtil.isStartTag(xmlPullParser3, "Representation")) {
                                if (!arrayList17.isEmpty()) {
                                    i2 = parseContentType;
                                    list2 = arrayList17;
                                } else {
                                    i2 = parseContentType;
                                    list2 = list;
                                }
                                int i4 = i2;
                                arrayList = arrayList17;
                                ArrayList arrayList19 = arrayList16;
                                arrayList2 = arrayList15;
                                arrayList3 = arrayList14;
                                arrayList4 = arrayList13;
                                arrayList5 = arrayList12;
                                arrayList6 = arrayList10;
                                str = str3;
                                obj2 = null;
                                String str7 = str6;
                                RepresentationInfo parseRepresentation = parseRepresentation(xmlPullParser, list2, attributeValue, attributeValue2, parseInt2, parseInt3, parseFrameRate, i3, parseInt4, str6, arrayList4, arrayList5, arrayList3, arrayList2, segmentBase2, j4, j, j12, j11, j5, z);
                                int trackType = MimeTypes.getTrackType(parseRepresentation.format.sampleMimeType);
                                int i5 = i4;
                                if (i5 == -1) {
                                    i5 = trackType;
                                } else if (trackType != -1) {
                                    if (i5 != trackType) {
                                        z3 = false;
                                    }
                                    Assertions.checkState(z3);
                                }
                                arrayList19.add(parseRepresentation);
                                dashManifestParser = this;
                                j8 = j11;
                                arrayList7 = arrayList19;
                                parseContentType = i5;
                                j10 = j12;
                                arrayList8 = arrayList18;
                                str6 = str7;
                                xmlPullParser2 = xmlPullParser;
                            } else {
                                obj2 = null;
                                arrayList = arrayList17;
                                arrayList2 = arrayList15;
                                arrayList3 = arrayList14;
                                arrayList4 = arrayList13;
                                arrayList5 = arrayList12;
                                arrayList6 = arrayList10;
                                str = str3;
                                str2 = str6;
                                j6 = j12;
                                int i6 = parseContentType;
                                ArrayList arrayList20 = arrayList16;
                                if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentBase")) {
                                    j8 = j11;
                                    segmentBase2 = parseSegmentBase(xmlPullParser, (SegmentBase.SingleSegmentBase) segmentBase2);
                                    dashManifestParser = this;
                                    arrayList7 = arrayList20;
                                    parseContentType = i6;
                                    j10 = j6;
                                    arrayList8 = arrayList18;
                                    str6 = str2;
                                    xmlPullParser2 = xmlPullParser;
                                } else {
                                    if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentList")) {
                                        j8 = parseAvailabilityTimeOffsetUs(xmlPullParser, j11);
                                        dashManifestParser = this;
                                        i = i6;
                                        xmlPullParser2 = xmlPullParser;
                                        segmentBase2 = parseSegmentList(xmlPullParser, (SegmentBase.SegmentList) segmentBase2, j4, j, j6, j8, j5);
                                        arrayList7 = arrayList20;
                                    } else {
                                        j7 = j11;
                                        dashManifestParser = this;
                                        i = i6;
                                        xmlPullParser2 = xmlPullParser;
                                        if (XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentTemplate")) {
                                            j8 = dashManifestParser.parseAvailabilityTimeOffsetUs(xmlPullParser2, j7);
                                            arrayList7 = arrayList20;
                                            segmentBase2 = parseSegmentTemplate(xmlPullParser, (SegmentBase.SegmentTemplate) segmentBase2, arrayList2, j4, j, j6, j8, j5);
                                        } else {
                                            arrayList7 = arrayList20;
                                            if (XmlPullParserUtil.isStartTag(xmlPullParser2, "InbandEventStream")) {
                                                arrayList8 = arrayList18;
                                                arrayList8.add(parseDescriptor(xmlPullParser2, "InbandEventStream"));
                                            } else {
                                                arrayList8 = arrayList18;
                                                if (XmlPullParserUtil.isStartTag(xmlPullParser2, "Label")) {
                                                    j8 = j7;
                                                    str4 = parseLabel(xmlPullParser);
                                                    j10 = j6;
                                                    parseContentType = i;
                                                    str6 = str2;
                                                } else if (XmlPullParserUtil.isStartTag(xmlPullParser)) {
                                                    parseAdaptationSetChild(xmlPullParser);
                                                }
                                            }
                                            j8 = j7;
                                            j10 = j6;
                                            parseContentType = i;
                                            str6 = str2;
                                        }
                                    }
                                    j10 = j6;
                                    parseContentType = i;
                                    arrayList8 = arrayList18;
                                    str6 = str2;
                                }
                            }
                            if (!XmlPullParserUtil.isEndTag(xmlPullParser2, "AdaptationSet")) {
                                break;
                            }
                            arrayList11 = arrayList8;
                            j11 = j8;
                            arrayList17 = arrayList;
                            arrayList16 = arrayList7;
                            arrayList15 = arrayList2;
                            arrayList14 = arrayList3;
                            arrayList13 = arrayList4;
                            arrayList12 = arrayList5;
                            arrayList10 = arrayList6;
                            str3 = str;
                            XmlPullParser xmlPullParser4 = xmlPullParser2;
                            dashManifestParser2 = dashManifestParser;
                            xmlPullParser3 = xmlPullParser4;
                        }
                        i = parseContentType;
                        obj2 = null;
                        arrayList = arrayList17;
                        arrayList7 = arrayList16;
                        arrayList2 = arrayList15;
                        arrayList3 = arrayList14;
                        arrayList4 = arrayList13;
                        arrayList5 = arrayList12;
                        arrayList6 = arrayList10;
                        str = str3;
                        str2 = str6;
                        xmlPullParser2 = xmlPullParser3;
                        arrayList8 = arrayList18;
                        j6 = j12;
                        dashManifestParser = this;
                        j7 = j11;
                        j8 = j7;
                        j10 = j6;
                        parseContentType = i;
                        str6 = str2;
                        if (!XmlPullParserUtil.isEndTag(xmlPullParser2, "AdaptationSet")) {
                        }
                    }
                    obj2 = obj;
                    arrayList = arrayList17;
                    arrayList7 = arrayList16;
                    arrayList2 = arrayList15;
                    arrayList3 = arrayList14;
                    arrayList4 = arrayList13;
                    arrayList5 = arrayList12;
                    arrayList6 = arrayList10;
                    str = str3;
                    xmlPullParser2 = xmlPullParser3;
                    arrayList8 = arrayList18;
                    j10 = j12;
                    dashManifestParser = this;
                    if (!XmlPullParserUtil.isEndTag(xmlPullParser2, "AdaptationSet")) {
                    }
                }
            }
            obj2 = null;
            DashManifestParser dashManifestParser3 = dashManifestParser2;
            xmlPullParser2 = xmlPullParser3;
            dashManifestParser = dashManifestParser3;
            if (!XmlPullParserUtil.isEndTag(xmlPullParser2, "AdaptationSet")) {
            }
        }
        ArrayList arrayList21 = new ArrayList(arrayList7.size());
        for (int i7 = 0; i7 < arrayList7.size(); i7++) {
            arrayList21.add(buildRepresentation((RepresentationInfo) arrayList7.get(i7), str4, str5, arrayList6, arrayList8));
        }
        return buildAdaptationSet(parseInt, parseContentType, arrayList21, arrayList5, arrayList3, arrayList2);
    }

    public void parseAdaptationSetChild(XmlPullParser xmlPullParser) {
        maybeSkipTag(xmlPullParser);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public int parseAudioChannelConfiguration(XmlPullParser xmlPullParser) {
        char c;
        String parseString = parseString(xmlPullParser, "schemeIdUri", null);
        parseString.getClass();
        int i = -1;
        switch (parseString.hashCode()) {
            case -2128649360:
                if (parseString.equals("urn:dts:dash:audio_channel_configuration:2012")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1352850286:
                if (parseString.equals("urn:mpeg:dash:23003:3:audio_channel_configuration:2011")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1138141449:
                if (parseString.equals("tag:dolby.com,2014:dash:audio_channel_configuration:2011")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -986633423:
                if (parseString.equals("urn:mpeg:mpegB:cicp:ChannelConfiguration")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -79006963:
                if (parseString.equals("tag:dts.com,2014:dash:audio_channel_configuration:2012")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 312179081:
                if (parseString.equals("tag:dts.com,2018:uhd:audio_channel_configuration")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 2036691300:
                if (parseString.equals("urn:dolby:dash:audio_channel_configuration:2011")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
            case 4:
                i = parseDtsChannelConfiguration(xmlPullParser);
                break;
            case 1:
                i = parseInt(xmlPullParser, "value", -1);
                break;
            case 2:
            case 6:
                i = parseDolbyChannelConfiguration(xmlPullParser);
                break;
            case 3:
                i = parseMpegChannelConfiguration(xmlPullParser);
                break;
            case 5:
                i = parseDtsxChannelConfiguration(xmlPullParser);
                break;
        }
        do {
            xmlPullParser.next();
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "AudioChannelConfiguration"));
        return i;
    }

    public long parseAvailabilityTimeOffsetUs(XmlPullParser xmlPullParser, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "availabilityTimeOffset");
        if (attributeValue == null) {
            return j;
        }
        if ("INF".equals(attributeValue)) {
            return Long.MAX_VALUE;
        }
        return Float.parseFloat(attributeValue) * 1000000.0f;
    }

    public List<BaseUrl> parseBaseUrl(XmlPullParser xmlPullParser, List<BaseUrl> list, boolean z) {
        int i;
        int i2;
        String str;
        String attributeValue = xmlPullParser.getAttributeValue(null, "dvb:priority");
        if (attributeValue != null) {
            i = Integer.parseInt(attributeValue);
        } else if (z) {
            i = 1;
        } else {
            i = Integer.MIN_VALUE;
        }
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "dvb:weight");
        if (attributeValue2 != null) {
            i2 = Integer.parseInt(attributeValue2);
        } else {
            i2 = 1;
        }
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "serviceLocation");
        String parseText = parseText(xmlPullParser, "BaseURL");
        if (UriUtil.isAbsolute(parseText)) {
            if (attributeValue3 == null) {
                attributeValue3 = parseText;
            }
            return Lists.newArrayList(new BaseUrl(parseText, attributeValue3, i, i2));
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            BaseUrl baseUrl = list.get(i3);
            String resolve = UriUtil.resolve(baseUrl.url, parseText);
            if (attributeValue3 == null) {
                str = resolve;
            } else {
                str = attributeValue3;
            }
            if (z) {
                i = baseUrl.priority;
                i2 = baseUrl.weight;
                str = baseUrl.serviceLocation;
            }
            arrayList.add(new BaseUrl(resolve, str, i, i2));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bc  */
    /* JADX WARN: Type inference failed for: r4v10, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Pair<String, DrmInitData.SchemeData> parseContentProtection(XmlPullParser xmlPullParser) {
        UUID uuid;
        String str;
        String str2;
        String str3;
        ?? r4;
        DrmInitData.SchemeData schemeData = null;
        String attributeValue = xmlPullParser.getAttributeValue(null, "schemeIdUri");
        if (attributeValue != null) {
            String lowerCase = Ascii.toLowerCase(attributeValue);
            lowerCase.getClass();
            char c = 65535;
            switch (lowerCase.hashCode()) {
                case -1980789791:
                    if (lowerCase.equals("urn:uuid:e2719d58-a985-b3c9-781a-b030af78d30e")) {
                        c = 0;
                        break;
                    }
                    break;
                case 489446379:
                    if (lowerCase.equals("urn:uuid:9a04f079-9840-4286-ab92-e65be0885f95")) {
                        c = 1;
                        break;
                    }
                    break;
                case 755418770:
                    if (lowerCase.equals("urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1812765994:
                    if (lowerCase.equals("urn:mpeg:dash:mp4protection:2011")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    uuid = C0643C.CLEARKEY_UUID;
                    str = null;
                    str2 = str;
                    str3 = str2;
                    r4 = str2;
                    break;
                case 1:
                    uuid = C0643C.PLAYREADY_UUID;
                    str = null;
                    str2 = str;
                    str3 = str2;
                    r4 = str2;
                    break;
                case 2:
                    uuid = C0643C.WIDEVINE_UUID;
                    str = null;
                    str2 = str;
                    str3 = str2;
                    r4 = str2;
                    break;
                case 3:
                    str = xmlPullParser.getAttributeValue(null, "value");
                    String attributeValueIgnorePrefix = XmlPullParserUtil.getAttributeValueIgnorePrefix(xmlPullParser, "default_KID");
                    if (!TextUtils.isEmpty(attributeValueIgnorePrefix) && !"00000000-0000-0000-0000-000000000000".equals(attributeValueIgnorePrefix)) {
                        String[] split = attributeValueIgnorePrefix.split("\\s+");
                        UUID[] uuidArr = new UUID[split.length];
                        for (int i = 0; i < split.length; i++) {
                            uuidArr[i] = UUID.fromString(split[i]);
                        }
                        uuid = C0643C.COMMON_PSSH_UUID;
                        byte[] buildPsshAtom = PsshAtomUtil.buildPsshAtom(uuid, uuidArr, null);
                        str3 = null;
                        r4 = buildPsshAtom;
                        break;
                    } else {
                        uuid = null;
                        str2 = null;
                        str3 = str2;
                        r4 = str2;
                        break;
                    }
                    break;
            }
            do {
                xmlPullParser.next();
                if (!XmlPullParserUtil.isStartTag(xmlPullParser, "clearkey:Laurl") && xmlPullParser.next() == 4) {
                    str3 = xmlPullParser.getText();
                    r4 = r4;
                } else if (!XmlPullParserUtil.isStartTag(xmlPullParser, "ms:laurl")) {
                    str3 = xmlPullParser.getAttributeValue(null, "licenseUrl");
                    r4 = r4;
                } else if (r4 == 0 && XmlPullParserUtil.isStartTagIgnorePrefix(xmlPullParser, "pssh") && xmlPullParser.next() == 4) {
                    byte[] decode = Base64.decode(xmlPullParser.getText(), 0);
                    UUID parseUuid = PsshAtomUtil.parseUuid(decode);
                    if (parseUuid == null) {
                        Log.m3027w("MpdParser", "Skipping malformed cenc:pssh data");
                        uuid = parseUuid;
                        r4 = 0;
                    } else {
                        r4 = decode;
                        uuid = parseUuid;
                    }
                } else {
                    if (r4 == 0) {
                        UUID uuid2 = C0643C.PLAYREADY_UUID;
                        if (uuid2.equals(uuid) && XmlPullParserUtil.isStartTag(xmlPullParser, "mspr:pro") && xmlPullParser.next() == 4) {
                            r4 = PsshAtomUtil.buildPsshAtom(uuid2, Base64.decode(xmlPullParser.getText(), 0));
                        }
                    }
                    maybeSkipTag(xmlPullParser);
                    r4 = r4;
                }
            } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "ContentProtection"));
            if (uuid != null) {
                schemeData = new DrmInitData.SchemeData(uuid, str3, MimeTypes.VIDEO_MP4, r4);
            }
            return Pair.create(str, schemeData);
        }
        uuid = null;
        str = null;
        str2 = str;
        str3 = str2;
        r4 = str2;
        do {
            xmlPullParser.next();
            if (!XmlPullParserUtil.isStartTag(xmlPullParser, "clearkey:Laurl")) {
            }
            if (!XmlPullParserUtil.isStartTag(xmlPullParser, "ms:laurl")) {
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "ContentProtection"));
        if (uuid != null) {
        }
        return Pair.create(str, schemeData);
    }

    public int parseContentType(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "contentType");
        if (TextUtils.isEmpty(attributeValue)) {
            return -1;
        }
        if (MimeTypes.BASE_TYPE_AUDIO.equals(attributeValue)) {
            return 1;
        }
        if (MimeTypes.BASE_TYPE_VIDEO.equals(attributeValue)) {
            return 2;
        }
        if (!MimeTypes.BASE_TYPE_TEXT.equals(attributeValue)) {
            return -1;
        }
        return 3;
    }

    public Pair<Long, EventMessage> parseEvent(XmlPullParser xmlPullParser, String str, String str2, long j, ByteArrayOutputStream byteArrayOutputStream) {
        long parseLong = parseLong(xmlPullParser, "id", 0L);
        long parseLong2 = parseLong(xmlPullParser, TypedValues.TransitionType.S_DURATION, C0643C.TIME_UNSET);
        long parseLong3 = parseLong(xmlPullParser, "presentationTime", 0L);
        long scaleLargeTimestamp = Util.scaleLargeTimestamp(parseLong2, 1000L, j);
        long scaleLargeTimestamp2 = Util.scaleLargeTimestamp(parseLong3, 1000000L, j);
        String parseString = parseString(xmlPullParser, "messageData", null);
        byte[] parseEventObject = parseEventObject(xmlPullParser, byteArrayOutputStream);
        Long valueOf = Long.valueOf(scaleLargeTimestamp2);
        if (parseString != null) {
            parseEventObject = Util.getUtf8Bytes(parseString);
        }
        return Pair.create(valueOf, buildEvent(str, str2, parseLong, scaleLargeTimestamp, parseEventObject));
    }

    public byte[] parseEventObject(XmlPullParser xmlPullParser, ByteArrayOutputStream byteArrayOutputStream) {
        byteArrayOutputStream.reset();
        XmlSerializer newSerializer = Xml.newSerializer();
        newSerializer.setOutput(byteArrayOutputStream, Charsets.UTF_8.name());
        xmlPullParser.nextToken();
        while (!XmlPullParserUtil.isEndTag(xmlPullParser, "Event")) {
            switch (xmlPullParser.getEventType()) {
                case 0:
                    newSerializer.startDocument(null, Boolean.FALSE);
                    break;
                case 1:
                    newSerializer.endDocument();
                    break;
                case 2:
                    newSerializer.startTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
                        newSerializer.attribute(xmlPullParser.getAttributeNamespace(i), xmlPullParser.getAttributeName(i), xmlPullParser.getAttributeValue(i));
                    }
                    break;
                case 3:
                    newSerializer.endTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    break;
                case 4:
                    newSerializer.text(xmlPullParser.getText());
                    break;
                case 5:
                    newSerializer.cdsect(xmlPullParser.getText());
                    break;
                case 6:
                    newSerializer.entityRef(xmlPullParser.getText());
                    break;
                case 7:
                    newSerializer.ignorableWhitespace(xmlPullParser.getText());
                    break;
                case 8:
                    newSerializer.processingInstruction(xmlPullParser.getText());
                    break;
                case 9:
                    newSerializer.comment(xmlPullParser.getText());
                    break;
                case 10:
                    newSerializer.docdecl(xmlPullParser.getText());
                    break;
            }
            xmlPullParser.nextToken();
        }
        newSerializer.flush();
        return byteArrayOutputStream.toByteArray();
    }

    public EventStream parseEventStream(XmlPullParser xmlPullParser) {
        String parseString = parseString(xmlPullParser, "schemeIdUri", "");
        String parseString2 = parseString(xmlPullParser, "value", "");
        long parseLong = parseLong(xmlPullParser, "timescale", 1L);
        ArrayList arrayList = new ArrayList();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "Event")) {
                arrayList.add(parseEvent(xmlPullParser, parseString, parseString2, parseLong, byteArrayOutputStream));
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "EventStream"));
        long[] jArr = new long[arrayList.size()];
        EventMessage[] eventMessageArr = new EventMessage[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            Pair pair = (Pair) arrayList.get(i);
            jArr[i] = ((Long) pair.first).longValue();
            eventMessageArr[i] = (EventMessage) pair.second;
        }
        return buildEventStream(parseString, parseString2, parseLong, jArr, eventMessageArr);
    }

    public RangedUri parseInitialization(XmlPullParser xmlPullParser) {
        return parseRangedUrl(xmlPullParser, "sourceURL", "range");
    }

    public String parseLabel(XmlPullParser xmlPullParser) {
        return parseText(xmlPullParser, "Label");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x01e8 A[LOOP:1: B:25:0x00af->B:33:0x01e8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01a3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DashManifest parseMediaPresentationDescription(XmlPullParser xmlPullParser, Uri uri) {
        boolean z;
        long j;
        long j2;
        long j3;
        long j4;
        int i;
        long j5;
        ArrayList arrayList;
        ArrayList arrayList2;
        long j6;
        Throwable th;
        ArrayList arrayList3;
        ArrayList arrayList4;
        long j7;
        long j8;
        DashManifestParser dashManifestParser = this;
        boolean z2 = true;
        String[] parseProfiles = dashManifestParser.parseProfiles(xmlPullParser, "profiles", new String[0]);
        int length = parseProfiles.length;
        int i2 = 0;
        while (true) {
            if (i2 < length) {
                if (parseProfiles[i2].startsWith("urn:dvb:dash:profile:dvb-dash:")) {
                    z = true;
                    break;
                }
                i2++;
            } else {
                z = false;
                break;
            }
        }
        long j9 = C0643C.TIME_UNSET;
        long parseDateTime = parseDateTime(xmlPullParser, "availabilityStartTime", C0643C.TIME_UNSET);
        long parseDuration = parseDuration(xmlPullParser, "mediaPresentationDuration", C0643C.TIME_UNSET);
        long parseDuration2 = parseDuration(xmlPullParser, "minBufferTime", C0643C.TIME_UNSET);
        Throwable th2 = null;
        boolean equals = "dynamic".equals(xmlPullParser.getAttributeValue(null, "type"));
        if (equals) {
            j = parseDuration(xmlPullParser, "minimumUpdatePeriod", C0643C.TIME_UNSET);
        } else {
            j = -9223372036854775807L;
        }
        if (equals) {
            j2 = parseDuration(xmlPullParser, "timeShiftBufferDepth", C0643C.TIME_UNSET);
        } else {
            j2 = -9223372036854775807L;
        }
        if (equals) {
            j3 = parseDuration(xmlPullParser, "suggestedPresentationDelay", C0643C.TIME_UNSET);
        } else {
            j3 = -9223372036854775807L;
        }
        long parseDateTime2 = parseDateTime(xmlPullParser, "publishTime", C0643C.TIME_UNSET);
        long j10 = 0;
        if (equals) {
            j4 = 0;
        } else {
            j4 = -9223372036854775807L;
        }
        String uri2 = uri.toString();
        String uri3 = uri.toString();
        if (z) {
            i = 1;
        } else {
            i = Integer.MIN_VALUE;
        }
        ArrayList newArrayList = Lists.newArrayList(new BaseUrl(uri2, uri3, i, 1));
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        if (equals) {
            j10 = -9223372036854775807L;
        }
        boolean z3 = false;
        boolean z4 = false;
        long j11 = j10;
        ProgramInformation programInformation = null;
        UtcTimingElement utcTimingElement = null;
        Uri uri4 = null;
        ServiceDescriptionElement serviceDescriptionElement = null;
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "BaseURL")) {
                if (!z3) {
                    j4 = dashManifestParser.parseAvailabilityTimeOffsetUs(xmlPullParser, j4);
                    z3 = z2;
                }
                arrayList6.addAll(dashManifestParser.parseBaseUrl(xmlPullParser, newArrayList, z));
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "ProgramInformation")) {
                programInformation = parseProgramInformation(xmlPullParser);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "UTCTiming")) {
                utcTimingElement = parseUtcTiming(xmlPullParser);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "Location")) {
                uri4 = UriUtil.resolveToUri(uri.toString(), xmlPullParser.nextText());
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "ServiceDescription")) {
                serviceDescriptionElement = parseServiceDescription(xmlPullParser);
            } else {
                if (XmlPullParserUtil.isStartTag(xmlPullParser, "Period") && !z4) {
                    if (!arrayList6.isEmpty()) {
                        arrayList4 = arrayList6;
                    } else {
                        arrayList4 = newArrayList;
                    }
                    j5 = j4;
                    arrayList = arrayList6;
                    arrayList2 = newArrayList;
                    ArrayList arrayList7 = arrayList5;
                    j6 = j9;
                    th = th2;
                    Pair<Period, Long> parsePeriod = parsePeriod(xmlPullParser, arrayList4, j11, j5, parseDateTime, j2, z);
                    Period period = (Period) parsePeriod.first;
                    if (period.startMs == j6) {
                        if (equals) {
                            arrayList3 = arrayList7;
                            z4 = true;
                        } else {
                            throw ParserException.createForMalformedManifest("Unable to determine start of period " + arrayList7.size(), th);
                        }
                    } else {
                        long longValue = ((Long) parsePeriod.second).longValue();
                        if (longValue == j6) {
                            arrayList3 = arrayList7;
                            j7 = j6;
                        } else {
                            j7 = period.startMs + longValue;
                            arrayList3 = arrayList7;
                        }
                        arrayList3.add(period);
                        j11 = j7;
                    }
                } else {
                    j5 = j4;
                    arrayList = arrayList6;
                    arrayList2 = newArrayList;
                    j6 = j9;
                    th = th2;
                    arrayList3 = arrayList5;
                    maybeSkipTag(xmlPullParser);
                }
                j4 = j5;
                if (!XmlPullParserUtil.isEndTag(xmlPullParser, "MPD")) {
                    if (parseDuration == j6) {
                        if (j11 != j6) {
                            j8 = j11;
                            if (arrayList3.isEmpty()) {
                                return buildMediaPresentationDescription(parseDateTime, j8, parseDuration2, equals, j, j2, j3, parseDateTime2, programInformation, utcTimingElement, serviceDescriptionElement, uri4, arrayList3);
                            }
                            throw ParserException.createForMalformedManifest("No periods found.", th);
                        }
                        if (!equals) {
                            throw ParserException.createForMalformedManifest("Unable to determine duration of static manifest.", th);
                        }
                    }
                    j8 = parseDuration;
                    if (arrayList3.isEmpty()) {
                    }
                } else {
                    dashManifestParser = this;
                    arrayList5 = arrayList3;
                    th2 = th;
                    arrayList6 = arrayList;
                    newArrayList = arrayList2;
                    j9 = j6;
                    z2 = true;
                }
            }
            arrayList = arrayList6;
            arrayList2 = newArrayList;
            j6 = j9;
            th = th2;
            arrayList3 = arrayList5;
            if (!XmlPullParserUtil.isEndTag(xmlPullParser, "MPD")) {
            }
        }
    }

    public Pair<Period, Long> parsePeriod(XmlPullParser xmlPullParser, List<BaseUrl> list, long j, long j2, long j3, long j4, boolean z) {
        long j5;
        long j6;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        Object obj;
        long j7;
        SegmentBase parseSegmentTemplate;
        List<BaseUrl> list2;
        DashManifestParser dashManifestParser = this;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        Object obj2 = null;
        String attributeValue = xmlPullParser2.getAttributeValue(null, "id");
        long parseDuration = parseDuration(xmlPullParser2, "start", j);
        long j8 = C0643C.TIME_UNSET;
        if (j3 != C0643C.TIME_UNSET) {
            j5 = j3 + parseDuration;
        } else {
            j5 = -9223372036854775807L;
        }
        long parseDuration2 = parseDuration(xmlPullParser2, TypedValues.TransitionType.S_DURATION, C0643C.TIME_UNSET);
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        long j9 = j2;
        boolean z2 = false;
        long j10 = -9223372036854775807L;
        SegmentBase segmentBase = null;
        Descriptor descriptor = null;
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser2, "BaseURL")) {
                if (!z2) {
                    j9 = dashManifestParser.parseAvailabilityTimeOffsetUs(xmlPullParser2, j9);
                    z2 = true;
                }
                arrayList6.addAll(dashManifestParser.parseBaseUrl(xmlPullParser2, list, z));
                arrayList3 = arrayList5;
                arrayList = arrayList6;
                j7 = j8;
                obj = obj2;
                arrayList2 = arrayList4;
            } else {
                if (XmlPullParserUtil.isStartTag(xmlPullParser2, "AdaptationSet")) {
                    if (!arrayList6.isEmpty()) {
                        list2 = arrayList6;
                    } else {
                        list2 = list;
                    }
                    j6 = j9;
                    arrayList = arrayList6;
                    arrayList2 = arrayList4;
                    arrayList2.add(parseAdaptationSet(xmlPullParser, list2, segmentBase, parseDuration2, j9, j10, j5, j4, z));
                    xmlPullParser2 = xmlPullParser;
                    arrayList3 = arrayList5;
                } else {
                    j6 = j9;
                    ArrayList arrayList7 = arrayList5;
                    arrayList = arrayList6;
                    arrayList2 = arrayList4;
                    xmlPullParser2 = xmlPullParser;
                    if (XmlPullParserUtil.isStartTag(xmlPullParser2, "EventStream")) {
                        arrayList7.add(parseEventStream(xmlPullParser));
                        arrayList3 = arrayList7;
                    } else if (XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentBase")) {
                        arrayList3 = arrayList7;
                        segmentBase = parseSegmentBase(xmlPullParser2, null);
                        obj = null;
                        j9 = j6;
                        j7 = C0643C.TIME_UNSET;
                    } else {
                        arrayList3 = arrayList7;
                        if (XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentList")) {
                            long parseAvailabilityTimeOffsetUs = parseAvailabilityTimeOffsetUs(xmlPullParser2, C0643C.TIME_UNSET);
                            obj = null;
                            parseSegmentTemplate = parseSegmentList(xmlPullParser, null, j5, parseDuration2, j6, parseAvailabilityTimeOffsetUs, j4);
                            j10 = parseAvailabilityTimeOffsetUs;
                            j9 = j6;
                            j7 = C0643C.TIME_UNSET;
                        } else {
                            obj = null;
                            if (XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentTemplate")) {
                                long parseAvailabilityTimeOffsetUs2 = parseAvailabilityTimeOffsetUs(xmlPullParser2, C0643C.TIME_UNSET);
                                j7 = -9223372036854775807L;
                                parseSegmentTemplate = parseSegmentTemplate(xmlPullParser, null, ImmutableList.m3902of(), j5, parseDuration2, j6, parseAvailabilityTimeOffsetUs2, j4);
                                j10 = parseAvailabilityTimeOffsetUs2;
                                j9 = j6;
                            } else {
                                j7 = C0643C.TIME_UNSET;
                                if (XmlPullParserUtil.isStartTag(xmlPullParser2, "AssetIdentifier")) {
                                    descriptor = parseDescriptor(xmlPullParser2, "AssetIdentifier");
                                } else {
                                    maybeSkipTag(xmlPullParser);
                                }
                                j9 = j6;
                            }
                        }
                        segmentBase = parseSegmentTemplate;
                    }
                }
                obj = null;
                j7 = C0643C.TIME_UNSET;
                j9 = j6;
            }
            if (XmlPullParserUtil.isEndTag(xmlPullParser2, "Period")) {
                return Pair.create(buildPeriod(attributeValue, parseDuration, arrayList2, arrayList3, descriptor), Long.valueOf(parseDuration2));
            }
            arrayList4 = arrayList2;
            arrayList6 = arrayList;
            obj2 = obj;
            arrayList5 = arrayList3;
            j8 = j7;
            dashManifestParser = this;
        }
    }

    public String[] parseProfiles(XmlPullParser xmlPullParser, String str, String[] strArr) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue == null) {
            return strArr;
        }
        return attributeValue.split(",");
    }

    public ProgramInformation parseProgramInformation(XmlPullParser xmlPullParser) {
        String str = null;
        String parseString = parseString(xmlPullParser, "moreInformationURL", null);
        String parseString2 = parseString(xmlPullParser, "lang", null);
        String str2 = null;
        String str3 = null;
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "Title")) {
                str = xmlPullParser.nextText();
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "Source")) {
                str2 = xmlPullParser.nextText();
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, ExifInterface.TAG_COPYRIGHT)) {
                str3 = xmlPullParser.nextText();
            } else {
                maybeSkipTag(xmlPullParser);
            }
            String str4 = str3;
            if (XmlPullParserUtil.isEndTag(xmlPullParser, "ProgramInformation")) {
                return new ProgramInformation(str, str2, str4, parseString, parseString2);
            }
            str3 = str4;
        }
    }

    public RangedUri parseRangedUrl(XmlPullParser xmlPullParser, String str, String str2) {
        long j;
        long j2;
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, str2);
        if (attributeValue2 != null) {
            String[] split = attributeValue2.split("-");
            j = Long.parseLong(split[0]);
            if (split.length == 2) {
                j2 = (Long.parseLong(split[1]) - j) + 1;
                return buildRangedUri(attributeValue, j, j2);
            }
        } else {
            j = 0;
        }
        j2 = -1;
        return buildRangedUri(attributeValue, j, j2);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x01ee A[LOOP:0: B:2:0x006a->B:11:0x01ee, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0198 A[EDGE_INSN: B:12:0x0198->B:13:0x0198 BREAK  A[LOOP:0: B:2:0x006a->B:11:0x01ee], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RepresentationInfo parseRepresentation(XmlPullParser xmlPullParser, List<BaseUrl> list, @Nullable String str, @Nullable String str2, int i, int i2, float f, int i3, int i4, @Nullable String str3, List<Descriptor> list2, List<Descriptor> list3, List<Descriptor> list4, List<Descriptor> list5, @Nullable SegmentBase segmentBase, long j, long j2, long j3, long j4, long j5, boolean z) {
        long j6;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        int i5;
        long parseAvailabilityTimeOffsetUs;
        ArrayList arrayList7;
        SegmentBase segmentBase2;
        ArrayList arrayList8;
        ArrayList arrayList9;
        ArrayList arrayList10;
        ArrayList arrayList11;
        DashManifestParser dashManifestParser = this;
        String attributeValue = xmlPullParser.getAttributeValue(null, "id");
        int parseInt = parseInt(xmlPullParser, "bandwidth", -1);
        String parseString = parseString(xmlPullParser, "mimeType", str);
        String parseString2 = parseString(xmlPullParser, "codecs", str2);
        int parseInt2 = parseInt(xmlPullParser, "width", i);
        int parseInt3 = parseInt(xmlPullParser, "height", i2);
        float parseFrameRate = parseFrameRate(xmlPullParser, f);
        int parseInt4 = parseInt(xmlPullParser, "audioSamplingRate", i4);
        ArrayList arrayList12 = new ArrayList();
        ArrayList arrayList13 = new ArrayList();
        ArrayList arrayList14 = new ArrayList(list4);
        ArrayList arrayList15 = new ArrayList(list5);
        ArrayList arrayList16 = new ArrayList();
        int i6 = i3;
        long j7 = j3;
        boolean z2 = false;
        String str4 = null;
        SegmentBase segmentBase3 = segmentBase;
        long j8 = j4;
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "BaseURL")) {
                if (!z2) {
                    j7 = dashManifestParser.parseAvailabilityTimeOffsetUs(xmlPullParser, j7);
                    z2 = true;
                }
                arrayList16.addAll(dashManifestParser.parseBaseUrl(xmlPullParser, list, z));
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "AudioChannelConfiguration")) {
                segmentBase2 = segmentBase3;
                arrayList10 = arrayList16;
                arrayList4 = arrayList12;
                i5 = parseAudioChannelConfiguration(xmlPullParser);
                arrayList5 = arrayList13;
                arrayList6 = arrayList15;
                arrayList11 = arrayList10;
                if (XmlPullParserUtil.isEndTag(xmlPullParser, "Representation")) {
                    break;
                }
                arrayList15 = arrayList6;
                arrayList13 = arrayList5;
                arrayList12 = arrayList4;
                segmentBase3 = segmentBase2;
                dashManifestParser = this;
                i6 = i5;
                arrayList16 = arrayList11;
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentBase")) {
                segmentBase3 = dashManifestParser.parseSegmentBase(xmlPullParser, (SegmentBase.SingleSegmentBase) segmentBase3);
            } else {
                if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentList")) {
                    parseAvailabilityTimeOffsetUs = dashManifestParser.parseAvailabilityTimeOffsetUs(xmlPullParser, j8);
                    j6 = j7;
                    arrayList9 = arrayList16;
                    arrayList = arrayList15;
                    arrayList2 = arrayList13;
                    arrayList3 = arrayList14;
                    segmentBase3 = parseSegmentList(xmlPullParser, (SegmentBase.SegmentList) segmentBase3, j, j2, j6, parseAvailabilityTimeOffsetUs, j5);
                    arrayList4 = arrayList12;
                } else {
                    j6 = j7;
                    ArrayList arrayList17 = arrayList16;
                    arrayList = arrayList15;
                    arrayList2 = arrayList13;
                    arrayList3 = arrayList14;
                    if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentTemplate")) {
                        parseAvailabilityTimeOffsetUs = dashManifestParser.parseAvailabilityTimeOffsetUs(xmlPullParser, j8);
                        arrayList4 = arrayList12;
                        segmentBase3 = parseSegmentTemplate(xmlPullParser, (SegmentBase.SegmentTemplate) segmentBase3, list5, j, j2, j6, parseAvailabilityTimeOffsetUs, j5);
                        arrayList9 = arrayList17;
                    } else {
                        arrayList4 = arrayList12;
                        if (XmlPullParserUtil.isStartTag(xmlPullParser, "ContentProtection")) {
                            Pair<String, DrmInitData.SchemeData> parseContentProtection = parseContentProtection(xmlPullParser);
                            Object obj = parseContentProtection.first;
                            if (obj != null) {
                                str4 = (String) obj;
                            }
                            Object obj2 = parseContentProtection.second;
                            if (obj2 != null) {
                                arrayList4.add((DrmInitData.SchemeData) obj2);
                            }
                            i5 = i6;
                            arrayList8 = arrayList17;
                            j7 = j6;
                            arrayList6 = arrayList;
                            arrayList5 = arrayList2;
                            arrayList14 = arrayList3;
                            arrayList7 = arrayList8;
                            segmentBase2 = segmentBase3;
                            arrayList11 = arrayList7;
                            if (XmlPullParserUtil.isEndTag(xmlPullParser, "Representation")) {
                            }
                        } else {
                            if (XmlPullParserUtil.isStartTag(xmlPullParser, "InbandEventStream")) {
                                arrayList5 = arrayList2;
                                arrayList5.add(parseDescriptor(xmlPullParser, "InbandEventStream"));
                                arrayList6 = arrayList;
                                arrayList14 = arrayList3;
                            } else {
                                arrayList5 = arrayList2;
                                if (XmlPullParserUtil.isStartTag(xmlPullParser, "EssentialProperty")) {
                                    arrayList14 = arrayList3;
                                    arrayList14.add(parseDescriptor(xmlPullParser, "EssentialProperty"));
                                    arrayList6 = arrayList;
                                } else {
                                    arrayList14 = arrayList3;
                                    if (XmlPullParserUtil.isStartTag(xmlPullParser, "SupplementalProperty")) {
                                        arrayList6 = arrayList;
                                        arrayList6.add(parseDescriptor(xmlPullParser, "SupplementalProperty"));
                                    } else {
                                        arrayList6 = arrayList;
                                        maybeSkipTag(xmlPullParser);
                                    }
                                }
                            }
                            i5 = i6;
                            j7 = j6;
                            arrayList7 = arrayList17;
                            segmentBase2 = segmentBase3;
                            arrayList11 = arrayList7;
                            if (XmlPullParserUtil.isEndTag(xmlPullParser, "Representation")) {
                            }
                        }
                    }
                }
                i5 = i6;
                j8 = parseAvailabilityTimeOffsetUs;
                arrayList8 = arrayList9;
                j7 = j6;
                arrayList6 = arrayList;
                arrayList5 = arrayList2;
                arrayList14 = arrayList3;
                arrayList7 = arrayList8;
                segmentBase2 = segmentBase3;
                arrayList11 = arrayList7;
                if (XmlPullParserUtil.isEndTag(xmlPullParser, "Representation")) {
                }
            }
            arrayList10 = arrayList16;
            arrayList4 = arrayList12;
            i5 = i6;
            segmentBase2 = segmentBase3;
            arrayList5 = arrayList13;
            arrayList6 = arrayList15;
            arrayList11 = arrayList10;
            if (XmlPullParserUtil.isEndTag(xmlPullParser, "Representation")) {
            }
        }
        ArrayList arrayList18 = arrayList6;
        ArrayList arrayList19 = arrayList14;
        ArrayList arrayList20 = arrayList5;
        Format buildFormat = buildFormat(attributeValue, parseString, parseInt2, parseInt3, parseFrameRate, i5, parseInt4, parseInt, str3, list2, list3, parseString2, arrayList19, arrayList18);
        if (segmentBase2 == null) {
            segmentBase2 = new SegmentBase.SingleSegmentBase();
        }
        boolean isEmpty = arrayList11.isEmpty();
        List<BaseUrl> list6 = arrayList11;
        if (isEmpty) {
            list6 = list;
        }
        return new RepresentationInfo(buildFormat, list6, segmentBase2, str4, arrayList4, arrayList20, arrayList19, arrayList18, -1L);
    }

    public int parseRoleFlagsFromAccessibilityDescriptors(List<Descriptor> list) {
        int parseTvaAudioPurposeCsValue;
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            Descriptor descriptor = list.get(i2);
            if (Ascii.equalsIgnoreCase("urn:mpeg:dash:role:2011", descriptor.schemeIdUri)) {
                parseTvaAudioPurposeCsValue = parseRoleFlagsFromDashRoleScheme(descriptor.value);
            } else if (Ascii.equalsIgnoreCase("urn:tva:metadata:cs:AudioPurposeCS:2007", descriptor.schemeIdUri)) {
                parseTvaAudioPurposeCsValue = parseTvaAudioPurposeCsValue(descriptor.value);
            }
            i |= parseTvaAudioPurposeCsValue;
        }
        return i;
    }

    public int parseRoleFlagsFromDashRoleScheme(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -2060497896:
                if (str.equals("subtitle")) {
                    c = 0;
                    break;
                }
                break;
            case -1724546052:
                if (str.equals("description")) {
                    c = 1;
                    break;
                }
                break;
            case -1580883024:
                if (str.equals("enhanced-audio-intelligibility")) {
                    c = 2;
                    break;
                }
                break;
            case -1574842690:
                if (str.equals("forced_subtitle")) {
                    c = 3;
                    break;
                }
                break;
            case -1408024454:
                if (str.equals("alternate")) {
                    c = 4;
                    break;
                }
                break;
            case -1396432756:
                if (str.equals("forced-subtitle")) {
                    c = 5;
                    break;
                }
                break;
            case 99825:
                if (str.equals("dub")) {
                    c = 6;
                    break;
                }
                break;
            case 3343801:
                if (str.equals("main")) {
                    c = 7;
                    break;
                }
                break;
            case 3530173:
                if (str.equals("sign")) {
                    c = '\b';
                    break;
                }
                break;
            case 552573414:
                if (str.equals("caption")) {
                    c = '\t';
                    break;
                }
                break;
            case 899152809:
                if (str.equals("commentary")) {
                    c = '\n';
                    break;
                }
                break;
            case 1629013393:
                if (str.equals("emergency")) {
                    c = 11;
                    break;
                }
                break;
            case 1855372047:
                if (str.equals("supplementary")) {
                    c = '\f';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 3:
            case 5:
                return 128;
            case 1:
                return 512;
            case 2:
                return 2048;
            case 4:
                return 2;
            case 6:
                return 16;
            case 7:
                return 1;
            case '\b':
                return 256;
            case '\t':
                return 64;
            case '\n':
                return 8;
            case 11:
                return 32;
            case '\f':
                return 4;
            default:
                return 0;
        }
    }

    public int parseRoleFlagsFromProperties(List<Descriptor> list) {
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (Ascii.equalsIgnoreCase("http://dashif.org/guidelines/trickmode", list.get(i2).schemeIdUri)) {
                i = 16384;
            }
        }
        return i;
    }

    public int parseRoleFlagsFromRoleDescriptors(List<Descriptor> list) {
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            Descriptor descriptor = list.get(i2);
            if (Ascii.equalsIgnoreCase("urn:mpeg:dash:role:2011", descriptor.schemeIdUri)) {
                i |= parseRoleFlagsFromDashRoleScheme(descriptor.value);
            }
        }
        return i;
    }

    public SegmentBase.SingleSegmentBase parseSegmentBase(XmlPullParser xmlPullParser, @Nullable SegmentBase.SingleSegmentBase singleSegmentBase) {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        if (singleSegmentBase != null) {
            j = singleSegmentBase.f11334b;
        } else {
            j = 1;
        }
        long parseLong = parseLong(xmlPullParser, "timescale", j);
        long j6 = 0;
        if (singleSegmentBase != null) {
            j2 = singleSegmentBase.f11335c;
        } else {
            j2 = 0;
        }
        long parseLong2 = parseLong(xmlPullParser, "presentationTimeOffset", j2);
        if (singleSegmentBase != null) {
            j3 = singleSegmentBase.f11348d;
        } else {
            j3 = 0;
        }
        if (singleSegmentBase != null) {
            j6 = singleSegmentBase.f11349e;
        }
        RangedUri rangedUri = null;
        String attributeValue = xmlPullParser.getAttributeValue(null, "indexRange");
        if (attributeValue != null) {
            String[] split = attributeValue.split("-");
            j5 = Long.parseLong(split[0]);
            j4 = (Long.parseLong(split[1]) - j5) + 1;
        } else {
            j4 = j6;
            j5 = j3;
        }
        if (singleSegmentBase != null) {
            rangedUri = singleSegmentBase.f11333a;
        }
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "Initialization")) {
                rangedUri = parseInitialization(xmlPullParser);
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "SegmentBase"));
        return buildSingleSegmentBase(rangedUri, parseLong, parseLong2, j5, j4);
    }

    public SegmentBase.SegmentList parseSegmentList(XmlPullParser xmlPullParser, @Nullable SegmentBase.SegmentList segmentList, long j, long j2, long j3, long j4, long j5) {
        long j6;
        long j7;
        long j8;
        long j9;
        long j10;
        long j11 = 1;
        if (segmentList != null) {
            j6 = segmentList.f11334b;
        } else {
            j6 = 1;
        }
        long parseLong = parseLong(xmlPullParser, "timescale", j6);
        if (segmentList != null) {
            j7 = segmentList.f11335c;
        } else {
            j7 = 0;
        }
        long parseLong2 = parseLong(xmlPullParser, "presentationTimeOffset", j7);
        if (segmentList != null) {
            j8 = segmentList.f11337e;
        } else {
            j8 = -9223372036854775807L;
        }
        long parseLong3 = parseLong(xmlPullParser, TypedValues.TransitionType.S_DURATION, j8);
        if (segmentList != null) {
            j11 = segmentList.f11336d;
        }
        long parseLong4 = parseLong(xmlPullParser, "startNumber", j11);
        if (j4 == C0643C.TIME_UNSET) {
            j9 = j3;
        } else {
            j9 = j4;
        }
        if (j9 == Long.MAX_VALUE) {
            j10 = -9223372036854775807L;
        } else {
            j10 = j9;
        }
        List<SegmentBase.SegmentTimelineElement> list = null;
        List<RangedUri> list2 = null;
        RangedUri rangedUri = null;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "Initialization")) {
                rangedUri = parseInitialization(xmlPullParser);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentTimeline")) {
                list = parseSegmentTimeline(xmlPullParser, parseLong, j2);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentURL")) {
                if (list2 == null) {
                    list2 = new ArrayList<>();
                }
                list2.add(parseSegmentUrl(xmlPullParser));
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "SegmentList"));
        if (segmentList != null) {
            if (rangedUri == null) {
                rangedUri = segmentList.f11333a;
            }
            if (list == null) {
                list = segmentList.f11338f;
            }
            if (list2 == null) {
                list2 = segmentList.f11342j;
            }
        }
        return buildSegmentList(rangedUri, parseLong, parseLong2, parseLong4, parseLong3, list, j10, list2, j5, j);
    }

    public SegmentBase.SegmentTemplate parseSegmentTemplate(XmlPullParser xmlPullParser, @Nullable SegmentBase.SegmentTemplate segmentTemplate, List<Descriptor> list, long j, long j2, long j3, long j4, long j5) {
        long j6;
        long j7;
        long j8;
        long j9;
        long j10;
        UrlTemplate urlTemplate;
        UrlTemplate urlTemplate2;
        long j11 = 1;
        if (segmentTemplate != null) {
            j6 = segmentTemplate.f11334b;
        } else {
            j6 = 1;
        }
        long parseLong = parseLong(xmlPullParser, "timescale", j6);
        if (segmentTemplate != null) {
            j7 = segmentTemplate.f11335c;
        } else {
            j7 = 0;
        }
        long parseLong2 = parseLong(xmlPullParser, "presentationTimeOffset", j7);
        if (segmentTemplate != null) {
            j8 = segmentTemplate.f11337e;
        } else {
            j8 = -9223372036854775807L;
        }
        long parseLong3 = parseLong(xmlPullParser, TypedValues.TransitionType.S_DURATION, j8);
        if (segmentTemplate != null) {
            j11 = segmentTemplate.f11336d;
        }
        long parseLong4 = parseLong(xmlPullParser, "startNumber", j11);
        long parseLastSegmentNumberSupplementalProperty = parseLastSegmentNumberSupplementalProperty(list);
        if (j4 == C0643C.TIME_UNSET) {
            j9 = j3;
        } else {
            j9 = j4;
        }
        if (j9 == Long.MAX_VALUE) {
            j10 = -9223372036854775807L;
        } else {
            j10 = j9;
        }
        List<SegmentBase.SegmentTimelineElement> list2 = null;
        if (segmentTemplate != null) {
            urlTemplate = segmentTemplate.f11344k;
        } else {
            urlTemplate = null;
        }
        UrlTemplate parseUrlTemplate = parseUrlTemplate(xmlPullParser, "media", urlTemplate);
        if (segmentTemplate != null) {
            urlTemplate2 = segmentTemplate.f11343j;
        } else {
            urlTemplate2 = null;
        }
        UrlTemplate parseUrlTemplate2 = parseUrlTemplate(xmlPullParser, "initialization", urlTemplate2);
        RangedUri rangedUri = null;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "Initialization")) {
                rangedUri = parseInitialization(xmlPullParser);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentTimeline")) {
                list2 = parseSegmentTimeline(xmlPullParser, parseLong, j2);
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "SegmentTemplate"));
        if (segmentTemplate != null) {
            if (rangedUri == null) {
                rangedUri = segmentTemplate.f11333a;
            }
            if (list2 == null) {
                list2 = segmentTemplate.f11338f;
            }
        }
        return buildSegmentTemplate(rangedUri, parseLong, parseLong2, parseLong4, parseLastSegmentNumberSupplementalProperty, parseLong3, list2, j10, parseUrlTemplate2, parseUrlTemplate, j5, j);
    }

    public List<SegmentBase.SegmentTimelineElement> parseSegmentTimeline(XmlPullParser xmlPullParser, long j, long j2) {
        ArrayList arrayList = new ArrayList();
        long j3 = 0;
        long j4 = -9223372036854775807L;
        boolean z = false;
        int i = 0;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, ExifInterface.LATITUDE_SOUTH)) {
                long parseLong = parseLong(xmlPullParser, "t", C0643C.TIME_UNSET);
                if (z) {
                    j3 = m2787a(arrayList, j3, j4, i, parseLong);
                }
                if (parseLong == C0643C.TIME_UNSET) {
                    parseLong = j3;
                }
                j4 = parseLong(xmlPullParser, "d", C0643C.TIME_UNSET);
                i = parseInt(xmlPullParser, "r", 0);
                z = true;
                j3 = parseLong;
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "SegmentTimeline"));
        if (z) {
            m2787a(arrayList, j3, j4, i, Util.scaleLargeTimestamp(j2, j, 1000L));
        }
        return arrayList;
    }

    public RangedUri parseSegmentUrl(XmlPullParser xmlPullParser) {
        return parseRangedUrl(xmlPullParser, "media", "mediaRange");
    }

    public int parseSelectionFlagsFromDashRoleScheme(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        if (!str.equals("forced_subtitle") && !str.equals("forced-subtitle")) {
            return 0;
        }
        return 2;
    }

    public int parseSelectionFlagsFromRoleDescriptors(List<Descriptor> list) {
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            Descriptor descriptor = list.get(i2);
            if (Ascii.equalsIgnoreCase("urn:mpeg:dash:role:2011", descriptor.schemeIdUri)) {
                i |= parseSelectionFlagsFromDashRoleScheme(descriptor.value);
            }
        }
        return i;
    }

    public ServiceDescriptionElement parseServiceDescription(XmlPullParser xmlPullParser) {
        long j = -9223372036854775807L;
        long j2 = -9223372036854775807L;
        long j3 = -9223372036854775807L;
        float f = -3.4028235E38f;
        float f2 = -3.4028235E38f;
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "Latency")) {
                j = parseLong(xmlPullParser, TypedValues.AttributesType.S_TARGET, C0643C.TIME_UNSET);
                j2 = parseLong(xmlPullParser, "min", C0643C.TIME_UNSET);
                j3 = parseLong(xmlPullParser, "max", C0643C.TIME_UNSET);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "PlaybackRate")) {
                f = parseFloat(xmlPullParser, "min", -3.4028235E38f);
                f2 = parseFloat(xmlPullParser, "max", -3.4028235E38f);
            }
            long j4 = j;
            long j5 = j2;
            long j6 = j3;
            float f3 = f;
            float f4 = f2;
            if (XmlPullParserUtil.isEndTag(xmlPullParser, "ServiceDescription")) {
                return new ServiceDescriptionElement(j4, j5, j6, f3, f4);
            }
            j = j4;
            j2 = j5;
            j3 = j6;
            f = f3;
            f2 = f4;
        }
    }

    public int parseTvaAudioPurposeCsValue(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case 49:
                if (str.equals(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE)) {
                    c = 0;
                    break;
                }
                break;
            case 50:
                if (str.equals(ExifInterface.GPS_MEASUREMENT_2D)) {
                    c = 1;
                    break;
                }
                break;
            case 51:
                if (str.equals(ExifInterface.GPS_MEASUREMENT_3D)) {
                    c = 2;
                    break;
                }
                break;
            case 52:
                if (str.equals("4")) {
                    c = 3;
                    break;
                }
                break;
            case 54:
                if (str.equals("6")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return 512;
            case 1:
                return 2048;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 1;
            default:
                return 0;
        }
    }

    @Nullable
    public UrlTemplate parseUrlTemplate(XmlPullParser xmlPullParser, String str, @Nullable UrlTemplate urlTemplate) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue != null) {
            return UrlTemplate.compile(attributeValue);
        }
        return urlTemplate;
    }

    public UtcTimingElement parseUtcTiming(XmlPullParser xmlPullParser) {
        return buildUtcTimingElement(xmlPullParser.getAttributeValue(null, "schemeIdUri"), xmlPullParser.getAttributeValue(null, "value"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
    public DashManifest parse(Uri uri, InputStream inputStream) {
        try {
            XmlPullParser newPullParser = this.f11323a.newPullParser();
            newPullParser.setInput(inputStream, null);
            if (newPullParser.next() == 2 && "MPD".equals(newPullParser.getName())) {
                return parseMediaPresentationDescription(newPullParser, uri);
            }
            throw ParserException.createForMalformedManifest("inputStream does not contain a valid media presentation description", null);
        } catch (XmlPullParserException e) {
            throw ParserException.createForMalformedManifest(null, e);
        }
    }
}
