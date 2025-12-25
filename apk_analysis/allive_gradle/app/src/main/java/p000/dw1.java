package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/* loaded from: classes2.dex */
public final class dw1 extends AtomicInteger implements Observer, Disposable {
    private static final long serialVersionUID = -5127032662980523968L;

    /* renamed from: a */
    public final Observer f16564a;

    /* renamed from: b */
    public final Function f16565b;

    /* renamed from: c */
    public Disposable f16566c;

    /* renamed from: d */
    public volatile boolean f16567d;

    /* renamed from: e */
    public boolean f16568e;

    public dw1(Observer observer, Function function) {
        this.f16564a = observer;
        this.f16565b = function;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f16567d = true;
        this.f16566c.dispose();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f16567d;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        if (!this.f16568e) {
            this.f16568e = true;
            this.f16564a.onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        if (this.f16568e) {
            RxJavaPlugins.onError(th);
        } else {
            this.f16568e = true;
            this.f16564a.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        Iterator it;
        if (this.f16568e) {
            return;
        }
        try {
            Object apply = this.f16565b.apply(obj);
            Objects.requireNonNull(apply, "The mapper returned a null Stream");
            Stream m5549q = ki0.m5549q(apply);
            try {
                it = m5549q.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (this.f16567d) {
                        this.f16568e = true;
                        break;
                    }
                    Object next = it.next();
                    Objects.requireNonNull(next, "The Stream's Iterator.next returned a null value");
                    if (this.f16567d) {
                        this.f16568e = true;
                        break;
                    }
                    this.f16564a.onNext(next);
                    if (this.f16567d) {
                        this.f16568e = true;
                        break;
                    }
                }
                m5549q.close();
            } finally {
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.f16566c.dispose();
            onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f16566c, disposable)) {
            this.f16566c = disposable;
            this.f16564a.onSubscribe(this);
        }
    }
}
