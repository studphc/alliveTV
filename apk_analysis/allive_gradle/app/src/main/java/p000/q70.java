package p000;

import androidx.constraintlayout.core.motion.utils.Easing;

/* loaded from: classes.dex */
public final class q70 extends Easing {

    /* renamed from: c */
    public final double f25475c;

    /* renamed from: d */
    public final double f25476d;

    /* renamed from: e */
    public final double f25477e;

    /* renamed from: f */
    public final double f25478f;

    public q70(String str) {
        this.f2168a = str;
        int indexOf = str.indexOf(40);
        int indexOf2 = str.indexOf(44, indexOf);
        this.f25475c = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
        int i = indexOf2 + 1;
        int indexOf3 = str.indexOf(44, i);
        this.f25476d = Double.parseDouble(str.substring(i, indexOf3).trim());
        int i2 = indexOf3 + 1;
        int indexOf4 = str.indexOf(44, i2);
        this.f25477e = Double.parseDouble(str.substring(i2, indexOf4).trim());
        int i3 = indexOf4 + 1;
        this.f25478f = Double.parseDouble(str.substring(i3, str.indexOf(41, i3)).trim());
    }

    /* renamed from: a */
    public final double m7002a(double d) {
        double d2 = 1.0d - d;
        double d3 = 3.0d * d2;
        double d4 = d2 * d3 * d;
        double d5 = d3 * d * d;
        return (this.f25477e * d5) + (this.f25475c * d4) + (d * d * d);
    }

    /* renamed from: b */
    public final double m7003b(double d) {
        double d2 = 1.0d - d;
        double d3 = 3.0d * d2;
        double d4 = d2 * d3 * d;
        double d5 = d3 * d * d;
        return (this.f25478f * d5) + (this.f25476d * d4) + (d * d * d);
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public final double get(double d) {
        if (d <= 0.0d) {
            return 0.0d;
        }
        if (d >= 1.0d) {
            return 1.0d;
        }
        double d2 = 0.5d;
        double d3 = 0.5d;
        while (d2 > 0.01d) {
            d2 *= 0.5d;
            if (m7002a(d3) < d) {
                d3 += d2;
            } else {
                d3 -= d2;
            }
        }
        double d4 = d3 - d2;
        double m7002a = m7002a(d4);
        double d5 = d3 + d2;
        double m7002a2 = m7002a(d5);
        double m7003b = m7003b(d4);
        return (((d - m7002a) * (m7003b(d5) - m7003b)) / (m7002a2 - m7002a)) + m7003b;
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public final double getDiff(double d) {
        double d2 = 0.5d;
        double d3 = 0.5d;
        while (d2 > 1.0E-4d) {
            d2 *= 0.5d;
            if (m7002a(d3) < d) {
                d3 += d2;
            } else {
                d3 -= d2;
            }
        }
        double d4 = d3 - d2;
        double m7002a = m7002a(d4);
        double d5 = d3 + d2;
        return (m7003b(d5) - m7003b(d4)) / (m7002a(d5) - m7002a);
    }
}
