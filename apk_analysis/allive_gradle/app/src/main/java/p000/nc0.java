package p000;

import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.FileHandle;
import okio.Sink;
import okio.Timeout;

/* loaded from: classes2.dex */
public final class nc0 implements Sink {

    /* renamed from: a */
    public final FileHandle f23321a;

    /* renamed from: b */
    public long f23322b;

    /* renamed from: c */
    public boolean f23323c;

    public nc0(FileHandle fileHandle, long j) {
        Intrinsics.checkNotNullParameter(fileHandle, "fileHandle");
        this.f23321a = fileHandle;
        this.f23322b = j;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        int i;
        int i2;
        boolean z;
        if (this.f23323c) {
            return;
        }
        this.f23323c = true;
        synchronized (this.f23321a) {
            FileHandle fileHandle = this.f23321a;
            i = fileHandle.f24699c;
            fileHandle.f24699c = i - 1;
            i2 = this.f23321a.f24699c;
            if (i2 == 0) {
                z = this.f23321a.f24698b;
                if (z) {
                    this.f23321a.protectedClose();
                }
            }
        }
    }

    @Override // okio.Sink, java.io.Flushable
    public final void flush() {
        if (!this.f23323c) {
            this.f23321a.protectedFlush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.Sink
    /* renamed from: timeout */
    public final Timeout getF24748a() {
        return Timeout.NONE;
    }

    @Override // okio.Sink
    public final void write(Buffer source, long j) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (!this.f23323c) {
            this.f23321a.m6662b(this.f23322b, source, j);
            this.f23322b += j;
            return;
        }
        throw new IllegalStateException("closed");
    }
}
