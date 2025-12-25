package p000;

import com.google.common.primitives.ImmutableIntArray;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class p21 extends AbstractList implements RandomAccess, Serializable {

    /* renamed from: a */
    public final ImmutableIntArray f25009a;

    public p21(ImmutableIntArray immutableIntArray) {
        this.f25009a = immutableIntArray;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (indexOf(obj) >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        boolean z = obj instanceof p21;
        ImmutableIntArray immutableIntArray = this.f25009a;
        if (z) {
            return immutableIntArray.equals(((p21) obj).f25009a);
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list = (List) obj;
        if (immutableIntArray.length() != list.size()) {
            return false;
        }
        int i = immutableIntArray.f15205b;
        for (Object obj2 : list) {
            if (obj2 instanceof Integer) {
                int i2 = i + 1;
                if (immutableIntArray.f15204a[i] == ((Integer) obj2).intValue()) {
                    i = i2;
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return Integer.valueOf(this.f25009a.get(i));
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        return this.f25009a.hashCode();
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Integer) {
            return this.f25009a.indexOf(((Integer) obj).intValue());
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj instanceof Integer) {
            return this.f25009a.lastIndexOf(((Integer) obj).intValue());
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f25009a.length();
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i2) {
        return this.f25009a.subArray(i, i2).asList();
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return this.f25009a.toString();
    }
}
