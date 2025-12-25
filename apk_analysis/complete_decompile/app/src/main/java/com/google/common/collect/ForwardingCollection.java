package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.CheckForNull;
import p000.p63;

@GwtCompatible
/* loaded from: classes.dex */
public abstract class ForwardingCollection<E> extends ForwardingObject implements Collection<E> {
    @CanIgnoreReturnValue
    public boolean add(E e) {
        return delegate().add(e);
    }

    @CanIgnoreReturnValue
    public boolean addAll(Collection<? extends E> collection) {
        return delegate().addAll(collection);
    }

    @Override // java.util.Collection
    public void clear() {
        delegate().clear();
    }

    @Override // java.util.Collection
    public boolean contains(@CheckForNull Object obj) {
        return delegate().contains(obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return delegate().containsAll(collection);
    }

    @Override // com.google.common.collect.ForwardingObject
    public abstract Collection<E> delegate();

    @Override // java.util.Collection
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return delegate().iterator();
    }

    @Override // java.util.Collection
    @CanIgnoreReturnValue
    public boolean remove(@CheckForNull Object obj) {
        return delegate().remove(obj);
    }

    @Override // java.util.Collection
    @CanIgnoreReturnValue
    public boolean removeAll(Collection<?> collection) {
        return delegate().removeAll(collection);
    }

    @Override // java.util.Collection
    @CanIgnoreReturnValue
    public boolean retainAll(Collection<?> collection) {
        return delegate().retainAll(collection);
    }

    @Override // java.util.Collection
    public int size() {
        return delegate().size();
    }

    public boolean standardAddAll(Collection<? extends E> collection) {
        return Iterators.addAll(this, collection.iterator());
    }

    public void standardClear() {
        Iterators.m4034b(iterator());
    }

    public boolean standardContains(@CheckForNull Object obj) {
        return Iterators.contains(iterator(), obj);
    }

    public boolean standardContainsAll(Collection<?> collection) {
        return Collections2.m3835b(this, collection);
    }

    public boolean standardIsEmpty() {
        return !iterator().hasNext();
    }

    public boolean standardRemove(@CheckForNull Object obj) {
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (Objects.equal(it.next(), obj)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public boolean standardRemoveAll(Collection<?> collection) {
        return Iterators.removeAll(iterator(), collection);
    }

    public boolean standardRetainAll(Collection<?> collection) {
        return Iterators.retainAll(iterator(), collection);
    }

    public Object[] standardToArray() {
        return toArray(new Object[size()]);
    }

    public String standardToString() {
        int size = size();
        p63.m6869m(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(size * 8, 1073741824L));
        sb.append('[');
        boolean z = true;
        for (E e : this) {
            if (!z) {
                sb.append(", ");
            }
            if (e == this) {
                sb.append("(this Collection)");
            } else {
                sb.append(e);
            }
            z = false;
        }
        sb.append(']');
        return sb.toString();
    }

    public Object[] toArray() {
        return delegate().toArray();
    }

    @Override // java.util.Collection
    @CanIgnoreReturnValue
    public <T> T[] toArray(T[] tArr) {
        return (T[]) delegate().toArray(tArr);
    }

    public <T> T[] standardToArray(T[] tArr) {
        return (T[]) ObjectArrays.m4067c(this, tArr);
    }
}
