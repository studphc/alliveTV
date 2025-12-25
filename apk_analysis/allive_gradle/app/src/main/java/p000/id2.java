package p000;

/* loaded from: classes2.dex */
public final class id2 extends i92 {
    private static final long serialVersionUID = -8219729196779211169L;

    @Override // p000.i92
    /* renamed from: a */
    public final void mo4915a(Object obj) {
        ((Runnable) obj).run();
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        return "RunnableDisposable(disposed=" + isDisposed() + ", " + get() + ")";
    }
}
