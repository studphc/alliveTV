package p000;

import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;

/* loaded from: classes2.dex */
public final class up0 extends wp0 {
    private static final long serialVersionUID = -3029755663834015785L;

    /* renamed from: f */
    public final AtomicInteger f27399f;

    /* renamed from: g */
    public volatile boolean f27400g;

    public up0(SerializedSubscriber serializedSubscriber, Publisher publisher) {
        super(serializedSubscriber, publisher);
        this.f27399f = new AtomicInteger();
    }

    @Override // p000.wp0
    /* renamed from: a */
    public final void mo7759a() {
        this.f27400g = true;
        if (this.f27399f.getAndIncrement() == 0) {
            m8070b();
            this.f28264a.onComplete();
        }
    }

    @Override // p000.wp0
    /* renamed from: c */
    public final void mo7760c() {
        if (this.f27399f.getAndIncrement() != 0) {
            return;
        }
        do {
            boolean z = this.f27400g;
            m8070b();
            if (z) {
                this.f28264a.onComplete();
                return;
            }
        } while (this.f27399f.decrementAndGet() != 0);
    }
}
