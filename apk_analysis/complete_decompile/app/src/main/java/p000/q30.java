package p000;

import androidx.leanback.app.DetailsSupportFragment;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class q30 implements Runnable {

    /* renamed from: a */
    public final WeakReference f25417a;

    public q30(DetailsSupportFragment detailsSupportFragment) {
        this.f25417a = new WeakReference(detailsSupportFragment);
        detailsSupportFragment.getView().postDelayed(this, 200L);
    }

    @Override // java.lang.Runnable
    public final void run() {
        DetailsSupportFragment detailsSupportFragment = (DetailsSupportFragment) this.f25417a.get();
        if (detailsSupportFragment != null) {
            detailsSupportFragment.f4757A0.fireEvent(detailsSupportFragment.f4946O0);
        }
    }
}
