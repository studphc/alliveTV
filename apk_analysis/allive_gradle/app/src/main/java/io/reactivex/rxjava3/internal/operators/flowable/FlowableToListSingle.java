package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.internal.util.ArrayListSupplier;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Collection;
import p000.nn0;

/* loaded from: classes2.dex */
public final class FlowableToListSingle<T, U extends Collection<? super T>> extends Single<U> implements FuseToFlowable<U> {

    /* renamed from: a */
    public final Flowable f19065a;

    /* renamed from: b */
    public final Supplier f19066b;

    public FlowableToListSingle(Flowable<T> flowable) {
        this(flowable, ArrayListSupplier.asSupplier());
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.FuseToFlowable
    public Flowable<U> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableToList(this.f19065a, this.f19066b));
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super U> singleObserver) {
        try {
            this.f19065a.subscribe((FlowableSubscriber) new nn0(singleObserver, (Collection) ExceptionHelper.nullCheck(this.f19066b.get(), "The collectionSupplier returned a null Collection.")));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, singleObserver);
        }
    }

    public FlowableToListSingle(Flowable<T> flowable, Supplier<U> supplier) {
        this.f19065a = flowable;
        this.f19066b = supplier;
    }
}
