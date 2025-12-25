package androidx.leanback.app;

import android.view.View;
import androidx.leanback.media.PlaybackGlueHost;
import androidx.leanback.widget.OnActionClickedListener;
import androidx.leanback.widget.PlaybackRowPresenter;
import androidx.leanback.widget.PlaybackSeekUi;
import androidx.leanback.widget.Row;
import p000.j52;
import p000.k52;

@Deprecated
/* loaded from: classes.dex */
public class PlaybackFragmentGlueHost extends PlaybackGlueHost implements PlaybackSeekUi {

    /* renamed from: b */
    public final PlaybackFragment f5148b;

    /* renamed from: c */
    public final k52 f5149c = new k52(this);

    public PlaybackFragmentGlueHost(PlaybackFragment playbackFragment) {
        this.f5148b = playbackFragment;
    }

    @Override // androidx.leanback.media.PlaybackGlueHost
    public void fadeOut() {
        this.f5148b.fadeOut();
    }

    @Override // androidx.leanback.media.PlaybackGlueHost
    public PlaybackGlueHost.PlayerCallback getPlayerCallback() {
        return this.f5149c;
    }

    @Override // androidx.leanback.media.PlaybackGlueHost
    public void hideControlsOverlay(boolean z) {
        this.f5148b.hideControlsOverlay(z);
    }

    @Override // androidx.leanback.media.PlaybackGlueHost
    public boolean isControlsOverlayAutoHideEnabled() {
        return this.f5148b.isControlsOverlayAutoHideEnabled();
    }

    @Override // androidx.leanback.media.PlaybackGlueHost
    public boolean isControlsOverlayVisible() {
        return this.f5148b.isControlsOverlayVisible();
    }

    @Override // androidx.leanback.media.PlaybackGlueHost
    public void notifyPlaybackRowChanged() {
        this.f5148b.notifyPlaybackRowChanged();
    }

    @Override // androidx.leanback.media.PlaybackGlueHost
    public void setControlsOverlayAutoHideEnabled(boolean z) {
        this.f5148b.setControlsOverlayAutoHideEnabled(z);
    }

    @Override // androidx.leanback.media.PlaybackGlueHost
    public void setHostCallback(PlaybackGlueHost.HostCallback hostCallback) {
        this.f5148b.setHostCallback(hostCallback);
    }

    @Override // androidx.leanback.media.PlaybackGlueHost
    public void setOnActionClickedListener(OnActionClickedListener onActionClickedListener) {
        PlaybackFragment playbackFragment = this.f5148b;
        if (onActionClickedListener == null) {
            playbackFragment.setOnPlaybackItemViewClickedListener(null);
        } else {
            playbackFragment.setOnPlaybackItemViewClickedListener(new j52(onActionClickedListener));
        }
    }

    @Override // androidx.leanback.media.PlaybackGlueHost
    public void setOnKeyInterceptListener(View.OnKeyListener onKeyListener) {
        this.f5148b.setOnKeyInterceptListener(onKeyListener);
    }

    @Override // androidx.leanback.media.PlaybackGlueHost
    public void setPlaybackRow(Row row) {
        this.f5148b.setPlaybackRow(row);
    }

    @Override // androidx.leanback.media.PlaybackGlueHost
    public void setPlaybackRowPresenter(PlaybackRowPresenter playbackRowPresenter) {
        this.f5148b.setPlaybackRowPresenter(playbackRowPresenter);
    }

    @Override // androidx.leanback.widget.PlaybackSeekUi
    public void setPlaybackSeekUiClient(PlaybackSeekUi.Client client) {
        this.f5148b.setPlaybackSeekUiClient(client);
    }

    @Override // androidx.leanback.media.PlaybackGlueHost
    public void showControlsOverlay(boolean z) {
        this.f5148b.showControlsOverlay(z);
    }
}
