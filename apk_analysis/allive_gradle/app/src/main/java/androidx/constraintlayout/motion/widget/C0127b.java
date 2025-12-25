package androidx.constraintlayout.motion.widget;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.constraintlayout.motion.widget.b */
/* loaded from: classes.dex */
public final class C0127b implements MotionLayout.MotionTracker {

    /* renamed from: b */
    public static final C0127b f2991b = new Object();

    /* renamed from: a */
    public VelocityTracker f2992a;

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
    public final void addMovement(MotionEvent motionEvent) {
        VelocityTracker velocityTracker = this.f2992a;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
    public final void clear() {
        VelocityTracker velocityTracker = this.f2992a;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
    public final void computeCurrentVelocity(int i) {
        VelocityTracker velocityTracker = this.f2992a;
        if (velocityTracker != null) {
            velocityTracker.computeCurrentVelocity(i);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
    public final float getXVelocity() {
        VelocityTracker velocityTracker = this.f2992a;
        return velocityTracker != null ? velocityTracker.getXVelocity() : RecyclerView.f7068F0;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
    public final float getYVelocity() {
        VelocityTracker velocityTracker = this.f2992a;
        return velocityTracker != null ? velocityTracker.getYVelocity() : RecyclerView.f7068F0;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
    public final void recycle() {
        VelocityTracker velocityTracker = this.f2992a;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f2992a = null;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
    public final void computeCurrentVelocity(int i, float f) {
        VelocityTracker velocityTracker = this.f2992a;
        if (velocityTracker != null) {
            velocityTracker.computeCurrentVelocity(i, f);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
    public final float getXVelocity(int i) {
        VelocityTracker velocityTracker = this.f2992a;
        return velocityTracker != null ? velocityTracker.getXVelocity(i) : RecyclerView.f7068F0;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
    public final float getYVelocity(int i) {
        return this.f2992a != null ? getYVelocity(i) : RecyclerView.f7068F0;
    }
}
