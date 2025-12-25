package p000;

/* loaded from: classes2.dex */
public final class h02 implements Runnable {

    /* renamed from: a */
    public final i02 f17906a;

    /* renamed from: b */
    public final long f17907b;

    public h02(i02 i02Var, long j) {
        this.f17906a = i02Var;
        this.f17907b = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i02 i02Var = this.f17906a;
        i02Var.f17503b.offer(this);
        i02Var.mo4898c();
    }
}
