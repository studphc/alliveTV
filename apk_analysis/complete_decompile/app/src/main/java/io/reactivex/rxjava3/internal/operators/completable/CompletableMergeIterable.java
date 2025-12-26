package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C1994xs;

/* loaded from: classes2.dex */
public final class CompletableMergeIterable extends Completable {

    /* renamed from: a */
    public final Iterable f18687a;

    public CompletableMergeIterable(Iterable<? extends CompletableSource> iterable) {
        this.f18687a = iterable;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        AtomicInteger atomicInteger = new AtomicInteger(1);
        C1994xs c1994xs = new C1994xs(completableObserver, compositeDisposable, atomicInteger);
        completableObserver.onSubscribe(c1994xs);
        try {
            Iterator it = this.f18687a.iterator();
            Objects.requireNonNull(it, "The source iterator returned is null");
            while (!compositeDisposable.isDisposed()) {
                try {
                    if (!it.hasNext()) {
                        c1994xs.onComplete();
                        return;
                    }
                    if (compositeDisposable.isDisposed()) {
                        return;
                    }
                    try {
                        Object next = it.next();
                        Objects.requireNonNull(next, "The iterator returned a null CompletableSource");
                        CompletableSource completableSource = (CompletableSource) next;
                        if (compositeDisposable.isDisposed()) {
                            return;
                        }
                        atomicInteger.getAndIncrement();
                        completableSource.subscribe(c1994xs);
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        compositeDisposable.dispose();
                        c1994xs.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    compositeDisposable.dispose();
                    c1994xs.onError(th2);
                    return;
                }
            }
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            completableObserver.onError(th3);
        }
    }
}
