package p000;

import kotlin.ranges.OpenEndRange;

/* loaded from: classes2.dex */
public final class g12 implements OpenEndRange {

    /* renamed from: a */
    public final float f17525a;

    /* renamed from: b */
    public final float f17526b;

    public g12(float f, float f2) {
        this.f17525a = f;
        this.f17526b = f2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.OpenEndRange
    public final boolean contains(Comparable comparable) {
        float floatValue = ((Number) comparable).floatValue();
        if (floatValue >= this.f17525a && floatValue < this.f17526b) {
            return true;
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof g12) {
            if (!isEmpty() || !((g12) obj).isEmpty()) {
                g12 g12Var = (g12) obj;
                if (this.f17525a != g12Var.f17525a || this.f17526b != g12Var.f17526b) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.OpenEndRange
    public final Comparable getEndExclusive() {
        return Float.valueOf(this.f17526b);
    }

    @Override // kotlin.ranges.OpenEndRange
    public final Comparable getStart() {
        return Float.valueOf(this.f17525a);
    }

    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.floatToIntBits(this.f17525a) * 31) + Float.floatToIntBits(this.f17526b);
    }

    @Override // kotlin.ranges.OpenEndRange
    public final boolean isEmpty() {
        if (this.f17525a >= this.f17526b) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return this.f17525a + "..<" + this.f17526b;
    }
}
