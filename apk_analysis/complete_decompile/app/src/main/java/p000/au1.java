package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableCache;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class au1 extends AtomicInteger implements Disposable {
    private static final long serialVersionUID = 6770240836423125754L;

    /* renamed from: a */
    public final Observer f7745a;

    /* renamed from: b */
    public final ObservableCache f7746b;

    /* renamed from: c */
    public gj0 f7747c;

    /* renamed from: d */
    public int f7748d;

    /* renamed from: e */
    public long f7749e;

    /* renamed from: f */
    public volatile boolean f7750f;

    public au1(Observer observer, ObservableCache observableCache) {
        this.f7745a = observer;
        this.f7746b = observableCache;
        this.f7747c = observableCache.f19355e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        au1[] au1VarArr;
        if (!this.f7750f) {
            this.f7750f = true;
            ObservableCache observableCache = this.f7746b;
            while (true) {
                AtomicReference atomicReference = observableCache.f19353c;
                au1[] au1VarArr2 = (au1[]) atomicReference.get();
                int length = au1VarArr2.length;
                if (length != 0) {
                    int i = 0;
                    while (true) {
                        if (i < length) {
                            if (au1VarArr2[i] == this) {
                                break;
                            } else {
                                i++;
                            }
                        } else {
                            i = -1;
                            break;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            au1VarArr = ObservableCache.f19349j;
                        } else {
                            au1[] au1VarArr3 = new au1[length - 1];
                            System.arraycopy(au1VarArr2, 0, au1VarArr3, 0, i);
                            System.arraycopy(au1VarArr2, i + 1, au1VarArr3, i, (length - i) - 1);
                            au1VarArr = au1VarArr3;
                        }
                        while (!atomicReference.compareAndSet(au1VarArr2, au1VarArr)) {
                            if (atomicReference.get() != au1VarArr2) {
                                break;
                            }
                        }
                        return;
                    }
                    return;
                }
                return;
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f7750f;
    }
}
