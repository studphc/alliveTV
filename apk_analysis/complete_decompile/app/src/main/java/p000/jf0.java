package p000;

import java.util.concurrent.Flow;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class jf0 implements Subscription {

    /* renamed from: a */
    public final Flow.Subscription f20487a;

    public jf0(Flow.Subscription subscription) {
        this.f20487a = subscription;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f20487a.cancel();
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        this.f20487a.request(j);
    }
}
