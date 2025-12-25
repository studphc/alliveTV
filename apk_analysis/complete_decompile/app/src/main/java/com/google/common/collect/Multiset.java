package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CompatibleWith;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible
/* loaded from: classes.dex */
public interface Multiset<E> extends Collection<E> {

    /* loaded from: classes.dex */
    public interface Entry<E> {
        boolean equals(@CheckForNull Object obj);

        int getCount();

        E getElement();

        int hashCode();

        String toString();
    }

    @CanIgnoreReturnValue
    int add(E e, int i);

    @Override // java.util.Collection
    @CanIgnoreReturnValue
    boolean add(E e);

    boolean contains(@CheckForNull Object obj);

    @Override // java.util.Collection
    boolean containsAll(Collection<?> collection);

    int count(@CheckForNull @CompatibleWith("E") Object obj);

    Set<E> elementSet();

    Set<Entry<E>> entrySet();

    boolean equals(@CheckForNull Object obj);

    int hashCode();

    Iterator<E> iterator();

    @CanIgnoreReturnValue
    int remove(@CheckForNull @CompatibleWith("E") Object obj, int i);

    @Override // java.util.Collection
    @CanIgnoreReturnValue
    boolean remove(@CheckForNull Object obj);

    @Override // java.util.Collection
    @CanIgnoreReturnValue
    boolean removeAll(Collection<?> collection);

    @Override // java.util.Collection
    @CanIgnoreReturnValue
    boolean retainAll(Collection<?> collection);

    @CanIgnoreReturnValue
    int setCount(E e, int i);

    @CanIgnoreReturnValue
    boolean setCount(E e, int i, int i2);

    int size();

    String toString();
}
