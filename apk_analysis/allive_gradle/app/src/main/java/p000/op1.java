package p000;

import com.google.common.base.Preconditions;
import com.google.common.io.ByteSource;
import java.io.InputStream;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class op1 extends InputStream {

    /* renamed from: a */
    public Iterator f24855a;

    /* renamed from: b */
    public InputStream f24856b;

    /* renamed from: a */
    public final void m6714a() {
        close();
        Iterator it = this.f24855a;
        if (it.hasNext()) {
            this.f24856b = ((ByteSource) it.next()).openStream();
        }
    }

    @Override // java.io.InputStream
    public final int available() {
        InputStream inputStream = this.f24856b;
        if (inputStream == null) {
            return 0;
        }
        return inputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        InputStream inputStream = this.f24856b;
        if (inputStream != null) {
            try {
                inputStream.close();
            } finally {
                this.f24856b = null;
            }
        }
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public final int read() {
        while (true) {
            InputStream inputStream = this.f24856b;
            if (inputStream == null) {
                return -1;
            }
            int read = inputStream.read();
            if (read != -1) {
                return read;
            }
            m6714a();
        }
    }

    @Override // java.io.InputStream
    public final long skip(long j) {
        InputStream inputStream = this.f24856b;
        if (inputStream == null || j <= 0) {
            return 0L;
        }
        long skip = inputStream.skip(j);
        if (skip != 0) {
            return skip;
        }
        if (read() == -1) {
            return 0L;
        }
        return this.f24856b.skip(j - 1) + 1;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) {
        Preconditions.checkNotNull(bArr);
        while (true) {
            InputStream inputStream = this.f24856b;
            if (inputStream == null) {
                return -1;
            }
            int read = inputStream.read(bArr, i, i2);
            if (read != -1) {
                return read;
            }
            m6714a();
        }
    }
}
