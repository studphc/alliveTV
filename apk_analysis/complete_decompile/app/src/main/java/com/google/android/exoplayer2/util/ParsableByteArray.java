package com.google.android.exoplayer2.util;

import androidx.annotation.Nullable;
import com.google.common.base.Charsets;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import okio.Utf8;
import p000.ye0;

/* loaded from: classes.dex */
public final class ParsableByteArray {

    /* renamed from: a */
    public byte[] f12740a;

    /* renamed from: b */
    public int f12741b;

    /* renamed from: c */
    public int f12742c;

    public ParsableByteArray() {
        this.f12740a = Util.EMPTY_BYTE_ARRAY;
    }

    public int bytesLeft() {
        return this.f12742c - this.f12741b;
    }

    public int capacity() {
        return this.f12740a.length;
    }

    public void ensureCapacity(int i) {
        if (i > capacity()) {
            this.f12740a = Arrays.copyOf(this.f12740a, i);
        }
    }

    public byte[] getData() {
        return this.f12740a;
    }

    public int getPosition() {
        return this.f12741b;
    }

    public int limit() {
        return this.f12742c;
    }

    public char peekChar() {
        byte[] bArr = this.f12740a;
        int i = this.f12741b;
        return (char) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    public int peekUnsignedByte() {
        return this.f12740a[this.f12741b] & 255;
    }

    public void readBytes(ParsableBitArray parsableBitArray, int i) {
        readBytes(parsableBitArray.data, 0, i);
        parsableBitArray.setPosition(0);
    }

    @Nullable
    public String readDelimiterTerminatedString(char c) {
        if (bytesLeft() == 0) {
            return null;
        }
        int i = this.f12741b;
        while (i < this.f12742c && this.f12740a[i] != c) {
            i++;
        }
        byte[] bArr = this.f12740a;
        int i2 = this.f12741b;
        String fromUtf8Bytes = Util.fromUtf8Bytes(bArr, i2, i - i2);
        this.f12741b = i;
        if (i < this.f12742c) {
            this.f12741b = i + 1;
        }
        return fromUtf8Bytes;
    }

    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    public float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    public int readInt() {
        byte[] bArr = this.f12740a;
        int i = this.f12741b;
        int i2 = i + 1;
        this.f12741b = i2;
        int i3 = (bArr[i] & 255) << 24;
        int i4 = i + 2;
        this.f12741b = i4;
        int i5 = ((bArr[i2] & 255) << 16) | i3;
        int i6 = i + 3;
        this.f12741b = i6;
        int i7 = i5 | ((bArr[i4] & 255) << 8);
        this.f12741b = i + 4;
        return (bArr[i6] & 255) | i7;
    }

    public int readInt24() {
        byte[] bArr = this.f12740a;
        int i = this.f12741b;
        int i2 = i + 1;
        this.f12741b = i2;
        int i3 = ((bArr[i] & 255) << 24) >> 8;
        int i4 = i + 2;
        this.f12741b = i4;
        int i5 = ((bArr[i2] & 255) << 8) | i3;
        this.f12741b = i + 3;
        return (bArr[i4] & 255) | i5;
    }

    @Nullable
    public String readLine() {
        if (bytesLeft() == 0) {
            return null;
        }
        int i = this.f12741b;
        while (i < this.f12742c && !Util.isLinebreak(this.f12740a[i])) {
            i++;
        }
        int i2 = this.f12741b;
        if (i - i2 >= 3) {
            byte[] bArr = this.f12740a;
            if (bArr[i2] == -17 && bArr[i2 + 1] == -69 && bArr[i2 + 2] == -65) {
                this.f12741b = i2 + 3;
            }
        }
        byte[] bArr2 = this.f12740a;
        int i3 = this.f12741b;
        String fromUtf8Bytes = Util.fromUtf8Bytes(bArr2, i3, i - i3);
        this.f12741b = i;
        int i4 = this.f12742c;
        if (i == i4) {
            return fromUtf8Bytes;
        }
        byte[] bArr3 = this.f12740a;
        if (bArr3[i] == 13) {
            int i5 = i + 1;
            this.f12741b = i5;
            if (i5 == i4) {
                return fromUtf8Bytes;
            }
        }
        int i6 = this.f12741b;
        if (bArr3[i6] == 10) {
            this.f12741b = i6 + 1;
        }
        return fromUtf8Bytes;
    }

    public int readLittleEndianInt() {
        byte[] bArr = this.f12740a;
        int i = this.f12741b;
        int i2 = i + 1;
        this.f12741b = i2;
        int i3 = bArr[i] & 255;
        int i4 = i + 2;
        this.f12741b = i4;
        int i5 = ((bArr[i2] & 255) << 8) | i3;
        int i6 = i + 3;
        this.f12741b = i6;
        int i7 = i5 | ((bArr[i4] & 255) << 16);
        this.f12741b = i + 4;
        return ((bArr[i6] & 255) << 24) | i7;
    }

    public int readLittleEndianInt24() {
        byte[] bArr = this.f12740a;
        int i = this.f12741b;
        int i2 = i + 1;
        this.f12741b = i2;
        int i3 = bArr[i] & 255;
        int i4 = i + 2;
        this.f12741b = i4;
        int i5 = ((bArr[i2] & 255) << 8) | i3;
        this.f12741b = i + 3;
        return ((bArr[i4] & 255) << 16) | i5;
    }

    public long readLittleEndianLong() {
        byte[] bArr = this.f12740a;
        int i = this.f12741b;
        this.f12741b = i + 1;
        this.f12741b = i + 2;
        this.f12741b = i + 3;
        long j = (bArr[i] & 255) | ((bArr[r2] & 255) << 8) | ((bArr[r7] & 255) << 16);
        this.f12741b = i + 4;
        long j2 = j | ((bArr[r8] & 255) << 24);
        this.f12741b = i + 5;
        long j3 = j2 | ((bArr[r7] & 255) << 32);
        this.f12741b = i + 6;
        long j4 = j3 | ((bArr[r8] & 255) << 40);
        this.f12741b = i + 7;
        long j5 = j4 | ((bArr[r7] & 255) << 48);
        this.f12741b = i + 8;
        return ((bArr[r8] & 255) << 56) | j5;
    }

    public short readLittleEndianShort() {
        byte[] bArr = this.f12740a;
        int i = this.f12741b;
        int i2 = i + 1;
        this.f12741b = i2;
        int i3 = bArr[i] & 255;
        this.f12741b = i + 2;
        return (short) (((bArr[i2] & 255) << 8) | i3);
    }

    public long readLittleEndianUnsignedInt() {
        byte[] bArr = this.f12740a;
        int i = this.f12741b;
        this.f12741b = i + 1;
        this.f12741b = i + 2;
        this.f12741b = i + 3;
        long j = (bArr[i] & 255) | ((bArr[r2] & 255) << 8) | ((bArr[r7] & 255) << 16);
        this.f12741b = i + 4;
        return ((bArr[r4] & 255) << 24) | j;
    }

    public int readLittleEndianUnsignedInt24() {
        byte[] bArr = this.f12740a;
        int i = this.f12741b;
        int i2 = i + 1;
        this.f12741b = i2;
        int i3 = bArr[i] & 255;
        int i4 = i + 2;
        this.f12741b = i4;
        int i5 = ((bArr[i2] & 255) << 8) | i3;
        this.f12741b = i + 3;
        return ((bArr[i4] & 255) << 16) | i5;
    }

    public int readLittleEndianUnsignedIntToInt() {
        int readLittleEndianInt = readLittleEndianInt();
        if (readLittleEndianInt >= 0) {
            return readLittleEndianInt;
        }
        throw new IllegalStateException(ye0.m8291k(readLittleEndianInt, "Top bit not zero: "));
    }

    public int readLittleEndianUnsignedShort() {
        byte[] bArr = this.f12740a;
        int i = this.f12741b;
        int i2 = i + 1;
        this.f12741b = i2;
        int i3 = bArr[i] & 255;
        this.f12741b = i + 2;
        return ((bArr[i2] & 255) << 8) | i3;
    }

    public long readLong() {
        byte[] bArr = this.f12740a;
        int i = this.f12741b;
        this.f12741b = i + 1;
        this.f12741b = i + 2;
        this.f12741b = i + 3;
        long j = ((bArr[i] & 255) << 56) | ((bArr[r2] & 255) << 48) | ((bArr[r7] & 255) << 40);
        this.f12741b = i + 4;
        long j2 = j | ((bArr[r4] & 255) << 32);
        this.f12741b = i + 5;
        long j3 = j2 | ((bArr[r7] & 255) << 24);
        this.f12741b = i + 6;
        long j4 = j3 | ((bArr[r4] & 255) << 16);
        this.f12741b = i + 7;
        long j5 = j4 | ((bArr[r7] & 255) << 8);
        this.f12741b = i + 8;
        return (bArr[r4] & 255) | j5;
    }

    public String readNullTerminatedString(int i) {
        if (i == 0) {
            return "";
        }
        int i2 = this.f12741b;
        int i3 = (i2 + i) - 1;
        String fromUtf8Bytes = Util.fromUtf8Bytes(this.f12740a, i2, (i3 >= this.f12742c || this.f12740a[i3] != 0) ? i : i - 1);
        this.f12741b += i;
        return fromUtf8Bytes;
    }

    public short readShort() {
        byte[] bArr = this.f12740a;
        int i = this.f12741b;
        int i2 = i + 1;
        this.f12741b = i2;
        int i3 = (bArr[i] & 255) << 8;
        this.f12741b = i + 2;
        return (short) ((bArr[i2] & 255) | i3);
    }

    public String readString(int i) {
        return readString(i, Charsets.UTF_8);
    }

    public int readSynchSafeInt() {
        return (readUnsignedByte() << 21) | (readUnsignedByte() << 14) | (readUnsignedByte() << 7) | readUnsignedByte();
    }

    public int readUnsignedByte() {
        byte[] bArr = this.f12740a;
        int i = this.f12741b;
        this.f12741b = i + 1;
        return bArr[i] & 255;
    }

    public int readUnsignedFixedPoint1616() {
        byte[] bArr = this.f12740a;
        int i = this.f12741b;
        int i2 = i + 1;
        this.f12741b = i2;
        int i3 = (bArr[i] & 255) << 8;
        this.f12741b = i + 2;
        int i4 = (bArr[i2] & 255) | i3;
        this.f12741b = i + 4;
        return i4;
    }

    public long readUnsignedInt() {
        byte[] bArr = this.f12740a;
        int i = this.f12741b;
        this.f12741b = i + 1;
        this.f12741b = i + 2;
        this.f12741b = i + 3;
        long j = ((bArr[i] & 255) << 24) | ((bArr[r2] & 255) << 16) | ((bArr[r7] & 255) << 8);
        this.f12741b = i + 4;
        return (bArr[r4] & 255) | j;
    }

    public int readUnsignedInt24() {
        byte[] bArr = this.f12740a;
        int i = this.f12741b;
        int i2 = i + 1;
        this.f12741b = i2;
        int i3 = (bArr[i] & 255) << 16;
        int i4 = i + 2;
        this.f12741b = i4;
        int i5 = ((bArr[i2] & 255) << 8) | i3;
        this.f12741b = i + 3;
        return (bArr[i4] & 255) | i5;
    }

    public int readUnsignedIntToInt() {
        int readInt = readInt();
        if (readInt >= 0) {
            return readInt;
        }
        throw new IllegalStateException(ye0.m8291k(readInt, "Top bit not zero: "));
    }

    public long readUnsignedLongToLong() {
        long readLong = readLong();
        if (readLong >= 0) {
            return readLong;
        }
        throw new IllegalStateException(ye0.m8294n(readLong, "Top bit not zero: "));
    }

    public int readUnsignedShort() {
        byte[] bArr = this.f12740a;
        int i = this.f12741b;
        int i2 = i + 1;
        this.f12741b = i2;
        int i3 = (bArr[i] & 255) << 8;
        this.f12741b = i + 2;
        return (bArr[i2] & 255) | i3;
    }

    public long readUtf8EncodedLong() {
        int i;
        int i2;
        long j = this.f12740a[this.f12741b];
        int i3 = 7;
        while (true) {
            if (i3 < 0) {
                break;
            }
            if (((1 << i3) & j) != 0) {
                i3--;
            } else if (i3 < 6) {
                j &= r6 - 1;
                i2 = 7 - i3;
            } else if (i3 == 7) {
                i2 = 1;
            }
        }
        i2 = 0;
        if (i2 != 0) {
            for (i = 1; i < i2; i++) {
                if ((this.f12740a[this.f12741b + i] & 192) == 128) {
                    j = (j << 6) | (r3 & Utf8.REPLACEMENT_BYTE);
                } else {
                    throw new NumberFormatException(ye0.m8294n(j, "Invalid UTF-8 sequence continuation byte: "));
                }
            }
            this.f12741b += i2;
            return j;
        }
        throw new NumberFormatException(ye0.m8294n(j, "Invalid UTF-8 sequence first byte: "));
    }

    public void reset(int i) {
        reset(capacity() < i ? new byte[i] : this.f12740a, i);
    }

    public void setLimit(int i) {
        boolean z;
        if (i >= 0 && i <= this.f12740a.length) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkArgument(z);
        this.f12742c = i;
    }

    public void setPosition(int i) {
        boolean z;
        if (i >= 0 && i <= this.f12742c) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkArgument(z);
        this.f12741b = i;
    }

    public void skipBytes(int i) {
        setPosition(this.f12741b + i);
    }

    public String readString(int i, Charset charset) {
        String str = new String(this.f12740a, this.f12741b, i, charset);
        this.f12741b += i;
        return str;
    }

    public void reset(byte[] bArr) {
        reset(bArr, bArr.length);
    }

    public ParsableByteArray(int i) {
        this.f12740a = new byte[i];
        this.f12742c = i;
    }

    public void readBytes(byte[] bArr, int i, int i2) {
        System.arraycopy(this.f12740a, this.f12741b, bArr, i, i2);
        this.f12741b += i2;
    }

    public void reset(byte[] bArr, int i) {
        this.f12740a = bArr;
        this.f12742c = i;
        this.f12741b = 0;
    }

    public void readBytes(ByteBuffer byteBuffer, int i) {
        byteBuffer.put(this.f12740a, this.f12741b, i);
        this.f12741b += i;
    }

    public ParsableByteArray(byte[] bArr) {
        this.f12740a = bArr;
        this.f12742c = bArr.length;
    }

    @Nullable
    public String readNullTerminatedString() {
        return readDelimiterTerminatedString((char) 0);
    }

    public ParsableByteArray(byte[] bArr, int i) {
        this.f12740a = bArr;
        this.f12742c = i;
    }
}
