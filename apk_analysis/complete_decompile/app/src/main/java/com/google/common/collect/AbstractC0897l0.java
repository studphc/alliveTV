package com.google.common.collect;

import com.google.common.collect.ImmutableSortedSet;
import com.google.errorprone.annotations.DoNotCall;

/* renamed from: com.google.common.collect.l0 */
/* loaded from: classes.dex */
public abstract class AbstractC0897l0 extends ImmutableSet {
    @DoNotCall("Use naturalOrder")
    @Deprecated
    public static <E> ImmutableSortedSet.Builder<E> builder() {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Use naturalOrder (which does not accept an expected size)")
    @Deprecated
    public static <E> ImmutableSortedSet.Builder<E> builderWithExpectedSize(int i) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Pass parameters of type Comparable")
    @Deprecated
    public static <E> ImmutableSortedSet<E> copyOf(E[] eArr) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Pass a parameter of type Comparable")
    @Deprecated
    /* renamed from: of */
    public static <E> ImmutableSortedSet<E> m4127of(E e) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Pass parameters of type Comparable")
    @Deprecated
    /* renamed from: of */
    public static <E> ImmutableSortedSet<E> m4128of(E e, E e2) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Pass parameters of type Comparable")
    @Deprecated
    /* renamed from: of */
    public static <E> ImmutableSortedSet<E> m4129of(E e, E e2, E e3) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Pass parameters of type Comparable")
    @Deprecated
    /* renamed from: of */
    public static <E> ImmutableSortedSet<E> m4130of(E e, E e2, E e3, E e4) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Pass parameters of type Comparable")
    @Deprecated
    /* renamed from: of */
    public static <E> ImmutableSortedSet<E> m4131of(E e, E e2, E e3, E e4, E e5) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Pass parameters of type Comparable")
    @Deprecated
    /* renamed from: of */
    public static <E> ImmutableSortedSet<E> m4132of(E e, E e2, E e3, E e4, E e5, E e6, E... eArr) {
        throw new UnsupportedOperationException();
    }
}
