package androidx.leanback.widget;

import androidx.leanback.widget.PlaybackControlsRow;
import androidx.leanback.widget.PlaybackControlsRowPresenter;

/* renamed from: androidx.leanback.widget.f2 */
/* loaded from: classes.dex */
public final class C0335f2 extends PlaybackControlsRow.OnPlaybackProgressCallback {

    /* renamed from: a */
    public final /* synthetic */ PlaybackControlsRowPresenter.ViewHolder f6297a;

    public C0335f2(PlaybackControlsRowPresenter.ViewHolder viewHolder) {
        this.f6297a = viewHolder;
    }

    @Override // androidx.leanback.widget.PlaybackControlsRow.OnPlaybackProgressCallback
    public final void onBufferedPositionChanged(PlaybackControlsRow playbackControlsRow, long j) {
        PlaybackControlsRowPresenter.ViewHolder viewHolder = this.f6297a;
        C0314a2 c0314a2 = PlaybackControlsRowPresenter.this.f6008k;
        C0413z1 c0413z1 = viewHolder.f6028y;
        c0314a2.getClass();
        c0413z1.f6453q.setSecondaryProgress((int) ((j / c0413z1.f6455s) * 2.147483647E9d));
    }

    @Override // androidx.leanback.widget.PlaybackControlsRow.OnPlaybackProgressCallback
    public final void onCurrentPositionChanged(PlaybackControlsRow playbackControlsRow, long j) {
        PlaybackControlsRowPresenter.ViewHolder viewHolder = this.f6297a;
        C0314a2 c0314a2 = PlaybackControlsRowPresenter.this.f6008k;
        C0413z1 c0413z1 = viewHolder.f6028y;
        c0314a2.getClass();
        C0314a2.m1493c(c0413z1, j);
    }

    @Override // androidx.leanback.widget.PlaybackControlsRow.OnPlaybackProgressCallback
    public final void onDurationChanged(PlaybackControlsRow playbackControlsRow, long j) {
        PlaybackControlsRowPresenter.ViewHolder viewHolder = this.f6297a;
        C0314a2 c0314a2 = PlaybackControlsRowPresenter.this.f6008k;
        C0413z1 c0413z1 = viewHolder.f6028y;
        c0314a2.getClass();
        C0314a2.m1494d(c0413z1, j);
    }
}
