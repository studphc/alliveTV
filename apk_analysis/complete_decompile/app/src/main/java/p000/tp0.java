package p000;

/* loaded from: classes2.dex */
public final class tp0 extends dp0 {
    private static final long serialVersionUID = -2680129890138081029L;

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f16466j.cancel();
        this.f16464h.onComplete();
    }
}
