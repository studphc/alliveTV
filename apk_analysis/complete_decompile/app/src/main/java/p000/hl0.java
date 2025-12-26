package p000;

import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;

/* loaded from: classes2.dex */
public final class hl0 extends BasicFuseableConditionalSubscriber {

    /* renamed from: a */
    public final Function f18090a;

    /* renamed from: b */
    public final BiPredicate f18091b;

    /* renamed from: c */
    public Object f18092c;

    /* renamed from: d */
    public boolean f18093d;

    public hl0(ConditionalSubscriber conditionalSubscriber, Function function, BiPredicate biPredicate) {
        super(conditionalSubscriber);
        this.f18090a = function;
        this.f18091b = biPredicate;
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
            Object poll = this.f19888qs.poll();
            if (poll == null) {
                return null;
            }
            Object apply = this.f18090a.apply(poll);
            if (!this.f18093d) {
                this.f18093d = true;
                this.f18092c = apply;
                return poll;
            }
            if (!this.f18091b.test(this.f18092c, apply)) {
                this.f18092c = apply;
                return poll;
            }
            this.f18092c = apply;
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
            return this.downstream.tryOnNext(obj);
        }
        try {
            Object apply = this.f18090a.apply(obj);
            if (this.f18093d) {
                boolean test = this.f18091b.test(this.f18092c, apply);
                this.f18092c = apply;
                if (test) {
                    return false;
                }
            } else {
                this.f18093d = true;
                this.f18092c = apply;
            }
            this.downstream.onNext(obj);
            return true;
        } catch (Throwable th) {
            fail(th);
            return true;
        }
    }
}
