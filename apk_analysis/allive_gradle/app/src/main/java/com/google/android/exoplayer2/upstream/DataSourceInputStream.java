package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.Assertions;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class DataSourceInputStream extends InputStream {

    /* renamed from: a */
    public final DataSource f12416a;

    /* renamed from: b */
    public final DataSpec f12417b;

    /* renamed from: f */
    public long f12421f;

    /* renamed from: d */
    public boolean f12419d = false;

    /* renamed from: e */
    public boolean f12420e = false;

    /* renamed from: c */
    public final byte[] f12418c = new byte[1];

    public DataSourceInputStream(DataSource dataSource, DataSpec dataSpec) {
        this.f12416a = dataSource;
        this.f12417b = dataSpec;
    }

    public long bytesRead() {
        return this.f12421f;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.f12420e) {
            this.f12416a.close();
            this.f12420e = true;
        }
    }

    public void open() {
        if (!this.f12419d) {
            this.f12416a.open(this.f12417b);
            this.f12419d = true;
        }
    }

    @Override // java.io.InputStream
    public int read() {
        byte[] bArr = this.f12418c;
        if (read(bArr) == -1) {
            return -1;
        }
        return bArr[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        Assertions.checkState(!this.f12420e);
        boolean z = this.f12419d;
        DataSource dataSource = this.f12416a;
        if (!z) {
            dataSource.open(this.f12417b);
            this.f12419d = true;
        }
        int read = dataSource.read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        this.f12421f += read;
        return read;
    }
}
