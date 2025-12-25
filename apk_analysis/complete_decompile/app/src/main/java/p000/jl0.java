package p000;

import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import io.reactivex.rxjava3.operators.QueueSubscription;

/* loaded from: classes2.dex */
public final class jl0 extends BasicFuseableConditionalSubscriber {

    /* renamed from: a */
    public final /* synthetic */ int f20538a;

    /* renamed from: b */
    public final Object f20539b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ jl0(ConditionalSubscriber conditionalSubscriber, Object obj, int i) {
        super(conditionalSubscriber);
        this.f20538a = i;
        this.f20539b = obj;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        switch (this.f20538a) {
            case 0:
                this.downstream.onNext(obj);
                if (this.sourceMode == 0) {
                    try {
                        ((Consumer) this.f20539b).accept(obj);
                        return;
                    } catch (Throwable th) {
                        fail(th);
                        return;
                    }
                }
                return;
            default:
                if (!tryOnNext(obj)) {
                    this.upstream.request(1L);
                    return;
                }
                return;
        }
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final Object poll() {
        switch (this.f20538a) {
            case 0:
                Object poll = this.f19888qs.poll();
                if (poll != null) {
                    ((Consumer) this.f20539b).accept(poll);
                }
                return poll;
            default:
                QueueSubscription<T> queueSubscription = this.f19888qs;
                while (true) {
                    Object poll2 = queueSubscription.poll();
                    if (poll2 == null) {
                        return null;
                    }
                    if (((Predicate) this.f20539b).test(poll2)) {
                        return poll2;
                    }
                    if (this.sourceMode == 2) {
                        queueSubscription.request(1L);
                    }
                }
        }
    }

    @Override // io.reactivex.rxjava3.operators.ConditionalSubscriber
    public final boolean tryOnNext(Object obj) {
        switch (this.f20538a) {
            case 0:
                boolean tryOnNext = this.downstream.tryOnNext(obj);
                try {
                    ((Consumer) this.f20539b).accept(obj);
                } catch (Throwable th) {
                    fail(th);
                }
                return tryOnNext;
            default:
                if (this.done) {
                    return false;
                }
                if (this.sourceMode != 0) {
                    return this.downstream.tryOnNext(null);
                }
                try {
                    if (!((Predicate) this.f20539b).test(obj) || !this.downstream.tryOnNext(obj)) {
                        return false;
                    }
                } catch (Throwable th2) {
                    fail(th2);
                }
                return true;
        }
    }
}
