package androidx.leanback.widget;

import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.Presenter;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.leanback.widget.m1 */
/* loaded from: classes.dex */
public final class C0362m1 implements ViewHolderTask {

    /* renamed from: a */
    public final Presenter.ViewHolderTask f6324a;

    public C0362m1(ListRowPresenter.SelectItemViewHolderTask selectItemViewHolderTask) {
        this.f6324a = selectItemViewHolderTask.f5902c;
    }

    @Override // androidx.leanback.widget.ViewHolderTask
    public final void run(RecyclerView.ViewHolder viewHolder) {
        this.f6324a.run(((ItemBridgeAdapter.ViewHolder) viewHolder).getViewHolder());
    }
}
