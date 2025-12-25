package p000;

import android.view.View;
import androidx.constraintlayout.motion.utils.ViewOscillator;

/* loaded from: classes.dex */
public final class n33 extends ViewOscillator {

    /* renamed from: g */
    public final /* synthetic */ int f23219g;

    @Override // androidx.constraintlayout.motion.utils.ViewOscillator
    public final void setProperty(View view, float f) {
        switch (this.f23219g) {
            case 0:
                view.setAlpha(get(f));
                return;
            case 1:
                view.setElevation(get(f));
                return;
            case 2:
                view.setRotation(get(f));
                return;
            case 3:
                view.setRotationX(get(f));
                return;
            case 4:
                view.setRotationY(get(f));
                return;
            case 5:
                view.setScaleX(get(f));
                return;
            case 6:
                view.setScaleY(get(f));
                return;
            case 7:
                view.setTranslationX(get(f));
                return;
            case 8:
                view.setTranslationY(get(f));
                return;
            default:
                view.setTranslationZ(get(f));
                return;
        }
    }
}
