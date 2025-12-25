package p000;

import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.ViewHolderTask;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class zc2 implements ViewHolderTask {

    /* renamed from: a */
    public final /* synthetic */ Presenter.ViewHolderTask f29311a;

    public zc2(Presenter.ViewHolderTask viewHolderTask) {
        this.f29311a = viewHolderTask;
    }

    @Override // androidx.leanback.widget.ViewHolderTask
    public final void run(RecyclerView.ViewHolder viewHolder) {
        viewHolder.itemView.post(new yc2(this, viewHolder));
    }
}
