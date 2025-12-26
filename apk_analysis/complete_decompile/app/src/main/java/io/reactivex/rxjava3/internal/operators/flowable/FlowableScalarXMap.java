package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.ScalarSubscription;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.AbstractC0002a1;
import p000.hp0;

/* loaded from: classes2.dex */
public final class FlowableScalarXMap {
    public static <T, U> Flowable<U> scalarXMap(T t, Function<? super T, ? extends Publisher<? extends U>> function) {
        return RxJavaPlugins.onAssembly(new hp0(t, function, 1));
    }

    public static <T, R> boolean tryScalarXMapSubscribe(Publisher<T> publisher, Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function) {
        if (publisher instanceof Supplier) {
            try {
                AbstractC0002a1 abstractC0002a1 = (Object) ((Supplier) publisher).get();
                if (abstractC0002a1 == null) {
                    EmptySubscription.complete(subscriber);
                    return true;
                }
                try {
                    Publisher<? extends R> apply = function.apply(abstractC0002a1);
                    Objects.requireNonNull(apply, "The mapper returned a null Publisher");
                    Publisher<? extends R> publisher2 = apply;
                    if (publisher2 instanceof Supplier) {
                        try {
                            Object obj = ((Supplier) publisher2).get();
                            if (obj == null) {
                                EmptySubscription.complete(subscriber);
                                return true;
                            }
                            subscriber.onSubscribe(new ScalarSubscription(subscriber, obj));
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            EmptySubscription.error(th, subscriber);
                            return true;
                        }
                    } else {
                        publisher2.subscribe(subscriber);
                    }
                    return true;
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    EmptySubscription.error(th2, subscriber);
                    return true;
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                EmptySubscription.error(th3, subscriber);
                return true;
            }
        }
        return false;
    }
}
