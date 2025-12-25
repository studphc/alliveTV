package com.google.android.exoplayer2.util;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.google.common.base.Ascii;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p000.ye0;

/* loaded from: classes.dex */
public final class ColorParser {

    /* renamed from: a */
    public static final Pattern f12671a = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");

    /* renamed from: b */
    public static final Pattern f12672b = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");

    /* renamed from: c */
    public static final Pattern f12673c = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");

    /* renamed from: d */
    public static final HashMap f12674d;

    static {
        HashMap hashMap = new HashMap();
        f12674d = hashMap;
        ye0.m8278A(-984833, hashMap, "aliceblue", -332841, "antiquewhite");
        hashMap.put("aqua", -16711681);
        hashMap.put("aquamarine", -8388652);
        ye0.m8278A(-983041, hashMap, "azure", -657956, "beige");
        ye0.m8278A(-6972, hashMap, "bisque", ViewCompat.MEASURED_STATE_MASK, "black");
        ye0.m8278A(-5171, hashMap, "blanchedalmond", -16776961, "blue");
        ye0.m8278A(-7722014, hashMap, "blueviolet", -5952982, "brown");
        ye0.m8278A(-2180985, hashMap, "burlywood", -10510688, "cadetblue");
        ye0.m8278A(-8388864, hashMap, "chartreuse", -2987746, "chocolate");
        ye0.m8278A(-32944, hashMap, "coral", -10185235, "cornflowerblue");
        ye0.m8278A(-1828, hashMap, "cornsilk", -2354116, "crimson");
        hashMap.put("cyan", -16711681);
        hashMap.put("darkblue", -16777077);
        ye0.m8278A(-16741493, hashMap, "darkcyan", -4684277, "darkgoldenrod");
        hashMap.put("darkgray", -5658199);
        hashMap.put("darkgreen", -16751616);
        hashMap.put("darkgrey", -5658199);
        hashMap.put("darkkhaki", -4343957);
        ye0.m8278A(-7667573, hashMap, "darkmagenta", -11179217, "darkolivegreen");
        ye0.m8278A(-29696, hashMap, "darkorange", -6737204, "darkorchid");
        ye0.m8278A(-7667712, hashMap, "darkred", -1468806, "darksalmon");
        ye0.m8278A(-7357297, hashMap, "darkseagreen", -12042869, "darkslateblue");
        hashMap.put("darkslategray", -13676721);
        hashMap.put("darkslategrey", -13676721);
        hashMap.put("darkturquoise", -16724271);
        hashMap.put("darkviolet", -7077677);
        ye0.m8278A(-60269, hashMap, "deeppink", -16728065, "deepskyblue");
        hashMap.put("dimgray", -9868951);
        hashMap.put("dimgrey", -9868951);
        hashMap.put("dodgerblue", -14774017);
        hashMap.put("firebrick", -5103070);
        ye0.m8278A(-1296, hashMap, "floralwhite", -14513374, "forestgreen");
        hashMap.put("fuchsia", -65281);
        hashMap.put("gainsboro", -2302756);
        ye0.m8278A(-460545, hashMap, "ghostwhite", -10496, "gold");
        hashMap.put("goldenrod", -2448096);
        hashMap.put("gray", -8355712);
        ye0.m8278A(-16744448, hashMap, "green", -5374161, "greenyellow");
        hashMap.put("grey", -8355712);
        hashMap.put("honeydew", -983056);
        ye0.m8278A(-38476, hashMap, "hotpink", -3318692, "indianred");
        ye0.m8278A(-11861886, hashMap, "indigo", -16, "ivory");
        ye0.m8278A(-989556, hashMap, "khaki", -1644806, "lavender");
        ye0.m8278A(-3851, hashMap, "lavenderblush", -8586240, "lawngreen");
        ye0.m8278A(-1331, hashMap, "lemonchiffon", -5383962, "lightblue");
        ye0.m8278A(-1015680, hashMap, "lightcoral", -2031617, "lightcyan");
        hashMap.put("lightgoldenrodyellow", -329006);
        hashMap.put("lightgray", -2894893);
        hashMap.put("lightgreen", -7278960);
        hashMap.put("lightgrey", -2894893);
        ye0.m8278A(-18751, hashMap, "lightpink", -24454, "lightsalmon");
        ye0.m8278A(-14634326, hashMap, "lightseagreen", -7876870, "lightskyblue");
        hashMap.put("lightslategray", -8943463);
        hashMap.put("lightslategrey", -8943463);
        hashMap.put("lightsteelblue", -5192482);
        hashMap.put("lightyellow", -32);
        ye0.m8278A(-16711936, hashMap, "lime", -13447886, "limegreen");
        hashMap.put("linen", -331546);
        hashMap.put("magenta", -65281);
        ye0.m8278A(-8388608, hashMap, "maroon", -10039894, "mediumaquamarine");
        ye0.m8278A(-16777011, hashMap, "mediumblue", -4565549, "mediumorchid");
        ye0.m8278A(-7114533, hashMap, "mediumpurple", -12799119, "mediumseagreen");
        ye0.m8278A(-8689426, hashMap, "mediumslateblue", -16713062, "mediumspringgreen");
        ye0.m8278A(-12004916, hashMap, "mediumturquoise", -3730043, "mediumvioletred");
        ye0.m8278A(-15132304, hashMap, "midnightblue", -655366, "mintcream");
        ye0.m8278A(-6943, hashMap, "mistyrose", -6987, "moccasin");
        ye0.m8278A(-8531, hashMap, "navajowhite", -16777088, "navy");
        ye0.m8278A(-133658, hashMap, "oldlace", -8355840, "olive");
        ye0.m8278A(-9728477, hashMap, "olivedrab", -23296, "orange");
        ye0.m8278A(-47872, hashMap, "orangered", -2461482, "orchid");
        ye0.m8278A(-1120086, hashMap, "palegoldenrod", -6751336, "palegreen");
        ye0.m8278A(-5247250, hashMap, "paleturquoise", -2396013, "palevioletred");
        ye0.m8278A(-4139, hashMap, "papayawhip", -9543, "peachpuff");
        ye0.m8278A(-3308225, hashMap, "peru", -16181, "pink");
        ye0.m8278A(-2252579, hashMap, "plum", -5185306, "powderblue");
        ye0.m8278A(-8388480, hashMap, "purple", -10079335, "rebeccapurple");
        ye0.m8278A(SupportMenu.CATEGORY_MASK, hashMap, "red", -4419697, "rosybrown");
        ye0.m8278A(-12490271, hashMap, "royalblue", -7650029, "saddlebrown");
        ye0.m8278A(-360334, hashMap, "salmon", -744352, "sandybrown");
        ye0.m8278A(-13726889, hashMap, "seagreen", -2578, "seashell");
        ye0.m8278A(-6270419, hashMap, "sienna", -4144960, "silver");
        ye0.m8278A(-7876885, hashMap, "skyblue", -9807155, "slateblue");
        hashMap.put("slategray", -9404272);
        hashMap.put("slategrey", -9404272);
        hashMap.put("snow", -1286);
        hashMap.put("springgreen", -16711809);
        ye0.m8278A(-12156236, hashMap, "steelblue", -2968436, "tan");
        ye0.m8278A(-16744320, hashMap, "teal", -2572328, "thistle");
        ye0.m8278A(-40121, hashMap, "tomato", 0, "transparent");
        ye0.m8278A(-12525360, hashMap, "turquoise", -1146130, "violet");
        ye0.m8278A(-663885, hashMap, "wheat", -1, "white");
        ye0.m8278A(-657931, hashMap, "whitesmoke", InputDeviceCompat.SOURCE_ANY, "yellow");
        hashMap.put("yellowgreen", -6632142);
    }

