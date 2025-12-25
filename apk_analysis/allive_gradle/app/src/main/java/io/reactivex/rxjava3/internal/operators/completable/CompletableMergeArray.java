package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import java.util.concurrent.atomic.AtomicBoolean;
import p000.C1920vs;

/* loaded from: classes2.dex */
public final class CompletableMergeArray extends Completable {

    /* renamed from: a */
    public final CompletableSource[] f18684a;

    public CompletableMergeArray(CompletableSource[] completableSourceArr) {
        this.f18684a = completableSourceArr;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        CompletableSource[] completableSourceArr = this.f18684a;
        C1920vs c1920vs = new C1920vs(completableObserver, atomicBoolean, compositeDisposable, completableSourceArr.length + 1);
        completableObserver.onSubscribe(c1920vs);
        for (CompletableSource completableSource : completableSourceArr) {
            if (compositeDisposable.isDisposed()) {
                return;
            }
            if (completableSource == null) {
                compositeDisposable.dispose();
                c1920vs.onError(new NullPointerException("A completable source is null"));
                return;
            }
            completableSource.subscribe(c1920vs);
        }
        c1920vs.onComplete();
    }
}
