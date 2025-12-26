package p000;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.observers.SerializedObserver;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class ky1 extends my1 {
    private static final long serialVersionUID = -3029755663834015785L;

    /* renamed from: e */
    public final AtomicInteger f22247e;

    /* renamed from: f */
    public volatile boolean f22248f;

    public ky1(SerializedObserver serializedObserver, ObservableSource observableSource) {
        super(serializedObserver, observableSource);
        this.f22247e = new AtomicInteger();
    }

    @Override // p000.my1
    /* renamed from: a */
    public final void mo5800a() {
        this.f22248f = true;
        if (this.f22247e.getAndIncrement() == 0) {
            Object andSet = getAndSet(null);
            if (andSet != null) {
                this.f23160a.onNext(andSet);
            }
            this.f23160a.onComplete();
        }
    }

    @Override // p000.my1
    /* renamed from: b */
    public final void mo5801b() {
        if (this.f22247e.getAndIncrement() != 0) {
            return;
        }
        do {
            boolean z = this.f22248f;
            Object andSet = getAndSet(null);
            if (andSet != null) {
                this.f23160a.onNext(andSet);
            }
            if (z) {
                this.f23160a.onComplete();
                return;
            }
        } while (this.f22247e.decrementAndGet() != 0);
    }
}
