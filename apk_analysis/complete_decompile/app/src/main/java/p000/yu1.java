package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

/* loaded from: classes2.dex */
public final class yu1 implements Observer, Disposable {

    /* renamed from: a */
    public final /* synthetic */ int f29135a;

    /* renamed from: b */
    public final Object f29136b;

    /* renamed from: c */
    public long f29137c;

    /* renamed from: d */
    public Disposable f29138d;

    public /* synthetic */ yu1(int i, Object obj) {
        this.f29135a = i;
        this.f29136b = obj;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        switch (this.f29135a) {
            case 0:
                this.f29138d.dispose();
                return;
            case 1:
                this.f29138d.dispose();
                return;
            default:
                this.f29138d.dispose();
                this.f29138d = DisposableHelper.DISPOSED;
                return;
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        switch (this.f29135a) {
            case 0:
                return this.f29138d.isDisposed();
            case 1:
                return this.f29138d.isDisposed();
            default:
                return this.f29138d.isDisposed();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        switch (this.f29135a) {
            case 0:
                Long valueOf = Long.valueOf(this.f29137c);
                Observer observer = (Observer) this.f29136b;
                observer.onNext(valueOf);
                observer.onComplete();
                return;
            case 1:
                ((Observer) this.f29136b).onComplete();
                return;
            default:
                this.f29138d = DisposableHelper.DISPOSED;
                ((SingleObserver) this.f29136b).onSuccess(Long.valueOf(this.f29137c));
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        switch (this.f29135a) {
            case 0:
                ((Observer) this.f29136b).onError(th);
                return;
            case 1:
                ((Observer) this.f29136b).onError(th);
                return;
            default:
                this.f29138d = DisposableHelper.DISPOSED;
                ((SingleObserver) this.f29136b).onError(th);
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        switch (this.f29135a) {
            case 0:
                this.f29137c++;
                return;
            case 1:
                long j = this.f29137c;
                if (j != 0) {
                    this.f29137c = j - 1;
                    return;
                } else {
                    ((Observer) this.f29136b).onNext(obj);
                    return;
                }
            default:
                this.f29137c++;
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        switch (this.f29135a) {
            case 0:
                if (DisposableHelper.validate(this.f29138d, disposable)) {
                    this.f29138d = disposable;
                    ((Observer) this.f29136b).onSubscribe(this);
                    return;
                }
                return;
            case 1:
                if (DisposableHelper.validate(this.f29138d, disposable)) {
                    this.f29138d = disposable;
                    ((Observer) this.f29136b).onSubscribe(this);
                    return;
                }
                return;
            default:
                if (DisposableHelper.validate(this.f29138d, disposable)) {
                    this.f29138d = disposable;
                    ((SingleObserver) this.f29136b).onSubscribe(this);
                    return;
                }
                return;
        }
    }

    public yu1(Observer observer, long j) {
        this.f29135a = 1;
        this.f29136b = observer;
        this.f29137c = j;
    }
}
