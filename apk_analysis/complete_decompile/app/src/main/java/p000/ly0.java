package p000;

import androidx.leanback.app.GuidedStepFragment;
import androidx.leanback.widget.GuidedAction;
import androidx.leanback.widget.GuidedActionAdapter;

/* loaded from: classes.dex */
public final class ly0 implements GuidedActionAdapter.ClickListener {

    /* renamed from: a */
    public final /* synthetic */ GuidedStepFragment f22720a;

    public ly0(GuidedStepFragment guidedStepFragment) {
        this.f22720a = guidedStepFragment;
    }

    @Override // androidx.leanback.widget.GuidedActionAdapter.ClickListener
    public final void onGuidedActionClicked(GuidedAction guidedAction) {
        GuidedStepFragment guidedStepFragment = this.f22720a;
        if (!guidedStepFragment.f4997c.isInExpandTransition() && guidedStepFragment.onSubGuidedActionClicked(guidedAction)) {
            guidedStepFragment.collapseSubActions();
        }
    }
}
