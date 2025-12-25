package com.facebook.crypto.streams;

import com.facebook.crypto.cipher.NativeGCMCipher;
import java.io.InputStream;

/* loaded from: classes.dex */
public class NativeGCMCipherInputStream extends InputStream {

    /* renamed from: a */
    public final TailInputStream f9222a;

    /* renamed from: b */
    public final NativeGCMCipher f9223b;

    /* renamed from: c */
    public byte[] f9224c;

    /* renamed from: d */
    public boolean f9225d = false;

    public NativeGCMCipherInputStream(InputStream inputStream, NativeGCMCipher nativeGCMCipher, int i) {
        this.f9222a = new TailInputStream(inputStream, i);
        this.f9223b = nativeGCMCipher;
    }

    /* renamed from: a */
    public final void m2406a() {
        NativeGCMCipher nativeGCMCipher = this.f9223b;
        if (this.f9225d) {
            return;
        }
        this.f9225d = true;
        try {
            byte[] tail = this.f9222a.getTail();
            nativeGCMCipher.decryptFinal(tail, tail.length);
        } finally {
            nativeGCMCipher.destroy();
        }
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f9222a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        TailInputStream tailInputStream = this.f9222a;
        try {
            m2406a();
        } finally {
            tailInputStream.close();
        }
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public int read() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        if (this.f9224c == null) {
            this.f9224c = new byte[256];
        }
        long j2 = 0;
        while (j > 0) {
            int read = read(this.f9224c, 0, (int) Math.min(j, 256L));
            if (read < 0) {
                break;
            }
            long j3 = read;
            j2 += j3;
            j -= j3;
        }
        if (j2 == 0) {
            return -1L;
        }
        return j2;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int i3 = i + i2;
        if (bArr.length >= i3) {
            int read = this.f9222a.read(bArr, i, i2);
            if (read == -1) {
                m2406a();
                return -1;
            }
            return this.f9223b.update(bArr, i, read, bArr, i);
        }
        throw new ArrayIndexOutOfBoundsException(i3);
    }
}
