package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import androidx.fragment.app.SpecialEffectsController;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;
import p000.jt0;

/* renamed from: androidx.fragment.app.u */
/* loaded from: classes.dex */
public final class C0266u extends SpecialEffectsController.Operation {

    /* renamed from: l */
    public final C0264s f4712l;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0266u(SpecialEffectsController.Operation.State finalState, SpecialEffectsController.Operation.LifecycleImpact lifecycleImpact, C0264s fragmentStateManager) {
        super(finalState, lifecycleImpact, r0);
        Intrinsics.checkNotNullParameter(finalState, "finalState");
        Intrinsics.checkNotNullParameter(lifecycleImpact, "lifecycleImpact");
        Intrinsics.checkNotNullParameter(fragmentStateManager, "fragmentStateManager");
        Fragment fragment = fragmentStateManager.f4692c;
        Intrinsics.checkNotNullExpressionValue(fragment, "fragmentStateManager.fragment");
        this.f4712l = fragmentStateManager;
    }

    @Override // androidx.fragment.app.SpecialEffectsController.Operation
    public final void complete$fragment_release() {
        super.complete$fragment_release();
        getFragment().f4460n = false;
        this.f4712l.m1240k();
    }

    @Override // androidx.fragment.app.SpecialEffectsController.Operation
    public final void onStart() {
        float f;
        if (getIsStarted()) {
            return;
        }
        super.onStart();
        SpecialEffectsController.Operation.LifecycleImpact lifecycleImpact = getLifecycleImpact();
        SpecialEffectsController.Operation.LifecycleImpact lifecycleImpact2 = SpecialEffectsController.Operation.LifecycleImpact.ADDING;
        C0264s c0264s = this.f4712l;
        if (lifecycleImpact == lifecycleImpact2) {
            Fragment fragment = c0264s.f4692c;
            Intrinsics.checkNotNullExpressionValue(fragment, "fragmentStateManager.fragment");
            View findFocus = fragment.f4428K.findFocus();
            if (findFocus != null) {
                fragment.m1137c().f20622t = findFocus;
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "requestFocus: Saved focused view " + findFocus + " for Fragment " + fragment);
                }
            }
            View requireView = getFragment().requireView();
            Intrinsics.checkNotNullExpressionValue(requireView, "this.fragment.requireView()");
            if (requireView.getParent() == null) {
                c0264s.m1231b();
                requireView.setAlpha(RecyclerView.f7068F0);
            }
            if (requireView.getAlpha() == RecyclerView.f7068F0 && requireView.getVisibility() == 0) {
                requireView.setVisibility(4);
            }
            jt0 jt0Var = fragment.f4431N;
            if (jt0Var == null) {
                f = 1.0f;
            } else {
                f = jt0Var.f20621s;
            }
            requireView.setAlpha(f);
            return;
        }
        if (getLifecycleImpact() == SpecialEffectsController.Operation.LifecycleImpact.REMOVING) {
            Fragment fragment2 = c0264s.f4692c;
            Intrinsics.checkNotNullExpressionValue(fragment2, "fragmentStateManager.fragment");
            View requireView2 = fragment2.requireView();
            Intrinsics.checkNotNullExpressionValue(requireView2, "fragment.requireView()");
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Clearing focus " + requireView2.findFocus() + " on view " + requireView2 + " for Fragment " + fragment2);
            }
            requireView2.clearFocus();
        }
    }
}
