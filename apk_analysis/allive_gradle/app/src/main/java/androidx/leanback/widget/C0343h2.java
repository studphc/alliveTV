package androidx.leanback.widget;

import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowPresenter;
import p000.a52;

/* renamed from: androidx.leanback.widget.h2 */
/* loaded from: classes.dex */
public final class C0343h2 implements InterfaceC0352k {

    /* renamed from: a */
    public final /* synthetic */ PlaybackTransportRowPresenter f6304a;

    public C0343h2(PlaybackTransportRowPresenter playbackTransportRowPresenter) {
        this.f6304a = playbackTransportRowPresenter;
    }

    @Override // androidx.leanback.widget.InterfaceC0352k
    /* renamed from: a */
    public final void mo1496a(Presenter.ViewHolder viewHolder, Object obj, a52 a52Var) {
        RowPresenter.ViewHolder viewHolder2 = ((C0351j2) a52Var).f6313d;
        if (viewHolder2.getOnItemViewClickedListener() != null) {
            viewHolder2.getOnItemViewClickedListener().onItemClicked(viewHolder, obj, viewHolder2, viewHolder2.getRow());
        }
        OnActionClickedListener onActionClickedListener = this.f6304a.f6039m;
        if (onActionClickedListener != null && (obj instanceof Action)) {
            onActionClickedListener.onActionClicked((Action) obj);
        }
    }
}
