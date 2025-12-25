package p000;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;

/* renamed from: or */
/* loaded from: classes2.dex */
public final class C1647or implements ClosedRange {

    /* renamed from: a */
    public final Comparable f24869a;

    /* renamed from: b */
    public final Comparable f24870b;

    public C1647or(Comparable start, Comparable endInclusive) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(endInclusive, "endInclusive");
        this.f24869a = start;
        this.f24870b = endInclusive;
    }

    @Override // kotlin.ranges.ClosedRange
    public final boolean contains(Comparable comparable) {
        return ClosedRange.DefaultImpls.contains(this, comparable);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0014, code lost:
    
        if (kotlin.ranges.ClosedRange.DefaultImpls.isEmpty(r0) == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean equals(Object obj) {
        if (obj instanceof C1647or) {
            if (ClosedRange.DefaultImpls.isEmpty(this)) {
                C1647or c1647or = (C1647or) obj;
                c1647or.getClass();
            }
            C1647or c1647or2 = (C1647or) obj;
            if (Intrinsics.areEqual(this.f24869a, c1647or2.f24869a)) {
                if (Intrinsics.areEqual(this.f24870b, c1647or2.f24870b)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // kotlin.ranges.ClosedRange
    public final Comparable getEndInclusive() {
        return this.f24870b;
    }

    @Override // kotlin.ranges.ClosedRange
    public final Comparable getStart() {
        return this.f24869a;
    }

    public final int hashCode() {
        if (ClosedRange.DefaultImpls.isEmpty(this)) {
            return -1;
        }
        return (this.f24869a.hashCode() * 31) + this.f24870b.hashCode();
    }

    @Override // kotlin.ranges.ClosedRange
    public final boolean isEmpty() {
        return ClosedRange.DefaultImpls.isEmpty(this);
    }

    public final String toString() {
        return this.f24869a + ".." + this.f24870b;
    }
}
