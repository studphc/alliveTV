package androidx.leanback.media;

import android.media.MediaPlayer;
import androidx.leanback.R;

/* renamed from: androidx.leanback.media.h */
/* loaded from: classes.dex */
public final class C0305h implements MediaPlayer.OnErrorListener {

    /* renamed from: a */
    public final /* synthetic */ MediaPlayerAdapter f5472a;

    public C0305h(MediaPlayerAdapter mediaPlayerAdapter) {
        this.f5472a = mediaPlayerAdapter;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        MediaPlayerAdapter mediaPlayerAdapter = this.f5472a;
        mediaPlayerAdapter.getCallback().onError(mediaPlayerAdapter, i, mediaPlayerAdapter.f5385b.getString(R.string.lb_media_player_error, Integer.valueOf(i), Integer.valueOf(i2)));
        return mediaPlayerAdapter.onError(i, i2);
    }
}
