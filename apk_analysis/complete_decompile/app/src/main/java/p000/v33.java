package p000;

import android.view.View;
import androidx.constraintlayout.motion.utils.ViewSpline;

/* loaded from: classes.dex */
public final class v33 extends ViewSpline {

    /* renamed from: c */
    public final /* synthetic */ int f27644c;

    @Override // androidx.constraintlayout.motion.utils.ViewSpline
    public final void setProperty(View view, float f) {
        switch (this.f27644c) {
            case 0:
                view.setAlpha(get(f));
                return;
            case 1:
                view.setElevation(get(f));
                return;
            case 2:
                view.setPivotX(get(f));
                return;
            case 3:
                view.setPivotY(get(f));
                return;
            case 4:
                view.setRotation(get(f));
                return;
            case 5:
                view.setRotationX(get(f));
                return;
            case 6:
                view.setRotationY(get(f));
                return;
            case 7:
                view.setScaleX(get(f));
                return;
            case 8:
                view.setScaleY(get(f));
                return;
            case 9:
                view.setTranslationX(get(f));
                return;
            case 10:
                view.setTranslationY(get(f));
                return;
            default:
                view.setTranslationZ(get(f));
                return;
        }
    }
}
