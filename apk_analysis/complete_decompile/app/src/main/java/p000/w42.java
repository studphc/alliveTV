package p000;

import androidx.leanback.media.PlaybackBannerControlGlue;
import androidx.leanback.widget.AbstractDetailsDescriptionPresenter;

/* loaded from: classes.dex */
public final class w42 extends AbstractDetailsDescriptionPresenter {
    @Override // androidx.leanback.widget.AbstractDetailsDescriptionPresenter
    public final void onBindDescription(AbstractDetailsDescriptionPresenter.ViewHolder viewHolder, Object obj) {
        PlaybackBannerControlGlue playbackBannerControlGlue = (PlaybackBannerControlGlue) obj;
        viewHolder.getTitle().setText(playbackBannerControlGlue.getTitle());
        viewHolder.getSubtitle().setText(playbackBannerControlGlue.getSubtitle());
    }
}
