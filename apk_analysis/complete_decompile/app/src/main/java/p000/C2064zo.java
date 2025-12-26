package p000;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.Objects;

/* renamed from: zo */
/* loaded from: classes2.dex */
public final class C2064zo extends Reader {

    /* renamed from: a */
    public CharSequence f29449a;

    /* renamed from: b */
    public int f29450b;

    /* renamed from: c */
    public int f29451c;

    public C2064zo(CharSequence charSequence) {
        this.f29449a = (CharSequence) Preconditions.checkNotNull(charSequence);
    }

    /* renamed from: a */
    public final void m8419a() {
        if (this.f29449a != null) {
        } else {
            throw new IOException("reader closed");
        }
    }

    /* renamed from: b */
    public final int m8420b() {
        Objects.requireNonNull(this.f29449a);
        return this.f29449a.length() - this.f29450b;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.f29449a = null;
    }

    @Override // java.io.Reader
    public final synchronized void mark(int i) {
        boolean z;
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "readAheadLimit (%s) may not be negative", i);
        m8419a();
        this.f29451c = this.f29450b;
    }

    @Override // java.io.Reader
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.Reader, java.lang.Readable
    public final synchronized int read(CharBuffer charBuffer) {
        Preconditions.checkNotNull(charBuffer);
        m8419a();
        Objects.requireNonNull(this.f29449a);
        if (!(m8420b() > 0)) {
            return -1;
        }
        int min = Math.min(charBuffer.remaining(), m8420b());
        for (int i = 0; i < min; i++) {
            CharSequence charSequence = this.f29449a;
            int i2 = this.f29450b;
            this.f29450b = i2 + 1;
            charBuffer.put(charSequence.charAt(i2));
        }
        return min;
    }

    @Override // java.io.Reader
    public final synchronized boolean ready() {
        m8419a();
        return true;
    }

    @Override // java.io.Reader
    public final synchronized void reset() {
        m8419a();
        this.f29450b = this.f29451c;
    }

    @Override // java.io.Reader
    public final synchronized long skip(long j) {
        boolean z;
        int min;
        if (j >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "n (%s) may not be negative", j);
        m8419a();
        min = (int) Math.min(m8420b(), j);
        this.f29450b += min;
        return min;
    }

    @Override // java.io.Reader
    public final synchronized int read() {
        char c;
        m8419a();
        Objects.requireNonNull(this.f29449a);
        if (m8420b() > 0) {
            CharSequence charSequence = this.f29449a;
            int i = this.f29450b;
            this.f29450b = i + 1;
            c = charSequence.charAt(i);
        } else {
            c = 65535;
        }
        return c;
    }

    @Override // java.io.Reader
    public final synchronized int read(char[] cArr, int i, int i2) {
        Preconditions.checkPositionIndexes(i, i + i2, cArr.length);
        m8419a();
        Objects.requireNonNull(this.f29449a);
        if (!(m8420b() > 0)) {
            return -1;
        }
        int min = Math.min(i2, m8420b());
        for (int i3 = 0; i3 < min; i3++) {
            CharSequence charSequence = this.f29449a;
            int i4 = this.f29450b;
            this.f29450b = i4 + 1;
            cArr[i + i3] = charSequence.charAt(i4);
        }
        return min;
    }
}
