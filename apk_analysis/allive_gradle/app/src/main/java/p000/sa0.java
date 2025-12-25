package p000;

import android.media.MediaDataSource;
import java.io.IOException;

/* loaded from: classes.dex */
public final class sa0 extends MediaDataSource {

    /* renamed from: a */
    public long f26342a;

    /* renamed from: b */
    public final /* synthetic */ ta0 f26343b;

    public sa0(ta0 ta0Var) {
        this.f26343b = ta0Var;
    }

    @Override // android.media.MediaDataSource
    public final long getSize() {
        return -1L;
    }

    @Override // android.media.MediaDataSource
    public final int readAt(long j, byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (j < 0) {
            return -1;
        }
        try {
            long j2 = this.f26342a;
            ta0 ta0Var = this.f26343b;
            if (j2 != j) {
                if (j2 >= 0 && j >= j2 + ta0Var.f26741a.available()) {
                    return -1;
                }
                ta0Var.m7468a(j);
                this.f26342a = j;
            }
            if (i2 > ta0Var.f26741a.available()) {
                i2 = ta0Var.f26741a.available();
            }
            int read = ta0Var.read(bArr, i, i2);
            if (read >= 0) {
                this.f26342a += read;
                return read;
            }
        } catch (IOException unused) {
        }
        this.f26342a = -1L;
        return -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
