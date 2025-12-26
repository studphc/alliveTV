package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableRangeSet;
import com.google.common.collect.Range;

/* loaded from: classes.dex */
public final class s31 extends ImmutableList {

    /* renamed from: c */
    public final /* synthetic */ int f26224c;

    /* renamed from: d */
    public final /* synthetic */ int f26225d;

    /* renamed from: e */
    public final /* synthetic */ Range f26226e;

    /* renamed from: f */
    public final /* synthetic */ ImmutableRangeSet f26227f;

    public s31(ImmutableRangeSet immutableRangeSet, int i, int i2, Range range) {
        this.f26227f = immutableRangeSet;
        this.f26224c = i;
        this.f26225d = i2;
        this.f26226e = range;
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
        int i2 = this.f26224c;
        Preconditions.checkElementIndex(i, i2);
        int i3 = this.f26225d;
        ImmutableRangeSet immutableRangeSet = this.f26227f;
        if (i == 0 || i == i2 - 1) {
            immutableList = immutableRangeSet.f14692a;
            return ((Range) immutableList.get(i + i3)).intersection(this.f26226e);
        }
        immutableList2 = immutableRangeSet.f14692a;
        return (Range) immutableList2.get(i + i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f26224c;
    }
}
