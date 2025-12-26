package p000;

import android.os.CancellationSignal;

/* loaded from: classes.dex */
public final class k72 implements CancellationSignal.OnCancelListener {

    /* renamed from: a */
    public final /* synthetic */ l72 f20769a;

    public k72(l72 l72Var) {
        this.f20769a = l72Var;
    }

    @Override // android.os.CancellationSignal.OnCancelListener
    public final void onCancel() {
        l72 l72Var = this.f20769a;
        l72Var.f22382e.m1569a();
        l72Var.cancel(false);
    }
}
