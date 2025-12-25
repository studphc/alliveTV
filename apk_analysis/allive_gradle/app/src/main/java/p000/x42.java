package p000;

import androidx.leanback.media.PlaybackBannerControlGlue;
import androidx.leanback.widget.PlaybackControlsRowPresenter;
import androidx.leanback.widget.RowPresenter;

/* loaded from: classes.dex */
public final class x42 extends PlaybackControlsRowPresenter {

    /* renamed from: o */
    public final /* synthetic */ PlaybackBannerControlGlue f28439o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x42(PlaybackBannerControlGlue playbackBannerControlGlue, w42 w42Var) {
        super(w42Var);
        this.f28439o = playbackBannerControlGlue;
    }

    @Override // androidx.leanback.widget.PlaybackControlsRowPresenter, androidx.leanback.widget.RowPresenter
    public final void onBindRowViewHolder(RowPresenter.ViewHolder viewHolder, Object obj) {
        super.onBindRowViewHolder(viewHolder, obj);
        viewHolder.setOnKeyListener(this.f28439o);
    }

    @Override // androidx.leanback.widget.PlaybackControlsRowPresenter, androidx.leanback.widget.RowPresenter
    public final void onUnbindRowViewHolder(RowPresenter.ViewHolder viewHolder) {
        super.onUnbindRowViewHolder(viewHolder);
        viewHolder.setOnKeyListener(null);
    }
}
