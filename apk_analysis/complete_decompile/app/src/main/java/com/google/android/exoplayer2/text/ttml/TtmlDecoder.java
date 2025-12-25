package com.google.android.exoplayer2.text.ttml;

import android.text.Layout;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.upstream.DataSchemeDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ColorParser;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.XmlPullParserUtil;
import com.google.common.base.Ascii;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlinx.coroutines.DebugKt;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import p000.AbstractC1726qj;
import p000.cx2;
import p000.dx2;
import p000.ex2;
import p000.fx2;
import p000.gx2;
import p000.pl1;
import p000.tx0;
import p000.vs2;
import p000.ye0;

/* loaded from: classes.dex */
public final class TtmlDecoder extends SimpleSubtitleDecoder {

    /* renamed from: p */
    public static final Pattern f11820p = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");

    /* renamed from: q */
    public static final Pattern f11821q = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");

    /* renamed from: r */
    public static final Pattern f11822r = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");

    /* renamed from: s */
    public static final Pattern f11823s = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");

    /* renamed from: t */
    public static final Pattern f11824t = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");

    /* renamed from: u */
    public static final Pattern f11825u = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");

    /* renamed from: v */
    public static final Pattern f11826v = Pattern.compile("^(\\d+) (\\d+)$");

    /* renamed from: w */
    public static final cx2 f11827w = new cx2(30.0f, 1, 1);

    /* renamed from: x */
    public static final tx0 f11828x = new tx0(15);

    /* renamed from: o */
    public final XmlPullParserFactory f11829o;

