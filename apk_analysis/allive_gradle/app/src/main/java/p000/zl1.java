package p000;

import android.media.MediaPlayer;
import androidx.leanback.media.MediaPlayerGlue;

/* loaded from: classes.dex */
public final class zl1 implements MediaPlayer.OnCompletionListener {

    /* renamed from: a */
    public boolean f29426a;

    /* renamed from: b */
    public final /* synthetic */ MediaPlayerGlue f29427b;

    public zl1(MediaPlayerGlue mediaPlayerGlue) {
        this.f29427b = mediaPlayerGlue;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        if (!this.f29426a) {
            this.f29426a = true;
            mediaPlayer.setOnCompletionListener(null);
        }
        this.f29427b.play();
    }
}
