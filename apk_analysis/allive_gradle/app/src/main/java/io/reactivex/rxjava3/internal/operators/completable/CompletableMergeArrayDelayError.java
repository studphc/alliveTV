package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C1957ws;
import p000.C2030yr;

/* loaded from: classes2.dex */
public final class CompletableMergeArrayDelayError extends Completable {

    /* renamed from: a */
    public final CompletableSource[] f18685a;

    public CompletableMergeArrayDelayError(CompletableSource[] completableSourceArr) {
        this.f18685a = completableSourceArr;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        CompletableSource[] completableSourceArr = this.f18685a;
        AtomicInteger atomicInteger = new AtomicInteger(completableSourceArr.length + 1);
        AtomicThrowable atomicThrowable = new AtomicThrowable();
        compositeDisposable.add(new C1957ws(atomicThrowable));
        completableObserver.onSubscribe(compositeDisposable);
        for (CompletableSource completableSource : completableSourceArr) {
            if (compositeDisposable.isDisposed()) {
                return;
            }
            if (completableSource == null) {
                atomicThrowable.tryAddThrowableOrReport(new NullPointerException("A completable source is null"));
                atomicInteger.decrementAndGet();
            } else {
                completableSource.subscribe(new C2030yr(completableObserver, compositeDisposable, atomicThrowable, atomicInteger));
            }
        }
        if (atomicInteger.decrementAndGet() == 0) {
            atomicThrowable.tryTerminateConsumer(completableObserver);
        }
    }
}
