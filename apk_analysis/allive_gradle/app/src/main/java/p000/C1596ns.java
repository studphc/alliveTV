package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: ns */
/* loaded from: classes2.dex */
public final class C1596ns extends AtomicInteger implements CompletableObserver, Disposable {
    private static final long serialVersionUID = 4109457741734051389L;

    /* renamed from: a */
    public final CompletableObserver f23470a;

    /* renamed from: b */
    public final Action f23471b;

    /* renamed from: c */
    public Disposable f23472c;

    public C1596ns(CompletableObserver completableObserver, Action action) {
        this.f23470a = completableObserver;
        this.f23471b = action;
    }

    /* renamed from: a */
    public final void m6396a() {
        if (compareAndSet(0, 1)) {
            try {
                this.f23471b.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f23472c.dispose();
        m6396a();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f23472c.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onComplete() {
        this.f23470a.onComplete();
        m6396a();
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onError(Throwable th) {
        this.f23470a.onError(th);
        m6396a();
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f23472c, disposable)) {
            this.f23472c = disposable;
            this.f23470a.onSubscribe(this);
        }
    }
}
