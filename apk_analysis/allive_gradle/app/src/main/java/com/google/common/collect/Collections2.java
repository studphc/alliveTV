package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import p000.C0529aq;
import p000.C0578c2;
import p000.C1130dq;
import p000.C2065zp;

@GwtCompatible
/* loaded from: classes.dex */
public final class Collections2 {
    /* renamed from: a */
    public static boolean m3834a(List list, List list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        C0869f2 c0869f2 = new C0869f2();
        for (Object obj : list) {
            c0869f2.m4101m(c0869f2.m4092d(obj) + 1, obj);
        }
        C0869f2 c0869f22 = new C0869f2();
        for (Object obj2 : list2) {
            c0869f22.m4101m(c0869f22.m4092d(obj2) + 1, obj2);
        }
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (c0869f2.m4094f(i) != c0869f22.m4092d(c0869f2.m4093e(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static boolean m3835b(Collection collection, Collection collection2) {
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    public static boolean m3836c(Collection collection, Object obj) {
        Preconditions.checkNotNull(collection);
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static <E> Collection<E> filter(Collection<E> collection, Predicate<? super E> predicate) {
        if (collection instanceof C2065zp) {
            C2065zp c2065zp = (C2065zp) collection;
            return new C2065zp(c2065zp.f29458a, Predicates.and(c2065zp.f29459b, predicate));
        }
        return new C2065zp((Collection) Preconditions.checkNotNull(collection), (Predicate) Preconditions.checkNotNull(predicate));
    }

    @Beta
    public static <E extends Comparable<? super E>> Collection<List<E>> orderedPermutations(Iterable<E> iterable) {
        return orderedPermutations(iterable, Ordering.natural());
    }

    @Beta
    public static <E> Collection<List<E>> permutations(Collection<E> collection) {
        return new C0578c2(ImmutableList.copyOf((Collection) collection));
    }

    public static <F, T> Collection<T> transform(Collection<F> collection, Function<? super F, T> function) {
        return new C1130dq(collection, function);
    }

    @Beta
    public static <E> Collection<List<E>> orderedPermutations(Iterable<E> iterable, Comparator<? super E> comparator) {
        return new C0529aq(iterable, comparator);
    }
}
