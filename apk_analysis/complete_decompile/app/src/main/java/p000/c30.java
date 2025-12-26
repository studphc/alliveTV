package p000;

import androidx.leanback.app.DetailsFragment;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class c30 implements Runnable {

    /* renamed from: a */
    public final WeakReference f8242a;

    public c30(DetailsFragment detailsFragment) {
        this.f8242a = new WeakReference(detailsFragment);
        detailsFragment.getView().postDelayed(this, 200L);
    }

    @Override // java.lang.Runnable
    public final void run() {
        DetailsFragment detailsFragment = (DetailsFragment) this.f8242a.get();
        if (detailsFragment != null) {
            detailsFragment.f4754w.fireEvent(detailsFragment.f4905K);
        }
    }
}
