package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.annotations.NonNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class VolatileSizeArrayList<T> extends AtomicInteger implements List<T>, RandomAccess {
    private static final long serialVersionUID = 3972397474470203923L;

    /* renamed from: a */
    public final ArrayList f19967a;

    public VolatileSizeArrayList() {
        this.f19967a = new ArrayList();
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T t) {
        ArrayList arrayList = this.f19967a;
        boolean add = arrayList.add(t);
        lazySet(arrayList.size());
        return add;
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(@NonNull Collection<? extends T> collection) {
        ArrayList arrayList = this.f19967a;
        boolean addAll = arrayList.addAll(collection);
        lazySet(arrayList.size());
        return addAll;
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.f19967a.clear();
        lazySet(0);
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return this.f19967a.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(@NonNull Collection<?> collection) {
        return this.f19967a.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        boolean z = obj instanceof VolatileSizeArrayList;
        ArrayList arrayList = this.f19967a;
        if (z) {
            return arrayList.equals(((VolatileSizeArrayList) obj).f19967a);
        }
        return arrayList.equals(obj);
    }

    @Override // java.util.List
    public T get(int i) {
        return (T) this.f19967a.get(i);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.f19967a.hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.f19967a.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        if (get() == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return this.f19967a.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.f19967a.lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return this.f19967a.listIterator();
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        ArrayList arrayList = this.f19967a;
        boolean remove = arrayList.remove(obj);
        lazySet(arrayList.size());
        return remove;
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(@NonNull Collection<?> collection) {
        ArrayList arrayList = this.f19967a;
        boolean removeAll = arrayList.removeAll(collection);
        lazySet(arrayList.size());
        return removeAll;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(@NonNull Collection<?> collection) {
        ArrayList arrayList = this.f19967a;
        boolean retainAll = arrayList.retainAll(collection);
        lazySet(arrayList.size());
        return retainAll;
    }

    @Override // java.util.List
    public T set(int i, T t) {
        return (T) this.f19967a.set(i, t);
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return get();
    }

    @Override // java.util.List
    public List<T> subList(int i, int i2) {
        return this.f19967a.subList(i, i2);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.f19967a.toArray();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public String toString() {
        return this.f19967a.toString();
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int i) {
        return this.f19967a.listIterator(i);
    }

    @Override // java.util.List, java.util.Collection
    public <E> E[] toArray(@NonNull E[] eArr) {
        return (E[]) this.f19967a.toArray(eArr);
    }

    public VolatileSizeArrayList(int i) {
        this.f19967a = new ArrayList(i);
    }

    @Override // java.util.List
    public void add(int i, T t) {
        ArrayList arrayList = this.f19967a;
        arrayList.add(i, t);
        lazySet(arrayList.size());
    }

    @Override // java.util.List
    public boolean addAll(int i, @NonNull Collection<? extends T> collection) {
        ArrayList arrayList = this.f19967a;
        boolean addAll = arrayList.addAll(i, collection);
        lazySet(arrayList.size());
        return addAll;
    }

    @Override // java.util.List
    public T remove(int i) {
        ArrayList arrayList = this.f19967a;
        T t = (T) arrayList.remove(i);
        lazySet(arrayList.size());
        return t;
    }
}
