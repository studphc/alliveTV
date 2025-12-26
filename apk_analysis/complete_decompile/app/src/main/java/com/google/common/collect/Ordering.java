package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import p000.C1245gu;
import p000.C1697pr;
import p000.C1825t7;
import p000.C2021yi;
import p000.bt1;
import p000.ct1;
import p000.ir1;
import p000.m12;
import p000.nc2;
import p000.p63;
import p000.wb0;
import p000.x03;
import p000.x71;

@GwtCompatible
/* loaded from: classes.dex */
public abstract class Ordering<T> implements Comparator<T> {
    @GwtCompatible(serializable = true)
    public static Ordering<Object> allEqual() {
        return C1825t7.f26711a;
    }

    public static Ordering<Object> arbitrary() {
        return m12.f22756a;
    }

    @GwtCompatible(serializable = true)
    public static <T> Ordering<T> explicit(List<T> list) {
        return new wb0(list);
    }

    @GwtCompatible(serializable = true)
    public static <T> Ordering<T> from(Comparator<T> comparator) {
        if (comparator instanceof Ordering) {
            return (Ordering) comparator;
        }
        return new C1697pr(comparator);
    }

    @GwtCompatible(serializable = true)
    public static <C extends Comparable> Ordering<C> natural() {
        return ir1.f20241c;
    }

    @GwtCompatible(serializable = true)
    public static Ordering<Object> usingToString() {
        return x03.f28417a;
    }

    @Deprecated
    public int binarySearch(List<? extends T> list, T t) {
        return Collections.binarySearch(list, t, this);
    }

    @Override // java.util.Comparator
    @CanIgnoreReturnValue
    public abstract int compare(T t, T t2);

    @GwtCompatible(serializable = true)
    public <U extends T> Ordering<U> compound(Comparator<? super U> comparator) {
        return new C1245gu(this, (Comparator) Preconditions.checkNotNull(comparator));
    }

    public <E extends T> List<E> greatestOf(Iterable<E> iterable, int i) {
        return reverse().leastOf(iterable, i);
    }

    public <E extends T> ImmutableList<E> immutableSortedCopy(Iterable<E> iterable) {
        return ImmutableList.sortedCopyOf(this, iterable);
    }

