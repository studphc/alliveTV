package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.concurrent.CopyOnWriteArrayList;
import p000.ca1;
import p000.da1;
import p000.ea1;
import p000.ia1;
import p000.ja1;
import p000.ka1;
import p000.la1;
import p000.ma1;
import p000.p63;

@GwtCompatible(emulated = true)
/* loaded from: classes.dex */
public final class Lists {
    /* renamed from: a */
    public static boolean m4040a(List list, Object obj) {
        if (obj == Preconditions.checkNotNull(list)) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list2 = (List) obj;
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        if ((list instanceof RandomAccess) && (list2 instanceof RandomAccess)) {
            for (int i = 0; i < size; i++) {
                if (!Objects.equal(list.get(i), list2.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return Iterators.elementsEqual(list.iterator(), list2.iterator());
    }

    public static <E> List<E> asList(E e, E[] eArr) {
        return new da1(e, eArr);
    }

    /* renamed from: b */
    public static int m4041b(List list, Object obj) {
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i = 0;
            if (obj == null) {
                while (i < size) {
                    if (list.get(i) != null) {
                        i++;
                    }
                }
                return -1;
            }
            while (i < size) {
                if (!obj.equals(list.get(i))) {
                    i++;
                }
            }
            return -1;
            return i;
        }
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (Objects.equal(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    /* renamed from: c */
    public static int m4042c(List list, Object obj) {
        if (list instanceof RandomAccess) {
            if (obj == null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (list.get(size) == null) {
                        return size;
                    }
                }
                return -1;
            }
            for (int size2 = list.size() - 1; size2 >= 0; size2--) {
                if (obj.equals(list.get(size2))) {
                    return size2;
                }
            }
            return -1;
        }
        ListIterator listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (Objects.equal(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    public static <B> List<List<B>> cartesianProduct(List<? extends List<? extends B>> list) {
        int i = C0896l.f14871c;
        AbstractC0957z abstractC0957z = new AbstractC0957z(list.size());
        Iterator<? extends List<? extends B>> it = list.iterator();
        while (it.hasNext()) {
            ImmutableList copyOf = ImmutableList.copyOf((Collection) it.next());
            if (copyOf.isEmpty()) {
                return ImmutableList.m3902of();
            }
            abstractC0957z.add((AbstractC0957z) copyOf);
        }
        return new C0896l(abstractC0957z.build());
    }

    public static ImmutableList<Character> charactersOf(String str) {
        return new ja1((String) Preconditions.checkNotNull(str));
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayList() {
        return new ArrayList<>();
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayListWithCapacity(int i) {
        p63.m6869m(i, "initialArraySize");
        return new ArrayList<>(i);
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayListWithExpectedSize(int i) {
        p63.m6869m(i, "arraySize");
        return new ArrayList<>(Ints.saturatedCast(i + 5 + (i / 10)));
    }

    @GwtIncompatible
    public static <E> CopyOnWriteArrayList<E> newCopyOnWriteArrayList() {
        return new CopyOnWriteArrayList<>();
    }

    @GwtCompatible(serializable = true)
    public static <E> LinkedList<E> newLinkedList() {
        return new LinkedList<>();
    }

    public static <T> List<List<T>> partition(List<T> list, int i) {
        boolean z;
        Preconditions.checkNotNull(list);
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (list instanceof RandomAccess) {
            return new ea1(i, list);
        }
        return new ea1(i, list);
    }

    public static <T> List<T> reverse(List<T> list) {
        if (list instanceof ImmutableList) {
            return ((ImmutableList) list).reverse();
        }
        if (list instanceof ia1) {
            return ((ia1) list).f18351a;
        }
        if (list instanceof RandomAccess) {
            return new ia1(list);
        }
        return new ia1(list);
    }

    public static <F, T> List<T> transform(List<F> list, Function<? super F, ? extends T> function) {
        if (list instanceof RandomAccess) {
            return new ka1(list, function);
        }
        return new la1(list, function);
    }

    public static <E> List<E> asList(E e, E e2, E[] eArr) {
        return new ma1(e, e2, eArr);
    }

    @Beta
    public static List<Character> charactersOf(CharSequence charSequence) {
        return new ca1((CharSequence) Preconditions.checkNotNull(charSequence));
    }

    @SafeVarargs
    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayList(E... eArr) {
        Preconditions.checkNotNull(eArr);
        int length = eArr.length;
        p63.m6869m(length, "arraySize");
        ArrayList<E> arrayList = new ArrayList<>(Ints.saturatedCast(length + 5 + (length / 10)));
        Collections.addAll(arrayList, eArr);
        return arrayList;
    }

    @GwtIncompatible
    public static <E> CopyOnWriteArrayList<E> newCopyOnWriteArrayList(Iterable<? extends E> iterable) {
        Collection newArrayList;
        if (iterable instanceof Collection) {
            newArrayList = (Collection) iterable;
        } else {
            newArrayList = newArrayList(iterable);
        }
        return new CopyOnWriteArrayList<>(newArrayList);
    }

    @GwtCompatible(serializable = true)
    public static <E> LinkedList<E> newLinkedList(Iterable<? extends E> iterable) {
        LinkedList<E> newLinkedList = newLinkedList();
        Iterables.addAll(newLinkedList, iterable);
        return newLinkedList;
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayList(Iterable<? extends E> iterable) {
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof Collection) {
            return new ArrayList<>((Collection) iterable);
        }
        return newArrayList(iterable.iterator());
    }

    @SafeVarargs
    public static <B> List<List<B>> cartesianProduct(List<? extends B>... listArr) {
        return cartesianProduct(Arrays.asList(listArr));
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayList(Iterator<? extends E> it) {
        ArrayList<E> newArrayList = newArrayList();
        Iterators.addAll(newArrayList, it);
        return newArrayList;
    }
}
