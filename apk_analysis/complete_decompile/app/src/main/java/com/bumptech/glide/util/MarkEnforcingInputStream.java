package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.InputStream;

/* loaded from: classes.dex */
public class MarkEnforcingInputStream extends FilterInputStream {

    /* renamed from: a */
    public int f9176a;

    public MarkEnforcingInputStream(@NonNull InputStream inputStream) {
        super(inputStream);
        this.f9176a = Integer.MIN_VALUE;
    }

    /* renamed from: a */
    public final long m2397a(long j) {
        int i = this.f9176a;
        if (i == 0) {
            return -1L;
        }
        if (i != Integer.MIN_VALUE && j > i) {
            return i;
        }
        return j;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        int i = this.f9176a;
        if (i == Integer.MIN_VALUE) {
            return super.available();
        }
        return Math.min(i, super.available());
    }

    /* renamed from: b */
    public final void m2398b(long j) {
        int i = this.f9176a;
        if (i != Integer.MIN_VALUE && j != -1) {
            this.f9176a = (int) (i - j);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        super.mark(i);
        this.f9176a = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        if (m2397a(1L) == -1) {
            return -1;
        }
        int read = super.read();
        m2398b(1L);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        super.reset();
        this.f9176a = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) {
        long m2397a = m2397a(j);
        if (m2397a == -1) {
            return 0L;
        }
        long skip = super.skip(m2397a);
        m2398b(skip);
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i, int i2) {
        int m2397a = (int) m2397a(i2);
        if (m2397a == -1) {
            return -1;
        }
        int read = super.read(bArr, i, m2397a);
        m2398b(read);
        return read;
    }
}
