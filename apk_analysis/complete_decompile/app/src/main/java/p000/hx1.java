package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.subjects.PublishSubject;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class hx1 implements Observer {

    /* renamed from: a */
    public final /* synthetic */ int f18208a;

    /* renamed from: b */
    public final Observer f18209b;

    /* renamed from: c */
    public final AtomicReference f18210c;

    public /* synthetic */ hx1(Observer observer, AtomicReference atomicReference, int i) {
        this.f18208a = i;
        this.f18209b = observer;
        this.f18210c = atomicReference;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        switch (this.f18208a) {
            case 0:
                ((PublishSubject) this.f18209b).onComplete();
                return;
            default:
                this.f18209b.onComplete();
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        switch (this.f18208a) {
            case 0:
                ((PublishSubject) this.f18209b).onError(th);
                return;
            default:
                this.f18209b.onError(th);
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        switch (this.f18208a) {
            case 0:
                ((PublishSubject) this.f18209b).onNext(obj);
                return;
            default:
                this.f18209b.onNext(obj);
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        switch (this.f18208a) {
            case 0:
                DisposableHelper.setOnce((ix1) this.f18210c, disposable);
                return;
            default:
                DisposableHelper.replace(this.f18210c, disposable);
                return;
        }
    }
}
