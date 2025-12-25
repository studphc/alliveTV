package p000;

import androidx.leanback.widget.Action;
import androidx.leanback.widget.OnActionClickedListener;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;

/* loaded from: classes.dex */
public final class j52 implements OnItemViewClickedListener {

    /* renamed from: a */
    public final /* synthetic */ OnActionClickedListener f20381a;

    public j52(OnActionClickedListener onActionClickedListener) {
        this.f20381a = onActionClickedListener;
    }

    @Override // androidx.leanback.widget.BaseOnItemViewClickedListener
    public final void onItemClicked(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        if (obj instanceof Action) {
            this.f20381a.onActionClicked((Action) obj);
        }
    }
}
