package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p000.ni2;

/* loaded from: classes2.dex */
public final class SingleCache<T> extends Single<T> implements SingleObserver<T> {

    /* renamed from: f */
    public static final ni2[] f19709f = new ni2[0];

    /* renamed from: g */
    public static final ni2[] f19710g = new ni2[0];

    /* renamed from: a */
    public final SingleSource f19711a;

    /* renamed from: b */
    public final AtomicInteger f19712b = new AtomicInteger();

    /* renamed from: c */
    public final AtomicReference f19713c = new AtomicReference(f19709f);

    /* renamed from: d */
    public Object f19714d;

    /* renamed from: e */
    public Throwable f19715e;

    public SingleCache(SingleSource<? extends T> singleSource) {
        this.f19711a = singleSource;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: c */
    public final void m5297c(ni2 ni2Var) {
        ni2[] ni2VarArr;
        while (true) {
            AtomicReference atomicReference = this.f19713c;
            ni2[] ni2VarArr2 = (ni2[]) atomicReference.get();
            int length = ni2VarArr2.length;
            if (length == 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i < length) {
                    if (ni2VarArr2[i] == ni2Var) {
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
                ni2VarArr = f19709f;
            } else {
                ni2[] ni2VarArr3 = new ni2[length - 1];
                System.arraycopy(ni2VarArr2, 0, ni2VarArr3, 0, i);
                System.arraycopy(ni2VarArr2, i + 1, ni2VarArr3, i, (length - i) - 1);
                ni2VarArr = ni2VarArr3;
            }
            while (!atomicReference.compareAndSet(ni2VarArr2, ni2VarArr)) {
                if (atomicReference.get() != ni2VarArr2) {
                    break;
                }
            }
            return;
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public void onError(Throwable th) {
        this.f19715e = th;
        for (ni2 ni2Var : (ni2[]) this.f19713c.getAndSet(f19710g)) {
            if (!ni2Var.get()) {
                ni2Var.f23374a.onError(th);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public void onSubscribe(Disposable disposable) {
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public void onSuccess(T t) {
        this.f19714d = t;
        for (ni2 ni2Var : (ni2[]) this.f19713c.getAndSet(f19710g)) {
            if (!ni2Var.get()) {
                ni2Var.f23374a.onSuccess(t);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        ni2 ni2Var = new ni2(singleObserver, this);
        singleObserver.onSubscribe(ni2Var);
        while (true) {
            AtomicReference atomicReference = this.f19713c;
            ni2[] ni2VarArr = (ni2[]) atomicReference.get();
            if (ni2VarArr == f19710g) {
                Throwable th = this.f19715e;
                if (th != null) {
                    singleObserver.onError(th);
                    return;
                } else {
                    singleObserver.onSuccess((Object) this.f19714d);
                    return;
                }
            }
            int length = ni2VarArr.length;
            ni2[] ni2VarArr2 = new ni2[length + 1];
            System.arraycopy(ni2VarArr, 0, ni2VarArr2, 0, length);
            ni2VarArr2[length] = ni2Var;
            while (!atomicReference.compareAndSet(ni2VarArr, ni2VarArr2)) {
                if (atomicReference.get() != ni2VarArr) {
                    break;
                }
            }
            if (ni2Var.get()) {
                m5297c(ni2Var);
            }
            if (this.f19712b.getAndIncrement() == 0) {
                this.f19711a.subscribe(this);
                return;
            }
            return;
        }
    }
}
