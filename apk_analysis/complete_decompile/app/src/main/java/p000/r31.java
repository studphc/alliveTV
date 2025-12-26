package p000;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableRangeMap;
import com.google.common.collect.Range;
import java.util.Map;

/* loaded from: classes.dex */
public final class r31 extends ImmutableRangeMap {

    /* renamed from: d */
    public final /* synthetic */ Range f25855d;

    /* renamed from: e */
    public final /* synthetic */ ImmutableRangeMap f25856e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r31(q31 q31Var, ImmutableList immutableList, Range range, ImmutableRangeMap immutableRangeMap) {
        super(q31Var, immutableList);
        this.f25855d = range;
        this.f25856e = immutableRangeMap;
    }

    @Override // com.google.common.collect.ImmutableRangeMap, com.google.common.collect.RangeMap
    public final /* bridge */ /* synthetic */ Map asDescendingMapOfRanges() {
        return super.asDescendingMapOfRanges();
    }

    @Override // com.google.common.collect.ImmutableRangeMap, com.google.common.collect.RangeMap
    public final /* bridge */ /* synthetic */ Map asMapOfRanges() {
        return super.asMapOfRanges();
    }

    @Override // com.google.common.collect.ImmutableRangeMap, com.google.common.collect.RangeMap
    public final ImmutableRangeMap subRangeMap(Range range) {
        Range range2 = this.f25855d;
        if (range2.isConnected(range)) {
            return this.f25856e.subRangeMap(range.intersection(range2));
        }
        return ImmutableRangeMap.m3964of();
    }
}
