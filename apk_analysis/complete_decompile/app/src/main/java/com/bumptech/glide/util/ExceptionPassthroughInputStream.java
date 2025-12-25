package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* loaded from: classes.dex */
public final class ExceptionPassthroughInputStream extends InputStream {

    /* renamed from: c */
    public static final Queue f9165c = Util.createQueue(0);

    /* renamed from: a */
    public InputStream f9166a;

    /* renamed from: b */
    public IOException f9167b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.InputStream] */
    @NonNull
    public static ExceptionPassthroughInputStream obtain(@NonNull InputStream inputStream) {
        ExceptionPassthroughInputStream exceptionPassthroughInputStream;
        ExceptionPassthroughInputStream exceptionPassthroughInputStream2;
        Queue queue = f9165c;
        synchronized (queue) {
            exceptionPassthroughInputStream = (ExceptionPassthroughInputStream) queue.poll();
            exceptionPassthroughInputStream2 = exceptionPassthroughInputStream;
        }
        if (exceptionPassthroughInputStream == null) {
            exceptionPassthroughInputStream2 = new InputStream();
        }
        exceptionPassthroughInputStream2.f9166a = inputStream;
        return exceptionPassthroughInputStream2;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f9166a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f9166a.close();
    }

    @Nullable
    public IOException getException() {
        return this.f9167b;
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.f9166a.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f9166a.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.f9166a.read();
        } catch (IOException e) {
            this.f9167b = e;
            throw e;
        }
    }

    public void release() {
        this.f9167b = null;
        this.f9166a = null;
        Queue queue = f9165c;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.f9166a.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        try {
            return this.f9166a.skip(j);
        } catch (IOException e) {
            this.f9167b = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.f9166a.read(bArr);
        } catch (IOException e) {
            this.f9167b = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        try {
            return this.f9166a.read(bArr, i, i2);
        } catch (IOException e) {
            this.f9167b = e;
            throw e;
        }
    }
}
