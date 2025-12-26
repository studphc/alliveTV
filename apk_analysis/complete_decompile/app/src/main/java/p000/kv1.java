package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.EmptyComponent;

/* loaded from: classes2.dex */
public final class kv1 implements Observer, Disposable {

    /* renamed from: a */
    public final /* synthetic */ int f22215a;

    /* renamed from: b */
    public Object f22216b;

    /* renamed from: c */
    public Disposable f22217c;

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        switch (this.f22215a) {
            case 0:
                Disposable disposable = this.f22217c;
                this.f22217c = EmptyComponent.INSTANCE;
                this.f22216b = EmptyComponent.asObserver();
                disposable.dispose();
                return;
            case 1:
                this.f22217c.dispose();
                return;
            case 2:
                this.f22217c.dispose();
                return;
            case 3:
                this.f22217c.dispose();
                return;
            default:
                this.f22217c.dispose();
                return;
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        switch (this.f22215a) {
            case 0:
                return this.f22217c.isDisposed();
            case 1:
                return this.f22217c.isDisposed();
            case 2:
                return this.f22217c.isDisposed();
            case 3:
                return this.f22217c.isDisposed();
            default:
                return this.f22217c.isDisposed();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        switch (this.f22215a) {
            case 0:
                Observer observer = (Observer) this.f22216b;
                this.f22217c = EmptyComponent.INSTANCE;
                this.f22216b = EmptyComponent.asObserver();
                observer.onComplete();
                return;
            case 1:
                ((Observer) this.f22216b).onComplete();
                return;
            case 2:
                ((Observer) this.f22216b).onComplete();
                return;
            case 3:
                Notification createOnComplete = Notification.createOnComplete();
                Observer observer2 = (Observer) this.f22216b;
                observer2.onNext(createOnComplete);
                observer2.onComplete();
                return;
            default:
                ((CompletableObserver) this.f22216b).onComplete();
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        switch (this.f22215a) {
            case 0:
                Observer observer = (Observer) this.f22216b;
                this.f22217c = EmptyComponent.INSTANCE;
                this.f22216b = EmptyComponent.asObserver();
                observer.onError(th);
                return;
            case 1:
                ((Observer) this.f22216b).onError(th);
                return;
            case 2:
                ((Observer) this.f22216b).onError(th);
                return;
            case 3:
                Notification createOnError = Notification.createOnError(th);
                Observer observer2 = (Observer) this.f22216b;
                observer2.onNext(createOnError);
                observer2.onComplete();
                return;
            default:
                ((CompletableObserver) this.f22216b).onError(th);
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        switch (this.f22215a) {
            case 0:
                ((Observer) this.f22216b).onNext(obj);
                return;
            case 1:
                ((Observer) this.f22216b).onNext(obj);
                return;
            case 2:
                return;
            case 3:
                ((Observer) this.f22216b).onNext(Notification.createOnNext(obj));
                return;
            default:
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        switch (this.f22215a) {
            case 0:
                if (DisposableHelper.validate(this.f22217c, disposable)) {
                    this.f22217c = disposable;
                    ((Observer) this.f22216b).onSubscribe(this);
                    return;
                }
                return;
            case 1:
                if (DisposableHelper.validate(this.f22217c, disposable)) {
                    this.f22217c = disposable;
                    ((Observer) this.f22216b).onSubscribe(this);
                    return;
                }
                return;
            case 2:
                this.f22217c = disposable;
                ((Observer) this.f22216b).onSubscribe(this);
                return;
            case 3:
                if (DisposableHelper.validate(this.f22217c, disposable)) {
                    this.f22217c = disposable;
                    ((Observer) this.f22216b).onSubscribe(this);
                    return;
                }
                return;
            default:
                this.f22217c = disposable;
                ((CompletableObserver) this.f22216b).onSubscribe(this);
                return;
        }
    }

    public /* synthetic */ kv1(int i, Object obj) {
        this.f22215a = i;
        this.f22216b = obj;
    }

    /* renamed from: a */
    private final void m5794a(Object obj) {
    }

    /* renamed from: b */
    private final void m5795b(Object obj) {
    }
}
