package p000;

import android.app.Fragment;
import androidx.leanback.app.DetailsFragment;

/* loaded from: classes.dex */
public final class n20 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f23198a;

    /* renamed from: b */
    public final /* synthetic */ DetailsFragment f23199b;

    public /* synthetic */ n20(DetailsFragment detailsFragment, int i) {
        this.f23198a = i;
        this.f23199b = detailsFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f23198a) {
            case 0:
                DetailsFragment detailsFragment = this.f23199b;
                if (detailsFragment.getView() != null) {
                    Fragment fragment = detailsFragment.f4912R;
                    if (fragment != null && fragment.getView() != null) {
                        detailsFragment.f4912R.getView().requestFocus();
                    } else {
                        detailsFragment.f4754w.fireEvent(detailsFragment.f4906L);
                    }
                }
                detailsFragment.f4920Z = false;
                return;
            default:
                this.f23199b.f4914T.setEntranceTransitionState(true);
                return;
        }
    }
}
