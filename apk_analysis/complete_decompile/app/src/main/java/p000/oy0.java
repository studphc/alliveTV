package p000;

import androidx.leanback.app.GuidedStepSupportFragment;
import androidx.leanback.widget.GuidedAction;
import androidx.leanback.widget.GuidedActionAdapter;

/* loaded from: classes.dex */
public final class oy0 implements GuidedActionAdapter.ClickListener {

    /* renamed from: a */
    public final /* synthetic */ GuidedStepSupportFragment f24951a;

    public oy0(GuidedStepSupportFragment guidedStepSupportFragment) {
        this.f24951a = guidedStepSupportFragment;
    }

    @Override // androidx.leanback.widget.GuidedActionAdapter.ClickListener
    public final void onGuidedActionClicked(GuidedAction guidedAction) {
        this.f24951a.onGuidedActionClicked(guidedAction);
    }
}
