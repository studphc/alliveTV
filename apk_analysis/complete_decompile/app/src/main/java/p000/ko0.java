package p000;

import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscribers.SinglePostCompleteSubscriber;
import java.util.Objects;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class ko0 extends SinglePostCompleteSubscriber {
    private static final long serialVersionUID = -3740826063558713822L;

    /* renamed from: a */
    public final Function f20920a;

    public ko0(Subscriber subscriber, Function function) {
        super(subscriber);
        this.f20920a = function;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.downstream.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        try {
            Object apply = this.f20920a.apply(th);
            Objects.requireNonNull(apply, "The valueSupplier returned a null value");
            complete(apply);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            this.downstream.onError(new CompositeException(th, th2));
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        this.produced++;
        this.downstream.onNext(obj);
    }
}
