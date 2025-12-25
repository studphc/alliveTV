package p000;

import android.view.View;
import android.view.animation.Animation;
import androidx.leanback.widget.BaseCardView;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: se */
/* loaded from: classes.dex */
public final class AnimationAnimationListenerC1795se implements Animation.AnimationListener {

    /* renamed from: a */
    public final /* synthetic */ int f26391a;

    /* renamed from: b */
    public final /* synthetic */ BaseCardView f26392b;

    public /* synthetic */ AnimationAnimationListenerC1795se(BaseCardView baseCardView, int i) {
        this.f26391a = i;
        this.f26392b = baseCardView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        switch (this.f26391a) {
            case 0:
                BaseCardView baseCardView = this.f26392b;
                if (baseCardView.f5579m == RecyclerView.f7068F0) {
                    for (int i = 0; i < baseCardView.f5572f.size(); i++) {
                        ((View) baseCardView.f5572f.get(i)).setVisibility(8);
                    }
                    return;
                }
                return;
            case 1:
                BaseCardView baseCardView2 = this.f26392b;
                if (baseCardView2.f5580n == RecyclerView.f7068F0) {
                    for (int i2 = 0; i2 < baseCardView2.f5571e.size(); i2++) {
                        ((View) baseCardView2.f5571e.get(i2)).setVisibility(8);
                    }
                    return;
                }
                return;
            default:
                BaseCardView baseCardView3 = this.f26392b;
                if (baseCardView3.f5581o == 0.0d) {
                    for (int i3 = 0; i3 < baseCardView3.f5571e.size(); i3++) {
                        ((View) baseCardView3.f5571e.get(i3)).setVisibility(8);
                    }
                    return;
                }
                return;
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
        int i = this.f26391a;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        int i = this.f26391a;
    }

    /* renamed from: a */
    private final void m7363a(Animation animation) {
    }

    /* renamed from: b */
    private final void m7364b(Animation animation) {
    }

    /* renamed from: c */
    private final void m7365c(Animation animation) {
    }

    /* renamed from: d */
    private final void m7366d(Animation animation) {
    }

    /* renamed from: e */
    private final void m7367e(Animation animation) {
    }

    /* renamed from: f */
    private final void m7368f(Animation animation) {
    }
}
