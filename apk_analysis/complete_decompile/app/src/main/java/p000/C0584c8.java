package p000;

import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

/* renamed from: c8 */
/* loaded from: classes.dex */
public final class C0584c8 implements Drawable.Callback {

    /* renamed from: a */
    public final /* synthetic */ int f8285a = 1;

    /* renamed from: b */
    public Object f8286b;

    public /* synthetic */ C0584c8() {
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        switch (this.f8285a) {
            case 0:
                ((AnimatedVectorDrawableCompat) this.f8286b).invalidateSelf();
                return;
            default:
                return;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        switch (this.f8285a) {
            case 0:
                ((AnimatedVectorDrawableCompat) this.f8286b).scheduleSelf(runnable, j);
                return;
            default:
                Drawable.Callback callback = (Drawable.Callback) this.f8286b;
                if (callback != null) {
                    callback.scheduleDrawable(drawable, runnable, j);
                    return;
                }
                return;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        switch (this.f8285a) {
            case 0:
                ((AnimatedVectorDrawableCompat) this.f8286b).unscheduleSelf(runnable);
                return;
            default:
                Drawable.Callback callback = (Drawable.Callback) this.f8286b;
                if (callback != null) {
                    callback.unscheduleDrawable(drawable, runnable);
                    return;
                }
                return;
        }
    }

    public C0584c8(AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
        this.f8286b = animatedVectorDrawableCompat;
    }

    /* renamed from: a */
    private final void m2206a(Drawable drawable) {
    }
}
