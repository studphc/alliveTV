package androidx.leanback.app;

import android.content.Context;
import androidx.leanback.R;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.transition.TransitionHelper;

/* renamed from: androidx.leanback.app.j */
/* loaded from: classes.dex */
public final class RunnableC0276j implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ boolean f5331a;

    /* renamed from: b */
    public final /* synthetic */ BrowseSupportFragment f5332b;

    public RunnableC0276j(BrowseSupportFragment browseSupportFragment, boolean z) {
        this.f5332b = browseSupportFragment;
        this.f5331a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        Object obj;
        BrowseSupportFragment browseSupportFragment = this.f5332b;
        browseSupportFragment.f4852K0.onTransitionPrepare();
        browseSupportFragment.f4852K0.onTransitionStart();
        Context context = browseSupportFragment.getContext();
        if (browseSupportFragment.f4864W0) {
            i = R.transition.lb_browse_headers_in;
        } else {
            i = R.transition.lb_browse_headers_out;
        }
        Object loadTransition = TransitionHelper.loadTransition(context, i);
        browseSupportFragment.f4881n1 = loadTransition;
        TransitionHelper.addTransitionListener(loadTransition, new C0277k(browseSupportFragment));
        BrowseSupportFragment.BrowseTransitionListener browseTransitionListener = browseSupportFragment.f4883p1;
        boolean z = this.f5331a;
        if (browseTransitionListener != null) {
            browseTransitionListener.onHeadersTransitionStart(z);
        }
        if (z) {
            obj = browseSupportFragment.f4878k1;
        } else {
            obj = browseSupportFragment.f4879l1;
        }
        TransitionHelper.runTransition(obj, browseSupportFragment.f4881n1);
        if (browseSupportFragment.f4862U0) {
            if (!z) {
                browseSupportFragment.getFragmentManager().beginTransaction().addToBackStack(browseSupportFragment.f4863V0).commit();
                return;
            }
            int i2 = browseSupportFragment.f4882o1.f17702b;
            if (i2 >= 0) {
                browseSupportFragment.getFragmentManager().popBackStackImmediate(browseSupportFragment.getFragmentManager().getBackStackEntryAt(i2).getId(), 1);
            }
        }
    }
}
