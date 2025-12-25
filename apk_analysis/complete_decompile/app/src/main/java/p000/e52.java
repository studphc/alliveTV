package p000;

import androidx.leanback.app.PlaybackFragment;
import androidx.leanback.widget.BaseOnItemViewSelectedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowPresenter;

/* loaded from: classes.dex */
public final class e52 implements BaseOnItemViewSelectedListener {

    /* renamed from: a */
    public final /* synthetic */ PlaybackFragment f16675a;

    public e52(PlaybackFragment playbackFragment) {
        this.f16675a = playbackFragment;
    }

    @Override // androidx.leanback.widget.BaseOnItemViewSelectedListener
    public final void onItemSelected(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Object obj2) {
        BaseOnItemViewSelectedListener baseOnItemViewSelectedListener = this.f16675a.f5130i;
        if (baseOnItemViewSelectedListener != null) {
            baseOnItemViewSelectedListener.onItemSelected(viewHolder, obj, viewHolder2, obj2);
        }
    }
}
