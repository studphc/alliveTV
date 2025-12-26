package io.reactivex.rxjava3.subjects;

import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import p000.i82;

/* loaded from: classes2.dex */
public final class PublishSubject<T> extends Subject<T> {

    /* renamed from: c */
    public static final i82[] f20121c = new i82[0];

    /* renamed from: d */
    public static final i82[] f20122d = new i82[0];

    /* renamed from: a */
    public final AtomicReference f20123a = new AtomicReference(f20122d);

    /* renamed from: b */
    public Throwable f20124b;

    @CheckReturnValue
    @NonNull
    public static <T> PublishSubject<T> create() {
        return new PublishSubject<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d */
    public final void m5324d(i82 i82Var) {
        i82[] i82VarArr;
        while (true) {
            AtomicReference atomicReference = this.f20123a;
            i82[] i82VarArr2 = (i82[]) atomicReference.get();
            if (i82VarArr2 != f20121c && i82VarArr2 != (i82VarArr = f20122d)) {
                int length = i82VarArr2.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        if (i82VarArr2[i] == i82Var) {
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
                if (length != 1) {
                    i82VarArr = new i82[length - 1];
                    System.arraycopy(i82VarArr2, 0, i82VarArr, 0, i);
                    System.arraycopy(i82VarArr2, i + 1, i82VarArr, i, (length - i) - 1);
                }
                while (!atomicReference.compareAndSet(i82VarArr2, i82VarArr)) {
                    if (atomicReference.get() != i82VarArr2) {
                        break;
                    }
                }
                return;
            }
            return;
        }
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    @CheckReturnValue
    @Nullable
    public Throwable getThrowable() {
        if (this.f20123a.get() == f20121c) {
            return this.f20124b;
        }
        return null;
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    @CheckReturnValue
    public boolean hasComplete() {
        if (this.f20123a.get() == f20121c && this.f20124b == null) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    @CheckReturnValue
    public boolean hasObservers() {
        if (((i82[]) this.f20123a.get()).length != 0) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    @CheckReturnValue
    public boolean hasThrowable() {
        if (this.f20123a.get() == f20121c && this.f20124b != null) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onComplete() {
        AtomicReference atomicReference = this.f20123a;
        Object obj = atomicReference.get();
        Object obj2 = f20121c;
        if (obj == obj2) {
            return;
        }
        i82[] i82VarArr = (i82[]) atomicReference.getAndSet(obj2);
        for (i82 i82Var : i82VarArr) {
            if (!i82Var.get()) {
                i82Var.f18336a.onComplete();
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onError(Throwable th) {
        ExceptionHelper.nullCheck(th, "onError called with a null Throwable.");
        AtomicReference atomicReference = this.f20123a;
        Object obj = atomicReference.get();
        Object obj2 = f20121c;
        if (obj == obj2) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f20124b = th;
        i82[] i82VarArr = (i82[]) atomicReference.getAndSet(obj2);
        for (i82 i82Var : i82VarArr) {
            if (i82Var.get()) {
                RxJavaPlugins.onError(th);
            } else {
                i82Var.f18336a.onError(th);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onNext(T t) {
        ExceptionHelper.nullCheck(t, "onNext called with a null value.");
        for (i82 i82Var : (i82[]) this.f20123a.get()) {
            if (!i82Var.get()) {
                i82Var.f18336a.onNext(t);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onSubscribe(Disposable disposable) {
        if (this.f20123a.get() == f20121c) {
            disposable.dispose();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        i82 i82Var = new i82(observer, this);
        observer.onSubscribe(i82Var);
        while (true) {
            AtomicReference atomicReference = this.f20123a;
            i82[] i82VarArr = (i82[]) atomicReference.get();
            if (i82VarArr == f20121c) {
                Throwable th = this.f20124b;
                if (th != null) {
                    observer.onError(th);
                    return;
                } else {
                    observer.onComplete();
                    return;
                }
            }
            int length = i82VarArr.length;
            i82[] i82VarArr2 = new i82[length + 1];
            System.arraycopy(i82VarArr, 0, i82VarArr2, 0, length);
            i82VarArr2[length] = i82Var;
            while (!atomicReference.compareAndSet(i82VarArr, i82VarArr2)) {
                if (atomicReference.get() != i82VarArr) {
                    break;
                }
            }
            if (i82Var.get()) {
                m5324d(i82Var);
                return;
            }
            return;
        }
    }
}
