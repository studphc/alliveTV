package p000;

import androidx.leanback.app.PlaybackSupportFragment;
import androidx.leanback.widget.BaseOnItemViewSelectedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowPresenter;

/* loaded from: classes.dex */
public final class r52 implements BaseOnItemViewSelectedListener {

    /* renamed from: a */
    public final /* synthetic */ PlaybackSupportFragment f25874a;

    public r52(PlaybackSupportFragment playbackSupportFragment) {
        this.f25874a = playbackSupportFragment;
    }

    @Override // androidx.leanback.widget.BaseOnItemViewSelectedListener
    public final void onItemSelected(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Object obj2) {
        BaseOnItemViewSelectedListener baseOnItemViewSelectedListener = this.f25874a.f5183m0;
        if (baseOnItemViewSelectedListener != null) {
            baseOnItemViewSelectedListener.onItemSelected(viewHolder, obj, viewHolder2, obj2);
        }
    }
}
