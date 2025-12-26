package androidx.leanback.widget;

import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowPresenter;
import p000.a52;

/* renamed from: androidx.leanback.widget.c2 */
/* loaded from: classes.dex */
public final class C0323c2 implements InterfaceC0352k {

    /* renamed from: a */
    public final /* synthetic */ PlaybackControlsRowPresenter f6276a;

    public C0323c2(PlaybackControlsRowPresenter playbackControlsRowPresenter) {
        this.f6276a = playbackControlsRowPresenter;
    }

    @Override // androidx.leanback.widget.InterfaceC0352k
    /* renamed from: a */
    public final void mo1496a(Presenter.ViewHolder viewHolder, Object obj, a52 a52Var) {
        RowPresenter.ViewHolder viewHolder2 = ((C0331e2) a52Var).f6284d;
        if (viewHolder2.getOnItemViewClickedListener() != null) {
            viewHolder2.getOnItemViewClickedListener().onItemClicked(viewHolder, obj, viewHolder2, viewHolder2.getRow());
        }
        OnActionClickedListener onActionClickedListener = this.f6276a.f6010m;
        if (onActionClickedListener != null && (obj instanceof Action)) {
            onActionClickedListener.onActionClicked((Action) obj);
        }
    }
}
