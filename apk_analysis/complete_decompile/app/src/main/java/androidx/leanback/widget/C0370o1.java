package androidx.leanback.widget;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.leanback.widget.MultiActionsProvider;
import androidx.leanback.widget.Presenter;

/* renamed from: androidx.leanback.widget.o1 */
/* loaded from: classes.dex */
public final class C0370o1 extends Presenter {
    @Override // androidx.leanback.widget.Presenter
    public final void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        ((C0366n1) viewHolder).f6328b.setImageDrawable(((MultiActionsProvider.MultiAction) obj).getCurrentDrawable());
    }

    @Override // androidx.leanback.widget.Presenter
    public final Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new C0366n1(LayoutInflater.from(viewGroup.getContext()).inflate(androidx.leanback.R.layout.lb_row_media_item_action, viewGroup, false));
    }

    @Override // androidx.leanback.widget.Presenter
    public final void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
    }
}
