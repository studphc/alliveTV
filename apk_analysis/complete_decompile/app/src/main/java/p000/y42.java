package p000;

import androidx.leanback.media.PlaybackControlGlue;
import androidx.leanback.widget.AbstractDetailsDescriptionPresenter;

/* loaded from: classes.dex */
public final class y42 extends AbstractDetailsDescriptionPresenter {
    @Override // androidx.leanback.widget.AbstractDetailsDescriptionPresenter
    public final void onBindDescription(AbstractDetailsDescriptionPresenter.ViewHolder viewHolder, Object obj) {
        PlaybackControlGlue playbackControlGlue = (PlaybackControlGlue) obj;
        if (playbackControlGlue.hasValidMedia()) {
            viewHolder.getTitle().setText(playbackControlGlue.getMediaTitle());
            viewHolder.getSubtitle().setText(playbackControlGlue.getMediaSubtitle());
        } else {
            viewHolder.getTitle().setText("");
            viewHolder.getSubtitle().setText("");
        }
    }
}
