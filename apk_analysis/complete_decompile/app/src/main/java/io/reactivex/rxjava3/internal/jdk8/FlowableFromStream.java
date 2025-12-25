package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.stream.Stream;
import org.reactivestreams.Subscriber;
import p000.qm0;
import p000.rm0;

/* loaded from: classes2.dex */
public final class FlowableFromStream<T> extends Flowable<T> {

    /* renamed from: c */
    public static final /* synthetic */ int f18539c = 0;

    /* renamed from: b */
    public final Stream f18540b;

    public FlowableFromStream(Stream<T> stream) {
        this.f18540b = stream;
    }

    public static <T> void subscribeStream(Subscriber<? super T> subscriber, Stream<T> stream) {
        Iterator it;
        try {
            it = stream.iterator();
            if (!it.hasNext()) {
                EmptySubscription.complete(subscriber);
                try {
                    stream.close();
                    return;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                    return;
                }
            }
            if (subscriber instanceof ConditionalSubscriber) {
                subscriber.onSubscribe(new qm0((ConditionalSubscriber) subscriber, it, stream));
            } else {
                subscriber.onSubscribe(new rm0(subscriber, it, stream));
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptySubscription.error(th2, subscriber);
            try {
                stream.close();
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                RxJavaPlugins.onError(th3);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        subscribeStream(subscriber, this.f18540b);
    }
}
