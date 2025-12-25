package p000;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.C0264s;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.SpecialEffectsController;

/* loaded from: classes.dex */
public final class pt0 implements View.OnAttachStateChangeListener {

    /* renamed from: a */
    public final /* synthetic */ C0264s f25284a;

    /* renamed from: b */
    public final /* synthetic */ qt0 f25285b;

    public pt0(qt0 qt0Var, C0264s c0264s) {
        this.f25285b = qt0Var;
        this.f25284a = c0264s;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        C0264s c0264s = this.f25284a;
        Fragment fragment = c0264s.f4692c;
        c0264s.m1240k();
        SpecialEffectsController.getOrCreateController((ViewGroup) fragment.f4428K.getParent(), this.f25285b.f25743a).forceCompleteAllOperations();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
