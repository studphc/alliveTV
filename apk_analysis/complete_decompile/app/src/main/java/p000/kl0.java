package p000;

import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber;
import java.util.Objects;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class kl0 extends BasicFuseableSubscriber {

    /* renamed from: a */
    public final /* synthetic */ int f20888a;

    /* renamed from: b */
    public final Object f20889b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ kl0(Subscriber subscriber, Object obj, int i) {
        super(subscriber);
        this.f20888a = i;
        this.f20889b = obj;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        switch (this.f20888a) {
            case 0:
                if (!this.done) {
                    this.downstream.onNext(obj);
                    if (this.sourceMode == 0) {
                        try {
                            ((Consumer) this.f20889b).accept(obj);
                            return;
                        } catch (Throwable th) {
                            fail(th);
                            return;
                        }
                    }
                    return;
                }
                return;
            default:
                if (!this.done) {
                    if (this.sourceMode != 0) {
                        this.downstream.onNext(null);
                        return;
                    }
                    try {
                        Object apply = ((Function) this.f20889b).apply(obj);
                        Objects.requireNonNull(apply, "The mapper function returned a null value.");
                        this.downstream.onNext(apply);
                        return;
                    } catch (Throwable th2) {
                        fail(th2);
                        return;
                    }
                }
                return;
        }
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final Object poll() {
        switch (this.f20888a) {
            case 0:
                Object poll = this.f19889qs.poll();
                if (poll != null) {
                    ((Consumer) this.f20889b).accept(poll);
                }
                return poll;
            default:
                Object poll2 = this.f19889qs.poll();
                if (poll2 != null) {
                    Object apply = ((Function) this.f20889b).apply(poll2);
                    Objects.requireNonNull(apply, "The mapper function returned a null value.");
                    return apply;
                }
                return null;
        }
    }
}
