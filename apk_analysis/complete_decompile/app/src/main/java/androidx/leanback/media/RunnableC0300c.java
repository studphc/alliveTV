package androidx.leanback.media;

/* renamed from: androidx.leanback.media.c */
/* loaded from: classes.dex */
public final class RunnableC0300c implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ MediaPlayerAdapter f5467a;

    public RunnableC0300c(MediaPlayerAdapter mediaPlayerAdapter) {
        this.f5467a = mediaPlayerAdapter;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MediaPlayerAdapter mediaPlayerAdapter = this.f5467a;
        mediaPlayerAdapter.getCallback().onCurrentPositionChanged(mediaPlayerAdapter);
        mediaPlayerAdapter.f5389f.postDelayed(this, mediaPlayerAdapter.getProgressUpdatingInterval());
    }
}
