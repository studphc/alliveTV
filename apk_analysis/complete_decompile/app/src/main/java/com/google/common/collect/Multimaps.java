package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import p000.AbstractC1546mf;
import p000.AbstractC1930w1;
import p000.cq1;
import p000.dq1;
import p000.eq1;
import p000.fq1;
import p000.gq1;
import p000.kr2;
import p000.md0;
import p000.mr2;
import p000.ng1;
import p000.od0;
import p000.pr2;
import p000.rd0;
import p000.td0;
import p000.tr2;
import p000.ud0;
import p000.vd0;
import p000.wp1;
import p000.wr2;
import p000.yp1;
import p000.zp1;

@GwtCompatible(emulated = true)
/* loaded from: classes.dex */
public final class Multimaps {
    /* renamed from: a */
    public static Collection m4059a(Collection collection) {
        if (collection instanceof SortedSet) {
            return Collections.unmodifiableSortedSet((SortedSet) collection);
        }
        if (collection instanceof Set) {
            return Collections.unmodifiableSet((Set) collection);
        }
        if (collection instanceof List) {
            return Collections.unmodifiableList((List) collection);
        }
        return Collections.unmodifiableCollection(collection);
    }

    @Beta
    public static <K, V> Map<K, List<V>> asMap(ListMultimap<K, V> listMultimap) {
        return listMultimap.asMap();
    }

    public static <K, V> Multimap<K, V> filterEntries(Multimap<K, V> multimap, Predicate<? super Map.Entry<K, V>> predicate) {
        Preconditions.checkNotNull(predicate);
        if (multimap instanceof SetMultimap) {
            return filterEntries((SetMultimap) multimap, (Predicate) predicate);
        }
        if (multimap instanceof ud0) {
            ud0 ud0Var = (ud0) multimap;
            return new md0(ud0Var.mo6136a(), Predicates.and(ud0Var.mo6137c(), predicate));
        }
        return new md0((Multimap) Preconditions.checkNotNull(multimap), predicate);
    }

    public static <K, V> Multimap<K, V> filterKeys(Multimap<K, V> multimap, Predicate<? super K> predicate) {
        if (multimap instanceof SetMultimap) {
            return filterKeys((SetMultimap) multimap, (Predicate) predicate);
        }
        if (multimap instanceof ListMultimap) {
            return filterKeys((ListMultimap) multimap, (Predicate) predicate);
        }
        if (multimap instanceof rd0) {
            rd0 rd0Var = (rd0) multimap;
            return new rd0(rd0Var.f25933f, Predicates.and(rd0Var.f25934g, predicate));
        }
        if (multimap instanceof ud0) {
            ud0 ud0Var = (ud0) multimap;
            return new md0(ud0Var.mo6136a(), Predicates.and(ud0Var.mo6137c(), Predicates.compose(predicate, ng1.f23353a)));
        }
        return new rd0(multimap, predicate);
    }

    public static <K, V> Multimap<K, V> filterValues(Multimap<K, V> multimap, Predicate<? super V> predicate) {
        return filterEntries(multimap, Predicates.compose(predicate, ng1.f23354b));
    }

    public static <K, V> SetMultimap<K, V> forMap(Map<K, V> map) {
        return new cq1(map);
    }

    public static <K, V> ImmutableListMultimap<K, V> index(Iterable<V> iterable, Function<? super V, K> function) {
        return index(iterable.iterator(), function);
    }

    @CanIgnoreReturnValue
    public static <K, V, M extends Multimap<K, V>> M invertFrom(Multimap<? extends V, ? extends K> multimap, M m) {
        Preconditions.checkNotNull(m);
        for (Map.Entry<? extends V, ? extends K> entry : multimap.entries()) {
            m.put(entry.getValue(), entry.getKey());
        }
        return m;
    }

    public static <K, V> ListMultimap<K, V> newListMultimap(Map<K, Collection<V>> map, Supplier<? extends List<V>> supplier) {
        wp1 wp1Var = (ListMultimap<K, V>) new AbstractC1930w1(map);
        wp1Var.f28269h = (Supplier) Preconditions.checkNotNull(supplier);
        return wp1Var;
    }

