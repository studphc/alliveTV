package p000;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Bytes;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: nj */
/* loaded from: classes2.dex */
public final class C1587nj extends AbstractList implements RandomAccess, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final byte[] f23376a;

    /* renamed from: b */
    public final int f23377b;

    /* renamed from: c */
    public final int f23378c;

    public C1587nj(byte[] bArr, int i, int i2) {
        this.f23376a = bArr;
        this.f23377b = i;
        this.f23378c = i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (obj instanceof Byte) {
            if (Bytes.m4241a(this.f23376a, ((Byte) obj).byteValue(), this.f23377b, this.f23378c) != -1) {
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
        if (obj instanceof C1587nj) {
            C1587nj c1587nj = (C1587nj) obj;
            int size = size();
            if (c1587nj.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (this.f23376a[this.f23377b + i] != c1587nj.f23376a[c1587nj.f23377b + i]) {
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
        return Byte.valueOf(this.f23376a[this.f23377b + i]);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = this.f23377b; i2 < this.f23378c; i2++) {
            i = (i * 31) + Bytes.hashCode(this.f23376a[i2]);
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Byte) {
            byte byteValue = ((Byte) obj).byteValue();
            byte[] bArr = this.f23376a;
            int i = this.f23377b;
            int m4241a = Bytes.m4241a(bArr, byteValue, i, this.f23378c);
            if (m4241a >= 0) {
                return m4241a - i;
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
        if (obj instanceof Byte) {
            byte byteValue = ((Byte) obj).byteValue();
            int i2 = this.f23378c;
            while (true) {
                i2--;
                i = this.f23377b;
                if (i2 >= i) {
                    if (this.f23376a[i2] == byteValue) {
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
        int i2 = this.f23377b + i;
        byte[] bArr = this.f23376a;
        byte b = bArr[i2];
        bArr[i2] = ((Byte) Preconditions.checkNotNull((Byte) obj)).byteValue();
        return Byte.valueOf(b);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f23378c - this.f23377b;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i2) {
        Preconditions.checkPositionIndexes(i, i2, size());
        if (i == i2) {
            return Collections.emptyList();
        }
        int i3 = this.f23377b;
        return new C1587nj(this.f23376a, i + i3, i3 + i2);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        StringBuilder sb = new StringBuilder(size() * 5);
        sb.append('[');
        byte[] bArr = this.f23376a;
        int i = this.f23377b;
        sb.append((int) bArr[i]);
        while (true) {
            i++;
            if (i < this.f23378c) {
                sb.append(", ");
                sb.append((int) bArr[i]);
            } else {
                sb.append(']');
                return sb.toString();
            }
        }
    }
}
