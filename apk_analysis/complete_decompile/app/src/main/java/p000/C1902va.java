package p000;

/* renamed from: va */
/* loaded from: classes.dex */
public final class C1902va {

    /* renamed from: s */
    public static final double[] f27693s = new double[91];

    /* renamed from: a */
    public double[] f27694a;

    /* renamed from: b */
    public double f27695b;

    /* renamed from: c */
    public double f27696c;

    /* renamed from: d */
    public double f27697d;

    /* renamed from: e */
    public double f27698e;

    /* renamed from: f */
    public double f27699f;

    /* renamed from: g */
    public double f27700g;

    /* renamed from: h */
    public double f27701h;

    /* renamed from: i */
    public double f27702i;

    /* renamed from: j */
    public double f27703j;

    /* renamed from: k */
    public double f27704k;

    /* renamed from: l */
    public double f27705l;

    /* renamed from: m */
    public double f27706m;

    /* renamed from: n */
    public double f27707n;

    /* renamed from: o */
    public double f27708o;

    /* renamed from: p */
    public double f27709p;

    /* renamed from: q */
    public boolean f27710q;

    /* renamed from: r */
    public boolean f27711r;

    /* renamed from: a */
    public final double m7879a() {
        double d = this.f27703j * this.f27709p;
        double hypot = this.f27707n / Math.hypot(d, (-this.f27704k) * this.f27708o);
        if (this.f27710q) {
            d = -d;
        }
        return d * hypot;
    }

    /* renamed from: b */
    public final double m7880b() {
        double d = this.f27703j * this.f27709p;
        double d2 = (-this.f27704k) * this.f27708o;
        double hypot = this.f27707n / Math.hypot(d, d2);
        if (this.f27710q) {
            return (-d2) * hypot;
        }
        return d2 * hypot;
    }

    /* renamed from: c */
    public final double m7881c(double d) {
        double d2 = (d - this.f27696c) * this.f27702i;
        double d3 = this.f27699f;
        double d4 = this.f27698e;
        return ((d3 - d4) * d2) + d4;
    }

    /* renamed from: d */
    public final double m7882d(double d) {
        double d2 = (d - this.f27696c) * this.f27702i;
        double d3 = this.f27701h;
        double d4 = this.f27700g;
        return ((d3 - d4) * d2) + d4;
    }

    /* renamed from: e */
    public final double m7883e() {
        return (this.f27703j * this.f27708o) + this.f27705l;
    }

    /* renamed from: f */
    public final double m7884f() {
        return (this.f27704k * this.f27709p) + this.f27706m;
    }

    /* renamed from: g */
    public final void m7885g(double d) {
        double d2;
        if (this.f27710q) {
            d2 = this.f27697d - d;
        } else {
            d2 = d - this.f27696c;
        }
        double d3 = d2 * this.f27702i;
        double d4 = 0.0d;
        if (d3 > 0.0d) {
            d4 = 1.0d;
            if (d3 < 1.0d) {
                double[] dArr = this.f27694a;
                double length = d3 * (dArr.length - 1);
                int i = (int) length;
                double d5 = dArr[i];
                d4 = ((dArr[i + 1] - d5) * (length - i)) + d5;
            }
        }
        double d6 = d4 * 1.5707963267948966d;
        this.f27708o = Math.sin(d6);
        this.f27709p = Math.cos(d6);
    }
}
