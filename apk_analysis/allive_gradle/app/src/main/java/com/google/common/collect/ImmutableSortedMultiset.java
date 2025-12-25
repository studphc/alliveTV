package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Multiset;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import javax.annotation.CheckForNull;
import p000.p63;

@GwtIncompatible
/* loaded from: classes.dex */
public abstract class ImmutableSortedMultiset<E> extends AbstractC0887j0 implements SortedMultiset<E> {

    /* renamed from: e */
    public transient ImmutableSortedMultiset f14709e;

    /* loaded from: classes.dex */
    public static class Builder<E> extends ImmutableMultiset.Builder<E> {

        /* renamed from: d */
        public final Comparator f14710d;

        /* renamed from: e */
        public Object[] f14711e;

        /* renamed from: f */
        public int[] f14712f;

        /* renamed from: g */
        public int f14713g;

        /* renamed from: h */
        public boolean f14714h;

        public Builder(Comparator<? super E> comparator) {
            this.f14684b = false;
            this.f14685c = false;
            this.f14683a = null;
            this.f14710d = (Comparator) Preconditions.checkNotNull(comparator);
            this.f14711e = new Object[4];
            this.f14712f = new int[4];
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder add(Object obj) {
            return add((Builder<E>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultiset.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableMultiset.Builder addCopies(Object obj, int i) {
            return addCopies((Builder<E>) obj, i);
        }

        /* renamed from: b */
        public final void m4013b(boolean z) {
            int i = this.f14713g;
            if (i == 0) {
                return;
            }
            Object[] copyOf = Arrays.copyOf(this.f14711e, i);
            Comparator comparator = this.f14710d;
            Arrays.sort(copyOf, comparator);
            int i2 = 1;
            for (int i3 = 1; i3 < copyOf.length; i3++) {
                if (comparator.compare(copyOf[i2 - 1], copyOf[i3]) < 0) {
                    copyOf[i2] = copyOf[i3];
                    i2++;
                }
            }
            Arrays.fill(copyOf, i2, this.f14713g, (Object) null);
            if (z) {
                int i4 = i2 * 4;
                int i5 = this.f14713g;
                if (i4 > i5 * 3) {
                    copyOf = Arrays.copyOf(copyOf, IntMath.saturatedAdd(i5, (i5 / 2) + 1));
                }
            }
            int[] iArr = new int[copyOf.length];
            for (int i6 = 0; i6 < this.f14713g; i6++) {
                int binarySearch = Arrays.binarySearch(copyOf, 0, i2, this.f14711e[i6], comparator);
                int i7 = this.f14712f[i6];
                if (i7 >= 0) {
                    iArr[binarySearch] = iArr[binarySearch] + i7;
                } else {
                    iArr[binarySearch] = ~i7;
                }
            }
            this.f14711e = copyOf;
            this.f14712f = iArr;
            this.f14713g = i2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultiset.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableMultiset.Builder setCount(Object obj, int i) {
            return setCount((Builder<E>) obj, i);
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder
        @CanIgnoreReturnValue
        public Builder<E> addCopies(E e, int i) {
            Preconditions.checkNotNull(e);
            p63.m6869m(i, "occurrences");
            if (i == 0) {
                return this;
            }
            int i2 = this.f14713g;
            Object[] objArr = this.f14711e;
            if (i2 == objArr.length) {
                m4013b(true);
            } else if (this.f14714h) {
                this.f14711e = Arrays.copyOf(objArr, objArr.length);
            }
            this.f14714h = false;
            Object[] objArr2 = this.f14711e;
            int i3 = this.f14713g;
            objArr2[i3] = e;
            this.f14712f[i3] = i;
            this.f14713g = i3 + 1;
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder
        @CanIgnoreReturnValue
        public Builder<E> setCount(E e, int i) {
            Preconditions.checkNotNull(e);
            p63.m6869m(i, "count");
            int i2 = this.f14713g;
            Object[] objArr = this.f14711e;
            if (i2 == objArr.length) {
                m4013b(true);
            } else if (this.f14714h) {
                this.f14711e = Arrays.copyOf(objArr, objArr.length);
            }
            this.f14714h = false;
            Object[] objArr2 = this.f14711e;
            int i3 = this.f14713g;
            objArr2[i3] = e;
            this.f14712f[i3] = ~i;
            this.f14713g = i3 + 1;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableMultiset.Builder add(Object obj) {
            return add((Builder<E>) obj);
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        public ImmutableSortedMultiset<E> build() {
            int i;
            m4013b(false);
            int i2 = 0;
            int i3 = 0;
            while (true) {
                i = this.f14713g;
                if (i2 >= i) {
                    break;
                }
                int[] iArr = this.f14712f;
                int i4 = iArr[i2];
                if (i4 > 0) {
                    Object[] objArr = this.f14711e;
                    objArr[i3] = objArr[i2];
                    iArr[i3] = i4;
                    i3++;
                }
                i2++;
            }
            Arrays.fill(this.f14711e, i3, i, (Object) null);
            Arrays.fill(this.f14712f, i3, this.f14713g, 0);
            this.f14713g = i3;
            Comparator comparator = this.f14710d;
            if (i3 == 0) {
                return ImmutableSortedMultiset.m4005i(comparator);
            }
            C0909n2 m4014j = ImmutableSortedSet.m4014j(i3, comparator, this.f14711e);
            long[] jArr = new long[this.f14713g + 1];
            int i5 = 0;
            while (i5 < this.f14713g) {
                int i6 = i5 + 1;
                jArr[i6] = jArr[i5] + this.f14712f[i5];
                i5 = i6;
            }
            this.f14714h = true;
            return new C0904m2(m4014j, jArr, 0, this.f14713g);
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E e) {
            return addCopies((Builder<E>) e, 1);
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterable<? extends E> iterable) {
            if (iterable instanceof Multiset) {
                for (Multiset.Entry<E> entry : ((Multiset) iterable).entrySet()) {
                    addCopies((Builder<E>) entry.getElement(), entry.getCount());
                }
            } else {
                Iterator<? extends E> it = iterable.iterator();
                while (it.hasNext()) {
                    add((Builder<E>) it.next());
                }
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E... eArr) {
            for (E e : eArr) {
                add((Builder<E>) e);
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterator<? extends E> it) {
            while (it.hasNext()) {
                add((Builder<E>) it.next());
            }
            return this;
        }
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>([TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset copyOf(Comparable[] comparableArr) {
        return copyOf(Ordering.natural(), Arrays.asList(comparableArr));
    }

    public static <E> ImmutableSortedMultiset<E> copyOfSorted(SortedMultiset<E> sortedMultiset) {
        return m4004h(sortedMultiset.comparator(), Lists.newArrayList(sortedMultiset.entrySet()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: h */
    public static C0904m2 m4004h(Comparator comparator, AbstractCollection abstractCollection) {
        if (abstractCollection.isEmpty()) {
            return m4005i(comparator);
        }
        AbstractC0957z abstractC0957z = new AbstractC0957z(abstractCollection.size());
        long[] jArr = new long[abstractCollection.size() + 1];
        Iterator<E> it = abstractCollection.iterator();
        int i = 0;
        while (it.hasNext()) {
            abstractC0957z.add((AbstractC0957z) ((Multiset.Entry) it.next()).getElement());
            int i2 = i + 1;
            jArr[i2] = jArr[i] + r5.getCount();
            i = i2;
        }
        return new C0904m2(new C0909n2(abstractC0957z.build(), comparator), jArr, 0, abstractCollection.size());
    }

    /* renamed from: i */
    public static C0904m2 m4005i(Comparator comparator) {
        if (Ordering.natural().equals(comparator)) {
            return C0904m2.f14891k;
        }
        return new C0904m2(comparator);
    }

    public static <E extends Comparable<?>> Builder<E> naturalOrder() {
        return new Builder<>(Ordering.natural());
    }

    /* renamed from: of */
    public static <E> ImmutableSortedMultiset<E> m4006of() {
        return C0904m2.f14891k;
    }

    public static <E> Builder<E> orderedBy(Comparator<E> comparator) {
        return new Builder<>(comparator);
    }

    public static <E extends Comparable<?>> Builder<E> reverseOrder() {
        return new Builder<>(Ordering.natural().reverse());
    }

    @Override // com.google.common.collect.SortedMultiset, p000.fl2
    public final Comparator<? super E> comparator() {
        return elementSet().comparator();
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public abstract ImmutableSortedSet<E> elementSet();

    @Override // com.google.common.collect.SortedMultiset
    public abstract ImmutableSortedMultiset<E> headMultiset(E e, BoundType boundType);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset headMultiset(Object obj, BoundType boundType) {
        return headMultiset((ImmutableSortedMultiset<E>) obj, boundType);
    }

    @Override // com.google.common.collect.SortedMultiset
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    @CanIgnoreReturnValue
    public final Multiset.Entry<E> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.SortedMultiset
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    @CanIgnoreReturnValue
    public final Multiset.Entry<E> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset subMultiset(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        return subMultiset((BoundType) obj, boundType, (BoundType) obj2, boundType2);
    }

    @Override // com.google.common.collect.SortedMultiset
    public abstract ImmutableSortedMultiset<E> tailMultiset(E e, BoundType boundType);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset tailMultiset(Object obj, BoundType boundType) {
        return tailMultiset((ImmutableSortedMultiset<E>) obj, boundType);
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new C0882i0(this);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterable<? extends E> iterable) {
        return copyOf(Ordering.natural(), iterable);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    /* renamed from: of */
    public static ImmutableSortedMultiset m4007of(Comparable comparable) {
        return new C0904m2((C0909n2) ImmutableSortedSet.m4017of(comparable), new long[]{0, 1}, 0, 1);
    }

    @Override // com.google.common.collect.SortedMultiset
    public ImmutableSortedMultiset<E> descendingMultiset() {
        ImmutableSortedMultiset<E> immutableSortedMultiset = this.f14709e;
        if (immutableSortedMultiset == null) {
            if (isEmpty()) {
                immutableSortedMultiset = m4005i(Ordering.from(comparator()).reverse());
            } else {
                immutableSortedMultiset = new C0921q(this);
            }
            this.f14709e = immutableSortedMultiset;
        }
        return immutableSortedMultiset;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.SortedMultiset
    public ImmutableSortedMultiset<E> subMultiset(E e, BoundType boundType, E e2, BoundType boundType2) {
        Preconditions.checkArgument(comparator().compare(e, e2) <= 0, "Expected lowerBound <= upperBound but %s > %s", e, e2);
        return tailMultiset((ImmutableSortedMultiset<E>) e, boundType).headMultiset((ImmutableSortedMultiset<E>) e2, boundType2);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterator<? extends E> it) {
        return copyOf(Ordering.natural(), it);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    /* renamed from: of */
    public static ImmutableSortedMultiset m4008of(Comparable comparable, Comparable comparable2) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2));
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> comparator, Iterator<? extends E> it) {
        Preconditions.checkNotNull(comparator);
        return new Builder(comparator).addAll((Iterator) it).build();
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    /* renamed from: of */
    public static ImmutableSortedMultiset m4009of(Comparable comparable, Comparable comparable2, Comparable comparable3) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2, comparable3));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    /* renamed from: of */
    public static ImmutableSortedMultiset m4010of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2, comparable3, comparable4));
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableSortedMultiset) {
            ImmutableSortedMultiset<E> immutableSortedMultiset = (ImmutableSortedMultiset) iterable;
            if (comparator.equals(immutableSortedMultiset.comparator())) {
                return immutableSortedMultiset.mo7e() ? m4004h(comparator, immutableSortedMultiset.entrySet().asList()) : immutableSortedMultiset;
            }
        }
        return new Builder(comparator).addAll((Iterable) iterable).build();
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    /* renamed from: of */
    public static ImmutableSortedMultiset m4011of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2, comparable3, comparable4, comparable5));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;TE;[TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    /* renamed from: of */
    public static ImmutableSortedMultiset m4012of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5, Comparable comparable6, Comparable... comparableArr) {
        ArrayList newArrayListWithCapacity = Lists.newArrayListWithCapacity(comparableArr.length + 6);
        Collections.addAll(newArrayListWithCapacity, comparable, comparable2, comparable3, comparable4, comparable5, comparable6);
        Collections.addAll(newArrayListWithCapacity, comparableArr);
        return copyOf(Ordering.natural(), newArrayListWithCapacity);
    }
}
