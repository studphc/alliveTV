package p000;

import android.media.MediaPlayer;
import androidx.leanback.media.MediaPlayerGlue;

/* loaded from: classes.dex */
public final class bm1 implements MediaPlayer.OnBufferingUpdateListener {

    /* renamed from: a */
    public final /* synthetic */ MediaPlayerGlue f8084a;

    public bm1(MediaPlayerGlue mediaPlayerGlue) {
        this.f8084a = mediaPlayerGlue;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        MediaPlayerGlue mediaPlayerGlue = this.f8084a;
        if (mediaPlayerGlue.getControlsRow() == null) {
            return;
        }
        mediaPlayerGlue.getControlsRow().setBufferedProgress((int) ((i / 100.0f) * mediaPlayer.getDuration()));
    }
}
