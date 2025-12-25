package p000;

import androidx.leanback.media.PlaybackBaseControlGlue;
import androidx.leanback.widget.AbstractDetailsDescriptionPresenter;

/* loaded from: classes.dex */
public final class y52 extends AbstractDetailsDescriptionPresenter {
    @Override // androidx.leanback.widget.AbstractDetailsDescriptionPresenter
    public final void onBindDescription(AbstractDetailsDescriptionPresenter.ViewHolder viewHolder, Object obj) {
        PlaybackBaseControlGlue playbackBaseControlGlue = (PlaybackBaseControlGlue) obj;
        viewHolder.getTitle().setText(playbackBaseControlGlue.getTitle());
        viewHolder.getSubtitle().setText(playbackBaseControlGlue.getSubtitle());
    }
}
