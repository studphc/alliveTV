package p000;

import android.view.VelocityTracker;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class o13 {
    @DoNotInline
    /* renamed from: a */
    public static float m6404a(VelocityTracker velocityTracker, int i) {
        return velocityTracker.getAxisVelocity(i);
    }

    @DoNotInline
    /* renamed from: b */
    public static float m6405b(VelocityTracker velocityTracker, int i, int i2) {
        return velocityTracker.getAxisVelocity(i, i2);
    }

    @DoNotInline
    /* renamed from: c */
    public static boolean m6406c(VelocityTracker velocityTracker, int i) {
        return velocityTracker.isAxisSupported(i);
    }
}
