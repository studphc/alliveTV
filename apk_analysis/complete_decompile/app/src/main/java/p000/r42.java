package p000;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.EGLSurfaceTexture;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.video.PlaceholderSurface;

/* loaded from: classes.dex */
public final class r42 extends HandlerThread implements Handler.Callback {

    /* renamed from: a */
    public EGLSurfaceTexture f25865a;

    /* renamed from: b */
    public Handler f25866b;

    /* renamed from: c */
    public Error f25867c;

    /* renamed from: d */
    public RuntimeException f25868d;

    /* renamed from: e */
    public PlaceholderSurface f25869e;

    /* renamed from: a */
    public final void m7219a(int i) {
        boolean z;
        Assertions.checkNotNull(this.f25865a);
        this.f25865a.init(i);
        SurfaceTexture surfaceTexture = this.f25865a.getSurfaceTexture();
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f25869e = new PlaceholderSurface(this, surfaceTexture, z);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        try {
            if (i != 1) {
                if (i != 2) {
                    return true;
                }
                try {
                    Assertions.checkNotNull(this.f25865a);
                    this.f25865a.release();
                } finally {
                    try {
                        return true;
                    } finally {
                    }
                }
                return true;
            }
            try {
                m7219a(message.arg1);
                synchronized (this) {
                    notify();
                }
            } catch (Error e) {
                Log.m3024e("PlaceholderSurface", "Failed to initialize placeholder surface", e);
                this.f25867c = e;
                synchronized (this) {
                    notify();
                }
            } catch (RuntimeException e2) {
                Log.m3024e("PlaceholderSurface", "Failed to initialize placeholder surface", e2);
                this.f25868d = e2;
                synchronized (this) {
                    notify();
                }
            }
            return true;
        } catch (Throwable th) {
            synchronized (this) {
                notify();
                throw th;
            }
        }
    }
}
