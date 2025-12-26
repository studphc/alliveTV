package p000;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class oy1 extends AtomicInteger implements Disposable {
    private static final long serialVersionUID = -6178010334400373240L;

    /* renamed from: a */
    public final Observer f24952a;

    /* renamed from: b */
    public final BiPredicate f24953b;

    /* renamed from: c */
    public final ArrayCompositeDisposable f24954c;

    /* renamed from: d */
    public final ObservableSource f24955d;

    /* renamed from: e */
    public final ObservableSource f24956e;

    /* renamed from: f */
    public final py1[] f24957f;

    /* renamed from: g */
    public volatile boolean f24958g;

    /* renamed from: h */
    public Object f24959h;

    /* renamed from: i */
    public Object f24960i;

    public oy1(Observer observer, int i, ObservableSource observableSource, ObservableSource observableSource2, BiPredicate biPredicate) {
        this.f24952a = observer;
        this.f24955d = observableSource;
        this.f24956e = observableSource2;
        this.f24953b = biPredicate;
        this.f24957f = r3;
        py1[] py1VarArr = {new py1(this, 0, i), new py1(this, 1, i)};
        this.f24954c = new ArrayCompositeDisposable(2);
    }

    /* renamed from: a */
    public final void m6747a() {
        boolean z;
        boolean z2;
        Throwable th;
        Throwable th2;
        if (getAndIncrement() != 0) {
            return;
        }
        py1[] py1VarArr = this.f24957f;
        py1 py1Var = py1VarArr[0];
        SpscLinkedArrayQueue spscLinkedArrayQueue = py1Var.f25338b;
        py1 py1Var2 = py1VarArr[1];
        SpscLinkedArrayQueue spscLinkedArrayQueue2 = py1Var2.f25338b;
        int i = 1;
        while (!this.f24958g) {
            boolean z3 = py1Var.f25340d;
            if (z3 && (th2 = py1Var.f25341e) != null) {
                this.f24958g = true;
                spscLinkedArrayQueue.clear();
                spscLinkedArrayQueue2.clear();
                this.f24952a.onError(th2);
                return;
            }
            boolean z4 = py1Var2.f25340d;
            if (z4 && (th = py1Var2.f25341e) != null) {
                this.f24958g = true;
                spscLinkedArrayQueue.clear();
                spscLinkedArrayQueue2.clear();
                this.f24952a.onError(th);
                return;
            }
            if (this.f24959h == null) {
                this.f24959h = spscLinkedArrayQueue.poll();
            }
            if (this.f24959h == null) {
                z = true;
            } else {
                z = false;
            }
            if (this.f24960i == null) {
                this.f24960i = spscLinkedArrayQueue2.poll();
            }
            Object obj = this.f24960i;
            if (obj == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z3 && z4 && z && z2) {
                this.f24952a.onNext(Boolean.TRUE);
                this.f24952a.onComplete();
                return;
            }
            if (z3 && z4 && z != z2) {
                this.f24958g = true;
                spscLinkedArrayQueue.clear();
                spscLinkedArrayQueue2.clear();
                this.f24952a.onNext(Boolean.FALSE);
                this.f24952a.onComplete();
                return;
            }
            if (!z && !z2) {
                try {
                    if (!this.f24953b.test(this.f24959h, obj)) {
                        this.f24958g = true;
                        spscLinkedArrayQueue.clear();
                        spscLinkedArrayQueue2.clear();
                        this.f24952a.onNext(Boolean.FALSE);
                        this.f24952a.onComplete();
                        return;
                    }
                    this.f24959h = null;
                    this.f24960i = null;
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    this.f24958g = true;
                    spscLinkedArrayQueue.clear();
                    spscLinkedArrayQueue2.clear();
                    this.f24952a.onError(th3);
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
        if (!this.f24958g) {
            this.f24958g = true;
            this.f24954c.dispose();
            if (getAndIncrement() == 0) {
                py1[] py1VarArr = this.f24957f;
                py1VarArr[0].f25338b.clear();
                py1VarArr[1].f25338b.clear();
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f24958g;
    }
}
