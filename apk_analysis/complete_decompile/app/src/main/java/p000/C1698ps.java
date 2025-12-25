package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

/* renamed from: ps */
/* loaded from: classes2.dex */
public final class C1698ps implements Observer {

    /* renamed from: a */
    public final /* synthetic */ int f25274a;

    /* renamed from: b */
    public final Object f25275b;

    public /* synthetic */ C1698ps(int i, Object obj) {
        this.f25274a = i;
        this.f25275b = obj;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        switch (this.f25274a) {
            case 0:
                ((CompletableObserver) this.f25275b).onComplete();
                return;
            case 1:
                ((iv1) this.f25275b).f20276b.onComplete();
                return;
            case 2:
                my1 my1Var = (my1) this.f25275b;
                my1Var.f23163d.dispose();
                my1Var.mo5800a();
                return;
            default:
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        switch (this.f25274a) {
            case 0:
                ((CompletableObserver) this.f25275b).onError(th);
                return;
            case 1:
                ((iv1) this.f25275b).f20276b.onError(th);
                return;
            case 2:
                my1 my1Var = (my1) this.f25275b;
                my1Var.f23163d.dispose();
                my1Var.f23160a.onError(th);
                return;
            default:
                l02 l02Var = (l02) this.f25275b;
                DisposableHelper.dispose(l02Var.f22273c);
                l02Var.f22271a.onError(th);
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        switch (this.f25274a) {
            case 0:
                return;
            case 1:
                ((iv1) this.f25275b).f20276b.onNext(obj);
                return;
            case 2:
                ((my1) this.f25275b).mo5801b();
                return;
            default:
                ((l02) this.f25275b).lazySet(obj);
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        switch (this.f25274a) {
            case 0:
                ((CompletableObserver) this.f25275b).onSubscribe(disposable);
                return;
            case 1:
                ((iv1) this.f25275b).f20277c.update(disposable);
                return;
            case 2:
                DisposableHelper.setOnce(((my1) this.f25275b).f23162c, disposable);
                return;
            default:
                DisposableHelper.setOnce(((l02) this.f25275b).f22274d, disposable);
                return;
        }
    }

    /* renamed from: a */
    private final void m6921a() {
    }

    /* renamed from: b */
    private final void m6922b(Object obj) {
    }
}
