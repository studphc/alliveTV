package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.Collection;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.gl0;

/* loaded from: classes2.dex */
public final class FlowableDistinct<T, K> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Function f18814b;

    /* renamed from: c */
    public final Supplier f18815c;

    public FlowableDistinct(Flowable<T> flowable, Function<? super T, K> function, Supplier<? extends Collection<? super K>> supplier) {
        super(flowable);
        this.f18814b = function;
        this.f18815c = supplier;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            this.source.subscribe((FlowableSubscriber<? super Object>) new gl0(subscriber, this.f18814b, (Collection) ExceptionHelper.nullCheck(this.f18815c.get(), "The collectionSupplier returned a null Collection.")));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
