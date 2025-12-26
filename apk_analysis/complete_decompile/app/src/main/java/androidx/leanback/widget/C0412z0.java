package androidx.leanback.widget;

import androidx.leanback.widget.GuidedActionsStylist;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.leanback.widget.z0 */
/* loaded from: classes.dex */
public final class C0412z0 implements ViewHolderTask {

    /* renamed from: a */
    public final /* synthetic */ GuidedActionsStylist f6445a;

    public C0412z0(GuidedActionsStylist guidedActionsStylist) {
        this.f6445a = guidedActionsStylist;
    }

    @Override // androidx.leanback.widget.ViewHolderTask
    public final void run(RecyclerView.ViewHolder viewHolder) {
        GuidedActionsStylist.ViewHolder viewHolder2 = (GuidedActionsStylist.ViewHolder) viewHolder;
        boolean hasEditableActivatorView = viewHolder2.getAction().hasEditableActivatorView();
        GuidedActionsStylist guidedActionsStylist = this.f6445a;
        if (hasEditableActivatorView) {
            guidedActionsStylist.m1442c(viewHolder2, true, false);
        } else {
            guidedActionsStylist.onUpdateExpandedViewHolder(viewHolder2);
        }
    }
}
