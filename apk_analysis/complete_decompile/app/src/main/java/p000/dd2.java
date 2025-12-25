package p000;

import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.ViewHolderTask;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class dd2 implements ViewHolderTask {

    /* renamed from: a */
    public final /* synthetic */ Presenter.ViewHolderTask f16347a;

    public dd2(Presenter.ViewHolderTask viewHolderTask) {
        this.f16347a = viewHolderTask;
    }

    @Override // androidx.leanback.widget.ViewHolderTask
    public final void run(RecyclerView.ViewHolder viewHolder) {
        viewHolder.itemView.post(new cd2(this, viewHolder));
    }
}
