package com.google.gson.internal;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public class NonNullElementWrapperList<E> extends AbstractList<E> implements RandomAccess {

    /* renamed from: a */
    public final ArrayList f15737a;

    public NonNullElementWrapperList(ArrayList<E> arrayList) {
        Objects.requireNonNull(arrayList);
        this.f15737a = arrayList;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, E e) {
        if (e != null) {
            this.f15737a.add(i, e);
            return;
        }
        throw new NullPointerException("Element must be non-null");
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f15737a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return this.f15737a.contains(obj);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return this.f15737a.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        return (E) this.f15737a.get(i);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return this.f15737a.hashCode();
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        return this.f15737a.indexOf(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        return this.f15737a.lastIndexOf(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i) {
        return (E) this.f15737a.remove(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> collection) {
        return this.f15737a.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> collection) {
        return this.f15737a.retainAll(collection);
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i, E e) {
        if (e != null) {
            return (E) this.f15737a.set(i, e);
        }
        throw new NullPointerException("Element must be non-null");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f15737a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return this.f15737a.toArray();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        return this.f15737a.remove(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.f15737a.toArray(tArr);
    }
}
