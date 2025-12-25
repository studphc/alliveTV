package com.google.android.exoplayer2.text.webvtt;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.span.HorizontalTextInVerticalContextSpan;
import com.google.android.exoplayer2.text.span.RubySpan;
import com.google.android.exoplayer2.text.span.SpanUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import p000.a53;
import p000.b53;
import p000.c53;
import p000.z43;

/* loaded from: classes.dex */
public final class WebvttCueParser {
    public static final Pattern CUE_HEADER_PATTERN = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");

    /* renamed from: a */
    public static final Pattern f11855a = Pattern.compile("(\\S+?):(\\S+)");

    /* renamed from: b */
    public static final Map f11856b;

    /* renamed from: c */
    public static final Map f11857c;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("white", Integer.valueOf(Color.rgb(255, 255, 255)));
        hashMap.put("lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        hashMap.put("cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        hashMap.put("red", Integer.valueOf(Color.rgb(255, 0, 0)));
        hashMap.put("yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        hashMap.put("magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        hashMap.put("blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        hashMap.put("black", Integer.valueOf(Color.rgb(0, 0, 0)));
        f11856b = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("bg_white", Integer.valueOf(Color.rgb(255, 255, 255)));
        hashMap2.put("bg_lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        hashMap2.put("bg_cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        hashMap2.put("bg_red", Integer.valueOf(Color.rgb(255, 0, 0)));
        hashMap2.put("bg_yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        hashMap2.put("bg_magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        hashMap2.put("bg_blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        hashMap2.put("bg_black", Integer.valueOf(Color.rgb(0, 0, 0)));
        f11857c = Collections.unmodifiableMap(hashMap2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: a */
    public static void m2868a(String str, a53 a53Var, List list, SpannableStringBuilder spannableStringBuilder, List list2) {
        char c;
        int i = a53Var.f47b;
        int length = spannableStringBuilder.length();
        String str2 = a53Var.f46a;
        str2.getClass();
        int i2 = -1;
        switch (str2.hashCode()) {
            case 0:
                if (str2.equals("")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 98:
                if (str2.equals("b")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 99:
                if (str2.equals("c")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 105:
                if (str2.equals("i")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 117:
                if (str2.equals("u")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 118:
                if (str2.equals("v")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 3314158:
                if (str2.equals("lang")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 3511770:
                if (str2.equals("ruby")) {
                    c = 7;
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
            case 5:
            case 6:
                break;
            case 1:
                spannableStringBuilder.setSpan(new StyleSpan(1), i, length, 33);
                break;
            case 2:
                for (String str3 : a53Var.f49d) {
                    Map map = f11856b;
                    if (map.containsKey(str3)) {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(((Integer) map.get(str3)).intValue()), i, length, 33);
                    } else {
                        Map map2 = f11857c;
                        if (map2.containsKey(str3)) {
                            spannableStringBuilder.setSpan(new BackgroundColorSpan(((Integer) map2.get(str3)).intValue()), i, length, 33);
                        }
                    }
                }
                break;
            case 3:
                spannableStringBuilder.setSpan(new StyleSpan(2), i, length, 33);
                break;
            case 4:
                spannableStringBuilder.setSpan(new UnderlineSpan(), i, length, 33);
                break;
            case 7:
                int m2870c = m2870c(list2, str, a53Var);
                ArrayList arrayList = new ArrayList(list.size());
                arrayList.addAll(list);
                Collections.sort(arrayList, z43.f29246c);
                int i3 = a53Var.f47b;
                int i4 = 0;
                int i5 = 0;
                while (i4 < arrayList.size()) {
                    if ("rt".equals(((z43) arrayList.get(i4)).f29247a.f46a)) {
                        z43 z43Var = (z43) arrayList.get(i4);
                        int m2870c2 = m2870c(list2, str, z43Var.f29247a);
                        if (m2870c2 == i2) {
                            if (m2870c != i2) {
                                m2870c2 = m2870c;
                            } else {
                                m2870c2 = 1;
                            }
                        }
                        int i6 = z43Var.f29247a.f47b - i5;
                        int i7 = z43Var.f29248b - i5;
                        CharSequence subSequence = spannableStringBuilder.subSequence(i6, i7);
                        spannableStringBuilder.delete(i6, i7);
                        spannableStringBuilder.setSpan(new RubySpan(subSequence.toString(), m2870c2), i3, i6, 33);
                        i5 = subSequence.length() + i5;
                        i3 = i6;
                    }
                    i4++;
                    i2 = -1;
                }
                break;
            default:
                return;
        }
        ArrayList m2869b = m2869b(list2, str, a53Var);
        for (int i8 = 0; i8 < m2869b.size(); i8++) {
            WebvttCssStyle webvttCssStyle = ((b53) m2869b.get(i8)).f7904b;
            if (webvttCssStyle.getStyle() != -1) {
                SpanUtil.addOrReplaceSpan(spannableStringBuilder, new StyleSpan(webvttCssStyle.getStyle()), i, length, 33);
            }
            if (webvttCssStyle.isLinethrough()) {
                spannableStringBuilder.setSpan(new StrikethroughSpan(), i, length, 33);
            }
            if (webvttCssStyle.isUnderline()) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i, length, 33);
            }
            if (webvttCssStyle.hasFontColor()) {
                SpanUtil.addOrReplaceSpan(spannableStringBuilder, new ForegroundColorSpan(webvttCssStyle.getFontColor()), i, length, 33);
            }
            if (webvttCssStyle.hasBackgroundColor()) {
                SpanUtil.addOrReplaceSpan(spannableStringBuilder, new BackgroundColorSpan(webvttCssStyle.getBackgroundColor()), i, length, 33);
            }
            if (webvttCssStyle.getFontFamily() != null) {
                SpanUtil.addOrReplaceSpan(spannableStringBuilder, new TypefaceSpan(webvttCssStyle.getFontFamily()), i, length, 33);
            }
            int fontSizeUnit = webvttCssStyle.getFontSizeUnit();
            if (fontSizeUnit != 1) {
                if (fontSizeUnit != 2) {
                    if (fontSizeUnit == 3) {
                        SpanUtil.addOrReplaceSpan(spannableStringBuilder, new RelativeSizeSpan(webvttCssStyle.getFontSize() / 100.0f), i, length, 33);
                    }
                } else {
                    SpanUtil.addOrReplaceSpan(spannableStringBuilder, new RelativeSizeSpan(webvttCssStyle.getFontSize()), i, length, 33);
                }
            } else {
                SpanUtil.addOrReplaceSpan(spannableStringBuilder, new AbsoluteSizeSpan((int) webvttCssStyle.getFontSize(), true), i, length, 33);
            }
            if (webvttCssStyle.getCombineUpright()) {
                spannableStringBuilder.setSpan(new HorizontalTextInVerticalContextSpan(), i, length, 33);
            }
        }
    }

    /* renamed from: b */
    public static ArrayList m2869b(List list, String str, a53 a53Var) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            WebvttCssStyle webvttCssStyle = (WebvttCssStyle) list.get(i);
            int specificityScore = webvttCssStyle.getSpecificityScore(str, a53Var.f46a, a53Var.f49d, a53Var.f48c);
            if (specificityScore > 0) {
                arrayList.add(new b53(specificityScore, webvttCssStyle));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /* renamed from: c */
    public static int m2870c(List list, String str, a53 a53Var) {
        ArrayList m2869b = m2869b(list, str, a53Var);
        for (int i = 0; i < m2869b.size(); i++) {
            WebvttCssStyle webvttCssStyle = ((b53) m2869b.get(i)).f7904b;
            if (webvttCssStyle.getRubyPosition() != -1) {
                return webvttCssStyle.getRubyPosition();
            }
        }
        return -1;
    }

    /* renamed from: d */
    public static WebvttCueInfo m2871d(String str, Matcher matcher, ParsableByteArray parsableByteArray, List list) {
        c53 c53Var = new c53();
        try {
            c53Var.f8255a = WebvttParserUtil.parseTimestampUs((String) Assertions.checkNotNull(matcher.group(1)));
            c53Var.f8256b = WebvttParserUtil.parseTimestampUs((String) Assertions.checkNotNull(matcher.group(2)));
            m2872e((String) Assertions.checkNotNull(matcher.group(3)), c53Var);
            StringBuilder sb = new StringBuilder();
            String readLine = parsableByteArray.readLine();
            while (!TextUtils.isEmpty(readLine)) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(readLine.trim());
                readLine = parsableByteArray.readLine();
            }
            c53Var.f8257c = m2873f(str, sb.toString(), list);
            return new WebvttCueInfo(c53Var.m2204a().build(), c53Var.f8255a, c53Var.f8256b);
        } catch (NumberFormatException unused) {
            Log.m3027w("WebvttCueParser", "Skipping cue with bad header: " + matcher.group());
            return null;
        }
    }

    /* renamed from: e */
    public static void m2872e(String str, c53 c53Var) {
        char c;
        int i;
        char c2;
        int i2;
        int i3;
        Matcher matcher = f11855a.matcher(str);
        while (matcher.find()) {
            String str2 = (String) Assertions.checkNotNull(matcher.group(1));
            String str3 = (String) Assertions.checkNotNull(matcher.group(2));
            try {
                if ("line".equals(str2)) {
                    m2874g(str3, c53Var);
                } else if ("align".equals(str2)) {
                    str3.getClass();
                    switch (str3.hashCode()) {
                        case -1364013995:
                            if (str3.equals("center")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -1074341483:
                            if (str3.equals("middle")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 100571:
                            if (str3.equals("end")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 3317767:
                            if (str3.equals("left")) {
                                c = 3;
                                break;
                            }
                            break;
                        case 108511772:
                            if (str3.equals("right")) {
                                c = 4;
                                break;
                            }
                            break;
                        case 109757538:
                            if (str3.equals("start")) {
                                c = 5;
                                break;
                            }
                            break;
                    }
                    c = 65535;
                    switch (c) {
                        case 0:
                        case 1:
                            break;
                        case 2:
                            i = 3;
                            break;
                        case 3:
                            i = 4;
                            break;
                        case 4:
                            i = 5;
                            break;
                        case 5:
                            i = 1;
                            break;
                        default:
                            Log.m3027w("WebvttCueParser", "Invalid alignment value: ".concat(str3));
                            break;
                    }
                    i = 2;
                    c53Var.f8258d = i;
                } else if ("position".equals(str2)) {
                    int indexOf = str3.indexOf(44);
                    if (indexOf != -1) {
                        String substring = str3.substring(indexOf + 1);
                        substring.getClass();
                        switch (substring.hashCode()) {
                            case -1842484672:
                                if (substring.equals("line-left")) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                            case -1364013995:
                                if (substring.equals("center")) {
                                    c2 = 1;
                                    break;
                                }
                                break;
                            case -1276788989:
                                if (substring.equals("line-right")) {
                                    c2 = 2;
                                    break;
                                }
                                break;
                            case -1074341483:
                                if (substring.equals("middle")) {
                                    c2 = 3;
                                    break;
                                }
                                break;
                            case 100571:
                                if (substring.equals("end")) {
                                    c2 = 4;
                                    break;
                                }
                                break;
                            case 109757538:
                                if (substring.equals("start")) {
                                    c2 = 5;
                                    break;
                                }
                                break;
                        }
                        c2 = 65535;
                        switch (c2) {
                            case 0:
                            case 5:
                                i2 = 0;
                                break;
                            case 1:
                            case 3:
                                i2 = 1;
                                break;
                            case 2:
                            case 4:
                                i2 = 2;
                                break;
                            default:
                                Log.m3027w("WebvttCueParser", "Invalid anchor value: ".concat(substring));
                                i2 = Integer.MIN_VALUE;
                                break;
                        }
                        c53Var.f8263i = i2;
                        str3 = str3.substring(0, indexOf);
                    }
                    c53Var.f8262h = WebvttParserUtil.parsePercentage(str3);
                } else if ("size".equals(str2)) {
                    c53Var.f8264j = WebvttParserUtil.parsePercentage(str3);
                } else if ("vertical".equals(str2)) {
                    str3.getClass();
                    if (!str3.equals("lr")) {
                        if (!str3.equals("rl")) {
                            Log.m3027w("WebvttCueParser", "Invalid 'vertical' value: ".concat(str3));
                            i3 = Integer.MIN_VALUE;
                        } else {
                            i3 = 1;
                        }
                    } else {
                        i3 = 2;
                    }
                    c53Var.f8265k = i3;
                } else {
                    Log.m3027w("WebvttCueParser", "Unknown cue setting " + str2 + ":" + str3);
                }
            } catch (NumberFormatException unused) {
                Log.m3027w("WebvttCueParser", "Skipping bad cue setting: " + matcher.group());
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x009b. Please report as an issue. */
    /* renamed from: f */
    public static SpannedString m2873f(String str, String str2, List list) {
        int i;
        char c;
        int i2;
        int i3;
        int i4;
        int i5;
        char c2;
        int i6 = 1;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayList arrayList = new ArrayList();
        int i7 = 0;
        while (true) {
            String str3 = "";
            if (i7 < str2.length()) {
                char charAt = str2.charAt(i7);
                if (charAt != '&') {
                    if (charAt != '<') {
                        spannableStringBuilder.append(charAt);
                        i7 += i6;
                    } else {
                        int i8 = i7 + 1;
                        if (i8 < str2.length()) {
                            if (str2.charAt(i8) == '/') {
                                i2 = i6;
                            } else {
                                i2 = 0;
                            }
                            int indexOf = str2.indexOf(62, i8);
                            if (indexOf == -1) {
                                i8 = str2.length();
                            } else {
                                i8 = indexOf + i6;
                            }
                            int i9 = i8 - 2;
                            if (str2.charAt(i9) == '/') {
                                i3 = i6;
                            } else {
                                i3 = 0;
                            }
                            if (i2 != 0) {
                                i4 = 2;
                            } else {
                                i4 = i6;
                            }
                            int i10 = i7 + i4;
                            if (i3 == 0) {
                                i9 = i8 - 1;
                            }
                            String substring = str2.substring(i10, i9);
                            if (!substring.trim().isEmpty()) {
                                String trim = substring.trim();
                                Assertions.checkArgument(trim.isEmpty() ^ i6);
                                String str4 = Util.splitAtFirst(trim, "[ \\.]")[0];
                                str4.getClass();
                                switch (str4.hashCode()) {
                                    case 98:
                                        if (str4.equals("b")) {
                                            i5 = 0;
                                            break;
                                        }
                                        i5 = -1;
                                        break;
                                    case 99:
                                        if (str4.equals("c")) {
                                            i5 = i6;
                                            break;
                                        }
                                        i5 = -1;
                                        break;
                                    case 105:
                                        if (str4.equals("i")) {
                                            i5 = 2;
                                            break;
                                        }
                                        i5 = -1;
                                        break;
                                    case 117:
                                        if (str4.equals("u")) {
                                            i5 = 3;
                                            break;
                                        }
                                        i5 = -1;
                                        break;
                                    case 118:
                                        if (str4.equals("v")) {
                                            i5 = 4;
                                            break;
                                        }
                                        i5 = -1;
                                        break;
                                    case 3650:
                                        if (str4.equals("rt")) {
                                            i5 = 5;
                                            break;
                                        }
                                        i5 = -1;
                                        break;
                                    case 3314158:
                                        if (str4.equals("lang")) {
                                            i5 = 6;
                                            break;
                                        }
                                        i5 = -1;
                                        break;
                                    case 3511770:
                                        if (str4.equals("ruby")) {
                                            i5 = 7;
                                            break;
                                        }
                                        i5 = -1;
                                        break;
                                    default:
                                        i5 = -1;
                                        break;
                                }
                                switch (i5) {
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                        if (i2 == 0) {
                                            if (i3 == 0) {
                                                int length = spannableStringBuilder.length();
                                                String trim2 = substring.trim();
                                                Assertions.checkArgument(trim2.isEmpty() ^ i6);
                                                int indexOf2 = trim2.indexOf(" ");
                                                if (indexOf2 == -1) {
                                                    c2 = 0;
                                                } else {
                                                    str3 = trim2.substring(indexOf2).trim();
                                                    c2 = 0;
                                                    trim2 = trim2.substring(0, indexOf2);
                                                }
                                                String[] split = Util.split(trim2, "\\.");
                                                String str5 = split[c2];
                                                HashSet hashSet = new HashSet();
                                                for (int i11 = i6; i11 < split.length; i11 += i6) {
                                                    hashSet.add(split[i11]);
                                                }
                                                arrayDeque.push(new a53(str5, length, str3, hashSet));
                                                break;
                                            }
                                        }
                                        while (!arrayDeque.isEmpty()) {
                                            a53 a53Var = (a53) arrayDeque.pop();
                                            m2868a(str, a53Var, arrayList, spannableStringBuilder, list);
                                            if (!arrayDeque.isEmpty()) {
                                                arrayList.add(new z43(a53Var, spannableStringBuilder.length()));
                                            } else {
                                                arrayList.clear();
                                            }
                                            if (a53Var.f46a.equals(str4)) {
                                                break;
                                            }
                                        }
                                        break;
                                }
                            }
                            i7 = i8;
                            continue;
                        }
                        i7 = i8;
                    }
                    i = i6;
                } else {
                    i7 += i6;
                    int indexOf3 = str2.indexOf(59, i7);
                    int indexOf4 = str2.indexOf(32, i7);
                    if (indexOf3 == -1) {
                        indexOf3 = indexOf4;
                    } else if (indexOf4 != -1) {
                        indexOf3 = Math.min(indexOf3, indexOf4);
                    }
                    if (indexOf3 != -1) {
                        String substring2 = str2.substring(i7, indexOf3);
                        substring2.getClass();
                        switch (substring2.hashCode()) {
                            case 3309:
                                if (substring2.equals("gt")) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case 3464:
                                if (substring2.equals("lt")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case 96708:
                                if (substring2.equals("amp")) {
                                    c = 2;
                                    break;
                                }
                                break;
                            case 3374865:
                                if (substring2.equals("nbsp")) {
                                    c = 3;
                                    break;
                                }
                                break;
                        }
                        c = 65535;
                        switch (c) {
                            case 0:
                                spannableStringBuilder.append(Typography.greater);
                                break;
                            case 1:
                                spannableStringBuilder.append(Typography.less);
                                break;
                            case 2:
                                spannableStringBuilder.append(Typography.amp);
                                break;
                            case 3:
                                spannableStringBuilder.append(' ');
                                break;
                            default:
                                Log.m3027w("WebvttCueParser", "ignoring unsupported entity: '&" + substring2 + ";'");
                                break;
                        }
                        if (indexOf3 == indexOf4) {
                            spannableStringBuilder.append((CharSequence) " ");
                        }
                        i = 1;
                        i7 = indexOf3 + 1;
                    } else {
                        i = 1;
                        spannableStringBuilder.append(charAt);
                    }
                }
                i6 = i;
            } else {
                while (!arrayDeque.isEmpty()) {
                    m2868a(str, (a53) arrayDeque.pop(), arrayList, spannableStringBuilder, list);
                }
                m2868a(str, new a53("", 0, "", Collections.emptySet()), Collections.emptyList(), spannableStringBuilder, list);
                return SpannedString.valueOf(spannableStringBuilder);
            }
        }
    }

    /* renamed from: g */
    public static void m2874g(String str, c53 c53Var) {
        int i = 2;
        int indexOf = str.indexOf(44);
        char c = 65535;
        if (indexOf != -1) {
            String substring = str.substring(indexOf + 1);
            substring.getClass();
            switch (substring.hashCode()) {
                case -1364013995:
                    if (substring.equals("center")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1074341483:
                    if (substring.equals("middle")) {
                        c = 1;
                        break;
                    }
                    break;
                case 100571:
                    if (substring.equals("end")) {
                        c = 2;
                        break;
                    }
                    break;
                case 109757538:
                    if (substring.equals("start")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                    i = 1;
                    break;
                case 2:
                    break;
                case 3:
                    i = 0;
                    break;
                default:
                    Log.m3027w("WebvttCueParser", "Invalid anchor value: ".concat(substring));
                    i = Integer.MIN_VALUE;
                    break;
            }
            c53Var.f8261g = i;
            str = str.substring(0, indexOf);
        }
        if (str.endsWith("%")) {
            c53Var.f8259e = WebvttParserUtil.parsePercentage(str);
            c53Var.f8260f = 0;
        } else {
            c53Var.f8259e = Integer.parseInt(str);
            c53Var.f8260f = 1;
        }
    }

    @Nullable
    public static WebvttCueInfo parseCue(ParsableByteArray parsableByteArray, List<WebvttCssStyle> list) {
        String readLine = parsableByteArray.readLine();
        if (readLine == null) {
            return null;
        }
        Pattern pattern = CUE_HEADER_PATTERN;
        Matcher matcher = pattern.matcher(readLine);
        if (matcher.matches()) {
            return m2871d(null, matcher, parsableByteArray, list);
        }
        String readLine2 = parsableByteArray.readLine();
        if (readLine2 == null) {
            return null;
        }
        Matcher matcher2 = pattern.matcher(readLine2);
        if (!matcher2.matches()) {
            return null;
        }
        return m2871d(readLine.trim(), matcher2, parsableByteArray, list);
    }
}
