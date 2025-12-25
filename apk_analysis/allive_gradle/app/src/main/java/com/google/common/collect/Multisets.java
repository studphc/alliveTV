package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import p000.jq1;
import p000.p63;

@GwtCompatible
/* loaded from: classes.dex */
public final class Multisets {
    /* renamed from: a */
    public static boolean m4060a(Multiset multiset, Collection collection) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(collection);
        if (collection instanceof Multiset) {
            Multiset multiset2 = (Multiset) collection;
            if (multiset2 instanceof AbstractC0846b) {
                AbstractC0846b abstractC0846b = (AbstractC0846b) multiset2;
                if (abstractC0846b.isEmpty()) {
                    return false;
                }
                Preconditions.checkNotNull(multiset);
                for (int mo4091c = abstractC0846b.f14773c.mo4091c(); mo4091c >= 0; mo4091c = abstractC0846b.f14773c.mo4099k(mo4091c)) {
                    multiset.add(abstractC0846b.f14773c.m4093e(mo4091c), abstractC0846b.f14773c.m4094f(mo4091c));
                }
            } else {
                if (multiset2.isEmpty()) {
                    return false;
                }
                for (Multiset.Entry entry : multiset2.entrySet()) {
                    multiset.add(entry.getElement(), entry.getCount());
                }
            }
            return true;
        }
        if (collection.isEmpty()) {
            return false;
        }
        return Iterators.addAll(multiset, collection.iterator());
    }

    /* renamed from: b */
    public static boolean m4061b(Multiset multiset, Object obj) {
        if (obj == multiset) {
            return true;
        }
        if (obj instanceof Multiset) {
            Multiset multiset2 = (Multiset) obj;
            if (multiset.size() == multiset2.size() && multiset.entrySet().size() == multiset2.entrySet().size()) {
                for (Multiset.Entry entry : multiset2.entrySet()) {
                    if (multiset.count(entry.getElement()) != entry.getCount()) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public static C0859d2 m4062c(Multiset multiset) {
        return new C0859d2(multiset, multiset.entrySet().iterator());
    }

    @CanIgnoreReturnValue
    public static boolean containsOccurrences(Multiset<?> multiset, Multiset<?> multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        for (Multiset.Entry<?> entry : multiset2.entrySet()) {
            if (multiset.count(entry.getElement()) < entry.getCount()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Beta
    public static <E> ImmutableMultiset<E> copyHighestCountFirst(Multiset<E> multiset) {
        Multiset.Entry[] entryArr = (Multiset.Entry[]) multiset.entrySet().toArray(new Multiset.Entry[0]);
        Arrays.sort(entryArr, C0959z1.f14997a);
        List<Multiset.Entry> asList = Arrays.asList(entryArr);
        int i = ImmutableMultiset.f14680d;
        ImmutableMultiset.Builder builder = new ImmutableMultiset.Builder(asList.size());
        for (Multiset.Entry entry : asList) {
            builder.addCopies(entry.getElement(), entry.getCount());
        }
        return builder.build();
    }

    /* renamed from: d */
    public static int m4063d(Multiset multiset) {
        long j = 0;
        while (multiset.entrySet().iterator().hasNext()) {
            j += ((Multiset.Entry) r4.next()).getCount();
        }
        return Ints.saturatedCast(j);
    }

    @Beta
    public static <E> Multiset<E> difference(Multiset<E> multiset, Multiset<?> multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        return new C0947w1(multiset, multiset2);
    }

    /* renamed from: e */
    public static boolean m4064e(Multiset multiset, Object obj, int i, int i2) {
        p63.m6869m(i, "oldCount");
        p63.m6869m(i2, "newCount");
        if (multiset.count(obj) == i) {
            multiset.setCount(obj, i2);
            return true;
        }
        return false;
    }

    @Beta
    public static <E> Multiset<E> filter(Multiset<E> multiset, Predicate<? super E> predicate) {
        if (multiset instanceof C0854c2) {
            C0854c2 c0854c2 = (C0854c2) multiset;
            return new C0854c2(c0854c2.f14786c, Predicates.and(c0854c2.f14787d, predicate));
        }
        return new C0854c2(multiset, predicate);
    }

    public static <E> Multiset.Entry<E> immutableEntry(E e, int i) {
        return new jq1(i, e);
    }

    public static <E> Multiset<E> intersection(Multiset<E> multiset, Multiset<?> multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        return new C0927r1(multiset, multiset2);
    }

    @CanIgnoreReturnValue
    public static boolean removeOccurrences(Multiset<?> multiset, Iterable<?> iterable) {
        if (iterable instanceof Multiset) {
            return removeOccurrences(multiset, (Multiset<?>) iterable);
        }
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(iterable);
        Iterator<?> it = iterable.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= multiset.remove(it.next());
        }
        return z;
    }

    @CanIgnoreReturnValue
    public static boolean retainOccurrences(Multiset<?> multiset, Multiset<?> multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        Iterator<Multiset.Entry<?>> it = multiset.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            Multiset.Entry<?> next = it.next();
            int count = multiset2.count(next.getElement());
            if (count == 0) {
                it.remove();
            } else if (count < next.getCount()) {
                multiset.setCount(next.getElement(), count);
            }
            z = true;
        }
        return z;
    }

    @Beta
    public static <E> Multiset<E> sum(Multiset<? extends E> multiset, Multiset<? extends E> multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        return new C0935t1(multiset, multiset2);
    }

    @Beta
    public static <E> Multiset<E> union(Multiset<? extends E> multiset, Multiset<? extends E> multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        return new C0918p1(multiset, multiset2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> Multiset<E> unmodifiableMultiset(Multiset<? extends E> multiset) {
        return ((multiset instanceof C0864e2) || (multiset instanceof ImmutableMultiset)) ? multiset : new C0864e2((Multiset) Preconditions.checkNotNull(multiset));
    }

    @Beta
    public static <E> SortedMultiset<E> unmodifiableSortedMultiset(SortedMultiset<E> sortedMultiset) {
        return (SortedMultiset<E>) new C0864e2((SortedMultiset) Preconditions.checkNotNull(sortedMultiset));
    }

    @Deprecated
    public static <E> Multiset<E> unmodifiableMultiset(ImmutableMultiset<E> immutableMultiset) {
        return (Multiset) Preconditions.checkNotNull(immutableMultiset);
    }

    @CanIgnoreReturnValue
    public static boolean removeOccurrences(Multiset<?> multiset, Multiset<?> multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        Iterator<Multiset.Entry<?>> it = multiset.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            Multiset.Entry<?> next = it.next();
            int count = multiset2.count(next.getElement());
            if (count >= next.getCount()) {
                it.remove();
            } else if (count > 0) {
                multiset.remove(next.getElement(), count);
            }
            z = true;
        }
        return z;
    }
}
