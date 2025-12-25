package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;
import p000.C1533m2;
import p000.lc0;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public final class FileBackedOutputStream extends OutputStream {

    /* renamed from: a */
    public final int f15076a;

    /* renamed from: b */
    public final boolean f15077b;

    /* renamed from: c */
    public final ByteSource f15078c;

    /* renamed from: d */
    public OutputStream f15079d;

    /* renamed from: e */
    public C1533m2 f15080e;

    /* renamed from: f */
    public File f15081f;

    public FileBackedOutputStream(int i) {
        this(i, false);
    }

    /* renamed from: a */
    public static InputStream m4202a(FileBackedOutputStream fileBackedOutputStream) {
        InputStream byteArrayInputStream;
        synchronized (fileBackedOutputStream) {
            if (fileBackedOutputStream.f15081f != null) {
                byteArrayInputStream = new FileInputStream(fileBackedOutputStream.f15081f);
            } else {
                Objects.requireNonNull(fileBackedOutputStream.f15080e);
                byteArrayInputStream = new ByteArrayInputStream(fileBackedOutputStream.f15080e.m6005b(), 0, fileBackedOutputStream.f15080e.getCount());
            }
        }
        return byteArrayInputStream;
    }

    public ByteSource asByteSource() {
        return this.f15078c;
    }

    /* renamed from: b */
    public final void m4203b(int i) {
        C1533m2 c1533m2 = this.f15080e;
        if (c1533m2 != null && c1533m2.getCount() + i > this.f15076a) {
            File createTempFile = File.createTempFile("FileBackedOutputStream", null, null);
            if (this.f15077b) {
                createTempFile.deleteOnExit();
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                fileOutputStream.write(this.f15080e.m6005b(), 0, this.f15080e.getCount());
                fileOutputStream.flush();
                this.f15079d = fileOutputStream;
                this.f15081f = createTempFile;
                this.f15080e = null;
            } catch (IOException e) {
                createTempFile.delete();
                throw e;
            }
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f15079d.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public synchronized void flush() {
        this.f15079d.flush();
    }

    public synchronized void reset() {
        try {
            close();
            C1533m2 c1533m2 = this.f15080e;
            if (c1533m2 == null) {
                this.f15080e = new C1533m2();
            } else {
                c1533m2.reset();
            }
            this.f15079d = this.f15080e;
            File file = this.f15081f;
            if (file != null) {
                this.f15081f = null;
                if (!file.delete()) {
                    String valueOf = String.valueOf(file);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 18);
                    sb.append("Could not delete: ");
                    sb.append(valueOf);
                    throw new IOException(sb.toString());
                }
            }
        } catch (Throwable th) {
            if (this.f15080e == null) {
                this.f15080e = new C1533m2();
            } else {
                this.f15080e.reset();
            }
            this.f15079d = this.f15080e;
            File file2 = this.f15081f;
            if (file2 != null) {
                this.f15081f = null;
                if (!file2.delete()) {
                    String valueOf2 = String.valueOf(file2);
                    StringBuilder sb2 = new StringBuilder(valueOf2.length() + 18);
                    sb2.append("Could not delete: ");
                    sb2.append(valueOf2);
                    throw new IOException(sb2.toString());
                }
            }
            throw th;
        } finally {
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) {
        m4203b(1);
        this.f15079d.write(i);
    }

    public FileBackedOutputStream(int i, boolean z) {
        this.f15076a = i;
        this.f15077b = z;
        C1533m2 c1533m2 = new C1533m2();
        this.f15080e = c1533m2;
        this.f15079d = c1533m2;
        if (z) {
            this.f15078c = new lc0(this, 0);
        } else {
            this.f15078c = new lc0(this, 1);
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        m4203b(i2);
        this.f15079d.write(bArr, i, i2);
    }
}
