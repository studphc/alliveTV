package p000;

import com.google.android.exoplayer2.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: rc */
/* loaded from: classes.dex */
public final class C1756rc extends OutputStream {

    /* renamed from: a */
    public final FileOutputStream f25925a;

    /* renamed from: b */
    public boolean f25926b = false;

    public C1756rc(File file) {
        this.f25925a = new FileOutputStream(file);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        FileOutputStream fileOutputStream = this.f25925a;
        if (this.f25926b) {
            return;
        }
        this.f25926b = true;
        flush();
        try {
            fileOutputStream.getFD().sync();
        } catch (IOException e) {
            Log.m3028w("AtomicFile", "Failed to sync file descriptor:", e);
        }
        fileOutputStream.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
        this.f25925a.flush();
    }

    @Override // java.io.OutputStream
    public final void write(int i) {
        this.f25925a.write(i);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        this.f25925a.write(bArr);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) {
        this.f25925a.write(bArr, i, i2);
    }
}
