package p000;

import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.AbstractC0712a;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public final class jm2 extends AbstractC0712a {

    /* renamed from: e */
    public Format f20546e;

    @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.AbstractC0712a
    /* renamed from: b */
    public final Object mo2834b() {
        return this.f20546e;
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.AbstractC0712a
    /* renamed from: j */
    public final void mo2839j(XmlPullParser xmlPullParser) {
        String str;
        int i;
        Format.Builder builder = new Format.Builder();
        String attributeValue = xmlPullParser.getAttributeValue(null, "FourCC");
        if (attributeValue != null) {
            if (!attributeValue.equalsIgnoreCase("H264") && !attributeValue.equalsIgnoreCase("X264") && !attributeValue.equalsIgnoreCase("AVC1") && !attributeValue.equalsIgnoreCase("DAVC")) {
                if (!attributeValue.equalsIgnoreCase("AAC") && !attributeValue.equalsIgnoreCase("AACL") && !attributeValue.equalsIgnoreCase("AACH") && !attributeValue.equalsIgnoreCase("AACP")) {
                    if (!attributeValue.equalsIgnoreCase("TTML") && !attributeValue.equalsIgnoreCase("DFXP")) {
                        if (!attributeValue.equalsIgnoreCase("ac-3") && !attributeValue.equalsIgnoreCase("dac3")) {
                            if (!attributeValue.equalsIgnoreCase("ec-3") && !attributeValue.equalsIgnoreCase("dec3")) {
                                if (attributeValue.equalsIgnoreCase("dtsc")) {
                                    str = MimeTypes.AUDIO_DTS;
                                } else if (!attributeValue.equalsIgnoreCase("dtsh") && !attributeValue.equalsIgnoreCase("dtsl")) {
                                    if (attributeValue.equalsIgnoreCase("dtse")) {
                                        str = MimeTypes.AUDIO_DTS_EXPRESS;
                                    } else if (attributeValue.equalsIgnoreCase("opus")) {
                                        str = MimeTypes.AUDIO_OPUS;
                                    } else {
                                        str = null;
                                    }
                                } else {
                                    str = MimeTypes.AUDIO_DTS_HD;
                                }
                            } else {
                                str = MimeTypes.AUDIO_E_AC3;
                            }
                        } else {
                            str = MimeTypes.AUDIO_AC3;
                        }
                    } else {
                        str = MimeTypes.APPLICATION_TTML;
                    }
                } else {
                    str = MimeTypes.AUDIO_AAC;
                }
            } else {
                str = MimeTypes.VIDEO_H264;
            }
            int intValue = ((Integer) m2835c("Type")).intValue();
            if (intValue == 2) {
                String attributeValue2 = xmlPullParser.getAttributeValue(null, "CodecPrivateData");
                ArrayList arrayList = new ArrayList();
                if (!TextUtils.isEmpty(attributeValue2)) {
                    byte[] bytesFromHexString = Util.getBytesFromHexString(attributeValue2);
                    byte[][] splitNalUnits = CodecSpecificDataUtil.splitNalUnits(bytesFromHexString);
                    if (splitNalUnits == null) {
                        arrayList.add(bytesFromHexString);
                    } else {
                        Collections.addAll(arrayList, splitNalUnits);
                    }
                }
                builder.setContainerMimeType(MimeTypes.VIDEO_MP4).setWidth(AbstractC0712a.m2832i(xmlPullParser, "MaxWidth")).setHeight(AbstractC0712a.m2832i(xmlPullParser, "MaxHeight")).setInitializationData(arrayList);
            } else if (intValue == 1) {
                if (str == null) {
                    str = MimeTypes.AUDIO_AAC;
                }
                int m2832i = AbstractC0712a.m2832i(xmlPullParser, "Channels");
                int m2832i2 = AbstractC0712a.m2832i(xmlPullParser, "SamplingRate");
                String attributeValue3 = xmlPullParser.getAttributeValue(null, "CodecPrivateData");
                ArrayList arrayList2 = new ArrayList();
                if (!TextUtils.isEmpty(attributeValue3)) {
                    byte[] bytesFromHexString2 = Util.getBytesFromHexString(attributeValue3);
                    byte[][] splitNalUnits2 = CodecSpecificDataUtil.splitNalUnits(bytesFromHexString2);
                    if (splitNalUnits2 == null) {
                        arrayList2.add(bytesFromHexString2);
                    } else {
                        Collections.addAll(arrayList2, splitNalUnits2);
                    }
                }
                boolean isEmpty = arrayList2.isEmpty();
                List<byte[]> list = arrayList2;
                if (isEmpty) {
                    list = arrayList2;
                    if (MimeTypes.AUDIO_AAC.equals(str)) {
                        list = Collections.singletonList(AacUtil.buildAacLcAudioSpecificConfig(m2832i2, m2832i));
                    }
                }
                builder.setContainerMimeType(MimeTypes.AUDIO_MP4).setChannelCount(m2832i).setSampleRate(m2832i2).setInitializationData(list);
            } else if (intValue == 3) {
                String str2 = (String) m2835c("Subtype");
                if (str2 != null) {
                    if (!str2.equals("CAPT")) {
                        if (str2.equals("DESC")) {
                            i = 1024;
                        }
                    } else {
                        i = 64;
                    }
                    builder.setContainerMimeType(MimeTypes.APPLICATION_MP4).setRoleFlags(i);
                }
                i = 0;
                builder.setContainerMimeType(MimeTypes.APPLICATION_MP4).setRoleFlags(i);
            } else {
                builder.setContainerMimeType(MimeTypes.APPLICATION_MP4);
            }
            this.f20546e = builder.setId(xmlPullParser.getAttributeValue(null, "Index")).setLabel((String) m2835c("Name")).setSampleMimeType(str).setAverageBitrate(AbstractC0712a.m2832i(xmlPullParser, "Bitrate")).setLanguage((String) m2835c("Language")).build();
            return;
        }
        throw new SsManifestParser.MissingFieldException("FourCC");
    }
}
