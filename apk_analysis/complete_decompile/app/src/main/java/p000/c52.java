package p000;

import androidx.leanback.app.PlaybackFragment;
import androidx.leanback.widget.PlaybackSeekDataProvider;
import androidx.leanback.widget.PlaybackSeekUi;

/* loaded from: classes.dex */
public final class c52 extends PlaybackSeekUi.Client {

    /* renamed from: a */
    public final /* synthetic */ PlaybackFragment f8254a;

    public c52(PlaybackFragment playbackFragment) {
        this.f8254a = playbackFragment;
    }

    @Override // androidx.leanback.widget.PlaybackSeekUi.Client
    public final PlaybackSeekDataProvider getPlaybackSeekDataProvider() {
        PlaybackSeekUi.Client client = this.f8254a.f5123b;
        if (client == null) {
            return null;
        }
        return client.getPlaybackSeekDataProvider();
    }

    @Override // androidx.leanback.widget.PlaybackSeekUi.Client
    public final boolean isSeekEnabled() {
        PlaybackSeekUi.Client client = this.f8254a.f5123b;
        if (client == null) {
            return false;
        }
        return client.isSeekEnabled();
    }

    @Override // androidx.leanback.widget.PlaybackSeekUi.Client
    public final void onSeekFinished(boolean z) {
        PlaybackFragment playbackFragment = this.f8254a;
        PlaybackSeekUi.Client client = playbackFragment.f5123b;
        if (client != null) {
            client.onSeekFinished(z);
        }
        playbackFragment.m1324g(false);
    }

    @Override // androidx.leanback.widget.PlaybackSeekUi.Client
    public final void onSeekPositionChanged(long j) {
        PlaybackSeekUi.Client client = this.f8254a.f5123b;
        if (client != null) {
            client.onSeekPositionChanged(j);
        }
    }

    @Override // androidx.leanback.widget.PlaybackSeekUi.Client
    public final void onSeekStarted() {
        PlaybackFragment playbackFragment = this.f8254a;
        PlaybackSeekUi.Client client = playbackFragment.f5123b;
        if (client != null) {
            client.onSeekStarted();
        }
        playbackFragment.m1324g(true);
    }
}
