package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.BasicQueueDisposable;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class ri1 extends BasicQueueDisposable implements MaybeObserver {

    /* renamed from: a */
    public final Observer f25979a;

    /* renamed from: b */
    public final Function f25980b;

    /* renamed from: c */
    public Disposable f25981c;

    /* renamed from: d */
    public volatile Iterator f25982d;

    /* renamed from: e */
    public volatile boolean f25983e;

    /* renamed from: f */
    public boolean f25984f;

    public ri1(Observer observer, Function function) {
        this.f25979a = observer;
        this.f25980b = function;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final void clear() {
        this.f25982d = null;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f25983e = true;
        this.f25981c.dispose();
        this.f25981c = DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f25983e;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final boolean isEmpty() {
        if (this.f25982d == null) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        this.f25979a.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        this.f25981c = DisposableHelper.DISPOSED;
        this.f25979a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f25981c, disposable)) {
            this.f25981c = disposable;
            this.f25979a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        Observer observer = this.f25979a;
        try {
            Iterator it = ((Iterable) this.f25980b.apply(obj)).iterator();
            if (!it.hasNext()) {
                observer.onComplete();
                return;
            }
            this.f25982d = it;
            if (this.f25984f) {
                observer.onNext(null);
                observer.onComplete();
                return;
            }
            while (!this.f25983e) {
                try {
                    observer.onNext(it.next());
                    if (this.f25983e) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            observer.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        observer.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    observer.onError(th2);
                    return;
                }
            }
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            observer.onError(th3);
        }
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final Object poll() {
        Iterator it = this.f25982d;
        if (it == null) {
            return null;
        }
        Object next = it.next();
        Objects.requireNonNull(next, "The iterator returned a null value");
        if (!it.hasNext()) {
            this.f25982d = null;
        }
        return next;
    }

    @Override // io.reactivex.rxjava3.operators.QueueFuseable
    public final int requestFusion(int i) {
        if ((i & 2) != 0) {
            this.f25984f = true;
            return 2;
        }
        return 0;
    }
}
