package p000;

/* loaded from: classes2.dex */
public final class al0 implements Runnable {

    /* renamed from: a */
    public final Throwable f253a;

    /* renamed from: b */
    public final /* synthetic */ bl0 f254b;

    public al0(bl0 bl0Var, Throwable th) {
        this.f254b = bl0Var;
        this.f253a = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        bl0 bl0Var = this.f254b;
        try {
            bl0Var.f8059a.onError(this.f253a);
        } finally {
            bl0Var.f8062d.dispose();
        }
    }
}
