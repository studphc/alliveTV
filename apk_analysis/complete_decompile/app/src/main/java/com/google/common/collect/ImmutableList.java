package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.InlineMe;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;
import p000.C1505lb;
import p000.p63;
import p000.q21;
import p000.r21;
import p000.s21;

@GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes.dex */
public abstract class ImmutableList<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {

    /* renamed from: b */
    public static final C1505lb f14663b = new C1505lb(0, C0879h2.f14840e);

    /* loaded from: classes.dex */
    public static final class Builder<E> extends AbstractC0957z {
        public Builder() {
            super(4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.AbstractC0957z, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ AbstractC0957z add(Object obj) {
            return add((Builder<E>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder add(Object obj) {
            return add((Builder<E>) obj);
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public ImmutableList<E> build() {
            this.f14995c = true;
            return ImmutableList.m3901f(this.f14994b, this.f14993a);
        }

        @Override // com.google.common.collect.AbstractC0957z, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterable<? extends E> iterable) {
            super.addAll((Iterable) iterable);
            return this;
        }

        @Override // com.google.common.collect.AbstractC0957z, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E e) {
            super.add((Object) e);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterator<? extends E> it) {
            super.addAll((Iterator) it);
            return this;
        }

        @Override // com.google.common.collect.AbstractC0957z, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E... eArr) {
            super.add((Object[]) eArr);
            return this;
        }
    }

    public static <E> Builder<E> builder() {
        return new Builder<>();
    }

    @Beta
    public static <E> Builder<E> builderWithExpectedSize(int i) {
        p63.m6869m(i, "expectedSize");
        return (Builder<E>) new AbstractC0957z(i);
    }

    public static <E> ImmutableList<E> copyOf(Iterable<? extends E> iterable) {
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof Collection) {
            return copyOf((Collection) iterable);
        }
        return copyOf(iterable.iterator());
    }

    /* renamed from: f */
    public static ImmutableList m3901f(int i, Object[] objArr) {
        if (i == 0) {
            return m3902of();
        }
        return new C0879h2(i, objArr);
    }

    /* renamed from: of */
    public static <E> ImmutableList<E> m3902of() {
        return C0879h2.f14840e;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E extends Comparable<? super E>> ImmutableList<E> sortedCopyOf(Iterable<? extends E> iterable) {
        Collection newArrayList;
        Comparable[] comparableArr = new Comparable[0];
        if (iterable instanceof Collection) {
            newArrayList = (Collection) iterable;
        } else {
            newArrayList = Lists.newArrayList(iterable.iterator());
        }
        Comparable[] comparableArr2 = (Comparable[]) newArrayList.toArray(comparableArr);
        ObjectArrays.m4065a(comparableArr2.length, comparableArr2);
        Arrays.sort(comparableArr2);
        return m3901f(comparableArr2.length, comparableArr2);
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: a */
    public int mo3896a(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    @Override // java.util.List
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    @InlineMe(replacement = "this")
    @Deprecated
    public final ImmutableList<E> asList() {
        return this;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object obj) {
        if (indexOf(obj) >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(@CheckForNull Object obj) {
        return Lists.m4040a(this, obj);
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = ~(~(get(i2).hashCode() + (i * 31)));
        }
        return i;
    }

    @Override // java.util.List
    public int indexOf(@CheckForNull Object obj) {
        if (obj == null) {
            return -1;
        }
        return Lists.m4041b(this, obj);
    }

    @Override // java.util.List
    public int lastIndexOf(@CheckForNull Object obj) {
        if (obj == null) {
            return -1;
        }
        return Lists.m4042c(this, obj);
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> reverse() {
        if (size() <= 1) {
            return this;
        }
        return new q21(this);
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new r21(toArray());
    }

    /* renamed from: of */
    public static <E> ImmutableList<E> m3903of(E e) {
        Object[] objArr = {e};
        ObjectArrays.m4065a(1, objArr);
        return m3901f(1, objArr);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public UnmodifiableIterator<E> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public ImmutableList<E> subList(int i, int i2) {
        Preconditions.checkPositionIndexes(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 == 0) {
            return m3902of();
        }
        return new s21(this, i, i3);
    }

    @Override // java.util.List
    public UnmodifiableListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public UnmodifiableListIterator<E> listIterator(int i) {
        Preconditions.checkPositionIndex(i, size());
        if (isEmpty()) {
            return f14663b;
        }
        return new C1505lb(i, this);
    }

    public static <E> ImmutableList<E> copyOf(Collection<? extends E> collection) {
        if (collection instanceof ImmutableCollection) {
            ImmutableList<E> asList = ((ImmutableCollection) collection).asList();
            if (!asList.mo7e()) {
                return asList;
            }
            Object[] array = asList.toArray();
            return m3901f(array.length, array);
        }
        Object[] array2 = collection.toArray();
        ObjectArrays.m4065a(array2.length, array2);
        return m3901f(array2.length, array2);
    }

    /* renamed from: of */
    public static <E> ImmutableList<E> m3904of(E e, E e2) {
        Object[] objArr = {e, e2};
        ObjectArrays.m4065a(2, objArr);
        return m3901f(2, objArr);
    }

    /* renamed from: of */
    public static <E> ImmutableList<E> m3905of(E e, E e2, E e3) {
        Object[] objArr = {e, e2, e3};
        ObjectArrays.m4065a(3, objArr);
        return m3901f(3, objArr);
    }

    public static <E> ImmutableList<E> sortedCopyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        Collection newArrayList;
        Preconditions.checkNotNull(comparator);
        if (iterable instanceof Collection) {
            newArrayList = (Collection) iterable;
        } else {
            newArrayList = Lists.newArrayList(iterable.iterator());
        }
        Object[] array = newArrayList.toArray();
        ObjectArrays.m4065a(array.length, array);
        Arrays.sort(array, comparator);
        return m3901f(array.length, array);
    }

    /* renamed from: of */
    public static <E> ImmutableList<E> m3906of(E e, E e2, E e3, E e4) {
        Object[] objArr = {e, e2, e3, e4};
        ObjectArrays.m4065a(4, objArr);
        return m3901f(4, objArr);
    }

    public static <E> ImmutableList<E> copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return m3902of();
        }
        E next = it.next();
        if (!it.hasNext()) {
            return m3903of((Object) next);
        }
        return new Builder().add((Builder) next).addAll((Iterator) it).build();
    }

    /* renamed from: of */
    public static <E> ImmutableList<E> m3907of(E e, E e2, E e3, E e4, E e5) {
        Object[] objArr = {e, e2, e3, e4, e5};
        ObjectArrays.m4065a(5, objArr);
        return m3901f(5, objArr);
    }

    /* renamed from: of */
    public static <E> ImmutableList<E> m3908of(E e, E e2, E e3, E e4, E e5, E e6) {
        Object[] objArr = {e, e2, e3, e4, e5, e6};
        ObjectArrays.m4065a(6, objArr);
        return m3901f(6, objArr);
    }

    public static <E> ImmutableList<E> copyOf(E[] eArr) {
        if (eArr.length == 0) {
            return m3902of();
        }
        Object[] objArr = (Object[]) eArr.clone();
        ObjectArrays.m4065a(objArr.length, objArr);
        return m3901f(objArr.length, objArr);
    }

    /* renamed from: of */
    public static <E> ImmutableList<E> m3909of(E e, E e2, E e3, E e4, E e5, E e6, E e7) {
        Object[] objArr = {e, e2, e3, e4, e5, e6, e7};
        ObjectArrays.m4065a(7, objArr);
        return m3901f(7, objArr);
    }

    /* renamed from: of */
    public static <E> ImmutableList<E> m3910of(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8) {
        Object[] objArr = {e, e2, e3, e4, e5, e6, e7, e8};
        ObjectArrays.m4065a(8, objArr);
        return m3901f(8, objArr);
    }

    /* renamed from: of */
    public static <E> ImmutableList<E> m3911of(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9) {
        Object[] objArr = {e, e2, e3, e4, e5, e6, e7, e8, e9};
        ObjectArrays.m4065a(9, objArr);
        return m3901f(9, objArr);
    }

    /* renamed from: of */
    public static <E> ImmutableList<E> m3912of(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10) {
        Object[] objArr = {e, e2, e3, e4, e5, e6, e7, e8, e9, e10};
        ObjectArrays.m4065a(10, objArr);
        return m3901f(10, objArr);
    }

    /* renamed from: of */
    public static <E> ImmutableList<E> m3913of(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10, E e11) {
        Object[] objArr = {e, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11};
        ObjectArrays.m4065a(11, objArr);
        return m3901f(11, objArr);
    }

    @SafeVarargs
    /* renamed from: of */
    public static <E> ImmutableList<E> m3914of(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10, E e11, E e12, E... eArr) {
        Preconditions.checkArgument(eArr.length <= 2147483635, "the total number of elements must fit in an int");
        int length = eArr.length + 12;
        Object[] objArr = new Object[length];
        objArr[0] = e;
        objArr[1] = e2;
        objArr[2] = e3;
        objArr[3] = e4;
        objArr[4] = e5;
        objArr[5] = e6;
        objArr[6] = e7;
        objArr[7] = e8;
        objArr[8] = e9;
        objArr[9] = e10;
        objArr[10] = e11;
        objArr[11] = e12;
        System.arraycopy(eArr, 0, objArr, 12, eArr.length);
        ObjectArrays.m4065a(length, objArr);
        return m3901f(length, objArr);
    }
}
