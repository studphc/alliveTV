package androidx.leanback.media;

import androidx.leanback.media.PlaybackGlueHost;
import androidx.leanback.media.PlayerAdapter;

/* renamed from: androidx.leanback.media.j */
/* loaded from: classes.dex */
public final class C0307j extends PlayerAdapter.Callback {

    /* renamed from: a */
    public final /* synthetic */ PlaybackBaseControlGlue f5474a;

    public C0307j(PlaybackBaseControlGlue playbackBaseControlGlue) {
        this.f5474a = playbackBaseControlGlue;
    }

    @Override // androidx.leanback.media.PlayerAdapter.Callback
    public final void onBufferedPositionChanged(PlayerAdapter playerAdapter) {
        this.f5474a.onUpdateBufferedProgress();
    }

    @Override // androidx.leanback.media.PlayerAdapter.Callback
    public final void onBufferingStateChanged(PlayerAdapter playerAdapter, boolean z) {
        PlaybackBaseControlGlue playbackBaseControlGlue = this.f5474a;
        playbackBaseControlGlue.f5436n = z;
        PlaybackGlueHost.PlayerCallback playerCallback = playbackBaseControlGlue.f5435m;
        if (playerCallback != null) {
            playerCallback.onBufferingStateChanged(z);
        }
    }

    @Override // androidx.leanback.media.PlayerAdapter.Callback
    public final void onCurrentPositionChanged(PlayerAdapter playerAdapter) {
        this.f5474a.onUpdateProgress();
    }

    @Override // androidx.leanback.media.PlayerAdapter.Callback
    public final void onDurationChanged(PlayerAdapter playerAdapter) {
        this.f5474a.onUpdateDuration();
    }

    @Override // androidx.leanback.media.PlayerAdapter.Callback
    public final void onError(PlayerAdapter playerAdapter, int i, String str) {
        PlaybackBaseControlGlue playbackBaseControlGlue = this.f5474a;
        playbackBaseControlGlue.f5439q = true;
        playbackBaseControlGlue.f5440r = i;
        playbackBaseControlGlue.f5441s = str;
        PlaybackGlueHost.PlayerCallback playerCallback = playbackBaseControlGlue.f5435m;
        if (playerCallback != null) {
            playerCallback.onError(i, str);
        }
    }

    @Override // androidx.leanback.media.PlayerAdapter.Callback
    public final void onMetadataChanged(PlayerAdapter playerAdapter) {
        this.f5474a.onMetadataChanged();
    }

    @Override // androidx.leanback.media.PlayerAdapter.Callback
    public final void onPlayCompleted(PlayerAdapter playerAdapter) {
        this.f5474a.onPlayCompleted();
    }

    @Override // androidx.leanback.media.PlayerAdapter.Callback
    public final void onPlayStateChanged(PlayerAdapter playerAdapter) {
        this.f5474a.onPlayStateChanged();
    }

    @Override // androidx.leanback.media.PlayerAdapter.Callback
    public final void onPreparedStateChanged(PlayerAdapter playerAdapter) {
        this.f5474a.onPreparedStateChanged();
    }

    @Override // androidx.leanback.media.PlayerAdapter.Callback
    public final void onVideoSizeChanged(PlayerAdapter playerAdapter, int i, int i2) {
        PlaybackBaseControlGlue playbackBaseControlGlue = this.f5474a;
        playbackBaseControlGlue.f5437o = i;
        playbackBaseControlGlue.f5438p = i2;
        PlaybackGlueHost.PlayerCallback playerCallback = playbackBaseControlGlue.f5435m;
        if (playerCallback != null) {
            playerCallback.onVideoSizeChanged(i, i2);
        }
    }
}
