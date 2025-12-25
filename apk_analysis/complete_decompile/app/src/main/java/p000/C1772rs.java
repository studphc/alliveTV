package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

/* renamed from: rs */
/* loaded from: classes2.dex */
public final class C1772rs implements SingleObserver {

    /* renamed from: a */
    public final /* synthetic */ int f26120a;

    /* renamed from: b */
    public final Object f26121b;

    public /* synthetic */ C1772rs(int i, Object obj) {
        this.f26120a = i;
        this.f26121b = obj;
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onError(Throwable th) {
        switch (this.f26120a) {
            case 0:
                ((CompletableObserver) this.f26121b).onError(th);
                return;
            default:
                ((ij2) this.f26121b).f18437a.onError(th);
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        switch (this.f26120a) {
            case 0:
                ((CompletableObserver) this.f26121b).onSubscribe(disposable);
                return;
            default:
                DisposableHelper.setOnce((ij2) this.f26121b, disposable);
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSuccess(Object obj) {
        switch (this.f26120a) {
            case 0:
                ((CompletableObserver) this.f26121b).onComplete();
                return;
            default:
                ((ij2) this.f26121b).f18437a.onSuccess(obj);
                return;
        }
    }
}
