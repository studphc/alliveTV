package p000;

import androidx.leanback.media.PlaybackTransportControlGlue;
import androidx.leanback.widget.PlaybackControlsRow;
import androidx.leanback.widget.PlaybackSeekDataProvider;
import androidx.leanback.widget.PlaybackSeekUi;

/* loaded from: classes.dex */
public final class a62 extends PlaybackSeekUi.Client {

    /* renamed from: a */
    public boolean f56a;

    /* renamed from: b */
    public long f57b;

    /* renamed from: c */
    public long f58c;

    /* renamed from: d */
    public boolean f59d;

    /* renamed from: e */
    public final /* synthetic */ PlaybackTransportControlGlue f60e;

    public a62(PlaybackTransportControlGlue playbackTransportControlGlue) {
        this.f60e = playbackTransportControlGlue;
    }

    @Override // androidx.leanback.widget.PlaybackSeekUi.Client
    public final PlaybackSeekDataProvider getPlaybackSeekDataProvider() {
        return this.f60e.f5460t;
    }

    @Override // androidx.leanback.widget.PlaybackSeekUi.Client
    public final boolean isSeekEnabled() {
        PlaybackTransportControlGlue playbackTransportControlGlue = this.f60e;
        if (playbackTransportControlGlue.f5460t == null && !playbackTransportControlGlue.f5461u) {
            return false;
        }
        return true;
    }

    @Override // androidx.leanback.widget.PlaybackSeekUi.Client
    public final void onSeekFinished(boolean z) {
        PlaybackTransportControlGlue playbackTransportControlGlue = this.f60e;
        if (!z) {
            long j = this.f58c;
            if (j >= 0) {
                playbackTransportControlGlue.seekTo(j);
            }
        } else {
            long j2 = this.f57b;
            if (j2 >= 0) {
                playbackTransportControlGlue.seekTo(j2);
            }
        }
        this.f59d = false;
        if (!this.f56a) {
            playbackTransportControlGlue.play();
        } else {
            playbackTransportControlGlue.f5426d.setProgressUpdatingEnabled(false);
            playbackTransportControlGlue.onUpdateProgress();
        }
    }

    @Override // androidx.leanback.widget.PlaybackSeekUi.Client
    public final void onSeekPositionChanged(long j) {
        PlaybackTransportControlGlue playbackTransportControlGlue = this.f60e;
        if (playbackTransportControlGlue.f5460t == null) {
            playbackTransportControlGlue.f5426d.seekTo(j);
        } else {
            this.f58c = j;
        }
        PlaybackControlsRow playbackControlsRow = playbackTransportControlGlue.f5427e;
        if (playbackControlsRow != null) {
            playbackControlsRow.setCurrentPosition(j);
        }
    }

    @Override // androidx.leanback.widget.PlaybackSeekUi.Client
    public final void onSeekStarted() {
        long j;
        this.f59d = true;
        PlaybackTransportControlGlue playbackTransportControlGlue = this.f60e;
        this.f56a = !playbackTransportControlGlue.isPlaying();
        playbackTransportControlGlue.f5426d.setProgressUpdatingEnabled(true);
        if (playbackTransportControlGlue.f5460t == null) {
            j = playbackTransportControlGlue.f5426d.getCurrentPosition();
        } else {
            j = -1;
        }
        this.f57b = j;
        this.f58c = -1L;
        playbackTransportControlGlue.pause();
    }
}
