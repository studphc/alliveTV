package p000;

import android.graphics.Rect;
import android.view.animation.Interpolator;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.motion.widget.MotionController;
import androidx.constraintlayout.motion.widget.ViewTransitionController;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class b43 {

    /* renamed from: a */
    public final int f7888a;

    /* renamed from: b */
    public final int f7889b;

    /* renamed from: c */
    public final MotionController f7890c;

    /* renamed from: d */
    public final int f7891d;

    /* renamed from: f */
    public final ViewTransitionController f7893f;

    /* renamed from: g */
    public final Interpolator f7894g;

    /* renamed from: i */
    public float f7896i;

    /* renamed from: j */
    public float f7897j;

    /* renamed from: m */
    public final boolean f7900m;

    /* renamed from: e */
    public final KeyCache f7892e = new KeyCache();

    /* renamed from: h */
    public boolean f7895h = false;

    /* renamed from: l */
    public final Rect f7899l = new Rect();

    /* renamed from: k */
    public long f7898k = System.nanoTime();

    public b43(ViewTransitionController viewTransitionController, MotionController motionController, int i, int i2, int i3, Interpolator interpolator, int i4, int i5) {
        float f;
        this.f7900m = false;
        this.f7893f = viewTransitionController;
        this.f7890c = motionController;
        this.f7891d = i2;
        if (viewTransitionController.f2982e == null) {
            viewTransitionController.f2982e = new ArrayList();
        }
        viewTransitionController.f2982e.add(this);
        this.f7894g = interpolator;
        this.f7888a = i4;
        this.f7889b = i5;
        if (i3 == 3) {
            this.f7900m = true;
        }
        if (i == 0) {
            f = Float.MAX_VALUE;
        } else {
            f = 1.0f / i;
        }
        this.f7897j = f;
        m2017a();
    }

    /* renamed from: a */
    public final void m2017a() {
        float interpolation;
        ViewTransitionController viewTransitionController;
        float interpolation2;
        boolean z = this.f7895h;
        ViewTransitionController viewTransitionController2 = this.f7893f;
        Interpolator interpolator = this.f7894g;
        MotionController motionController = this.f7890c;
        int i = this.f7889b;
        int i2 = this.f7888a;
        if (z) {
            long nanoTime = System.nanoTime();
            long j = nanoTime - this.f7898k;
            this.f7898k = nanoTime;
            float f = this.f7896i - (((float) (j * 1.0E-6d)) * this.f7897j);
            this.f7896i = f;
            if (f < RecyclerView.f7068F0) {
                this.f7896i = RecyclerView.f7068F0;
            }
            if (interpolator == null) {
                interpolation2 = this.f7896i;
            } else {
                interpolation2 = interpolator.getInterpolation(this.f7896i);
            }
            boolean m568f = motionController.m568f(motionController.f2797b, interpolation2, nanoTime, this.f7892e);
            if (this.f7896i <= RecyclerView.f7068F0) {
                if (i2 != -1) {
                    motionController.getView().setTag(i2, Long.valueOf(System.nanoTime()));
                }
                if (i != -1) {
                    motionController.getView().setTag(i, null);
                }
                viewTransitionController2.f2983f.add(this);
            }
            if (this.f7896i > RecyclerView.f7068F0 || m568f) {
                viewTransitionController2.f2978a.invalidate();
                return;
            }
            return;
        }
        long nanoTime2 = System.nanoTime();
        long j2 = nanoTime2 - this.f7898k;
        this.f7898k = nanoTime2;
        float f2 = (((float) (j2 * 1.0E-6d)) * this.f7897j) + this.f7896i;
        this.f7896i = f2;
        if (f2 >= 1.0f) {
            this.f7896i = 1.0f;
        }
        if (interpolator == null) {
            interpolation = this.f7896i;
        } else {
            interpolation = interpolator.getInterpolation(this.f7896i);
        }
        boolean m568f2 = motionController.m568f(motionController.f2797b, interpolation, nanoTime2, this.f7892e);
        if (this.f7896i >= 1.0f) {
            if (i2 != -1) {
                motionController.getView().setTag(i2, Long.valueOf(System.nanoTime()));
            }
            if (i != -1) {
                motionController.getView().setTag(i, null);
            }
            if (!this.f7900m) {
                viewTransitionController = viewTransitionController2;
                viewTransitionController.f2983f.add(this);
                if (this.f7896i >= 1.0f || m568f2) {
                    viewTransitionController.f2978a.invalidate();
                }
                return;
            }
        }
        viewTransitionController = viewTransitionController2;
        if (this.f7896i >= 1.0f) {
        }
        viewTransitionController.f2978a.invalidate();
    }

    /* renamed from: b */
    public final void m2018b() {
        float f;
        this.f7895h = true;
        int i = this.f7891d;
        if (i != -1) {
            if (i == 0) {
                f = Float.MAX_VALUE;
            } else {
                f = 1.0f / i;
            }
            this.f7897j = f;
        }
        this.f7893f.f2978a.invalidate();
        this.f7898k = System.nanoTime();
    }
}
