package p000;

import androidx.leanback.app.GuidedStepSupportFragment;
import androidx.leanback.widget.GuidedAction;
import androidx.leanback.widget.GuidedActionAdapter;

/* loaded from: classes.dex */
public final class my0 implements GuidedActionAdapter.EditListener {

    /* renamed from: a */
    public final /* synthetic */ GuidedStepSupportFragment f23159a;

    public my0(GuidedStepSupportFragment guidedStepSupportFragment) {
        this.f23159a = guidedStepSupportFragment;
    }

    @Override // androidx.leanback.widget.GuidedActionAdapter.EditListener
    public final void onGuidedActionEditCanceled(GuidedAction guidedAction) {
        this.f23159a.onGuidedActionEditCanceled(guidedAction);
    }

    @Override // androidx.leanback.widget.GuidedActionAdapter.EditListener
    public final long onGuidedActionEditedAndProceed(GuidedAction guidedAction) {
        return this.f23159a.onGuidedActionEditedAndProceed(guidedAction);
    }

    @Override // androidx.leanback.widget.GuidedActionAdapter.EditListener
    public final void onImeClose() {
        this.f23159a.m1301o(false);
    }

    @Override // androidx.leanback.widget.GuidedActionAdapter.EditListener
    public final void onImeOpen() {
        this.f23159a.m1301o(true);
    }
}
