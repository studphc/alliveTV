package androidx.leanback.media;

import android.media.MediaPlayer;
import androidx.leanback.media.PlaybackGlue;
import java.util.Iterator;
import java.util.List;

/* renamed from: androidx.leanback.media.i */
/* loaded from: classes.dex */
public final class C0306i implements MediaPlayer.OnPreparedListener {

    /* renamed from: a */
    public final /* synthetic */ MediaPlayerGlue f5473a;

    public C0306i(MediaPlayerGlue mediaPlayerGlue) {
        this.f5473a = mediaPlayerGlue;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        MediaPlayerGlue mediaPlayerGlue = this.f5473a;
        mediaPlayerGlue.f5409u = true;
        List<PlaybackGlue.PlayerCallback> playerCallbacks = mediaPlayerGlue.getPlayerCallbacks();
        if (playerCallbacks != null) {
            Iterator<PlaybackGlue.PlayerCallback> it = playerCallbacks.iterator();
            while (it.hasNext()) {
                it.next().onPreparedStateChanged(mediaPlayerGlue);
            }
        }
    }
}
