package p000;

import androidx.leanback.app.GuidedStepSupportFragment;
import androidx.leanback.widget.GuidedAction;
import androidx.leanback.widget.GuidedActionAdapter;

/* loaded from: classes.dex */
public final class py0 implements GuidedActionAdapter.ClickListener {

    /* renamed from: a */
    public final /* synthetic */ GuidedStepSupportFragment f25336a;

    public py0(GuidedStepSupportFragment guidedStepSupportFragment) {
        this.f25336a = guidedStepSupportFragment;
    }

    @Override // androidx.leanback.widget.GuidedActionAdapter.ClickListener
    public final void onGuidedActionClicked(GuidedAction guidedAction) {
        GuidedStepSupportFragment guidedStepSupportFragment = this.f25336a;
        if (!guidedStepSupportFragment.f5010g0.isInExpandTransition() && guidedStepSupportFragment.onSubGuidedActionClicked(guidedAction)) {
            guidedStepSupportFragment.collapseSubActions();
        }
    }
}
