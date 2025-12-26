package p000;

/* loaded from: classes2.dex */
public final class iy1 extends jy1 {
    private static final long serialVersionUID = -7139995637533111443L;

    @Override // p000.jy1
    /* renamed from: a */
    public final void mo5141a() {
        this.f20681a.onComplete();
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object andSet = getAndSet(null);
        if (andSet != null) {
            this.f20681a.onNext(andSet);
        }
    }
}
