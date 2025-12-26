package p000;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Shorts;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class fi2 extends AbstractList implements RandomAccess, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final short[] f17279a;

    /* renamed from: b */
    public final int f17280b;

    /* renamed from: c */
    public final int f17281c;

    public fi2(short[] sArr, int i, int i2) {
        this.f17279a = sArr;
        this.f17280b = i;
        this.f17281c = i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (obj instanceof Short) {
            if (Shorts.m4275a(this.f17279a, ((Short) obj).shortValue(), this.f17280b, this.f17281c) != -1) {
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
        if (obj instanceof fi2) {
            fi2 fi2Var = (fi2) obj;
            int size = size();
            if (fi2Var.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (this.f17279a[this.f17280b + i] != fi2Var.f17279a[fi2Var.f17280b + i]) {
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
        return Short.valueOf(this.f17279a[this.f17280b + i]);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = this.f17280b; i2 < this.f17281c; i2++) {
            i = (i * 31) + Shorts.hashCode(this.f17279a[i2]);
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Short) {
            short shortValue = ((Short) obj).shortValue();
            short[] sArr = this.f17279a;
            int i = this.f17280b;
            int m4275a = Shorts.m4275a(sArr, shortValue, i, this.f17281c);
            if (m4275a >= 0) {
                return m4275a - i;
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
        if (obj instanceof Short) {
            short shortValue = ((Short) obj).shortValue();
            int i2 = this.f17281c;
            while (true) {
                i2--;
                i = this.f17280b;
                if (i2 >= i) {
                    if (this.f17279a[i2] == shortValue) {
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
        int i2 = this.f17280b + i;
        short[] sArr = this.f17279a;
        short s = sArr[i2];
        sArr[i2] = ((Short) Preconditions.checkNotNull((Short) obj)).shortValue();
        return Short.valueOf(s);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f17281c - this.f17280b;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i2) {
        Preconditions.checkPositionIndexes(i, i2, size());
        if (i == i2) {
            return Collections.emptyList();
        }
        int i3 = this.f17280b;
        return new fi2(this.f17279a, i + i3, i3 + i2);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        StringBuilder sb = new StringBuilder(size() * 6);
        sb.append('[');
        short[] sArr = this.f17279a;
        int i = this.f17280b;
        sb.append((int) sArr[i]);
        while (true) {
            i++;
            if (i < this.f17281c) {
                sb.append(", ");
                sb.append((int) sArr[i]);
            } else {
                sb.append(']');
                return sb.toString();
            }
        }
    }
}
