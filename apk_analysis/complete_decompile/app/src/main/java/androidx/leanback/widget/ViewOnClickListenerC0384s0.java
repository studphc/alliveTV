package androidx.leanback.widget;

import android.view.View;
import androidx.leanback.widget.GuidedActionsStylist;

/* renamed from: androidx.leanback.widget.s0 */
/* loaded from: classes.dex */
public final class ViewOnClickListenerC0384s0 implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ GuidedActionAdapter f6411a;

    public ViewOnClickListenerC0384s0(GuidedActionAdapter guidedActionAdapter) {
        this.f6411a = guidedActionAdapter;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view != null && view.getWindowToken() != null) {
            GuidedActionAdapter guidedActionAdapter = this.f6411a;
            if (guidedActionAdapter.f5763d.isAttachedToWindow()) {
                GuidedActionsStylist.ViewHolder viewHolder = (GuidedActionsStylist.ViewHolder) guidedActionAdapter.f5763d.getChildViewHolder(view);
                GuidedAction action = viewHolder.getAction();
                if (action.hasTextEditable()) {
                    guidedActionAdapter.f5772m.openIme(guidedActionAdapter, viewHolder);
                    return;
                }
                if (action.hasEditableActivatorView()) {
                    guidedActionAdapter.performOnActionClick(viewHolder);
                    return;
                }
                guidedActionAdapter.handleCheckedActions(viewHolder);
                if (action.isEnabled() && !action.infoOnly()) {
                    guidedActionAdapter.performOnActionClick(viewHolder);
                }
            }
        }
    }
}