    public boolean isOrdered(Iterable<? extends T> iterable) {
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                T next2 = it.next();
                if (compare(next, next2) > 0) {
                    return false;
                }
                next = next2;
            }
            return true;
        }
        return true;
    }

    public boolean isStrictlyOrdered(Iterable<? extends T> iterable) {
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                T next2 = it.next();
                if (compare(next, next2) >= 0) {
                    return false;
                }
                next = next2;
            }
            return true;
        }
        return true;
    }

    public <E extends T> List<E> leastOf(Iterable<E> iterable, int i) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= i * 2) {
                Object[] array = collection.toArray();
                Arrays.sort(array, this);
                if (array.length > i) {
                    array = Arrays.copyOf(array, i);
                }
                return Collections.unmodifiableList(Arrays.asList(array));
            }
        }
        return leastOf(iterable.iterator(), i);
    }

    @GwtCompatible(serializable = true)
    public <S extends T> Ordering<Iterable<S>> lexicographical() {
        return new x71(this);
    }

    public <E extends T> E max(Iterator<E> it) {
        E next = it.next();
        while (it.hasNext()) {
            next = (E) max(next, it.next());
        }
        return next;
    }

    public <E extends T> E min(Iterator<E> it) {
        E next = it.next();
        while (it.hasNext()) {
            next = (E) min(next, it.next());
        }
        return next;
    }

    @GwtCompatible(serializable = true)
    public <S extends T> Ordering<S> nullsFirst() {
        return new bt1(this);
    }

    @GwtCompatible(serializable = true)
    public <S extends T> Ordering<S> nullsLast() {
        return new ct1(this);
    }

    @GwtCompatible(serializable = true)
    public <F> Ordering<F> onResultOf(Function<F, ? extends T> function) {
        return new C2021yi(function, this);
    }

    @GwtCompatible(serializable = true)
    public <S extends T> Ordering<S> reverse() {
        return new nc2(this);
    }

    public <E extends T> List<E> sortedCopy(Iterable<E> iterable) {
        Collection newArrayList;
        if (iterable instanceof Collection) {
            newArrayList = (Collection) iterable;
        } else {
            newArrayList = Lists.newArrayList(iterable.iterator());
        }
        Object[] array = newArrayList.toArray();
        Arrays.sort(array, this);
        return Lists.newArrayList(Arrays.asList(array));
    }

    @GwtCompatible(serializable = true)
    public static <T> Ordering<T> compound(Iterable<? extends Comparator<? super T>> iterable) {
        return new C1245gu(iterable);
    }

    @GwtCompatible(serializable = true)
    public static <T> Ordering<T> explicit(T t, T... tArr) {
        return explicit(Lists.asList(t, tArr));
    }

    public <E extends T> List<E> greatestOf(Iterator<E> it, int i) {
        return reverse().leastOf(it, i);
    }

    @GwtCompatible(serializable = true)
    @Deprecated
    public static <T> Ordering<T> from(Ordering<T> ordering) {
        return (Ordering) Preconditions.checkNotNull(ordering);
    }

    public <E extends T> E max(Iterable<E> iterable) {
        return (E) max(iterable.iterator());
    }

    public <E extends T> E min(Iterable<E> iterable) {
        return (E) min(iterable.iterator());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <E extends T> E max(E e, E e2) {
        return compare(e, e2) >= 0 ? e : e2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <E extends T> E min(E e, E e2) {
        return compare(e, e2) <= 0 ? e : e2;
    }

    public <E extends T> E max(E e, E e2, E e3, E... eArr) {
        E e4 = (E) max(max(e, e2), e3);
        for (E e5 : eArr) {
            e4 = (E) max(e4, e5);
        }
        return e4;
    }

    public <E extends T> E min(E e, E e2, E e3, E... eArr) {
        E e4 = (E) min(min(e, e2), e3);
        for (E e5 : eArr) {
            e4 = (E) min(e4, e5);
        }
        return e4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <E extends T> List<E> leastOf(Iterator<E> it, int i) {
        int i2;
        int i3 = i;
        Preconditions.checkNotNull(it);
        p63.m6869m(i3, "k");
        if (i3 == 0 || !it.hasNext()) {
            return Collections.emptyList();
        }
        if (i3 >= 1073741823) {
            ArrayList newArrayList = Lists.newArrayList(it);
            Collections.sort(newArrayList, this);
            if (newArrayList.size() > i3) {
                newArrayList.subList(i3, newArrayList.size()).clear();
            }
            newArrayList.trimToSize();
            return Collections.unmodifiableList(newArrayList);
        }
        Comparator comparator = (Comparator) Preconditions.checkNotNull(this, "comparator");
        Preconditions.checkArgument(i3 >= 0, "k (%s) must be >= 0", i3);
        Preconditions.checkArgument(i3 <= 1073741823, "k (%s) must be <= Integer.MAX_VALUE / 2", i3);
        int checkedMultiply = IntMath.checkedMultiply(i3, 2);
        Object[] objArr = new Object[checkedMultiply];
        int i4 = 0;
        Object obj = null;
        while (it.hasNext()) {
            E next = it.next();
            if (i3 != 0) {
                if (i4 == 0) {
                    objArr[0] = next;
                    i4 = 1;
                    obj = next;
                } else {
                    if (i4 < i3) {
                        i2 = i4 + 1;
                        objArr[i4] = next;
                        if (comparator.compare(next, obj) > 0) {
                            obj = next;
                        }
                    } else if (comparator.compare(next, obj) < 0) {
                        i2 = i4 + 1;
                        objArr[i4] = next;
                        int i5 = i3 * 2;
                        if (i2 == i5) {
                            int i6 = i5 - 1;
                            int log2 = IntMath.log2(i6, RoundingMode.CEILING) * 3;
                            int i7 = 0;
                            int i8 = 0;
                            int i9 = 0;
                            while (true) {
                                if (i7 >= i6) {
                                    break;
                                }
                                int i10 = ((i7 + i6) + 1) >>> 1;
                                Object obj2 = objArr[i10];
                                objArr[i10] = objArr[i6];
                                int i11 = i7;
                                int i12 = i11;
                                while (i11 < i6) {
                                    if (comparator.compare(objArr[i11], obj2) < 0) {
                                        Object obj3 = objArr[i12];
                                        objArr[i12] = objArr[i11];
                                        objArr[i11] = obj3;
                                        i12++;
                                    }
                                    i11++;
                                }
                                objArr[i6] = objArr[i12];
                                objArr[i12] = obj2;
                                if (i12 <= i3) {
                                    if (i12 >= i3) {
                                        break;
                                    }
                                    i7 = Math.max(i12, i7 + 1);
                                    i9 = i12;
                                } else {
                                    i6 = i12 - 1;
                                }
                                i8++;
                                if (i8 >= log2) {
                                    Arrays.sort(objArr, i7, i6 + 1, comparator);
                                    break;
                                }
                            }
                            Object obj4 = objArr[i9];
                            obj = obj4;
                            for (int i13 = i9 + 1; i13 < i3; i13++) {
                                if (comparator.compare(objArr[i13], obj) > 0) {
                                    obj = objArr[i13];
                                }
                            }
                            i4 = i3;
                        }
                    }
                    i4 = i2;
                }
            }
        }
        Arrays.sort(objArr, 0, i4, comparator);
        if (i4 > i3) {
            Arrays.fill(objArr, i3, checkedMultiply, (Object) null);
            Object obj5 = objArr[i3 - 1];
        } else {
            i3 = i4;
        }
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(objArr, i3)));
    }
}
