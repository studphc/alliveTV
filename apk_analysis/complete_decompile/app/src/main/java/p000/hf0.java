package p000;

import java.util.concurrent.Flow;
import org.reactivestreams.Processor;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class hf0 implements Processor {

    /* renamed from: a */
    public final Flow.Processor f18045a;

    public hf0(Flow.Processor processor) {
        this.f18045a = processor;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f18045a.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.f18045a.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        this.f18045a.onNext(obj);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        ff0 ff0Var;
        Flow.Processor processor = this.f18045a;
        if (subscription == null) {
            ff0Var = null;
        } else {
            ff0Var = new ff0(subscription);
        }
        processor.onSubscribe(ff0Var);
    }

    @Override // org.reactivestreams.Publisher
    public final void subscribe(Subscriber subscriber) {
        ef0 ef0Var;
        Flow.Processor processor = this.f18045a;
        if (subscriber == null) {
            ef0Var = null;
        } else {
            ef0Var = new ef0(subscriber);
        }
        processor.subscribe(ef0Var);
    }
}
