package com.facebook.crypto.streams;

import com.facebook.crypto.mac.NativeMac;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class NativeMacLayeredInputStream extends InputStream {

    /* renamed from: a */
    public final NativeMac f9232a;

    /* renamed from: b */
    public final TailInputStream f9233b;

    /* renamed from: c */
    public boolean f9234c = false;

    public NativeMacLayeredInputStream(NativeMac nativeMac, InputStream inputStream) {
        this.f9232a = nativeMac;
        this.f9233b = new TailInputStream(inputStream, nativeMac.getMacLength());
    }

    /* renamed from: a */
    public final void m2407a() {
        NativeMac nativeMac = this.f9232a;
        if (this.f9234c) {
            return;
        }
        this.f9234c = true;
        try {
            byte[] doFinal = nativeMac.doFinal();
            byte[] tail = this.f9233b.getTail();
            if (tail.length == doFinal.length) {
                int i = 0;
                for (int i2 = 0; i2 < tail.length; i2++) {
                    i |= tail[i2] ^ doFinal[i2];
                }
                if (i == 0) {
                    return;
                }
            }
            throw new IOException("Mac does not match");
        } finally {
            nativeMac.destroy();
        }
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f9233b.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        TailInputStream tailInputStream = this.f9233b;
        try {
            m2407a();
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

    @Override // java.io.InputStream
    public synchronized void reset() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int read = this.f9233b.read(bArr, i, i2);
        if (read == -1) {
            m2407a();
            return -1;
        }
        if (read > 0) {
            this.f9232a.update(bArr, i, read);
        }
        return read;
    }
}
