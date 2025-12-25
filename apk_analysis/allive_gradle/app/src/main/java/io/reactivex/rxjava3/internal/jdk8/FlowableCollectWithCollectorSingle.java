package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import p000.kj0;

/* loaded from: classes2.dex */
public final class FlowableCollectWithCollectorSingle<T, A, R> extends Single<R> implements FuseToFlowable<R> {

    /* renamed from: a */
    public final Flowable f18531a;

    /* renamed from: b */
    public final Collector f18532b;

    public FlowableCollectWithCollectorSingle(Flowable<T> flowable, Collector<? super T, A, R> collector) {
        this.f18531a = flowable;
        this.f18532b = collector;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.FuseToFlowable
    public Flowable<R> fuseToFlowable() {
        return new FlowableCollectWithCollector(this.f18531a, this.f18532b);
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(@NonNull SingleObserver<? super R> singleObserver) {
        Supplier supplier;
        Object obj;
        BiConsumer accumulator;
        Function finisher;
        try {
            supplier = this.f18532b.supplier();
            obj = supplier.get();
            accumulator = this.f18532b.accumulator();
            finisher = this.f18532b.finisher();
            this.f18531a.subscribe((FlowableSubscriber) new kj0(singleObserver, obj, accumulator, finisher));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, singleObserver);
        }
    }
}
