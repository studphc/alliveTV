package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import p000.ye0;

/* renamed from: com.google.common.io.e */
/* loaded from: classes2.dex */
public final class C0971e extends InputStream {

    /* renamed from: a */
    public int f15104a = 0;

    /* renamed from: b */
    public int f15105b = 0;

    /* renamed from: c */
    public int f15106c = 0;

    /* renamed from: d */
    public boolean f15107d = false;

    /* renamed from: e */
    public final /* synthetic */ Reader f15108e;

    /* renamed from: f */
    public final /* synthetic */ C0972f f15109f;

    public C0971e(C0972f c0972f, Reader reader) {
        this.f15109f = c0972f;
        this.f15108e = reader;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f15108e.close();
    }

    @Override // java.io.InputStream
    public final int read() {
        while (true) {
            int read = this.f15108e.read();
            C0972f c0972f = this.f15109f;
            if (read == -1) {
                if (!this.f15107d) {
                    C0967a c0967a = c0972f.f15110f;
                    if (!c0967a.f15099h[this.f15106c % c0967a.f15096e]) {
                        throw new IOException(ye0.m8290j(32, this.f15106c, "Invalid input length "));
                    }
                }
                return -1;
            }
            this.f15106c++;
            char c = (char) read;
            Character ch = c0972f.f15111g;
            C0967a c0967a2 = c0972f.f15110f;
            if (ch != null && ch.charValue() == c) {
                if (!this.f15107d) {
                    int i = this.f15106c;
                    if (i == 1) {
                        break;
                    }
                    if (!c0967a2.f15099h[(i - 1) % c0967a2.f15096e]) {
                        break;
                    }
                }
                this.f15107d = true;
            } else if (!this.f15107d) {
                int i2 = this.f15104a << c0967a2.f15095d;
                this.f15104a = i2;
                int m4206a = c0967a2.m4206a(c) | i2;
                this.f15104a = m4206a;
                int i3 = this.f15105b + c0967a2.f15095d;
                this.f15105b = i3;
                if (i3 >= 8) {
                    int i4 = i3 - 8;
                    this.f15105b = i4;
                    return (m4206a >> i4) & 255;
                }
            } else {
                int i5 = this.f15106c;
                StringBuilder sb = new StringBuilder(61);
                sb.append("Expected padding character but found '");
                sb.append(c);
                sb.append("' at index ");
                sb.append(i5);
                throw new IOException(sb.toString());
            }
        }
        throw new IOException(ye0.m8290j(41, this.f15106c, "Padding cannot start at index "));
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) {
        int i3 = i2 + i;
        Preconditions.checkPositionIndexes(i, i3, bArr.length);
        int i4 = i;
        while (i4 < i3) {
            int read = read();
            if (read == -1) {
                int i5 = i4 - i;
                if (i5 == 0) {
                    return -1;
                }
                return i5;
            }
            bArr[i4] = (byte) read;
            i4++;
        }
        return i4 - i;
    }
}
