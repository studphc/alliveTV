package p000;

import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.processors.UnicastProcessor;

/* loaded from: classes2.dex */
public final class c03 extends BasicIntQueueSubscription {
    private static final long serialVersionUID = -4896760517184205454L;

    /* renamed from: a */
    public final /* synthetic */ UnicastProcessor f8221a;

    public c03(UnicastProcessor unicastProcessor) {
        this.f8221a = unicastProcessor;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (this.f8221a.f20080h) {
            return;
        }
        this.f8221a.f20080h = true;
        Runnable runnable = (Runnable) this.f8221a.f20075c.getAndSet(null);
        if (runnable != null) {
            runnable.run();
        }
        this.f8221a.f20079g.lazySet(null);
        if (this.f8221a.f20082j.getAndIncrement() == 0) {
            this.f8221a.f20079g.lazySet(null);
            UnicastProcessor unicastProcessor = this.f8221a;
            if (!unicastProcessor.f20084l) {
                unicastProcessor.f20074b.clear();
            }
        }
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final void clear() {
        this.f8221a.f20074b.clear();
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final boolean isEmpty() {
        return this.f8221a.f20074b.isEmpty();
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final Object poll() {
        return this.f8221a.f20074b.poll();
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            UnicastProcessor unicastProcessor = this.f8221a;
            BackpressureHelper.add(unicastProcessor.f20083k, j);
            unicastProcessor.m5317f();
        }
    }

    @Override // io.reactivex.rxjava3.operators.QueueFuseable
    public final int requestFusion(int i) {
        if ((i & 2) != 0) {
            this.f8221a.f20084l = true;
            return 2;
        }
        return 0;
    }
}
