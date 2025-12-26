package androidx.leanback.widget;

import android.view.View;
import androidx.leanback.widget.GuidedActionAdapter;
import androidx.leanback.widget.GuidedActionsStylist;

/* renamed from: androidx.leanback.widget.v0 */
/* loaded from: classes.dex */
public final class ViewOnFocusChangeListenerC0396v0 implements View.OnFocusChangeListener {

    /* renamed from: a */
    public GuidedActionAdapter.FocusListener f6424a;

    /* renamed from: b */
    public View f6425b;

    /* renamed from: c */
    public final /* synthetic */ GuidedActionAdapter f6426c;

    public ViewOnFocusChangeListenerC0396v0(GuidedActionAdapter guidedActionAdapter, GuidedActionAdapter.FocusListener focusListener) {
        this.f6426c = guidedActionAdapter;
        this.f6424a = focusListener;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        GuidedActionAdapter guidedActionAdapter = this.f6426c;
        if (!guidedActionAdapter.f5763d.isAttachedToWindow()) {
            return;
        }
        GuidedActionsStylist.ViewHolder viewHolder = (GuidedActionsStylist.ViewHolder) guidedActionAdapter.f5763d.getChildViewHolder(view);
        GuidedActionsStylist guidedActionsStylist = guidedActionAdapter.f5771l;
        if (z) {
            this.f6425b = view;
            GuidedActionAdapter.FocusListener focusListener = this.f6424a;
            if (focusListener != null) {
                focusListener.onGuidedActionFocused(viewHolder.getAction());
            }
        } else if (this.f6425b == view) {
            guidedActionsStylist.onAnimateItemPressedCancelled(viewHolder);
            this.f6425b = null;
        }
        guidedActionsStylist.onAnimateItemFocused(viewHolder, z);
    }
}
