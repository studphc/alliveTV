package p000;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Floats;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class ze0 extends AbstractList implements RandomAccess, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final float[] f29334a;

    /* renamed from: b */
    public final int f29335b;

    /* renamed from: c */
    public final int f29336c;

    public ze0(float[] fArr, int i, int i2) {
        this.f29334a = fArr;
        this.f29335b = i;
        this.f29336c = i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (obj instanceof Float) {
            if (Floats.m4244a(this.f29334a, ((Float) obj).floatValue(), this.f29335b, this.f29336c) != -1) {
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
        if (obj instanceof ze0) {
            ze0 ze0Var = (ze0) obj;
            int size = size();
            if (ze0Var.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (this.f29334a[this.f29335b + i] != ze0Var.f29334a[ze0Var.f29335b + i]) {
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
        return Float.valueOf(this.f29334a[this.f29335b + i]);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = this.f29335b; i2 < this.f29336c; i2++) {
            i = (i * 31) + Floats.hashCode(this.f29334a[i2]);
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Float) {
            float floatValue = ((Float) obj).floatValue();
            float[] fArr = this.f29334a;
            int i = this.f29335b;
            int m4244a = Floats.m4244a(fArr, floatValue, i, this.f29336c);
            if (m4244a >= 0) {
                return m4244a - i;
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
        if (obj instanceof Float) {
            float floatValue = ((Float) obj).floatValue();
            int i2 = this.f29336c;
            while (true) {
                i2--;
                i = this.f29335b;
                if (i2 >= i) {
                    if (this.f29334a[i2] == floatValue) {
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
        int i2 = this.f29335b + i;
        float[] fArr = this.f29334a;
        float f = fArr[i2];
        fArr[i2] = ((Float) Preconditions.checkNotNull((Float) obj)).floatValue();
        return Float.valueOf(f);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f29336c - this.f29335b;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i2) {
        Preconditions.checkPositionIndexes(i, i2, size());
        if (i == i2) {
            return Collections.emptyList();
        }
        int i3 = this.f29335b;
        return new ze0(this.f29334a, i + i3, i3 + i2);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        StringBuilder sb = new StringBuilder(size() * 12);
        sb.append('[');
        float[] fArr = this.f29334a;
        int i = this.f29335b;
        sb.append(fArr[i]);
        while (true) {
            i++;
            if (i < this.f29336c) {
                sb.append(", ");
                sb.append(fArr[i]);
            } else {
                sb.append(']');
                return sb.toString();
            }
        }
    }
}
