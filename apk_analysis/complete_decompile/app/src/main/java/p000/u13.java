package p000;

import androidx.versionedparcelable.C0523a;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class u13 extends FilterInputStream {

    /* renamed from: a */
    public final /* synthetic */ C0523a f27069a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u13(C0523a c0523a, InputStream inputStream) {
        super(inputStream);
        this.f27069a = c0523a;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() {
        C0523a c0523a = this.f27069a;
        int i = c0523a.f7581l;
        if (i != -1 && c0523a.f7579j >= i) {
            throw new IOException();
        }
        int read = super.read();
        c0523a.f7579j++;
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j) {
        C0523a c0523a = this.f27069a;
        int i = c0523a.f7581l;
        if (i != -1 && c0523a.f7579j >= i) {
            throw new IOException();
        }
        long skip = super.skip(j);
        if (skip > 0) {
            c0523a.f7579j += (int) skip;
        }
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) {
        C0523a c0523a = this.f27069a;
        int i3 = c0523a.f7581l;
        if (i3 != -1 && c0523a.f7579j >= i3) {
            throw new IOException();
        }
        int read = super.read(bArr, i, i2);
        if (read > 0) {
            c0523a.f7579j += read;
        }
        return read;
    }
}
