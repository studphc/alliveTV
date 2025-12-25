package com.facebook.crypto.streams;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class TailInputStream extends FilterInputStream {

    /* renamed from: a */
    public final byte[] f9238a;

    /* renamed from: b */
    public final int f9239b;

    /* renamed from: c */
    public int f9240c;

    /* renamed from: d */
    public boolean f9241d;

    public TailInputStream(InputStream inputStream, int i) {
        super(inputStream);
        this.f9238a = new byte[i];
        this.f9239b = i;
    }

    /* renamed from: a */
    public final int m2408a(byte[] bArr, int i, int i2, int i3) {
        int i4 = this.f9239b - i2;
        int max = Math.max(0, i - i4) + i3;
        int min = Math.min(i4, i);
        if (min > 0) {
            byte[] bArr2 = this.f9238a;
            if (i2 > 0) {
                System.arraycopy(bArr2, 0, bArr2, min, i2);
            }
            System.arraycopy(bArr, max, bArr2, 0, min);
        }
        this.f9240c = min + i2;
        return max - i3;
    }

    public byte[] getTail() {
        if (this.f9240c == this.f9239b) {
            return this.f9238a;
        }
        throw new IOException("Not enough tail data");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        byte[] bArr = new byte[1];
        int read = read(bArr, 0, 1);
        while (read == 0) {
            read = read(bArr, 0, 1);
        }
        if (read == -1) {
            return -1;
        }
        return bArr[0] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        if (this.f9241d) {
            return -1;
        }
        if (i2 == 0) {
            return 0;
        }
        int i3 = 0;
        while (i3 == 0) {
            int i4 = this.f9240c;
            if (i2 >= i4) {
                int read = ((FilterInputStream) this).in.read(bArr, this.f9240c + i, i2 - i4);
                if (read == -1) {
                    this.f9241d = true;
                    i3 = -1;
                } else {
                    int i5 = this.f9240c;
                    if (i5 > 0) {
                        System.arraycopy(this.f9238a, 0, bArr, i, i5);
                    }
                    int i6 = this.f9240c + read;
                    int read2 = ((FilterInputStream) this).in.read(this.f9238a, 0, this.f9239b);
                    if (read2 == -1) {
                        this.f9241d = true;
                        read2 = 0;
                    }
                    i3 = m2408a(bArr, i6, read2, i);
                }
            } else {
                int i7 = i4 - i2;
                System.arraycopy(this.f9238a, 0, bArr, i, i2);
                byte[] bArr2 = this.f9238a;
                System.arraycopy(bArr2, i2, bArr2, 0, i7);
                int read3 = ((FilterInputStream) this).in.read(this.f9238a, i7, this.f9239b - i7);
                if (read3 == -1) {
                    byte[] bArr3 = this.f9238a;
                    System.arraycopy(bArr3, 0, bArr3, i2, i7);
                    System.arraycopy(bArr, i, this.f9238a, 0, i2);
                    this.f9241d = true;
                    i3 = -1;
                } else {
                    i3 = m2408a(bArr, i2, read3 + i7, i);
                }
            }
        }
        return i3;
    }
}
