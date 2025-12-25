package p000;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;

/* loaded from: classes.dex */
public final class lw2 extends TreeRangeSet {

    /* renamed from: e */
    public final /* synthetic */ TreeRangeSet f22699e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.AbstractMap, java.util.NavigableMap] */
    public lw2(TreeRangeSet treeRangeSet) {
        super(new nw2(treeRangeSet.f14759a, Range.all()));
        this.f22699e = treeRangeSet;
    }

    @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.RangeSet
    public final void add(Range range) {
        this.f22699e.remove(range);
    }

    @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.RangeSet
    public final RangeSet complement() {
        return this.f22699e;
    }

    @Override // com.google.common.collect.TreeRangeSet, p000.AbstractC1672p2, com.google.common.collect.RangeSet
    public final boolean contains(Comparable comparable) {
        return !this.f22699e.contains(comparable);
    }

    @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.RangeSet
    public final void remove(Range range) {
        this.f22699e.add(range);
    }
}
