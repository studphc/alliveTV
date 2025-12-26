package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class si1 implements MaybeObserver {

    /* renamed from: a */
    public final /* synthetic */ int f26440a;

    /* renamed from: b */
    public final /* synthetic */ AtomicReference f26441b;

    public /* synthetic */ si1(AtomicReference atomicReference, int i) {
        this.f26440a = i;
        this.f26441b = atomicReference;
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        switch (this.f26440a) {
            case 0:
                ((ti1) this.f26441b).f26825a.onComplete();
                return;
            default:
                ((yi1) this.f26441b).f28966a.onComplete();
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        switch (this.f26440a) {
            case 0:
                ((ti1) this.f26441b).f26825a.onError(th);
                return;
            default:
                ((yi1) this.f26441b).f28966a.onError(th);
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        switch (this.f26440a) {
            case 0:
                DisposableHelper.setOnce((ti1) this.f26441b, disposable);
                return;
            default:
                DisposableHelper.setOnce((yi1) this.f26441b, disposable);
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        switch (this.f26440a) {
            case 0:
                ((ti1) this.f26441b).f26825a.onSuccess(obj);
                return;
            default:
                ((yi1) this.f26441b).f28966a.onSuccess(obj);
                return;
        }
    }
}
