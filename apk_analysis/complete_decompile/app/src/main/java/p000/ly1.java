package p000;

/* loaded from: classes2.dex */
public final class ly1 extends my1 {
    private static final long serialVersionUID = -3029755663834015785L;

    @Override // p000.my1
    /* renamed from: a */
    public final void mo5800a() {
        this.f23160a.onComplete();
    }

    @Override // p000.my1
    /* renamed from: b */
    public final void mo5801b() {
        Object andSet = getAndSet(null);
        if (andSet != null) {
            this.f23160a.onNext(andSet);
        }
    }
}
