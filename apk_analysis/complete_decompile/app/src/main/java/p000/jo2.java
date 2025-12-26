package p000;

import java.io.Closeable;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class jo2 implements Closeable {

    /* renamed from: a */
    public final FileInputStream f20570a;

    /* renamed from: b */
    public final Charset f20571b;

    /* renamed from: c */
    public byte[] f20572c;

    /* renamed from: d */
    public int f20573d;

    /* renamed from: e */
    public int f20574e;

    public jo2(FileInputStream fileInputStream, Charset charset) {
        if (charset != null) {
            if (charset.equals(b13.f7854a)) {
                this.f20570a = fileInputStream;
                this.f20571b = charset;
                this.f20572c = new byte[8192];
                return;
            }
            throw new IllegalArgumentException("Unsupported encoding");
        }
        throw null;
    }

    /* renamed from: a */
    public final String m5447a() {
        int i;
        synchronized (this.f20570a) {
            try {
                byte[] bArr = this.f20572c;
                if (bArr != null) {
                    if (this.f20573d >= this.f20574e) {
                        int read = this.f20570a.read(bArr, 0, bArr.length);
                        if (read != -1) {
                            this.f20573d = 0;
                            this.f20574e = read;
                        } else {
                            throw new EOFException();
                        }
                    }
                    for (int i2 = this.f20573d; i2 != this.f20574e; i2++) {
                        byte[] bArr2 = this.f20572c;
                        if (bArr2[i2] == 10) {
                            int i3 = this.f20573d;
                            if (i2 != i3) {
                                i = i2 - 1;
                                if (bArr2[i] == 13) {
                                    String str = new String(bArr2, i3, i - i3, this.f20571b.name());
                                    this.f20573d = i2 + 1;
                                    return str;
                                }
                            }
                            i = i2;
                            String str2 = new String(bArr2, i3, i - i3, this.f20571b.name());
                            this.f20573d = i2 + 1;
                            return str2;
                        }
                    }
                    io2 io2Var = new io2(this, (this.f20574e - this.f20573d) + 80);
                    while (true) {
                        byte[] bArr3 = this.f20572c;
                        int i4 = this.f20573d;
                        io2Var.write(bArr3, i4, this.f20574e - i4);
                        this.f20574e = -1;
                        byte[] bArr4 = this.f20572c;
                        int read2 = this.f20570a.read(bArr4, 0, bArr4.length);
                        if (read2 != -1) {
                            this.f20573d = 0;
                            this.f20574e = read2;
                            for (int i5 = 0; i5 != this.f20574e; i5++) {
                                byte[] bArr5 = this.f20572c;
                                if (bArr5[i5] == 10) {
                                    int i6 = this.f20573d;
                                    if (i5 != i6) {
                                        io2Var.write(bArr5, i6, i5 - i6);
                                    }
                                    this.f20573d = i5 + 1;
                                    return io2Var.toString();
                                }
                            }
                        } else {
                            throw new EOFException();
                        }
                    }
                } else {
                    throw new IOException("LineReader is closed");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this.f20570a) {
            try {
                if (this.f20572c != null) {
                    this.f20572c = null;
                    this.f20570a.close();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
