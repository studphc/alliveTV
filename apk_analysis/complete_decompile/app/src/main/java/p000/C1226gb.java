package p000;

import androidx.collection.ArrayMap;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* renamed from: gb */
/* loaded from: classes.dex */
public final class C1226gb implements Set {

    /* renamed from: a */
    public final /* synthetic */ ArrayMap f17627a;

    public C1226gb(ArrayMap arrayMap) {
        this.f17627a = arrayMap;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        this.f17627a.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f17627a.containsKey(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection collection) {
        return this.f17627a.containsAll(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    if (containsAll(set)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public final int hashCode() {
        int hashCode;
        ArrayMap arrayMap = this.f17627a;
        int i = 0;
        for (int f1755c = arrayMap.getF1755c() - 1; f1755c >= 0; f1755c--) {
            K keyAt = arrayMap.keyAt(f1755c);
            if (keyAt == 0) {
                hashCode = 0;
            } else {
                hashCode = keyAt.hashCode();
            }
            i += hashCode;
        }
        return i;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        return this.f17627a.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new C1189fb(this.f17627a, 0);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        ArrayMap arrayMap = this.f17627a;
        int indexOfKey = arrayMap.indexOfKey(obj);
        if (indexOfKey >= 0) {
            arrayMap.removeAt(indexOfKey);
            return true;
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection collection) {
        return this.f17627a.removeAll(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection collection) {
        return this.f17627a.retainAll(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        return this.f17627a.getF1755c();
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        ArrayMap arrayMap = this.f17627a;
        int f1755c = arrayMap.getF1755c();
        if (objArr.length < f1755c) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), f1755c);
        }
        for (int i = 0; i < f1755c; i++) {
            objArr[i] = arrayMap.keyAt(i);
        }
        if (objArr.length > f1755c) {
            objArr[f1755c] = null;
        }
        return objArr;
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        ArrayMap arrayMap = this.f17627a;
        int f1755c = arrayMap.getF1755c();
        Object[] objArr = new Object[f1755c];
        for (int i = 0; i < f1755c; i++) {
            objArr[i] = arrayMap.keyAt(i);
        }
        return objArr;
    }
}
