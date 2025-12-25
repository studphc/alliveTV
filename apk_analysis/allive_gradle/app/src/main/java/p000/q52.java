package p000;

import androidx.leanback.app.PlaybackSupportFragment;
import androidx.leanback.widget.BaseOnItemViewClickedListener;
import androidx.leanback.widget.PlaybackRowPresenter;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowPresenter;

/* loaded from: classes.dex */
public final class q52 implements BaseOnItemViewClickedListener {

    /* renamed from: a */
    public final /* synthetic */ PlaybackSupportFragment f25457a;

    public q52(PlaybackSupportFragment playbackSupportFragment) {
        this.f25457a = playbackSupportFragment;
    }

    @Override // androidx.leanback.widget.BaseOnItemViewClickedListener
    public final void onItemClicked(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Object obj2) {
        PlaybackSupportFragment playbackSupportFragment = this.f25457a;
        BaseOnItemViewClickedListener baseOnItemViewClickedListener = playbackSupportFragment.f5185o0;
        if (baseOnItemViewClickedListener != null && (viewHolder2 instanceof PlaybackRowPresenter.ViewHolder)) {
            baseOnItemViewClickedListener.onItemClicked(viewHolder, obj, viewHolder2, obj2);
        }
        BaseOnItemViewClickedListener baseOnItemViewClickedListener2 = playbackSupportFragment.f5184n0;
        if (baseOnItemViewClickedListener2 != null) {
            baseOnItemViewClickedListener2.onItemClicked(viewHolder, obj, viewHolder2, obj2);
        }
    }
}
