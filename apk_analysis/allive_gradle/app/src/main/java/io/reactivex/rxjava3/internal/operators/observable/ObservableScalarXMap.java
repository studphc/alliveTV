package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.operators.QueueDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import p000.AbstractC0002a1;

/* loaded from: classes2.dex */
public final class ObservableScalarXMap {

    /* loaded from: classes2.dex */
    public static final class ScalarDisposable<T> extends AtomicInteger implements QueueDisposable<T>, Runnable {
        private static final long serialVersionUID = 3880992722410194083L;

        /* renamed from: a */
        public final Observer f19543a;

        /* renamed from: b */
        public final Object f19544b;

        public ScalarDisposable(Observer<? super T> observer, T t) {
            this.f19543a = observer;
            this.f19544b = t;
        }

        @Override // io.reactivex.rxjava3.operators.SimpleQueue
        public void clear() {
            lazySet(3);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            set(3);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            if (get() == 3) {
                return true;
            }
            return false;
        }

        @Override // io.reactivex.rxjava3.operators.SimpleQueue
        public boolean isEmpty() {
            if (get() != 1) {
                return true;
            }
            return false;
        }

        @Override // io.reactivex.rxjava3.operators.SimpleQueue, java.util.Queue
        public boolean offer(T t) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // io.reactivex.rxjava3.operators.SimpleQueue
        @Nullable
        public T poll() {
            if (get() == 1) {
                lazySet(3);
                return (T) this.f19544b;
            }
            return null;
        }

        @Override // io.reactivex.rxjava3.operators.QueueFuseable
        public int requestFusion(int i) {
            if ((i & 1) != 0) {
                lazySet(1);
                return 1;
            }
            return 0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                Object obj = this.f19544b;
                Observer observer = this.f19543a;
                observer.onNext(obj);
                if (get() == 2) {
                    lazySet(3);
                    observer.onComplete();
                }
            }
        }

        @Override // io.reactivex.rxjava3.operators.SimpleQueue
        public boolean offer(T t, T t2) {
            throw new UnsupportedOperationException("Should not be called!");
        }
    }

    public static <T, U> Observable<U> scalarXMap(T t, Function<? super T, ? extends ObservableSource<? extends U>> function) {
        return RxJavaPlugins.onAssembly(new C1321c(t, function));
    }

    public static <T, R> boolean tryScalarXMapSubscribe(ObservableSource<T> observableSource, Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function) {
        if (observableSource instanceof Supplier) {
            try {
                AbstractC0002a1 abstractC0002a1 = (Object) ((Supplier) observableSource).get();
                if (abstractC0002a1 == null) {
                    EmptyDisposable.complete(observer);
                    return true;
                }
                try {
                    ObservableSource<? extends R> apply = function.apply(abstractC0002a1);
                    Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
                    ObservableSource<? extends R> observableSource2 = apply;
                    if (observableSource2 instanceof Supplier) {
                        try {
                            Object obj = ((Supplier) observableSource2).get();
                            if (obj == null) {
                                EmptyDisposable.complete(observer);
                                return true;
                            }
                            ScalarDisposable scalarDisposable = new ScalarDisposable(observer, obj);
                            observer.onSubscribe(scalarDisposable);
                            scalarDisposable.run();
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            EmptyDisposable.error(th, observer);
                            return true;
                        }
                    } else {
                        observableSource2.subscribe(observer);
                    }
                    return true;
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    EmptyDisposable.error(th2, observer);
                    return true;
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                EmptyDisposable.error(th3, observer);
                return true;
            }
        }
        return false;
    }
}
