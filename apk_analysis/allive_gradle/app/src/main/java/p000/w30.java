package p000;

import android.app.Dialog;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentContainer;

/* loaded from: classes.dex */
public final class w30 extends FragmentContainer {

    /* renamed from: a */
    public final /* synthetic */ ht0 f28053a;

    /* renamed from: b */
    public final /* synthetic */ DialogFragment f28054b;

    public w30(DialogFragment dialogFragment, ht0 ht0Var) {
        this.f28054b = dialogFragment;
        this.f28053a = ht0Var;
    }

    @Override // androidx.fragment.app.FragmentContainer
    public final View onFindViewById(int i) {
        ht0 ht0Var = this.f28053a;
        if (ht0Var.onHasView()) {
            return ht0Var.onFindViewById(i);
        }
        Dialog dialog = this.f28054b.f4412p0;
        if (dialog != null) {
            return dialog.findViewById(i);
        }
        return null;
    }

    @Override // androidx.fragment.app.FragmentContainer
    public final boolean onHasView() {
        if (!this.f28053a.onHasView() && !this.f28054b.f4416t0) {
            return false;
        }
        return true;
    }
}
