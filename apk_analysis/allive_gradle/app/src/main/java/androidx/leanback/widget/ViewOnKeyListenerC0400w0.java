package androidx.leanback.widget;

import android.view.KeyEvent;
import android.view.View;
import androidx.leanback.widget.GuidedActionsStylist;

/* renamed from: androidx.leanback.widget.w0 */
/* loaded from: classes.dex */
public final class ViewOnKeyListenerC0400w0 implements View.OnKeyListener {

    /* renamed from: a */
    public boolean f6432a = false;

    /* renamed from: b */
    public final /* synthetic */ GuidedActionAdapter f6433b;

    public ViewOnKeyListenerC0400w0(GuidedActionAdapter guidedActionAdapter) {
        this.f6433b = guidedActionAdapter;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (view != null && keyEvent != null) {
            GuidedActionAdapter guidedActionAdapter = this.f6433b;
            if (guidedActionAdapter.f5763d.isAttachedToWindow()) {
                if (i == 23 || i == 66 || i == 160 || i == 99 || i == 100) {
                    GuidedActionsStylist.ViewHolder viewHolder = (GuidedActionsStylist.ViewHolder) guidedActionAdapter.f5763d.getChildViewHolder(view);
                    GuidedAction action = viewHolder.getAction();
                    if (action.isEnabled() && !action.infoOnly()) {
                        int action2 = keyEvent.getAction();
                        GuidedActionsStylist guidedActionsStylist = guidedActionAdapter.f5771l;
                        if (action2 != 0) {
                            if (action2 == 1 && this.f6432a) {
                                this.f6432a = false;
                                guidedActionsStylist.onAnimateItemPressed(viewHolder, false);
                            }
                        } else if (!this.f6432a) {
                            this.f6432a = true;
                            guidedActionsStylist.onAnimateItemPressed(viewHolder, true);
                        }
                    } else {
                        keyEvent.getAction();
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
