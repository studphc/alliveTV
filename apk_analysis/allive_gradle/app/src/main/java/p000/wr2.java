package p000;

import com.google.common.collect.Multimap;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.SortedSetMultimap;
import java.util.Comparator;
import java.util.SortedSet;

/* loaded from: classes.dex */
public final class wr2 extends tr2 implements SortedSetMultimap {
    private static final long serialVersionUID = 0;

    @Override // p000.tr2, p000.mr2
    /* renamed from: e */
    public final Multimap mo5783e() {
        return (SortedSetMultimap) super.mo5783e();
    }

    @Override // p000.tr2
    /* renamed from: f */
    public final SetMultimap mo5783e() {
        return (SortedSetMultimap) super.mo5783e();
    }

    @Override // com.google.common.collect.SortedSetMultimap
    public final Comparator valueComparator() {
        Comparator valueComparator;
        synchronized (this.f25273b) {
            valueComparator = ((SortedSetMultimap) super.mo5783e()).valueComparator();
        }
        return valueComparator;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [pr2, java.util.SortedSet] */
    @Override // p000.tr2, p000.mr2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final SortedSet get(Object obj) {
        ?? pr2Var;
        synchronized (this.f25273b) {
            pr2Var = new pr2(((SortedSetMultimap) super.mo5783e()).get((SortedSetMultimap) obj), this.f25273b);
        }
        return pr2Var;
    }

    @Override // p000.tr2, p000.mr2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final SortedSet removeAll(Object obj) {
        SortedSet removeAll;
        synchronized (this.f25273b) {
            removeAll = ((SortedSetMultimap) super.mo5783e()).removeAll(obj);
        }
        return removeAll;
    }

    @Override // p000.tr2, p000.mr2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final SortedSet replaceValues(Object obj, Iterable iterable) {
        SortedSet replaceValues;
        synchronized (this.f25273b) {
            replaceValues = ((SortedSetMultimap) super.mo5783e()).replaceValues((SortedSetMultimap) obj, iterable);
        }
        return replaceValues;
    }
}
