package p000;

import android.view.View;

/* loaded from: classes.dex */
public final class l51 implements View.OnFocusChangeListener {

    /* renamed from: a */
    public final View.OnFocusChangeListener f22328a;

    /* renamed from: b */
    public boolean f22329b;

    /* renamed from: c */
    public qs0 f22330c;

    public l51(View.OnFocusChangeListener onFocusChangeListener, boolean z, qs0 qs0Var) {
        this.f22328a = onFocusChangeListener;
        this.f22329b = z;
        this.f22330c = qs0Var;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        if (this.f22329b) {
            view = (View) view.getParent();
        }
        this.f22330c.mo7143a(view, z);
        View.OnFocusChangeListener onFocusChangeListener = this.f22328a;
        if (onFocusChangeListener != null) {
            onFocusChangeListener.onFocusChange(view, z);
        }
    }
}
