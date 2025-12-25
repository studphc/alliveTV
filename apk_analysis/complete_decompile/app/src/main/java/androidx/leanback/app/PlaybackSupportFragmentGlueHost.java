package androidx.leanback.app;

import android.view.View;
import androidx.leanback.media.PlaybackGlueHost;
import androidx.leanback.widget.OnActionClickedListener;
import androidx.leanback.widget.PlaybackRowPresenter;
import androidx.leanback.widget.PlaybackSeekUi;
import androidx.leanback.widget.Row;
import p000.w52;
import p000.x52;

/* loaded from: classes.dex */
public class PlaybackSupportFragmentGlueHost extends PlaybackGlueHost implements PlaybackSeekUi {

    /* renamed from: b */
    public final PlaybackSupportFragment f5197b;

    /* renamed from: c */
    public final x52 f5198c = new x52(this);

    public PlaybackSupportFragmentGlueHost(PlaybackSupportFragment playbackSupportFragment) {
        this.f5197b = playbackSupportFragment;
    }

    @Override // androidx.leanback.media.PlaybackGlueHost
    public void fadeOut() {
        this.f5197b.fadeOut();
    }

    @Override // androidx.leanback.media.PlaybackGlueHost
    public PlaybackGlueHost.PlayerCallback getPlayerCallback() {
        return this.f5198c;
    }

    @Override // androidx.leanback.media.PlaybackGlueHost
    public void hideControlsOverlay(boolean z) {
        this.f5197b.hideControlsOverlay(z);
    }

    @Override // androidx.leanback.media.PlaybackGlueHost
    public boolean isControlsOverlayAutoHideEnabled() {
        return this.f5197b.isControlsOverlayAutoHideEnabled();
    }

    @Override // androidx.leanback.media.PlaybackGlueHost
    public boolean isControlsOverlayVisible() {
        return this.f5197b.isControlsOverlayVisible();
    }

    @Override // androidx.leanback.media.PlaybackGlueHost
    public void notifyPlaybackRowChanged() {
        this.f5197b.notifyPlaybackRowChanged();
    }

    @Override // androidx.leanback.media.PlaybackGlueHost
    public void setControlsOverlayAutoHideEnabled(boolean z) {
        this.f5197b.setControlsOverlayAutoHideEnabled(z);
    }

    @Override // androidx.leanback.media.PlaybackGlueHost
    public void setHostCallback(PlaybackGlueHost.HostCallback hostCallback) {
        this.f5197b.setHostCallback(hostCallback);
    }

    @Override // androidx.leanback.media.PlaybackGlueHost
    public void setOnActionClickedListener(OnActionClickedListener onActionClickedListener) {
        PlaybackSupportFragment playbackSupportFragment = this.f5197b;
        if (onActionClickedListener == null) {
            playbackSupportFragment.setOnPlaybackItemViewClickedListener(null);
        } else {
            playbackSupportFragment.setOnPlaybackItemViewClickedListener(new w52(onActionClickedListener));
        }
    }

    @Override // androidx.leanback.media.PlaybackGlueHost
    public void setOnKeyInterceptListener(View.OnKeyListener onKeyListener) {
        this.f5197b.setOnKeyInterceptListener(onKeyListener);
    }

    @Override // androidx.leanback.media.PlaybackGlueHost
    public void setPlaybackRow(Row row) {
        this.f5197b.setPlaybackRow(row);
    }

    @Override // androidx.leanback.media.PlaybackGlueHost
    public void setPlaybackRowPresenter(PlaybackRowPresenter playbackRowPresenter) {
        this.f5197b.setPlaybackRowPresenter(playbackRowPresenter);
    }

    @Override // androidx.leanback.widget.PlaybackSeekUi
    public void setPlaybackSeekUiClient(PlaybackSeekUi.Client client) {
        this.f5197b.setPlaybackSeekUiClient(client);
    }

    @Override // androidx.leanback.media.PlaybackGlueHost
    public void showControlsOverlay(boolean z) {
        this.f5197b.showControlsOverlay(z);
    }
}
