package androidx.leanback.widget;

import androidx.core.app.ActivityCompat;
import androidx.core.view.ViewCompat;
import androidx.leanback.transition.TransitionHelper;
import androidx.leanback.widget.DetailsOverviewRowPresenter;

/* renamed from: androidx.leanback.widget.e0 */
/* loaded from: classes.dex */
public final class RunnableC0329e0 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ C0333f0 f6282a;

    public RunnableC0329e0(C0333f0 c0333f0) {
        this.f6282a = c0333f0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0333f0 c0333f0 = this.f6282a;
        DetailsOverviewRowPresenter.ViewHolder viewHolder = (DetailsOverviewRowPresenter.ViewHolder) c0333f0.f6288b.get();
        if (viewHolder == null) {
            return;
        }
        ViewCompat.setTransitionName(viewHolder.f5627n, c0333f0.f6291e);
        Object sharedElementEnterTransition = TransitionHelper.getSharedElementEnterTransition(c0333f0.f6289c.getWindow());
        if (sharedElementEnterTransition != null) {
            TransitionHelper.addTransitionListener(sharedElementEnterTransition, new C0325d0(this));
        }
        if (!c0333f0.f6290d) {
            ActivityCompat.startPostponedEnterTransition(c0333f0.f6289c);
            c0333f0.f6290d = true;
        }
    }
}