    public TtmlDecoder() {
        super("TtmlDecoder");
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            this.f11829o = newInstance;
            newInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    /* renamed from: b */
    public static fx2 m2855b(fx2 fx2Var) {
        if (fx2Var == null) {
            return new fx2();
        }
        return fx2Var;
    }

    /* renamed from: c */
    public static boolean m2856c(String str) {
        if (!str.equals("tt") && !str.equals("head") && !str.equals("body") && !str.equals("div") && !str.equals("p") && !str.equals("span") && !str.equals("br") && !str.equals("style") && !str.equals("styling") && !str.equals("layout") && !str.equals("region") && !str.equals("metadata") && !str.equals(MimeTypes.BASE_TYPE_IMAGE) && !str.equals(DataSchemeDataSource.SCHEME_DATA) && !str.equals("information")) {
            return false;
        }
        return true;
    }

    /* renamed from: d */
    public static tx0 m2857d(XmlPullParser xmlPullParser, tx0 tx0Var) {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (attributeValue == null) {
            return tx0Var;
        }
        Matcher matcher = f11826v.matcher(attributeValue);
        if (!matcher.matches()) {
            Log.m3027w("TtmlDecoder", "Ignoring malformed cell resolution: ".concat(attributeValue));
            return tx0Var;
        }
        try {
            int parseInt = Integer.parseInt((String) Assertions.checkNotNull(matcher.group(1)));
            int parseInt2 = Integer.parseInt((String) Assertions.checkNotNull(matcher.group(2)));
            if (parseInt != 0 && parseInt2 != 0) {
                return new tx0(parseInt2);
            }
            throw new SubtitleDecoderException("Invalid cell resolution " + parseInt + " " + parseInt2);
        } catch (NumberFormatException unused) {
            Log.m3027w("TtmlDecoder", "Ignoring malformed cell resolution: ".concat(attributeValue));
            return tx0Var;
        }
    }

    /* renamed from: e */
    public static void m2858e(String str, fx2 fx2Var) {
        Matcher matcher;
        String[] split = Util.split(str, "\\s+");
        int length = split.length;
        Pattern pattern = f11822r;
        if (length == 1) {
            matcher = pattern.matcher(str);
        } else if (split.length == 2) {
            matcher = pattern.matcher(split[1]);
            Log.m3027w("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        } else {
            throw new SubtitleDecoderException(ye0.m8298r(new StringBuilder("Invalid number of entries for fontSize: "), ".", split.length));
        }
        if (matcher.matches()) {
            String str2 = (String) Assertions.checkNotNull(matcher.group(3));
            str2.getClass();
            char c = 65535;
            switch (str2.hashCode()) {
                case 37:
                    if (str2.equals("%")) {
                        c = 0;
                        break;
                    }
                    break;
                case 3240:
                    if (str2.equals("em")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3592:
                    if (str2.equals("px")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    fx2Var.f17435j = 3;
                    break;
                case 1:
                    fx2Var.f17435j = 2;
                    break;
                case 2:
                    fx2Var.f17435j = 1;
                    break;
                default:
                    throw new SubtitleDecoderException(ye0.m8296p("Invalid unit for fontSize: '", str2, "'."));
            }
            fx2Var.f17436k = Float.parseFloat((String) Assertions.checkNotNull(matcher.group(1)));
            return;
        }
        throw new SubtitleDecoderException(ye0.m8296p("Invalid expression for fontSize: '", str, "'."));
    }

    /* renamed from: f */
    public static cx2 m2859f(XmlPullParser xmlPullParser) {
        int i;
        float f;
        int i2;
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        if (attributeValue != null) {
            i = Integer.parseInt(attributeValue);
        } else {
            i = 30;
        }
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            if (Util.split(attributeValue2, " ").length == 2) {
                f = Integer.parseInt(r2[0]) / Integer.parseInt(r2[1]);
            } else {
                throw new SubtitleDecoderException("frameRateMultiplier doesn't have 2 parts");
            }
        } else {
            f = 1.0f;
        }
        cx2 cx2Var = f11827w;
        int i3 = cx2Var.f16174b;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i3 = Integer.parseInt(attributeValue3);
        }
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i2 = Integer.parseInt(attributeValue4);
        } else {
            i2 = cx2Var.f16175c;
        }
        return new cx2(i * f, i3, i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0239, code lost:
    
        r19.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0242, code lost:
    
        if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r19, com.google.android.exoplayer2.util.MimeTypes.BASE_TYPE_IMAGE) == false) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0244, code lost:
    
        r6 = com.google.android.exoplayer2.util.XmlPullParserUtil.getAttributeValue(r19, "id");
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0248, code lost:
    
        if (r6 == null) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x024a, code lost:
    
        r24.put(r6, r19.nextText());
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x025a, code lost:
    
        if (com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(r19, "metadata") == false) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0237, code lost:
    
        if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r19, "metadata") != false) goto L93;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:61:0x01b6. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0265 A[LOOP:0: B:2:0x0009->B:21:0x0265, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0264 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01aa  */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m2860g(XmlPullParser xmlPullParser, HashMap hashMap, tx0 tx0Var, pl1 pl1Var, HashMap hashMap2, HashMap hashMap3) {
        float parseFloat;
        float f;
        float parseFloat2;
        float f2;
        tx0 tx0Var2;
        int i;
        String attributeValue;
        int i2;
        String[] split;
        int i3 = 0;
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "style")) {
                String attributeValue2 = XmlPullParserUtil.getAttributeValue(xmlPullParser, "style");
                fx2 m2862i = m2862i(xmlPullParser, new fx2());
                if (attributeValue2 != null) {
                    String trim = attributeValue2.trim();
                    if (trim.isEmpty()) {
                        split = new String[i3];
                    } else {
                        split = Util.split(trim, "\\s+");
                    }
                    int length = split.length;
                    for (int i4 = i3; i4 < length; i4++) {
                        m2862i.m4874a((fx2) hashMap.get(split[i4]));
                    }
                }
                String str = m2862i.f17437l;
                if (str != null) {
                    hashMap.put(str, m2862i);
                }
            } else {
                if (XmlPullParserUtil.isStartTag(xmlPullParser, "region")) {
                    String attributeValue3 = XmlPullParserUtil.getAttributeValue(xmlPullParser, "id");
                    ex2 ex2Var = null;
                    if (attributeValue3 != null) {
                        String attributeValue4 = XmlPullParserUtil.getAttributeValue(xmlPullParser, "origin");
                        if (attributeValue4 != null) {
                            Pattern pattern = f11824t;
                            Matcher matcher = pattern.matcher(attributeValue4);
                            Pattern pattern2 = f11825u;
                            Matcher matcher2 = pattern2.matcher(attributeValue4);
                            if (matcher.matches()) {
                                try {
                                    float parseFloat3 = Float.parseFloat((String) Assertions.checkNotNull(matcher.group(1))) / 100.0f;
                                    parseFloat = Float.parseFloat((String) Assertions.checkNotNull(matcher.group(2))) / 100.0f;
                                    f = parseFloat3;
                                } catch (NumberFormatException unused) {
                                    Log.m3027w("TtmlDecoder", "Ignoring region with malformed origin: ".concat(attributeValue4));
                                }
                            } else if (matcher2.matches()) {
                                if (pl1Var == null) {
                                    Log.m3027w("TtmlDecoder", "Ignoring region with missing tts:extent: ".concat(attributeValue4));
                                } else {
                                    try {
                                        int parseInt = Integer.parseInt((String) Assertions.checkNotNull(matcher2.group(1)));
                                        f = parseInt / pl1Var.f25214a;
                                        parseFloat = Integer.parseInt((String) Assertions.checkNotNull(matcher2.group(2))) / pl1Var.f25215b;
                                    } catch (NumberFormatException unused2) {
                                        Log.m3027w("TtmlDecoder", "Ignoring region with malformed origin: ".concat(attributeValue4));
                                    }
                                }
                            } else {
                                Log.m3027w("TtmlDecoder", "Ignoring region with unsupported origin: ".concat(attributeValue4));
                            }
                            String attributeValue5 = XmlPullParserUtil.getAttributeValue(xmlPullParser, "extent");
                            if (attributeValue5 != null) {
                                Matcher matcher3 = pattern.matcher(attributeValue5);
                                Matcher matcher4 = pattern2.matcher(attributeValue5);
                                if (matcher3.matches()) {
                                    try {
                                        float parseFloat4 = Float.parseFloat((String) Assertions.checkNotNull(matcher3.group(1))) / 100.0f;
                                        parseFloat2 = Float.parseFloat((String) Assertions.checkNotNull(matcher3.group(2))) / 100.0f;
                                        f2 = parseFloat4;
                                    } catch (NumberFormatException unused3) {
                                        Log.m3027w("TtmlDecoder", "Ignoring region with malformed extent: ".concat(attributeValue4));
                                    }
                                } else if (matcher4.matches()) {
                                    if (pl1Var == null) {
                                        Log.m3027w("TtmlDecoder", "Ignoring region with missing tts:extent: ".concat(attributeValue4));
                                    } else {
                                        try {
                                            int parseInt2 = Integer.parseInt((String) Assertions.checkNotNull(matcher4.group(1)));
                                            f2 = parseInt2 / pl1Var.f25214a;
                                            parseFloat2 = Integer.parseInt((String) Assertions.checkNotNull(matcher4.group(2))) / pl1Var.f25215b;
                                        } catch (NumberFormatException unused4) {
                                            Log.m3027w("TtmlDecoder", "Ignoring region with malformed extent: ".concat(attributeValue4));
                                        }
                                    }
                                } else {
                                    Log.m3027w("TtmlDecoder", "Ignoring region with unsupported extent: ".concat(attributeValue4));
                                }
                                String attributeValue6 = XmlPullParserUtil.getAttributeValue(xmlPullParser, "displayAlign");
                                if (attributeValue6 != null) {
                                    String lowerCase = Ascii.toLowerCase(attributeValue6);
                                    lowerCase.getClass();
                                    if (!lowerCase.equals("center")) {
                                        if (lowerCase.equals("after")) {
                                            parseFloat += parseFloat2;
                                            tx0Var2 = tx0Var;
                                            i = 2;
                                        }
                                    } else {
                                        i = 1;
                                        parseFloat = (parseFloat2 / 2.0f) + parseFloat;
                                        tx0Var2 = tx0Var;
                                    }
                                    float f3 = 1.0f / tx0Var2.f27011a;
                                    attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, "writingMode");
                                    if (attributeValue != null) {
                                        String lowerCase2 = Ascii.toLowerCase(attributeValue);
                                        lowerCase2.getClass();
                                        char c = 65535;
                                        switch (lowerCase2.hashCode()) {
                                            case 3694:
                                                if (lowerCase2.equals("tb")) {
                                                    c = 0;
                                                    break;
                                                }
                                                break;
                                            case 3553396:
                                                if (lowerCase2.equals("tblr")) {
                                                    c = 1;
                                                    break;
                                                }
                                                break;
                                            case 3553576:
                                                if (lowerCase2.equals("tbrl")) {
                                                    c = 2;
                                                    break;
                                                }
                                                break;
                                        }
                                        switch (c) {
                                            case 0:
                                            case 1:
                                                i2 = 2;
                                                break;
                                            case 2:
                                                i2 = 1;
                                                break;
                                        }
                                        ex2Var = new ex2(attributeValue3, f, parseFloat, 0, i, f2, parseFloat2, 1, f3, i2);
                                    }
                                    i2 = Integer.MIN_VALUE;
                                    ex2Var = new ex2(attributeValue3, f, parseFloat, 0, i, f2, parseFloat2, 1, f3, i2);
                                }
                                tx0Var2 = tx0Var;
                                i = 0;
                                float f32 = 1.0f / tx0Var2.f27011a;
                                attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, "writingMode");
                                if (attributeValue != null) {
                                }
                                i2 = Integer.MIN_VALUE;
                                ex2Var = new ex2(attributeValue3, f, parseFloat, 0, i, f2, parseFloat2, 1, f32, i2);
                            } else {
                                Log.m3027w("TtmlDecoder", "Ignoring region without an extent");
                            }
                        } else {
                            Log.m3027w("TtmlDecoder", "Ignoring region without an origin");
                        }
                    }
                    if (ex2Var != null) {
                        hashMap2.put(ex2Var.f17022a, ex2Var);
                    }
                }
                if (!XmlPullParserUtil.isEndTag(xmlPullParser, "head")) {
                    return;
                } else {
                    i3 = 0;
                }
            }
            if (!XmlPullParserUtil.isEndTag(xmlPullParser, "head")) {
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:23:0x0083. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0093 A[FALL_THROUGH, PHI: r12
      0x0093: PHI (r12v2 java.lang.String) = (r12v1 java.lang.String), (r12v1 java.lang.String), (r12v4 java.lang.String) binds: [B:23:0x0083, B:25:0x008d, B:26:0x008f] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static dx2 m2861h(XmlPullParser xmlPullParser, dx2 dx2Var, HashMap hashMap, cx2 cx2Var) {
        long j;
        long j2;
        String[] split;
        int attributeCount = xmlPullParser.getAttributeCount();
        fx2 m2862i = m2862i(xmlPullParser, null);
        String str = null;
        String str2 = "";
        long j3 = C0643C.TIME_UNSET;
        long j4 = C0643C.TIME_UNSET;
        long j5 = C0643C.TIME_UNSET;
        String[] strArr = null;
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            attributeName.getClass();
            char c = 65535;
            switch (attributeName.hashCode()) {
                case -934795532:
                    if (attributeName.equals("region")) {
                        c = 0;
                    }
                    switch (c) {
                        case 0:
                            if (hashMap.containsKey(attributeValue)) {
                                str2 = attributeValue;
                                break;
                            } else {
                                break;
                            }
                        case 1:
                            j5 = m2863j(attributeValue, cx2Var);
                            break;
                        case 2:
                            j4 = m2863j(attributeValue, cx2Var);
                            break;
                        case 3:
                            j3 = m2863j(attributeValue, cx2Var);
                            break;
                        case 4:
                            String trim = attributeValue.trim();
                            if (trim.isEmpty()) {
                                split = new String[0];
                            } else {
                                split = Util.split(trim, "\\s+");
                            }
                            if (split.length > 0) {
                                strArr = split;
                            }
                            break;
                        case 5:
                            if (attributeValue.startsWith("#")) {
                                str = attributeValue.substring(1);
                            }
                    }
                case 99841:
                    if (attributeName.equals("dur")) {
                        c = 1;
                    }
                    switch (c) {
                    }
                    break;
                case 100571:
                    if (attributeName.equals("end")) {
                        c = 2;
                    }
                    switch (c) {
                    }
                    break;
                case 93616297:
                    if (attributeName.equals("begin")) {
                        c = 3;
                    }
                    switch (c) {
                    }
                    break;
                case 109780401:
                    if (attributeName.equals("style")) {
                        c = 4;
                    }
                    switch (c) {
                    }
                    break;
                case 1292595405:
                    if (attributeName.equals("backgroundImage")) {
                        c = 5;
                    }
                    switch (c) {
                    }
                    break;
                default:
                    switch (c) {
                    }
                    break;
            }
        }
        if (dx2Var != null) {
            long j6 = dx2Var.f16592d;
            j = C0643C.TIME_UNSET;
            if (j6 != C0643C.TIME_UNSET) {
                if (j3 != C0643C.TIME_UNSET) {
                    j3 += j6;
                }
                if (j4 != C0643C.TIME_UNSET) {
                    j4 += j6;
                }
            }
        } else {
            j = C0643C.TIME_UNSET;
        }
        if (j4 == j) {
            if (j5 != j) {
                j2 = j3 + j5;
            } else if (dx2Var != null) {
                long j7 = dx2Var.f16593e;
                if (j7 != j) {
                    j2 = j7;
                }
            }
            return new dx2(xmlPullParser.getName(), null, j3, j2, m2862i, strArr, str2, str, dx2Var);
        }
        j2 = j4;
        return new dx2(xmlPullParser.getName(), null, j3, j2, m2862i, strArr, str2, str, dx2Var);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0140, code lost:
    
        r0.f17441p = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x04d9, code lost:
    
        r0.f17440o = r16;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x00eb. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x028e  */
    /* JADX WARN: Type inference failed for: r11v66, types: [vs2] */
    /* JADX WARN: Type inference failed for: r12v45, types: [vs2] */
    /* JADX WARN: Type inference failed for: r12v54, types: [vs2] */
    /* JADX WARN: Type inference failed for: r1v51, types: [vs2] */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static fx2 m2862i(XmlPullParser xmlPullParser, fx2 fx2Var) {
        char c;
        String str;
        char c2;
        int i;
        char c3;
        char c4;
        char c5;
        int i2;
        Sets.SetView intersection;
        int i3;
        int hashCode;
        char c6;
        int i4;
        Layout.Alignment alignment;
        int i5;
        char c7;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        String str2 = "after";
        int attributeCount = xmlPullParser.getAttributeCount();
        fx2 fx2Var2 = fx2Var;
        int i6 = 0;
        while (i6 < attributeCount) {
            String attributeValue = xmlPullParser2.getAttributeValue(i6);
            String attributeName = xmlPullParser2.getAttributeName(i6);
            attributeName.getClass();
            Layout.Alignment alignment2 = null;
            switch (attributeName.hashCode()) {
                case -1550943582:
                    if (attributeName.equals("fontStyle")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1224696685:
                    if (attributeName.equals("fontFamily")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1065511464:
                    if (attributeName.equals("textAlign")) {
                        c = 2;
                        break;
                    }
                    break;
                case -879295043:
                    if (attributeName.equals("textDecoration")) {
                        c = 3;
                        break;
                    }
                    break;
                case -734428249:
                    if (attributeName.equals("fontWeight")) {
                        c = 4;
                        break;
                    }
                    break;
                case 3355:
                    if (attributeName.equals("id")) {
                        c = 5;
                        break;
                    }
                    break;
                case 3511770:
                    if (attributeName.equals("ruby")) {
                        c = 6;
                        break;
                    }
                    break;
                case 94842723:
                    if (attributeName.equals(TypedValues.Custom.S_COLOR)) {
                        c = 7;
                        break;
                    }
                    break;
                case 109403361:
                    if (attributeName.equals("shear")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 110138194:
                    if (attributeName.equals("textCombine")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 365601008:
                    if (attributeName.equals("fontSize")) {
                        c = '\n';
                        break;
                    }
                    break;
                case 921125321:
                    if (attributeName.equals("textEmphasis")) {
                        c = 11;
                        break;
                    }
                    break;
                case 1115953443:
                    if (attributeName.equals("rubyPosition")) {
                        c = '\f';
                        break;
                    }
                    break;
                case 1287124693:
                    if (attributeName.equals("backgroundColor")) {
                        c = '\r';
                        break;
                    }
                    break;
                case 1754920356:
                    if (attributeName.equals("multiRowAlign")) {
                        c = 14;
                        break;
                    }
                    break;
            }
            c = 65535;
            switch (c) {
                case 0:
                    str = str2;
                    fx2Var2 = m2855b(fx2Var2);
                    fx2Var2.f17434i = "italic".equalsIgnoreCase(attributeValue) ? 1 : 0;
                    i = 1;
                    break;
                case 1:
                    str = str2;
                    fx2Var2 = m2855b(fx2Var2);
                    fx2Var2.f17426a = attributeValue;
                    i = 1;
                    break;
                case 2:
                    str = str2;
                    fx2Var2 = m2855b(fx2Var2);
                    String lowerCase = Ascii.toLowerCase(attributeValue);
                    lowerCase.getClass();
                    switch (lowerCase.hashCode()) {
                        case -1364013995:
                            if (lowerCase.equals("center")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case 100571:
                            if (lowerCase.equals("end")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 3317767:
                            if (lowerCase.equals("left")) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case 108511772:
                            if (lowerCase.equals("right")) {
                                c2 = 3;
                                break;
                            }
                            break;
                        case 109757538:
                            if (lowerCase.equals("start")) {
                                c2 = 4;
                                break;
                            }
                            break;
                    }
                    c2 = 65535;
                    switch (c2) {
                        case 0:
                            alignment2 = Layout.Alignment.ALIGN_CENTER;
                            break;
                        case 1:
                        case 3:
                            alignment2 = Layout.Alignment.ALIGN_OPPOSITE;
                            break;
                        case 2:
                        case 4:
                            alignment2 = Layout.Alignment.ALIGN_NORMAL;
                            break;
                    }
                    i = 1;
                    break;
                case 3:
                    str = str2;
                    String lowerCase2 = Ascii.toLowerCase(attributeValue);
                    lowerCase2.getClass();
                    switch (lowerCase2.hashCode()) {
                        case -1461280213:
                            if (lowerCase2.equals("nounderline")) {
                                c3 = 0;
                                break;
                            }
                            break;
                        case -1026963764:
                            if (lowerCase2.equals("underline")) {
                                c3 = 1;
                                break;
                            }
                            break;
                        case 913457136:
                            if (lowerCase2.equals("nolinethrough")) {
                                c3 = 2;
                                break;
                            }
                            break;
                        case 1679736913:
                            if (lowerCase2.equals("linethrough")) {
                                c3 = 3;
                                break;
                            }
                            break;
                    }
                    c3 = 65535;
                    switch (c3) {
                        case 0:
                            fx2Var2 = m2855b(fx2Var2);
                            fx2Var2.f17432g = 0;
                            break;
                        case 1:
                            fx2Var2 = m2855b(fx2Var2);
                            fx2Var2.f17432g = 1;
                            break;
                        case 2:
                            fx2Var2 = m2855b(fx2Var2);
                            fx2Var2.f17431f = 0;
                            break;
                        case 3:
                            fx2Var2 = m2855b(fx2Var2);
                            fx2Var2.f17431f = 1;
                            break;
                    }
                    i = 1;
                    break;
                case 4:
                    str = str2;
                    fx2Var2 = m2855b(fx2Var2);
                    fx2Var2.f17433h = "bold".equalsIgnoreCase(attributeValue) ? 1 : 0;
                    i = 1;
                    break;
                case 5:
                    str = str2;
                    if ("style".equals(xmlPullParser.getName())) {
                        fx2Var2 = m2855b(fx2Var2);
                        fx2Var2.f17437l = attributeValue;
                    }
                    i = 1;
                    break;
                case 6:
                    str = str2;
                    String lowerCase3 = Ascii.toLowerCase(attributeValue);
                    lowerCase3.getClass();
                    switch (lowerCase3.hashCode()) {
                        case -618561360:
                            if (lowerCase3.equals("baseContainer")) {
                                c4 = 0;
                                break;
                            }
                            break;
                        case -410956671:
                            if (lowerCase3.equals("container")) {
                                c4 = 1;
                                break;
                            }
                            break;
                        case -250518009:
                            if (lowerCase3.equals("delimiter")) {
                                c4 = 2;
                                break;
                            }
                            break;
                        case -136074796:
                            if (lowerCase3.equals("textContainer")) {
                                c4 = 3;
                                break;
                            }
                            break;
                        case 3016401:
                            if (lowerCase3.equals("base")) {
                                c4 = 4;
                                break;
                            }
                            break;
                        case 3556653:
                            if (lowerCase3.equals(MimeTypes.BASE_TYPE_TEXT)) {
                                c4 = 5;
                                break;
                            }
                            break;
                    }
                    c4 = 65535;
                    switch (c4) {
                        case 0:
                        case 4:
                            fx2Var2 = m2855b(fx2Var2);
                            fx2Var2.f17438m = 2;
                            break;
                        case 1:
                            fx2Var2 = m2855b(fx2Var2);
                            fx2Var2.f17438m = 1;
                            break;
                        case 2:
                            fx2Var2 = m2855b(fx2Var2);
                            fx2Var2.f17438m = 4;
                            break;
                        case 3:
                        case 5:
                            fx2Var2 = m2855b(fx2Var2);
                            fx2Var2.f17438m = 3;
                            break;
                    }
                    i = 1;
                    break;
                case 7:
                    str = str2;
                    fx2Var2 = m2855b(fx2Var2);
                    try {
                        fx2Var2.f17427b = ColorParser.parseTtmlColor(attributeValue);
                        fx2Var2.f17428c = true;
                    } catch (IllegalArgumentException unused) {
                        ye0.m8279B("Failed parsing color value: ", attributeValue, "TtmlDecoder");
                    }
                    i = 1;
                    break;
                case '\b':
                    str = str2;
                    fx2 m2855b = m2855b(fx2Var2);
                    Matcher matcher = f11823s.matcher(attributeValue);
                    float f = Float.MAX_VALUE;
                    if (!matcher.matches()) {
                        ye0.m8279B("Invalid value for shear: ", attributeValue, "TtmlDecoder");
                    } else {
                        try {
                            f = Math.min(100.0f, Math.max(-100.0f, Float.parseFloat((String) Assertions.checkNotNull(matcher.group(1)))));
                        } catch (NumberFormatException e) {
                            Log.m3028w("TtmlDecoder", "Failed to parse shear: " + attributeValue, e);
                        }
                    }
                    m2855b.f17444s = f;
                    fx2Var2 = m2855b;
                    i = 1;
                    break;
                case '\t':
                    str = str2;
                    String lowerCase4 = Ascii.toLowerCase(attributeValue);
                    lowerCase4.getClass();
                    if (!lowerCase4.equals("all")) {
                        if (lowerCase4.equals(SchedulerSupport.NONE)) {
                            fx2Var2 = m2855b(fx2Var2);
                            fx2Var2.f17442q = 0;
                        }
                    } else {
                        fx2Var2 = m2855b(fx2Var2);
                        fx2Var2.f17442q = 1;
                    }
                    i = 1;
                    break;
                case '\n':
                    str = str2;
                    try {
                        fx2Var2 = m2855b(fx2Var2);
                        m2858e(attributeValue, fx2Var2);
                    } catch (SubtitleDecoderException unused2) {
                        ye0.m8279B("Failed parsing fontSize value: ", attributeValue, "TtmlDecoder");
                    }
                    i = 1;
                    break;
                case 11:
                    fx2Var2 = m2855b(fx2Var2);
                    Pattern pattern = vs2.f27943d;
                    if (attributeValue != null) {
                        String lowerCase5 = Ascii.toLowerCase(attributeValue.trim());
                        if (!lowerCase5.isEmpty()) {
                            ImmutableSet copyOf = ImmutableSet.copyOf(TextUtils.split(lowerCase5, vs2.f27943d));
                            String str3 = (String) Iterables.getFirst(Sets.intersection(vs2.f27947h, copyOf), "outside");
                            int hashCode2 = str3.hashCode();
                            if (hashCode2 != -1392885889) {
                                if (hashCode2 != -1106037339) {
                                    if (hashCode2 == 92734940 && str3.equals(str2)) {
                                        c5 = 0;
                                        if (c5 == 0) {
                                            if (c5 != 1) {
                                                i2 = 1;
                                            } else {
                                                i2 = -2;
                                            }
                                        } else {
                                            i2 = 2;
                                        }
                                        intersection = Sets.intersection(vs2.f27944e, copyOf);
                                        if (intersection.isEmpty()) {
                                            String str4 = (String) intersection.iterator().next();
                                            int hashCode3 = str4.hashCode();
                                            if (hashCode3 != 3005871) {
                                                if (hashCode3 == 3387192 && str4.equals(SchedulerSupport.NONE)) {
                                                    i5 = 0;
                                                    str = str2;
                                                    alignment = new vs2(i5, 0, i2);
                                                }
                                            } else {
                                                str4.equals(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
                                            }
                                            i5 = -1;
                                            str = str2;
                                            alignment = new vs2(i5, 0, i2);
                                        } else {
                                            Sets.SetView intersection2 = Sets.intersection(vs2.f27946g, copyOf);
                                            Sets.SetView intersection3 = Sets.intersection(vs2.f27945f, copyOf);
                                            if (intersection2.isEmpty() && intersection3.isEmpty()) {
                                                str = str2;
                                                alignment2 = new vs2(-1, 0, i2);
                                            } else {
                                                String str5 = (String) Iterables.getFirst(intersection2, "filled");
                                                int hashCode4 = str5.hashCode();
                                                str = str2;
                                                if (hashCode4 != -1274499742) {
                                                    if (hashCode4 == 3417674 && str5.equals("open")) {
                                                        i3 = 2;
                                                        String str6 = (String) Iterables.getFirst(intersection3, "circle");
                                                        hashCode = str6.hashCode();
                                                        if (hashCode == -1360216880) {
                                                            if (hashCode != -905816648) {
                                                                if (hashCode == 99657 && str6.equals("dot")) {
                                                                    c6 = 0;
                                                                    if (c6 == 0) {
                                                                        if (c6 != 1) {
                                                                            i4 = 1;
                                                                        } else {
                                                                            i4 = 3;
                                                                        }
                                                                    } else {
                                                                        i4 = 2;
                                                                    }
                                                                    alignment = new vs2(i4, i3, i2);
                                                                }
                                                                c6 = 65535;
                                                                if (c6 == 0) {
                                                                }
                                                                alignment = new vs2(i4, i3, i2);
                                                            } else {
                                                                if (str6.equals("sesame")) {
                                                                    c6 = 1;
                                                                    if (c6 == 0) {
                                                                    }
                                                                    alignment = new vs2(i4, i3, i2);
                                                                }
                                                                c6 = 65535;
                                                                if (c6 == 0) {
                                                                }
                                                                alignment = new vs2(i4, i3, i2);
                                                            }
                                                        } else {
                                                            if (str6.equals("circle")) {
                                                                c6 = 2;
                                                                if (c6 == 0) {
                                                                }
                                                                alignment = new vs2(i4, i3, i2);
                                                            }
                                                            c6 = 65535;
                                                            if (c6 == 0) {
                                                            }
                                                            alignment = new vs2(i4, i3, i2);
                                                        }
                                                    }
                                                } else {
                                                    str5.equals("filled");
                                                }
                                                i3 = 1;
                                                String str62 = (String) Iterables.getFirst(intersection3, "circle");
                                                hashCode = str62.hashCode();
                                                if (hashCode == -1360216880) {
                                                }
                                            }
                                        }
                                        alignment2 = alignment;
                                    }
                                    c5 = 65535;
                                    if (c5 == 0) {
                                    }
                                    intersection = Sets.intersection(vs2.f27944e, copyOf);
                                    if (intersection.isEmpty()) {
                                    }
                                    alignment2 = alignment;
                                } else {
                                    if (str3.equals("outside")) {
                                        c5 = 1;
                                        if (c5 == 0) {
                                        }
                                        intersection = Sets.intersection(vs2.f27944e, copyOf);
                                        if (intersection.isEmpty()) {
                                        }
                                        alignment2 = alignment;
                                    }
                                    c5 = 65535;
                                    if (c5 == 0) {
                                    }
                                    intersection = Sets.intersection(vs2.f27944e, copyOf);
                                    if (intersection.isEmpty()) {
                                    }
                                    alignment2 = alignment;
                                }
                            } else {
                                if (str3.equals("before")) {
                                    c5 = 2;
                                    if (c5 == 0) {
                                    }
                                    intersection = Sets.intersection(vs2.f27944e, copyOf);
                                    if (intersection.isEmpty()) {
                                    }
                                    alignment2 = alignment;
                                }
                                c5 = 65535;
                                if (c5 == 0) {
                                }
                                intersection = Sets.intersection(vs2.f27944e, copyOf);
                                if (intersection.isEmpty()) {
                                }
                                alignment2 = alignment;
                            }
                            fx2Var2.f17443r = alignment2;
                            i = 1;
                            break;
                        }
                    }
                    str = str2;
                    fx2Var2.f17443r = alignment2;
                    i = 1;
                    break;
                case '\f':
                    String lowerCase6 = Ascii.toLowerCase(attributeValue);
                    lowerCase6.getClass();
                    if (!lowerCase6.equals("before")) {
                        if (lowerCase6.equals(str2)) {
                            fx2Var2 = m2855b(fx2Var2);
                            fx2Var2.f17439n = 2;
                        }
                    } else {
                        fx2Var2 = m2855b(fx2Var2);
                        fx2Var2.f17439n = 1;
                    }
                    str = str2;
                    i = 1;
                    break;
                case '\r':
                    fx2Var2 = m2855b(fx2Var2);
                    try {
                        fx2Var2.f17429d = ColorParser.parseTtmlColor(attributeValue);
                        fx2Var2.f17430e = true;
                    } catch (IllegalArgumentException unused3) {
                        ye0.m8279B("Failed parsing background value: ", attributeValue, "TtmlDecoder");
                    }
                    str = str2;
                    i = 1;
                    break;
                case 14:
                    fx2Var2 = m2855b(fx2Var2);
                    String lowerCase7 = Ascii.toLowerCase(attributeValue);
                    lowerCase7.getClass();
                    switch (lowerCase7.hashCode()) {
                        case -1364013995:
                            if (lowerCase7.equals("center")) {
                                c7 = 0;
                                break;
                            }
                            break;
                        case 100571:
                            if (lowerCase7.equals("end")) {
                                c7 = 1;
                                break;
                            }
                            break;
                        case 3317767:
                            if (lowerCase7.equals("left")) {
                                c7 = 2;
                                break;
                            }
                            break;
                        case 108511772:
                            if (lowerCase7.equals("right")) {
                                c7 = 3;
                                break;
                            }
                            break;
                        case 109757538:
                            if (lowerCase7.equals("start")) {
                                c7 = 4;
                                break;
                            }
                            break;
                    }
                    c7 = 65535;
                    switch (c7) {
                        case 0:
                            alignment2 = Layout.Alignment.ALIGN_CENTER;
                            break;
                        case 1:
                        case 3:
                            alignment2 = Layout.Alignment.ALIGN_OPPOSITE;
                            break;
                        case 2:
                        case 4:
                            alignment2 = Layout.Alignment.ALIGN_NORMAL;
                            break;
                    }
                    str = str2;
                    i = 1;
                    break;
                default:
                    str = str2;
                    i = 1;
                    break;
            }
            i6 += i;
            xmlPullParser2 = xmlPullParser;
            str2 = str;
        }
        return fx2Var2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bb, code lost:
    
        if (r13.equals("ms") == false) goto L21;
     */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long m2863j(String str, cx2 cx2Var) {
        double d;
        double d2;
        double d3;
        double d4;
        char c = 4;
        Matcher matcher = f11820p.matcher(str);
        if (matcher.matches()) {
            double parseLong = (Long.parseLong((String) Assertions.checkNotNull(matcher.group(1))) * 3600) + (Long.parseLong((String) Assertions.checkNotNull(matcher.group(2))) * 60) + Long.parseLong((String) Assertions.checkNotNull(matcher.group(3)));
            String group = matcher.group(4);
            double d5 = 0.0d;
            if (group != null) {
                d3 = Double.parseDouble(group);
            } else {
                d3 = 0.0d;
            }
            double d6 = parseLong + d3;
            String group2 = matcher.group(5);
            if (group2 != null) {
                d4 = ((float) Long.parseLong(group2)) / cx2Var.f16173a;
            } else {
                d4 = 0.0d;
            }
            double d7 = d6 + d4;
            if (matcher.group(6) != null) {
                d5 = (Long.parseLong(r13) / cx2Var.f16174b) / cx2Var.f16173a;
            }
            return (long) ((d7 + d5) * 1000000.0d);
        }
        Matcher matcher2 = f11821q.matcher(str);
        if (matcher2.matches()) {
            double parseDouble = Double.parseDouble((String) Assertions.checkNotNull(matcher2.group(1)));
            String str2 = (String) Assertions.checkNotNull(matcher2.group(2));
            str2.getClass();
            switch (str2.hashCode()) {
                case 102:
                    if (str2.equals("f")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 104:
                    if (str2.equals("h")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 109:
                    if (str2.equals("m")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 116:
                    if (str2.equals("t")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 3494:
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    d = cx2Var.f16173a;
                    parseDouble /= d;
                    break;
                case 1:
                    d2 = 3600.0d;
                    break;
                case 2:
                    d2 = 60.0d;
                    break;
                case 3:
                    d = cx2Var.f16175c;
                    parseDouble /= d;
                    break;
                case 4:
                    d = 1000.0d;
                    parseDouble /= d;
                    break;
            }
            parseDouble *= d2;
            return (long) (parseDouble * 1000000.0d);
        }
        throw new SubtitleDecoderException(AbstractC1726qj.m7038C("Malformed time expression: ", str));
    }

    /* renamed from: k */
    public static pl1 m2864k(XmlPullParser xmlPullParser) {
        String attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, "extent");
        if (attributeValue == null) {
            return null;
        }
        Matcher matcher = f11825u.matcher(attributeValue);
        if (!matcher.matches()) {
            Log.m3027w("TtmlDecoder", "Ignoring non-pixel tts extent: ".concat(attributeValue));
            return null;
        }
        try {
            return new pl1(Integer.parseInt((String) Assertions.checkNotNull(matcher.group(1))), Integer.parseInt((String) Assertions.checkNotNull(matcher.group(2))));
        } catch (NumberFormatException unused) {
            Log.m3027w("TtmlDecoder", "Ignoring malformed tts extent: ".concat(attributeValue));
            return null;
        }
    }

    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public Subtitle decode(byte[] bArr, int i, boolean z) {
        tx0 tx0Var;
        cx2 cx2Var;
        try {
            XmlPullParser newPullParser = this.f11829o.newPullParser();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            hashMap2.put("", new ex2("", -3.4028235E38f, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE));
            pl1 pl1Var = null;
            newPullParser.setInput(new ByteArrayInputStream(bArr, 0, i), null);
            ArrayDeque arrayDeque = new ArrayDeque();
            cx2 cx2Var2 = f11827w;
            tx0 tx0Var2 = f11828x;
            int i2 = 0;
            gx2 gx2Var = null;
            tx0 tx0Var3 = tx0Var2;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.getEventType()) {
                dx2 dx2Var = (dx2) arrayDeque.peek();
                if (i2 == 0) {
                    String name = newPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            cx2Var2 = m2859f(newPullParser);
                            tx0Var3 = m2857d(newPullParser, tx0Var2);
                            pl1Var = m2864k(newPullParser);
                        }
                        tx0 tx0Var4 = tx0Var3;
                        pl1 pl1Var2 = pl1Var;
                        cx2 cx2Var3 = cx2Var2;
                        if (!m2856c(name)) {
                            Log.m3025i("TtmlDecoder", "Ignoring unsupported tag: " + newPullParser.getName());
                            i2++;
                            tx0Var3 = tx0Var4;
                            cx2Var2 = cx2Var3;
                        } else {
                            if ("head".equals(name)) {
                                tx0Var = tx0Var4;
                                cx2Var = cx2Var3;
                                m2860g(newPullParser, hashMap, tx0Var4, pl1Var2, hashMap2, hashMap3);
                            } else {
                                tx0Var = tx0Var4;
                                cx2Var = cx2Var3;
                                try {
                                    dx2 m2861h = m2861h(newPullParser, dx2Var, hashMap2, cx2Var);
                                    arrayDeque.push(m2861h);
                                    if (dx2Var != null) {
                                        if (dx2Var.f16601m == null) {
                                            dx2Var.f16601m = new ArrayList();
                                        }
                                        dx2Var.f16601m.add(m2861h);
                                    }
                                } catch (SubtitleDecoderException e) {
                                    Log.m3028w("TtmlDecoder", "Suppressing parser error", e);
                                    i2++;
                                }
                            }
                            tx0Var3 = tx0Var;
                            cx2Var2 = cx2Var;
                        }
                        pl1Var = pl1Var2;
                    } else if (eventType == 4) {
                        dx2 dx2Var2 = (dx2) Assertions.checkNotNull(dx2Var);
                        dx2 m4633a = dx2.m4633a(newPullParser.getText());
                        if (dx2Var2.f16601m == null) {
                            dx2Var2.f16601m = new ArrayList();
                        }
                        dx2Var2.f16601m.add(m4633a);
                    } else if (eventType == 3) {
                        if (newPullParser.getName().equals("tt")) {
                            gx2Var = new gx2((dx2) Assertions.checkNotNull((dx2) arrayDeque.peek()), hashMap, hashMap2, hashMap3);
                        }
                        arrayDeque.pop();
                    }
                } else if (eventType == 2) {
                    i2++;
                } else if (eventType == 3) {
                    i2--;
                }
                newPullParser.next();
            }
            if (gx2Var != null) {
                return gx2Var;
            }
            throw new SubtitleDecoderException("No TTML subtitles found");
        } catch (IOException e2) {
            throw new IllegalStateException("Unexpected error when reading input.", e2);
        } catch (XmlPullParserException e3) {
            throw new SubtitleDecoderException("Unable to decode source", e3);
        }
    }
}
