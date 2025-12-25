package p000;

import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class il0 extends BasicFuseableSubscriber implements ConditionalSubscriber {

    /* renamed from: a */
    public final Function f18456a;

    /* renamed from: b */
    public final BiPredicate f18457b;

    /* renamed from: c */
    public Object f18458c;

    /* renamed from: d */
    public boolean f18459d;

    public il0(Subscriber subscriber, Function function, BiPredicate biPredicate) {
        super(subscriber);
        this.f18456a = function;
        this.f18457b = biPredicate;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (!tryOnNext(obj)) {
            this.upstream.request(1L);
        }
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final Object poll() {
        while (true) {
            Object poll = this.f19889qs.poll();
            if (poll == null) {
                return null;
            }
            Object apply = this.f18456a.apply(poll);
            if (!this.f18459d) {
                this.f18459d = true;
                this.f18458c = apply;
                return poll;
            }
            if (!this.f18457b.test(this.f18458c, apply)) {
                this.f18458c = apply;
                return poll;
            }
            this.f18458c = apply;
            if (this.sourceMode != 1) {
                this.upstream.request(1L);
            }
        }
    }

    @Override // io.reactivex.rxjava3.operators.ConditionalSubscriber
    public final boolean tryOnNext(Object obj) {
        if (this.done) {
            return false;
        }
        if (this.sourceMode != 0) {
            this.downstream.onNext(obj);
            return true;
        }
        try {
            Object apply = this.f18456a.apply(obj);
            if (this.f18459d) {
                boolean test = this.f18457b.test(this.f18458c, apply);
                this.f18458c = apply;
                if (test) {
                    return false;
                }
            } else {
                this.f18459d = true;
                this.f18458c = apply;
            }
            this.downstream.onNext(obj);
            return true;
        } catch (Throwable th) {
            fail(th);
            return true;
        }
    }
}
