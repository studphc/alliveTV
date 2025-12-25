package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public final class CountingInputStream extends FilterInputStream {

    /* renamed from: a */
    public long f15073a;

    /* renamed from: b */
    public long f15074b;

    public CountingInputStream(InputStream inputStream) {
        super((InputStream) Preconditions.checkNotNull(inputStream));
        this.f15074b = -1L;
    }

    public long getCount() {
        return this.f15073a;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        ((FilterInputStream) this).in.mark(i);
        this.f15074b = this.f15073a;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int read = ((FilterInputStream) this).in.read();
        if (read != -1) {
            this.f15073a++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        if (((FilterInputStream) this).in.markSupported()) {
            if (this.f15074b != -1) {
                ((FilterInputStream) this).in.reset();
                this.f15073a = this.f15074b;
            } else {
                throw new IOException("Mark not set");
            }
        } else {
            throw new IOException("Mark not supported");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) {
        long skip = ((FilterInputStream) this).in.skip(j);
        this.f15073a += skip;
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int read = ((FilterInputStream) this).in.read(bArr, i, i2);
        if (read != -1) {
            this.f15073a += read;
        }
        return read;
    }
}
