package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class BufferedOutputStream extends OutputStream {

    /* renamed from: a */
    public final OutputStream f8637a;

    /* renamed from: b */
    public byte[] f8638b;

    /* renamed from: c */
    public final ArrayPool f8639c;

    /* renamed from: d */
    public int f8640d;

    public BufferedOutputStream(@NonNull OutputStream outputStream, @NonNull ArrayPool arrayPool) {
        this.f8637a = outputStream;
        this.f8639c = arrayPool;
        this.f8638b = (byte[]) arrayPool.get(65536, byte[].class);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        OutputStream outputStream = this.f8637a;
        try {
            flush();
            outputStream.close();
            byte[] bArr = this.f8638b;
            if (bArr != null) {
                this.f8639c.put(bArr);
                this.f8638b = null;
            }
        } catch (Throwable th) {
            outputStream.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        int i = this.f8640d;
        OutputStream outputStream = this.f8637a;
        if (i > 0) {
            outputStream.write(this.f8638b, 0, i);
            this.f8640d = 0;
        }
        outputStream.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        byte[] bArr = this.f8638b;
        int i2 = this.f8640d;
        int i3 = i2 + 1;
        this.f8640d = i3;
        bArr[i2] = (byte) i;
        if (i3 != bArr.length || i3 <= 0) {
            return;
        }
        this.f8637a.write(bArr, 0, i3);
        this.f8640d = 0;
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr, int i, int i2) {
        int i3 = 0;
        do {
            int i4 = i2 - i3;
            int i5 = i + i3;
            int i6 = this.f8640d;
            OutputStream outputStream = this.f8637a;
            if (i6 == 0 && i4 >= this.f8638b.length) {
                outputStream.write(bArr, i5, i4);
                return;
            }
            int min = Math.min(i4, this.f8638b.length - i6);
            System.arraycopy(bArr, i5, this.f8638b, this.f8640d, min);
            int i7 = this.f8640d + min;
            this.f8640d = i7;
            i3 += min;
            byte[] bArr2 = this.f8638b;
            if (i7 == bArr2.length && i7 > 0) {
                outputStream.write(bArr2, 0, i7);
                this.f8640d = 0;
            }
        } while (i3 < i2);
    }
}
