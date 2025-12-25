package androidx.leanback.widget;

import androidx.core.app.ActivityCompat;
import androidx.core.view.ViewCompat;
import androidx.leanback.transition.TransitionHelper;
import androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter;

/* renamed from: androidx.leanback.widget.p0 */
/* loaded from: classes.dex */
public final class RunnableC0373p0 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ FullWidthDetailsOverviewSharedElementHelper f6343a;

    public RunnableC0373p0(FullWidthDetailsOverviewSharedElementHelper fullWidthDetailsOverviewSharedElementHelper) {
        this.f6343a = fullWidthDetailsOverviewSharedElementHelper;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FullWidthDetailsOverviewSharedElementHelper fullWidthDetailsOverviewSharedElementHelper = this.f6343a;
        FullWidthDetailsOverviewRowPresenter.ViewHolder viewHolder = (FullWidthDetailsOverviewRowPresenter.ViewHolder) fullWidthDetailsOverviewSharedElementHelper.f5667a.get();
        if (viewHolder == null) {
            return;
        }
        ViewCompat.setTransitionName(viewHolder.getLogoViewHolder().view, fullWidthDetailsOverviewSharedElementHelper.f5670d);
        Object sharedElementEnterTransition = TransitionHelper.getSharedElementEnterTransition(fullWidthDetailsOverviewSharedElementHelper.f5668b.getWindow());
        if (sharedElementEnterTransition != null) {
            TransitionHelper.addTransitionListener(sharedElementEnterTransition, new C0369o0(this));
        }
        if (!fullWidthDetailsOverviewSharedElementHelper.f5669c && fullWidthDetailsOverviewSharedElementHelper.f5667a.get() != null) {
            ActivityCompat.startPostponedEnterTransition(fullWidthDetailsOverviewSharedElementHelper.f5668b);
            fullWidthDetailsOverviewSharedElementHelper.f5669c = true;
        }
    }
}
