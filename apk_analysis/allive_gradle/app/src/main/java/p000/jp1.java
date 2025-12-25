package p000;

import androidx.constraintlayout.motion.widget.MotionLayout;

/* loaded from: classes.dex */
public final class jp1 {

    /* renamed from: a */
    public float f20575a = Float.NaN;

    /* renamed from: b */
    public float f20576b = Float.NaN;

    /* renamed from: c */
    public int f20577c = -1;

    /* renamed from: d */
    public int f20578d = -1;

    /* renamed from: e */
    public final /* synthetic */ MotionLayout f20579e;

    public jp1(MotionLayout motionLayout) {
        this.f20579e = motionLayout;
    }

    /* renamed from: a */
    public final void m5448a() {
        int i = this.f20577c;
        MotionLayout motionLayout = this.f20579e;
        if (i != -1 || this.f20578d != -1) {
            if (i == -1) {
                motionLayout.transitionToState(this.f20578d);
            } else {
                int i2 = this.f20578d;
                if (i2 == -1) {
                    motionLayout.setState(i, -1, -1);
                } else {
                    motionLayout.setTransition(i, i2);
                }
            }
            motionLayout.setState(kp1.f22136b);
        }
        if (Float.isNaN(this.f20576b)) {
            if (Float.isNaN(this.f20575a)) {
                return;
            }
            motionLayout.setProgress(this.f20575a);
        } else {
            motionLayout.setProgress(this.f20575a, this.f20576b);
            this.f20575a = Float.NaN;
            this.f20576b = Float.NaN;
            this.f20577c = -1;
            this.f20578d = -1;
        }
    }
}
