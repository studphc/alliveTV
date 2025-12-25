package p000;

import com.google.android.gms.internal.measurement.zzmh;
import com.google.android.gms.internal.measurement.zzmk;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class hd3 extends mc3 implements RandomAccess, zzmh, td3 {

    /* renamed from: d */
    public static final int[] f18032d;

    /* renamed from: e */
    public static final hd3 f18033e;

    /* renamed from: b */
    public int[] f18034b;

    /* renamed from: c */
    public int f18035c;

    static {
        int[] iArr = new int[0];
        f18032d = iArr;
        f18033e = new hd3(0, false, iArr);
    }

    public hd3(int i, boolean z, int[] iArr) {
        super(z);
        this.f18034b = iArr;
        this.f18035c = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2;
        int intValue = ((Integer) obj).intValue();
        m6130a();
        if (i >= 0 && i <= (i2 = this.f18035c)) {
            int i3 = i + 1;
            int[] iArr = this.f18034b;
            int length = iArr.length;
            if (i2 < length) {
                System.arraycopy(iArr, i, iArr, i3, i2 - i);
            } else {
                int[] iArr2 = new int[Math.max(((length * 3) / 2) + 1, 10)];
                System.arraycopy(this.f18034b, 0, iArr2, 0, i);
                System.arraycopy(this.f18034b, i, iArr2, i3, this.f18035c - i);
                this.f18034b = iArr2;
            }
            this.f18034b[i] = intValue;
            this.f18035c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(ye0.m8293m(i, "Index:", ", Size:", this.f18035c));
    }

    @Override // p000.mc3, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        m6130a();
        Charset charset = zzmk.f13887a;
        collection.getClass();
        if (!(collection instanceof hd3)) {
            return super.addAll(collection);
        }
        hd3 hd3Var = (hd3) collection;
        int i = hd3Var.f18035c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f18035c;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.f18034b;
            if (i3 > iArr.length) {
                this.f18034b = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(hd3Var.f18034b, 0, this.f18034b, this.f18035c, hd3Var.f18035c);
            this.f18035c = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    /* renamed from: b */
    public final int m5052b(int i) {
        m5055e(i);
        return this.f18034b[i];
    }

    /* renamed from: c */
    public final void m5053c(int i) {
        m6130a();
        int i2 = this.f18035c;
        int length = this.f18034b.length;
        if (i2 == length) {
            int[] iArr = new int[Math.max(((length * 3) / 2) + 1, 10)];
            System.arraycopy(this.f18034b, 0, iArr, 0, this.f18035c);
            this.f18034b = iArr;
        }
        int[] iArr2 = this.f18034b;
        int i3 = this.f18035c;
        this.f18035c = i3 + 1;
        iArr2[i3] = i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (indexOf(obj) != -1) {
            return true;
        }
        return false;
    }

    /* renamed from: d */
    public final void m5054d(int i) {
        int length = this.f18034b.length;
        if (i <= length) {
            return;
        }
        if (length != 0) {
            while (length < i) {
                length = Math.max(((length * 3) / 2) + 1, 10);
            }
            this.f18034b = Arrays.copyOf(this.f18034b, length);
            return;
        }
        this.f18034b = new int[Math.max(i, 10)];
    }

    /* renamed from: e */
    public final void m5055e(int i) {
        if (i >= 0 && i < this.f18035c) {
        } else {
            throw new IndexOutOfBoundsException(ye0.m8293m(i, "Index:", ", Size:", this.f18035c));
        }
    }

    @Override // p000.mc3, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof hd3)) {
            return super.equals(obj);
        }
        hd3 hd3Var = (hd3) obj;
        if (this.f18035c != hd3Var.f18035c) {
            return false;
        }
        int[] iArr = hd3Var.f18034b;
        for (int i = 0; i < this.f18035c; i++) {
            if (this.f18034b[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        m5055e(i);
        return Integer.valueOf(this.f18034b[i]);
    }

    @Override // p000.mc3, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f18035c; i2++) {
            i = (i * 31) + this.f18034b[i2];
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int i = this.f18035c;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f18034b[i2] == intValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // p000.mc3, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        m6130a();
        m5055e(i);
        int[] iArr = this.f18034b;
        int i2 = iArr[i];
        if (i < this.f18035c - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (r2 - i) - 1);
        }
        this.f18035c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i2);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        m6130a();
        if (i2 >= i) {
            int[] iArr = this.f18034b;
            System.arraycopy(iArr, i2, iArr, i, this.f18035c - i2);
            this.f18035c -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        m6130a();
        m5055e(i);
        int[] iArr = this.f18034b;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f18035c;
    }

    @Override // com.google.android.gms.internal.measurement.zzmj
    /* renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final zzmh zzd(int i) {
        int[] copyOf;
        if (i >= this.f18035c) {
            if (i == 0) {
                copyOf = f18032d;
            } else {
                copyOf = Arrays.copyOf(this.f18034b, i);
            }
            return new hd3(this.f18035c, true, copyOf);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        m5053c(((Integer) obj).intValue());
        return true;
    }
}
