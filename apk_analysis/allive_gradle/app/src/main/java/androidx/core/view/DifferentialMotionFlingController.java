package androidx.core.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import p000.C1255h3;

/* loaded from: classes.dex */
public class DifferentialMotionFlingController {

    /* renamed from: a */
    public final Context f3859a;

    /* renamed from: b */
    public final DifferentialMotionFlingTarget f3860b;

    /* renamed from: c */
    public final C1255h3 f3861c;

    /* renamed from: d */
    public final C1255h3 f3862d;

    /* renamed from: e */
    public VelocityTracker f3863e;

    /* renamed from: f */
    public float f3864f;

    /* renamed from: g */
    public int f3865g;

    /* renamed from: h */
    public int f3866h;

    /* renamed from: i */
    public int f3867i;

    /* renamed from: j */
    public final int[] f3868j;

    public DifferentialMotionFlingController(@NonNull Context context, @NonNull DifferentialMotionFlingTarget differentialMotionFlingTarget) {
        C1255h3 c1255h3 = new C1255h3(19);
        C1255h3 c1255h32 = new C1255h3(20);
        this.f3865g = -1;
        this.f3866h = -1;
        this.f3867i = -1;
        this.f3868j = new int[]{Integer.MAX_VALUE, 0};
        this.f3859a = context;
        this.f3860b = differentialMotionFlingTarget;
        this.f3861c = c1255h3;
        this.f3862d = c1255h32;
    }

    public void onMotionEvent(@NonNull MotionEvent motionEvent, int i) {
        boolean z;
        int source = motionEvent.getSource();
        int deviceId = motionEvent.getDeviceId();
        int i2 = this.f3866h;
        int[] iArr = this.f3868j;
        if (i2 == source && this.f3867i == deviceId && this.f3865g == i) {
            z = false;
        } else {
            this.f3861c.getClass();
            Context context = this.f3859a;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            iArr[0] = ViewConfigurationCompat.getScaledMinimumFlingVelocity(context, viewConfiguration, motionEvent.getDeviceId(), i, motionEvent.getSource());
            iArr[1] = ViewConfigurationCompat.getScaledMaximumFlingVelocity(context, viewConfiguration, motionEvent.getDeviceId(), i, motionEvent.getSource());
            this.f3866h = source;
            this.f3867i = deviceId;
            this.f3865g = i;
            z = true;
        }
        if (iArr[0] == Integer.MAX_VALUE) {
            VelocityTracker velocityTracker = this.f3863e;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f3863e = null;
                return;
            }
            return;
        }
        if (this.f3863e == null) {
            this.f3863e = VelocityTracker.obtain();
        }
        VelocityTracker velocityTracker2 = this.f3863e;
        this.f3862d.getClass();
        VelocityTrackerCompat.addMovement(velocityTracker2, motionEvent);
        VelocityTrackerCompat.computeCurrentVelocity(velocityTracker2, 1000);
        float axisVelocity = VelocityTrackerCompat.getAxisVelocity(velocityTracker2, i);
        DifferentialMotionFlingTarget differentialMotionFlingTarget = this.f3860b;
        float scaledScrollFactor = differentialMotionFlingTarget.getScaledScrollFactor() * axisVelocity;
        float signum = Math.signum(scaledScrollFactor);
        float f = RecyclerView.f7068F0;
        if (z || (signum != Math.signum(this.f3864f) && signum != RecyclerView.f7068F0)) {
            differentialMotionFlingTarget.stopDifferentialMotionFling();
        }
        if (Math.abs(scaledScrollFactor) < iArr[0]) {
            return;
        }
        float max = Math.max(-r10, Math.min(scaledScrollFactor, iArr[1]));
        if (differentialMotionFlingTarget.startDifferentialMotionFling(max)) {
            f = max;
        }
        this.f3864f = f;
    }
}
