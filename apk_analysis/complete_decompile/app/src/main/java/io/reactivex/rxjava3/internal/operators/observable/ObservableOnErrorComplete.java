package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import p000.AbstractC1607o2;

/* loaded from: classes2.dex */
public final class ObservableOnErrorComplete<T> extends AbstractC1607o2 {

    /* renamed from: a */
    public final Predicate f19498a;

    /* loaded from: classes2.dex */
    public static final class OnErrorCompleteObserver<T> implements Observer<T>, Disposable {

        /* renamed from: a */
        public final Observer f19499a;

        /* renamed from: b */
        public final Predicate f19500b;

        /* renamed from: c */
        public Disposable f19501c;

        public OnErrorCompleteObserver(Observer<? super T> observer, Predicate<? super Throwable> predicate) {
            this.f19499a = observer;
            this.f19500b = predicate;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.f19501c.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.f19501c.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.f19499a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            Observer observer = this.f19499a;
            try {
                if (this.f19500b.test(th)) {
                    observer.onComplete();
                } else {
                    observer.onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                observer.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            this.f19499a.onNext(t);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f19501c, disposable)) {
                this.f19501c = disposable;
                this.f19499a.onSubscribe(this);
            }
        }
    }

    public ObservableOnErrorComplete(ObservableSource<T> observableSource, Predicate<? super Throwable> predicate) {
        super(observableSource);
        this.f19498a = predicate;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new OnErrorCompleteObserver(observer, this.f19498a));
    }
}
