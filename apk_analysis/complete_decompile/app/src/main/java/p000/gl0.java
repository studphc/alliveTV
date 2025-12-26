package p000;

import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.Objects;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class gl0 extends BasicFuseableSubscriber {

    /* renamed from: a */
    public final Collection f17749a;

    /* renamed from: b */
    public final Function f17750b;

    public gl0(Subscriber subscriber, Function function, Collection collection) {
        super(subscriber);
        this.f17750b = function;
        this.f17749a = collection;
    }

    @Override // io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber, io.reactivex.rxjava3.operators.SimpleQueue
    public final void clear() {
        this.f17749a.clear();
        super.clear();
    }

    @Override // io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber, org.reactivestreams.Subscriber
    public final void onComplete() {
        if (!this.done) {
            this.done = true;
            this.f17749a.clear();
            this.downstream.onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber, org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.done) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.done = true;
        this.f17749a.clear();
        this.downstream.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (this.done) {
            return;
        }
        if (this.sourceMode == 0) {
            try {
                Object apply = this.f17750b.apply(obj);
                Objects.requireNonNull(apply, "The keySelector returned a null key");
                if (this.f17749a.add(apply)) {
                    this.downstream.onNext(obj);
                    return;
                } else {
                    this.upstream.request(1L);
                    return;
                }
            } catch (Throwable th) {
                fail(th);
                return;
            }
        }
        this.downstream.onNext(null);
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final Object poll() {
        Object poll;
        while (true) {
            poll = this.f19889qs.poll();
            if (poll == null) {
                break;
            }
            Object apply = this.f17750b.apply(poll);
            Objects.requireNonNull(apply, "The keySelector returned a null key");
            if (this.f17749a.add(apply)) {
                break;
            }
            if (this.sourceMode == 2) {
                this.upstream.request(1L);
            }
        }
        return poll;
    }
}
