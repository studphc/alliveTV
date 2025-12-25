package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Comparator;
import p000.C1734qr;
import p000.C1771rr;

@GwtCompatible
/* loaded from: classes.dex */
public abstract class ComparisonChain {

    /* renamed from: a */
    public static final C1734qr f14621a = new Object();

    /* renamed from: b */
    public static final C1771rr f14622b = new C1771rr(-1);

    /* renamed from: c */
    public static final C1771rr f14623c = new C1771rr(1);

    public static ComparisonChain start() {
        return f14621a;
    }

    public abstract ComparisonChain compare(double d, double d2);

    public abstract ComparisonChain compare(float f, float f2);

    public abstract ComparisonChain compare(int i, int i2);

    public abstract ComparisonChain compare(long j, long j2);

    @Deprecated
    public final ComparisonChain compare(Boolean bool, Boolean bool2) {
        return compareFalseFirst(bool.booleanValue(), bool2.booleanValue());
    }

    public abstract ComparisonChain compare(Comparable<?> comparable, Comparable<?> comparable2);

    public abstract <T> ComparisonChain compare(T t, T t2, Comparator<T> comparator);

    public abstract ComparisonChain compareFalseFirst(boolean z, boolean z2);

    public abstract ComparisonChain compareTrueFirst(boolean z, boolean z2);

    public abstract int result();
}
