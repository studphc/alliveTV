package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import javax.annotation.CheckForNull;
import p000.fl2;
import p000.o63;

@GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes.dex */
public abstract class ImmutableSortedSet<E> extends AbstractC0897l0 implements NavigableSet<E>, fl2 {

    /* renamed from: c */
    public final transient Comparator f14715c;

    /* renamed from: d */
    public transient ImmutableSortedSet f14716d;

    /* loaded from: classes.dex */
    public static final class Builder<E> extends ImmutableSet.Builder<E> {

        /* renamed from: f */
        public final Comparator f14717f;

        public Builder(Comparator<? super E> comparator) {
            this.f14717f = (Comparator) Preconditions.checkNotNull(comparator);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.AbstractC0957z, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ AbstractC0957z add(Object obj) {
            return add((Builder<E>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder add(Object obj) {
            return add((Builder<E>) obj);
        }

        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.Builder
        public ImmutableSortedSet<E> build() {
            Object[] objArr = this.f14993a;
            C0909n2 m4014j = ImmutableSortedSet.m4014j(this.f14994b, this.f14717f, objArr);
            this.f14994b = m4014j.f14907e.size();
            this.f14995c = true;
            return m4014j;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.AbstractC0957z, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableSet.Builder add(Object obj) {
            return add((Builder<E>) obj);
        }

        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.AbstractC0957z, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterable<? extends E> iterable) {
            super.addAll((Iterable) iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E e) {
            super.add((Builder<E>) e);
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterator<? extends E> it) {
            super.addAll((Iterator) it);
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.AbstractC0957z, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E... eArr) {
            super.add((Object[]) eArr);
            return this;
        }
    }

    public ImmutableSortedSet(Comparator comparator) {
        this.f14715c = comparator;
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>([TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet copyOf(Comparable[] comparableArr) {
        return m4014j(comparableArr.length, Ordering.natural(), (Comparable[]) comparableArr.clone());
    }

    public static <E> ImmutableSortedSet<E> copyOfSorted(SortedSet<E> sortedSet) {
        Comparator<? super E> comparator = sortedSet.comparator();
        if (comparator == null) {
            comparator = Ordering.natural();
        }
        ImmutableList copyOf = ImmutableList.copyOf((Collection) sortedSet);
        if (copyOf.isEmpty()) {
            return m4015l(comparator);
        }
        return new C0909n2(copyOf, comparator);
    }

    /* renamed from: j */
    public static C0909n2 m4014j(int i, Comparator comparator, Object... objArr) {
        if (i == 0) {
            return m4015l(comparator);
        }
        ObjectArrays.m4065a(i, objArr);
        Arrays.sort(objArr, 0, i, comparator);
        int i2 = 1;
        for (int i3 = 1; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (comparator.compare(obj, objArr[i2 - 1]) != 0) {
                objArr[i2] = obj;
                i2++;
            }
        }
        Arrays.fill(objArr, i2, i, (Object) null);
        if (i2 < objArr.length / 2) {
            objArr = Arrays.copyOf(objArr, i2);
        }
        return new C0909n2(ImmutableList.m3901f(i2, objArr), comparator);
    }

    /* renamed from: l */
    public static C0909n2 m4015l(Comparator comparator) {
        if (Ordering.natural().equals(comparator)) {
            return C0909n2.f14906f;
        }
        return new C0909n2(ImmutableList.m3902of(), comparator);
    }

    public static <E extends Comparable<?>> Builder<E> naturalOrder() {
        return new Builder<>(Ordering.natural());
    }

    /* renamed from: of */
    public static <E> ImmutableSortedSet<E> m4016of() {
        return C0909n2.f14906f;
    }

    public static <E> Builder<E> orderedBy(Comparator<E> comparator) {
        return new Builder<>(comparator);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E extends Comparable<?>> Builder<E> reverseOrder() {
        return new Builder<>(Collections.reverseOrder());
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public E ceiling(E e) {
        return (E) Iterables.getFirst(tailSet((ImmutableSortedSet<E>) e, true), null);
    }

    @Override // java.util.SortedSet, p000.fl2
    public Comparator<? super E> comparator() {
        return this.f14715c;
    }

    @Override // java.util.NavigableSet
    @GwtIncompatible
    public abstract UnmodifiableIterator<E> descendingIterator();

    @Override // java.util.SortedSet
    public E first() {
        return iterator().next();
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public E floor(E e) {
        return (E) Iterators.getNext(headSet((ImmutableSortedSet<E>) e, true).descendingIterator(), null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ NavigableSet headSet(Object obj, boolean z) {
        return headSet((ImmutableSortedSet<E>) obj, z);
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    @GwtIncompatible
    public E higher(E e) {
        return (E) Iterables.getFirst(tailSet((ImmutableSortedSet<E>) e, false), null);
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public abstract UnmodifiableIterator<E> iterator();

    /* renamed from: k */
    public abstract ImmutableSortedSet mo3842k();

    @Override // java.util.SortedSet
    public E last() {
        return descendingIterator().next();
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    @GwtIncompatible
    public E lower(E e) {
        return (E) Iterators.getNext(headSet((ImmutableSortedSet<E>) e, false).descendingIterator(), null);
    }

    /* renamed from: m */
    public abstract ImmutableSortedSet mo3843m(Object obj, boolean z);

    /* renamed from: n */
    public abstract ImmutableSortedSet mo3844n(Object obj, boolean z, Object obj2, boolean z2);

    /* renamed from: o */
    public abstract ImmutableSortedSet mo3845o(Object obj, boolean z);

    @Override // java.util.NavigableSet
    @CheckForNull
    @GwtIncompatible
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    @CanIgnoreReturnValue
    public final E pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    @GwtIncompatible
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    @CanIgnoreReturnValue
    public final E pollLast() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    public /* bridge */ /* synthetic */ NavigableSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
        return subSet((boolean) obj, z, (boolean) obj2, z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ NavigableSet tailSet(Object obj, boolean z) {
        return tailSet((ImmutableSortedSet<E>) obj, z);
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new C0892k0(this.f14715c, toArray());
    }

    public static <E> ImmutableSortedSet<E> copyOf(Iterable<? extends E> iterable) {
        return copyOf(Ordering.natural(), iterable);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    /* renamed from: of */
    public static ImmutableSortedSet m4017of(Comparable comparable) {
        return new C0909n2(ImmutableList.m3903of(comparable), Ordering.natural());
    }

    @Override // java.util.NavigableSet
    @GwtIncompatible
    public ImmutableSortedSet<E> descendingSet() {
        ImmutableSortedSet<E> immutableSortedSet = this.f14716d;
        if (immutableSortedSet != null) {
            return immutableSortedSet;
        }
        ImmutableSortedSet<E> mo3842k = mo3842k();
        this.f14716d = mo3842k;
        mo3842k.f14716d = this;
        return mo3842k;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ SortedSet headSet(Object obj) {
        return headSet((ImmutableSortedSet<E>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ SortedSet tailSet(Object obj) {
        return tailSet((ImmutableSortedSet<E>) obj);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    /* renamed from: of */
    public static ImmutableSortedSet m4018of(Comparable comparable, Comparable comparable2) {
        return m4014j(2, Ordering.natural(), comparable, comparable2);
    }

    public ImmutableSortedSet<E> headSet(E e) {
        return headSet((ImmutableSortedSet<E>) e, false);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public ImmutableSortedSet<E> subSet(E e, E e2) {
        return subSet((boolean) e, true, (boolean) e2, false);
    }

    public ImmutableSortedSet<E> tailSet(E e) {
        return tailSet((ImmutableSortedSet<E>) e, true);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Collection<? extends E> collection) {
        return copyOf((Comparator) Ordering.natural(), (Collection) collection);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    /* renamed from: of */
    public static ImmutableSortedSet m4019of(Comparable comparable, Comparable comparable2, Comparable comparable3) {
        return m4014j(3, Ordering.natural(), comparable, comparable2, comparable3);
    }

    public ImmutableSortedSet<E> headSet(E e, boolean z) {
        return mo3843m(Preconditions.checkNotNull(e), z);
    }

    @GwtIncompatible
    public ImmutableSortedSet<E> subSet(E e, boolean z, E e2, boolean z2) {
        Preconditions.checkNotNull(e);
        Preconditions.checkNotNull(e2);
        Preconditions.checkArgument(this.f14715c.compare(e, e2) <= 0);
        return mo3844n(e, z, e2, z2);
    }

    public ImmutableSortedSet<E> tailSet(E e, boolean z) {
        return mo3845o(Preconditions.checkNotNull(e), z);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    /* renamed from: of */
    public static ImmutableSortedSet m4020of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4) {
        return m4014j(4, Ordering.natural(), comparable, comparable2, comparable3, comparable4);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Iterator<? extends E> it) {
        return copyOf(Ordering.natural(), it);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    /* renamed from: of */
    public static ImmutableSortedSet m4021of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5) {
        return m4014j(5, Ordering.natural(), comparable, comparable2, comparable3, comparable4, comparable5);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;TE;[TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    /* renamed from: of */
    public static ImmutableSortedSet m4022of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5, Comparable comparable6, Comparable... comparableArr) {
        int length = comparableArr.length + 6;
        Comparable[] comparableArr2 = new Comparable[length];
        comparableArr2[0] = comparable;
        comparableArr2[1] = comparable2;
        comparableArr2[2] = comparable3;
        comparableArr2[3] = comparable4;
        comparableArr2[4] = comparable5;
        comparableArr2[5] = comparable6;
        System.arraycopy(comparableArr, 0, comparableArr2, 6, comparableArr.length);
        return m4014j(length, Ordering.natural(), comparableArr2);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator, Iterator<? extends E> it) {
        return new Builder(comparator).addAll((Iterator) it).build();
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        Collection newArrayList;
        Preconditions.checkNotNull(comparator);
        if (o63.m6473q(iterable, comparator) && (iterable instanceof ImmutableSortedSet)) {
            ImmutableSortedSet<E> immutableSortedSet = (ImmutableSortedSet) iterable;
            if (!immutableSortedSet.mo7e()) {
                return immutableSortedSet;
            }
        }
        if (iterable instanceof Collection) {
            newArrayList = (Collection) iterable;
        } else {
            newArrayList = Lists.newArrayList(iterable.iterator());
        }
        Object[] array = newArrayList.toArray();
        return m4014j(array.length, comparator, array);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator, Collection<? extends E> collection) {
        return copyOf((Comparator) comparator, (Iterable) collection);
    }
}
