package com.bumptech.glide.load.resource.bitmap;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class RecyclableBufferedInputStream extends FilterInputStream {

    /* renamed from: a */
    public volatile byte[] f8904a;

    /* renamed from: b */
    public int f8905b;

    /* renamed from: c */
    public int f8906c;

    /* renamed from: d */
    public int f8907d;

    /* renamed from: e */
    public int f8908e;

    /* renamed from: f */
    public final ArrayPool f8909f;

    public RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool) {
        super(inputStream);
        this.f8907d = -1;
        this.f8909f = arrayPool;
        this.f8904a = (byte[]) arrayPool.get(65536, byte[].class);
    }

    /* renamed from: b */
    public static void m2353b() {
        throw new IOException("BufferedInputStream is closed");
    }

    /* renamed from: a */
    public final int m2354a(InputStream inputStream, byte[] bArr) {
        int i = this.f8907d;
        if (i != -1) {
            int i2 = this.f8908e - i;
            int i3 = this.f8906c;
            if (i2 < i3) {
                if (i == 0 && i3 > bArr.length && this.f8905b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i3) {
                        i3 = length;
                    }
                    byte[] bArr2 = (byte[]) this.f8909f.get(i3, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f8904a = bArr2;
                    this.f8909f.put(bArr);
                    bArr = bArr2;
                } else if (i > 0) {
                    System.arraycopy(bArr, i, bArr, 0, bArr.length - i);
                }
                int i4 = this.f8908e - this.f8907d;
                this.f8908e = i4;
                this.f8907d = 0;
                this.f8905b = 0;
                int read = inputStream.read(bArr, i4, bArr.length - i4);
                int i5 = this.f8908e;
                if (read > 0) {
                    i5 += read;
                }
                this.f8905b = i5;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.f8907d = -1;
            this.f8908e = 0;
            this.f8905b = read2;
        }
        return read2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f8904a != null && inputStream != null) {
        } else {
            m2353b();
            throw null;
        }
        return (this.f8905b - this.f8908e) + inputStream.available();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f8904a != null) {
            this.f8909f.put(this.f8904a);
            this.f8904a = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public synchronized void fixMarkLimit() {
        this.f8906c = this.f8904a.length;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        this.f8906c = Math.max(this.f8906c, i);
        this.f8907d = this.f8908e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        byte[] bArr = this.f8904a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr != null && inputStream != null) {
            if (this.f8908e >= this.f8905b && m2354a(inputStream, bArr) == -1) {
                return -1;
            }
            if (bArr != this.f8904a && (bArr = this.f8904a) == null) {
                m2353b();
                throw null;
            }
            int i = this.f8905b;
            int i2 = this.f8908e;
            if (i - i2 <= 0) {
                return -1;
            }
            this.f8908e = i2 + 1;
            return bArr[i2] & 255;
        }
        m2353b();
        throw null;
    }

    public synchronized void release() {
        if (this.f8904a != null) {
            this.f8909f.put(this.f8904a);
            this.f8904a = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        if (this.f8904a != null) {
            int i = this.f8907d;
            if (-1 != i) {
                this.f8908e = i;
            } else {
                throw new IOException("Mark has been invalidated, pos: " + this.f8908e + " markLimit: " + this.f8906c);
            }
        } else {
            throw new IOException("Stream is closed");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) {
        if (j < 1) {
            return 0L;
        }
        byte[] bArr = this.f8904a;
        if (bArr != null) {
            InputStream inputStream = ((FilterInputStream) this).in;
            if (inputStream != null) {
                int i = this.f8905b;
                int i2 = this.f8908e;
                if (i - i2 >= j) {
                    this.f8908e = (int) (i2 + j);
                    return j;
                }
                long j2 = i - i2;
                this.f8908e = i;
                if (this.f8907d != -1 && j <= this.f8906c) {
                    if (m2354a(inputStream, bArr) == -1) {
                        return j2;
                    }
                    int i3 = this.f8905b;
                    int i4 = this.f8908e;
                    if (i3 - i4 >= j - j2) {
                        this.f8908e = (int) ((i4 + j) - j2);
                        return j;
                    }
                    long j3 = (j2 + i3) - i4;
                    this.f8908e = i3;
                    return j3;
                }
                long skip = inputStream.skip(j - j2);
                if (skip > 0) {
                    this.f8907d = -1;
                }
                return j2 + skip;
            }
            m2353b();
            throw null;
        }
        m2353b();
        throw null;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(@NonNull byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        byte[] bArr2 = this.f8904a;
        if (bArr2 == null) {
            m2353b();
            throw null;
        }
        if (i2 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            int i5 = this.f8908e;
            int i6 = this.f8905b;
            if (i5 < i6) {
                int i7 = i6 - i5;
                if (i7 >= i2) {
                    i7 = i2;
                }
                System.arraycopy(bArr2, i5, bArr, i, i7);
                this.f8908e += i7;
                if (i7 == i2 || inputStream.available() == 0) {
                    return i7;
                }
                i += i7;
                i3 = i2 - i7;
            } else {
                i3 = i2;
            }
            while (true) {
                if (this.f8907d == -1 && i3 >= bArr2.length) {
                    i4 = inputStream.read(bArr, i, i3);
                    if (i4 == -1) {
                        return i3 != i2 ? i2 - i3 : -1;
                    }
                } else {
                    if (m2354a(inputStream, bArr2) == -1) {
                        return i3 != i2 ? i2 - i3 : -1;
                    }
                    if (bArr2 != this.f8904a && (bArr2 = this.f8904a) == null) {
                        m2353b();
                        throw null;
                    }
                    int i8 = this.f8905b;
                    int i9 = this.f8908e;
                    i4 = i8 - i9;
                    if (i4 >= i3) {
                        i4 = i3;
                    }
                    System.arraycopy(bArr2, i9, bArr, i, i4);
                    this.f8908e += i4;
                }
                i3 -= i4;
                if (i3 == 0) {
                    return i2;
                }
                if (inputStream.available() == 0) {
                    return i2 - i3;
                }
                i += i4;
            }
        } else {
            m2353b();
            throw null;
        }
    }
}
