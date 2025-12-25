package p000;

import androidx.collection.ArrayMap;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: ib */
/* loaded from: classes.dex */
public final class C1300ib implements Collection {

    /* renamed from: a */
    public final /* synthetic */ ArrayMap f18352a;

    public C1300ib(ArrayMap arrayMap) {
        this.f18352a = arrayMap;
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final void clear() {
        this.f18352a.clear();
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        if (this.f18352a.__restricted$indexOfValue(obj) >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f18352a.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new C1189fb(this.f18352a, 1);
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        ArrayMap arrayMap = this.f18352a;
        int __restricted$indexOfValue = arrayMap.__restricted$indexOfValue(obj);
        if (__restricted$indexOfValue >= 0) {
            arrayMap.removeAt(__restricted$indexOfValue);
            return true;
        }
        return false;
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        ArrayMap arrayMap = this.f18352a;
        int f1755c = arrayMap.getF1755c();
        int i = 0;
        boolean z = false;
        while (i < f1755c) {
            if (collection.contains(arrayMap.valueAt(i))) {
                arrayMap.removeAt(i);
                i--;
                f1755c--;
                z = true;
            }
            i++;
        }
        return z;
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        ArrayMap arrayMap = this.f18352a;
        int f1755c = arrayMap.getF1755c();
        int i = 0;
        boolean z = false;
        while (i < f1755c) {
            if (!collection.contains(arrayMap.valueAt(i))) {
                arrayMap.removeAt(i);
                i--;
                f1755c--;
                z = true;
            }
            i++;
        }
        return z;
    }

    @Override // java.util.Collection
    public final int size() {
        return this.f18352a.getF1755c();
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        ArrayMap arrayMap = this.f18352a;
        int f1755c = arrayMap.getF1755c();
        if (objArr.length < f1755c) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), f1755c);
        }
        for (int i = 0; i < f1755c; i++) {
            objArr[i] = arrayMap.valueAt(i);
        }
        if (objArr.length > f1755c) {
            objArr[f1755c] = null;
        }
        return objArr;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        ArrayMap arrayMap = this.f18352a;
        int f1755c = arrayMap.getF1755c();
        Object[] objArr = new Object[f1755c];
        for (int i = 0; i < f1755c; i++) {
            objArr[i] = arrayMap.valueAt(i);
        }
        return objArr;
    }
}
