package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import p000.ij0;

/* loaded from: classes2.dex */
public final class FlowableCollectSingle<T, U> extends Single<U> implements FuseToFlowable<U> {

    /* renamed from: a */
    public final Flowable f18770a;

    /* renamed from: b */
    public final Supplier f18771b;

    /* renamed from: c */
    public final BiConsumer f18772c;

    public FlowableCollectSingle(Flowable<T> flowable, Supplier<? extends U> supplier, BiConsumer<? super U, ? super T> biConsumer) {
        this.f18770a = flowable;
        this.f18771b = supplier;
        this.f18772c = biConsumer;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.FuseToFlowable
    public Flowable<U> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableCollect(this.f18770a, this.f18771b, this.f18772c));
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super U> singleObserver) {
        try {
            Object obj = this.f18771b.get();
            Objects.requireNonNull(obj, "The initialSupplier returned a null value");
            this.f18770a.subscribe((FlowableSubscriber) new ij0(singleObserver, obj, this.f18772c));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, singleObserver);
        }
    }
}
