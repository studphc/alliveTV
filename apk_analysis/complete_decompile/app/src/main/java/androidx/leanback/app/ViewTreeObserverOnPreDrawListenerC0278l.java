package androidx.leanback.app;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.leanback.app.BrowseSupportFragment;

/* renamed from: androidx.leanback.app.l */
/* loaded from: classes.dex */
public final class ViewTreeObserverOnPreDrawListenerC0278l implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a */
    public final View f5334a;

    /* renamed from: b */
    public final RunnableC0276j f5335b;

    /* renamed from: c */
    public int f5336c;

    /* renamed from: d */
    public final BrowseSupportFragment.MainFragmentAdapter f5337d;

    /* renamed from: e */
    public final /* synthetic */ BrowseSupportFragment f5338e;

    public ViewTreeObserverOnPreDrawListenerC0278l(BrowseSupportFragment browseSupportFragment, RunnableC0276j runnableC0276j, BrowseSupportFragment.MainFragmentAdapter mainFragmentAdapter, View view) {
        this.f5338e = browseSupportFragment;
        this.f5334a = view;
        this.f5335b = runnableC0276j;
        this.f5337d = mainFragmentAdapter;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        BrowseSupportFragment browseSupportFragment = this.f5338e;
        View view = browseSupportFragment.getView();
        View view2 = this.f5334a;
        if (view != null && browseSupportFragment.getContext() != null) {
            int i = this.f5336c;
            if (i == 0) {
                this.f5337d.setExpand(true);
                view2.invalidate();
                this.f5336c = 1;
                return false;
            }
            if (i == 1) {
                this.f5335b.run();
                view2.getViewTreeObserver().removeOnPreDrawListener(this);
                this.f5336c = 2;
                return false;
            }
            return false;
        }
        view2.getViewTreeObserver().removeOnPreDrawListener(this);
        return true;
    }
}
