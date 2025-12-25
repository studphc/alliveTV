package com.google.android.exoplayer2.upstream;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.TraceUtil;
import java.io.IOException;

/* renamed from: com.google.android.exoplayer2.upstream.b */
/* loaded from: classes.dex */
public final class HandlerC0734b extends Handler implements Runnable {

    /* renamed from: a */
    public final int f12569a;

    /* renamed from: b */
    public final Loader.Loadable f12570b;

    /* renamed from: c */
    public final long f12571c;

    /* renamed from: d */
    public Loader.Callback f12572d;

    /* renamed from: e */
    public IOException f12573e;

    /* renamed from: f */
    public int f12574f;

    /* renamed from: g */
    public Thread f12575g;

    /* renamed from: h */
    public boolean f12576h;

    /* renamed from: i */
    public volatile boolean f12577i;

    /* renamed from: j */
    public final /* synthetic */ Loader f12578j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC0734b(Loader loader, Looper looper, Loader.Loadable loadable, Loader.Callback callback, int i, long j) {
        super(looper);
        this.f12578j = loader;
        this.f12570b = loadable;
        this.f12572d = callback;
        this.f12569a = i;
        this.f12571c = j;
    }

    /* renamed from: a */
    public final void m2989a(boolean z) {
        this.f12577i = z;
        this.f12573e = null;
        if (hasMessages(0)) {
            this.f12576h = true;
            removeMessages(0);
            if (!z) {
                sendEmptyMessage(1);
            }
        } else {
            synchronized (this) {
                try {
                    this.f12576h = true;
                    this.f12570b.cancelLoad();
                    Thread thread = this.f12575g;
                    if (thread != null) {
                        thread.interrupt();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (z) {
            this.f12578j.f12512b = null;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            ((Loader.Callback) Assertions.checkNotNull(this.f12572d)).onLoadCanceled(this.f12570b, elapsedRealtime, elapsedRealtime - this.f12571c, true);
            this.f12572d = null;
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.f12577i) {
            return;
        }
        int i = message.what;
        if (i == 0) {
            this.f12573e = null;
            Loader loader = this.f12578j;
            loader.f12511a.execute((Runnable) Assertions.checkNotNull(loader.f12512b));
            return;
        }
        if (i != 3) {
            this.f12578j.f12512b = null;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = elapsedRealtime - this.f12571c;
            Loader.Callback callback = (Loader.Callback) Assertions.checkNotNull(this.f12572d);
            if (this.f12576h) {
                callback.onLoadCanceled(this.f12570b, elapsedRealtime, j, false);
                return;
            }
            int i2 = message.what;
            boolean z = true;
            if (i2 != 1) {
                if (i2 == 2) {
                    IOException iOException = (IOException) message.obj;
                    this.f12573e = iOException;
                    int i3 = this.f12574f + 1;
                    this.f12574f = i3;
                    Loader.LoadErrorAction onLoadError = callback.onLoadError(this.f12570b, elapsedRealtime, j, iOException, i3);
                    int i4 = onLoadError.f12514a;
                    if (i4 == 3) {
                        this.f12578j.f12513c = this.f12573e;
                        return;
                    }
                    if (i4 != 2) {
                        if (i4 == 1) {
                            this.f12574f = 1;
                        }
                        long j2 = onLoadError.f12515b;
                        if (j2 == C0643C.TIME_UNSET) {
                            j2 = Math.min((this.f12574f - 1) * 1000, 5000);
                        }
                        Loader loader2 = this.f12578j;
                        if (loader2.f12512b != null) {
                            z = false;
                        }
                        Assertions.checkState(z);
                        loader2.f12512b = this;
                        if (j2 > 0) {
                            sendEmptyMessageDelayed(0, j2);
                            return;
                        } else {
                            this.f12573e = null;
                            loader2.f12511a.execute((Runnable) Assertions.checkNotNull(this));
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            try {
                callback.onLoadCompleted(this.f12570b, elapsedRealtime, j);
                return;
            } catch (RuntimeException e) {
                Log.m3024e("LoadTask", "Unexpected exception handling load completed", e);
                this.f12578j.f12513c = new Loader.UnexpectedLoaderException(e);
                return;
            }
        }
        throw ((Error) message.obj);
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        try {
            synchronized (this) {
                z = this.f12576h;
                this.f12575g = Thread.currentThread();
            }
            if (!z) {
                TraceUtil.beginSection("load:".concat(this.f12570b.getClass().getSimpleName()));
                try {
                    this.f12570b.load();
                    TraceUtil.endSection();
                } catch (Throwable th) {
                    TraceUtil.endSection();
                    throw th;
                }
            }
            synchronized (this) {
                this.f12575g = null;
                Thread.interrupted();
            }
            if (!this.f12577i) {
                sendEmptyMessage(1);
            }
        } catch (IOException e) {
            if (!this.f12577i) {
                obtainMessage(2, e).sendToTarget();
            }
        } catch (Exception e2) {
            if (!this.f12577i) {
                Log.m3024e("LoadTask", "Unexpected exception loading stream", e2);
                obtainMessage(2, new Loader.UnexpectedLoaderException(e2)).sendToTarget();
            }
        } catch (OutOfMemoryError e3) {
            if (!this.f12577i) {
                Log.m3024e("LoadTask", "OutOfMemory error loading stream", e3);
                obtainMessage(2, new Loader.UnexpectedLoaderException(e3)).sendToTarget();
            }
        } catch (Error e4) {
            if (!this.f12577i) {
                Log.m3024e("LoadTask", "Unexpected error loading stream", e4);
                obtainMessage(3, e4).sendToTarget();
            }
            throw e4;
        }
    }
}
