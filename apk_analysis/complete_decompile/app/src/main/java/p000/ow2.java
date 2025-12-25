package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableRangeSet;
import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;
import java.util.Map;

/* loaded from: classes.dex */
public final class ow2 extends TreeRangeSet {

    /* renamed from: e */
    public final Range f24938e;

    /* renamed from: f */
    public final /* synthetic */ TreeRangeSet f24939f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.AbstractMap, java.util.NavigableMap] */
    public ow2(TreeRangeSet treeRangeSet, Range range) {
        super(new pw2(Range.all(), range, treeRangeSet.f14759a));
        this.f24939f = treeRangeSet;
        this.f24938e = range;
    }

    @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.RangeSet
    public final void add(Range range) {
        Range range2 = this.f24938e;
        Preconditions.checkArgument(range2.encloses(range), "Cannot add range %s to subRangeSet(%s)", range, range2);
        this.f24939f.add(range);
    }

    @Override // com.google.common.collect.TreeRangeSet, p000.AbstractC1672p2, com.google.common.collect.RangeSet
    public final void clear() {
        this.f24939f.remove(this.f24938e);
    }

    @Override // com.google.common.collect.TreeRangeSet, p000.AbstractC1672p2, com.google.common.collect.RangeSet
    public final boolean contains(Comparable comparable) {
        if (this.f24938e.contains(comparable) && this.f24939f.contains(comparable)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.AbstractMap, java.util.NavigableMap] */
    @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.RangeSet
    public final boolean encloses(Range range) {
        Range range2;
        Range range3 = this.f24938e;
        if (range3.isEmpty() || !range3.encloses(range)) {
            return false;
        }
        TreeRangeSet treeRangeSet = this.f24939f;
        treeRangeSet.getClass();
        Preconditions.checkNotNull(range);
        Map.Entry floorEntry = treeRangeSet.f14759a.floorEntry(range.f14747a);
        if (floorEntry != null && ((Range) floorEntry.getValue()).encloses(range)) {
            range2 = (Range) floorEntry.getValue();
        } else {
            range2 = null;
        }
        if (range2 == null || range2.intersection(range3).isEmpty()) {
            return false;
        }
        return true;
    }

    @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.RangeSet
    public final Range rangeContaining(Comparable comparable) {
        Range rangeContaining;
        Range range = this.f24938e;
        if (!range.contains(comparable) || (rangeContaining = this.f24939f.rangeContaining(comparable)) == null) {
            return null;
        }
        return rangeContaining.intersection(range);
    }

    @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.RangeSet
    public final void remove(Range range) {
        Range range2 = this.f24938e;
        if (range.isConnected(range2)) {
            this.f24939f.remove(range.intersection(range2));
        }
    }

    @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.RangeSet
    public final RangeSet subRangeSet(Range range) {
        Range range2 = this.f24938e;
        if (range.encloses(range2)) {
            return this;
        }
        if (range.isConnected(range2)) {
            return new ow2(this, range2.intersection(range));
        }
        return ImmutableRangeSet.m3967of();
    }
}
