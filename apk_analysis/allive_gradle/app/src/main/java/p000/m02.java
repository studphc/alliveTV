package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes2.dex */
public final class m02 extends AtomicInteger implements Observer, Disposable {
    private static final long serialVersionUID = 1577321883966341961L;

    /* renamed from: a */
    public final Observer f22746a;

    /* renamed from: b */
    public final Function f22747b;

    /* renamed from: c */
    public final n02[] f22748c;

    /* renamed from: d */
    public final AtomicReferenceArray f22749d;

    /* renamed from: e */
    public final AtomicReference f22750e;

    /* renamed from: f */
    public final AtomicThrowable f22751f;

    /* renamed from: g */
    public volatile boolean f22752g;

    public m02(Observer observer, Function function, int i) {
        this.f22746a = observer;
        this.f22747b = function;
        n02[] n02VarArr = new n02[i];
        for (int i2 = 0; i2 < i; i2++) {
            n02VarArr[i2] = new n02(this, i2);
        }
        this.f22748c = n02VarArr;
        this.f22749d = new AtomicReferenceArray(i);
        this.f22750e = new AtomicReference();
        this.f22751f = new AtomicThrowable();
    }

    /* renamed from: a */
    public final void m6001a(int i) {
        int i2 = 0;
        while (true) {
            n02[] n02VarArr = this.f22748c;
            if (i2 < n02VarArr.length) {
                if (i2 != i) {
                    n02 n02Var = n02VarArr[i2];
                    n02Var.getClass();
                    DisposableHelper.dispose(n02Var);
                }
                i2++;
            } else {
                return;
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this.f22750e);
        for (n02 n02Var : this.f22748c) {
            n02Var.getClass();
            DisposableHelper.dispose(n02Var);
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) this.f22750e.get());
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        if (!this.f22752g) {
            this.f22752g = true;
            m6001a(-1);
            HalfSerializer.onComplete((Observer<?>) this.f22746a, this, this.f22751f);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        if (this.f22752g) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f22752g = true;
        m6001a(-1);
        HalfSerializer.onError((Observer<?>) this.f22746a, th, this, this.f22751f);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        if (this.f22752g) {
            return;
        }
        AtomicReferenceArray atomicReferenceArray = this.f22749d;
        int length = atomicReferenceArray.length();
        Object[] objArr = new Object[length + 1];
        int i = 0;
        objArr[0] = obj;
        while (i < length) {
            Object obj2 = atomicReferenceArray.get(i);
            if (obj2 == null) {
                return;
            }
            i++;
            objArr[i] = obj2;
        }
        try {
            Object apply = this.f22747b.apply(objArr);
            Objects.requireNonNull(apply, "combiner returned a null value");
            HalfSerializer.onNext((Observer<? super Object>) this.f22746a, apply, this, this.f22751f);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            dispose();
            onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.f22750e, disposable);
    }
}
