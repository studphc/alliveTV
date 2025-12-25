package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.core.motion.utils.SpringStopEngine;
import androidx.constraintlayout.core.motion.utils.StopEngine;
import androidx.constraintlayout.core.motion.utils.StopLogicEngine;
import androidx.constraintlayout.motion.widget.MotionInterpolator;

/* loaded from: classes.dex */
public class StopLogic extends MotionInterpolator {

    /* renamed from: a */
    public final StopLogicEngine f2684a;

    /* renamed from: b */
    public SpringStopEngine f2685b;

    /* renamed from: c */
    public StopEngine f2686c;

    public StopLogic() {
        StopLogicEngine stopLogicEngine = new StopLogicEngine();
        this.f2684a = stopLogicEngine;
        this.f2686c = stopLogicEngine;
    }

    public void config(float f, float f2, float f3, float f4, float f5, float f6) {
        StopLogicEngine stopLogicEngine = this.f2684a;
        this.f2686c = stopLogicEngine;
        stopLogicEngine.config(f, f2, f3, f4, f5, f6);
    }

    public String debug(String str, float f) {
        return this.f2686c.debug(str, f);
    }

    @Override // androidx.constraintlayout.motion.widget.MotionInterpolator, android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return this.f2686c.getInterpolation(f);
    }

    public float getVelocity(float f) {
        return this.f2686c.getVelocity(f);
    }

    public boolean isStopped() {
        return this.f2686c.isStopped();
    }

    public void springConfig(float f, float f2, float f3, float f4, float f5, float f6, float f7, int i) {
        if (this.f2685b == null) {
            this.f2685b = new SpringStopEngine();
        }
        SpringStopEngine springStopEngine = this.f2685b;
        this.f2686c = springStopEngine;
        springStopEngine.springConfig(f, f2, f3, f4, f5, f6, f7, i);
    }

    @Override // androidx.constraintlayout.motion.widget.MotionInterpolator
    public float getVelocity() {
        return this.f2686c.getVelocity();
    }
}
