package p000;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.exoplayer2.p003ui.C0731m;
import com.google.android.exoplayer2.p003ui.DefaultTimeBar;

/* loaded from: classes.dex */
public final class tp2 extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ int f26917a;

    /* renamed from: b */
    public final /* synthetic */ C0731m f26918b;

    public /* synthetic */ tp2(C0731m c0731m, int i) {
        this.f26917a = i;
        this.f26918b = c0731m;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        switch (this.f26917a) {
            case 0:
                C0731m c0731m = this.f26918b;
                View view = c0731m.f12357b;
                if (view != null) {
                    view.setVisibility(4);
                }
                ViewGroup viewGroup = c0731m.f12358c;
                if (viewGroup != null) {
                    viewGroup.setVisibility(4);
                }
                ViewGroup viewGroup2 = c0731m.f12360e;
                if (viewGroup2 != null) {
                    viewGroup2.setVisibility(4);
                    return;
                }
                return;
            case 1:
            default:
                super.onAnimationEnd(animator);
                return;
            case 2:
                this.f26918b.m2973i(0);
                return;
            case 3:
                this.f26918b.m2973i(0);
                return;
            case 4:
                ViewGroup viewGroup3 = this.f26918b.f12361f;
                if (viewGroup3 != null) {
                    viewGroup3.setVisibility(4);
                    return;
                }
                return;
            case 5:
                ViewGroup viewGroup4 = this.f26918b.f12363h;
                if (viewGroup4 != null) {
                    viewGroup4.setVisibility(4);
                    return;
                }
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f26917a) {
            case 0:
                C0731m c0731m = this.f26918b;
                View view = c0731m.f12365j;
                if ((view instanceof DefaultTimeBar) && !c0731m.f12353A) {
                    ((DefaultTimeBar) view).hideScrubber(250L);
                    return;
                }
                return;
            case 1:
                C0731m c0731m2 = this.f26918b;
                View view2 = c0731m2.f12357b;
                int i = 0;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
                ViewGroup viewGroup = c0731m2.f12358c;
                if (viewGroup != null) {
                    viewGroup.setVisibility(0);
                }
                ViewGroup viewGroup2 = c0731m2.f12360e;
                if (viewGroup2 != null) {
                    if (!c0731m2.f12353A) {
                        i = 4;
                    }
                    viewGroup2.setVisibility(i);
                }
                View view3 = c0731m2.f12365j;
                if ((view3 instanceof DefaultTimeBar) && !c0731m2.f12353A) {
                    ((DefaultTimeBar) view3).showScrubber(250L);
                    return;
                }
                return;
            case 2:
                this.f26918b.m2973i(4);
                return;
            case 3:
                this.f26918b.m2973i(4);
                return;
            case 4:
                C0731m c0731m3 = this.f26918b;
                ViewGroup viewGroup3 = c0731m3.f12363h;
                if (viewGroup3 != null) {
                    viewGroup3.setVisibility(0);
                    c0731m3.f12363h.setTranslationX(r0.getWidth());
                    ViewGroup viewGroup4 = c0731m3.f12363h;
                    viewGroup4.scrollTo(viewGroup4.getWidth(), 0);
                    return;
                }
                return;
            default:
                ViewGroup viewGroup5 = this.f26918b.f12361f;
                if (viewGroup5 != null) {
                    viewGroup5.setVisibility(0);
                    return;
                }
                return;
        }
    }
}
