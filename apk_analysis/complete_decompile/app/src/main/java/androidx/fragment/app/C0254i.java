package androidx.fragment.app;

import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: androidx.fragment.app.i */
/* loaded from: classes.dex */
public final class C0254i extends DefaultSpecialEffectsController.SpecialEffectsInfo {

    /* renamed from: b */
    public final Object f4678b;

    /* renamed from: c */
    public final boolean f4679c;

    /* renamed from: d */
    public final Object f4680d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0254i(SpecialEffectsController.Operation operation, boolean z, boolean z2) {
        super(operation);
        Object exitTransition;
        boolean z3;
        Object obj;
        Intrinsics.checkNotNullParameter(operation, "operation");
        SpecialEffectsController.Operation.State finalState = operation.getFinalState();
        SpecialEffectsController.Operation.State state = SpecialEffectsController.Operation.State.VISIBLE;
        if (finalState == state) {
            Fragment fragment = operation.getFragment();
            if (z) {
                exitTransition = fragment.getReenterTransition();
            } else {
                exitTransition = fragment.getEnterTransition();
            }
        } else {
            Fragment fragment2 = operation.getFragment();
            if (z) {
                exitTransition = fragment2.getReturnTransition();
            } else {
                exitTransition = fragment2.getExitTransition();
            }
        }
        this.f4678b = exitTransition;
        if (operation.getFinalState() == state) {
            if (z) {
                z3 = operation.getFragment().getAllowReturnTransitionOverlap();
            } else {
                z3 = operation.getFragment().getAllowEnterTransitionOverlap();
            }
        } else {
            z3 = true;
        }
        this.f4679c = z3;
        if (z2) {
            if (z) {
                obj = operation.getFragment().getSharedElementReturnTransition();
            } else {
                obj = operation.getFragment().getSharedElementEnterTransition();
            }
        } else {
            obj = null;
        }
        this.f4680d = obj;
    }

    /* renamed from: a */
    public final FragmentTransitionImpl m1228a() {
        Object obj = this.f4678b;
        FragmentTransitionImpl m1229b = m1229b(obj);
        Object obj2 = this.f4680d;
        FragmentTransitionImpl m1229b2 = m1229b(obj2);
        if (m1229b != null && m1229b2 != null && m1229b != m1229b2) {
            throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + getOperation().getFragment() + " returned Transition " + obj + " which uses a different Transition  type than its shared element transition " + obj2).toString());
        }
        if (m1229b == null) {
            return m1229b2;
        }
        return m1229b;
    }

    /* renamed from: b */
    public final FragmentTransitionImpl m1229b(Object obj) {
        if (obj == null) {
            return null;
        }
        FragmentTransitionImpl fragmentTransitionImpl = FragmentTransition.PLATFORM_IMPL;
        if (fragmentTransitionImpl != null && fragmentTransitionImpl.canHandle(obj)) {
            return fragmentTransitionImpl;
        }
        FragmentTransitionImpl fragmentTransitionImpl2 = FragmentTransition.SUPPORT_IMPL;
        if (fragmentTransitionImpl2 != null && fragmentTransitionImpl2.canHandle(obj)) {
            return fragmentTransitionImpl2;
        }
        throw new IllegalArgumentException("Transition " + obj + " for fragment " + getOperation().getFragment() + " is not a valid framework Transition or AndroidX Transition");
    }
}
