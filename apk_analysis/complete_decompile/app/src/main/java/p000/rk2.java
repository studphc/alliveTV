package p000;

import android.view.animation.Animation;
import com.hisona.allive.SlidingPanel;

/* loaded from: classes2.dex */
public final class rk2 implements Animation.AnimationListener {

    /* renamed from: a */
    public final /* synthetic */ int f26006a;

    /* renamed from: b */
    public final /* synthetic */ SlidingPanel f26007b;

    public /* synthetic */ rk2(SlidingPanel slidingPanel, int i) {
        this.f26006a = i;
        this.f26007b = slidingPanel;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        switch (this.f26006a) {
            case 0:
                SlidingPanel slidingPanel = this.f26007b;
                if (slidingPanel.f15949m) {
                    slidingPanel.f15939c.setVisibility(4);
                    slidingPanel.f15949m = false;
                    return;
                } else {
                    slidingPanel.f15949m = true;
                    return;
                }
            default:
                SlidingPanel slidingPanel2 = this.f26007b;
                if (slidingPanel2.f15949m) {
                    slidingPanel2.f15939c.setVisibility(4);
                    slidingPanel2.f15949m = false;
                    return;
                } else {
                    slidingPanel2.f15949m = true;
                    return;
                }
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
        int i = this.f26006a;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        int i = this.f26006a;
    }

    /* renamed from: a */
    private final void m7281a(Animation animation) {
    }

    /* renamed from: b */
    private final void m7282b(Animation animation) {
    }

    /* renamed from: c */
    private final void m7283c(Animation animation) {
    }

    /* renamed from: d */
    private final void m7284d(Animation animation) {
    }
}
