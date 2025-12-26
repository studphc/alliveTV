package androidx.leanback.widget;

import androidx.leanback.widget.PlaybackControlsRow;
import androidx.leanback.widget.PlaybackTransportRowPresenter;

/* renamed from: androidx.leanback.widget.k2 */
/* loaded from: classes.dex */
public final class C0355k2 extends PlaybackControlsRow.OnPlaybackProgressCallback {

    /* renamed from: a */
    public final /* synthetic */ PlaybackTransportRowPresenter.ViewHolder f6317a;

    public C0355k2(PlaybackTransportRowPresenter.ViewHolder viewHolder) {
        this.f6317a = viewHolder;
    }

    @Override // androidx.leanback.widget.PlaybackControlsRow.OnPlaybackProgressCallback
    public final void onBufferedPositionChanged(PlaybackControlsRow playbackControlsRow, long j) {
        this.f6317a.f6062u.setSecondaryProgress((int) ((j / r5.f6064w) * 2.147483647E9d));
    }

    @Override // androidx.leanback.widget.PlaybackControlsRow.OnPlaybackProgressCallback
    public final void onCurrentPositionChanged(PlaybackControlsRow playbackControlsRow, long j) {
        this.f6317a.m1474c(j);
    }

    @Override // androidx.leanback.widget.PlaybackControlsRow.OnPlaybackProgressCallback
    public final void onDurationChanged(PlaybackControlsRow playbackControlsRow, long j) {
        PlaybackTransportRowPresenter.ViewHolder viewHolder = this.f6317a;
        if (viewHolder.f6064w != j) {
            viewHolder.f6064w = j;
            viewHolder.onSetDurationLabel(j);
        }
    }
}
