package p000;

import androidx.collection.MutableObjectList;
import androidx.collection.ObjectListKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;

/* loaded from: classes.dex */
public final class uq1 implements List, KMutableList {

    /* renamed from: a */
    public final MutableObjectList f27410a;

    public uq1(MutableObjectList objectList) {
        Intrinsics.checkNotNullParameter(objectList, "objectList");
        this.f27410a = objectList;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean add(Object obj) {
        return this.f27410a.add(obj);
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.f27410a.addAll(i, elements);
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        this.f27410a.clear();
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f27410a.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.f27410a.containsAll(elements);
    }

    @Override // java.util.List
    public final Object get(int i) {
        ObjectListKt.access$checkIndex(this, i);
        return this.f27410a.get(i);
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        return this.f27410a.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return this.f27410a.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new tq1(0, this);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        return this.f27410a.lastIndexOf(obj);
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        return new tq1(0, this);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        return this.f27410a.remove(obj);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.f27410a.removeAll(elements);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.f27410a.retainAll(elements);
    }

    @Override // java.util.List
    public final Object set(int i, Object obj) {
        ObjectListKt.access$checkIndex(this, i);
        return this.f27410a.set(i, obj);
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.f27410a.getSize();
    }

    @Override // java.util.List
    public final List subList(int i, int i2) {
        ObjectListKt.access$checkSubIndex(this, i, i2);
        return new vq1(this, i, i2);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List
    public final void add(int i, Object obj) {
        this.f27410a.add(i, obj);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.f27410a.addAll(elements);
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i) {
        return new tq1(i, this);
    }

    @Override // java.util.List
    public final Object remove(int i) {
        ObjectListKt.access$checkIndex(this, i);
        return this.f27410a.removeAt(i);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray(Object[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return CollectionToArray.toArray(this, array);
    }
}
