package p000;

import com.google.common.collect.Multimap;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.SortedSetMultimap;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;

/* loaded from: classes.dex */
public final class gq1 extends fq1 implements SortedSetMultimap {
    private static final long serialVersionUID = 0;

    @Override // p000.fq1, p000.eq1, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
    public final Multimap delegate() {
        return (SortedSetMultimap) ((SetMultimap) this.f16945a);
    }

    @Override // p000.fq1, p000.eq1, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final SortedSet get(Object obj) {
        return Collections.unmodifiableSortedSet(((SortedSetMultimap) ((SetMultimap) this.f16945a)).get((SortedSetMultimap) obj));
    }

    @Override // p000.fq1, p000.eq1, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final Collection removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // p000.fq1, p000.eq1, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final Collection replaceValues(Object obj, Iterable iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.SortedSetMultimap
    public final Comparator valueComparator() {
        return ((SortedSetMultimap) ((SetMultimap) this.f16945a)).valueComparator();
    }

    @Override // p000.fq1, p000.eq1, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final Set removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // p000.fq1, p000.eq1, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final Set replaceValues(Object obj, Iterable iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // p000.fq1, p000.eq1, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
    public final SetMultimap delegate() {
        return (SortedSetMultimap) ((SetMultimap) this.f16945a);
    }

    @Override // p000.fq1, p000.eq1, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final SortedSet removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // p000.fq1, p000.eq1, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final SortedSet replaceValues(Object obj, Iterable iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // p000.fq1, p000.eq1, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
    public final Object delegate() {
        return (SortedSetMultimap) ((SetMultimap) this.f16945a);
    }
}
