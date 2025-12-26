package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableRangeMap;
import com.google.common.collect.Range;

/* loaded from: classes.dex */
public final class q31 extends ImmutableList {

    /* renamed from: c */
    public final /* synthetic */ int f25418c;

    /* renamed from: d */
    public final /* synthetic */ int f25419d;

    /* renamed from: e */
    public final /* synthetic */ Range f25420e;

    /* renamed from: f */
    public final /* synthetic */ ImmutableRangeMap f25421f;

    public q31(ImmutableRangeMap immutableRangeMap, int i, int i2, Range range) {
        this.f25421f = immutableRangeMap;
        this.f25418c = i;
        this.f25419d = i2;
        this.f25420e = range;
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
        ImmutableList immutableList2;
        int i2 = this.f25418c;
        Preconditions.checkElementIndex(i, i2);
        int i3 = this.f25419d;
        ImmutableRangeMap immutableRangeMap = this.f25421f;
        if (i == 0 || i == i2 - 1) {
            immutableList = immutableRangeMap.f14687a;
            return ((Range) immutableList.get(i + i3)).intersection(this.f25420e);
        }
        immutableList2 = immutableRangeMap.f14687a;
        return (Range) immutableList2.get(i + i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f25418c;
    }
}
