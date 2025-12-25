package com.google.android.exoplayer2.util;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class TimedValueQueue<V> {

    /* renamed from: a */
    public long[] f12767a;

    /* renamed from: b */
    public Object[] f12768b;

    /* renamed from: c */
    public int f12769c;

    /* renamed from: d */
    public int f12770d;

    public TimedValueQueue() {
        this(10);
    }

    /* renamed from: a */
    public final void m3043a() {
        int length = this.f12768b.length;
        if (this.f12770d < length) {
            return;
        }
        int i = length * 2;
        long[] jArr = new long[i];
        Object[] objArr = new Object[i];
        int i2 = this.f12769c;
        int i3 = length - i2;
        System.arraycopy(this.f12767a, i2, jArr, 0, i3);
        System.arraycopy(this.f12768b, this.f12769c, objArr, 0, i3);
        int i4 = this.f12769c;
        if (i4 > 0) {
            System.arraycopy(this.f12767a, 0, jArr, i3, i4);
            System.arraycopy(this.f12768b, 0, objArr, i3, this.f12769c);
        }
        this.f12767a = jArr;
        this.f12768b = objArr;
        this.f12769c = 0;
    }

    public synchronized void add(long j, V v) {
        if (this.f12770d > 0) {
            if (j <= this.f12767a[((this.f12769c + r0) - 1) % this.f12768b.length]) {
                clear();
            }
        }
        m3043a();
        int i = this.f12769c;
        int i2 = this.f12770d;
        Object[] objArr = this.f12768b;
        int length = (i + i2) % objArr.length;
        this.f12767a[length] = j;
        objArr[length] = v;
        this.f12770d = i2 + 1;
    }

    /* renamed from: b */
    public final Object m3044b(long j, boolean z) {
        Object obj = null;
        long j2 = Long.MAX_VALUE;
        while (this.f12770d > 0) {
            long j3 = j - this.f12767a[this.f12769c];
            if (j3 < 0 && (z || (-j3) >= j2)) {
                break;
            }
            obj = m3045c();
            j2 = j3;
        }
        return obj;
    }

    /* renamed from: c */
    public final Object m3045c() {
        boolean z;
        if (this.f12770d > 0) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        Object[] objArr = this.f12768b;
        int i = this.f12769c;
        Object obj = objArr[i];
        objArr[i] = null;
        this.f12769c = (i + 1) % objArr.length;
        this.f12770d--;
        return obj;
    }

    public synchronized void clear() {
        this.f12769c = 0;
        this.f12770d = 0;
        Arrays.fill(this.f12768b, (Object) null);
    }

    @Nullable
    public synchronized V poll(long j) {
        return (V) m3044b(j, false);
    }

    @Nullable
    public synchronized V pollFirst() {
        V v;
        if (this.f12770d == 0) {
            v = null;
        } else {
            v = (V) m3045c();
        }
        return v;
    }

    @Nullable
    public synchronized V pollFloor(long j) {
        return (V) m3044b(j, true);
    }

    public synchronized int size() {
        return this.f12770d;
    }

    public TimedValueQueue(int i) {
        this.f12767a = new long[i];
        this.f12768b = new Object[i];
    }
}
