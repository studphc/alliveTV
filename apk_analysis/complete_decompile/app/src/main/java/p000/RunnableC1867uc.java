package p000;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.google.android.exoplayer2.SurfaceHolderCallbackC0644a;

/* renamed from: uc */
/* loaded from: classes.dex */
public final class RunnableC1867uc extends BroadcastReceiver implements Runnable {

    /* renamed from: a */
    public final SurfaceHolderCallbackC0644a f27217a;

    /* renamed from: b */
    public final Handler f27218b;

    /* renamed from: c */
    public final /* synthetic */ C1904vc f27219c;

    public RunnableC1867uc(C1904vc c1904vc, Handler handler, SurfaceHolderCallbackC0644a surfaceHolderCallbackC0644a) {
        this.f27219c = c1904vc;
        this.f27218b = handler;
        this.f27217a = surfaceHolderCallbackC0644a;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
            this.f27218b.post(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f27219c.f27734a) {
            this.f27217a.onAudioBecomingNoisy();
        }
    }
}
