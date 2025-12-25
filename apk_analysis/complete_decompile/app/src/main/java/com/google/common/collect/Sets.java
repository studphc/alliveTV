package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.CheckForNull;
import p000.C2065zp;
import p000.ih2;
import p000.jh2;
import p000.mh2;
import p000.o21;
import p000.p63;
import p000.ph2;
import p000.pr2;
import p000.qh2;

@GwtCompatible(emulated = true)
/* loaded from: classes.dex */
public final class Sets {

    /* loaded from: classes.dex */
    public static abstract class SetView<E> extends AbstractSet<E> {
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        @DoNotCall("Always throws UnsupportedOperationException")
        @Deprecated
        public final boolean add(E e) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        @DoNotCall("Always throws UnsupportedOperationException")
        @Deprecated
        public final boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @DoNotCall("Always throws UnsupportedOperationException")
        @Deprecated
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        @CanIgnoreReturnValue
        public <S extends Set<E>> S copyInto(S s) {
            s.addAll(this);
            return s;
        }

        public ImmutableSet<E> immutableCopy() {
            return ImmutableSet.copyOf((Collection) this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public abstract UnmodifiableIterator<E> iterator();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        @DoNotCall("Always throws UnsupportedOperationException")
        @Deprecated
        public final boolean remove(@CheckForNull Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        @DoNotCall("Always throws UnsupportedOperationException")
        @Deprecated
        public final boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        @DoNotCall("Always throws UnsupportedOperationException")
        @Deprecated
        public final boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: a */
    public static boolean m4069a(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    /* renamed from: b */
    public static int m4070b(Set set) {
        int i;
        int i2 = 0;
        for (Object obj : set) {
            if (obj != null) {
                i = obj.hashCode();
            } else {
                i = 0;
            }
            i2 = ~(~(i2 + i));
        }
        return i2;
    }

    /* renamed from: c */
    public static boolean m4071c(Set set, Collection collection) {
        Preconditions.checkNotNull(collection);
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).elementSet();
        }
        if ((collection instanceof Set) && collection.size() > set.size()) {
            return Iterators.removeAll(set.iterator(), collection);
        }
        return m4072d(set, collection.iterator());
    }

    @SafeVarargs
    public static <B> Set<List<B>> cartesianProduct(Set<? extends B>... setArr) {
        return cartesianProduct(Arrays.asList(setArr));
    }

    @Beta
    public static <E> Set<Set<E>> combinations(Set<E> set, int i) {
        boolean z;
        ImmutableMap m4049e = Maps.m4049e(set);
        p63.m6869m(i, "size");
        if (i <= m4049e.size()) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "size (%s) must be <= set.size() (%s)", i, m4049e.size());
        if (i == 0) {
            return ImmutableSet.m3972of(ImmutableSet.m3971of());
        }
        if (i == m4049e.size()) {
            return ImmutableSet.m3972of(m4049e.keySet());
        }
        return new ih2(i, m4049e);
    }

    public static <E extends Enum<E>> EnumSet<E> complementOf(Collection<E> collection) {
        if (collection instanceof EnumSet) {
            return EnumSet.complementOf((EnumSet) collection);
        }
        Preconditions.checkArgument(!collection.isEmpty(), "collection is empty; use the other version of this method");
        EnumSet<E> allOf = EnumSet.allOf(collection.iterator().next().getDeclaringClass());
        allOf.removeAll(collection);
        return allOf;
    }

    /* renamed from: d */
    public static boolean m4072d(Set set, Iterator it) {
        boolean z = false;
        while (it.hasNext()) {
            z |= set.remove(it.next());
        }
        return z;
    }

    public static <E> SetView<E> difference(Set<E> set, Set<?> set2) {
        Preconditions.checkNotNull(set, "set1");
        Preconditions.checkNotNull(set2, "set2");
        return new C0936t2(set, set2);
    }

    public static <E> Set<E> filter(Set<E> set, Predicate<? super E> predicate) {
        if (set instanceof SortedSet) {
            return filter((SortedSet) set, (Predicate) predicate);
        }
        if (set instanceof mh2) {
            mh2 mh2Var = (mh2) set;
            return (Set<E>) new C2065zp((Set) mh2Var.f29458a, Predicates.and(mh2Var.f29459b, predicate));
        }
        return (Set<E>) new C2065zp((Set) Preconditions.checkNotNull(set), (Predicate) Preconditions.checkNotNull(predicate));
    }

    @GwtCompatible(serializable = true)
    public static <E extends Enum<E>> ImmutableSet<E> immutableEnumSet(E e, E... eArr) {
        return o21.m6407j(EnumSet.of((Enum) e, (Enum[]) eArr));
    }

    public static <E> SetView<E> intersection(Set<E> set, Set<?> set2) {
        Preconditions.checkNotNull(set, "set1");
        Preconditions.checkNotNull(set2, "set2");
        return new C0932s2(set, set2);
    }

    public static <E> Set<E> newConcurrentHashSet() {
        return Collections.newSetFromMap(new ConcurrentHashMap());
    }

    @GwtIncompatible
    public static <E> CopyOnWriteArraySet<E> newCopyOnWriteArraySet() {
        return new CopyOnWriteArraySet<>();
    }

    public static <E extends Enum<E>> EnumSet<E> newEnumSet(Iterable<E> iterable, Class<E> cls) {
        EnumSet<E> noneOf = EnumSet.noneOf(cls);
        Iterables.addAll(noneOf, iterable);
        return noneOf;
    }

    public static <E> HashSet<E> newHashSet() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> newHashSetWithExpectedSize(int i) {
        return new HashSet<>(Maps.m4047c(i));
    }

    public static <E> Set<E> newIdentityHashSet() {
        return Collections.newSetFromMap(Maps.newIdentityHashMap());
    }

    public static <E> LinkedHashSet<E> newLinkedHashSet() {
        return new LinkedHashSet<>();
    }

    public static <E> LinkedHashSet<E> newLinkedHashSetWithExpectedSize(int i) {
        return new LinkedHashSet<>(Maps.m4047c(i));
    }

    @Deprecated
    public static <E> Set<E> newSetFromMap(Map<E, Boolean> map) {
        return Collections.newSetFromMap(map);
    }

    public static <E extends Comparable> TreeSet<E> newTreeSet() {
        return new TreeSet<>();
    }

    @GwtCompatible(serializable = false)
    public static <E> Set<Set<E>> powerSet(Set<E> set) {
        return new ph2(set);
    }

    @Beta
    @GwtIncompatible
    public static <K extends Comparable<? super K>> NavigableSet<K> subSet(NavigableSet<K> navigableSet, Range<K> range) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        if (navigableSet.comparator() != null && navigableSet.comparator() != Ordering.natural() && range.hasLowerBound() && range.hasUpperBound()) {
            if (navigableSet.comparator().compare(range.lowerEndpoint(), range.upperEndpoint()) <= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkArgument(z2, "set is using a custom comparator which is inconsistent with the natural ordering.");
        }
        if (range.hasLowerBound() && range.hasUpperBound()) {
            K lowerEndpoint = range.lowerEndpoint();
            BoundType lowerBoundType = range.lowerBoundType();
            BoundType boundType = BoundType.CLOSED;
            if (lowerBoundType == boundType) {
                z = true;
            } else {
                z = false;
            }
            K upperEndpoint = range.upperEndpoint();
            if (range.upperBoundType() == boundType) {
                z3 = true;
            }
            return navigableSet.subSet(lowerEndpoint, z, upperEndpoint, z3);
        }
        if (range.hasLowerBound()) {
            K lowerEndpoint2 = range.lowerEndpoint();
            if (range.lowerBoundType() == BoundType.CLOSED) {
                z3 = true;
            }
            return navigableSet.tailSet(lowerEndpoint2, z3);
        }
        if (range.hasUpperBound()) {
            K upperEndpoint2 = range.upperEndpoint();
            if (range.upperBoundType() == BoundType.CLOSED) {
                z3 = true;
            }
            return navigableSet.headSet(upperEndpoint2, z3);
        }
        return (NavigableSet) Preconditions.checkNotNull(navigableSet);
    }

    public static <E> SetView<E> symmetricDifference(Set<? extends E> set, Set<? extends E> set2) {
        Preconditions.checkNotNull(set, "set1");
        Preconditions.checkNotNull(set2, "set2");
        return new C0940u2(set, set2);
    }

    @GwtIncompatible
    public static <E> NavigableSet<E> synchronizedNavigableSet(NavigableSet<E> navigableSet) {
        return (NavigableSet<E>) new pr2(navigableSet, null);
    }

    public static <E> SetView<E> union(Set<? extends E> set, Set<? extends E> set2) {
        Preconditions.checkNotNull(set, "set1");
        Preconditions.checkNotNull(set2, "set2");
        return new C0928r2(set, set2);
    }

    public static <E> NavigableSet<E> unmodifiableNavigableSet(NavigableSet<E> navigableSet) {
        if (!(navigableSet instanceof ImmutableCollection) && !(navigableSet instanceof qh2)) {
            return new qh2(navigableSet);
        }
        return navigableSet;
    }

    public static <B> Set<List<B>> cartesianProduct(List<? extends Set<? extends B>> list) {
        AbstractC0957z abstractC0957z = new AbstractC0957z(list.size());
        Iterator<? extends Set<? extends B>> it = list.iterator();
        while (it.hasNext()) {
            ImmutableSet copyOf = ImmutableSet.copyOf((Collection) it.next());
            if (copyOf.isEmpty()) {
                return ImmutableSet.m3971of();
            }
            abstractC0957z.add((AbstractC0957z) copyOf);
        }
        ImmutableList build = abstractC0957z.build();
        return new C0944v2(build, new C0896l(new jh2(build)));
    }

    @GwtCompatible(serializable = true)
    public static <E extends Enum<E>> ImmutableSet<E> immutableEnumSet(Iterable<E> iterable) {
        if (iterable instanceof o21) {
            return (o21) iterable;
        }
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.isEmpty()) {
                return ImmutableSet.m3971of();
            }
            return o21.m6407j(EnumSet.copyOf(collection));
        }
        Iterator<E> it = iterable.iterator();
        if (it.hasNext()) {
            EnumSet of = EnumSet.of((Enum) it.next());
            Iterators.addAll(of, it);
            return o21.m6407j(of);
        }
        return ImmutableSet.m3971of();
    }

