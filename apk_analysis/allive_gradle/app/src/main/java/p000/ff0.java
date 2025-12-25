package p000;

import java.util.concurrent.Flow;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class ff0 implements Flow.Subscription {

    /* renamed from: a */
    public final Subscription f17240a;

    public ff0(Subscription subscription) {
        this.f17240a = subscription;
    }

    @Override // java.util.concurrent.Flow.Subscription
    public final void cancel() {
        this.f17240a.cancel();
    }

    @Override // java.util.concurrent.Flow.Subscription
    public final void request(long j) {
        this.f17240a.request(j);
    }
}