    public static <K, V> Multimap<K, V> newMultimap(Map<K, Collection<V>> map, Supplier<? extends Collection<V>> supplier) {
        AbstractC1930w1 abstractC1930w1 = new AbstractC1930w1(map);
        abstractC1930w1.f28678h = (Supplier) Preconditions.checkNotNull(supplier);
        return abstractC1930w1;
    }

    public static <K, V> SetMultimap<K, V> newSetMultimap(Map<K, Collection<V>> map, Supplier<? extends Set<V>> supplier) {
        yp1 yp1Var = (SetMultimap<K, V>) new AbstractC1930w1(map);
        yp1Var.f29058h = (Supplier) Preconditions.checkNotNull(supplier);
        return yp1Var;
    }

    public static <K, V> SortedSetMultimap<K, V> newSortedSetMultimap(Map<K, Collection<V>> map, Supplier<? extends SortedSet<V>> supplier) {
        zp1 zp1Var = (SortedSetMultimap<K, V>) new AbstractC1930w1(map);
        zp1Var.f29460h = (Supplier) Preconditions.checkNotNull(supplier);
        zp1Var.f29461i = supplier.get().comparator();
        return zp1Var;
    }

    public static <K, V> ListMultimap<K, V> synchronizedListMultimap(ListMultimap<K, V> listMultimap) {
        if (!(listMultimap instanceof kr2) && !(listMultimap instanceof AbstractC1546mf)) {
            return (ListMultimap<K, V>) new pr2(listMultimap, null);
        }
        return listMultimap;
    }

    public static <K, V> Multimap<K, V> synchronizedMultimap(Multimap<K, V> multimap) {
        if (!(multimap instanceof mr2) && !(multimap instanceof AbstractC1546mf)) {
            return (Multimap<K, V>) new pr2(multimap, null);
        }
        return multimap;
    }

    public static <K, V> SetMultimap<K, V> synchronizedSetMultimap(SetMultimap<K, V> setMultimap) {
        if (!(setMultimap instanceof tr2) && !(setMultimap instanceof AbstractC1546mf)) {
            return (SetMultimap<K, V>) new pr2(setMultimap, null);
        }
        return setMultimap;
    }

    public static <K, V> SortedSetMultimap<K, V> synchronizedSortedSetMultimap(SortedSetMultimap<K, V> sortedSetMultimap) {
        if (!(sortedSetMultimap instanceof wr2)) {
            return (SortedSetMultimap<K, V>) new pr2(sortedSetMultimap, null);
        }
        return sortedSetMultimap;
    }

    public static <K, V1, V2> Multimap<K, V2> transformEntries(Multimap<K, V1> multimap, Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new C0908n1(multimap, entryTransformer);
    }

    public static <K, V1, V2> Multimap<K, V2> transformValues(Multimap<K, V1> multimap, Function<? super V1, V2> function) {
        Preconditions.checkNotNull(function);
        Preconditions.checkNotNull(function);
        return transformEntries(multimap, new C0926r0(function));
    }

    public static <K, V> ListMultimap<K, V> unmodifiableListMultimap(ListMultimap<K, V> listMultimap) {
        return ((listMultimap instanceof dq1) || (listMultimap instanceof ImmutableListMultimap)) ? listMultimap : (ListMultimap<K, V>) new eq1(listMultimap);
    }

    public static <K, V> Multimap<K, V> unmodifiableMultimap(Multimap<K, V> multimap) {
        return ((multimap instanceof eq1) || (multimap instanceof ImmutableMultimap)) ? multimap : new eq1(multimap);
    }

    public static <K, V> SetMultimap<K, V> unmodifiableSetMultimap(SetMultimap<K, V> setMultimap) {
        return ((setMultimap instanceof fq1) || (setMultimap instanceof ImmutableSetMultimap)) ? setMultimap : (SetMultimap<K, V>) new eq1(setMultimap);
    }

    public static <K, V> SortedSetMultimap<K, V> unmodifiableSortedSetMultimap(SortedSetMultimap<K, V> sortedSetMultimap) {
        if (sortedSetMultimap instanceof gq1) {
            return sortedSetMultimap;
        }
        return (SortedSetMultimap<K, V>) new eq1(sortedSetMultimap);
    }

    @Beta
    public static <K, V> Map<K, Set<V>> asMap(SetMultimap<K, V> setMultimap) {
        return setMultimap.asMap();
    }

