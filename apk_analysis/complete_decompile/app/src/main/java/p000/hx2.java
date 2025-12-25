package p000;

/* loaded from: classes.dex */
public final class hx2 {

    /* renamed from: d */
    public static hx2 f18211d;

    /* renamed from: a */
    public long f18212a;

    /* renamed from: b */
    public long f18213b;

    /* renamed from: c */
    public int f18214c;

    /* renamed from: a */
    public final void m5138a(long j, double d, double d2) {
        double d3 = (0.01720197f * (((float) (j - 946728000000L)) / 8.64E7f)) + 6.24006f;
        double sin = (Math.sin(r4 * 3.0f) * 5.236000106378924E-6d) + (Math.sin(2.0f * r4) * 3.4906598739326E-4d) + (Math.sin(d3) * 0.03341960161924362d) + d3 + 1.796593063d + 3.141592653589793d;
        double sin2 = (Math.sin(2.0d * sin) * (-0.0069d)) + (Math.sin(d3) * 0.0053d) + ((float) Math.round((r3 - 9.0E-4f) - r7)) + 9.0E-4f + ((-d2) / 360.0d);
        double asin = Math.asin(Math.sin(0.4092797040939331d) * Math.sin(sin));
        double d4 = 0.01745329238474369d * d;
        double sin3 = (Math.sin(-0.10471975803375244d) - (Math.sin(asin) * Math.sin(d4))) / (Math.cos(asin) * Math.cos(d4));
        if (sin3 >= 1.0d) {
            this.f18214c = 1;
            this.f18212a = -1L;
            this.f18213b = -1L;
        } else {
            if (sin3 <= -1.0d) {
                this.f18214c = 0;
                this.f18212a = -1L;
                this.f18213b = -1L;
                return;
            }
            double acos = (float) (Math.acos(sin3) / 6.283185307179586d);
            this.f18212a = Math.round((sin2 + acos) * 8.64E7d) + 946728000000L;
            long round = Math.round((sin2 - acos) * 8.64E7d) + 946728000000L;
            this.f18213b = round;
            if (round < j && this.f18212a > j) {
                this.f18214c = 0;
            } else {
                this.f18214c = 1;
            }
        }
    }
}
