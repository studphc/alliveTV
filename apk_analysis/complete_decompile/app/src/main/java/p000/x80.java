package p000;

import java.io.IOException;
import java.io.OutputStream;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class x80 extends OutputStream {

    /* renamed from: a */
    public final OutputStream f28464a;

    /* renamed from: b */
    public final Base64 f28465b;

    /* renamed from: c */
    public boolean f28466c;

    /* renamed from: d */
    public int f28467d;

    /* renamed from: e */
    public final byte[] f28468e;

    /* renamed from: f */
    public final byte[] f28469f;

    /* renamed from: g */
    public int f28470g;

    public x80(OutputStream output, Base64 base64) {
        int i;
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(base64, "base64");
        this.f28464a = output;
        this.f28465b = base64;
        if (base64.getIsMimeScheme()) {
            i = 76;
        } else {
            i = -1;
        }
        this.f28467d = i;
        this.f28468e = new byte[1024];
        this.f28469f = new byte[3];
    }

    /* renamed from: a */
    public final void m8148a() {
        if (m8149b(this.f28469f, 0, this.f28470g) == 4) {
            this.f28470g = 0;
            return;
        }
        throw new IllegalStateException("Check failed.");
    }

    /* renamed from: b */
    public final int m8149b(byte[] bArr, int i, int i2) {
        int encodeIntoByteArray = this.f28465b.encodeIntoByteArray(bArr, this.f28468e, 0, i, i2);
        int i3 = this.f28467d;
        OutputStream outputStream = this.f28464a;
        if (i3 == 0) {
            outputStream.write(Base64.INSTANCE.getMimeLineSeparatorSymbols$kotlin_stdlib());
            this.f28467d = 76;
            if (encodeIntoByteArray > 76) {
                throw new IllegalStateException("Check failed.");
            }
        }
        outputStream.write(this.f28468e, 0, encodeIntoByteArray);
        this.f28467d -= encodeIntoByteArray;
        return encodeIntoByteArray;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (!this.f28466c) {
            this.f28466c = true;
            if (this.f28470g != 0) {
                m8148a();
            }
            this.f28464a.close();
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
        if (!this.f28466c) {
            this.f28464a.flush();
            return;
        }
        throw new IOException("The output stream is closed.");
    }

    @Override // java.io.OutputStream
    public final void write(int i) {
        if (!this.f28466c) {
            int i2 = this.f28470g;
            int i3 = i2 + 1;
            this.f28470g = i3;
            this.f28469f[i2] = (byte) i;
            if (i3 == 3) {
                m8148a();
                return;
            }
            return;
        }
        throw new IOException("The output stream is closed.");
    }

    @Override // java.io.OutputStream
    public final void write(byte[] source, int i, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(source, "source");
        if (!this.f28466c) {
            if (i < 0 || i2 < 0 || (i3 = i + i2) > source.length) {
                StringBuilder m8302v = ye0.m8302v("offset: ", i, ", length: ", i2, ", source size: ");
                m8302v.append(source.length);
                throw new IndexOutOfBoundsException(m8302v.toString());
            }
            if (i2 == 0) {
                return;
            }
            int i4 = this.f28470g;
            if (i4 < 3) {
                byte[] bArr = this.f28469f;
                if (i4 != 0) {
                    int min = Math.min(3 - i4, i3 - i);
                    int i5 = i + min;
                    ArraysKt___ArraysJvmKt.copyInto(source, bArr, this.f28470g, i, i5);
                    int i6 = this.f28470g + min;
                    this.f28470g = i6;
                    if (i6 == 3) {
                        m8148a();
                    }
                    if (this.f28470g != 0) {
                        return;
                    } else {
                        i = i5;
                    }
                }
                while (i + 3 <= i3) {
                    int min2 = Math.min((this.f28465b.getIsMimeScheme() ? this.f28467d : this.f28468e.length) / 4, (i3 - i) / 3);
                    int i7 = (min2 * 3) + i;
                    if (m8149b(source, i, i7) != min2 * 4) {
                        throw new IllegalStateException("Check failed.");
                    }
                    i = i7;
                }
                ArraysKt___ArraysJvmKt.copyInto(source, bArr, 0, i, i3);
                this.f28470g = i3 - i;
                return;
            }
            throw new IllegalStateException("Check failed.");
        }
        throw new IOException("The output stream is closed.");
    }
}
