package androidx.constraintlayout.motion.widget;

import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintSet;

/* loaded from: classes.dex */
public class TransitionBuilder {
    public static MotionScene.Transition buildTransition(MotionScene motionScene, int i, int i2, ConstraintSet constraintSet, int i3, ConstraintSet constraintSet2) {
        MotionScene.Transition transition = new MotionScene.Transition(i, motionScene, i2, i3);
        int startConstraintSetId = transition.getStartConstraintSetId();
        int endConstraintSetId = transition.getEndConstraintSetId();
        motionScene.setConstraintSet(startConstraintSetId, constraintSet);
        motionScene.setConstraintSet(endConstraintSetId, constraintSet2);
        return transition;
    }

    public static void validate(MotionLayout motionLayout) {
        MotionScene motionScene = motionLayout.f2878r;
        if (motionScene != null) {
            if (motionScene.validateLayout(motionLayout)) {
                if (motionScene.f2898c != null && !motionScene.getDefinedTransitions().isEmpty()) {
                    return;
                } else {
                    throw new RuntimeException("Invalid motion layout. Motion Scene doesn't have any transition.");
                }
            }
            throw new RuntimeException("MotionLayout doesn't have the right motion scene.");
        }
        throw new RuntimeException("Invalid motion layout. Layout missing Motion Scene.");
    }
}
