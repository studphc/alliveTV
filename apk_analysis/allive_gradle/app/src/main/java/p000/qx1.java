package p000;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import io.reactivex.rxjava3.subjects.Subject;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class qx1 extends AtomicInteger implements Observer, Disposable {
    private static final long serialVersionUID = 802743776666017014L;

    /* renamed from: a */
    public final Observer f25788a;

    /* renamed from: d */
    public final Subject f25791d;

    /* renamed from: g */
    public final ObservableSource f25794g;

    /* renamed from: h */
    public volatile boolean f25795h;

    /* renamed from: b */
    public final AtomicInteger f25789b = new AtomicInteger();

    /* renamed from: c */
    public final AtomicThrowable f25790c = new AtomicThrowable();

    /* renamed from: e */
    public final px1 f25792e = new px1(this);

    /* renamed from: f */
    public final AtomicReference f25793f = new AtomicReference();

    public qx1(Observer observer, Subject subject, ObservableSource observableSource) {
        this.f25788a = observer;
        this.f25791d = subject;
        this.f25794g = observableSource;
    }

    /* renamed from: a */
    public final void m7150a() {
        if (this.f25789b.getAndIncrement() != 0) {
            return;
        }
        while (!isDisposed()) {
            if (!this.f25795h) {
                this.f25795h = true;
                this.f25794g.subscribe(this);
            }
            if (this.f25789b.decrementAndGet() == 0) {
                return;
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this.f25793f);
        DisposableHelper.dispose(this.f25792e);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) this.f25793f.get());
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        DisposableHelper.replace(this.f25793f, null);
        this.f25795h = false;
        this.f25791d.onNext(0);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        DisposableHelper.dispose(this.f25792e);
        HalfSerializer.onError((Observer<?>) this.f25788a, th, this, this.f25790c);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        HalfSerializer.onNext((Observer<? super Object>) this.f25788a, obj, this, this.f25790c);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.f25793f, disposable);
    }
}
