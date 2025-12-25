package androidx.leanback.transition;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.leanback.R;
import androidx.leanback.widget.Parallax;
import androidx.recyclerview.widget.RecyclerView;
import p000.C1303ie;

@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ParallaxTransition extends Visibility {

    /* renamed from: a */
    public static final LinearInterpolator f5490a = new LinearInterpolator();

    public ParallaxTransition() {
    }

    /* renamed from: a */
    public static ValueAnimator m1373a(View view) {
        Parallax parallax = (Parallax) view.getTag(R.id.lb_parallax_source);
        if (parallax == null) {
            return null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(RecyclerView.f7068F0, 1.0f);
        ofFloat.setInterpolator(f5490a);
        ofFloat.addUpdateListener(new C1303ie(3, parallax));
        return ofFloat;
    }

    @Override // android.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues2 == null) {
            return null;
        }
        return m1373a(view);
    }

    @Override // android.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null) {
            return null;
        }
        return m1373a(view);
    }

    public ParallaxTransition(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
