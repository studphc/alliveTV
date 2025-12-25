package p000;

import androidx.leanback.app.GuidedStepFragment;
import androidx.leanback.widget.GuidedAction;
import androidx.leanback.widget.GuidedActionAdapter;

/* loaded from: classes.dex */
public final class iy0 implements GuidedActionAdapter.EditListener {

    /* renamed from: a */
    public final /* synthetic */ GuidedStepFragment f20307a;

    public iy0(GuidedStepFragment guidedStepFragment) {
        this.f20307a = guidedStepFragment;
    }

    @Override // androidx.leanback.widget.GuidedActionAdapter.EditListener
    public final void onGuidedActionEditCanceled(GuidedAction guidedAction) {
        this.f20307a.onGuidedActionEditCanceled(guidedAction);
    }

    @Override // androidx.leanback.widget.GuidedActionAdapter.EditListener
    public final long onGuidedActionEditedAndProceed(GuidedAction guidedAction) {
        return this.f20307a.onGuidedActionEditedAndProceed(guidedAction);
    }

    @Override // androidx.leanback.widget.GuidedActionAdapter.EditListener
    public final void onImeClose() {
        this.f20307a.m1297d(false);
    }

    @Override // androidx.leanback.widget.GuidedActionAdapter.EditListener
    public final void onImeOpen() {
        this.f20307a.m1297d(true);
    }
}
