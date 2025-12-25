package io.reactivex.rxjava3.subjects;

import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p000.C0569bt;

/* loaded from: classes2.dex */
public final class CompletableSubject extends Completable implements CompletableObserver {

    /* renamed from: d */
    public static final C0569bt[] f20110d = new C0569bt[0];

    /* renamed from: e */
    public static final C0569bt[] f20111e = new C0569bt[0];

    /* renamed from: c */
    public Throwable f20114c;

    /* renamed from: b */
    public final AtomicBoolean f20113b = new AtomicBoolean();

    /* renamed from: a */
    public final AtomicReference f20112a = new AtomicReference(f20110d);

    @CheckReturnValue
    @NonNull
    public static CompletableSubject create() {
        return new CompletableSubject();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d */
    public final void m5322d(C0569bt c0569bt) {
        C0569bt[] c0569btArr;
        while (true) {
            AtomicReference atomicReference = this.f20112a;
            C0569bt[] c0569btArr2 = (C0569bt[]) atomicReference.get();
            int length = c0569btArr2.length;
            if (length == 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i < length) {
                    if (c0569btArr2[i] == c0569bt) {
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
                c0569btArr = f20110d;
            } else {
                C0569bt[] c0569btArr3 = new C0569bt[length - 1];
                System.arraycopy(c0569btArr2, 0, c0569btArr3, 0, i);
                System.arraycopy(c0569btArr2, i + 1, c0569btArr3, i, (length - i) - 1);
                c0569btArr = c0569btArr3;
            }
            while (!atomicReference.compareAndSet(c0569btArr2, c0569btArr)) {
                if (atomicReference.get() != c0569btArr2) {
                    break;
                }
            }
            return;
        }
    }

    @Nullable
    public Throwable getThrowable() {
        if (this.f20112a.get() == f20111e) {
            return this.f20114c;
        }
        return null;
    }

    public boolean hasComplete() {
        if (this.f20112a.get() == f20111e && this.f20114c == null) {
            return true;
        }
        return false;
    }

    public boolean hasObservers() {
        if (((C0569bt[]) this.f20112a.get()).length != 0) {
            return true;
        }
        return false;
    }

    public boolean hasThrowable() {
        if (this.f20112a.get() == f20111e && this.f20114c != null) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public void onComplete() {
        if (this.f20113b.compareAndSet(false, true)) {
            for (C0569bt c0569bt : (C0569bt[]) this.f20112a.getAndSet(f20111e)) {
                c0569bt.f8149a.onComplete();
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public void onError(Throwable th) {
        ExceptionHelper.nullCheck(th, "onError called with a null Throwable.");
        if (this.f20113b.compareAndSet(false, true)) {
            this.f20114c = th;
            for (C0569bt c0569bt : (C0569bt[]) this.f20112a.getAndSet(f20111e)) {
                c0569bt.f8149a.onError(th);
            }
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public void onSubscribe(Disposable disposable) {
        if (this.f20112a.get() == f20111e) {
            disposable.dispose();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        C0569bt c0569bt = new C0569bt(completableObserver, this);
        completableObserver.onSubscribe(c0569bt);
        while (true) {
            AtomicReference atomicReference = this.f20112a;
            C0569bt[] c0569btArr = (C0569bt[]) atomicReference.get();
            if (c0569btArr == f20111e) {
                Throwable th = this.f20114c;
                if (th != null) {
                    completableObserver.onError(th);
                    return;
                } else {
                    completableObserver.onComplete();
                    return;
                }
            }
            int length = c0569btArr.length;
            C0569bt[] c0569btArr2 = new C0569bt[length + 1];
            System.arraycopy(c0569btArr, 0, c0569btArr2, 0, length);
            c0569btArr2[length] = c0569bt;
            while (!atomicReference.compareAndSet(c0569btArr, c0569btArr2)) {
                if (atomicReference.get() != c0569btArr) {
                    break;
                }
            }
            if (c0569bt.isDisposed()) {
                m5322d(c0569bt);
                return;
            }
            return;
        }
    }
}
