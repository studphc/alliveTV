package p000;

/* loaded from: classes2.dex */
public final class bp0 extends dp0 {
    private static final long serialVersionUID = -2680129890138081029L;

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        m4597d(0);
    }

    @Override // p000.dp0, org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.f16466j.cancel();
        this.f16464h.onError(th);
    }
}
