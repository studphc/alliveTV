package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.AbstractEmptyQueueFuseable;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamCompletableSource;

/* loaded from: classes2.dex */
public final class ObservableFromCompletable<T> extends Observable<T> implements HasUpstreamCompletableSource {

    /* renamed from: a */
    public final CompletableSource f19437a;

    /* loaded from: classes2.dex */
    public static final class FromCompletableObserver<T> extends AbstractEmptyQueueFuseable<T> implements CompletableObserver {

        /* renamed from: a */
        public final Observer f19438a;

        /* renamed from: b */
        public Disposable f19439b;

        public FromCompletableObserver(Observer<? super T> observer) {
            this.f19438a = observer;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.AbstractEmptyQueueFuseable, io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.f19439b.dispose();
            this.f19439b = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.AbstractEmptyQueueFuseable, io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.f19439b.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onComplete() {
            this.f19439b = DisposableHelper.DISPOSED;
            this.f19438a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onError(Throwable th) {
            this.f19439b = DisposableHelper.DISPOSED;
            this.f19438a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f19439b, disposable)) {
                this.f19439b = disposable;
                this.f19438a.onSubscribe(this);
            }
        }
    }

    public ObservableFromCompletable(CompletableSource completableSource) {
        this.f19437a = completableSource;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.HasUpstreamCompletableSource
    public CompletableSource source() {
        return this.f19437a;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.f19437a.subscribe(new FromCompletableObserver(observer));
    }
}
