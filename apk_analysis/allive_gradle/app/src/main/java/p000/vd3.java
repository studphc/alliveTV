package p000;

import com.google.android.gms.internal.measurement.zzmj;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class vd3 extends mc3 implements RandomAccess {

    /* renamed from: d */
    public static final Object[] f27745d;

    /* renamed from: e */
    public static final vd3 f27746e;

    /* renamed from: b */
    public Object[] f27747b;

    /* renamed from: c */
    public int f27748c;

    static {
        Object[] objArr = new Object[0];
        f27745d = objArr;
        f27746e = new vd3(objArr, 0, false);
    }

    public vd3(Object[] objArr, int i, boolean z) {
        super(z);
        this.f27747b = objArr;
        this.f27748c = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2;
        m6130a();
        if (i >= 0 && i <= (i2 = this.f27748c)) {
            int i3 = i + 1;
            Object[] objArr = this.f27747b;
            int length = objArr.length;
            if (i2 < length) {
                System.arraycopy(objArr, i, objArr, i3, i2 - i);
            } else {
                Object[] objArr2 = new Object[Math.max(((length * 3) / 2) + 1, 10)];
                System.arraycopy(this.f27747b, 0, objArr2, 0, i);
                System.arraycopy(this.f27747b, i, objArr2, i3, this.f27748c - i);
                this.f27747b = objArr2;
            }
            this.f27747b[i] = obj;
            this.f27748c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(ye0.m8293m(i, "Index:", ", Size:", this.f27748c));
    }

    /* renamed from: b */
    public final void m7909b(int i) {
        if (i >= 0 && i < this.f27748c) {
        } else {
            throw new IndexOutOfBoundsException(ye0.m8293m(i, "Index:", ", Size:", this.f27748c));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        m7909b(i);
        return this.f27747b[i];
    }

    @Override // p000.mc3, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        m6130a();
        m7909b(i);
        Object[] objArr = this.f27747b;
        Object obj = objArr[i];
        if (i < this.f27748c - 1) {
            System.arraycopy(objArr, i + 1, objArr, i, (r2 - i) - 1);
        }
        this.f27748c--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        m6130a();
        m7909b(i);
        Object[] objArr = this.f27747b;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f27748c;
    }

    @Override // com.google.android.gms.internal.measurement.zzmj
    public final /* bridge */ /* synthetic */ zzmj zzd(int i) {
        Object[] copyOf;
        if (i >= this.f27748c) {
            if (i == 0) {
                copyOf = f27745d;
            } else {
                copyOf = Arrays.copyOf(this.f27747b, i);
            }
            return new vd3(copyOf, this.f27748c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        m6130a();
        int i = this.f27748c;
        int length = this.f27747b.length;
        if (i == length) {
            this.f27747b = Arrays.copyOf(this.f27747b, Math.max(((length * 3) / 2) + 1, 10));
        }
        Object[] objArr = this.f27747b;
        int i2 = this.f27748c;
        this.f27748c = i2 + 1;
        objArr[i2] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