    /* renamed from: a */
    public static int m3009a(String str, boolean z) {
        Pattern pattern;
        int parseInt;
        Assertions.checkArgument(!TextUtils.isEmpty(str));
        String replace = str.replace(" ", "");
        if (replace.charAt(0) == '#') {
            int parseLong = (int) Long.parseLong(replace.substring(1), 16);
            if (replace.length() == 7) {
                return (-16777216) | parseLong;
            }
            if (replace.length() == 9) {
                return ((parseLong & 255) << 24) | (parseLong >>> 8);
            }
            throw new IllegalArgumentException();
        }
        if (replace.startsWith("rgba")) {
            if (z) {
                pattern = f12673c;
            } else {
                pattern = f12672b;
            }
            Matcher matcher = pattern.matcher(replace);
            if (matcher.matches()) {
                if (z) {
                    parseInt = (int) (Float.parseFloat((String) Assertions.checkNotNull(matcher.group(4))) * 255.0f);
                } else {
                    parseInt = Integer.parseInt((String) Assertions.checkNotNull(matcher.group(4)), 10);
                }
                return Color.argb(parseInt, Integer.parseInt((String) Assertions.checkNotNull(matcher.group(1)), 10), Integer.parseInt((String) Assertions.checkNotNull(matcher.group(2)), 10), Integer.parseInt((String) Assertions.checkNotNull(matcher.group(3)), 10));
            }
        } else if (replace.startsWith("rgb")) {
            Matcher matcher2 = f12671a.matcher(replace);
            if (matcher2.matches()) {
                return Color.rgb(Integer.parseInt((String) Assertions.checkNotNull(matcher2.group(1)), 10), Integer.parseInt((String) Assertions.checkNotNull(matcher2.group(2)), 10), Integer.parseInt((String) Assertions.checkNotNull(matcher2.group(3)), 10));
            }
        } else {
            Integer num = (Integer) f12674d.get(Ascii.toLowerCase(replace));
            if (num != null) {
                return num.intValue();
            }
        }
        throw new IllegalArgumentException();
    }

    @ColorInt
    public static int parseCssColor(String str) {
        return m3009a(str, true);
    }

    @ColorInt
    public static int parseTtmlColor(String str) {
        return m3009a(str, false);
    }
}
