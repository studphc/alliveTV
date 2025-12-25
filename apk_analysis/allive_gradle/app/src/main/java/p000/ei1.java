package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeDoOnTerminate;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ei1 implements MaybeObserver {

    /* renamed from: a */
    public final /* synthetic */ int f16835a;

    /* renamed from: b */
    public final MaybeObserver f16836b;

    /* renamed from: c */
    public final Object f16837c;

    public /* synthetic */ ei1(int i, MaybeObserver maybeObserver, Object obj) {
        this.f16835a = i;
        this.f16837c = obj;
        this.f16836b = maybeObserver;
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        switch (this.f16835a) {
            case 0:
                this.f16836b.onComplete();
                return;
            case 1:
                MaybeObserver maybeObserver = this.f16836b;
                try {
                    ((MaybeDoOnTerminate) this.f16837c).f19147b.run();
                    maybeObserver.onComplete();
                    return;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    maybeObserver.onError(th);
                    return;
                }
            case 2:
                this.f16836b.onComplete();
                return;
            case 3:
                this.f16836b.onComplete();
                return;
            default:
                this.f16836b.onComplete();
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        MaybeObserver maybeObserver = this.f16836b;
        switch (this.f16835a) {
            case 0:
                maybeObserver.onError(th);
                return;
            case 1:
                try {
                    ((MaybeDoOnTerminate) this.f16837c).f19147b.run();
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    th = new CompositeException(th, th2);
                }
                maybeObserver.onError(th);
                return;
            case 2:
                maybeObserver.onError(th);
                return;
            case 3:
                maybeObserver.onError(th);
                return;
            default:
                maybeObserver.onError(th);
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        switch (this.f16835a) {
            case 0:
                DisposableHelper.replace((fi1) this.f16837c, disposable);
                return;
            case 1:
                this.f16836b.onSubscribe(disposable);
                return;
            case 2:
                DisposableHelper.setOnce((hj1) this.f16837c, disposable);
                return;
            case 3:
                DisposableHelper.setOnce((kj1) this.f16837c, disposable);
                return;
            default:
                DisposableHelper.replace((hj2) this.f16837c, disposable);
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        switch (this.f16835a) {
            case 0:
                this.f16836b.onSuccess(obj);
                return;
            case 1:
                MaybeObserver maybeObserver = this.f16836b;
                try {
                    ((MaybeDoOnTerminate) this.f16837c).f19147b.run();
                    maybeObserver.onSuccess(obj);
                    return;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    maybeObserver.onError(th);
                    return;
                }
            case 2:
                this.f16836b.onSuccess(obj);
                return;
            case 3:
                this.f16836b.onSuccess(obj);
                return;
            default:
                this.f16836b.onSuccess(obj);
                return;
        }
    }

    public /* synthetic */ ei1(MaybeObserver maybeObserver, AtomicReference atomicReference, int i) {
        this.f16835a = i;
        this.f16836b = maybeObserver;
        this.f16837c = atomicReference;
    }
}
