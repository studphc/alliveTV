package p000;

import android.animation.ValueAnimator;
import androidx.leanback.app.BackgroundManager;
import androidx.leanback.widget.Parallax;
import androidx.recyclerview.widget.C0504s;

/* renamed from: ie */
/* loaded from: classes.dex */
public final class C1303ie implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    public final /* synthetic */ int f18381a;

    /* renamed from: b */
    public final /* synthetic */ Object f18382b;

    public /* synthetic */ C1303ie(int i, Object obj) {
        this.f18381a = i;
        this.f18382b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f18381a) {
            case 0:
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                BackgroundManager backgroundManager = (BackgroundManager) this.f18382b;
                int i = backgroundManager.f4738p;
                if (i != -1) {
                    C1684pe c1684pe = backgroundManager.f4737o;
                    C1582ne c1582ne = c1684pe.f25128a[i];
                    if (c1582ne != null) {
                        c1582ne.f23336a = intValue;
                        c1684pe.invalidateSelf();
                        return;
                    }
                    return;
                }
                return;
            case 1:
                ((m20) this.f18382b).f22774e.setAlpha((int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f));
                return;
            case 2:
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
                C0504s c0504s = (C0504s) this.f18382b;
                c0504s.f7475c.setAlpha(floatValue);
                c0504s.f7476d.setAlpha(floatValue);
                c0504s.f7491s.invalidate();
                return;
            default:
                ((Parallax) this.f18382b).updateValues();
                return;
        }
    }
}
