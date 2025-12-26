package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.Collection;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.sr0;

/* loaded from: classes2.dex */
public final class FlowableToList<T, U extends Collection<? super T>> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Supplier f19064b;

    public FlowableToList(Flowable<T> flowable, Supplier<U> supplier) {
        super(flowable);
        this.f19064b = supplier;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super U> subscriber) {
        try {
            this.source.subscribe((FlowableSubscriber<? super Object>) new sr0(subscriber, (Collection) ExceptionHelper.nullCheck(this.f19064b.get(), "The collectionSupplier returned a null Collection.")));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
