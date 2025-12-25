package p000;

import com.google.common.base.Preconditions;
import com.google.common.io.CharSource;
import java.io.Reader;
import java.util.Iterator;

/* renamed from: we */
/* loaded from: classes2.dex */
public final class C1943we extends Reader {

    /* renamed from: a */
    public final /* synthetic */ int f28155a = 0;

    /* renamed from: b */
    public Reader f28156b;

    /* renamed from: c */
    public final Object f28157c;

    public C1943we(Iterator it) {
        this.f28157c = it;
        m8053a();
    }

    /* renamed from: a */
    public void m8053a() {
        close();
        Iterator it = (Iterator) this.f28157c;
        if (it.hasNext()) {
            this.f28156b = ((CharSource) it.next()).openStream();
        }
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        switch (this.f28155a) {
            case 0:
                this.f28156b.close();
                return;
            default:
                Reader reader = this.f28156b;
                if (reader != null) {
                    try {
                        reader.close();
                        return;
                    } finally {
                        this.f28156b = null;
                    }
                }
                return;
        }
    }

    @Override // java.io.Reader
    public final int read(char[] cArr, int i, int i2) {
        switch (this.f28155a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                Preconditions.checkNotNull(cArr);
                Reader reader = this.f28156b;
                if (reader == null) {
                    return -1;
                }
                int read = reader.read(cArr, i, i2);
                if (read != -1) {
                    return read;
                }
                m8053a();
                return read(cArr, i, i2);
        }
    }

    @Override // java.io.Reader
    public boolean ready() {
        switch (this.f28155a) {
            case 1:
                Reader reader = this.f28156b;
                if (reader != null && reader.ready()) {
                    return true;
                }
                return false;
            default:
                return super.ready();
        }
    }

    @Override // java.io.Reader
    public long skip(long j) {
        boolean z;
        switch (this.f28155a) {
            case 1:
                if (j >= 0) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkArgument(z, "n is negative");
                if (j <= 0) {
                    return 0L;
                }
                while (true) {
                    Reader reader = this.f28156b;
                    if (reader == null) {
                        return 0L;
                    }
                    long skip = reader.skip(j);
                    if (skip > 0) {
                        return skip;
                    }
                    m8053a();
                }
            default:
                return super.skip(j);
        }
    }

    public C1943we(Reader reader, String str) {
        this.f28156b = reader;
        this.f28157c = str;
    }

    @Override // java.io.Reader
    public int read() {
        int read;
        switch (this.f28155a) {
            case 0:
                break;
            default:
                return super.read();
        }
        do {
            read = this.f28156b.read();
            if (read != -1) {
            }
            return read;
        } while (((String) this.f28157c).indexOf((char) read) >= 0);
        return read;
    }
}
