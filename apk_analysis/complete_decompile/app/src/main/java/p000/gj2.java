package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class gj2 extends BasicIntQueueDisposable implements SingleObserver {
    private static final long serialVersionUID = -8938804753851907758L;

    /* renamed from: a */
    public final Observer f17722a;

    /* renamed from: b */
    public final Function f17723b;

    /* renamed from: c */
    public Disposable f17724c;

    /* renamed from: d */
    public volatile Iterator f17725d;

    /* renamed from: e */
    public volatile boolean f17726e;

    /* renamed from: f */
    public boolean f17727f;

    public gj2(Observer observer, Function function) {
        this.f17722a = observer;
        this.f17723b = function;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final void clear() {
        this.f17725d = null;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f17726e = true;
        this.f17724c.dispose();
        this.f17724c = DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f17726e;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final boolean isEmpty() {
        if (this.f17725d == null) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onError(Throwable th) {
        this.f17724c = DisposableHelper.DISPOSED;
        this.f17722a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f17724c, disposable)) {
            this.f17724c = disposable;
            this.f17722a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSuccess(Object obj) {
        Observer observer = this.f17722a;
        try {
            Iterator it = ((Iterable) this.f17723b.apply(obj)).iterator();
            if (!it.hasNext()) {
                observer.onComplete();
                return;
            }
            if (this.f17727f) {
                this.f17725d = it;
                observer.onNext(null);
                observer.onComplete();
                return;
            }
            while (!this.f17726e) {
                try {
                    observer.onNext(it.next());
                    if (this.f17726e) {
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
            this.f17722a.onError(th3);
        }
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final Object poll() {
        Iterator it = this.f17725d;
        if (it == null) {
            return null;
        }
        Object next = it.next();
        Objects.requireNonNull(next, "The iterator returned a null value");
        if (!it.hasNext()) {
            this.f17725d = null;
        }
        return next;
    }

    @Override // io.reactivex.rxjava3.operators.QueueFuseable
    public final int requestFusion(int i) {
        if ((i & 2) != 0) {
            this.f17727f = true;
            return 2;
        }
        return 0;
    }
}
