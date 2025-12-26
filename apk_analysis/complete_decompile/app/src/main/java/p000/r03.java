package p000;

import com.google.common.primitives.UnsignedLongs;
import java.math.BigInteger;

/* loaded from: classes2.dex */
public abstract class r03 {

    /* renamed from: a */
    public static final long[] f25829a = new long[37];

    /* renamed from: b */
    public static final int[] f25830b = new int[37];

    /* renamed from: c */
    public static final int[] f25831c = new int[37];

    static {
        BigInteger bigInteger = new BigInteger("10000000000000000", 16);
        for (int i = 2; i <= 36; i++) {
            long j = i;
            f25829a[i] = UnsignedLongs.divide(-1L, j);
            f25830b[i] = (int) UnsignedLongs.remainder(-1L, j);
            f25831c[i] = bigInteger.toString(i).length() - 1;
        }
    }
}
