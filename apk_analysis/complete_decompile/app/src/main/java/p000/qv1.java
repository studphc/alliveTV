package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public final class qv1 implements Observer, Disposable {

    /* renamed from: a */
    public final Observer f25770a;

    /* renamed from: b */
    public final long f25771b;

    /* renamed from: c */
    public final Object f25772c;

    /* renamed from: d */
    public final boolean f25773d;

    /* renamed from: e */
    public Disposable f25774e;

    /* renamed from: f */
    public long f25775f;

    /* renamed from: g */
    public boolean f25776g;

    public qv1(Observer observer, long j, Object obj, boolean z) {
        this.f25770a = observer;
        this.f25771b = j;
        this.f25772c = obj;
        this.f25773d = z;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f25774e.dispose();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f25774e.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        if (!this.f25776g) {
            this.f25776g = true;
            Observer observer = this.f25770a;
            Object obj = this.f25772c;
            if (obj == null && this.f25773d) {
                observer.onError(new NoSuchElementException());
                return;
            }
            if (obj != null) {
                observer.onNext(obj);
            }
            observer.onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        if (this.f25776g) {
            RxJavaPlugins.onError(th);
        } else {
            this.f25776g = true;
            this.f25770a.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        if (this.f25776g) {
            return;
        }
        long j = this.f25775f;
        if (j == this.f25771b) {
            this.f25776g = true;
            this.f25774e.dispose();
            Observer observer = this.f25770a;
            observer.onNext(obj);
            observer.onComplete();
            return;
        }
        this.f25775f = j + 1;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f25774e, disposable)) {
            this.f25774e = disposable;
            this.f25770a.onSubscribe(this);
        }
    }
}
