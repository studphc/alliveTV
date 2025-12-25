package com.google.android.exoplayer2.util;

/* loaded from: classes.dex */
public final class ParsableNalUnitBitArray {

    /* renamed from: a */
    public byte[] f12743a;

    /* renamed from: b */
    public int f12744b;

    /* renamed from: c */
    public int f12745c;

    /* renamed from: d */
    public int f12746d;

    public ParsableNalUnitBitArray(byte[] bArr, int i, int i2) {
        reset(bArr, i, i2);
    }

    /* renamed from: a */
    public final void m3037a() {
        boolean z;
        int i;
        int i2 = this.f12745c;
        if (i2 >= 0 && (i2 < (i = this.f12744b) || (i2 == i && this.f12746d == 0))) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
    }

    /* renamed from: b */
    public final boolean m3038b(int i) {
        if (2 <= i && i < this.f12744b) {
            byte[] bArr = this.f12743a;
            if (bArr[i] == 3 && bArr[i - 2] == 0 && bArr[i - 1] == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean canReadBits(int i) {
        int i2 = this.f12745c;
        int i3 = i / 8;
        int i4 = i2 + i3;
        int i5 = (this.f12746d + i) - (i3 * 8);
        if (i5 > 7) {
            i4++;
            i5 -= 8;
        }
        while (true) {
            i2++;
            if (i2 > i4 || i4 >= this.f12744b) {
                break;
            }
            if (m3038b(i2)) {
                i4++;
                i2 += 2;
            }
        }
        int i6 = this.f12744b;
        if (i4 < i6) {
            return true;
        }
        if (i4 == i6 && i5 == 0) {
            return true;
        }
        return false;
    }

    public boolean canReadExpGolombCodedNum() {
        boolean z;
        int i = this.f12745c;
        int i2 = this.f12746d;
        int i3 = 0;
        while (this.f12745c < this.f12744b && !readBit()) {
            i3++;
        }
        if (this.f12745c == this.f12744b) {
            z = true;
        } else {
            z = false;
        }
        this.f12745c = i;
        this.f12746d = i2;
        if (z || !canReadBits((i3 * 2) + 1)) {
            return false;
        }
        return true;
    }

    public boolean readBit() {
        boolean z;
        if ((this.f12743a[this.f12745c] & (128 >> this.f12746d)) != 0) {
            z = true;
        } else {
            z = false;
        }
        skipBit();
        return z;
    }

    public int readBits(int i) {
        int i2;
        int i3;
        this.f12746d += i;
        int i4 = 0;
        while (true) {
            i2 = this.f12746d;
            i3 = 2;
            if (i2 <= 8) {
                break;
            }
            int i5 = i2 - 8;
            this.f12746d = i5;
            byte[] bArr = this.f12743a;
            int i6 = this.f12745c;
            i4 |= (bArr[i6] & 255) << i5;
            if (!m3038b(i6 + 1)) {
                i3 = 1;
            }
            this.f12745c = i6 + i3;
        }
        byte[] bArr2 = this.f12743a;
        int i7 = this.f12745c;
        int i8 = ((-1) >>> (32 - i)) & (i4 | ((bArr2[i7] & 255) >> (8 - i2)));
        if (i2 == 8) {
            this.f12746d = 0;
            if (!m3038b(i7 + 1)) {
                i3 = 1;
            }
            this.f12745c = i7 + i3;
        }
        m3037a();
        return i8;
    }

    public int readSignedExpGolombCodedInt() {
        int i;
        int i2 = 0;
        int i3 = 0;
        while (!readBit()) {
            i3++;
        }
        int i4 = (1 << i3) - 1;
        if (i3 > 0) {
            i2 = readBits(i3);
        }
        int i5 = i4 + i2;
        if (i5 % 2 == 0) {
            i = -1;
        } else {
            i = 1;
        }
        return ((i5 + 1) / 2) * i;
    }

    public int readUnsignedExpGolombCodedInt() {
        int i = 0;
        int i2 = 0;
        while (!readBit()) {
            i2++;
        }
        int i3 = (1 << i2) - 1;
        if (i2 > 0) {
            i = readBits(i2);
        }
        return i3 + i;
    }

    public void reset(byte[] bArr, int i, int i2) {
        this.f12743a = bArr;
        this.f12745c = i;
        this.f12744b = i2;
        this.f12746d = 0;
        m3037a();
    }

    public void skipBit() {
        int i = 1;
        int i2 = this.f12746d + 1;
        this.f12746d = i2;
        if (i2 == 8) {
            this.f12746d = 0;
            int i3 = this.f12745c;
            if (m3038b(i3 + 1)) {
                i = 2;
            }
            this.f12745c = i3 + i;
        }
        m3037a();
    }

    public void skipBits(int i) {
        int i2 = this.f12745c;
        int i3 = i / 8;
        int i4 = i2 + i3;
        this.f12745c = i4;
        int i5 = (i - (i3 * 8)) + this.f12746d;
        this.f12746d = i5;
        if (i5 > 7) {
            this.f12745c = i4 + 1;
            this.f12746d = i5 - 8;
        }
        while (true) {
            i2++;
            if (i2 <= this.f12745c) {
                if (m3038b(i2)) {
                    this.f12745c++;
                    i2 += 2;
                }
            } else {
                m3037a();
                return;
            }
        }
    }
}
