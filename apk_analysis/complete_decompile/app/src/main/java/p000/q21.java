package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.Iterator;
import java.util.ListIterator;

/* loaded from: classes.dex */
public final class q21 extends ImmutableList {

    /* renamed from: c */
    public final transient ImmutableList f25415c;

    public q21(ImmutableList immutableList) {
        this.f25415c = immutableList;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f25415c.contains(obj);
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: e */
    public final boolean mo7e() {
        return this.f25415c.mo7e();
    }

    @Override // java.util.List
    public final Object get(int i) {
        ImmutableList immutableList = this.f25415c;
        Preconditions.checkElementIndex(i, immutableList.size());
        return immutableList.get((immutableList.size() - 1) - i);
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public final int indexOf(Object obj) {
        int lastIndexOf = this.f25415c.lastIndexOf(obj);
        if (lastIndexOf >= 0) {
            return (r0.size() - 1) - lastIndexOf;
        }
        return -1;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public final int lastIndexOf(Object obj) {
        int indexOf = this.f25415c.indexOf(obj);
        if (indexOf >= 0) {
            return (r0.size() - 1) - indexOf;
        }
        return -1;
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public final /* bridge */ /* synthetic */ ListIterator listIterator() {
        return super.listIterator();
    }

    @Override // com.google.common.collect.ImmutableList
    public final ImmutableList reverse() {
        return this.f25415c;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f25415c.size();
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public final /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
        return super.listIterator(i);
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public final ImmutableList subList(int i, int i2) {
        ImmutableList immutableList = this.f25415c;
        Preconditions.checkPositionIndexes(i, i2, immutableList.size());
        return immutableList.subList(immutableList.size() - i2, immutableList.size() - i).reverse();
    }
}
