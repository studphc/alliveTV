package androidx.constraintlayout.motion.widget;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.HashSet;
import p000.d43;

/* loaded from: classes.dex */
public class ViewTransitionController {

    /* renamed from: a */
    public final MotionLayout f2978a;

    /* renamed from: c */
    public HashSet f2980c;

    /* renamed from: e */
    public ArrayList f2982e;

    /* renamed from: b */
    public final ArrayList f2979b = new ArrayList();

    /* renamed from: d */
    public final String f2981d = "ViewTransitionController";

    /* renamed from: f */
    public final ArrayList f2983f = new ArrayList();

    public ViewTransitionController(MotionLayout motionLayout) {
        this.f2978a = motionLayout;
    }

    public void add(ViewTransition viewTransition) {
        this.f2979b.add(viewTransition);
        this.f2980c = null;
        if (viewTransition.getStateTransition() == 4) {
            ConstraintLayout.getSharedValues().addListener(viewTransition.getSharedValueID(), new d43(this, viewTransition, viewTransition.getSharedValueID(), true, viewTransition.getSharedValue()));
        } else if (viewTransition.getStateTransition() == 5) {
            ConstraintLayout.getSharedValues().addListener(viewTransition.getSharedValueID(), new d43(this, viewTransition, viewTransition.getSharedValueID(), false, viewTransition.getSharedValue()));
        }
    }
}
