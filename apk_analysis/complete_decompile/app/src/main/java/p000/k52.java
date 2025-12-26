package p000;

import androidx.leanback.app.PlaybackFragmentGlueHost;
import androidx.leanback.media.PlaybackGlueHost;

/* loaded from: classes.dex */
public final class k52 extends PlaybackGlueHost.PlayerCallback {

    /* renamed from: a */
    public final /* synthetic */ PlaybackFragmentGlueHost f20752a;

    public k52(PlaybackFragmentGlueHost playbackFragmentGlueHost) {
        this.f20752a = playbackFragmentGlueHost;
    }

    @Override // androidx.leanback.media.PlaybackGlueHost.PlayerCallback
    public final void onBufferingStateChanged(boolean z) {
        this.f20752a.f5148b.onBufferingStateChanged(z);
    }

    @Override // androidx.leanback.media.PlaybackGlueHost.PlayerCallback
    public final void onError(int i, CharSequence charSequence) {
        this.f20752a.f5148b.onError(i, charSequence);
    }

    @Override // androidx.leanback.media.PlaybackGlueHost.PlayerCallback
    public final void onVideoSizeChanged(int i, int i2) {
        this.f20752a.f5148b.onVideoSizeChanged(i, i2);
    }
}
