package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

@Deprecated
/* loaded from: classes.dex */
public class ExceptionCatchingInputStream extends InputStream {

    /* renamed from: c */
    public static final Queue f9162c = Util.createQueue(0);

    /* renamed from: a */
    public InputStream f9163a;

    /* renamed from: b */
    public IOException f9164b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.InputStream] */
    @NonNull
    public static ExceptionCatchingInputStream obtain(@NonNull InputStream inputStream) {
        ExceptionCatchingInputStream exceptionCatchingInputStream;
        ExceptionCatchingInputStream exceptionCatchingInputStream2;
        Queue queue = f9162c;
        synchronized (queue) {
            exceptionCatchingInputStream = (ExceptionCatchingInputStream) queue.poll();
            exceptionCatchingInputStream2 = exceptionCatchingInputStream;
        }
        if (exceptionCatchingInputStream == null) {
            exceptionCatchingInputStream2 = new InputStream();
        }
        exceptionCatchingInputStream2.f9163a = inputStream;
        return exceptionCatchingInputStream2;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f9163a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f9163a.close();
    }

    @Nullable
    public IOException getException() {
        return this.f9164b;
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.f9163a.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f9163a.markSupported();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.f9163a.read(bArr);
        } catch (IOException e) {
            this.f9164b = e;
            return -1;
        }
    }

    public void release() {
        this.f9164b = null;
        this.f9163a = null;
        Queue queue = f9162c;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.f9163a.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        try {
            return this.f9163a.skip(j);
        } catch (IOException e) {
            this.f9164b = e;
            return 0L;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        try {
            return this.f9163a.read(bArr, i, i2);
        } catch (IOException e) {
            this.f9164b = e;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.f9163a.read();
        } catch (IOException e) {
            this.f9164b = e;
            return -1;
        }
    }
}
