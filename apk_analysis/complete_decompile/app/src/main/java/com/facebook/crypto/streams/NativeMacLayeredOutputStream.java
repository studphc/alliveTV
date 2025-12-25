package com.facebook.crypto.streams;

import com.facebook.crypto.mac.NativeMac;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class NativeMacLayeredOutputStream extends OutputStream {

    /* renamed from: a */
    public final NativeMac f9235a;

    /* renamed from: b */
    public final OutputStream f9236b;

    /* renamed from: c */
    public boolean f9237c = false;

    public NativeMacLayeredOutputStream(NativeMac nativeMac, OutputStream outputStream) {
        this.f9235a = nativeMac;
        this.f9236b = outputStream;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        OutputStream outputStream = this.f9236b;
        try {
            NativeMac nativeMac = this.f9235a;
            if (!this.f9237c) {
                this.f9237c = true;
                try {
                    outputStream.write(nativeMac.doFinal());
                } finally {
                    nativeMac.destroy();
                }
            }
        } finally {
            outputStream.close();
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        this.f9236b.flush();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        this.f9235a.update(bArr, i, i2);
        this.f9236b.write(bArr, i, i2);
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        this.f9235a.update((byte) i);
        this.f9236b.write(i);
    }
}
