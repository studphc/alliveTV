package p000;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.leanback.widget.BaseCardView;

/* renamed from: te */
/* loaded from: classes.dex */
public final class C1832te extends Animation {

    /* renamed from: a */
    public final /* synthetic */ int f26780a;

    /* renamed from: b */
    public final float f26781b;

    /* renamed from: c */
    public final float f26782c;

    /* renamed from: d */
    public final /* synthetic */ BaseCardView f26783d;

    public C1832te(BaseCardView baseCardView, float f, float f2, int i) {
        this.f26780a = i;
        switch (i) {
            case 1:
                this.f26783d = baseCardView;
                this.f26781b = f;
                this.f26782c = f2 - f;
                return;
            case 2:
                this.f26783d = baseCardView;
                this.f26781b = f;
                this.f26782c = f2 - f;
                return;
            default:
                this.f26783d = baseCardView;
                this.f26781b = f;
                this.f26782c = f2 - f;
                return;
        }
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float f, Transformation transformation) {
        switch (this.f26780a) {
            case 0:
                float f2 = (f * this.f26782c) + this.f26781b;
                BaseCardView baseCardView = this.f26783d;
                baseCardView.f5581o = f2;
                for (int i = 0; i < baseCardView.f5571e.size(); i++) {
                    ((View) baseCardView.f5571e.get(i)).setAlpha(baseCardView.f5581o);
                }
                return;
            case 1:
                float f3 = (f * this.f26782c) + this.f26781b;
                BaseCardView baseCardView2 = this.f26783d;
                baseCardView2.f5580n = f3;
                baseCardView2.requestLayout();
                return;
            default:
                float f4 = (f * this.f26782c) + this.f26781b;
                BaseCardView baseCardView3 = this.f26783d;
                baseCardView3.f5579m = f4;
                baseCardView3.requestLayout();
                return;
        }
    }
}
