package com.google.android.exoplayer2.util;

import androidx.core.view.MotionEventCompat;
import com.google.common.base.Charsets;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class ParsableBitArray {

    /* renamed from: a */
    public int f12737a;

    /* renamed from: b */
    public int f12738b;

    /* renamed from: c */
    public int f12739c;
    public byte[] data;

    public ParsableBitArray() {
        this.data = Util.EMPTY_BYTE_ARRAY;
    }

    /* renamed from: a */
    public final void m3036a() {
        boolean z;
        int i;
        int i2 = this.f12737a;
        if (i2 >= 0 && (i2 < (i = this.f12739c) || (i2 == i && this.f12738b == 0))) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
    }

    public int bitsLeft() {
        return ((this.f12739c - this.f12737a) * 8) - this.f12738b;
    }

    public void byteAlign() {
        if (this.f12738b == 0) {
            return;
        }
        this.f12738b = 0;
        this.f12737a++;
        m3036a();
    }

    public int getBytePosition() {
        boolean z;
        if (this.f12738b == 0) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        return this.f12737a;
    }

    public int getPosition() {
        return (this.f12737a * 8) + this.f12738b;
    }

    public void putInt(int i, int i2) {
        if (i2 < 32) {
            i &= (1 << i2) - 1;
        }
        int min = Math.min(8 - this.f12738b, i2);
        int i3 = this.f12738b;
        int i4 = (8 - i3) - min;
        int i5 = (MotionEventCompat.ACTION_POINTER_INDEX_MASK >> i3) | ((1 << i4) - 1);
        byte[] bArr = this.data;
        int i6 = this.f12737a;
        byte b = (byte) (i5 & bArr[i6]);
        bArr[i6] = b;
        int i7 = i2 - min;
        bArr[i6] = (byte) (b | ((i >>> i7) << i4));
        int i8 = i6 + 1;
        while (i7 > 8) {
            this.data[i8] = (byte) (i >>> (i7 - 8));
            i7 -= 8;
            i8++;
        }
        int i9 = 8 - i7;
        byte[] bArr2 = this.data;
        byte b2 = (byte) (bArr2[i8] & ((1 << i9) - 1));
        bArr2[i8] = b2;
        bArr2[i8] = (byte) (((i & ((1 << i7) - 1)) << i9) | b2);
        skipBits(i2);
        m3036a();
    }

    public boolean readBit() {
        boolean z;
        if ((this.data[this.f12737a] & (128 >> this.f12738b)) != 0) {
            z = true;
        } else {
            z = false;
        }
        skipBit();
        return z;
    }

    public int readBits(int i) {
        int i2;
        if (i == 0) {
            return 0;
        }
        this.f12738b += i;
        int i3 = 0;
        while (true) {
            i2 = this.f12738b;
            if (i2 <= 8) {
                break;
            }
            int i4 = i2 - 8;
            this.f12738b = i4;
            byte[] bArr = this.data;
            int i5 = this.f12737a;
            this.f12737a = i5 + 1;
            i3 |= (bArr[i5] & 255) << i4;
        }
        byte[] bArr2 = this.data;
        int i6 = this.f12737a;
        int i7 = ((-1) >>> (32 - i)) & (i3 | ((bArr2[i6] & 255) >> (8 - i2)));
        if (i2 == 8) {
            this.f12738b = 0;
            this.f12737a = i6 + 1;
        }
        m3036a();
        return i7;
    }

    public long readBitsToLong(int i) {
        if (i <= 32) {
            return Util.toUnsignedLong(readBits(i));
        }
        return Util.toLong(readBits(i - 32), readBits(32));
    }

    public void readBytes(byte[] bArr, int i, int i2) {
        boolean z;
        if (this.f12738b == 0) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        System.arraycopy(this.data, this.f12737a, bArr, i, i2);
        this.f12737a += i2;
        m3036a();
    }

    public String readBytesAsString(int i) {
        return readBytesAsString(i, Charsets.UTF_8);
    }

    public void reset(byte[] bArr) {
        reset(bArr, bArr.length);
    }

    public void setPosition(int i) {
        int i2 = i / 8;
        this.f12737a = i2;
        this.f12738b = i - (i2 * 8);
        m3036a();
    }

    public void skipBit() {
        int i = this.f12738b + 1;
        this.f12738b = i;
        if (i == 8) {
            this.f12738b = 0;
            this.f12737a++;
        }
        m3036a();
    }

    public void skipBits(int i) {
        int i2 = i / 8;
        int i3 = this.f12737a + i2;
        this.f12737a = i3;
        int i4 = (i - (i2 * 8)) + this.f12738b;
        this.f12738b = i4;
        if (i4 > 7) {
            this.f12737a = i3 + 1;
            this.f12738b = i4 - 8;
        }
        m3036a();
    }

    public void skipBytes(int i) {
        boolean z;
        if (this.f12738b == 0) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        this.f12737a += i;
        m3036a();
    }

    public String readBytesAsString(int i, Charset charset) {
        byte[] bArr = new byte[i];
        readBytes(bArr, 0, i);
        return new String(bArr, charset);
    }

    public void reset(ParsableByteArray parsableByteArray) {
        reset(parsableByteArray.getData(), parsableByteArray.limit());
        setPosition(parsableByteArray.getPosition() * 8);
    }

    public ParsableBitArray(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public ParsableBitArray(byte[] bArr, int i) {
        this.data = bArr;
        this.f12739c = i;
    }

    public void reset(byte[] bArr, int i) {
        this.data = bArr;
        this.f12737a = 0;
        this.f12738b = 0;
        this.f12739c = i;
    }

    public void readBits(byte[] bArr, int i, int i2) {
        int i3 = (i2 >> 3) + i;
        while (i < i3) {
            byte[] bArr2 = this.data;
            int i4 = this.f12737a;
            int i5 = i4 + 1;
            this.f12737a = i5;
            byte b = bArr2[i4];
            int i6 = this.f12738b;
            byte b2 = (byte) (b << i6);
            bArr[i] = b2;
            bArr[i] = (byte) (((255 & bArr2[i5]) >> (8 - i6)) | b2);
            i++;
        }
        int i7 = i2 & 7;
        if (i7 == 0) {
            return;
        }
        byte b3 = (byte) (bArr[i3] & (255 >> i7));
        bArr[i3] = b3;
        int i8 = this.f12738b;
        if (i8 + i7 > 8) {
            byte[] bArr3 = this.data;
            int i9 = this.f12737a;
            this.f12737a = i9 + 1;
            bArr[i3] = (byte) (b3 | ((bArr3[i9] & 255) << i8));
            this.f12738b = i8 - 8;
        }
        int i10 = this.f12738b + i7;
        this.f12738b = i10;
        byte[] bArr4 = this.data;
        int i11 = this.f12737a;
        bArr[i3] = (byte) (((byte) (((255 & bArr4[i11]) >> (8 - i10)) << (8 - i7))) | bArr[i3]);
        if (i10 == 8) {
            this.f12738b = 0;
            this.f12737a = i11 + 1;
        }
        m3036a();
    }
}
