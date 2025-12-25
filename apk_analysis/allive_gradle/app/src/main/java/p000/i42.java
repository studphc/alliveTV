package p000;

import android.app.PendingIntent;
import java.io.Closeable;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes.dex */
public final class i42 implements Closeable {

    /* renamed from: b */
    public PendingIntent.OnFinished f18283b;

    /* renamed from: a */
    public final CountDownLatch f18282a = new CountDownLatch(1);

    /* renamed from: c */
    public boolean f18284c = false;

    public i42(PendingIntent.OnFinished onFinished) {
        this.f18283b = onFinished;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (!this.f18284c) {
            this.f18283b = null;
        }
        this.f18282a.countDown();
    }
}
