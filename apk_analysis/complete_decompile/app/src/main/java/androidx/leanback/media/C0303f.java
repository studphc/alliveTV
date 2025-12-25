package androidx.leanback.media;

import android.media.MediaPlayer;

/* renamed from: androidx.leanback.media.f */
/* loaded from: classes.dex */
public final class C0303f implements MediaPlayer.OnBufferingUpdateListener {

    /* renamed from: a */
    public final /* synthetic */ MediaPlayerAdapter f5470a;

    public C0303f(MediaPlayerAdapter mediaPlayerAdapter) {
        this.f5470a = mediaPlayerAdapter;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        MediaPlayerAdapter mediaPlayerAdapter = this.f5470a;
        mediaPlayerAdapter.f5393j = (mediaPlayerAdapter.getDuration() * i) / 100;
        mediaPlayerAdapter.getCallback().onBufferedPositionChanged(mediaPlayerAdapter);
    }
}
