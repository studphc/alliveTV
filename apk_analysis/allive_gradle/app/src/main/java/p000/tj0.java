package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class tj0 extends SubscriptionArbiter implements FlowableSubscriber {
    private static final long serialVersionUID = 897683679971470653L;

    /* renamed from: h */
    public final AtomicInteger f26844h;

    /* renamed from: i */
    public long f26845i;

    /* JADX WARN: Multi-variable type inference failed */
    public tj0(uj0 uj0Var) {
        super(false);
        this.f26844h = (AtomicInteger) uj0Var;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.concurrent.atomic.AtomicInteger, uj0] */
    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        long j = this.f26845i;
        if (j != 0) {
            this.f26845i = 0L;
            produced(j);
        }
        this.f26844h.mo2260b();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.concurrent.atomic.AtomicInteger, uj0] */
    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        long j = this.f26845i;
        if (j != 0) {
            this.f26845i = 0L;
            produced(j);
        }
        this.f26844h.mo4587a(th);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.concurrent.atomic.AtomicInteger, uj0] */
    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        this.f26845i++;
        this.f26844h.mo4588c(obj);
    }
}