    public static <E> Set<E> newConcurrentHashSet(Iterable<? extends E> iterable) {
        Set<E> newConcurrentHashSet = newConcurrentHashSet();
        Iterables.addAll(newConcurrentHashSet, iterable);
        return newConcurrentHashSet;
    }

    @GwtIncompatible
    public static <E> CopyOnWriteArraySet<E> newCopyOnWriteArraySet(Iterable<? extends E> iterable) {
        Collection newArrayList;
        if (iterable instanceof Collection) {
            newArrayList = (Collection) iterable;
        } else {
            newArrayList = Lists.newArrayList(iterable);
        }
        return new CopyOnWriteArraySet<>(newArrayList);
    }

    public static <E> HashSet<E> newHashSet(E... eArr) {
        HashSet<E> newHashSetWithExpectedSize = newHashSetWithExpectedSize(eArr.length);
        Collections.addAll(newHashSetWithExpectedSize, eArr);
        return newHashSetWithExpectedSize;
    }

    public static <E> LinkedHashSet<E> newLinkedHashSet(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new LinkedHashSet<>((Collection) iterable);
        }
        LinkedHashSet<E> newLinkedHashSet = newLinkedHashSet();
        Iterables.addAll(newLinkedHashSet, iterable);
        return newLinkedHashSet;
    }

    public static <E extends Comparable> TreeSet<E> newTreeSet(Iterable<? extends E> iterable) {
        TreeSet<E> newTreeSet = newTreeSet();
        Iterables.addAll(newTreeSet, iterable);
        return newTreeSet;
    }

    public static <E> HashSet<E> newHashSet(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new HashSet<>((Collection) iterable);
        }
        return newHashSet(iterable.iterator());
    }

    public static <E> TreeSet<E> newTreeSet(Comparator<? super E> comparator) {
        return new TreeSet<>((Comparator) Preconditions.checkNotNull(comparator));
    }

    public static <E> HashSet<E> newHashSet(Iterator<? extends E> it) {
        HashSet<E> newHashSet = newHashSet();
        Iterators.addAll(newHashSet, it);
        return newHashSet;
    }

    public static <E extends Enum<E>> EnumSet<E> complementOf(Collection<E> collection, Class<E> cls) {
        Preconditions.checkNotNull(collection);
        if (collection instanceof EnumSet) {
            return EnumSet.complementOf((EnumSet) collection);
        }
        EnumSet<E> allOf = EnumSet.allOf(cls);
        allOf.removeAll(collection);
        return allOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> SortedSet<E> filter(SortedSet<E> sortedSet, Predicate<? super E> predicate) {
        if (sortedSet instanceof mh2) {
            mh2 mh2Var = (mh2) sortedSet;
            return (SortedSet<E>) new C2065zp((SortedSet) mh2Var.f29458a, Predicates.and(mh2Var.f29459b, predicate));
        }
        return (SortedSet<E>) new C2065zp((SortedSet) Preconditions.checkNotNull(sortedSet), (Predicate) Preconditions.checkNotNull(predicate));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    public static <E> NavigableSet<E> filter(NavigableSet<E> navigableSet, Predicate<? super E> predicate) {
        if (navigableSet instanceof mh2) {
            mh2 mh2Var = (mh2) navigableSet;
            return (NavigableSet<E>) new C2065zp((NavigableSet) mh2Var.f29458a, Predicates.and(mh2Var.f29459b, predicate));
        }
        return (NavigableSet<E>) new C2065zp((NavigableSet) Preconditions.checkNotNull(navigableSet), (Predicate) Preconditions.checkNotNull(predicate));
    }
}
