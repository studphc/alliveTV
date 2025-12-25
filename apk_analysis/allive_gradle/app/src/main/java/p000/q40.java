package p000;

import com.google.common.collect.DiscreteDomain;
import com.google.common.primitives.Ints;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class q40 extends DiscreteDomain implements Serializable {

    /* renamed from: b */
    public static final q40 f25430b = new DiscreteDomain(true);
    private static final long serialVersionUID = 0;

    private Object readResolve() {
        return f25430b;
    }

    @Override // com.google.common.collect.DiscreteDomain
    /* renamed from: a */
    public final Comparable mo3849a(Comparable comparable, long j) {
        p63.m6870n(j);
        return Integer.valueOf(Ints.checkedCast(((Integer) comparable).longValue() + j));
    }

    @Override // com.google.common.collect.DiscreteDomain
    public final long distance(Comparable comparable, Comparable comparable2) {
        return ((Integer) comparable2).intValue() - ((Integer) comparable).intValue();
    }

    @Override // com.google.common.collect.DiscreteDomain
    public final /* bridge */ /* synthetic */ Comparable maxValue() {
        return Integer.MAX_VALUE;
    }

    @Override // com.google.common.collect.DiscreteDomain
    public final /* bridge */ /* synthetic */ Comparable minValue() {
        return Integer.MIN_VALUE;
    }

    @Override // com.google.common.collect.DiscreteDomain
    public final Comparable next(Comparable comparable) {
        int intValue = ((Integer) comparable).intValue();
        if (intValue == Integer.MAX_VALUE) {
            return null;
        }
        return Integer.valueOf(intValue + 1);
    }

    @Override // com.google.common.collect.DiscreteDomain
    public final Comparable previous(Comparable comparable) {
        int intValue = ((Integer) comparable).intValue();
        if (intValue == Integer.MIN_VALUE) {
            return null;
        }
        return Integer.valueOf(intValue - 1);
    }

    public final String toString() {
        return "DiscreteDomain.integers()";
    }
}
