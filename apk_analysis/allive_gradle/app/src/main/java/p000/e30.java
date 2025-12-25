package p000;

import androidx.fragment.app.Fragment;
import androidx.leanback.app.DetailsSupportFragment;

/* loaded from: classes.dex */
public final class e30 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f16661a;

    /* renamed from: b */
    public final /* synthetic */ DetailsSupportFragment f16662b;

    public /* synthetic */ e30(DetailsSupportFragment detailsSupportFragment, int i) {
        this.f16661a = i;
        this.f16662b = detailsSupportFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f16661a) {
            case 0:
                DetailsSupportFragment detailsSupportFragment = this.f16662b;
                if (detailsSupportFragment.getView() != null) {
                    Fragment fragment = detailsSupportFragment.f4953V0;
                    if (fragment != null && fragment.getView() != null) {
                        detailsSupportFragment.f4953V0.getView().requestFocus();
                    } else {
                        detailsSupportFragment.f4757A0.fireEvent(detailsSupportFragment.f4947P0);
                    }
                }
                detailsSupportFragment.f4961d1 = false;
                return;
            default:
                this.f16662b.f4955X0.setEntranceTransitionState(true);
                return;
        }
    }
}
