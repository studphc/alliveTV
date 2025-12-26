package p000;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class qy1 extends AtomicInteger implements Disposable {
    private static final long serialVersionUID = -6178010334400373240L;

    /* renamed from: a */
    public final SingleObserver f25799a;

    /* renamed from: b */
    public final BiPredicate f25800b;

    /* renamed from: c */
    public final ArrayCompositeDisposable f25801c;

    /* renamed from: d */
    public final ObservableSource f25802d;

    /* renamed from: e */
    public final ObservableSource f25803e;

    /* renamed from: f */
    public final py1[] f25804f;

    /* renamed from: g */
    public volatile boolean f25805g;

    /* renamed from: h */
    public Object f25806h;

    /* renamed from: i */
    public Object f25807i;

    public qy1(SingleObserver singleObserver, int i, ObservableSource observableSource, ObservableSource observableSource2, BiPredicate biPredicate) {
        this.f25799a = singleObserver;
        this.f25802d = observableSource;
        this.f25803e = observableSource2;
        this.f25800b = biPredicate;
        this.f25804f = r3;
        py1[] py1VarArr = {new py1(this, 0, i), new py1(this, 1, i)};
        this.f25801c = new ArrayCompositeDisposable(2);
    }

    /* renamed from: a */
    public final void m7152a() {
        boolean z;
        boolean z2;
        Throwable th;
        Throwable th2;
        if (getAndIncrement() != 0) {
            return;
        }
        py1[] py1VarArr = this.f25804f;
        py1 py1Var = py1VarArr[0];
        SpscLinkedArrayQueue spscLinkedArrayQueue = py1Var.f25338b;
        py1 py1Var2 = py1VarArr[1];
        SpscLinkedArrayQueue spscLinkedArrayQueue2 = py1Var2.f25338b;
        int i = 1;
        while (!this.f25805g) {
            boolean z3 = py1Var.f25340d;
            if (z3 && (th2 = py1Var.f25341e) != null) {
                this.f25805g = true;
                spscLinkedArrayQueue.clear();
                spscLinkedArrayQueue2.clear();
                this.f25799a.onError(th2);
                return;
            }
            boolean z4 = py1Var2.f25340d;
            if (z4 && (th = py1Var2.f25341e) != null) {
                this.f25805g = true;
                spscLinkedArrayQueue.clear();
                spscLinkedArrayQueue2.clear();
                this.f25799a.onError(th);
                return;
            }
            if (this.f25806h == null) {
                this.f25806h = spscLinkedArrayQueue.poll();
            }
            if (this.f25806h == null) {
                z = true;
            } else {
                z = false;
            }
            if (this.f25807i == null) {
                this.f25807i = spscLinkedArrayQueue2.poll();
            }
            Object obj = this.f25807i;
            if (obj == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z3 && z4 && z && z2) {
                this.f25799a.onSuccess(Boolean.TRUE);
                return;
            }
            if (z3 && z4 && z != z2) {
                this.f25805g = true;
                spscLinkedArrayQueue.clear();
                spscLinkedArrayQueue2.clear();
                this.f25799a.onSuccess(Boolean.FALSE);
                return;
            }
            if (!z && !z2) {
                try {
                    if (!this.f25800b.test(this.f25806h, obj)) {
                        this.f25805g = true;
                        spscLinkedArrayQueue.clear();
                        spscLinkedArrayQueue2.clear();
                        this.f25799a.onSuccess(Boolean.FALSE);
                        return;
                    }
                    this.f25806h = null;
                    this.f25807i = null;
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    this.f25805g = true;
                    spscLinkedArrayQueue.clear();
                    spscLinkedArrayQueue2.clear();
                    this.f25799a.onError(th3);
                    return;
                }
            }
            if (z || z2) {
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }
        spscLinkedArrayQueue.clear();
        spscLinkedArrayQueue2.clear();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (!this.f25805g) {
            this.f25805g = true;
            this.f25801c.dispose();
            if (getAndIncrement() == 0) {
                py1[] py1VarArr = this.f25804f;
                py1VarArr[0].f25338b.clear();
                py1VarArr[1].f25338b.clear();
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f25805g;
    }
}
