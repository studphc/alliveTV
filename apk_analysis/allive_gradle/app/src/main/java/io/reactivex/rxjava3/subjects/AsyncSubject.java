package io.reactivex.rxjava3.subjects;

import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import p000.C0013ac;

/* loaded from: classes2.dex */
public final class AsyncSubject<T> extends Subject<T> {

    /* renamed from: d */
    public static final C0013ac[] f20097d = new C0013ac[0];

    /* renamed from: e */
    public static final C0013ac[] f20098e = new C0013ac[0];

    /* renamed from: a */
    public final AtomicReference f20099a = new AtomicReference(f20097d);

    /* renamed from: b */
    public Throwable f20100b;

    /* renamed from: c */
    public Object f20101c;

    @CheckReturnValue
    @NonNull
    public static <T> AsyncSubject<T> create() {
        return new AsyncSubject<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d */
    public final void m5320d(C0013ac c0013ac) {
        C0013ac[] c0013acArr;
        while (true) {
            AtomicReference atomicReference = this.f20099a;
            C0013ac[] c0013acArr2 = (C0013ac[]) atomicReference.get();
            int length = c0013acArr2.length;
            if (length == 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i < length) {
                    if (c0013acArr2[i] == c0013ac) {
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
                c0013acArr = f20097d;
            } else {
                C0013ac[] c0013acArr3 = new C0013ac[length - 1];
                System.arraycopy(c0013acArr2, 0, c0013acArr3, 0, i);
                System.arraycopy(c0013acArr2, i + 1, c0013acArr3, i, (length - i) - 1);
                c0013acArr = c0013acArr3;
            }
            while (!atomicReference.compareAndSet(c0013acArr2, c0013acArr)) {
                if (atomicReference.get() != c0013acArr2) {
                    break;
                }
            }
            return;
        }
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    @CheckReturnValue
    public Throwable getThrowable() {
        if (this.f20099a.get() == f20098e) {
            return this.f20100b;
        }
        return null;
    }

    @CheckReturnValue
    @Nullable
    public T getValue() {
        if (this.f20099a.get() == f20098e) {
            return (T) this.f20101c;
        }
        return null;
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    @CheckReturnValue
    public boolean hasComplete() {
        if (this.f20099a.get() == f20098e && this.f20100b == null) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    @CheckReturnValue
    public boolean hasObservers() {
        if (((C0013ac[]) this.f20099a.get()).length != 0) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    @CheckReturnValue
    public boolean hasThrowable() {
        if (this.f20099a.get() == f20098e && this.f20100b != null) {
            return true;
        }
        return false;
    }

    @CheckReturnValue
    public boolean hasValue() {
        if (this.f20099a.get() == f20098e && this.f20101c != null) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.Observer
    public void onComplete() {
        AtomicReference atomicReference = this.f20099a;
        Object obj = atomicReference.get();
        Object obj2 = f20098e;
        if (obj == obj2) {
            return;
        }
        Object obj3 = this.f20101c;
        C0013ac[] c0013acArr = (C0013ac[]) atomicReference.getAndSet(obj2);
        int i = 0;
        if (obj3 == null) {
            int length = c0013acArr.length;
            while (i < length) {
                c0013acArr[i].onComplete();
                i++;
            }
            return;
        }
        int length2 = c0013acArr.length;
        while (i < length2) {
            c0013acArr[i].complete(obj3);
            i++;
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onError(Throwable th) {
        ExceptionHelper.nullCheck(th, "onError called with a null Throwable.");
        AtomicReference atomicReference = this.f20099a;
        Object obj = atomicReference.get();
        Object obj2 = f20098e;
        if (obj == obj2) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f20101c = null;
        this.f20100b = th;
        C0013ac[] c0013acArr = (C0013ac[]) atomicReference.getAndSet(obj2);
        for (C0013ac c0013ac : c0013acArr) {
            c0013ac.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onNext(T t) {
        ExceptionHelper.nullCheck(t, "onNext called with a null value.");
        if (this.f20099a.get() == f20098e) {
            return;
        }
        this.f20101c = t;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onSubscribe(Disposable disposable) {
        if (this.f20099a.get() == f20098e) {
            disposable.dispose();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        C0013ac c0013ac = new C0013ac(observer, this);
        observer.onSubscribe(c0013ac);
        while (true) {
            AtomicReference atomicReference = this.f20099a;
            C0013ac[] c0013acArr = (C0013ac[]) atomicReference.get();
            if (c0013acArr == f20098e) {
                Throwable th = this.f20100b;
                if (th != null) {
                    observer.onError(th);
                    return;
                }
                Object obj = this.f20101c;
                if (obj != null) {
                    c0013ac.complete(obj);
                    return;
                } else {
                    c0013ac.onComplete();
                    return;
                }
            }
            int length = c0013acArr.length;
            C0013ac[] c0013acArr2 = new C0013ac[length + 1];
            System.arraycopy(c0013acArr, 0, c0013acArr2, 0, length);
            c0013acArr2[length] = c0013ac;
            while (!atomicReference.compareAndSet(c0013acArr, c0013acArr2)) {
                if (atomicReference.get() != c0013acArr) {
                    break;
                }
            }
            if (c0013ac.isDisposed()) {
                m5320d(c0013ac);
                return;
            }
            return;
        }
    }
}
