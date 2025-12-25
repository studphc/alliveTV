package p000;

import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import io.reactivex.rxjava3.operators.QueueSubscription;
import java.util.Objects;
import java.util.Optional;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class tl0 extends BasicFuseableSubscriber implements ConditionalSubscriber {

    /* renamed from: a */
    public final /* synthetic */ int f26864a;

    /* renamed from: b */
    public final Object f26865b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ tl0(Subscriber subscriber, Object obj, int i) {
        super(subscriber);
        this.f26864a = i;
        this.f26865b = obj;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        switch (this.f26864a) {
            case 0:
                if (!tryOnNext(obj)) {
                    this.upstream.request(1L);
                    return;
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
        boolean isPresent;
        Object obj;
        switch (this.f26864a) {
            case 0:
                QueueSubscription<T> queueSubscription = this.f19889qs;
                while (true) {
                    Object poll = queueSubscription.poll();
                    if (poll == null) {
                        return null;
                    }
                    if (((Predicate) this.f26865b).test(poll)) {
                        return poll;
                    }
                    if (this.sourceMode == 2) {
                        queueSubscription.request(1L);
                    }
                }
        }
        while (true) {
            Object poll2 = this.f19889qs.poll();
            if (poll2 == null) {
                return null;
            }
            Object apply = ((Function) this.f26865b).apply(poll2);
            Objects.requireNonNull(apply, "The mapper returned a null Optional");
            Optional m5540h = ki0.m5540h(apply);
            isPresent = m5540h.isPresent();
            if (isPresent) {
                obj = m5540h.get();
                return obj;
            }
            if (this.sourceMode == 2) {
                this.f19889qs.request(1L);
            }
        }
    }

    @Override // io.reactivex.rxjava3.operators.ConditionalSubscriber
    public final boolean tryOnNext(Object obj) {
        boolean isPresent;
        Object obj2;
        switch (this.f26864a) {
            case 0:
                if (this.done) {
                    return false;
                }
                if (this.sourceMode != 0) {
                    this.downstream.onNext(null);
                } else {
                    try {
                        boolean test = ((Predicate) this.f26865b).test(obj);
                        if (test) {
                            this.downstream.onNext(obj);
                        }
                        return test;
                    } catch (Throwable th) {
                        fail(th);
                    }
                }
                return true;
            default:
                if (this.done) {
                    return true;
                }
                if (this.sourceMode != 0) {
                    this.downstream.onNext(null);
                    return true;
                }
                try {
                    Object apply = ((Function) this.f26865b).apply(obj);
                    Objects.requireNonNull(apply, "The mapper returned a null Optional");
                    Optional m5540h = ki0.m5540h(apply);
                    isPresent = m5540h.isPresent();
                    if (isPresent) {
                        Subscriber<? super R> subscriber = this.downstream;
                        obj2 = m5540h.get();
                        subscriber.onNext(obj2);
                        return true;
                    }
                    return false;
                } catch (Throwable th2) {
                    fail(th2);
                    return true;
                }
        }
    }
}
