package p000;

import androidx.leanback.widget.ObjectAdapter;

/* loaded from: classes.dex */
public final class s91 extends ObjectAdapter.DataObserver {

    /* renamed from: a */
    public final /* synthetic */ u91 f26322a;

    public s91(u91 u91Var) {
        this.f26322a = u91Var;
    }

    @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
    public final void onChanged() {
        u91 u91Var = this.f26322a;
        u91Var.m7683a();
        u91Var.notifyChanged();
    }
}
