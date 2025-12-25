package p000;

/* loaded from: classes2.dex */
public final class zk0 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ bl0 f29406a;

    public zk0(bl0 bl0Var) {
        this.f29406a = bl0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        bl0 bl0Var = this.f29406a;
        try {
            bl0Var.f8059a.onComplete();
        } finally {
            bl0Var.f8062d.dispose();
        }
    }
}
