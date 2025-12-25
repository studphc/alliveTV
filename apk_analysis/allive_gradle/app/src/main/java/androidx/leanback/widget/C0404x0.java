package androidx.leanback.widget;

import androidx.leanback.widget.GuidedActionsStylist;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.leanback.widget.x0 */
/* loaded from: classes.dex */
public final class C0404x0 implements ViewHolderTask {

    /* renamed from: a */
    public final /* synthetic */ GuidedActionAdapter f6436a;

    public C0404x0(GuidedActionAdapter guidedActionAdapter) {
        this.f6436a = guidedActionAdapter;
    }

    @Override // androidx.leanback.widget.ViewHolderTask
    public final void run(RecyclerView.ViewHolder viewHolder) {
        GuidedActionAdapter guidedActionAdapter = this.f6436a;
        guidedActionAdapter.f5772m.openIme(guidedActionAdapter, (GuidedActionsStylist.ViewHolder) viewHolder);
    }
}
