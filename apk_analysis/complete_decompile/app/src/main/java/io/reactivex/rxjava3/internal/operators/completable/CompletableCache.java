package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p000.C1132ds;

/* loaded from: classes2.dex */
public final class CompletableCache extends Completable implements CompletableObserver {

    /* renamed from: e */
    public static final C1132ds[] f18643e = new C1132ds[0];

    /* renamed from: f */
    public static final C1132ds[] f18644f = new C1132ds[0];

    /* renamed from: a */
    public final CompletableSource f18645a;

    /* renamed from: b */
    public final AtomicReference f18646b = new AtomicReference(f18643e);

    /* renamed from: c */
    public final AtomicBoolean f18647c = new AtomicBoolean();

    /* renamed from: d */
    public Throwable f18648d;

    public CompletableCache(CompletableSource completableSource) {
        this.f18645a = completableSource;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d */
    public final void m5273d(C1132ds c1132ds) {
        C1132ds[] c1132dsArr;
        while (true) {
            AtomicReference atomicReference = this.f18646b;
            C1132ds[] c1132dsArr2 = (C1132ds[]) atomicReference.get();
            int length = c1132dsArr2.length;
            if (length == 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i < length) {
                    if (c1132dsArr2[i] == c1132ds) {
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
                c1132dsArr = f18643e;
            } else {
                C1132ds[] c1132dsArr3 = new C1132ds[length - 1];
                System.arraycopy(c1132dsArr2, 0, c1132dsArr3, 0, i);
                System.arraycopy(c1132dsArr2, i + 1, c1132dsArr3, i, (length - i) - 1);
                c1132dsArr = c1132dsArr3;
            }
            while (!atomicReference.compareAndSet(c1132dsArr2, c1132dsArr)) {
                if (atomicReference.get() != c1132dsArr2) {
                    break;
                }
            }
            return;
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public void onComplete() {
        for (C1132ds c1132ds : (C1132ds[]) this.f18646b.getAndSet(f18644f)) {
            if (!c1132ds.get()) {
                c1132ds.f16511a.onComplete();
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public void onError(Throwable th) {
        this.f18648d = th;
        for (C1132ds c1132ds : (C1132ds[]) this.f18646b.getAndSet(f18644f)) {
            if (!c1132ds.get()) {
                c1132ds.f16511a.onError(th);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public void onSubscribe(Disposable disposable) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        C1132ds c1132ds = new C1132ds(this, completableObserver);
        completableObserver.onSubscribe(c1132ds);
        while (true) {
            AtomicReference atomicReference = this.f18646b;
            C1132ds[] c1132dsArr = (C1132ds[]) atomicReference.get();
            if (c1132dsArr == f18644f) {
                Throwable th = this.f18648d;
                if (th != null) {
                    completableObserver.onError(th);
                    return;
                } else {
                    completableObserver.onComplete();
                    return;
                }
            }
            int length = c1132dsArr.length;
            C1132ds[] c1132dsArr2 = new C1132ds[length + 1];
            System.arraycopy(c1132dsArr, 0, c1132dsArr2, 0, length);
            c1132dsArr2[length] = c1132ds;
            while (!atomicReference.compareAndSet(c1132dsArr, c1132dsArr2)) {
                if (atomicReference.get() != c1132dsArr) {
                    break;
                }
            }
            if (c1132ds.get()) {
                m5273d(c1132ds);
            }
            if (this.f18647c.compareAndSet(false, true)) {
                this.f18645a.subscribe(this);
                return;
            }
            return;
        }
    }
}
