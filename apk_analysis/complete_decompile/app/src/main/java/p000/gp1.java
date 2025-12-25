package p000;

import androidx.constraintlayout.motion.widget.MotionLayout;

/* loaded from: classes.dex */
public final class gp1 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f17790a;

    /* renamed from: b */
    public final /* synthetic */ MotionLayout f17791b;

    public /* synthetic */ gp1(MotionLayout motionLayout, int i) {
        this.f17790a = i;
        this.f17791b = motionLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f17790a) {
            case 0:
                this.f17791b.f2885u0.m5448a();
                return;
            case 1:
                this.f17791b.f2893y0 = false;
                return;
            default:
                this.f17791b.f2885u0.m5448a();
                return;
        }
    }
}
