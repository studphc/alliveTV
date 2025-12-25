package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: gs */
/* loaded from: classes2.dex */
public final class C1243gs extends AtomicInteger implements CompletableObserver {
    private static final long serialVersionUID = -7965400327305809232L;

    /* renamed from: a */
    public final CompletableObserver f17814a;

    /* renamed from: b */
    public final CompletableSource[] f17815b;

    /* renamed from: c */
    public int f17816c;

    /* renamed from: d */
    public final SequentialDisposable f17817d = new SequentialDisposable();

    public C1243gs(CompletableObserver completableObserver, CompletableSource[] completableSourceArr) {
        this.f17814a = completableObserver;
        this.f17815b = completableSourceArr;
    }

    /* renamed from: a */
    public final void m4984a() {
        SequentialDisposable sequentialDisposable = this.f17817d;
        if (sequentialDisposable.isDisposed() || getAndIncrement() != 0) {
            return;
        }
        while (!sequentialDisposable.isDisposed()) {
            int i = this.f17816c;
            this.f17816c = i + 1;
            CompletableSource[] completableSourceArr = this.f17815b;
            if (i == completableSourceArr.length) {
                this.f17814a.onComplete();
                return;
            } else {
                completableSourceArr[i].subscribe(this);
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onComplete() {
        m4984a();
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onError(Throwable th) {
        this.f17814a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onSubscribe(Disposable disposable) {
        this.f17817d.replace(disposable);
    }
}
