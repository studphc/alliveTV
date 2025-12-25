package p000;

import com.google.common.collect.ComparisonChain;
import java.util.Comparator;

/* renamed from: rr */
/* loaded from: classes.dex */
public final class C1771rr extends ComparisonChain {

    /* renamed from: d */
    public final int f26117d;

    public C1771rr(int i) {
        this.f26117d = i;
    }

    @Override // com.google.common.collect.ComparisonChain
    public final ComparisonChain compare(Comparable comparable, Comparable comparable2) {
        return this;
    }

    @Override // com.google.common.collect.ComparisonChain
    public final int result() {
        return this.f26117d;
    }

    @Override // com.google.common.collect.ComparisonChain
    public final ComparisonChain compare(Object obj, Object obj2, Comparator comparator) {
        return this;
    }

    @Override // com.google.common.collect.ComparisonChain
    public final ComparisonChain compare(int i, int i2) {
        return this;
    }

    @Override // com.google.common.collect.ComparisonChain
    public final ComparisonChain compare(long j, long j2) {
        return this;
    }

    @Override // com.google.common.collect.ComparisonChain
    public final ComparisonChain compare(float f, float f2) {
        return this;
    }

    @Override // com.google.common.collect.ComparisonChain
    public final ComparisonChain compare(double d, double d2) {
        return this;
    }

    @Override // com.google.common.collect.ComparisonChain
    public final ComparisonChain compareFalseFirst(boolean z, boolean z2) {
        return this;
    }

    @Override // com.google.common.collect.ComparisonChain
    public final ComparisonChain compareTrueFirst(boolean z, boolean z2) {
        return this;
    }
}
