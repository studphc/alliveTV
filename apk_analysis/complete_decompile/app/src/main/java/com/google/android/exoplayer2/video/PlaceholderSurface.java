package com.google.android.exoplayer2.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.EGLSurfaceTexture;
import com.google.android.exoplayer2.util.GlUtil;
import p000.r42;

@RequiresApi(17)
/* loaded from: classes.dex */
public final class PlaceholderSurface extends Surface {

    /* renamed from: c */
    public static int f12866c;

    /* renamed from: d */
    public static boolean f12867d;

    /* renamed from: a */
    public final r42 f12868a;

    /* renamed from: b */
    public boolean f12869b;
    public final boolean secure;

    public PlaceholderSurface(r42 r42Var, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.f12868a = r42Var;
        this.secure = z;
    }

    public static synchronized boolean isSecureSupported(Context context) {
        boolean z;
        int i;
        synchronized (PlaceholderSurface.class) {
            try {
                z = false;
                if (!f12867d) {
                    if (GlUtil.isProtectedContentExtensionSupported(context)) {
                        if (GlUtil.isSurfacelessContextExtensionSupported()) {
                            i = 1;
                        } else {
                            i = 2;
                        }
                    } else {
                        i = 0;
                    }
                    f12866c = i;
                    f12867d = true;
                }
                if (f12866c != 0) {
                    z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [r42, android.os.HandlerThread, java.lang.Thread, android.os.Handler$Callback, java.lang.Object] */
    public static PlaceholderSurface newInstanceV17(Context context, boolean z) {
        boolean z2;
        int i;
        boolean z3 = false;
        if (z && !isSecureSupported(context)) {
            z2 = false;
        } else {
            z2 = true;
        }
        Assertions.checkState(z2);
        ?? handlerThread = new HandlerThread("ExoPlayer:PlaceholderSurface");
        if (z) {
            i = f12866c;
        } else {
            i = 0;
        }
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper(), handlerThread);
        handlerThread.f25866b = handler;
        handlerThread.f25865a = new EGLSurfaceTexture(handler);
        synchronized (handlerThread) {
            handlerThread.f25866b.obtainMessage(1, i, 0).sendToTarget();
            while (handlerThread.f25869e == null && handlerThread.f25868d == null && handlerThread.f25867c == null) {
                try {
                    handlerThread.wait();
                } catch (InterruptedException unused) {
                    z3 = true;
                }
            }
        }
        if (z3) {
            Thread.currentThread().interrupt();
        }
        RuntimeException runtimeException = handlerThread.f25868d;
        if (runtimeException == null) {
            Error error = handlerThread.f25867c;
            if (error == null) {
                return (PlaceholderSurface) Assertions.checkNotNull(handlerThread.f25869e);
            }
            throw error;
        }
        throw runtimeException;
    }

    @Override // android.view.Surface
    public void release() {
        super.release();
        synchronized (this.f12868a) {
            try {
                if (!this.f12869b) {
                    r42 r42Var = this.f12868a;
                    Assertions.checkNotNull(r42Var.f25866b);
                    r42Var.f25866b.sendEmptyMessage(2);
                    this.f12869b = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
