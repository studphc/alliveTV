package com.google.android.exoplayer2.text.ssa;

import android.graphics.PointF;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p000.AbstractC1726qj;
import p000.km2;
import p000.lm2;
import p000.mm2;
import p000.nm2;
import p000.om2;

/* loaded from: classes.dex */
public final class SsaDecoder extends SimpleSubtitleDecoder {

    /* renamed from: t */
    public static final Pattern f11810t = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");

    /* renamed from: o */
    public final boolean f11811o;

    /* renamed from: p */
    public final km2 f11812p;

    /* renamed from: q */
    public LinkedHashMap f11813q;

    /* renamed from: r */
    public float f11814r;

    /* renamed from: s */
    public float f11815s;

    public SsaDecoder() {
        this(null);
    }

    /* renamed from: b */
    public static int m2851b(long j, ArrayList arrayList, ArrayList arrayList2) {
        int i;
        ArrayList arrayList3;
        int size = arrayList.size() - 1;
        while (true) {
            if (size >= 0) {
                if (((Long) arrayList.get(size)).longValue() == j) {
                    return size;
                }
                if (((Long) arrayList.get(size)).longValue() < j) {
                    i = size + 1;
                    break;
                }
                size--;
            } else {
                i = 0;
                break;
            }
        }
        arrayList.add(i, Long.valueOf(j));
        if (i == 0) {
            arrayList3 = new ArrayList();
        } else {
            arrayList3 = new ArrayList((Collection) arrayList2.get(i - 1));
        }
        arrayList2.add(i, arrayList3);
        return i;
    }

