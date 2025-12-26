package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Collection;

/* loaded from: classes2.dex */
public final class tw1 implements Observer, Disposable {

    /* renamed from: a */
    public final /* synthetic */ int f27004a;

    /* renamed from: b */
    public Disposable f27005b;

    /* renamed from: c */
    public Object f27006c;

    /* renamed from: d */
    public final Object f27007d;

    public /* synthetic */ tw1(int i, Object obj) {
        this.f27004a = i;
        this.f27007d = obj;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        switch (this.f27004a) {
            case 0:
                this.f27005b.dispose();
                this.f27005b = DisposableHelper.DISPOSED;
                return;
            case 1:
                this.f27006c = null;
                this.f27005b.dispose();
                return;
            case 2:
                this.f27005b.dispose();
                return;
            default:
                this.f27005b.dispose();
                return;
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        switch (this.f27004a) {
            case 0:
                if (this.f27005b == DisposableHelper.DISPOSED) {
                    return true;
                }
                return false;
            case 1:
                return this.f27005b.isDisposed();
            case 2:
                return this.f27005b.isDisposed();
            default:
                return this.f27005b.isDisposed();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        switch (this.f27004a) {
            case 0:
                this.f27005b = DisposableHelper.DISPOSED;
                Object obj = this.f27006c;
                MaybeObserver maybeObserver = (MaybeObserver) this.f27007d;
                if (obj != null) {
                    this.f27006c = null;
                    maybeObserver.onSuccess(obj);
                    return;
                } else {
                    maybeObserver.onComplete();
                    return;
                }
            case 1:
                Object obj2 = this.f27006c;
                Observer observer = (Observer) this.f27007d;
                if (obj2 != null) {
                    this.f27006c = null;
                    observer.onNext(obj2);
                }
                observer.onComplete();
                return;
            case 2:
                Collection collection = (Collection) this.f27006c;
                this.f27006c = null;
                Observer observer2 = (Observer) this.f27007d;
                observer2.onNext(collection);
                observer2.onComplete();
                return;
            default:
                Collection collection2 = (Collection) this.f27006c;
                this.f27006c = null;
                ((SingleObserver) this.f27007d).onSuccess(collection2);
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        switch (this.f27004a) {
            case 0:
                this.f27005b = DisposableHelper.DISPOSED;
                this.f27006c = null;
                ((MaybeObserver) this.f27007d).onError(th);
                return;
            case 1:
                this.f27006c = null;
                ((Observer) this.f27007d).onError(th);
                return;
            case 2:
                this.f27006c = null;
                ((Observer) this.f27007d).onError(th);
                return;
            default:
                this.f27006c = null;
                ((SingleObserver) this.f27007d).onError(th);
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        switch (this.f27004a) {
            case 0:
                this.f27006c = obj;
                return;
            case 1:
                this.f27006c = obj;
                return;
            case 2:
                ((Collection) this.f27006c).add(obj);
                return;
            default:
                ((Collection) this.f27006c).add(obj);
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        switch (this.f27004a) {
            case 0:
                if (DisposableHelper.validate(this.f27005b, disposable)) {
                    this.f27005b = disposable;
                    ((MaybeObserver) this.f27007d).onSubscribe(this);
                    return;
                }
                return;
            case 1:
                if (DisposableHelper.validate(this.f27005b, disposable)) {
                    this.f27005b = disposable;
                    ((Observer) this.f27007d).onSubscribe(this);
                    return;
                }
                return;
            case 2:
                if (DisposableHelper.validate(this.f27005b, disposable)) {
                    this.f27005b = disposable;
                    ((Observer) this.f27007d).onSubscribe(this);
                    return;
                }
                return;
            default:
                if (DisposableHelper.validate(this.f27005b, disposable)) {
                    this.f27005b = disposable;
                    ((SingleObserver) this.f27007d).onSubscribe(this);
                    return;
                }
                return;
        }
    }

    public /* synthetic */ tw1(Object obj, Collection collection, int i) {
        this.f27004a = i;
        this.f27007d = obj;
        this.f27006c = collection;
    }
}
