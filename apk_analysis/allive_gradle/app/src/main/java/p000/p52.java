package p000;

import androidx.leanback.app.PlaybackSupportFragment;
import androidx.leanback.widget.PlaybackSeekDataProvider;
import androidx.leanback.widget.PlaybackSeekUi;

/* loaded from: classes.dex */
public final class p52 extends PlaybackSeekUi.Client {

    /* renamed from: a */
    public final /* synthetic */ PlaybackSupportFragment f25044a;

    public p52(PlaybackSupportFragment playbackSupportFragment) {
        this.f25044a = playbackSupportFragment;
    }

    @Override // androidx.leanback.widget.PlaybackSeekUi.Client
    public final PlaybackSeekDataProvider getPlaybackSeekDataProvider() {
        PlaybackSeekUi.Client client = this.f25044a.f5176f0;
        if (client == null) {
            return null;
        }
        return client.getPlaybackSeekDataProvider();
    }

    @Override // androidx.leanback.widget.PlaybackSeekUi.Client
    public final boolean isSeekEnabled() {
        PlaybackSeekUi.Client client = this.f25044a.f5176f0;
        if (client == null) {
            return false;
        }
        return client.isSeekEnabled();
    }

    @Override // androidx.leanback.widget.PlaybackSeekUi.Client
    public final void onSeekFinished(boolean z) {
        PlaybackSupportFragment playbackSupportFragment = this.f25044a;
        PlaybackSeekUi.Client client = playbackSupportFragment.f5176f0;
        if (client != null) {
            client.onSeekFinished(z);
        }
        playbackSupportFragment.m1334q(false);
    }

    @Override // androidx.leanback.widget.PlaybackSeekUi.Client
    public final void onSeekPositionChanged(long j) {
        PlaybackSeekUi.Client client = this.f25044a.f5176f0;
        if (client != null) {
            client.onSeekPositionChanged(j);
        }
    }

    @Override // androidx.leanback.widget.PlaybackSeekUi.Client
    public final void onSeekStarted() {
        PlaybackSupportFragment playbackSupportFragment = this.f25044a;
        PlaybackSeekUi.Client client = playbackSupportFragment.f5176f0;
        if (client != null) {
            client.onSeekStarted();
        }
        playbackSupportFragment.m1334q(true);
    }
}
