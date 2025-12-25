package p000;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import androidx.leanback.R;
import androidx.leanback.app.BackgroundManager;

/* renamed from: me */
/* loaded from: classes.dex */
public final class RunnableC1545me implements Runnable {

    /* renamed from: a */
    public final Drawable f22905a;

    /* renamed from: b */
    public final /* synthetic */ BackgroundManager f22906b;

    public RunnableC1545me(BackgroundManager backgroundManager, Drawable drawable) {
        this.f22906b = backgroundManager;
        this.f22905a = drawable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C1582ne c1582ne;
        C1582ne c1582ne2;
        BackgroundManager backgroundManager = this.f22906b;
        C1684pe c1684pe = backgroundManager.f4737o;
        if (c1684pe != null) {
            if (c1684pe == null) {
                c1582ne = null;
            } else {
                c1582ne = c1684pe.f25128a[backgroundManager.f4738p];
            }
            Drawable drawable = this.f22905a;
            if (c1582ne != null) {
                Drawable drawable2 = (Drawable) c1582ne.f23337b;
                if (!BackgroundManager.m1253d(drawable, drawable2)) {
                    backgroundManager.f4737o.m6911a(R.id.background_imagein, backgroundManager.f4723a);
                    backgroundManager.f4737o.m6912b(R.id.background_imageout, drawable2);
                }
            }
            if (backgroundManager.f4734l) {
                C1684pe c1684pe2 = backgroundManager.f4737o;
                if (c1684pe2 == null) {
                    c1582ne2 = null;
                } else {
                    c1582ne2 = c1684pe2.f25128a[backgroundManager.f4738p];
                }
                if (c1582ne2 == null && drawable != null) {
                    c1684pe2.m6912b(R.id.background_imagein, drawable);
                    C1684pe c1684pe3 = backgroundManager.f4737o;
                    C1582ne c1582ne3 = c1684pe3.f25128a[backgroundManager.f4738p];
                    if (c1582ne3 != null) {
                        c1582ne3.f23336a = 0;
                        c1684pe3.invalidateSelf();
                    }
                }
                ValueAnimator valueAnimator = backgroundManager.f4736n;
                valueAnimator.setDuration(500L);
                valueAnimator.start();
            }
        }
        backgroundManager.f4739q = null;
    }
}
