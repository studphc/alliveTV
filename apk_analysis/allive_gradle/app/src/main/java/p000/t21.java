package p000;

import com.google.common.primitives.ImmutableLongArray;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class t21 extends AbstractList implements RandomAccess, Serializable {

    /* renamed from: a */
    public final ImmutableLongArray f26674a;

    public t21(ImmutableLongArray immutableLongArray) {
        this.f26674a = immutableLongArray;
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
        boolean z = obj instanceof t21;
        ImmutableLongArray immutableLongArray = this.f26674a;
        if (z) {
            return immutableLongArray.equals(((t21) obj).f26674a);
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list = (List) obj;
        if (immutableLongArray.length() != list.size()) {
            return false;
        }
        int i = immutableLongArray.f15211b;
        for (Object obj2 : list) {
            if (obj2 instanceof Long) {
                int i2 = i + 1;
                if (immutableLongArray.f15210a[i] == ((Long) obj2).longValue()) {
                    i = i2;
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return Long.valueOf(this.f26674a.get(i));
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        return this.f26674a.hashCode();
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Long) {
            return this.f26674a.indexOf(((Long) obj).longValue());
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj instanceof Long) {
            return this.f26674a.lastIndexOf(((Long) obj).longValue());
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f26674a.length();
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i2) {
        return this.f26674a.subArray(i, i2).asList();
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return this.f26674a.toString();
    }
}
