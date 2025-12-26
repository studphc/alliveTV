package p000;

import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;

/* loaded from: classes2.dex */
public final class d11 extends y01 {

    /* renamed from: d */
    public boolean f16209d;

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f28781b) {
            return;
        }
        if (!this.f16209d) {
            m8207a();
        }
        this.f28781b = true;
    }

    @Override // p000.y01, okio.Source
    public final long read(Buffer sink, long j) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j >= 0) {
            if (!this.f28781b) {
                if (this.f16209d) {
                    return -1L;
                }
                long read = super.read(sink, j);
                if (read == -1) {
                    this.f16209d = true;
                    m8207a();
                    return -1L;
                }
                return read;
            }
            throw new IllegalStateException("closed");
        }
        throw new IllegalArgumentException(ye0.m8294n(j, "byteCount < 0: ").toString());
    }
}
