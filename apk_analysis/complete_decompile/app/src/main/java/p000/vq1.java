package p000;

import androidx.collection.ObjectListKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;

/* loaded from: classes.dex */
public final class vq1 implements List, KMutableList {

    /* renamed from: a */
    public final Object f27927a;

    /* renamed from: b */
    public final int f27928b;

    /* renamed from: c */
    public int f27929c;

    public vq1(List list, int i, int i2) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.f27927a = list;
        this.f27928b = i;
        this.f27929c = i2;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List, java.lang.Object] */
    @Override // java.util.List, java.util.Collection
    public final boolean add(Object obj) {
        int i = this.f27929c;
        this.f27929c = i + 1;
        this.f27927a.add(i, obj);
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List, java.lang.Object] */
    @Override // java.util.List
    public final boolean addAll(int i, Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        this.f27927a.addAll(i + this.f27928b, elements);
        this.f27929c = elements.size() + this.f27929c;
        return elements.size() > 0;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List, java.lang.Object] */
    @Override // java.util.List, java.util.Collection
    public final void clear() {
        int i = this.f27929c - 1;
        int i2 = this.f27928b;
        if (i2 <= i) {
            while (true) {
                this.f27927a.remove(i);
                if (i == i2) {
                    break;
                } else {
                    i--;
                }
            }
        }
        this.f27929c = i2;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List, java.lang.Object] */
    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        int i = this.f27929c;
        for (int i2 = this.f27928b; i2 < i; i2++) {
            if (Intrinsics.areEqual(this.f27927a.get(i2), obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List, java.lang.Object] */
    @Override // java.util.List
    public final Object get(int i) {
        ObjectListKt.access$checkIndex(this, i);
        return this.f27927a.get(i + this.f27928b);
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.List, java.lang.Object] */
    @Override // java.util.List
    public final int indexOf(Object obj) {
        int i = this.f27929c;
        int i2 = this.f27928b;
        for (int i3 = i2; i3 < i; i3++) {
            if (Intrinsics.areEqual(this.f27927a.get(i3), obj)) {
                return i3 - i2;
            }
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        if (this.f27929c == this.f27928b) {
            return true;
        }
        return false;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new tq1(0, this);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List, java.lang.Object] */
    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        int i = this.f27929c - 1;
        int i2 = this.f27928b;
        if (i2 <= i) {
            while (!Intrinsics.areEqual(this.f27927a.get(i), obj)) {
                if (i != i2) {
                    i--;
                } else {
                    return -1;
                }
            }
            return i - i2;
        }
        return -1;
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        return new tq1(0, this);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List, java.lang.Object] */
    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        int i = this.f27929c;
        for (int i2 = this.f27928b; i2 < i; i2++) {
            ?? r2 = this.f27927a;
            if (Intrinsics.areEqual(r2.get(i2), obj)) {
                r2.remove(i2);
                this.f27929c--;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = this.f27929c;
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
        if (i != this.f27929c) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.List, java.lang.Object] */
    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = this.f27929c;
        int i2 = i - 1;
        int i3 = this.f27928b;
        if (i3 <= i2) {
            while (true) {
                ?? r3 = this.f27927a;
                if (!elements.contains(r3.get(i2))) {
                    r3.remove(i2);
                    this.f27929c--;
                }
                if (i2 == i3) {
                    break;
                }
                i2--;
            }
        }
        if (i != this.f27929c) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List, java.lang.Object] */
    @Override // java.util.List
    public final Object set(int i, Object obj) {
        ObjectListKt.access$checkIndex(this, i);
        return this.f27927a.set(i + this.f27928b, obj);
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.f27929c - this.f27928b;
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

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List, java.lang.Object] */
    @Override // java.util.List
    public final void add(int i, Object obj) {
        this.f27927a.add(i + this.f27928b, obj);
        this.f27929c++;
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i) {
        return new tq1(i, this);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray(Object[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return CollectionToArray.toArray(this, array);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List, java.lang.Object] */
    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        this.f27927a.addAll(this.f27929c, elements);
        this.f27929c = elements.size() + this.f27929c;
        return elements.size() > 0;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List, java.lang.Object] */
    @Override // java.util.List
    public final Object remove(int i) {
        ObjectListKt.access$checkIndex(this, i);
        this.f27929c--;
        return this.f27927a.remove(i + this.f27928b);
    }
}
