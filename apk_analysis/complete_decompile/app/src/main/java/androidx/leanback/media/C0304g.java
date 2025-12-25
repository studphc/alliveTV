package androidx.leanback.media;

import android.media.MediaPlayer;

/* renamed from: androidx.leanback.media.g */
/* loaded from: classes.dex */
public final class C0304g implements MediaPlayer.OnVideoSizeChangedListener {

    /* renamed from: a */
    public final /* synthetic */ MediaPlayerAdapter f5471a;

    public C0304g(MediaPlayerAdapter mediaPlayerAdapter) {
        this.f5471a = mediaPlayerAdapter;
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        PlayerAdapter playerAdapter = this.f5471a;
        playerAdapter.getCallback().onVideoSizeChanged(playerAdapter, i, i2);
    }
}
