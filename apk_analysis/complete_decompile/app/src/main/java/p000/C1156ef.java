package p000;

import androidx.leanback.transition.TransitionHelper;
import androidx.leanback.util.StateMachine;

/* renamed from: ef */
/* loaded from: classes.dex */
public final class C1156ef extends StateMachine.Condition {
    @Override // androidx.leanback.util.StateMachine.Condition
    public final boolean canProceed() {
        return !TransitionHelper.systemSupportsEntranceTransitions();
    }
}
