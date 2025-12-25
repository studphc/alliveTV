package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.Arrays;
import p000.o63;
import p000.p63;

/* renamed from: com.google.common.collect.f2 */
/* loaded from: classes.dex */
public class C0869f2 {

    /* renamed from: a */
    public transient Object[] f14819a;

    /* renamed from: b */
    public transient int[] f14820b;

    /* renamed from: c */
    public transient int f14821c;

    /* renamed from: d */
    public transient int f14822d;

    /* renamed from: e */
    public transient int[] f14823e;

    /* renamed from: f */
    public transient long[] f14824f;

    /* renamed from: g */
    public transient float f14825g;

    /* renamed from: h */
    public transient int f14826h;

    public C0869f2() {
        mo4096h(3);
    }

    /* renamed from: a */
    public void mo4089a() {
        this.f14822d++;
        Arrays.fill(this.f14819a, 0, this.f14821c, (Object) null);
        Arrays.fill(this.f14820b, 0, this.f14821c, 0);
        Arrays.fill(this.f14823e, -1);
        Arrays.fill(this.f14824f, -1L);
        this.f14821c = 0;
    }

    /* renamed from: b */
    public final void m4090b(int i) {
        if (i > this.f14824f.length) {
            mo4104p(i);
        }
        if (i >= this.f14826h) {
            m4105q(Math.max(2, Integer.highestOneBit(i - 1) << 1));
        }
    }

    /* renamed from: c */
    public int mo4091c() {
        if (this.f14821c == 0) {
            return -1;
        }
        return 0;
    }

    /* renamed from: d */
    public final int m4092d(Object obj) {
        int m4095g = m4095g(obj);
        if (m4095g == -1) {
            return 0;
        }
        return this.f14820b[m4095g];
    }

    /* renamed from: e */
    public final Object m4093e(int i) {
        Preconditions.checkElementIndex(i, this.f14821c);
        return this.f14819a[i];
    }

    /* renamed from: f */
    public final int m4094f(int i) {
        Preconditions.checkElementIndex(i, this.f14821c);
        return this.f14820b[i];
    }

    /* renamed from: g */
    public final int m4095g(Object obj) {
        int m6454N = o63.m6454N(obj);
        int i = this.f14823e[(r1.length - 1) & m6454N];
        while (i != -1) {
            long j = this.f14824f[i];
            if (((int) (j >>> 32)) == m6454N && Objects.equal(obj, this.f14819a[i])) {
                return i;
            }
            i = (int) j;
        }
        return -1;
    }

    /* renamed from: h */
    public void mo4096h(int i) {
        boolean z;
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Initial capacity must be non-negative");
        Preconditions.checkArgument(true, "Illegal load factor");
        int m6465h = o63.m6465h(1.0f, i);
        int[] iArr = new int[m6465h];
        Arrays.fill(iArr, -1);
        this.f14823e = iArr;
        this.f14825g = 1.0f;
        this.f14819a = new Object[i];
        this.f14820b = new int[i];
        long[] jArr = new long[i];
        Arrays.fill(jArr, -1L);
        this.f14824f = jArr;
        this.f14826h = Math.max(1, (int) (m6465h * 1.0f));
    }

    /* renamed from: i */
    public void mo4097i(int i, int i2, int i3, Object obj) {
        this.f14824f[i] = (i3 << 32) | 4294967295L;
        this.f14819a[i] = obj;
        this.f14820b[i] = i2;
    }

    /* renamed from: j */
    public void mo4098j(int i) {
        int i2 = this.f14821c - 1;
        if (i < i2) {
            Object[] objArr = this.f14819a;
            objArr[i] = objArr[i2];
            int[] iArr = this.f14820b;
            iArr[i] = iArr[i2];
            objArr[i2] = null;
            iArr[i2] = 0;
            long[] jArr = this.f14824f;
            long j = jArr[i2];
            jArr[i] = j;
            jArr[i2] = -1;
            int[] iArr2 = this.f14823e;
            int length = ((int) (j >>> 32)) & (iArr2.length - 1);
            int i3 = iArr2[length];
            if (i3 == i2) {
                iArr2[length] = i;
                return;
            }
            while (true) {
                long[] jArr2 = this.f14824f;
                long j2 = jArr2[i3];
                int i4 = (int) j2;
                if (i4 == i2) {
                    jArr2[i3] = (j2 & (-4294967296L)) | (4294967295L & i);
                    return;
                }
                i3 = i4;
            }
        } else {
            this.f14819a[i] = null;
            this.f14820b[i] = 0;
            this.f14824f[i] = -1;
        }
    }

