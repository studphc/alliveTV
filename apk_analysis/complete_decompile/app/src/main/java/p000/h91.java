package p000;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableListIterator;

/* loaded from: classes2.dex */
public final class h91 implements ListIterator, KMutableListIterator {

    /* renamed from: a */
    public final ListBuilder f17987a;

    /* renamed from: b */
    public int f17988b;

    /* renamed from: c */
    public int f17989c;

    public h91(ListBuilder list, int i) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.f17987a = list;
        this.f17988b = i;
        this.f17989c = -1;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        int i = this.f17988b;
        this.f17988b = i + 1;
        this.f17987a.add(i, obj);
        this.f17989c = -1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        int i;
        int i2 = this.f17988b;
        i = this.f17987a.f21018c;
        if (i2 < i) {
            return true;
        }
        return false;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        if (this.f17988b > 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        int i;
        Object[] objArr;
        int i2;
        int i3 = this.f17988b;
        ListBuilder listBuilder = this.f17987a;
        i = listBuilder.f21018c;
        if (i3 < i) {
            int i4 = this.f17988b;
            this.f17988b = i4 + 1;
            this.f17989c = i4;
            objArr = listBuilder.f21016a;
            i2 = listBuilder.f21017b;
            return objArr[i2 + this.f17989c];
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f17988b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        Object[] objArr;
        int i;
        int i2 = this.f17988b;
        if (i2 > 0) {
            int i3 = i2 - 1;
            this.f17988b = i3;
            this.f17989c = i3;
            ListBuilder listBuilder = this.f17987a;
            objArr = listBuilder.f21016a;
            i = listBuilder.f21017b;
            return objArr[i + this.f17989c];
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f17988b - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        int i = this.f17989c;
        if (i != -1) {
            this.f17987a.remove(i);
            this.f17988b = this.f17989c;
            this.f17989c = -1;
            return;
        }
        throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        int i = this.f17989c;
        if (i != -1) {
            this.f17987a.set(i, obj);
            return;
        }
        throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
    }
}
