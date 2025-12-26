package p000;

import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscribers.SinglePostCompleteSubscriber;
import java.util.Objects;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class qn0 extends SinglePostCompleteSubscriber {
    private static final long serialVersionUID = 2757120512858778108L;

    /* renamed from: a */
    public final Function f25695a;

    /* renamed from: b */
    public final Function f25696b;

    /* renamed from: c */
    public final Supplier f25697c;

    public qn0(Subscriber subscriber, Function function, Function function2, Supplier supplier) {
        super(subscriber);
        this.f25695a = function;
        this.f25696b = function2;
        this.f25697c = supplier;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        try {
            Object obj = this.f25697c.get();
            Objects.requireNonNull(obj, "The onComplete publisher returned is null");
            complete(obj);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.downstream.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        try {
            Object apply = this.f25696b.apply(th);
            Objects.requireNonNull(apply, "The onError publisher returned is null");
            complete(apply);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            this.downstream.onError(new CompositeException(th, th2));
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        try {
            Object apply = this.f25695a.apply(obj);
            Objects.requireNonNull(apply, "The onNext publisher returned is null");
            this.produced++;
            this.downstream.onNext(apply);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.downstream.onError(th);
        }
    }
}
