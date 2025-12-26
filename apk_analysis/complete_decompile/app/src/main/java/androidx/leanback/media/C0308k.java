package androidx.leanback.media;

import androidx.leanback.media.PlaybackGlue;

/* renamed from: androidx.leanback.media.k */
/* loaded from: classes.dex */
public final class C0308k extends PlaybackGlue.PlayerCallback {

    /* renamed from: a */
    public final /* synthetic */ PlaybackGlue f5475a;

    public C0308k(PlaybackGlue playbackGlue) {
        this.f5475a = playbackGlue;
    }

    @Override // androidx.leanback.media.PlaybackGlue.PlayerCallback
    public final void onPreparedStateChanged(PlaybackGlue playbackGlue) {
        if (playbackGlue.isPrepared()) {
            PlaybackGlue playbackGlue2 = this.f5475a;
            playbackGlue2.removePlayerCallback(this);
            playbackGlue2.play();
        }
    }
}
