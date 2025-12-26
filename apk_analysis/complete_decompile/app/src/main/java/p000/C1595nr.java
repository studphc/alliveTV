package p000;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.OpenEndRange;

/* renamed from: nr */
/* loaded from: classes2.dex */
public final class C1595nr implements OpenEndRange {

    /* renamed from: a */
    public final Comparable f23462a;

    /* renamed from: b */
    public final Comparable f23463b;

    public C1595nr(Comparable start, Comparable endExclusive) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(endExclusive, "endExclusive");
        this.f23462a = start;
        this.f23463b = endExclusive;
    }

    @Override // kotlin.ranges.OpenEndRange
    public final boolean contains(Comparable comparable) {
        return OpenEndRange.DefaultImpls.contains(this, comparable);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0014, code lost:
    
        if (kotlin.ranges.OpenEndRange.DefaultImpls.isEmpty(r0) == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean equals(Object obj) {
        if (obj instanceof C1595nr) {
            if (OpenEndRange.DefaultImpls.isEmpty(this)) {
                C1595nr c1595nr = (C1595nr) obj;
                c1595nr.getClass();
            }
            C1595nr c1595nr2 = (C1595nr) obj;
            if (Intrinsics.areEqual(this.f23462a, c1595nr2.f23462a)) {
                if (Intrinsics.areEqual(this.f23463b, c1595nr2.f23463b)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // kotlin.ranges.OpenEndRange
    public final Comparable getEndExclusive() {
        return this.f23463b;
    }

    @Override // kotlin.ranges.OpenEndRange
    public final Comparable getStart() {
        return this.f23462a;
    }

    public final int hashCode() {
        if (OpenEndRange.DefaultImpls.isEmpty(this)) {
            return -1;
        }
        return (this.f23462a.hashCode() * 31) + this.f23463b.hashCode();
    }

    @Override // kotlin.ranges.OpenEndRange
    public final boolean isEmpty() {
        return OpenEndRange.DefaultImpls.isEmpty(this);
    }

    public final String toString() {
        return this.f23462a + "..<" + this.f23463b;
    }
}
