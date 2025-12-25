package p000;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class q50 extends AbstractList implements RandomAccess, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final double[] f25453a;

    /* renamed from: b */
    public final int f25454b;

    /* renamed from: c */
    public final int f25455c;

    public q50(double[] dArr, int i, int i2) {
        this.f25453a = dArr;
        this.f25454b = i;
        this.f25455c = i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (obj instanceof Double) {
            if (Doubles.m4243S(this.f25453a, ((Double) obj).doubleValue(), this.f25454b, this.f25455c) != -1) {
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
        if (obj instanceof q50) {
            q50 q50Var = (q50) obj;
            int size = size();
            if (q50Var.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (this.f25453a[this.f25454b + i] != q50Var.f25453a[q50Var.f25454b + i]) {
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
        return Double.valueOf(this.f25453a[this.f25454b + i]);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = this.f25454b; i2 < this.f25455c; i2++) {
            i = (i * 31) + Doubles.hashCode(this.f25453a[i2]);
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            double[] dArr = this.f25453a;
            int i = this.f25454b;
            int m4243S = Doubles.m4243S(dArr, doubleValue, i, this.f25455c);
            if (m4243S >= 0) {
                return m4243S - i;
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
        if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            int i2 = Doubles.BYTES;
            int i3 = this.f25455c - 1;
            while (true) {
                i = this.f25454b;
                if (i3 >= i) {
                    if (this.f25453a[i3] == doubleValue) {
                        break;
                    }
                    i3--;
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 >= 0) {
                return i3 - i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        Preconditions.checkElementIndex(i, size());
        int i2 = this.f25454b + i;
        double[] dArr = this.f25453a;
        double d = dArr[i2];
        dArr[i2] = ((Double) Preconditions.checkNotNull((Double) obj)).doubleValue();
        return Double.valueOf(d);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f25455c - this.f25454b;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i2) {
        Preconditions.checkPositionIndexes(i, i2, size());
        if (i == i2) {
            return Collections.emptyList();
        }
        int i3 = this.f25454b;
        return new q50(this.f25453a, i + i3, i3 + i2);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        StringBuilder sb = new StringBuilder(size() * 12);
        sb.append('[');
        double[] dArr = this.f25453a;
        int i = this.f25454b;
        sb.append(dArr[i]);
        while (true) {
            i++;
            if (i < this.f25455c) {
                sb.append(", ");
                sb.append(dArr[i]);
            } else {
                sb.append(']');
                return sb.toString();
            }
        }
    }
}
