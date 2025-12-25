package p000;

import androidx.emoji2.text.flatbuffer.FlexBuffers;
import androidx.emoji2.text.flatbuffer.FlexBuffersBuilder;

/* loaded from: classes.dex */
public final class xe0 {

    /* renamed from: a */
    public final int f28518a;

    /* renamed from: b */
    public final int f28519b;

    /* renamed from: c */
    public final double f28520c;

    /* renamed from: d */
    public final long f28521d;

    /* renamed from: e */
    public final int f28522e;

    public xe0(int i, int i2, int i3, long j) {
        this.f28522e = i;
        this.f28518a = i2;
        this.f28519b = i3;
        this.f28521d = j;
        this.f28520c = Double.MIN_VALUE;
    }

    /* renamed from: a */
    public static int m8163a(int i, int i2, int i3, long j, int i4) {
        int i5 = FlexBuffers.FBT_NULL;
        if (i > 3 && i != 26) {
            for (int i6 = 1; i6 <= 32; i6 *= 2) {
                int m1072e = FlexBuffersBuilder.m1072e((int) (((i4 * i6) + ((((~i3) + 1) & (i6 - 1)) + i3)) - j));
                if ((1 << m1072e) == i6) {
                    return m1072e;
                }
            }
            return 3;
        }
        return i2;
    }

    public xe0(int i, int i2, double d) {
        this.f28522e = i;
        this.f28518a = 3;
        this.f28519b = i2;
        this.f28520c = d;
        this.f28521d = Long.MIN_VALUE;
    }
}
