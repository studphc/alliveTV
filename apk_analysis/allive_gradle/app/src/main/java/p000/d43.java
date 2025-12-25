package p000;

import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.ViewTransition;
import androidx.constraintlayout.motion.widget.ViewTransitionController;
import androidx.constraintlayout.widget.SharedValues;

/* loaded from: classes.dex */
public final class d43 implements SharedValues.SharedValuesListener {

    /* renamed from: a */
    public final /* synthetic */ ViewTransition f16245a;

    /* renamed from: b */
    public final /* synthetic */ int f16246b;

    /* renamed from: c */
    public final /* synthetic */ boolean f16247c;

    /* renamed from: d */
    public final /* synthetic */ int f16248d;

    /* renamed from: e */
    public final /* synthetic */ ViewTransitionController f16249e;

    public d43(ViewTransitionController viewTransitionController, ViewTransition viewTransition, int i, boolean z, int i2) {
        this.f16249e = viewTransitionController;
        this.f16245a = viewTransition;
        this.f16246b = i;
        this.f16247c = z;
        this.f16248d = i2;
    }

    @Override // androidx.constraintlayout.widget.SharedValues.SharedValuesListener
    public final void onNewValue(int i, int i2, int i3) {
        ViewTransition viewTransition = this.f16245a;
        int sharedValueCurrent = viewTransition.getSharedValueCurrent();
        viewTransition.setSharedValueCurrent(i2);
        if (this.f16246b == i && sharedValueCurrent != i2) {
            ViewTransitionController viewTransitionController = this.f16249e;
            boolean z = this.f16247c;
            int i4 = this.f16248d;
            if (z) {
                if (i4 == i2) {
                    int childCount = viewTransitionController.f2978a.getChildCount();
                    for (int i5 = 0; i5 < childCount; i5++) {
                        MotionLayout motionLayout = viewTransitionController.f2978a;
                        View childAt = motionLayout.getChildAt(i5);
                        if (viewTransition.m601c(childAt)) {
                            int currentState = motionLayout.getCurrentState();
                            this.f16245a.m599a(viewTransitionController, viewTransitionController.f2978a, currentState, motionLayout.getConstraintSet(currentState), childAt);
                        }
                    }
                    return;
                }
                return;
            }
            if (i4 != i2) {
                int childCount2 = viewTransitionController.f2978a.getChildCount();
                for (int i6 = 0; i6 < childCount2; i6++) {
                    MotionLayout motionLayout2 = viewTransitionController.f2978a;
                    View childAt2 = motionLayout2.getChildAt(i6);
                    if (viewTransition.m601c(childAt2)) {
                        int currentState2 = motionLayout2.getCurrentState();
                        this.f16245a.m599a(viewTransitionController, viewTransitionController.f2978a, currentState2, motionLayout2.getConstraintSet(currentState2), childAt2);
                    }
                }
            }
        }
    }
}
