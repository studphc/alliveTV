package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class zz1 extends AtomicInteger implements Observer, Disposable, Runnable {
    private static final long serialVersionUID = 3366976432059579510L;

    /* renamed from: a */
    public final Observer f29578a;

    /* renamed from: b */
    public final long f29579b;

    /* renamed from: c */
    public final long f29580c;

    /* renamed from: d */
    public final int f29581d;

    /* renamed from: e */
    public final ArrayDeque f29582e = new ArrayDeque();

    /* renamed from: f */
    public final AtomicBoolean f29583f = new AtomicBoolean();

    /* renamed from: g */
    public long f29584g;

    /* renamed from: h */
    public long f29585h;

    /* renamed from: i */
    public Disposable f29586i;

    public zz1(Observer observer, long j, long j2, int i) {
        this.f29578a = observer;
        this.f29579b = j;
        this.f29580c = j2;
        this.f29581d = i;
        lazySet(1);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (this.f29583f.compareAndSet(false, true)) {
            run();
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f29583f.get();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        ArrayDeque arrayDeque = this.f29582e;
        while (!arrayDeque.isEmpty()) {
            ((UnicastSubject) arrayDeque.poll()).onComplete();
        }
        this.f29578a.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        ArrayDeque arrayDeque = this.f29582e;
        while (!arrayDeque.isEmpty()) {
            ((UnicastSubject) arrayDeque.poll()).onError(th);
        }
        this.f29578a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        ux1 ux1Var;
        ArrayDeque arrayDeque = this.f29582e;
        long j = this.f29584g;
        long j2 = this.f29580c;
        long j3 = j % j2;
        AtomicBoolean atomicBoolean = this.f29583f;
        if (j3 == 0 && !atomicBoolean.get()) {
            getAndIncrement();
            UnicastSubject create = UnicastSubject.create(this.f29581d, this);
            ux1Var = new ux1(create);
            arrayDeque.offer(create);
            this.f29578a.onNext(ux1Var);
        } else {
            ux1Var = null;
        }
        long j4 = this.f29585h + 1;
        Iterator it = arrayDeque.iterator();
        while (it.hasNext()) {
            ((UnicastSubject) it.next()).onNext(obj);
        }
        if (j4 >= this.f29579b) {
            ((UnicastSubject) arrayDeque.poll()).onComplete();
            if (arrayDeque.isEmpty() && atomicBoolean.get()) {
                return;
            } else {
                this.f29585h = j4 - j2;
            }
        } else {
            this.f29585h = j4;
        }
        this.f29584g = j + 1;
        if (ux1Var != null && ux1Var.m7788d()) {
            ((UnicastSubject) ux1Var.f27522b).onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f29586i, disposable)) {
            this.f29586i = disposable;
            this.f29578a.onSubscribe(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (decrementAndGet() == 0) {
            this.f29586i.dispose();
        }
    }
}
