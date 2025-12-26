package p000;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class ex1 implements Observer {

    /* renamed from: a */
    public final Observer f17017a;

    /* renamed from: b */
    public final Function f17018b;

    /* renamed from: c */
    public final SequentialDisposable f17019c = new SequentialDisposable();

    /* renamed from: d */
    public boolean f17020d;

    /* renamed from: e */
    public boolean f17021e;

    public ex1(Observer observer, Function function) {
        this.f17017a = observer;
        this.f17018b = function;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        if (this.f17021e) {
            return;
        }
        this.f17021e = true;
        this.f17020d = true;
        this.f17017a.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        boolean z = this.f17020d;
        Observer observer = this.f17017a;
        if (z) {
            if (this.f17021e) {
                RxJavaPlugins.onError(th);
                return;
            } else {
                observer.onError(th);
                return;
            }
        }
        this.f17020d = true;
        try {
            ObservableSource observableSource = (ObservableSource) this.f17018b.apply(th);
            if (observableSource == null) {
                NullPointerException nullPointerException = new NullPointerException("Observable is null");
                nullPointerException.initCause(th);
                observer.onError(nullPointerException);
                return;
            }
            observableSource.subscribe(this);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            observer.onError(new CompositeException(th, th2));
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        if (this.f17021e) {
            return;
        }
        this.f17017a.onNext(obj);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        this.f17019c.replace(disposable);
    }
}
