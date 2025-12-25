package p000;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Booleans;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: kh */
/* loaded from: classes2.dex */
public final class C1391kh extends AbstractList implements RandomAccess, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final boolean[] f20850a;

    /* renamed from: b */
    public final int f20851b;

    /* renamed from: c */
    public final int f20852c;

    public C1391kh(boolean[] zArr, int i, int i2) {
        this.f20850a = zArr;
        this.f20851b = i;
        this.f20852c = i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (obj instanceof Boolean) {
            if (Booleans.m4240a(this.f20850a, ((Boolean) obj).booleanValue(), this.f20851b, this.f20852c) != -1) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C1391kh) {
            C1391kh c1391kh = (C1391kh) obj;
            int size = size();
            if (c1391kh.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (this.f20850a[this.f20851b + i] != c1391kh.f20850a[c1391kh.f20851b + i]) {
                    return false;
                }
            }
            return true;
        }
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        Preconditions.checkElementIndex(i, size());
        return Boolean.valueOf(this.f20850a[this.f20851b + i]);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = this.f20851b; i2 < this.f20852c; i2++) {
            i = (i * 31) + Booleans.hashCode(this.f20850a[i2]);
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Boolean) {
            boolean booleanValue = ((Boolean) obj).booleanValue();
            boolean[] zArr = this.f20850a;
            int i = this.f20851b;
            int m4240a = Booleans.m4240a(zArr, booleanValue, i, this.f20852c);
            if (m4240a >= 0) {
                return m4240a - i;
            }
            return -1;
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int i;
        if (obj instanceof Boolean) {
            boolean booleanValue = ((Boolean) obj).booleanValue();
            int i2 = this.f20852c;
            while (true) {
                i2--;
                i = this.f20851b;
                if (i2 >= i) {
                    if (this.f20850a[i2] == booleanValue) {
                        break;
                    }
                } else {
                    i2 = -1;
                    break;
                }
            }
            if (i2 >= 0) {
                return i2 - i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        Preconditions.checkElementIndex(i, size());
        int i2 = this.f20851b + i;
        boolean[] zArr = this.f20850a;
        boolean z = zArr[i2];
        zArr[i2] = ((Boolean) Preconditions.checkNotNull((Boolean) obj)).booleanValue();
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f20852c - this.f20851b;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i2) {
        Preconditions.checkPositionIndexes(i, i2, size());
        if (i == i2) {
            return Collections.emptyList();
        }
        int i3 = this.f20851b;
        return new C1391kh(this.f20850a, i + i3, i3 + i2);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder(size() * 7);
        boolean[] zArr = this.f20850a;
        int i = this.f20851b;
        if (zArr[i]) {
            str = "[true";
        } else {
            str = "[false";
        }
        sb.append(str);
        while (true) {
            i++;
            if (i < this.f20852c) {
                if (zArr[i]) {
                    str2 = ", true";
                } else {
                    str2 = ", false";
                }
                sb.append(str2);
            } else {
                sb.append(']');
                return sb.toString();
            }
        }
    }
}
