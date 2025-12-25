package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Emitter;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.flowables.ConnectableFlowable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p000.an0;
import p000.bn0;
import p000.dn0;
import p000.en0;
import p000.fn0;
import p000.gn0;
import p000.hn0;
import p000.in0;
import p000.jn0;
import p000.zm0;

/* loaded from: classes2.dex */
public final class FlowableInternalHelper {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes2.dex */
    public static final class RequestMax implements Consumer<Subscription> {
        public static final RequestMax INSTANCE;

        /* renamed from: a */
        public static final /* synthetic */ RequestMax[] f18908a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Enum, io.reactivex.rxjava3.internal.operators.flowable.FlowableInternalHelper$RequestMax] */
        static {
            ?? r1 = new Enum("INSTANCE", 0);
            INSTANCE = r1;
            f18908a = new RequestMax[]{r1};
        }

        public static RequestMax valueOf(String str) {
            return (RequestMax) Enum.valueOf(RequestMax.class, str);
        }

        public static RequestMax[] values() {
            return (RequestMax[]) f18908a.clone();
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Subscription subscription) {
            subscription.request(Long.MAX_VALUE);
        }
    }

    public static <T, U> Function<T, Publisher<U>> flatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        return new bn0(function, 0);
    }

    public static <T, U, R> Function<T, Publisher<R>> flatMapWithCombiner(Function<? super T, ? extends Publisher<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return new dn0(function, biFunction, 0);
    }

    public static <T, U> Function<T, Publisher<T>> itemDelay(Function<? super T, ? extends Publisher<U>> function) {
        return new bn0(function, 1);
    }

    public static <T> Supplier<ConnectableFlowable<T>> replaySupplier(Flowable<T> flowable) {
        return new en0(0, flowable);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> simpleBiGenerator(BiConsumer<S, Emitter<T>> biConsumer) {
        return new fn0(biConsumer, 0);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> simpleGenerator(Consumer<Emitter<T>> consumer) {
        return new gn0(consumer, 0);
    }

    public static <T> Action subscriberOnComplete(Subscriber<T> subscriber) {
        return new hn0(0, subscriber);
    }

    public static <T> Consumer<Throwable> subscriberOnError(Subscriber<T> subscriber) {
        return new in0(subscriber, 0);
    }

    public static <T> Consumer<T> subscriberOnNext(Subscriber<T> subscriber) {
        return new in0(subscriber, 1);
    }

    public static <T> Supplier<ConnectableFlowable<T>> replaySupplier(Flowable<T> flowable, int i, boolean z) {
        return new zm0(flowable, i, z, 0);
    }

    public static <T> Supplier<ConnectableFlowable<T>> replaySupplier(Flowable<T> flowable, int i, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        return new an0(flowable, i, j, timeUnit, scheduler, z, 0);
    }

    public static <T> Supplier<ConnectableFlowable<T>> replaySupplier(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        return new jn0(flowable, j, timeUnit, scheduler, z, 0);
    }
}
