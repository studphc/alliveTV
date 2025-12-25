package p000;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class mi2 implements SingleObserver {

    /* renamed from: a */
    public final CompositeDisposable f22949a;

    /* renamed from: b */
    public final SingleObserver f22950b;

    /* renamed from: c */
    public final AtomicBoolean f22951c;

    /* renamed from: d */
    public Disposable f22952d;

    public mi2(SingleObserver singleObserver, CompositeDisposable compositeDisposable, AtomicBoolean atomicBoolean) {
        this.f22950b = singleObserver;
        this.f22949a = compositeDisposable;
        this.f22951c = atomicBoolean;
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onError(Throwable th) {
        if (this.f22951c.compareAndSet(false, true)) {
            Disposable disposable = this.f22952d;
            CompositeDisposable compositeDisposable = this.f22949a;
            compositeDisposable.delete(disposable);
            compositeDisposable.dispose();
            this.f22950b.onError(th);
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        this.f22952d = disposable;
        this.f22949a.add(disposable);
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSuccess(Object obj) {
        if (this.f22951c.compareAndSet(false, true)) {
            Disposable disposable = this.f22952d;
            CompositeDisposable compositeDisposable = this.f22949a;
            compositeDisposable.delete(disposable);
            compositeDisposable.dispose();
            this.f22950b.onSuccess(obj);
        }
    }
}
