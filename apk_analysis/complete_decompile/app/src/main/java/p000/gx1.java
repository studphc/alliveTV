package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class gx1 extends AtomicReference implements Observer, Disposable {

    /* renamed from: e */
    public static final fx1[] f17856e = new fx1[0];

    /* renamed from: f */
    public static final fx1[] f17857f = new fx1[0];
    private static final long serialVersionUID = -3251430252873581268L;

    /* renamed from: b */
    public final AtomicReference f17859b;

    /* renamed from: d */
    public Throwable f17861d;

    /* renamed from: a */
    public final AtomicBoolean f17858a = new AtomicBoolean();

    /* renamed from: c */
    public final AtomicReference f17860c = new AtomicReference();

    public gx1(AtomicReference atomicReference) {
        this.f17859b = atomicReference;
        lazySet(f17856e);
    }

    /* renamed from: a */
    public final void m5025a(fx1 fx1Var) {
        fx1[] fx1VarArr;
        fx1[] fx1VarArr2;
        do {
            fx1VarArr = (fx1[]) get();
            int length = fx1VarArr.length;
            if (length == 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i < length) {
                    if (fx1VarArr[i] == fx1Var) {
                        break;
                    } else {
                        i++;
                    }
                } else {
                    i = -1;
                    break;
                }
            }
            if (i < 0) {
                return;
            }
            fx1VarArr2 = f17856e;
            if (length != 1) {
                fx1VarArr2 = new fx1[length - 1];
                System.arraycopy(fx1VarArr, 0, fx1VarArr2, 0, i);
                System.arraycopy(fx1VarArr, i + 1, fx1VarArr2, i, (length - i) - 1);
            }
        } while (!compareAndSet(fx1VarArr, fx1VarArr2));
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        AtomicReference atomicReference;
        getAndSet(f17857f);
        do {
            atomicReference = this.f17859b;
            if (atomicReference.compareAndSet(this, null)) {
                break;
            }
        } while (atomicReference.get() == this);
        DisposableHelper.dispose(this.f17860c);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        if (get() == f17857f) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        this.f17860c.lazySet(DisposableHelper.DISPOSED);
        for (fx1 fx1Var : (fx1[]) getAndSet(f17857f)) {
            fx1Var.f17425a.onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        AtomicReference atomicReference = this.f17860c;
        Object obj = atomicReference.get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (obj != disposableHelper) {
            this.f17861d = th;
            atomicReference.lazySet(disposableHelper);
            for (fx1 fx1Var : (fx1[]) getAndSet(f17857f)) {
                fx1Var.f17425a.onError(th);
            }
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        for (fx1 fx1Var : (fx1[]) get()) {
            fx1Var.f17425a.onNext(obj);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.f17860c, disposable);
    }
}
