package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.DiscreteDomain;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class r40 extends DiscreteDomain implements Serializable {

    /* renamed from: b */
    public static final r40 f25864b = new DiscreteDomain(true);
    private static final long serialVersionUID = 0;

    private Object readResolve() {
        return f25864b;
    }

    @Override // com.google.common.collect.DiscreteDomain
    /* renamed from: a */
    public final Comparable mo3849a(Comparable comparable, long j) {
        boolean z;
        Long l = (Long) comparable;
        p63.m6870n(j);
        long longValue = l.longValue() + j;
        if (longValue < 0) {
            if (l.longValue() < 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "overflow");
        }
        return Long.valueOf(longValue);
    }

    @Override // com.google.common.collect.DiscreteDomain
    public final long distance(Comparable comparable, Comparable comparable2) {
        Long l = (Long) comparable;
        Long l2 = (Long) comparable2;
        long longValue = l2.longValue() - l.longValue();
        if (l2.longValue() > l.longValue() && longValue < 0) {
            return Long.MAX_VALUE;
        }
        if (l2.longValue() < l.longValue() && longValue > 0) {
            return Long.MIN_VALUE;
        }
        return longValue;
    }

    @Override // com.google.common.collect.DiscreteDomain
    public final /* bridge */ /* synthetic */ Comparable maxValue() {
        return Long.MAX_VALUE;
    }

    @Override // com.google.common.collect.DiscreteDomain
    public final /* bridge */ /* synthetic */ Comparable minValue() {
        return Long.MIN_VALUE;
    }

    @Override // com.google.common.collect.DiscreteDomain
    public final Comparable next(Comparable comparable) {
        long longValue = ((Long) comparable).longValue();
        if (longValue == Long.MAX_VALUE) {
            return null;
        }
        return Long.valueOf(longValue + 1);
    }

    @Override // com.google.common.collect.DiscreteDomain
    public final Comparable previous(Comparable comparable) {
        long longValue = ((Long) comparable).longValue();
        if (longValue == Long.MIN_VALUE) {
            return null;
        }
        return Long.valueOf(longValue - 1);
    }

    public final String toString() {
        return "DiscreteDomain.longs()";
    }
}
