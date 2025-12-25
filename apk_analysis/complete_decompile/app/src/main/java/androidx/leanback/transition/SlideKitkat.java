package androidx.leanback.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BaseInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.RequiresApi;
import androidx.leanback.R;
import p000.nk2;
import p000.ok2;
import p000.pk2;
import p000.qk2;

@RequiresApi(19)
/* loaded from: classes.dex */
class SlideKitkat extends Visibility {

    /* renamed from: b */
    public static final DecelerateInterpolator f5491b = new DecelerateInterpolator();

    /* renamed from: c */
    public static final AccelerateInterpolator f5492c = new AccelerateInterpolator();

    /* renamed from: d */
    public static final nk2 f5493d = new nk2(0);

    /* renamed from: e */
    public static final ok2 f5494e = new ok2(0);

    /* renamed from: f */
    public static final nk2 f5495f = new nk2(1);

    /* renamed from: g */
    public static final ok2 f5496g = new ok2(1);

    /* renamed from: h */
    public static final nk2 f5497h = new nk2(2);

    /* renamed from: i */
    public static final nk2 f5498i = new nk2(3);

    /* renamed from: a */
    public pk2 f5499a;

    public SlideKitkat(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.lbSlide);
        m1375b(obtainStyledAttributes.getInt(R.styleable.lbSlide_lb_slideEdge, 80));
        long j = obtainStyledAttributes.getInt(R.styleable.lbSlide_android_duration, -1);
        if (j >= 0) {
            setDuration(j);
        }
        long j2 = obtainStyledAttributes.getInt(R.styleable.lbSlide_android_startDelay, -1);
        if (j2 > 0) {
            setStartDelay(j2);
        }
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.lbSlide_android_interpolator, 0);
        if (resourceId > 0) {
            setInterpolator(AnimationUtils.loadInterpolator(context, resourceId));
        }
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    public static ObjectAnimator m1374a(View view, Property property, float f, float f2, float f3, BaseInterpolator baseInterpolator, int i) {
        int i2 = R.id.lb_slide_transition_value;
        float[] fArr = (float[]) view.getTag(i2);
        if (fArr != null) {
            if (View.TRANSLATION_Y == property) {
                f = fArr[1];
            } else {
                f = fArr[0];
            }
            view.setTag(i2, null);
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, f, f2);
        qk2 qk2Var = new qk2(view, property, f3, f2, i);
        ofFloat.addListener(qk2Var);
        ofFloat.addPauseListener(qk2Var);
        ofFloat.setInterpolator(baseInterpolator);
        return ofFloat;
    }

    /* renamed from: b */
    public final void m1375b(int i) {
        if (i != 3) {
            if (i != 5) {
                if (i != 48) {
                    if (i != 80) {
                        if (i != 8388611) {
                            if (i == 8388613) {
                                this.f5499a = f5498i;
                                return;
                            }
                            throw new IllegalArgumentException("Invalid slide direction");
                        }
                        this.f5499a = f5497h;
                        return;
                    }
                    this.f5499a = f5496g;
                    return;
                }
                this.f5499a = f5494e;
                return;
            }
            this.f5499a = f5495f;
            return;
        }
        this.f5499a = f5493d;
    }

    @Override // android.transition.Visibility
    public final Animator onAppear(ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, int i2) {
        View view;
        if (transitionValues2 != null) {
            view = transitionValues2.view;
        } else {
            view = null;
        }
        if (view == null) {
            return null;
        }
        float mo6881b = this.f5499a.mo6881b(view);
        return m1374a(view, this.f5499a.getProperty(), this.f5499a.mo6355a(view), mo6881b, mo6881b, f5491b, 0);
    }

    @Override // android.transition.Visibility
    public final Animator onDisappear(ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, int i2) {
        View view;
        if (transitionValues != null) {
            view = transitionValues.view;
        } else {
            view = null;
        }
        if (view == null) {
            return null;
        }
        float mo6881b = this.f5499a.mo6881b(view);
        return m1374a(view, this.f5499a.getProperty(), mo6881b, this.f5499a.mo6355a(view), mo6881b, f5492c, 4);
    }
}
