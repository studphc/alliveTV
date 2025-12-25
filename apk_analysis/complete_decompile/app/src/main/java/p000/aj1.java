package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Stream;

/* loaded from: classes2.dex */
public final class aj1 extends BasicIntQueueDisposable implements MaybeObserver, SingleObserver {
    private static final long serialVersionUID = 7363336003027148283L;

    /* renamed from: a */
    public final Observer f222a;

    /* renamed from: b */
    public final Function f223b;

    /* renamed from: c */
    public Disposable f224c;

    /* renamed from: d */
    public volatile Iterator f225d;

    /* renamed from: e */
    public AutoCloseable f226e;

    /* renamed from: f */
    public boolean f227f;

    /* renamed from: g */
    public volatile boolean f228g;

    /* renamed from: h */
    public boolean f229h;

    public aj1(Observer observer, Function function) {
        this.f222a = observer;
        this.f223b = function;
    }

    /* renamed from: a */
    public final void m104a() {
        if (getAndIncrement() != 0) {
            return;
        }
        Observer observer = this.f222a;
        Iterator it = this.f225d;
        int i = 1;
        while (true) {
            if (this.f228g) {
                clear();
            } else if (this.f229h) {
                observer.onNext(null);
                observer.onComplete();
            } else {
                try {
                    Object next = it.next();
                    if (!this.f228g) {
                        observer.onNext(next);
                        if (!this.f228g) {
                            try {
                                boolean hasNext = it.hasNext();
                                if (!this.f228g && !hasNext) {
                                    observer.onComplete();
                                    this.f228g = true;
                                }
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                observer.onError(th);
                                this.f228g = true;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    observer.onError(th2);
                    this.f228g = true;
                }
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
        }
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final void clear() {
        this.f225d = null;
        AutoCloseable autoCloseable = this.f226e;
        this.f226e = null;
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f228g = true;
        this.f224c.dispose();
        if (!this.f229h) {
            m104a();
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f228g;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final boolean isEmpty() {
        Iterator it = this.f225d;
        if (it != null) {
            if (!this.f227f || it.hasNext()) {
                return false;
            }
            clear();
            return true;
        }
        return true;
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        this.f222a.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        this.f222a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f224c, disposable)) {
            this.f224c = disposable;
            this.f222a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        Iterator it;
        try {
            Object apply = this.f223b.apply(obj);
            Objects.requireNonNull(apply, "The mapper returned a null Stream");
            Stream m5549q = ki0.m5549q(apply);
            it = m5549q.iterator();
            if (!it.hasNext()) {
                this.f222a.onComplete();
                try {
                    m5549q.close();
                    return;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                    return;
                }
            }
            this.f225d = it;
            this.f226e = m5549q;
            m104a();
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            this.f222a.onError(th2);
        }
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final Object poll() {
        Iterator it = this.f225d;
        if (it == null) {
            return null;
        }
        if (this.f227f) {
            if (!it.hasNext()) {
                clear();
                return null;
            }
        } else {
            this.f227f = true;
        }
        return it.next();
    }

    @Override // io.reactivex.rxjava3.operators.QueueFuseable
    public final int requestFusion(int i) {
        if ((i & 2) != 0) {
            this.f229h = true;
            return 2;
        }
        return 0;
    }
}
