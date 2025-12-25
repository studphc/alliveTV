package p000;

import android.media.MediaPlayer;
import androidx.leanback.media.MediaPlayerGlue;

/* loaded from: classes.dex */
public final class am1 implements MediaPlayer.OnCompletionListener {

    /* renamed from: a */
    public final /* synthetic */ MediaPlayerGlue f258a;

    public am1(MediaPlayerGlue mediaPlayerGlue) {
        this.f258a = mediaPlayerGlue;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        this.f258a.play();
    }
}
