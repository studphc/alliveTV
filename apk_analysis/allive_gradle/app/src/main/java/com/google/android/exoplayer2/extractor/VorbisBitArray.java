package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.util.Assertions;

/* loaded from: classes.dex */
public final class VorbisBitArray {

    /* renamed from: a */
    public final byte[] f10106a;

    /* renamed from: b */
    public final int f10107b;

    /* renamed from: c */
    public int f10108c;

    /* renamed from: d */
    public int f10109d;

    public VorbisBitArray(byte[] bArr) {
        this.f10106a = bArr;
        this.f10107b = bArr.length;
    }

    public int bitsLeft() {
        return ((this.f10107b - this.f10108c) * 8) - this.f10109d;
    }

    public int getPosition() {
        return (this.f10108c * 8) + this.f10109d;
    }

    public boolean readBit() {
        boolean z;
        if ((((this.f10106a[this.f10108c] & 255) >> this.f10109d) & 1) == 1) {
            z = true;
        } else {
            z = false;
        }
        skipBits(1);
        return z;
    }

    public int readBits(int i) {
        int i2 = this.f10108c;
        int min = Math.min(i, 8 - this.f10109d);
        int i3 = i2 + 1;
        byte[] bArr = this.f10106a;
        int i4 = ((bArr[i2] & 255) >> this.f10109d) & (255 >> (8 - min));
        while (min < i) {
            i4 |= (bArr[i3] & 255) << min;
            min += 8;
            i3++;
        }
        int i5 = i4 & ((-1) >>> (32 - i));
        skipBits(i);
        return i5;
    }

    public void reset() {
        this.f10108c = 0;
        this.f10109d = 0;
    }

    public void setPosition(int i) {
        boolean z;
        int i2;
        int i3 = i / 8;
        this.f10108c = i3;
        int i4 = i - (i3 * 8);
        this.f10109d = i4;
        if (i3 >= 0 && (i3 < (i2 = this.f10107b) || (i3 == i2 && i4 == 0))) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
    }

    public void skipBits(int i) {
        int i2;
        int i3 = i / 8;
        int i4 = this.f10108c + i3;
        this.f10108c = i4;
        int i5 = (i - (i3 * 8)) + this.f10109d;
        this.f10109d = i5;
        boolean z = true;
        if (i5 > 7) {
            this.f10108c = i4 + 1;
            this.f10109d = i5 - 8;
        }
        int i6 = this.f10108c;
        if (i6 < 0 || (i6 >= (i2 = this.f10107b) && (i6 != i2 || this.f10109d != 0))) {
            z = false;
        }
        Assertions.checkState(z);
    }
}
