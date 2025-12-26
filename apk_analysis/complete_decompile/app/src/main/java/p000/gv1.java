package p000;

/* loaded from: classes2.dex */
public final class gv1 implements Runnable {

    /* renamed from: a */
    public final Throwable f17848a;

    /* renamed from: b */
    public final /* synthetic */ hv1 f17849b;

    public gv1(hv1 hv1Var, Throwable th) {
        this.f17849b = hv1Var;
        this.f17848a = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        hv1 hv1Var = this.f17849b;
        try {
            hv1Var.f18197a.onError(this.f17848a);
        } finally {
            hv1Var.f18200d.dispose();
        }
    }
}
