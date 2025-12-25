package p000;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class c51 extends AbstractList implements RandomAccess, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final int[] f8251a;

    /* renamed from: b */
    public final int f8252b;

    /* renamed from: c */
    public final int f8253c;

    public c51(int i, int i2, int[] iArr) {
        this.f8251a = iArr;
        this.f8252b = i;
        this.f8253c = i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (obj instanceof Integer) {
            if (Ints.m4273a(this.f8251a, ((Integer) obj).intValue(), this.f8252b, this.f8253c) != -1) {
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
        if (obj instanceof c51) {
            c51 c51Var = (c51) obj;
            int size = size();
            if (c51Var.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (this.f8251a[this.f8252b + i] != c51Var.f8251a[c51Var.f8252b + i]) {
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
        return Integer.valueOf(this.f8251a[this.f8252b + i]);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = this.f8252b; i2 < this.f8253c; i2++) {
            i = (i * 31) + Ints.hashCode(this.f8251a[i2]);
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            int[] iArr = this.f8251a;
            int i = this.f8252b;
            int m4273a = Ints.m4273a(iArr, intValue, i, this.f8253c);
            if (m4273a >= 0) {
                return m4273a - i;
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
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            int i2 = this.f8253c;
            while (true) {
                i2--;
                i = this.f8252b;
                if (i2 >= i) {
                    if (this.f8251a[i2] == intValue) {
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
        int i2 = this.f8252b + i;
        int[] iArr = this.f8251a;
        int i3 = iArr[i2];
        iArr[i2] = ((Integer) Preconditions.checkNotNull((Integer) obj)).intValue();
        return Integer.valueOf(i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f8253c - this.f8252b;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i2) {
        Preconditions.checkPositionIndexes(i, i2, size());
        if (i == i2) {
            return Collections.emptyList();
        }
        int i3 = this.f8252b;
        return new c51(i + i3, i3 + i2, this.f8251a);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        StringBuilder sb = new StringBuilder(size() * 5);
        sb.append('[');
        int[] iArr = this.f8251a;
        int i = this.f8252b;
        sb.append(iArr[i]);
        while (true) {
            i++;
            if (i < this.f8253c) {
                sb.append(", ");
                sb.append(iArr[i]);
            } else {
                sb.append(']');
                return sb.toString();
            }
        }
    }
}
