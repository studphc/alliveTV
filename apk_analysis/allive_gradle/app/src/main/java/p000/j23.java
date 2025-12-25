package p000;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public final class j23 implements Choreographer.FrameCallback, Handler.Callback {

    /* renamed from: e */
    public static final j23 f20354e = new j23();

    /* renamed from: a */
    public volatile long f20355a = C0643C.TIME_UNSET;

    /* renamed from: b */
    public final Handler f20356b;

    /* renamed from: c */
    public Choreographer f20357c;

    /* renamed from: d */
    public int f20358d;

    public j23() {
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
        handlerThread.start();
        Handler createHandler = Util.createHandler(handlerThread.getLooper(), this);
        this.f20356b = createHandler;
        createHandler.sendEmptyMessage(0);
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        this.f20355a = j;
        ((Choreographer) Assertions.checkNotNull(this.f20357c)).postFrameCallbackDelayed(this, 500L);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return false;
                }
                Choreographer choreographer = this.f20357c;
                if (choreographer != null) {
                    int i2 = this.f20358d - 1;
                    this.f20358d = i2;
                    if (i2 == 0) {
                        choreographer.removeFrameCallback(this);
                        this.f20355a = C0643C.TIME_UNSET;
                    }
                }
                return true;
            }
            Choreographer choreographer2 = this.f20357c;
            if (choreographer2 != null) {
                int i3 = this.f20358d + 1;
                this.f20358d = i3;
                if (i3 == 1) {
                    choreographer2.postFrameCallback(this);
                }
            }
            return true;
        }
        try {
            this.f20357c = Choreographer.getInstance();
        } catch (RuntimeException e) {
            Log.m3028w("VideoFrameReleaseHelper", "Vsync sampling disabled due to platform error", e);
        }
        return true;
    }
}
