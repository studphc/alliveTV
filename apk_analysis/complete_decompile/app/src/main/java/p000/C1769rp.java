package p000;

import kotlin.ranges.ClosedFloatingPointRange;

/* renamed from: rp */
/* loaded from: classes2.dex */
public final class C1769rp implements ClosedFloatingPointRange {

    /* renamed from: a */
    public final float f26087a;

    /* renamed from: b */
    public final float f26088b;

    public C1769rp(float f, float f2) {
        this.f26087a = f;
        this.f26088b = f2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.ClosedFloatingPointRange, kotlin.ranges.ClosedRange
    public final boolean contains(Comparable comparable) {
        float floatValue = ((Number) comparable).floatValue();
        if (floatValue >= this.f26087a && floatValue <= this.f26088b) {
            return true;
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C1769rp) {
            if (!isEmpty() || !((C1769rp) obj).isEmpty()) {
                C1769rp c1769rp = (C1769rp) obj;
                if (this.f26087a != c1769rp.f26087a || this.f26088b != c1769rp.f26088b) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.ClosedRange
    public final Comparable getEndInclusive() {
        return Float.valueOf(this.f26088b);
    }

    @Override // kotlin.ranges.ClosedRange
    public final Comparable getStart() {
        return Float.valueOf(this.f26087a);
    }

    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.floatToIntBits(this.f26087a) * 31) + Float.floatToIntBits(this.f26088b);
    }

    @Override // kotlin.ranges.ClosedFloatingPointRange, kotlin.ranges.ClosedRange
    public final boolean isEmpty() {
        if (this.f26087a > this.f26088b) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.ClosedFloatingPointRange
    public final boolean lessThanOrEquals(Comparable comparable, Comparable comparable2) {
        if (((Number) comparable).floatValue() <= ((Number) comparable2).floatValue()) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return this.f26087a + ".." + this.f26088b;
    }
}
