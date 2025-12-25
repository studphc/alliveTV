package p000;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.BufferedOutputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class lc2 extends BufferedOutputStream {

    /* renamed from: a */
    public boolean f22465a;

    /* renamed from: a */
    public final void m5920a(OutputStream outputStream) {
        Assertions.checkState(this.f22465a);
        ((BufferedOutputStream) this).out = outputStream;
        ((BufferedOutputStream) this).count = 0;
        this.f22465a = false;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f22465a = true;
        try {
            flush();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            ((BufferedOutputStream) this).out.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        if (th != null) {
            Util.sneakyThrow(th);
        }
    }
}
