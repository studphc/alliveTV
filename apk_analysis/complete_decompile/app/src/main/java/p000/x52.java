package p000;

import androidx.leanback.app.PlaybackSupportFragmentGlueHost;
import androidx.leanback.media.PlaybackGlueHost;

/* loaded from: classes.dex */
public final class x52 extends PlaybackGlueHost.PlayerCallback {

    /* renamed from: a */
    public final /* synthetic */ PlaybackSupportFragmentGlueHost f28444a;

    public x52(PlaybackSupportFragmentGlueHost playbackSupportFragmentGlueHost) {
        this.f28444a = playbackSupportFragmentGlueHost;
    }

    @Override // androidx.leanback.media.PlaybackGlueHost.PlayerCallback
    public final void onBufferingStateChanged(boolean z) {
        this.f28444a.f5197b.onBufferingStateChanged(z);
    }

    @Override // androidx.leanback.media.PlaybackGlueHost.PlayerCallback
    public final void onError(int i, CharSequence charSequence) {
        this.f28444a.f5197b.onError(i, charSequence);
    }

    @Override // androidx.leanback.media.PlaybackGlueHost.PlayerCallback
    public final void onVideoSizeChanged(int i, int i2) {
        this.f28444a.f5197b.onVideoSizeChanged(i, i2);
    }
}
