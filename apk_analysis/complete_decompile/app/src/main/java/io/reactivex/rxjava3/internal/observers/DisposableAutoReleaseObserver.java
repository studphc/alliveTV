package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.DisposableContainer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import p000.AbstractC0001a0;

/* loaded from: classes2.dex */
public final class DisposableAutoReleaseObserver<T> extends AbstractC0001a0 implements Observer<T> {
    private static final long serialVersionUID = 8924480688481408726L;

    /* renamed from: d */
    public final Consumer f18606d;

    public DisposableAutoReleaseObserver(DisposableContainer disposableContainer, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        super(action, consumer2, disposableContainer);
        this.f18606d = consumer;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onNext(T t) {
        if (get() != DisposableHelper.DISPOSED) {
            try {
                this.f18606d.accept(t);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                ((Disposable) get()).dispose();
                onError(th);
            }
        }
    }
}
