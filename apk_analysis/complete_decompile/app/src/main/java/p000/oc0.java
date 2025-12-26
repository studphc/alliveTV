package p000;

import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.FileHandle;
import okio.Source;
import okio.Timeout;

/* loaded from: classes2.dex */
public final class oc0 implements Source {

    /* renamed from: a */
    public final FileHandle f23762a;

    /* renamed from: b */
    public long f23763b;

    /* renamed from: c */
    public boolean f23764c;

    public oc0(FileHandle fileHandle, long j) {
        Intrinsics.checkNotNullParameter(fileHandle, "fileHandle");
        this.f23762a = fileHandle;
        this.f23763b = j;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        int i;
        int i2;
        boolean z;
        if (this.f23764c) {
            return;
        }
        this.f23764c = true;
        synchronized (this.f23762a) {
            FileHandle fileHandle = this.f23762a;
            i = fileHandle.f24699c;
            fileHandle.f24699c = i - 1;
            i2 = this.f23762a.f24699c;
            if (i2 == 0) {
                z = this.f23762a.f24698b;
                if (z) {
                    this.f23762a.protectedClose();
                }
            }
        }
    }

    @Override // okio.Source
    public final long read(Buffer sink, long j) {
        long m6661a;
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (!this.f23764c) {
            m6661a = this.f23762a.m6661a(this.f23763b, sink, j);
            if (m6661a != -1) {
                this.f23763b += m6661a;
            }
            return m6661a;
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.Source
    /* renamed from: timeout */
    public final Timeout getF24750a() {
        return Timeout.NONE;
    }
}
