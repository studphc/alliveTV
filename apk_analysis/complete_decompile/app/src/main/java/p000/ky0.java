package p000;

import androidx.leanback.app.GuidedStepFragment;
import androidx.leanback.widget.GuidedAction;
import androidx.leanback.widget.GuidedActionAdapter;

/* loaded from: classes.dex */
public final class ky0 implements GuidedActionAdapter.ClickListener {

    /* renamed from: a */
    public final /* synthetic */ GuidedStepFragment f22246a;

    public ky0(GuidedStepFragment guidedStepFragment) {
        this.f22246a = guidedStepFragment;
    }

    @Override // androidx.leanback.widget.GuidedActionAdapter.ClickListener
    public final void onGuidedActionClicked(GuidedAction guidedAction) {
        this.f22246a.onGuidedActionClicked(guidedAction);
    }
}
