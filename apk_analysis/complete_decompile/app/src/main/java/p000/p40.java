package p000;

import com.google.common.collect.DiscreteDomain;
import java.io.Serializable;
import java.math.BigInteger;

/* loaded from: classes.dex */
public final class p40 extends DiscreteDomain implements Serializable {

    /* renamed from: b */
    public static final p40 f25026b = new DiscreteDomain(true);

    /* renamed from: c */
    public static final BigInteger f25027c = BigInteger.valueOf(Long.MIN_VALUE);

    /* renamed from: d */
    public static final BigInteger f25028d = BigInteger.valueOf(Long.MAX_VALUE);
    private static final long serialVersionUID = 0;

    private Object readResolve() {
        return f25026b;
    }

    @Override // com.google.common.collect.DiscreteDomain
    /* renamed from: a */
    public final Comparable mo3849a(Comparable comparable, long j) {
        p63.m6870n(j);
        return ((BigInteger) comparable).add(BigInteger.valueOf(j));
    }

    @Override // com.google.common.collect.DiscreteDomain
    public final long distance(Comparable comparable, Comparable comparable2) {
        return ((BigInteger) comparable2).subtract((BigInteger) comparable).max(f25027c).min(f25028d).longValue();
    }

    @Override // com.google.common.collect.DiscreteDomain
    public final Comparable next(Comparable comparable) {
        return ((BigInteger) comparable).add(BigInteger.ONE);
    }

    @Override // com.google.common.collect.DiscreteDomain
    public final Comparable previous(Comparable comparable) {
        return ((BigInteger) comparable).subtract(BigInteger.ONE);
    }

    public final String toString() {
        return "DiscreteDomain.bigIntegers()";
    }
}
