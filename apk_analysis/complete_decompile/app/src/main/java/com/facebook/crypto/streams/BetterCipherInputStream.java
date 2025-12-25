package com.facebook.crypto.streams;

import java.io.FilterInputStream;
import java.io.InputStream;
import javax.crypto.Cipher;
import javax.crypto.ShortBufferException;

/* loaded from: classes.dex */
public class BetterCipherInputStream extends FilterInputStream {

    /* renamed from: a */
    public final Cipher f9220a;

    /* renamed from: b */
    public final byte[] f9221b;

    public BetterCipherInputStream(InputStream inputStream, Cipher cipher) {
        super(inputStream);
        this.f9220a = cipher;
        this.f9221b = new byte[256];
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int read = ((FilterInputStream) this).in.read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        int i3 = read / 256;
        int i4 = read % 256;
        int i5 = i;
        int i6 = i5;
        for (int i7 = 0; i7 < i3; i7++) {
            try {
                int update = this.f9220a.update(bArr, i5, 256, this.f9221b);
                System.arraycopy(this.f9221b, 0, bArr, i6, update);
                i6 += update;
                i5 += 256;
            } catch (ShortBufferException unused) {
            }
        }
        if (i4 > 0) {
            int update2 = this.f9220a.update(bArr, i5, i4, this.f9221b);
            System.arraycopy(this.f9221b, 0, bArr, i6, update2);
            i6 += update2;
        }
        return i6 - i;
    }
}
