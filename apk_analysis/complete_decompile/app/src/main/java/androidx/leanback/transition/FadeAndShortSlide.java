package androidx.leanback.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.GravityCompat;
import androidx.leanback.R;
import androidx.recyclerview.widget.RecyclerView;
import p000.ac0;
import p000.bc0;
import p000.vv2;
import p000.yy2;

@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class FadeAndShortSlide extends Visibility {

    /* renamed from: e */
    public static final DecelerateInterpolator f5480e = new DecelerateInterpolator();

    /* renamed from: f */
    public static final ac0 f5481f = new ac0(0);

    /* renamed from: g */
    public static final ac0 f5482g = new ac0(1);

    /* renamed from: h */
    public static final ac0 f5483h = new ac0(2);

    /* renamed from: i */
    public static final ac0 f5484i = new ac0(3);

    /* renamed from: j */
    public static final ac0 f5485j = new ac0(4);

    /* renamed from: a */
    public yy2 f5486a;

    /* renamed from: b */
    public Visibility f5487b;

    /* renamed from: c */
    public float f5488c;

    /* renamed from: d */
    public final bc0 f5489d;

    public FadeAndShortSlide() {
        this(GravityCompat.START);
    }

    /* renamed from: a */
    public final float m1371a(ViewGroup viewGroup) {
        float f = this.f5488c;
        if (f < RecyclerView.f7068F0) {
            return viewGroup.getWidth() / 4;
        }
        return f;
    }

    @Override // android.transition.Transition
    public Transition addListener(Transition.TransitionListener transitionListener) {
        this.f5487b.addListener(transitionListener);
        return super.addListener(transitionListener);
    }

    /* renamed from: b */
    public final float m1372b(ViewGroup viewGroup) {
        float f = this.f5488c;
        if (f < RecyclerView.f7068F0) {
            return viewGroup.getHeight() / 4;
        }
        return f;
    }

    @Override // android.transition.Visibility, android.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        this.f5487b.captureEndValues(transitionValues);
        super.captureEndValues(transitionValues);
        int[] iArr = new int[2];
        transitionValues.view.getLocationOnScreen(iArr);
        transitionValues.values.put("android:fadeAndShortSlideTransition:screenPosition", iArr);
    }

    @Override // android.transition.Visibility, android.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        this.f5487b.captureStartValues(transitionValues);
        super.captureStartValues(transitionValues);
        int[] iArr = new int[2];
        transitionValues.view.getLocationOnScreen(iArr);
        transitionValues.values.put("android:fadeAndShortSlideTransition:screenPosition", iArr);
    }

    public float getDistance() {
        return this.f5488c;
    }

    @Override // android.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues2 == null || viewGroup == view) {
            return null;
        }
        int[] iArr = (int[]) transitionValues2.values.get("android:fadeAndShortSlideTransition:screenPosition");
        int i = iArr[0];
        int i2 = iArr[1];
        float translationX = view.getTranslationX();
        ObjectAnimator m7943a = vv2.m7943a(view, transitionValues2, i, i2, this.f5486a.mo48t(this, viewGroup, view, iArr), this.f5486a.mo49u(this, viewGroup, view, iArr), translationX, view.getTranslationY(), f5480e, this);
        Animator onAppear = this.f5487b.onAppear(viewGroup, view, transitionValues, transitionValues2);
        if (m7943a == null) {
            return onAppear;
        }
        if (onAppear == null) {
            return m7943a;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(m7943a).with(onAppear);
        return animatorSet;
    }

    @Override // android.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null || viewGroup == view) {
            return null;
        }
        int[] iArr = (int[]) transitionValues.values.get("android:fadeAndShortSlideTransition:screenPosition");
        ObjectAnimator m7943a = vv2.m7943a(view, transitionValues, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.f5486a.mo48t(this, viewGroup, view, iArr), this.f5486a.mo49u(this, viewGroup, view, iArr), f5480e, this);
        Animator onDisappear = this.f5487b.onDisappear(viewGroup, view, transitionValues, transitionValues2);
        if (m7943a == null) {
            return onDisappear;
        }
        if (onDisappear == null) {
            return m7943a;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(m7943a).with(onDisappear);
        return animatorSet;
    }

    @Override // android.transition.Transition
    public Transition removeListener(Transition.TransitionListener transitionListener) {
        this.f5487b.removeListener(transitionListener);
        return super.removeListener(transitionListener);
    }

    public void setDistance(float f) {
        this.f5488c = f;
    }

    @Override // android.transition.Transition
    public void setEpicenterCallback(Transition.EpicenterCallback epicenterCallback) {
        this.f5487b.setEpicenterCallback(epicenterCallback);
        super.setEpicenterCallback(epicenterCallback);
    }

    public void setSlideEdge(int i) {
        if (i != 48) {
            if (i != 80) {
                if (i != 112) {
                    if (i != 8388611) {
                        if (i != 8388613) {
                            if (i == 8388615) {
                                this.f5486a = f5483h;
                                return;
                            }
                            throw new IllegalArgumentException("Invalid slide direction");
                        }
                        this.f5486a = f5482g;
                        return;
                    }
                    this.f5486a = f5481f;
                    return;
                }
                this.f5486a = this.f5489d;
                return;
            }
            this.f5486a = f5484i;
            return;
        }
        this.f5486a = f5485j;
    }

    public FadeAndShortSlide(int i) {
        this.f5487b = new Fade();
        this.f5488c = -1.0f;
        this.f5489d = new bc0(this);
        setSlideEdge(i);
    }

    @Override // android.transition.Transition
    public Transition clone() {
        FadeAndShortSlide fadeAndShortSlide = (FadeAndShortSlide) super.clone();
        fadeAndShortSlide.f5487b = (Visibility) this.f5487b.clone();
        return fadeAndShortSlide;
    }

    public FadeAndShortSlide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5487b = new Fade();
        this.f5488c = -1.0f;
        this.f5489d = new bc0(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.lbSlide);
        setSlideEdge(obtainStyledAttributes.getInt(R.styleable.lbSlide_lb_slideEdge, GravityCompat.START));
        obtainStyledAttributes.recycle();
    }
}
