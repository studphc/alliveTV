package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import com.google.common.base.Ascii;
import java.io.FilterInputStream;
import java.io.InputStream;
import p000.ye0;

/* loaded from: classes.dex */
public final class ExifOrientationStream extends FilterInputStream {

    /* renamed from: c */
    public static final byte[] f8643c = {-1, -31, 0, Ascii.f14458FS, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, Ascii.DC2, 0, 2, 0, 0, 0, 1, 0};

    /* renamed from: d */
    public static final int f8644d = 31;

    /* renamed from: a */
    public final byte f8645a;

    /* renamed from: b */
    public int f8646b;

    public ExifOrientationStream(InputStream inputStream, int i) {
        super(inputStream);
        if (i >= -1 && i <= 8) {
            this.f8645a = (byte) i;
            return;
        }
        throw new IllegalArgumentException(ye0.m8291k(i, "Cannot add invalid orientation: "));
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int read;
        int i;
        int i2 = this.f8646b;
        if (i2 < 2 || i2 > (i = f8644d)) {
            read = super.read();
        } else if (i2 == i) {
            read = this.f8645a;
        } else {
            read = f8643c[i2 - 2] & 255;
        }
        if (read != -1) {
            this.f8646b++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) {
        long skip = super.skip(j);
        if (skip > 0) {
            this.f8646b = (int) (this.f8646b + skip);
        }
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i, int i2) {
        int i3;
        int i4 = this.f8646b;
        int i5 = f8644d;
        if (i4 > i5) {
            i3 = super.read(bArr, i, i2);
        } else if (i4 == i5) {
            bArr[i] = this.f8645a;
            i3 = 1;
        } else if (i4 < 2) {
            i3 = super.read(bArr, i, 2 - i4);
        } else {
            int min = Math.min(i5 - i4, i2);
            System.arraycopy(f8643c, this.f8646b - 2, bArr, i, min);
            i3 = min;
        }
        if (i3 > 0) {
            this.f8646b += i3;
        }
        return i3;
    }
}
