package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes.dex */
public class ia1 extends AbstractList {

    /* renamed from: a */
    public final List f18351a;

    public ia1(List list) {
        this.f18351a = (List) Preconditions.checkNotNull(list);
    }

    /* renamed from: a */
    public final int m5205a(int i) {
        int size = this.f18351a.size();
        Preconditions.checkPositionIndex(i, size);
        return size - i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        this.f18351a.add(m5205a(i), obj);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        this.f18351a.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        List list = this.f18351a;
        int size = list.size();
        Preconditions.checkElementIndex(i, size);
        return list.get((size - 1) - i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator();
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        return new ha1(this, this.f18351a.listIterator(m5205a(i)));
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        List list = this.f18351a;
        int size = list.size();
        Preconditions.checkElementIndex(i, size);
        return list.remove((size - 1) - i);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        subList(i, i2).clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        List list = this.f18351a;
        int size = list.size();
        Preconditions.checkElementIndex(i, size);
        return list.set((size - 1) - i, obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f18351a.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i2) {
        List list = this.f18351a;
        Preconditions.checkPositionIndexes(i, i2, list.size());
        return Lists.reverse(list.subList(m5205a(i2), m5205a(i)));
    }
}
