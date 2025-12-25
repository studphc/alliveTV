package p000;

import kotlin.ranges.ClosedFloatingPointRange;

/* renamed from: qp */
/* loaded from: classes2.dex */
public final class C1732qp implements ClosedFloatingPointRange {

    /* renamed from: a */
    public final double f25707a;

    /* renamed from: b */
    public final double f25708b;

    public C1732qp(double d, double d2) {
        this.f25707a = d;
        this.f25708b = d2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.ClosedFloatingPointRange, kotlin.ranges.ClosedRange
    public final boolean contains(Comparable comparable) {
        double doubleValue = ((Number) comparable).doubleValue();
        if (doubleValue >= this.f25707a && doubleValue <= this.f25708b) {
            return true;
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C1732qp) {
            if (!isEmpty() || !((C1732qp) obj).isEmpty()) {
                C1732qp c1732qp = (C1732qp) obj;
                if (this.f25707a != c1732qp.f25707a || this.f25708b != c1732qp.f25708b) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.ClosedRange
    public final Comparable getEndInclusive() {
        return Double.valueOf(this.f25708b);
    }

    @Override // kotlin.ranges.ClosedRange
    public final Comparable getStart() {
        return Double.valueOf(this.f25707a);
    }

    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long doubleToLongBits = Double.doubleToLongBits(this.f25707a);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.f25708b);
        return i + ((int) ((doubleToLongBits2 >>> 32) ^ doubleToLongBits2));
    }

    @Override // kotlin.ranges.ClosedFloatingPointRange, kotlin.ranges.ClosedRange
    public final boolean isEmpty() {
        if (this.f25707a > this.f25708b) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.ClosedFloatingPointRange
    public final boolean lessThanOrEquals(Comparable comparable, Comparable comparable2) {
        if (((Number) comparable).doubleValue() <= ((Number) comparable2).doubleValue()) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return this.f25707a + ".." + this.f25708b;
    }
}
