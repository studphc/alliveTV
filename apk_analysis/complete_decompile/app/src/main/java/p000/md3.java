package p000;

import com.google.android.gms.internal.measurement.zzmi;
import com.google.android.gms.internal.measurement.zzmk;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class md3 extends mc3 implements RandomAccess, zzmi, td3 {

    /* renamed from: d */
    public static final long[] f22901d;

    /* renamed from: e */
    public static final md3 f22902e;

    /* renamed from: b */
    public long[] f22903b;

    /* renamed from: c */
    public int f22904c;

    static {
        long[] jArr = new long[0];
        f22901d = jArr;
        f22902e = new md3(jArr, 0, false);
    }

    public md3(long[] jArr, int i, boolean z) {
        super(z);
        this.f22903b = jArr;
        this.f22904c = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2;
        long longValue = ((Long) obj).longValue();
        m6130a();
        if (i >= 0 && i <= (i2 = this.f22904c)) {
            int i3 = i + 1;
            long[] jArr = this.f22903b;
            int length = jArr.length;
            if (i2 < length) {
                System.arraycopy(jArr, i, jArr, i3, i2 - i);
            } else {
                long[] jArr2 = new long[Math.max(((length * 3) / 2) + 1, 10)];
                System.arraycopy(this.f22903b, 0, jArr2, 0, i);
                System.arraycopy(this.f22903b, i, jArr2, i3, this.f22904c - i);
                this.f22903b = jArr2;
            }
            this.f22903b[i] = longValue;
            this.f22904c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(ye0.m8293m(i, "Index:", ", Size:", this.f22904c));
    }

    @Override // p000.mc3, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        m6130a();
        Charset charset = zzmk.f13887a;
        collection.getClass();
        if (!(collection instanceof md3)) {
            return super.addAll(collection);
        }
        md3 md3Var = (md3) collection;
        int i = md3Var.f22904c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f22904c;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.f22903b;
            if (i3 > jArr.length) {
                this.f22903b = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(md3Var.f22903b, 0, this.f22903b, this.f22904c, md3Var.f22904c);
            this.f22904c = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    /* renamed from: b */
    public final void m6139b(long j) {
        m6130a();
        int i = this.f22904c;
        int length = this.f22903b.length;
        if (i == length) {
            long[] jArr = new long[Math.max(((length * 3) / 2) + 1, 10)];
            System.arraycopy(this.f22903b, 0, jArr, 0, this.f22904c);
            this.f22903b = jArr;
        }
        long[] jArr2 = this.f22903b;
        int i2 = this.f22904c;
        this.f22904c = i2 + 1;
        jArr2[i2] = j;
    }

    /* renamed from: c */
    public final void m6140c(int i) {
        int length = this.f22903b.length;
        if (i <= length) {
            return;
        }
        if (length != 0) {
            while (length < i) {
                length = Math.max(((length * 3) / 2) + 1, 10);
            }
            this.f22903b = Arrays.copyOf(this.f22903b, length);
            return;
        }
        this.f22903b = new long[Math.max(i, 10)];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (indexOf(obj) != -1) {
            return true;
        }
        return false;
    }

    /* renamed from: d */
    public final void m6141d(int i) {
        if (i >= 0 && i < this.f22904c) {
        } else {
            throw new IndexOutOfBoundsException(ye0.m8293m(i, "Index:", ", Size:", this.f22904c));
        }
    }

    @Override // p000.mc3, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof md3)) {
            return super.equals(obj);
        }
        md3 md3Var = (md3) obj;
        if (this.f22904c != md3Var.f22904c) {
            return false;
        }
        long[] jArr = md3Var.f22903b;
        for (int i = 0; i < this.f22904c; i++) {
            if (this.f22903b[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        m6141d(i);
        return Long.valueOf(this.f22903b[i]);
    }

    @Override // p000.mc3, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f22904c; i2++) {
            long j = this.f22903b[i2];
            Charset charset = zzmk.f13887a;
            i = (i * 31) + ((int) (j ^ (j >>> 32)));
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int i = this.f22904c;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f22903b[i2] == longValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // p000.mc3, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        m6130a();
        m6141d(i);
        long[] jArr = this.f22903b;
        long j = jArr[i];
        if (i < this.f22904c - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (r3 - i) - 1);
        }
        this.f22904c--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        m6130a();
        if (i2 >= i) {
            long[] jArr = this.f22903b;
            System.arraycopy(jArr, i2, jArr, i, this.f22904c - i2);
            this.f22904c -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        m6130a();
        m6141d(i);
        long[] jArr = this.f22903b;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f22904c;
    }

    @Override // com.google.android.gms.internal.measurement.zzmi
    public final long zza(int i) {
        m6141d(i);
        return this.f22903b[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzmj
    /* renamed from: zze, reason: merged with bridge method [inline-methods] */
    public final zzmi zzd(int i) {
        long[] copyOf;
        if (i >= this.f22904c) {
            if (i == 0) {
                copyOf = f22901d;
            } else {
                copyOf = Arrays.copyOf(this.f22903b, i);
            }
            return new md3(copyOf, this.f22904c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        m6139b(((Long) obj).longValue());
        return true;
    }
}
