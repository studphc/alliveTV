package io.reactivex.rxjava3.subjects;

import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p000.uj2;

/* loaded from: classes2.dex */
public final class SingleSubject<T> extends Single<T> implements SingleObserver<T> {

    /* renamed from: e */
    public static final uj2[] f20131e = new uj2[0];

    /* renamed from: f */
    public static final uj2[] f20132f = new uj2[0];

    /* renamed from: c */
    public Object f20135c;

    /* renamed from: d */
    public Throwable f20136d;

    /* renamed from: b */
    public final AtomicBoolean f20134b = new AtomicBoolean();

    /* renamed from: a */
    public final AtomicReference f20133a = new AtomicReference(f20131e);

    @CheckReturnValue
    @NonNull
    public static <T> SingleSubject<T> create() {
        return new SingleSubject<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: c */
    public final void m5326c(uj2 uj2Var) {
        uj2[] uj2VarArr;
        while (true) {
            AtomicReference atomicReference = this.f20133a;
            uj2[] uj2VarArr2 = (uj2[]) atomicReference.get();
            int length = uj2VarArr2.length;
            if (length == 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i < length) {
                    if (uj2VarArr2[i] == uj2Var) {
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
                uj2VarArr = f20131e;
            } else {
                uj2[] uj2VarArr3 = new uj2[length - 1];
                System.arraycopy(uj2VarArr2, 0, uj2VarArr3, 0, i);
                System.arraycopy(uj2VarArr2, i + 1, uj2VarArr3, i, (length - i) - 1);
                uj2VarArr = uj2VarArr3;
            }
            while (!atomicReference.compareAndSet(uj2VarArr2, uj2VarArr)) {
                if (atomicReference.get() != uj2VarArr2) {
                    break;
                }
            }
            return;
        }
    }

    @Nullable
    public Throwable getThrowable() {
        if (this.f20133a.get() == f20132f) {
            return this.f20136d;
        }
        return null;
    }

    @Nullable
    public T getValue() {
        if (this.f20133a.get() == f20132f) {
            return (T) this.f20135c;
        }
        return null;
    }

    public boolean hasObservers() {
        if (((uj2[]) this.f20133a.get()).length != 0) {
            return true;
        }
        return false;
    }

    public boolean hasThrowable() {
        if (this.f20133a.get() == f20132f && this.f20136d != null) {
            return true;
        }
        return false;
    }

    public boolean hasValue() {
        if (this.f20133a.get() == f20132f && this.f20135c != null) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public void onError(@NonNull Throwable th) {
        ExceptionHelper.nullCheck(th, "onError called with a null Throwable.");
        if (this.f20134b.compareAndSet(false, true)) {
            this.f20136d = th;
            for (uj2 uj2Var : (uj2[]) this.f20133a.getAndSet(f20132f)) {
                uj2Var.f27299a.onError(th);
            }
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public void onSubscribe(@NonNull Disposable disposable) {
        if (this.f20133a.get() == f20132f) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public void onSuccess(@NonNull T t) {
        ExceptionHelper.nullCheck(t, "onSuccess called with a null value.");
        if (this.f20134b.compareAndSet(false, true)) {
            this.f20135c = t;
            for (uj2 uj2Var : (uj2[]) this.f20133a.getAndSet(f20132f)) {
                uj2Var.f27299a.onSuccess(t);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(@NonNull SingleObserver<? super T> singleObserver) {
        uj2 uj2Var = new uj2(singleObserver, this);
        singleObserver.onSubscribe(uj2Var);
        while (true) {
            AtomicReference atomicReference = this.f20133a;
            uj2[] uj2VarArr = (uj2[]) atomicReference.get();
            if (uj2VarArr == f20132f) {
                Throwable th = this.f20136d;
                if (th != null) {
                    singleObserver.onError(th);
                    return;
                } else {
                    singleObserver.onSuccess((Object) this.f20135c);
                    return;
                }
            }
            int length = uj2VarArr.length;
            uj2[] uj2VarArr2 = new uj2[length + 1];
            System.arraycopy(uj2VarArr, 0, uj2VarArr2, 0, length);
            uj2VarArr2[length] = uj2Var;
            while (!atomicReference.compareAndSet(uj2VarArr, uj2VarArr2)) {
                if (atomicReference.get() != uj2VarArr) {
                    break;
                }
            }
            if (uj2Var.isDisposed()) {
                m5326c(uj2Var);
                return;
            }
            return;
        }
    }
}
