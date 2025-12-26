package p000;

/* renamed from: bv */
/* loaded from: classes2.dex */
public abstract class AbstractC0571bv {

    /* renamed from: a */
    public static final double f8158a = Math.log(2.0d);

    /* renamed from: b */
    public static final double f8159b;

    /* renamed from: c */
    public static final double f8160c;

    /* renamed from: d */
    public static final double f8161d;

    /* renamed from: e */
    public static final double f8162e;

    static {
        double sqrt = Math.sqrt(Math.ulp(1.0d));
        f8159b = sqrt;
        double sqrt2 = Math.sqrt(sqrt);
        f8160c = sqrt2;
        double d = 1;
        f8161d = d / sqrt;
        f8162e = d / sqrt2;
    }
}
