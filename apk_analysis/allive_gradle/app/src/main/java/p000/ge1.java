package p000;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class ge1 extends AbstractList implements RandomAccess, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final long[] f17661a;

    /* renamed from: b */
    public final int f17662b;

    /* renamed from: c */
    public final int f17663c;

    public ge1(long[] jArr, int i, int i2) {
        this.f17661a = jArr;
        this.f17662b = i;
        this.f17663c = i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (obj instanceof Long) {
            if (Longs.m4274a(this.f17661a, ((Long) obj).longValue(), this.f17662b, this.f17663c) != -1) {
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
        if (obj instanceof ge1) {
            ge1 ge1Var = (ge1) obj;
            int size = size();
            if (ge1Var.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (this.f17661a[this.f17662b + i] != ge1Var.f17661a[ge1Var.f17662b + i]) {
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
        return Long.valueOf(this.f17661a[this.f17662b + i]);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = this.f17662b; i2 < this.f17663c; i2++) {
            i = (i * 31) + Longs.hashCode(this.f17661a[i2]);
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Long) {
            long longValue = ((Long) obj).longValue();
            long[] jArr = this.f17661a;
            int i = this.f17662b;
            int m4274a = Longs.m4274a(jArr, longValue, i, this.f17663c);
            if (m4274a >= 0) {
                return m4274a - i;
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
        if (obj instanceof Long) {
            long longValue = ((Long) obj).longValue();
            int i2 = this.f17663c;
            while (true) {
                i2--;
                i = this.f17662b;
                if (i2 >= i) {
                    if (this.f17661a[i2] == longValue) {
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
        int i2 = this.f17662b + i;
        long[] jArr = this.f17661a;
        long j = jArr[i2];
        jArr[i2] = ((Long) Preconditions.checkNotNull((Long) obj)).longValue();
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f17663c - this.f17662b;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i2) {
        Preconditions.checkPositionIndexes(i, i2, size());
        if (i == i2) {
            return Collections.emptyList();
        }
        int i3 = this.f17662b;
        return new ge1(this.f17661a, i + i3, i3 + i2);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        StringBuilder sb = new StringBuilder(size() * 10);
        sb.append('[');
        long[] jArr = this.f17661a;
        int i = this.f17662b;
        sb.append(jArr[i]);
        while (true) {
            i++;
            if (i < this.f17663c) {
                sb.append(", ");
                sb.append(jArr[i]);
            } else {
                sb.append(']');
                return sb.toString();
            }
        }
    }
}
