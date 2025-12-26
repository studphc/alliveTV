package androidx.leanback.widget;

import android.view.View;
import androidx.leanback.widget.GuidedActionsStylist;

/* renamed from: androidx.leanback.widget.y0 */
/* loaded from: classes.dex */
public final class ViewOnClickListenerC0408y0 implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ GuidedActionsStylist.ViewHolder f6439a;

    /* renamed from: b */
    public final /* synthetic */ GuidedActionsStylist f6440b;

    public ViewOnClickListenerC0408y0(GuidedActionsStylist guidedActionsStylist, GuidedActionsStylist.ViewHolder viewHolder) {
        this.f6440b = guidedActionsStylist;
        this.f6439a = viewHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        GuidedActionsStylist guidedActionsStylist = this.f6440b;
        if (!guidedActionsStylist.isInExpandTransition()) {
            ((GuidedActionAdapter) guidedActionsStylist.getActionsGridView().getAdapter()).performOnActionClick(this.f6439a);
        }
    }
}
