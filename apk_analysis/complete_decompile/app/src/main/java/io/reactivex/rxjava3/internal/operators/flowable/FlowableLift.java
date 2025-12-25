package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableOperator;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;

/* loaded from: classes2.dex */
public final class FlowableLift<R, T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final FlowableOperator f18927b;

    public FlowableLift(Flowable<T> flowable, FlowableOperator<? extends R, ? super T> flowableOperator) {
        super(flowable);
        this.f18927b = flowableOperator;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        FlowableOperator flowableOperator = this.f18927b;
        try {
            Subscriber<? super Object> apply = flowableOperator.apply(subscriber);
            if (apply != null) {
                this.source.subscribe(apply);
                return;
            }
            throw new NullPointerException("Operator " + flowableOperator + " returned a null Subscriber");
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }
}
