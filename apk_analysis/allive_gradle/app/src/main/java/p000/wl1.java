package p000;

import android.media.MediaPlayer;
import androidx.leanback.media.MediaPlayerAdapter;

/* loaded from: classes.dex */
public final class wl1 implements MediaPlayer.OnSeekCompleteListener {

    /* renamed from: a */
    public final /* synthetic */ MediaPlayerAdapter f28225a;

    public wl1(MediaPlayerAdapter mediaPlayerAdapter) {
        this.f28225a = mediaPlayerAdapter;
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public final void onSeekComplete(MediaPlayer mediaPlayer) {
        this.f28225a.onSeekComplete();
    }
}
