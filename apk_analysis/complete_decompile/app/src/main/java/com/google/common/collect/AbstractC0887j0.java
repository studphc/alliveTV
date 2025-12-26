package com.google.common.collect;

import com.google.common.collect.ImmutableSortedMultiset;
import com.google.errorprone.annotations.DoNotCall;

/* renamed from: com.google.common.collect.j0 */
/* loaded from: classes.dex */
public abstract class AbstractC0887j0 extends ImmutableMultiset {
    @DoNotCall("Use naturalOrder.")
    @Deprecated
    public static <E> ImmutableSortedMultiset.Builder<E> builder() {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Elements must be Comparable. (Or, pass a Comparator to orderedBy or copyOf.)")
    @Deprecated
    public static <E> ImmutableSortedMultiset<E> copyOf(E[] eArr) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Elements must be Comparable. (Or, pass a Comparator to orderedBy or copyOf.)")
    @Deprecated
    /* renamed from: of */
    public static <E> ImmutableSortedMultiset<E> m4120of(E e) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Elements must be Comparable. (Or, pass a Comparator to orderedBy or copyOf.)")
    @Deprecated
    /* renamed from: of */
    public static <E> ImmutableSortedMultiset<E> m4121of(E e, E e2) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Elements must be Comparable. (Or, pass a Comparator to orderedBy or copyOf.)")
    @Deprecated
    /* renamed from: of */
    public static <E> ImmutableSortedMultiset<E> m4122of(E e, E e2, E e3) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Elements must be Comparable. (Or, pass a Comparator to orderedBy or copyOf.)")
    @Deprecated
    /* renamed from: of */
    public static <E> ImmutableSortedMultiset<E> m4123of(E e, E e2, E e3, E e4) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Elements must be Comparable. (Or, pass a Comparator to orderedBy or copyOf.)")
    @Deprecated
    /* renamed from: of */
    public static <E> ImmutableSortedMultiset<E> m4124of(E e, E e2, E e3, E e4, E e5) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Elements must be Comparable. (Or, pass a Comparator to orderedBy or copyOf.)")
    @Deprecated
    /* renamed from: of */
    public static <E> ImmutableSortedMultiset<E> m4125of(E e, E e2, E e3, E e4, E e5, E e6, E... eArr) {
        throw new UnsupportedOperationException();
    }
}
