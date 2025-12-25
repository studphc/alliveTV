package androidx.leanback.media;

import android.os.Handler;

/* renamed from: androidx.leanback.media.a */
/* loaded from: classes.dex */
public final class RunnableC0298a implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ MediaControllerAdapter f5465a;

    public RunnableC0298a(MediaControllerAdapter mediaControllerAdapter) {
        this.f5465a = mediaControllerAdapter;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MediaControllerAdapter mediaControllerAdapter = this.f5465a;
        mediaControllerAdapter.getCallback().onCurrentPositionChanged(mediaControllerAdapter);
        Handler handler = mediaControllerAdapter.f5379c;
        mediaControllerAdapter.getClass();
        handler.postDelayed(this, 16);
    }
}
