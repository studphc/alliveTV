package com.google.android.exoplayer2.util;

import java.util.Arrays;
import p000.ye0;

/* loaded from: classes.dex */
public final class LongArray {

    /* renamed from: a */
    public int f12726a;

    /* renamed from: b */
    public long[] f12727b;

    public LongArray() {
        this(32);
    }

    public void add(long j) {
        int i = this.f12726a;
        long[] jArr = this.f12727b;
        if (i == jArr.length) {
            this.f12727b = Arrays.copyOf(jArr, i * 2);
        }
        long[] jArr2 = this.f12727b;
        int i2 = this.f12726a;
        this.f12726a = i2 + 1;
        jArr2[i2] = j;
    }

    public long get(int i) {
        if (i >= 0 && i < this.f12726a) {
            return this.f12727b[i];
        }
        StringBuilder m8299s = ye0.m8299s(i, "Invalid index ", ", size is ");
        m8299s.append(this.f12726a);
        throw new IndexOutOfBoundsException(m8299s.toString());
    }

    public int size() {
        return this.f12726a;
    }

    public long[] toArray() {
        return Arrays.copyOf(this.f12727b, this.f12726a);
    }

    public LongArray(int i) {
        this.f12727b = new long[i];
    }
}
