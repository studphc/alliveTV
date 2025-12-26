package p000;

import androidx.leanback.media.PlaybackControlGlue;
import androidx.leanback.widget.PlaybackControlsRowPresenter;
import androidx.leanback.widget.RowPresenter;

/* loaded from: classes.dex */
public final class z42 extends PlaybackControlsRowPresenter {

    /* renamed from: o */
    public final /* synthetic */ PlaybackControlGlue f29245o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z42(PlaybackControlGlue playbackControlGlue, y42 y42Var) {
        super(y42Var);
        this.f29245o = playbackControlGlue;
    }

    @Override // androidx.leanback.widget.PlaybackControlsRowPresenter, androidx.leanback.widget.RowPresenter
    public final void onBindRowViewHolder(RowPresenter.ViewHolder viewHolder, Object obj) {
        super.onBindRowViewHolder(viewHolder, obj);
        viewHolder.setOnKeyListener(this.f29245o);
    }

    @Override // androidx.leanback.widget.PlaybackControlsRowPresenter, androidx.leanback.widget.RowPresenter
    public final void onUnbindRowViewHolder(RowPresenter.ViewHolder viewHolder) {
        super.onUnbindRowViewHolder(viewHolder);
        viewHolder.setOnKeyListener(null);
    }
}
