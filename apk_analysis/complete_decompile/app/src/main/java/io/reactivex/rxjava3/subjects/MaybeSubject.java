package io.reactivex.rxjava3.subjects;

import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p000.AbstractC0002a1;
import p000.ij1;

/* loaded from: classes2.dex */
public final class MaybeSubject<T> extends Maybe<T> implements MaybeObserver<T> {

    /* renamed from: e */
    public static final ij1[] f20115e = new ij1[0];

    /* renamed from: f */
    public static final ij1[] f20116f = new ij1[0];

    /* renamed from: c */
    public Object f20119c;

    /* renamed from: d */
    public Throwable f20120d;

    /* renamed from: b */
    public final AtomicBoolean f20118b = new AtomicBoolean();

    /* renamed from: a */
    public final AtomicReference f20117a = new AtomicReference(f20115e);

    @CheckReturnValue
    @NonNull
    public static <T> MaybeSubject<T> create() {
        return new MaybeSubject<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public final void m5323a(ij1 ij1Var) {
        ij1[] ij1VarArr;
        while (true) {
            AtomicReference atomicReference = this.f20117a;
            ij1[] ij1VarArr2 = (ij1[]) atomicReference.get();
            int length = ij1VarArr2.length;
            if (length == 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i < length) {
                    if (ij1VarArr2[i] == ij1Var) {
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
                ij1VarArr = f20115e;
            } else {
                ij1[] ij1VarArr3 = new ij1[length - 1];
                System.arraycopy(ij1VarArr2, 0, ij1VarArr3, 0, i);
                System.arraycopy(ij1VarArr2, i + 1, ij1VarArr3, i, (length - i) - 1);
                ij1VarArr = ij1VarArr3;
            }
            while (!atomicReference.compareAndSet(ij1VarArr2, ij1VarArr)) {
                if (atomicReference.get() != ij1VarArr2) {
                    break;
                }
            }
            return;
        }
    }

    @Nullable
    public Throwable getThrowable() {
        if (this.f20117a.get() == f20116f) {
            return this.f20120d;
        }
        return null;
    }

    @Nullable
    public T getValue() {
        if (this.f20117a.get() == f20116f) {
            return (T) this.f20119c;
        }
        return null;
    }

    public boolean hasComplete() {
        if (this.f20117a.get() == f20116f && this.f20119c == null && this.f20120d == null) {
            return true;
        }
        return false;
    }

    public boolean hasObservers() {
        if (((ij1[]) this.f20117a.get()).length != 0) {
            return true;
        }
        return false;
    }

    public boolean hasThrowable() {
        if (this.f20117a.get() == f20116f && this.f20120d != null) {
            return true;
        }
        return false;
    }

    public boolean hasValue() {
        if (this.f20117a.get() == f20116f && this.f20119c != null) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public void onComplete() {
        if (this.f20118b.compareAndSet(false, true)) {
            for (ij1 ij1Var : (ij1[]) this.f20117a.getAndSet(f20116f)) {
                ij1Var.f18436a.onComplete();
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public void onError(Throwable th) {
        ExceptionHelper.nullCheck(th, "onError called with a null Throwable.");
        if (this.f20118b.compareAndSet(false, true)) {
            this.f20120d = th;
            for (ij1 ij1Var : (ij1[]) this.f20117a.getAndSet(f20116f)) {
                ij1Var.f18436a.onError(th);
            }
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public void onSubscribe(Disposable disposable) {
        if (this.f20117a.get() == f20116f) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public void onSuccess(T t) {
        ExceptionHelper.nullCheck(t, "onSuccess called with a null value.");
        if (this.f20118b.compareAndSet(false, true)) {
            this.f20119c = t;
            for (ij1 ij1Var : (ij1[]) this.f20117a.getAndSet(f20116f)) {
                ij1Var.f18436a.onSuccess(t);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        ij1 ij1Var = new ij1(maybeObserver, this);
        maybeObserver.onSubscribe(ij1Var);
        while (true) {
            AtomicReference atomicReference = this.f20117a;
            ij1[] ij1VarArr = (ij1[]) atomicReference.get();
            if (ij1VarArr == f20116f) {
                Throwable th = this.f20120d;
                if (th != null) {
                    maybeObserver.onError(th);
                    return;
                }
                AbstractC0002a1 abstractC0002a1 = (Object) this.f20119c;
                if (abstractC0002a1 == null) {
                    maybeObserver.onComplete();
                    return;
                } else {
                    maybeObserver.onSuccess(abstractC0002a1);
                    return;
                }
            }
            int length = ij1VarArr.length;
            ij1[] ij1VarArr2 = new ij1[length + 1];
            System.arraycopy(ij1VarArr, 0, ij1VarArr2, 0, length);
            ij1VarArr2[length] = ij1Var;
            while (!atomicReference.compareAndSet(ij1VarArr, ij1VarArr2)) {
                if (atomicReference.get() != ij1VarArr) {
                    break;
                }
            }
            if (ij1Var.isDisposed()) {
                m5323a(ij1Var);
                return;
            }
            return;
        }
    }
}
