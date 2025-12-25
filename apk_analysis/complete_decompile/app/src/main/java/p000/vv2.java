package p000;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.transition.TransitionValues;
import android.util.Property;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.leanback.R;
import androidx.leanback.transition.FadeAndShortSlide;

/* loaded from: classes.dex */
public abstract class vv2 {
    /* renamed from: a */
    public static ObjectAnimator m7943a(View view, TransitionValues transitionValues, int i, int i2, float f, float f2, float f3, float f4, DecelerateInterpolator decelerateInterpolator, FadeAndShortSlide fadeAndShortSlide) {
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        if (((int[]) transitionValues.view.getTag(R.id.transitionPosition)) != null) {
            f = (r2[0] - i) + translationX;
            f2 = (r2[1] - i2) + translationY;
        }
        int round = Math.round(f - translationX) + i;
        int round2 = Math.round(f2 - translationY) + i2;
        view.setTranslationX(f);
        view.setTranslationY(f2);
        if (f == f3 && f2 == f4) {
            return null;
        }
        Path path = new Path();
        path.moveTo(f, f2);
        path.lineTo(f3, f4);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_X, (Property<View, Float>) View.TRANSLATION_Y, path);
        uv2 uv2Var = new uv2(view, transitionValues.view, round, round2, translationX, translationY);
        fadeAndShortSlide.addListener(uv2Var);
        ofFloat.addListener(uv2Var);
        ofFloat.addPauseListener(uv2Var);
        ofFloat.setInterpolator(decelerateInterpolator);
        return ofFloat;
    }
}
