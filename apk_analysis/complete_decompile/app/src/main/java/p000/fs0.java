package p000;

/* loaded from: classes2.dex */
public final class fs0 implements Runnable {

    /* renamed from: a */
    public final gs0 f17392a;

    /* renamed from: b */
    public final long f17393b;

    public fs0(gs0 gs0Var, long j) {
        this.f17392a = gs0Var;
        this.f17393b = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        gs0 gs0Var = this.f17392a;
        gs0Var.f16960b.offer(this);
        gs0Var.mo4752c();
    }
}
