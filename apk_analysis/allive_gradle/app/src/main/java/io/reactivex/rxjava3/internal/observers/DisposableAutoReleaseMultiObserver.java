package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.DisposableContainer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import p000.AbstractC0001a0;

/* loaded from: classes2.dex */
public final class DisposableAutoReleaseMultiObserver<T> extends AbstractC0001a0 implements SingleObserver<T>, MaybeObserver<T>, CompletableObserver {
    private static final long serialVersionUID = 8924480688481408726L;

    /* renamed from: d */
    public final Consumer f18605d;

    public DisposableAutoReleaseMultiObserver(DisposableContainer disposableContainer, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        super(action, consumer2, disposableContainer);
        this.f18605d = consumer;
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public void onSuccess(T t) {
        Object obj = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (obj != disposableHelper) {
            lazySet(disposableHelper);
            try {
                this.f18605d.accept(t);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }
        m0a();
    }
}
