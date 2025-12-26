package p000;

import androidx.core.app.ActivityCompat;
import androidx.leanback.widget.C0333f0;
import androidx.leanback.widget.FullWidthDetailsOverviewSharedElementHelper;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class d30 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f16224a = 1;

    /* renamed from: b */
    public final WeakReference f16225b;

    public d30(C0333f0 c0333f0) {
        this.f16225b = new WeakReference(c0333f0);
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f16224a) {
            case 0:
                C0333f0 c0333f0 = (C0333f0) this.f16225b.get();
                if (c0333f0 != null && !c0333f0.f6290d) {
                    ActivityCompat.startPostponedEnterTransition(c0333f0.f6289c);
                    c0333f0.f6290d = true;
                    return;
                }
                return;
            default:
                FullWidthDetailsOverviewSharedElementHelper fullWidthDetailsOverviewSharedElementHelper = (FullWidthDetailsOverviewSharedElementHelper) this.f16225b.get();
                if (fullWidthDetailsOverviewSharedElementHelper != null) {
                    fullWidthDetailsOverviewSharedElementHelper.startPostponedEnterTransition();
                    return;
                }
                return;
        }
    }

    public d30(FullWidthDetailsOverviewSharedElementHelper fullWidthDetailsOverviewSharedElementHelper) {
        this.f16225b = new WeakReference(fullWidthDetailsOverviewSharedElementHelper);
    }
}
