package p000;

import android.os.Bundle;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.leanback.media.MediaControllerGlue;

/* loaded from: classes.dex */
public final class kl1 extends MediaControllerCompat.Callback {

    /* renamed from: d */
    public final /* synthetic */ MediaControllerGlue f20890d;

    public kl1(MediaControllerGlue mediaControllerGlue) {
        this.f20890d = mediaControllerGlue;
    }

    @Override // android.support.v4.media.session.MediaControllerCompat.Callback
    public final void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
        this.f20890d.onMetadataChanged();
    }

    @Override // android.support.v4.media.session.MediaControllerCompat.Callback
    public final void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
        this.f20890d.onStateChanged();
    }

    @Override // android.support.v4.media.session.MediaControllerCompat.Callback
    public final void onSessionDestroyed() {
        this.f20890d.f5383q = null;
    }

    @Override // android.support.v4.media.session.MediaControllerCompat.Callback
    public final void onSessionEvent(String str, Bundle bundle) {
    }
}
