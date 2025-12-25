package p000;

import com.google.common.primitives.ImmutableDoubleArray;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class j21 extends AbstractList implements RandomAccess, Serializable {

    /* renamed from: a */
    public final ImmutableDoubleArray f20350a;

    public j21(ImmutableDoubleArray immutableDoubleArray) {
        this.f20350a = immutableDoubleArray;
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
        boolean z = obj instanceof j21;
        ImmutableDoubleArray immutableDoubleArray = this.f20350a;
        if (z) {
            return immutableDoubleArray.equals(((j21) obj).f20350a);
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list = (List) obj;
        if (immutableDoubleArray.length() != list.size()) {
            return false;
        }
        int i = immutableDoubleArray.f15199b;
        for (Object obj2 : list) {
            if (obj2 instanceof Double) {
                int i2 = i + 1;
                if (ImmutableDoubleArray.m4245a(immutableDoubleArray.f15198a[i], ((Double) obj2).doubleValue())) {
                    i = i2;
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return Double.valueOf(this.f20350a.get(i));
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        return this.f20350a.hashCode();
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Double) {
            return this.f20350a.indexOf(((Double) obj).doubleValue());
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj instanceof Double) {
            return this.f20350a.lastIndexOf(((Double) obj).doubleValue());
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f20350a.length();
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i2) {
        return this.f20350a.subArray(i, i2).asList();
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return this.f20350a.toString();
    }
}
