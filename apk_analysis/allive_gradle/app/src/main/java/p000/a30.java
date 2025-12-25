package p000;

import android.app.FragmentTransaction;
import androidx.leanback.app.DetailsFragment;
import androidx.leanback.app.DetailsFragmentBackgroundController;
import androidx.leanback.app.DetailsSupportFragment;
import androidx.leanback.app.DetailsSupportFragmentBackgroundController;
import androidx.leanback.transition.TransitionListener;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class a30 extends TransitionListener {

    /* renamed from: a */
    public final /* synthetic */ int f29a = 0;

    /* renamed from: b */
    public final WeakReference f30b;

    public a30(DetailsSupportFragment detailsSupportFragment) {
        this.f30b = new WeakReference(detailsSupportFragment);
    }

    @Override // androidx.leanback.transition.TransitionListener
    public final void onTransitionStart(Object obj) {
        DetailsFragmentBackgroundController detailsFragmentBackgroundController;
        DetailsSupportFragmentBackgroundController detailsSupportFragmentBackgroundController;
        switch (this.f29a) {
            case 0:
                DetailsFragment detailsFragment = (DetailsFragment) this.f30b.get();
                if (detailsFragment != null && (detailsFragmentBackgroundController = detailsFragment.f4919Y) != null) {
                    m20 m20Var = detailsFragmentBackgroundController.f4929e;
                    if (m20Var != null) {
                        m20Var.f22770a.removeEffect(m20Var.f22771b);
                        if (detailsFragmentBackgroundController.f4929e.f22772c == 1) {
                            return;
                        }
                    }
                    if (detailsFragment.f4912R != null) {
                        FragmentTransaction beginTransaction = detailsFragment.getChildFragmentManager().beginTransaction();
                        beginTransaction.remove(detailsFragment.f4912R);
                        beginTransaction.commit();
                        detailsFragment.f4912R = null;
                        return;
                    }
                    return;
                }
                return;
            default:
                DetailsSupportFragment detailsSupportFragment = (DetailsSupportFragment) this.f30b.get();
                if (detailsSupportFragment != null && (detailsSupportFragmentBackgroundController = detailsSupportFragment.f4960c1) != null) {
                    m20 m20Var2 = detailsSupportFragmentBackgroundController.f4969e;
                    if (m20Var2 != null) {
                        m20Var2.f22770a.removeEffect(m20Var2.f22771b);
                        if (detailsSupportFragmentBackgroundController.f4969e.f22772c == 1) {
                            return;
                        }
                    }
                    if (detailsSupportFragment.f4953V0 != null) {
                        androidx.fragment.app.FragmentTransaction beginTransaction2 = detailsSupportFragment.getChildFragmentManager().beginTransaction();
                        beginTransaction2.remove(detailsSupportFragment.f4953V0);
                        beginTransaction2.commit();
                        detailsSupportFragment.f4953V0 = null;
                        return;
                    }
                    return;
                }
                return;
        }
    }

    public a30(DetailsFragment detailsFragment) {
        this.f30b = new WeakReference(detailsFragment);
    }
}
