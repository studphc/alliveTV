package androidx.leanback.media;

import android.media.MediaPlayer;

/* renamed from: androidx.leanback.media.e */
/* loaded from: classes.dex */
public final class C0302e implements MediaPlayer.OnCompletionListener {

    /* renamed from: a */
    public final /* synthetic */ MediaPlayerAdapter f5469a;

    public C0302e(MediaPlayerAdapter mediaPlayerAdapter) {
        this.f5469a = mediaPlayerAdapter;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        PlayerAdapter playerAdapter = this.f5469a;
        playerAdapter.getCallback().onPlayStateChanged(playerAdapter);
        playerAdapter.getCallback().onPlayCompleted(playerAdapter);
    }
}
