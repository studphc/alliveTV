package p000;

import kotlin.ranges.OpenEndRange;

/* loaded from: classes2.dex */
public final class f12 implements OpenEndRange {

    /* renamed from: a */
    public final double f17081a;

    /* renamed from: b */
    public final double f17082b;

    public f12(double d, double d2) {
        this.f17081a = d;
        this.f17082b = d2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.OpenEndRange
    public final boolean contains(Comparable comparable) {
        double doubleValue = ((Number) comparable).doubleValue();
        if (doubleValue >= this.f17081a && doubleValue < this.f17082b) {
            return true;
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof f12) {
            if (!isEmpty() || !((f12) obj).isEmpty()) {
                f12 f12Var = (f12) obj;
                if (this.f17081a != f12Var.f17081a || this.f17082b != f12Var.f17082b) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.OpenEndRange
    public final Comparable getEndExclusive() {
        return Double.valueOf(this.f17082b);
    }

    @Override // kotlin.ranges.OpenEndRange
    public final Comparable getStart() {
        return Double.valueOf(this.f17081a);
    }

    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long doubleToLongBits = Double.doubleToLongBits(this.f17081a);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.f17082b);
        return i + ((int) ((doubleToLongBits2 >>> 32) ^ doubleToLongBits2));
    }

    @Override // kotlin.ranges.OpenEndRange
    public final boolean isEmpty() {
        if (this.f17081a >= this.f17082b) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return this.f17081a + "..<" + this.f17082b;
    }
}
