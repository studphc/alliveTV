package androidx.leanback.widget;

import androidx.leanback.widget.GuidedActionsStylist;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.leanback.widget.a1 */
/* loaded from: classes.dex */
public final class C0313a1 implements ViewHolderTask {

    /* renamed from: a */
    public final /* synthetic */ GuidedActionsStylist f6264a;

    public C0313a1(GuidedActionsStylist guidedActionsStylist) {
        this.f6264a = guidedActionsStylist;
    }

    @Override // androidx.leanback.widget.ViewHolderTask
    public final void run(RecyclerView.ViewHolder viewHolder) {
        GuidedActionsStylist.ViewHolder viewHolder2 = (GuidedActionsStylist.ViewHolder) viewHolder;
        boolean hasEditableActivatorView = viewHolder2.getAction().hasEditableActivatorView();
        GuidedActionsStylist guidedActionsStylist = this.f6264a;
        if (hasEditableActivatorView) {
            guidedActionsStylist.m1442c(viewHolder2, true, true);
        } else {
            guidedActionsStylist.m1443d(viewHolder2, true);
        }
    }
}
