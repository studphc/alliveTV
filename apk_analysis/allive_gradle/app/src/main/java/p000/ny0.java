package p000;

import androidx.leanback.app.GuidedStepSupportFragment;
import androidx.leanback.widget.GuidedAction;
import androidx.leanback.widget.GuidedActionAdapter;

/* loaded from: classes.dex */
public final class ny0 implements GuidedActionAdapter.ClickListener {

    /* renamed from: a */
    public final /* synthetic */ GuidedStepSupportFragment f23530a;

    public ny0(GuidedStepSupportFragment guidedStepSupportFragment) {
        this.f23530a = guidedStepSupportFragment;
    }

    @Override // androidx.leanback.widget.GuidedActionAdapter.ClickListener
    public final void onGuidedActionClicked(GuidedAction guidedAction) {
        GuidedStepSupportFragment guidedStepSupportFragment = this.f23530a;
        guidedStepSupportFragment.onGuidedActionClicked(guidedAction);
        if (guidedStepSupportFragment.isExpanded()) {
            guidedStepSupportFragment.collapseAction(true);
        } else if (guidedAction.hasSubActions() || guidedAction.hasEditableActivatorView()) {
            guidedStepSupportFragment.expandAction(guidedAction, true);
        }
    }
}
