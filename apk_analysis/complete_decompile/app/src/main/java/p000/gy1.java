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
public final class gy1 extends AtomicInteger implements Observer, Disposable {
    private static final long serialVersionUID = 802743776666017014L;

    /* renamed from: a */
    public final Observer f17877a;

    /* renamed from: d */
    public final Subject f17880d;

    /* renamed from: g */
    public final ObservableSource f17883g;

    /* renamed from: h */
    public volatile boolean f17884h;

    /* renamed from: b */
    public final AtomicInteger f17878b = new AtomicInteger();

    /* renamed from: c */
    public final AtomicThrowable f17879c = new AtomicThrowable();

    /* renamed from: e */
    public final fy1 f17881e = new fy1(this);

    /* renamed from: f */
    public final AtomicReference f17882f = new AtomicReference();

    public gy1(Observer observer, Subject subject, ObservableSource observableSource) {
        this.f17877a = observer;
        this.f17880d = subject;
        this.f17883g = observableSource;
    }

    /* renamed from: a */
    public final void m5026a() {
        if (this.f17878b.getAndIncrement() != 0) {
            return;
        }
        while (!isDisposed()) {
            if (!this.f17884h) {
                this.f17884h = true;
                this.f17883g.subscribe(this);
            }
            if (this.f17878b.decrementAndGet() == 0) {
                return;
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this.f17882f);
        DisposableHelper.dispose(this.f17881e);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) this.f17882f.get());
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        DisposableHelper.dispose(this.f17881e);
        HalfSerializer.onComplete((Observer<?>) this.f17877a, this, this.f17879c);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        DisposableHelper.replace(this.f17882f, null);
        this.f17884h = false;
        this.f17880d.onNext(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        HalfSerializer.onNext((Observer<? super Object>) this.f17877a, obj, this, this.f17879c);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.replace(this.f17882f, disposable);
    }
}
