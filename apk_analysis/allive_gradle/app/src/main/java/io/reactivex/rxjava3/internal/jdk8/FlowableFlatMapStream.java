package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import java.util.Objects;
import java.util.stream.Stream;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.em0;
import p000.ki0;

/* loaded from: classes2.dex */
public final class FlowableFlatMapStream<T, R> extends Flowable<R> {

    /* renamed from: b */
    public final Flowable f18535b;

    /* renamed from: c */
    public final Function f18536c;

    /* renamed from: d */
    public final int f18537d;

    public FlowableFlatMapStream(Flowable<T> flowable, Function<? super T, ? extends Stream<? extends R>> function, int i) {
        this.f18535b = flowable;
        this.f18536c = function;
        this.f18537d = i;
    }

    public static <T, R> Subscriber<T> subscribe(Subscriber<? super R> subscriber, Function<? super T, ? extends Stream<? extends R>> function, int i) {
        return new em0(subscriber, function, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        Stream stream;
        Publisher publisher = this.f18535b;
        boolean z = publisher instanceof Supplier;
        Function function = this.f18536c;
        if (z) {
            try {
                Object obj = ((Supplier) publisher).get();
                if (obj != null) {
                    Object apply = function.apply(obj);
                    Objects.requireNonNull(apply, "The mapper returned a null Stream");
                    stream = ki0.m5549q(apply);
                } else {
                    stream = null;
                }
                if (stream != null) {
                    FlowableFromStream.subscribeStream(subscriber, stream);
                    return;
                } else {
                    EmptySubscription.complete(subscriber);
                    return;
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptySubscription.error(th, subscriber);
                return;
            }
        }
        publisher.subscribe(subscribe(subscriber, function, this.f18537d));
    }
}
