package androidx.leanback.media;

import android.media.MediaPlayer;

/* renamed from: androidx.leanback.media.d */
/* loaded from: classes.dex */
public final class C0301d implements MediaPlayer.OnPreparedListener {

    /* renamed from: a */
    public final /* synthetic */ MediaPlayerAdapter f5468a;

    public C0301d(MediaPlayerAdapter mediaPlayerAdapter) {
        this.f5468a = mediaPlayerAdapter;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        MediaPlayerAdapter mediaPlayerAdapter = this.f5468a;
        mediaPlayerAdapter.f5390g = true;
        mediaPlayerAdapter.m1356a();
        if (mediaPlayerAdapter.f5387d == null || mediaPlayerAdapter.f5392i) {
            mediaPlayerAdapter.getCallback().onPreparedStateChanged(mediaPlayerAdapter);
        }
    }
}
