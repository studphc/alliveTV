package p000;

import androidx.leanback.app.GuidedStepFragment;
import androidx.leanback.widget.GuidedAction;
import androidx.leanback.widget.GuidedActionAdapter;

/* loaded from: classes.dex */
public final class jy0 implements GuidedActionAdapter.ClickListener {

    /* renamed from: a */
    public final /* synthetic */ GuidedStepFragment f20680a;

    public jy0(GuidedStepFragment guidedStepFragment) {
        this.f20680a = guidedStepFragment;
    }

    @Override // androidx.leanback.widget.GuidedActionAdapter.ClickListener
    public final void onGuidedActionClicked(GuidedAction guidedAction) {
        GuidedStepFragment guidedStepFragment = this.f20680a;
        guidedStepFragment.onGuidedActionClicked(guidedAction);
        if (guidedStepFragment.isExpanded()) {
            guidedStepFragment.collapseAction(true);
        } else if (guidedAction.hasSubActions() || guidedAction.hasEditableActivatorView()) {
            guidedStepFragment.expandAction(guidedAction, true);
        }
    }
}
