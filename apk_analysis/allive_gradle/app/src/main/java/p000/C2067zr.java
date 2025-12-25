package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.operators.completable.CompletableDoOnEvent;
import io.reactivex.rxjava3.internal.operators.completable.CompletableOnErrorComplete;
import io.reactivex.rxjava3.internal.operators.completable.CompletableToSingle;

/* renamed from: zr */
/* loaded from: classes2.dex */
public final class C2067zr implements CompletableObserver {

    /* renamed from: a */
    public final /* synthetic */ int f29488a;

    /* renamed from: b */
    public final Object f29489b;

    /* renamed from: c */
    public final Object f29490c;

    public /* synthetic */ C2067zr(Object obj, CompletableObserver completableObserver, int i) {
        this.f29488a = i;
        this.f29490c = obj;
        this.f29489b = completableObserver;
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onComplete() {
        Object obj;
        switch (this.f29488a) {
            case 0:
                ((CompletableObserver) this.f29489b).onComplete();
                return;
            case 1:
                CompletableObserver completableObserver = (CompletableObserver) this.f29489b;
                try {
                    ((CompletableDoOnEvent) this.f29490c).f18666b.accept(null);
                    completableObserver.onComplete();
                    return;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    completableObserver.onError(th);
                    return;
                }
            case 2:
                ((CompletableObserver) this.f29489b).onComplete();
                return;
            default:
                CompletableToSingle completableToSingle = (CompletableToSingle) this.f29489b;
                Supplier supplier = completableToSingle.f18718b;
                SingleObserver singleObserver = (SingleObserver) this.f29490c;
                if (supplier != null) {
                    try {
                        obj = supplier.get();
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        singleObserver.onError(th2);
                        return;
                    }
                } else {
                    obj = completableToSingle.f18719c;
                }
                if (obj == null) {
                    singleObserver.onError(new NullPointerException("The value supplied is null"));
                    return;
                } else {
                    singleObserver.onSuccess(obj);
                    return;
                }
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onError(Throwable th) {
        Object obj = this.f29489b;
        Object obj2 = this.f29490c;
        switch (this.f29488a) {
            case 0:
                ((CompletableObserver) obj).onError(th);
                return;
            case 1:
                try {
                    ((CompletableDoOnEvent) obj2).f18666b.accept(th);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    th = new CompositeException(th, th2);
                }
                ((CompletableObserver) obj).onError(th);
                return;
            case 2:
                CompletableObserver completableObserver = (CompletableObserver) obj;
                try {
                    if (((CompletableOnErrorComplete) obj2).f18691b.test(th)) {
                        completableObserver.onComplete();
                        return;
                    } else {
                        completableObserver.onError(th);
                        return;
                    }
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    completableObserver.onError(new CompositeException(th, th3));
                    return;
                }
            default:
                ((SingleObserver) obj2).onError(th);
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onSubscribe(Disposable disposable) {
        switch (this.f29488a) {
            case 0:
                DisposableHelper.replace((C0531as) this.f29490c, disposable);
                return;
            case 1:
                ((CompletableObserver) this.f29489b).onSubscribe(disposable);
                return;
            case 2:
                ((CompletableObserver) this.f29489b).onSubscribe(disposable);
                return;
            default:
                ((SingleObserver) this.f29490c).onSubscribe(disposable);
                return;
        }
    }

    public C2067zr(CompletableToSingle completableToSingle, SingleObserver singleObserver) {
        this.f29488a = 3;
        this.f29489b = completableToSingle;
        this.f29490c = singleObserver;
    }
}
