package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableRangeSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Range;

/* loaded from: classes.dex */
public final class w31 extends ImmutableList {

    /* renamed from: c */
    public final boolean f28055c;

    /* renamed from: d */
    public final boolean f28056d;

    /* renamed from: e */
    public final int f28057e;

    /* renamed from: f */
    public final /* synthetic */ ImmutableRangeSet f28058f;

    /* JADX WARN: Multi-variable type inference failed */
    public w31(ImmutableRangeSet immutableRangeSet) {
        ImmutableList immutableList;
        ImmutableList immutableList2;
        ImmutableList immutableList3;
        this.f28058f = immutableRangeSet;
        immutableList = immutableRangeSet.f14692a;
        boolean hasLowerBound = ((Range) immutableList.get(0)).hasLowerBound();
        this.f28055c = hasLowerBound;
        immutableList2 = immutableRangeSet.f14692a;
        boolean hasUpperBound = ((Range) Iterables.getLast(immutableList2)).hasUpperBound();
        this.f28056d = hasUpperBound;
        immutableList3 = immutableRangeSet.f14692a;
        int size = immutableList3.size();
        size = hasLowerBound ? size : size - 1;
        this.f28057e = hasUpperBound ? size + 1 : size;
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: e */
    public final boolean mo7e() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.List
    public final Object get(int i) {
        ImmutableList immutableList;
        AbstractC1814sx abstractC1814sx;
        ImmutableList immutableList2;
        AbstractC1814sx abstractC1814sx2;
        ImmutableList immutableList3;
        int i2 = this.f28057e;
        Preconditions.checkElementIndex(i, i2);
        ImmutableRangeSet immutableRangeSet = this.f28058f;
        boolean z = this.f28055c;
        if (!z) {
            immutableList = immutableRangeSet.f14692a;
            abstractC1814sx = ((Range) immutableList.get(i)).f14748b;
        } else if (i != 0) {
            immutableList3 = immutableRangeSet.f14692a;
            abstractC1814sx = ((Range) immutableList3.get(i - 1)).f14748b;
        } else {
            abstractC1814sx = C1740qx.f25786b;
        }
        if (!this.f28056d || i != i2 - 1) {
            immutableList2 = immutableRangeSet.f14692a;
            abstractC1814sx2 = ((Range) immutableList2.get(i + (!z ? 1 : 0))).f14747a;
        } else {
            abstractC1814sx2 = C1666ox.f24940b;
        }
        return Range.m4068a(abstractC1814sx, abstractC1814sx2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f28057e;
    }
}
