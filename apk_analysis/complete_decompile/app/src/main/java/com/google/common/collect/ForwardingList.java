package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;
import p000.ca1;

@GwtCompatible
/* loaded from: classes.dex */
public abstract class ForwardingList<E> extends ForwardingCollection<E> implements List<E> {
    @Override // java.util.List
    public void add(int i, E e) {
        delegate().add(i, e);
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    public boolean addAll(int i, Collection<? extends E> collection) {
        return delegate().addAll(i, collection);
    }

    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract List<E> delegate();

    @Override // java.util.Collection, java.util.List
    public boolean equals(@CheckForNull Object obj) {
        if (obj != this && !delegate().equals(obj)) {
            return false;
        }
        return true;
    }

    @Override // java.util.List
    public E get(int i) {
        return delegate().get(i);
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // java.util.List
    public int indexOf(@CheckForNull Object obj) {
        return delegate().indexOf(obj);
    }

    @Override // java.util.List
    public int lastIndexOf(@CheckForNull Object obj) {
        return delegate().lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return delegate().listIterator();
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    public E remove(int i) {
        return delegate().remove(i);
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    public E set(int i, E e) {
        return delegate().set(i, e);
    }

    public boolean standardAdd(E e) {
        add(size(), e);
        return true;
    }

    public boolean standardAddAll(int i, Iterable<? extends E> iterable) {
        ListIterator<E> listIterator = listIterator(i);
        Iterator<? extends E> it = iterable.iterator();
        boolean z = false;
        while (it.hasNext()) {
            listIterator.add(it.next());
            z = true;
        }
        return z;
    }

    @Beta
    public boolean standardEquals(@CheckForNull Object obj) {
        return Lists.m4040a(this, obj);
    }

    @Beta
    public int standardHashCode() {
        int hashCode;
        int i = 1;
        for (E e : this) {
            int i2 = i * 31;
            if (e == null) {
                hashCode = 0;
            } else {
                hashCode = e.hashCode();
            }
            i = ~(~(i2 + hashCode));
        }
        return i;
    }

    public int standardIndexOf(@CheckForNull Object obj) {
        return Lists.m4041b(this, obj);
    }

    public Iterator<E> standardIterator() {
        return listIterator();
    }

    public int standardLastIndexOf(@CheckForNull Object obj) {
        return Lists.m4042c(this, obj);
    }

    public ListIterator<E> standardListIterator() {
        return listIterator(0);
    }

    @Beta
    public List<E> standardSubList(int i, int i2) {
        ca1 ca1Var;
        if (this instanceof RandomAccess) {
            ca1Var = new ca1(this);
        } else {
            ca1Var = new ca1(this);
        }
        return ca1Var.subList(i, i2);
    }

    @Override // java.util.List
    public List<E> subList(int i, int i2) {
        return delegate().subList(i, i2);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i) {
        return delegate().listIterator(i);
    }

    @Beta
    public ListIterator<E> standardListIterator(int i) {
        return new ca1(this).listIterator(i);
    }
}
