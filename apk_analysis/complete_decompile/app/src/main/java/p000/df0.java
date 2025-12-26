package p000;

import java.util.concurrent.Flow;
import org.reactivestreams.Processor;

/* loaded from: classes2.dex */
public final class df0 implements Flow.Processor {

    /* renamed from: a */
    public final Processor f16355a;

    public df0(Processor processor) {
        this.f16355a = processor;
    }

    @Override // java.util.concurrent.Flow.Subscriber
    public final void onComplete() {
        this.f16355a.onComplete();
    }

    @Override // java.util.concurrent.Flow.Subscriber
    public final void onError(Throwable th) {
        this.f16355a.onError(th);
    }

    @Override // java.util.concurrent.Flow.Subscriber
    public final void onNext(Object obj) {
        this.f16355a.onNext(obj);
    }

    @Override // java.util.concurrent.Flow.Subscriber
    public final void onSubscribe(Flow.Subscription subscription) {
        jf0 jf0Var;
        Processor processor = this.f16355a;
        if (subscription == null) {
            jf0Var = null;
        } else {
            jf0Var = new jf0(subscription);
        }
        processor.onSubscribe(jf0Var);
    }

    @Override // java.util.concurrent.Flow.Publisher
    public final void subscribe(Flow.Subscriber subscriber) {
        if0 if0Var;
        Processor processor = this.f16355a;
        if (subscriber == null) {
            if0Var = null;
        } else {
            if0Var = new if0(subscriber);
        }
        processor.subscribe(if0Var);
    }
}
