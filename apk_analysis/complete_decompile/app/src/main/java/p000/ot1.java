package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Collection;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class ot1 implements Observer, Disposable {

    /* renamed from: a */
    public final Observer f24899a;

    /* renamed from: b */
    public final int f24900b;

    /* renamed from: c */
    public final Supplier f24901c;

    /* renamed from: d */
    public Collection f24902d;

    /* renamed from: e */
    public int f24903e;

    /* renamed from: f */
    public Disposable f24904f;

    public ot1(Observer observer, int i, Supplier supplier) {
        this.f24899a = observer;
        this.f24900b = i;
        this.f24901c = supplier;
    }

    /* renamed from: a */
    public final boolean m6728a() {
        try {
            Object obj = this.f24901c.get();
            Objects.requireNonNull(obj, "Empty buffer supplied");
            this.f24902d = (Collection) obj;
            return true;
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.f24902d = null;
            Disposable disposable = this.f24904f;
            Observer observer = this.f24899a;
            if (disposable == null) {
                EmptyDisposable.error(th, (Observer<?>) observer);
                return false;
            }
            disposable.dispose();
            observer.onError(th);
            return false;
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f24904f.dispose();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f24904f.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        Collection collection = this.f24902d;
        if (collection != null) {
            this.f24902d = null;
            boolean isEmpty = collection.isEmpty();
            Observer observer = this.f24899a;
            if (!isEmpty) {
                observer.onNext(collection);
            }
            observer.onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        this.f24902d = null;
        this.f24899a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        Collection collection = this.f24902d;
        if (collection != null) {
            collection.add(obj);
            int i = this.f24903e + 1;
            this.f24903e = i;
            if (i >= this.f24900b) {
                this.f24899a.onNext(collection);
                this.f24903e = 0;
                m6728a();
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f24904f, disposable)) {
            this.f24904f = disposable;
            this.f24899a.onSubscribe(this);
        }
    }
}
