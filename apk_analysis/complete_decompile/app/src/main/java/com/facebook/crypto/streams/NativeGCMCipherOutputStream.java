package com.facebook.crypto.streams;

import com.facebook.crypto.cipher.NativeGCMCipher;
import java.io.OutputStream;
import p000.ye0;

/* loaded from: classes.dex */
public class NativeGCMCipherOutputStream extends OutputStream {

    /* renamed from: a */
    public final OutputStream f9226a;

    /* renamed from: b */
    public final NativeGCMCipher f9227b;

    /* renamed from: c */
    public final int f9228c;

    /* renamed from: d */
    public final byte[] f9229d;

    /* renamed from: e */
    public final byte[] f9230e;

    /* renamed from: f */
    public boolean f9231f = false;

    public NativeGCMCipherOutputStream(OutputStream outputStream, NativeGCMCipher nativeGCMCipher, byte[] bArr, int i) {
        this.f9226a = outputStream;
        this.f9227b = nativeGCMCipher;
        this.f9230e = new byte[i];
        int cipherBlockSize = nativeGCMCipher.getCipherBlockSize();
        if (bArr == null) {
            bArr = new byte[cipherBlockSize + 256];
        } else {
            int i2 = cipherBlockSize + 1;
            if (bArr.length < i2) {
                throw new IllegalArgumentException(ye0.m8292l(i2, "encryptBuffer cannot be smaller than ", "B"));
            }
        }
        this.f9228c = bArr.length - cipherBlockSize;
        this.f9229d = bArr;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        OutputStream outputStream = this.f9226a;
        try {
            byte[] bArr = this.f9230e;
            NativeGCMCipher nativeGCMCipher = this.f9227b;
            if (!this.f9231f) {
                this.f9231f = true;
                try {
                    nativeGCMCipher.encryptFinal(bArr, bArr.length);
                    outputStream.write(bArr);
                } finally {
                    nativeGCMCipher.destroy();
                }
            }
        } finally {
            outputStream.close();
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        this.f9226a.flush();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        byte[] bArr2;
        OutputStream outputStream;
        int i3 = i + i2;
        if (bArr.length >= i3) {
            int i4 = this.f9228c;
            int i5 = i2 / i4;
            int i6 = i2 % i4;
            int i7 = i;
            int i8 = 0;
            while (true) {
                bArr2 = this.f9229d;
                outputStream = this.f9226a;
                if (i8 >= i5) {
                    break;
                }
                outputStream.write(bArr2, 0, this.f9227b.update(bArr, i7, this.f9228c, this.f9229d, 0));
                i7 += i4;
                i8++;
            }
            if (i6 > 0) {
                outputStream.write(bArr2, 0, this.f9227b.update(bArr, i7, i6, this.f9229d, 0));
                return;
            }
            return;
        }
        throw new ArrayIndexOutOfBoundsException(i3);
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        write(new byte[]{(byte) i}, 0, 1);
    }
}