    /* renamed from: d */
    public static long m2852d(String str) {
        Matcher matcher = f11810t.matcher(str.trim());
        if (!matcher.matches()) {
            return C0643C.TIME_UNSET;
        }
        return (Long.parseLong((String) Util.castNonNull(matcher.group(4))) * 10000) + (Long.parseLong((String) Util.castNonNull(matcher.group(3))) * 1000000) + (Long.parseLong((String) Util.castNonNull(matcher.group(2))) * 60000000) + (Long.parseLong((String) Util.castNonNull(matcher.group(1))) * 3600000000L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x0297, code lost:
    
        if (r6 != 3) goto L158;
     */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0035 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0019 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x02ce  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2853c(ParsableByteArray parsableByteArray) {
        int i;
        int i2;
        nm2 nm2Var;
        int i3;
        Integer num;
        Integer num2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        String trim;
        int i5;
        int i6 = 6;
        int i7 = 7;
        int i8 = 2;
        int i9 = 0;
        while (true) {
            String readLine = parsableByteArray.readLine();
            if (readLine != null) {
                i = 91;
                if ("[Script Info]".equalsIgnoreCase(readLine)) {
                    while (true) {
                        String readLine2 = parsableByteArray.readLine();
                        if (readLine2 == null && (parsableByteArray.bytesLeft() == 0 || parsableByteArray.peekUnsignedByte() != 91)) {
                            String[] split = readLine2.split(":");
                            if (split.length != i8) {
                                String lowerCase = Ascii.toLowerCase(split[i9].trim());
                                lowerCase.getClass();
                                if (!lowerCase.equals("playresx")) {
                                    if (lowerCase.equals("playresy")) {
                                        try {
                                            this.f11815s = Float.parseFloat(split[1].trim());
                                        } catch (NumberFormatException unused) {
                                        }
                                    }
                                    String readLine22 = parsableByteArray.readLine();
                                    if (readLine22 == null) {
                                        break;
                                    }
                                    String[] split2 = readLine22.split(":");
                                    if (split2.length != i8) {
                                    }
                                } else {
                                    this.f11814r = Float.parseFloat(split2[1].trim());
                                }
                            }
                        }
                    }
                } else {
                    if ("[V4+ Styles]".equalsIgnoreCase(readLine)) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        lm2 lm2Var = null;
                        while (true) {
                            String readLine3 = parsableByteArray.readLine();
                            if (readLine3 != null && (parsableByteArray.bytesLeft() == 0 || parsableByteArray.peekUnsignedByte() != i)) {
                                if (readLine3.startsWith("Format:")) {
                                    String[] split3 = TextUtils.split(readLine3.substring(i7), ",");
                                    int i10 = -1;
                                    int i11 = -1;
                                    int i12 = -1;
                                    int i13 = -1;
                                    int i14 = -1;
                                    int i15 = -1;
                                    int i16 = -1;
                                    int i17 = -1;
                                    int i18 = -1;
                                    int i19 = -1;
                                    for (int i20 = i9; i20 < split3.length; i20++) {
                                        String lowerCase2 = Ascii.toLowerCase(split3[i20].trim());
                                        lowerCase2.getClass();
                                        switch (lowerCase2.hashCode()) {
                                            case -1178781136:
                                                if (lowerCase2.equals("italic")) {
                                                    i2 = i9;
                                                    break;
                                                }
                                                break;
                                            case -1026963764:
                                                if (lowerCase2.equals("underline")) {
                                                    i2 = 1;
                                                    break;
                                                }
                                                break;
                                            case -192095652:
                                                if (lowerCase2.equals("strikeout")) {
                                                    i2 = i8;
                                                    break;
                                                }
                                                break;
                                            case -70925746:
                                                if (lowerCase2.equals("primarycolour")) {
                                                    i2 = 3;
                                                    break;
                                                }
                                                break;
                                            case 3029637:
                                                if (lowerCase2.equals("bold")) {
                                                    i2 = 4;
                                                    break;
                                                }
                                                break;
                                            case 3373707:
                                                if (lowerCase2.equals(AppMeasurementSdk.ConditionalUserProperty.NAME)) {
                                                    i2 = 5;
                                                    break;
                                                }
                                                break;
                                            case 366554320:
                                                if (lowerCase2.equals("fontsize")) {
                                                    i2 = i6;
                                                    break;
                                                }
                                                break;
                                            case 767321349:
                                                if (lowerCase2.equals("borderstyle")) {
                                                    i2 = 7;
                                                    break;
                                                }
                                                break;
                                            case 1767875043:
                                                if (lowerCase2.equals("alignment")) {
                                                    i2 = 8;
                                                    break;
                                                }
                                                break;
                                            case 1988365454:
                                                if (lowerCase2.equals("outlinecolour")) {
                                                    i2 = 9;
                                                    break;
                                                }
                                                break;
                                        }
                                        i2 = -1;
                                        switch (i2) {
                                            case 0:
                                                i16 = i20;
                                                break;
                                            case 1:
                                                i17 = i20;
                                                break;
                                            case 2:
                                                i18 = i20;
                                                break;
                                            case 3:
                                                i12 = i20;
                                                break;
                                            case 4:
                                                i15 = i20;
                                                break;
                                            case 5:
                                                i10 = i20;
                                                break;
                                            case 6:
                                                i14 = i20;
                                                break;
                                            case 7:
                                                i19 = i20;
                                                break;
                                            case 8:
                                                i11 = i20;
                                                break;
                                            case 9:
                                                i13 = i20;
                                                break;
                                        }
                                    }
                                    if (i10 != -1) {
                                        lm2Var = new lm2(i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, split3.length);
                                    } else {
                                        lm2Var = null;
                                    }
                                    i7 = 7;
                                } else {
                                    if (readLine3.startsWith("Style:")) {
                                        if (lm2Var == null) {
                                            Log.m3027w("SsaDecoder", "Skipping 'Style:' line before 'Format:' line: ".concat(readLine3));
                                        } else {
                                            Assertions.checkArgument(readLine3.startsWith("Style:"));
                                            String[] split4 = TextUtils.split(readLine3.substring(i6), ",");
                                            int length = split4.length;
                                            int i21 = lm2Var.f22575k;
                                            if (length != i21) {
                                                Integer valueOf = Integer.valueOf(i21);
                                                Integer valueOf2 = Integer.valueOf(split4.length);
                                                Object[] objArr = new Object[3];
                                                objArr[i9] = valueOf;
                                                objArr[1] = valueOf2;
                                                objArr[i8] = readLine3;
                                                Log.m3027w("SsaStyle", Util.formatInvariant("Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", objArr));
                                            } else {
                                                try {
                                                    String trim2 = split4[lm2Var.f22565a].trim();
                                                    int i22 = lm2Var.f22566b;
                                                    if (i22 != -1) {
                                                        i3 = nm2.m6386a(split4[i22].trim());
                                                    } else {
                                                        i3 = -1;
                                                    }
                                                    int i23 = lm2Var.f22567c;
                                                    if (i23 != -1) {
                                                        num = nm2.m6388c(split4[i23].trim());
                                                    } else {
                                                        num = null;
                                                    }
                                                    int i24 = lm2Var.f22568d;
                                                    if (i24 != -1) {
                                                        num2 = nm2.m6388c(split4[i24].trim());
                                                    } else {
                                                        num2 = null;
                                                    }
                                                    int i25 = lm2Var.f22569e;
                                                    float f = -3.4028235E38f;
                                                    if (i25 != -1) {
                                                        String trim3 = split4[i25].trim();
                                                        try {
                                                            f = Float.parseFloat(trim3);
                                                        } catch (NumberFormatException e) {
                                                            Log.m3028w("SsaStyle", "Failed to parse font size: '" + trim3 + "'", e);
                                                        }
                                                    }
                                                    float f2 = f;
                                                    int i26 = lm2Var.f22570f;
                                                    if (i26 != -1 && nm2.m6387b(split4[i26].trim())) {
                                                        z = true;
                                                    } else {
                                                        z = false;
                                                    }
                                                    int i27 = lm2Var.f22571g;
                                                    if (i27 != -1 && nm2.m6387b(split4[i27].trim())) {
                                                        z2 = true;
                                                    } else {
                                                        z2 = false;
                                                    }
                                                    int i28 = lm2Var.f22572h;
                                                    if (i28 != -1 && nm2.m6387b(split4[i28].trim())) {
                                                        z3 = true;
                                                    } else {
                                                        z3 = false;
                                                    }
                                                    int i29 = lm2Var.f22573i;
                                                    if (i29 != -1 && nm2.m6387b(split4[i29].trim())) {
                                                        z4 = true;
                                                    } else {
                                                        z4 = false;
                                                    }
                                                    int i30 = lm2Var.f22574j;
                                                    if (i30 != -1) {
                                                        trim = split4[i30].trim();
                                                        try {
                                                            i5 = Integer.parseInt(trim.trim());
                                                            if (i5 != 1) {
                                                            }
                                                        } catch (NumberFormatException unused2) {
                                                        }
                                                        i4 = i5;
                                                    } else {
                                                        i4 = -1;
                                                    }
                                                    nm2Var = new nm2(trim2, i3, num, num2, f2, z, z2, z3, z4, i4);
                                                } catch (RuntimeException e2) {
                                                    Log.m3028w("SsaStyle", "Skipping malformed 'Style:' line: '" + readLine3 + "'", e2);
                                                }
                                                if (nm2Var != null) {
                                                    linkedHashMap.put(nm2Var.f23408a, nm2Var);
                                                }
                                            }
                                            nm2Var = null;
                                            if (nm2Var != null) {
                                            }
                                        }
                                    }
                                    i6 = 6;
                                    i7 = 7;
                                    i8 = 2;
                                    i9 = 0;
                                    i = 91;
                                }
                            }
                        }
                        this.f11813q = linkedHashMap;
                    } else if ("[V4 Styles]".equalsIgnoreCase(readLine)) {
                        Log.m3025i("SsaDecoder", "[V4 Styles] are not supported");
                    } else if ("[Events]".equalsIgnoreCase(readLine)) {
                        return;
                    }
                    i6 = 6;
                    i7 = 7;
                    i8 = 2;
                    i9 = 0;
                }
            } else {
                return;
            }
        }
        Log.m3027w("SsaStyle", "Ignoring unknown BorderStyle: " + trim);
        i5 = -1;
        i4 = i5;
        nm2Var = new nm2(trim2, i3, num, num2, f2, z, z2, z3, z4, i4);
        if (nm2Var != null) {
        }
        i6 = 6;
        i7 = 7;
        i8 = 2;
        i9 = 0;
        i = 91;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:93:0x0224. Please report as an issue. */
    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public Subtitle decode(byte[] bArr, int i, boolean z) {
        km2 km2Var;
        ParsableByteArray parsableByteArray;
        km2 km2Var2;
        nm2 nm2Var;
        long j;
        Layout.Alignment alignment;
        int i2;
        int i3;
        int i4;
        float f;
        int i5;
        int i6;
        Integer num;
        int i7;
        int i8;
        SsaDecoder ssaDecoder = this;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ParsableByteArray parsableByteArray2 = new ParsableByteArray(bArr, i);
        boolean z2 = ssaDecoder.f11811o;
        if (!z2) {
            ssaDecoder.m2853c(parsableByteArray2);
        }
        if (z2) {
            km2Var = ssaDecoder.f11812p;
        } else {
            km2Var = null;
        }
        while (true) {
            String readLine = parsableByteArray2.readLine();
            if (readLine != null) {
                if (readLine.startsWith("Format:")) {
                    km2Var = km2.m5564a(readLine);
                } else {
                    if (readLine.startsWith("Dialogue:")) {
                        if (km2Var == null) {
                            Log.m3027w("SsaDecoder", "Skipping dialogue line before complete format: ".concat(readLine));
                        } else {
                            Assertions.checkArgument(readLine.startsWith("Dialogue:"));
                            String substring = readLine.substring(9);
                            int i9 = km2Var.f20904e;
                            String[] split = substring.split(",", i9);
                            if (split.length != i9) {
                                Log.m3027w("SsaDecoder", "Skipping dialogue line with fewer columns than format: ".concat(readLine));
                            } else {
                                long m2852d = m2852d(split[km2Var.f20900a]);
                                if (m2852d == C0643C.TIME_UNSET) {
                                    Log.m3027w("SsaDecoder", "Skipping invalid timing: ".concat(readLine));
                                } else {
                                    long m2852d2 = m2852d(split[km2Var.f20901b]);
                                    if (m2852d2 == C0643C.TIME_UNSET) {
                                        Log.m3027w("SsaDecoder", "Skipping invalid timing: ".concat(readLine));
                                    } else {
                                        LinkedHashMap linkedHashMap = ssaDecoder.f11813q;
                                        if (linkedHashMap != null && (i8 = km2Var.f20902c) != -1) {
                                            nm2Var = (nm2) linkedHashMap.get(split[i8].trim());
                                        } else {
                                            nm2Var = null;
                                        }
                                        String str = split[km2Var.f20903d];
                                        Matcher matcher = mm2.f22985a.matcher(str);
                                        int i10 = -1;
                                        PointF pointF = null;
                                        while (matcher.find()) {
                                            String str2 = (String) Assertions.checkNotNull(matcher.group(1));
                                            try {
                                                PointF m6190a = mm2.m6190a(str2);
                                                if (m6190a != null) {
                                                    pointF = m6190a;
                                                }
                                            } catch (RuntimeException unused) {
                                            }
                                            ParsableByteArray parsableByteArray3 = parsableByteArray2;
                                            try {
                                                Matcher matcher2 = mm2.f22988d.matcher(str2);
                                                if (matcher2.find()) {
                                                    i7 = nm2.m6386a((String) Assertions.checkNotNull(matcher2.group(1)));
                                                } else {
                                                    i7 = -1;
                                                }
                                                if (i7 != -1) {
                                                    i10 = i7;
                                                }
                                            } catch (RuntimeException unused2) {
                                            }
                                            parsableByteArray2 = parsableByteArray3;
                                        }
                                        parsableByteArray = parsableByteArray2;
                                        String replace = mm2.f22985a.matcher(str).replaceAll("").replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " ");
                                        float f2 = ssaDecoder.f11814r;
                                        float f3 = ssaDecoder.f11815s;
                                        SpannableString spannableString = new SpannableString(replace);
                                        Cue.Builder text = new Cue.Builder().setText(spannableString);
                                        if (nm2Var != null) {
                                            Integer num2 = nm2Var.f23410c;
                                            km2Var2 = km2Var;
                                            if (num2 != null) {
                                                j = m2852d2;
                                                spannableString.setSpan(new ForegroundColorSpan(num2.intValue()), 0, spannableString.length(), 33);
                                            } else {
                                                j = m2852d2;
                                            }
                                            if (nm2Var.f23417j == 3 && (num = nm2Var.f23411d) != null) {
                                                spannableString.setSpan(new BackgroundColorSpan(num.intValue()), 0, spannableString.length(), 33);
                                            }
                                            float f4 = nm2Var.f23412e;
                                            if (f4 != -3.4028235E38f && f3 != -3.4028235E38f) {
                                                text.setTextSize(f4 / f3, 1);
                                            }
                                            boolean z3 = nm2Var.f23414g;
                                            boolean z4 = nm2Var.f23413f;
                                            if (z4 && z3) {
                                                i5 = 0;
                                                i6 = 33;
                                                spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
                                            } else {
                                                i5 = 0;
                                                i6 = 33;
                                                if (z4) {
                                                    spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
                                                } else if (z3) {
                                                    spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
                                                }
                                            }
                                            if (nm2Var.f23415h) {
                                                spannableString.setSpan(new UnderlineSpan(), i5, spannableString.length(), i6);
                                            }
                                            if (nm2Var.f23416i) {
                                                spannableString.setSpan(new StrikethroughSpan(), i5, spannableString.length(), i6);
                                            }
                                        } else {
                                            km2Var2 = km2Var;
                                            j = m2852d2;
                                        }
                                        int i11 = -1;
                                        if (i10 != -1) {
                                            i11 = i10;
                                        } else if (nm2Var != null) {
                                            i11 = nm2Var.f23409b;
                                        }
                                        switch (i11) {
                                            case -1:
                                                break;
                                            case 0:
                                            default:
                                                AbstractC1726qj.m7036A(i11, "Unknown alignment: ", "SsaDecoder");
                                                break;
                                            case 1:
                                            case 4:
                                            case 7:
                                                alignment = Layout.Alignment.ALIGN_NORMAL;
                                                break;
                                            case 2:
                                            case 5:
                                            case 8:
                                                alignment = Layout.Alignment.ALIGN_CENTER;
                                                break;
                                            case 3:
                                            case 6:
                                            case 9:
                                                alignment = Layout.Alignment.ALIGN_OPPOSITE;
                                                break;
                                        }
                                        alignment = null;
                                        Cue.Builder textAlignment = text.setTextAlignment(alignment);
                                        int i12 = Integer.MIN_VALUE;
                                        switch (i11) {
                                            case -1:
                                                break;
                                            case 0:
                                            default:
                                                AbstractC1726qj.m7036A(i11, "Unknown alignment: ", "SsaDecoder");
                                                break;
                                            case 1:
                                            case 4:
                                            case 7:
                                                i2 = 0;
                                                break;
                                            case 2:
                                            case 5:
                                            case 8:
                                                i2 = 1;
                                                break;
                                            case 3:
                                            case 6:
                                            case 9:
                                                i2 = 2;
                                                break;
                                        }
                                        i2 = Integer.MIN_VALUE;
                                        Cue.Builder positionAnchor = textAlignment.setPositionAnchor(i2);
                                        switch (i11) {
                                            case -1:
                                                break;
                                            case 0:
                                            default:
                                                AbstractC1726qj.m7036A(i11, "Unknown alignment: ", "SsaDecoder");
                                                break;
                                            case 1:
                                            case 2:
                                            case 3:
                                                i12 = 2;
                                                break;
                                            case 4:
                                            case 5:
                                            case 6:
                                                i12 = 1;
                                                break;
                                            case 7:
                                            case 8:
                                            case 9:
                                                i12 = 0;
                                                break;
                                        }
                                        positionAnchor.setLineAnchor(i12);
                                        if (pointF != null && f3 != -3.4028235E38f && f2 != -3.4028235E38f) {
                                            text.setPosition(pointF.x / f2);
                                            text.setLine(pointF.y / f3, 0);
                                        } else {
                                            int positionAnchor2 = text.getPositionAnchor();
                                            float f5 = 0.05f;
                                            if (positionAnchor2 != 0) {
                                                i3 = 1;
                                                if (positionAnchor2 != 1) {
                                                    i4 = 2;
                                                    if (positionAnchor2 != 2) {
                                                        f = -3.4028235E38f;
                                                    } else {
                                                        f = 0.95f;
                                                    }
                                                } else {
                                                    i4 = 2;
                                                    f = 0.5f;
                                                }
                                            } else {
                                                i3 = 1;
                                                i4 = 2;
                                                f = 0.05f;
                                            }
                                            text.setPosition(f);
                                            int lineAnchor = text.getLineAnchor();
                                            if (lineAnchor != 0) {
                                                if (lineAnchor != i3) {
                                                    if (lineAnchor != i4) {
                                                        f5 = -3.4028235E38f;
                                                    } else {
                                                        f5 = 0.95f;
                                                    }
                                                } else {
                                                    f5 = 0.5f;
                                                }
                                            }
                                            text.setLine(f5, 0);
                                        }
                                        Cue build = text.build();
                                        int m2851b = m2851b(j, arrayList2, arrayList);
                                        for (int m2851b2 = m2851b(m2852d, arrayList2, arrayList); m2851b2 < m2851b; m2851b2++) {
                                            ((List) arrayList.get(m2851b2)).add(build);
                                        }
                                        ssaDecoder = this;
                                        parsableByteArray2 = parsableByteArray;
                                        km2Var = km2Var2;
                                    }
                                }
                            }
                        }
                    }
                    parsableByteArray = parsableByteArray2;
                    km2Var2 = km2Var;
                    ssaDecoder = this;
                    parsableByteArray2 = parsableByteArray;
                    km2Var = km2Var2;
                }
            } else {
                return new om2(0, arrayList, arrayList2);
            }
        }
    }

    public SsaDecoder(@Nullable List<byte[]> list) {
        super("SsaDecoder");
        this.f11814r = -3.4028235E38f;
        this.f11815s = -3.4028235E38f;
        if (list != null && !list.isEmpty()) {
            this.f11811o = true;
            String fromUtf8Bytes = Util.fromUtf8Bytes(list.get(0));
            Assertions.checkArgument(fromUtf8Bytes.startsWith("Format:"));
            this.f11812p = (km2) Assertions.checkNotNull(km2.m5564a(fromUtf8Bytes));
            m2853c(new ParsableByteArray(list.get(1)));
            return;
        }
        this.f11811o = false;
        this.f11812p = null;
    }
}
