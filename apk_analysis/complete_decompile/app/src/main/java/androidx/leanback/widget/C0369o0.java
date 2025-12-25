package androidx.leanback.widget;

import androidx.leanback.transition.TransitionHelper;
import androidx.leanback.transition.TransitionListener;
import androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter;

/* renamed from: androidx.leanback.widget.o0 */
/* loaded from: classes.dex */
public final class C0369o0 extends TransitionListener {

    /* renamed from: a */
    public final /* synthetic */ RunnableC0373p0 f6333a;

    public C0369o0(RunnableC0373p0 runnableC0373p0) {
        this.f6333a = runnableC0373p0;
    }

    @Override // androidx.leanback.transition.TransitionListener
    public final void onTransitionEnd(Object obj) {
        FullWidthDetailsOverviewRowPresenter.ViewHolder viewHolder = (FullWidthDetailsOverviewRowPresenter.ViewHolder) this.f6333a.f6343a.f5667a.get();
        if (viewHolder != null && viewHolder.getActionsRow().isFocused()) {
            viewHolder.getActionsRow().requestFocus();
        }
        TransitionHelper.removeTransitionListener(obj, this);
    }
}
