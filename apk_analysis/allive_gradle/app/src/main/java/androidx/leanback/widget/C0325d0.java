package androidx.leanback.widget;

import androidx.leanback.transition.TransitionHelper;
import androidx.leanback.transition.TransitionListener;
import androidx.leanback.widget.DetailsOverviewRowPresenter;

/* renamed from: androidx.leanback.widget.d0 */
/* loaded from: classes.dex */
public final class C0325d0 extends TransitionListener {

    /* renamed from: a */
    public final /* synthetic */ RunnableC0329e0 f6278a;

    public C0325d0(RunnableC0329e0 runnableC0329e0) {
        this.f6278a = runnableC0329e0;
    }

    @Override // androidx.leanback.transition.TransitionListener
    public final void onTransitionEnd(Object obj) {
        DetailsOverviewRowPresenter.ViewHolder viewHolder = (DetailsOverviewRowPresenter.ViewHolder) this.f6278a.f6282a.f6288b.get();
        if (viewHolder != null) {
            HorizontalGridView horizontalGridView = viewHolder.f5632s;
            if (horizontalGridView.isFocused()) {
                horizontalGridView.requestFocus();
            }
        }
        TransitionHelper.removeTransitionListener(obj, this);
    }
}
