package p000;

import androidx.leanback.media.PlaybackTransportControlGlue;
import androidx.leanback.widget.PlaybackTransportRowPresenter;
import androidx.leanback.widget.RowPresenter;

/* loaded from: classes.dex */
public final class z52 extends PlaybackTransportRowPresenter {

    /* renamed from: n */
    public final /* synthetic */ PlaybackTransportControlGlue f29252n;

    public z52(PlaybackTransportControlGlue playbackTransportControlGlue) {
        this.f29252n = playbackTransportControlGlue;
    }

    @Override // androidx.leanback.widget.PlaybackTransportRowPresenter, androidx.leanback.widget.RowPresenter
    public final void onBindRowViewHolder(RowPresenter.ViewHolder viewHolder, Object obj) {
        super.onBindRowViewHolder(viewHolder, obj);
        viewHolder.setOnKeyListener(this.f29252n);
    }

    @Override // androidx.leanback.widget.PlaybackTransportRowPresenter, androidx.leanback.widget.RowPresenter
    public final void onUnbindRowViewHolder(RowPresenter.ViewHolder viewHolder) {
        super.onUnbindRowViewHolder(viewHolder);
        viewHolder.setOnKeyListener(null);
    }
}