    public static <K, V> ImmutableListMultimap<K, V> index(Iterator<V> it, Function<? super V, K> function) {
        Preconditions.checkNotNull(function);
        ImmutableListMultimap.Builder builder = ImmutableListMultimap.builder();
        while (it.hasNext()) {
            V next = it.next();
            Preconditions.checkNotNull(next, it);
            builder.put((ImmutableListMultimap.Builder) function.apply(next), (K) next);
        }
        return builder.build();
    }

    public static <K, V1, V2> ListMultimap<K, V2> transformEntries(ListMultimap<K, V1> listMultimap, Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return (ListMultimap<K, V2>) new C0908n1(listMultimap, entryTransformer);
    }

    @Beta
    public static <K, V> Map<K, SortedSet<V>> asMap(SortedSetMultimap<K, V> sortedSetMultimap) {
        return sortedSetMultimap.asMap();
    }

    public static <K, V> SetMultimap<K, V> filterValues(SetMultimap<K, V> setMultimap, Predicate<? super V> predicate) {
        return filterEntries((SetMultimap) setMultimap, Predicates.compose(predicate, ng1.f23354b));
    }

    @Deprecated
    public static <K, V> Multimap<K, V> unmodifiableMultimap(ImmutableMultimap<K, V> immutableMultimap) {
        return (Multimap) Preconditions.checkNotNull(immutableMultimap);
    }

    @Beta
    public static <K, V> Map<K, Collection<V>> asMap(Multimap<K, V> multimap) {
        return multimap.asMap();
    }

    @Deprecated
    public static <K, V> ListMultimap<K, V> unmodifiableListMultimap(ImmutableListMultimap<K, V> immutableListMultimap) {
        return (ListMultimap) Preconditions.checkNotNull(immutableListMultimap);
    }

    @Deprecated
    public static <K, V> SetMultimap<K, V> unmodifiableSetMultimap(ImmutableSetMultimap<K, V> immutableSetMultimap) {
        return (SetMultimap) Preconditions.checkNotNull(immutableSetMultimap);
    }

    public static <K, V1, V2> ListMultimap<K, V2> transformValues(ListMultimap<K, V1> listMultimap, Function<? super V1, V2> function) {
        Preconditions.checkNotNull(function);
        Preconditions.checkNotNull(function);
        return transformEntries((ListMultimap) listMultimap, (Maps.EntryTransformer) new C0926r0(function));
    }

    public static <K, V> SetMultimap<K, V> filterEntries(SetMultimap<K, V> setMultimap, Predicate<? super Map.Entry<K, V>> predicate) {
        Preconditions.checkNotNull(predicate);
        if (setMultimap instanceof vd0) {
            vd0 vd0Var = (vd0) setMultimap;
            return (SetMultimap<K, V>) new md0(vd0Var.mo6136a(), Predicates.and(vd0Var.mo6137c(), predicate));
        }
        return (SetMultimap<K, V>) new md0((SetMultimap) Preconditions.checkNotNull(setMultimap), predicate);
    }

    public static <K, V> SetMultimap<K, V> filterKeys(SetMultimap<K, V> setMultimap, Predicate<? super K> predicate) {
        if (setMultimap instanceof td0) {
            td0 td0Var = (td0) setMultimap;
            return (SetMultimap<K, V>) new rd0((SetMultimap) td0Var.f25933f, Predicates.and(td0Var.f25934g, predicate));
        }
        if (setMultimap instanceof vd0) {
            vd0 vd0Var = (vd0) setMultimap;
            return (SetMultimap<K, V>) new md0(vd0Var.mo6136a(), Predicates.and(vd0Var.mo6137c(), Predicates.compose(predicate, ng1.f23353a)));
        }
        return (SetMultimap<K, V>) new rd0(setMultimap, predicate);
    }

    public static <K, V> ListMultimap<K, V> filterKeys(ListMultimap<K, V> listMultimap, Predicate<? super K> predicate) {
        if (listMultimap instanceof od0) {
            od0 od0Var = (od0) listMultimap;
            return (ListMultimap<K, V>) new rd0((ListMultimap) od0Var.f25933f, Predicates.and(od0Var.f25934g, predicate));
        }
        return (ListMultimap<K, V>) new rd0(listMultimap, predicate);
    }
}
