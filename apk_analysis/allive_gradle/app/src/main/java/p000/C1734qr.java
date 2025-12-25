package p000;

import com.google.common.collect.ComparisonChain;
import com.google.common.primitives.Booleans;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.util.Comparator;

/* renamed from: qr */
/* loaded from: classes.dex */
public final class C1734qr extends ComparisonChain {
    /* renamed from: a */
    public static ComparisonChain m7117a(int i) {
        if (i < 0) {
            return ComparisonChain.f14622b;
        }
        if (i > 0) {
            return ComparisonChain.f14623c;
        }
        return ComparisonChain.f14621a;
    }

    @Override // com.google.common.collect.ComparisonChain
    public final ComparisonChain compare(Comparable comparable, Comparable comparable2) {
        return m7117a(comparable.compareTo(comparable2));
    }

    @Override // com.google.common.collect.ComparisonChain
    public final ComparisonChain compareFalseFirst(boolean z, boolean z2) {
        return m7117a(Booleans.compare(z, z2));
    }

    @Override // com.google.common.collect.ComparisonChain
    public final ComparisonChain compareTrueFirst(boolean z, boolean z2) {
        return m7117a(Booleans.compare(z2, z));
    }

    @Override // com.google.common.collect.ComparisonChain
    public final int result() {
        return 0;
    }

    @Override // com.google.common.collect.ComparisonChain
    public final ComparisonChain compare(Object obj, Object obj2, Comparator comparator) {
        return m7117a(comparator.compare(obj, obj2));
    }

    @Override // com.google.common.collect.ComparisonChain
    public final ComparisonChain compare(int i, int i2) {
        return m7117a(Ints.compare(i, i2));
    }

    @Override // com.google.common.collect.ComparisonChain
    public final ComparisonChain compare(long j, long j2) {
        return m7117a(Longs.compare(j, j2));
    }

    @Override // com.google.common.collect.ComparisonChain
    public final ComparisonChain compare(float f, float f2) {
        return m7117a(Float.compare(f, f2));
    }

    @Override // com.google.common.collect.ComparisonChain
    public final ComparisonChain compare(double d, double d2) {
        return m7117a(Double.compare(d, d2));
    }
}
