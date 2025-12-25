package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class o02 extends AtomicInteger implements Disposable {
    private static final long serialVersionUID = 2983708048395377667L;

    /* renamed from: a */
    public final Observer f23554a;

    /* renamed from: b */
    public final Function f23555b;

    /* renamed from: c */
    public final p02[] f23556c;

    /* renamed from: d */
    public final Object[] f23557d;

    /* renamed from: e */
    public final boolean f23558e;

    /* renamed from: f */
    public volatile boolean f23559f;

    public o02(Observer observer, Function function, int i, boolean z) {
        this.f23554a = observer;
        this.f23555b = function;
        this.f23556c = new p02[i];
        this.f23557d = new Object[i];
        this.f23558e = z;
    }

    /* renamed from: a */
    public final void m6402a() {
        p02[] p02VarArr = this.f23556c;
        for (p02 p02Var : p02VarArr) {
            p02Var.f24992b.clear();
        }
        for (p02 p02Var2 : p02VarArr) {
            DisposableHelper.dispose(p02Var2.f24995e);
        }
    }

    /* renamed from: b */
    public final void m6403b() {
        Throwable th;
        boolean z;
        if (getAndIncrement() != 0) {
            return;
        }
        p02[] p02VarArr = this.f23556c;
        Observer observer = this.f23554a;
        Object[] objArr = this.f23557d;
        boolean z2 = this.f23558e;
        int i = 1;
        while (true) {
            int i2 = 0;
            int i3 = 0;
            for (p02 p02Var : p02VarArr) {
                if (objArr[i3] == null) {
                    boolean z3 = p02Var.f24993c;
                    Object poll = p02Var.f24992b.poll();
                    if (poll == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (this.f23559f) {
                        m6402a();
                        return;
                    }
                    if (z3) {
                        if (z2) {
                            if (z) {
                                Throwable th2 = p02Var.f24994d;
                                this.f23559f = true;
                                m6402a();
                                if (th2 != null) {
                                    observer.onError(th2);
                                    return;
                                } else {
                                    observer.onComplete();
                                    return;
                                }
                            }
                        } else {
                            Throwable th3 = p02Var.f24994d;
                            if (th3 != null) {
                                this.f23559f = true;
                                m6402a();
                                observer.onError(th3);
                                return;
                            } else if (z) {
                                this.f23559f = true;
                                m6402a();
                                observer.onComplete();
                                return;
                            }
                        }
                    }
                    if (!z) {
                        objArr[i3] = poll;
                    } else {
                        i2++;
                    }
                } else if (p02Var.f24993c && !z2 && (th = p02Var.f24994d) != null) {
                    this.f23559f = true;
                    m6402a();
                    observer.onError(th);
                    return;
                }
                i3++;
            }
            if (i2 != 0) {
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else {
                try {
                    Object apply = this.f23555b.apply(objArr.clone());
                    Objects.requireNonNull(apply, "The zipper returned a null value");
                    observer.onNext(apply);
                    Arrays.fill(objArr, (Object) null);
                } catch (Throwable th4) {
                    Exceptions.throwIfFatal(th4);
                    m6402a();
                    observer.onError(th4);
                    return;
                }
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (!this.f23559f) {
            this.f23559f = true;
            for (p02 p02Var : this.f23556c) {
                DisposableHelper.dispose(p02Var.f24995e);
            }
            if (getAndIncrement() == 0) {
                for (p02 p02Var2 : this.f23556c) {
                    p02Var2.f24992b.clear();
                }
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f23559f;
    }
}
