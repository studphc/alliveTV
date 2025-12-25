package p000;

/* loaded from: classes2.dex */
public final class fv1 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ hv1 f17411a;

    public fv1(hv1 hv1Var) {
        this.f17411a = hv1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        hv1 hv1Var = this.f17411a;
        try {
            hv1Var.f18197a.onComplete();
        } finally {
            hv1Var.f18200d.dispose();
        }
    }
}
