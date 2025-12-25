package p000;

import androidx.leanback.app.PlaybackFragment;
import androidx.leanback.widget.BaseOnItemViewClickedListener;
import androidx.leanback.widget.PlaybackRowPresenter;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowPresenter;

/* loaded from: classes.dex */
public final class d52 implements BaseOnItemViewClickedListener {

    /* renamed from: a */
    public final /* synthetic */ PlaybackFragment f16251a;

    public d52(PlaybackFragment playbackFragment) {
        this.f16251a = playbackFragment;
    }

    @Override // androidx.leanback.widget.BaseOnItemViewClickedListener
    public final void onItemClicked(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Object obj2) {
        PlaybackFragment playbackFragment = this.f16251a;
        BaseOnItemViewClickedListener baseOnItemViewClickedListener = playbackFragment.f5132k;
        if (baseOnItemViewClickedListener != null && (viewHolder2 instanceof PlaybackRowPresenter.ViewHolder)) {
            baseOnItemViewClickedListener.onItemClicked(viewHolder, obj, viewHolder2, obj2);
        }
        BaseOnItemViewClickedListener baseOnItemViewClickedListener2 = playbackFragment.f5131j;
        if (baseOnItemViewClickedListener2 != null) {
            baseOnItemViewClickedListener2.onItemClicked(viewHolder, obj, viewHolder2, obj2);
        }
    }
}
