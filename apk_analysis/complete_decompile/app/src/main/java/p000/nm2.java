package p000;

import android.graphics.Color;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.common.primitives.Ints;

/* loaded from: classes.dex */
public final class nm2 {

    /* renamed from: a */
    public final String f23408a;

    /* renamed from: b */
    public final int f23409b;

    /* renamed from: c */
    public final Integer f23410c;

    /* renamed from: d */
    public final Integer f23411d;

    /* renamed from: e */
    public final float f23412e;

    /* renamed from: f */
    public final boolean f23413f;

    /* renamed from: g */
    public final boolean f23414g;

    /* renamed from: h */
    public final boolean f23415h;

    /* renamed from: i */
    public final boolean f23416i;

    /* renamed from: j */
    public final int f23417j;

    public nm2(String str, int i, Integer num, Integer num2, float f, boolean z, boolean z2, boolean z3, boolean z4, int i2) {
        this.f23408a = str;
        this.f23409b = i;
        this.f23410c = num;
        this.f23411d = num2;
        this.f23412e = f;
        this.f23413f = z;
        this.f23414g = z2;
        this.f23415h = z3;
        this.f23416i = z4;
        this.f23417j = i2;
    }

    /* renamed from: a */
    public static int m6386a(String str) {
        boolean z;
        try {
            int parseInt = Integer.parseInt(str.trim());
            switch (parseInt) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            if (z) {
                return parseInt;
            }
        } catch (NumberFormatException unused) {
        }
        ye0.m8279B("Ignoring unknown alignment: ", str, "SsaStyle");
        return -1;
    }

    /* renamed from: b */
    public static boolean m6387b(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            if (parseInt != 1 && parseInt != -1) {
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            Log.m3028w("SsaStyle", "Failed to parse boolean value: '" + str + "'", e);
            return false;
        }
    }

    /* renamed from: c */
    public static Integer m6388c(String str) {
        long parseLong;
        boolean z;
        try {
            if (str.startsWith("&H")) {
                parseLong = Long.parseLong(str.substring(2), 16);
            } else {
                parseLong = Long.parseLong(str);
            }
            if (parseLong <= 4294967295L) {
                z = true;
            } else {
                z = false;
            }
            Assertions.checkArgument(z);
            return Integer.valueOf(Color.argb(Ints.checkedCast(((parseLong >> 24) & 255) ^ 255), Ints.checkedCast(parseLong & 255), Ints.checkedCast((parseLong >> 8) & 255), Ints.checkedCast((parseLong >> 16) & 255)));
        } catch (IllegalArgumentException e) {
            Log.m3028w("SsaStyle", "Failed to parse color expression: '" + str + "'", e);
            return null;
        }
    }
}
