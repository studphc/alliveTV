package p000;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;

/* loaded from: classes2.dex */
public abstract class rh1 extends qh1 {
    @SinceKotlin(version = "1.2")
    public static final double acosh(double d) {
        if (d < 1.0d) {
            return Double.NaN;
        }
        if (d > AbstractC0571bv.f8161d) {
            return Math.log(d) + AbstractC0571bv.f8158a;
        }
        double d2 = 1;
        double d3 = d - d2;
        if (d3 >= AbstractC0571bv.f8160c) {
            return Math.log(Math.sqrt((d * d) - d2) + d);
        }
        double sqrt = Math.sqrt(d3);
        if (sqrt >= AbstractC0571bv.f8159b) {
            sqrt -= ((sqrt * sqrt) * sqrt) / 12;
        }
        return sqrt * Math.sqrt(2.0d);
    }

    @SinceKotlin(version = "1.2")
    public static final double asinh(double d) {
        double d2 = AbstractC0571bv.f8160c;
        if (d >= d2) {
            if (d > AbstractC0571bv.f8162e) {
                if (d > AbstractC0571bv.f8161d) {
                    return Math.log(d) + AbstractC0571bv.f8158a;
                }
                double d3 = d * 2;
                return Math.log((1 / d3) + d3);
            }
            return Math.log(Math.sqrt((d * d) + 1) + d);
        }
        if (d <= (-d2)) {
            return -asinh(-d);
        }
        if (Math.abs(d) >= AbstractC0571bv.f8159b) {
            return d - (((d * d) * d) / 6);
        }
        return d;
    }

    @SinceKotlin(version = "1.2")
    public static final double atanh(double d) {
        if (Math.abs(d) < AbstractC0571bv.f8160c) {
            if (Math.abs(d) > AbstractC0571bv.f8159b) {
                return d + (((d * d) * d) / 3);
            }
            return d;
        }
        double d2 = 1;
        return Math.log((d2 + d) / (d2 - d)) / 2;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(double d) {
    }

    public static int getSign(int i) {
        if (i < 0) {
            return -1;
        }
        return i > 0 ? 1 : 0;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getSign$annotations(double d) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getUlp$annotations(double d) {
    }

    @SinceKotlin(version = "1.2")
    public static final double log(double d, double d2) {
        if (d2 <= 0.0d || d2 == 1.0d) {
            return Double.NaN;
        }
        return Math.log(d) / Math.log(d2);
    }

    @SinceKotlin(version = "1.2")
    public static final double log2(double d) {
        return Math.log(d) / AbstractC0571bv.f8158a;
    }

    @SinceKotlin(version = "1.2")
    public static int roundToInt(double d) {
        if (Double.isNaN(d)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        if (d > 2.147483647E9d) {
            return Integer.MAX_VALUE;
        }
        if (d < -2.147483648E9d) {
            return Integer.MIN_VALUE;
        }
        return (int) Math.round(d);
    }

    @SinceKotlin(version = "1.2")
    public static long roundToLong(double d) {
        if (Double.isNaN(d)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(d);
    }

    @SinceKotlin(version = "1.2")
    public static final double truncate(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            return d;
        }
        if (d > 0.0d) {
            return Math.floor(d);
        }
        return Math.ceil(d);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(float f) {
    }

    public static int getSign(long j) {
        if (j < 0) {
            return -1;
        }
        return j > 0 ? 1 : 0;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getSign$annotations(float f) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getUlp$annotations(float f) {
    }

    @SinceKotlin(version = "1.2")
    public static final float log(float f, float f2) {
        if (f2 <= RecyclerView.f7068F0 || f2 == 1.0f) {
            return Float.NaN;
        }
        return (float) (Math.log(f) / Math.log(f2));
    }

    @SinceKotlin(version = "1.2")
    public static final float log2(float f) {
        return (float) (Math.log(f) / AbstractC0571bv.f8158a);
    }

    @SinceKotlin(version = "1.2")
    public static final long roundToLong(float f) {
        return roundToLong(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(int i) {
    }

    @SinceKotlin(version = "1.2")
    public static /* synthetic */ void getSign$annotations(int i) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(long j) {
    }

    @SinceKotlin(version = "1.2")
    public static /* synthetic */ void getSign$annotations(long j) {
    }

    @SinceKotlin(version = "1.2")
    public static final int roundToInt(float f) {
        if (Float.isNaN(f)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(f);
    }

    @SinceKotlin(version = "1.2")
    public static final float truncate(float f) {
        double ceil;
        if (Float.isNaN(f) || Float.isInfinite(f)) {
            return f;
        }
        if (f > RecyclerView.f7068F0) {
            ceil = Math.floor(f);
        } else {
            ceil = Math.ceil(f);
        }
        return (float) ceil;
    }
}
