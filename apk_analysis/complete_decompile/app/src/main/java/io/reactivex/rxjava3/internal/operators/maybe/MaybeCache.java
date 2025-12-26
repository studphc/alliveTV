package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;
import p000.AbstractC0002a1;
import p000.th1;

/* loaded from: classes2.dex */
public final class MaybeCache<T> extends Maybe<T> implements MaybeObserver<T> {

    /* renamed from: e */
    public static final th1[] f19115e = new th1[0];

    /* renamed from: f */
    public static final th1[] f19116f = new th1[0];

    /* renamed from: a */
    public final AtomicReference f19117a;

    /* renamed from: b */
    public final AtomicReference f19118b = new AtomicReference(f19115e);

    /* renamed from: c */
    public Object f19119c;

    /* renamed from: d */
    public Throwable f19120d;

    public MaybeCache(MaybeSource<T> maybeSource) {
        this.f19117a = new AtomicReference(maybeSource);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public final void m5285a(th1 th1Var) {
        th1[] th1VarArr;
        while (true) {
            AtomicReference atomicReference = this.f19118b;
            th1[] th1VarArr2 = (th1[]) atomicReference.get();
            int length = th1VarArr2.length;
            if (length == 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i < length) {
                    if (th1VarArr2[i] == th1Var) {
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
            if (length == 1) {
                th1VarArr = f19115e;
            } else {
                th1[] th1VarArr3 = new th1[length - 1];
                System.arraycopy(th1VarArr2, 0, th1VarArr3, 0, i);
                System.arraycopy(th1VarArr2, i + 1, th1VarArr3, i, (length - i) - 1);
                th1VarArr = th1VarArr3;
            }
            while (!atomicReference.compareAndSet(th1VarArr2, th1VarArr)) {
                if (atomicReference.get() != th1VarArr2) {
                    break;
                }
            }
            return;
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public void onComplete() {
        for (th1 th1Var : (th1[]) this.f19118b.getAndSet(f19116f)) {
            if (!th1Var.isDisposed()) {
                th1Var.f26814a.onComplete();
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public void onError(Throwable th) {
        this.f19120d = th;
        for (th1 th1Var : (th1[]) this.f19118b.getAndSet(f19116f)) {
            if (!th1Var.isDisposed()) {
                th1Var.f26814a.onError(th);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public void onSubscribe(Disposable disposable) {
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public void onSuccess(T t) {
        this.f19119c = t;
        for (th1 th1Var : (th1[]) this.f19118b.getAndSet(f19116f)) {
            if (!th1Var.isDisposed()) {
                th1Var.f26814a.onSuccess(t);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        th1 th1Var = new th1(maybeObserver, this);
        maybeObserver.onSubscribe(th1Var);
        while (true) {
            AtomicReference atomicReference = this.f19118b;
            th1[] th1VarArr = (th1[]) atomicReference.get();
            if (th1VarArr == f19116f) {
                if (!th1Var.isDisposed()) {
                    Throwable th = this.f19120d;
                    if (th != null) {
                        maybeObserver.onError(th);
                        return;
                    }
                    AbstractC0002a1 abstractC0002a1 = (Object) this.f19119c;
                    if (abstractC0002a1 != null) {
                        maybeObserver.onSuccess(abstractC0002a1);
                        return;
                    } else {
                        maybeObserver.onComplete();
                        return;
                    }
                }
                return;
            }
            int length = th1VarArr.length;
            th1[] th1VarArr2 = new th1[length + 1];
            System.arraycopy(th1VarArr, 0, th1VarArr2, 0, length);
            th1VarArr2[length] = th1Var;
            while (!atomicReference.compareAndSet(th1VarArr, th1VarArr2)) {
                if (atomicReference.get() != th1VarArr) {
                    break;
                }
            }
            if (th1Var.isDisposed()) {
                m5285a(th1Var);
                return;
            }
            MaybeSource maybeSource = (MaybeSource) this.f19117a.getAndSet(null);
            if (maybeSource != null) {
                maybeSource.subscribe(this);
                return;
            }
            return;
        }
    }
}
