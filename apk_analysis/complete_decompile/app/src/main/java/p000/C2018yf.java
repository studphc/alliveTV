package p000;

import androidx.leanback.transition.TransitionHelper;
import androidx.leanback.util.StateMachine;

/* renamed from: yf */
/* loaded from: classes.dex */
public final class C2018yf extends StateMachine.Condition {
    @Override // androidx.leanback.util.StateMachine.Condition
    public final boolean canProceed() {
        return !TransitionHelper.systemSupportsEntranceTransitions();
    }
}
