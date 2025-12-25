package androidx.leanback.app;

import android.content.Context;
import androidx.leanback.R;
import androidx.leanback.app.BrowseFragment;
import androidx.leanback.transition.TransitionHelper;
import p000.ou0;

/* renamed from: androidx.leanback.app.c */
/* loaded from: classes.dex */
public final class RunnableC0269c implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ boolean f5317a;

    /* renamed from: b */
    public final /* synthetic */ BrowseFragment f5318b;

    public RunnableC0269c(BrowseFragment browseFragment, boolean z) {
        this.f5318b = browseFragment;
        this.f5317a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        Object obj;
        BrowseFragment browseFragment = this.f5318b;
        browseFragment.f4799G.onTransitionPrepare();
        browseFragment.f4799G.onTransitionStart();
        Context m6729a = ou0.m6729a(browseFragment);
        if (browseFragment.f4811S) {
            i = R.transition.lb_browse_headers_in;
        } else {
            i = R.transition.lb_browse_headers_out;
        }
        Object loadTransition = TransitionHelper.loadTransition(m6729a, i);
        browseFragment.f4828j0 = loadTransition;
        TransitionHelper.addTransitionListener(loadTransition, new C0270d(browseFragment));
        BrowseFragment.BrowseTransitionListener browseTransitionListener = browseFragment.f4830l0;
        boolean z = this.f5317a;
        if (browseTransitionListener != null) {
            browseTransitionListener.onHeadersTransitionStart(z);
        }
        if (z) {
            obj = browseFragment.f4825g0;
        } else {
            obj = browseFragment.f4826h0;
        }
        TransitionHelper.runTransition(obj, browseFragment.f4828j0);
        if (browseFragment.f4809Q) {
            if (!z) {
                browseFragment.getFragmentManager().beginTransaction().addToBackStack(browseFragment.f4810R).commit();
                return;
            }
            int i2 = browseFragment.f4829k0.f29374b;
            if (i2 >= 0) {
                browseFragment.getFragmentManager().popBackStackImmediate(browseFragment.getFragmentManager().getBackStackEntryAt(i2).getId(), 1);
            }
        }
    }
}