    /* renamed from: k */
    public int mo4099k(int i) {
        int i2 = i + 1;
        if (i2 >= this.f14821c) {
            return -1;
        }
        return i2;
    }

    /* renamed from: l */
    public int mo4100l(int i, int i2) {
        return i - 1;
    }

    /* renamed from: m */
    public final int m4101m(int i, Object obj) {
        p63.m6873q(i, "count");
        long[] jArr = this.f14824f;
        Object[] objArr = this.f14819a;
        int[] iArr = this.f14820b;
        int m6454N = o63.m6454N(obj);
        int[] iArr2 = this.f14823e;
        int length = (iArr2.length - 1) & m6454N;
        int i2 = this.f14821c;
        int i3 = iArr2[length];
        if (i3 == -1) {
            iArr2[length] = i2;
        } else {
            while (true) {
                long j = jArr[i3];
                if (((int) (j >>> 32)) == m6454N && Objects.equal(obj, objArr[i3])) {
                    int i4 = iArr[i3];
                    iArr[i3] = i;
                    return i4;
                }
                int i5 = (int) j;
                if (i5 == -1) {
                    jArr[i3] = ((-4294967296L) & j) | (4294967295L & i2);
                    break;
                }
                i3 = i5;
            }
        }
        int i6 = Integer.MAX_VALUE;
        if (i2 != Integer.MAX_VALUE) {
            int i7 = i2 + 1;
            int length2 = this.f14824f.length;
            if (i7 > length2) {
                int max = Math.max(1, length2 >>> 1) + length2;
                if (max >= 0) {
                    i6 = max;
                }
                if (i6 != length2) {
                    mo4104p(i6);
                }
            }
            mo4097i(i2, i, m6454N, obj);
            this.f14821c = i7;
            if (i2 >= this.f14826h) {
                m4105q(this.f14823e.length * 2);
            }
            this.f14822d++;
            return 0;
        }
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
    }

    /* renamed from: n */
    public final int m4102n(Object obj, int i) {
        int length = (r0.length - 1) & i;
        int i2 = this.f14823e[length];
        if (i2 == -1) {
            return 0;
        }
        int i3 = -1;
        while (true) {
            if (((int) (this.f14824f[i2] >>> 32)) == i && Objects.equal(obj, this.f14819a[i2])) {
                int i4 = this.f14820b[i2];
                if (i3 == -1) {
                    this.f14823e[length] = (int) this.f14824f[i2];
                } else {
                    long[] jArr = this.f14824f;
                    jArr[i3] = (jArr[i3] & (-4294967296L)) | (4294967295L & ((int) jArr[i2]));
                }
                mo4098j(i2);
                this.f14821c--;
                this.f14822d++;
                return i4;
            }
            int i5 = (int) this.f14824f[i2];
            if (i5 == -1) {
                return 0;
            }
            i3 = i2;
            i2 = i5;
        }
    }

    /* renamed from: o */
    public final int m4103o(int i) {
        return m4102n(this.f14819a[i], (int) (this.f14824f[i] >>> 32));
    }

    /* renamed from: p */
    public void mo4104p(int i) {
        this.f14819a = Arrays.copyOf(this.f14819a, i);
        this.f14820b = Arrays.copyOf(this.f14820b, i);
        long[] jArr = this.f14824f;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i);
        if (i > length) {
            Arrays.fill(copyOf, length, i, -1L);
        }
        this.f14824f = copyOf;
    }

    /* renamed from: q */
    public final void m4105q(int i) {
        if (this.f14823e.length >= 1073741824) {
            this.f14826h = Integer.MAX_VALUE;
            return;
        }
        int i2 = ((int) (i * this.f14825g)) + 1;
        int[] iArr = new int[i];
        Arrays.fill(iArr, -1);
        long[] jArr = this.f14824f;
        int i3 = i - 1;
        for (int i4 = 0; i4 < this.f14821c; i4++) {
            int i5 = (int) (jArr[i4] >>> 32);
            int i6 = i5 & i3;
            int i7 = iArr[i6];
            iArr[i6] = i4;
            jArr[i4] = (i5 << 32) | (i7 & 4294967295L);
        }
        this.f14826h = i2;
        this.f14823e = iArr;
    }

    public C0869f2(C0869f2 c0869f2) {
        mo4096h(c0869f2.f14821c);
        int mo4091c = c0869f2.mo4091c();
        while (mo4091c != -1) {
            m4101m(c0869f2.m4094f(mo4091c), c0869f2.m4093e(mo4091c));
            mo4091c = c0869f2.mo4099k(mo4091c);
        }
    }

    public C0869f2(int i, int i2) {
        mo4096h(i);
    }
}
