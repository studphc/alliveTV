package androidx.leanback.app;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.leanback.app.BrowseFragment;
import p000.ou0;

/* renamed from: androidx.leanback.app.e */
/* loaded from: classes.dex */
public final class ViewTreeObserverOnPreDrawListenerC0271e implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a */
    public final View f5320a;

    /* renamed from: b */
    public final RunnableC0269c f5321b;

    /* renamed from: c */
    public int f5322c;

    /* renamed from: d */
    public final BrowseFragment.MainFragmentAdapter f5323d;

    /* renamed from: e */
    public final /* synthetic */ BrowseFragment f5324e;

    public ViewTreeObserverOnPreDrawListenerC0271e(BrowseFragment browseFragment, RunnableC0269c runnableC0269c, BrowseFragment.MainFragmentAdapter mainFragmentAdapter, View view) {
        this.f5324e = browseFragment;
        this.f5320a = view;
        this.f5321b = runnableC0269c;
        this.f5323d = mainFragmentAdapter;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        BrowseFragment browseFragment = this.f5324e;
        View view = browseFragment.getView();
        View view2 = this.f5320a;
        if (view != null && ou0.m6729a(browseFragment) != null) {
            int i = this.f5322c;
            if (i == 0) {
                this.f5323d.setExpand(true);
                view2.invalidate();
                this.f5322c = 1;
                return false;
            }
            if (i == 1) {
                this.f5321b.run();
                view2.getViewTreeObserver().removeOnPreDrawListener(this);
                this.f5322c = 2;
                return false;
            }
            return false;
        }
        view2.getViewTreeObserver().removeOnPreDrawListener(this);
        return true;
    }
}
