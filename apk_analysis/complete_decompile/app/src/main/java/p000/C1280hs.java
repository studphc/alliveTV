package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: hs */
/* loaded from: classes2.dex */
public final class C1280hs extends AtomicInteger implements CompletableObserver {
    private static final long serialVersionUID = -7965400327305809232L;

    /* renamed from: a */
    public final CompletableObserver f18154a;

    /* renamed from: b */
    public final Iterator f18155b;

    /* renamed from: c */
    public final SequentialDisposable f18156c = new SequentialDisposable();

    public C1280hs(CompletableObserver completableObserver, Iterator it) {
        this.f18154a = completableObserver;
        this.f18155b = it;
    }

    /* renamed from: a */
    public final void m5126a() {
        CompletableObserver completableObserver = this.f18154a;
        SequentialDisposable sequentialDisposable = this.f18156c;
        if (sequentialDisposable.isDisposed() || getAndIncrement() != 0) {
            return;
        }
        Iterator it = this.f18155b;
        while (!sequentialDisposable.isDisposed()) {
            try {
                if (!it.hasNext()) {
                    completableObserver.onComplete();
                    return;
                }
                try {
                    Object next = it.next();
                    Objects.requireNonNull(next, "The CompletableSource returned is null");
                    ((CompletableSource) next).subscribe(this);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    completableObserver.onError(th);
                    return;
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                completableObserver.onError(th2);
                return;
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onComplete() {
        m5126a();
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onError(Throwable th) {
        this.f18154a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onSubscribe(Disposable disposable) {
        this.f18156c.replace(disposable);
    }
}
