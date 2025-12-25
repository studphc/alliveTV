package p000;

import androidx.constraintlayout.motion.widget.MotionInterpolator;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class hp1 extends MotionInterpolator {

    /* renamed from: a */
    public float f18125a = RecyclerView.f7068F0;

    /* renamed from: b */
    public float f18126b = RecyclerView.f7068F0;

    /* renamed from: c */
    public float f18127c;

    /* renamed from: d */
    public final /* synthetic */ MotionLayout f18128d;

    public hp1(MotionLayout motionLayout) {
        this.f18128d = motionLayout;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionInterpolator, android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        float f2 = this.f18125a;
        MotionLayout motionLayout = this.f18128d;
        if (f2 > RecyclerView.f7068F0) {
            float f3 = this.f18127c;
            if (f2 / f3 < f) {
                f = f2 / f3;
            }
            motionLayout.f2884u = f2 - (f3 * f);
            return ((f2 * f) - (((f3 * f) * f) / 2.0f)) + this.f18126b;
        }
        float f4 = this.f18127c;
        if ((-f2) / f4 < f) {
            f = (-f2) / f4;
        }
        motionLayout.f2884u = (f4 * f) + f2;
        return (((f4 * f) * f) / 2.0f) + (f2 * f) + this.f18126b;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionInterpolator
    public final float getVelocity() {
        return this.f18128d.f2884u;
    }
}
