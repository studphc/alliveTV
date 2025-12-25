package p000;

import android.animation.TimeAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.leanback.graphics.ColorOverlayDimmer;
import androidx.leanback.widget.ShadowOverlayContainer;
import androidx.leanback.widget.ShadowOverlayHelper;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class ss0 implements TimeAnimator.TimeListener {

    /* renamed from: a */
    public final View f26542a;

    /* renamed from: b */
    public final int f26543b;

    /* renamed from: c */
    public final ShadowOverlayContainer f26544c;

    /* renamed from: d */
    public final float f26545d;

    /* renamed from: e */
    public float f26546e = RecyclerView.f7068F0;

    /* renamed from: f */
    public float f26547f;

    /* renamed from: g */
    public float f26548g;

    /* renamed from: h */
    public final TimeAnimator f26549h;

    /* renamed from: i */
    public final AccelerateDecelerateInterpolator f26550i;

    /* renamed from: j */
    public final ColorOverlayDimmer f26551j;

    public ss0(View view, float f, boolean z, int i) {
        TimeAnimator timeAnimator = new TimeAnimator();
        this.f26549h = timeAnimator;
        this.f26550i = new AccelerateDecelerateInterpolator();
        this.f26542a = view;
        this.f26543b = i;
        this.f26545d = f - 1.0f;
        if (view instanceof ShadowOverlayContainer) {
            this.f26544c = (ShadowOverlayContainer) view;
        } else {
            this.f26544c = null;
        }
        timeAnimator.setTimeListener(this);
        if (z) {
            this.f26551j = ColorOverlayDimmer.createDefault(view.getContext());
        } else {
            this.f26551j = null;
        }
    }

    /* renamed from: a */
    public final void m7401a(boolean z, boolean z2) {
        float f;
        TimeAnimator timeAnimator = this.f26549h;
        timeAnimator.end();
        if (z) {
            f = 1.0f;
        } else {
            f = RecyclerView.f7068F0;
        }
        if (z2) {
            mo1498b(f);
            return;
        }
        float f2 = this.f26546e;
        if (f2 != f) {
            this.f26547f = f2;
            this.f26548g = f - f2;
            timeAnimator.start();
        }
    }

    /* renamed from: b */
    public void mo1498b(float f) {
        this.f26546e = f;
        float f2 = (this.f26545d * f) + 1.0f;
        View view = this.f26542a;
        view.setScaleX(f2);
        view.setScaleY(f2);
        ShadowOverlayContainer shadowOverlayContainer = this.f26544c;
        if (shadowOverlayContainer != null) {
            shadowOverlayContainer.setShadowFocusLevel(f);
        } else {
            ShadowOverlayHelper.setNoneWrapperShadowFocusLevel(view, f);
        }
        ColorOverlayDimmer colorOverlayDimmer = this.f26551j;
        if (colorOverlayDimmer != null) {
            colorOverlayDimmer.setActiveLevel(f);
            int color = colorOverlayDimmer.getPaint().getColor();
            if (shadowOverlayContainer != null) {
                shadowOverlayContainer.setOverlayColor(color);
            } else {
                ShadowOverlayHelper.setNoneWrapperOverlayColor(view, color);
            }
        }
    }

    @Override // android.animation.TimeAnimator.TimeListener
    public final void onTimeUpdate(TimeAnimator timeAnimator, long j, long j2) {
        float f;
        int i = this.f26543b;
        if (j >= i) {
            this.f26549h.end();
            f = 1.0f;
        } else {
            f = (float) (j / i);
        }
        AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = this.f26550i;
        if (accelerateDecelerateInterpolator != null) {
            f = accelerateDecelerateInterpolator.getInterpolation(f);
        }
        mo1498b((f * this.f26548g) + this.f26547f);
    }
}
