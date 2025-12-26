package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class fu1 extends AtomicInteger implements Disposable {
    private static final long serialVersionUID = 8567835998786448817L;

    /* renamed from: a */
    public final Observer f17399a;

    /* renamed from: b */
    public final Function f17400b;

    /* renamed from: c */
    public final eu1[] f17401c;

    /* renamed from: d */
    public Object[] f17402d;

    /* renamed from: e */
    public final SpscLinkedArrayQueue f17403e;

    /* renamed from: f */
    public final boolean f17404f;

    /* renamed from: g */
    public volatile boolean f17405g;

    /* renamed from: h */
    public volatile boolean f17406h;

    /* renamed from: i */
    public final AtomicThrowable f17407i = new AtomicThrowable();

    /* renamed from: j */
    public int f17408j;

    /* renamed from: k */
    public int f17409k;

    public fu1(int i, int i2, Observer observer, Function function, boolean z) {
        this.f17399a = observer;
        this.f17400b = function;
        this.f17404f = z;
        this.f17402d = new Object[i];
        eu1[] eu1VarArr = new eu1[i];
        for (int i3 = 0; i3 < i; i3++) {
            eu1VarArr[i3] = new eu1(this, i3);
        }
        this.f17401c = eu1VarArr;
        this.f17403e = new SpscLinkedArrayQueue(i2);
    }

    /* renamed from: a */
    public final void m4841a() {
        for (eu1 eu1Var : this.f17401c) {
            eu1Var.getClass();
            DisposableHelper.dispose(eu1Var);
        }
    }

    /* renamed from: b */
    public final void m4842b(SpscLinkedArrayQueue spscLinkedArrayQueue) {
        synchronized (this) {
            this.f17402d = null;
        }
        spscLinkedArrayQueue.clear();
    }

    /* renamed from: c */
    public final void m4843c() {
        boolean z;
        if (getAndIncrement() != 0) {
            return;
        }
        SpscLinkedArrayQueue spscLinkedArrayQueue = this.f17403e;
        Observer<?> observer = this.f17399a;
        boolean z2 = this.f17404f;
        int i = 1;
        while (!this.f17405g) {
            if (!z2 && this.f17407i.get() != null) {
                m4841a();
                m4842b(spscLinkedArrayQueue);
                this.f17407i.tryTerminateConsumer(observer);
                return;
            }
            boolean z3 = this.f17406h;
            Object[] objArr = (Object[]) spscLinkedArrayQueue.poll();
            if (objArr == null) {
                z = true;
            } else {
                z = false;
            }
            if (z3 && z) {
                m4842b(spscLinkedArrayQueue);
                this.f17407i.tryTerminateConsumer(observer);
                return;
            }
            if (z) {
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else {
                try {
                    Object apply = this.f17400b.apply(objArr);
                    Objects.requireNonNull(apply, "The combiner returned a null value");
                    observer.onNext(apply);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.f17407i.tryAddThrowableOrReport(th);
                    m4841a();
                    m4842b(spscLinkedArrayQueue);
                    this.f17407i.tryTerminateConsumer(observer);
                    return;
                }
            }
        }
        m4842b(spscLinkedArrayQueue);
        this.f17407i.tryTerminateAndReport();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (!this.f17405g) {
            this.f17405g = true;
            m4841a();
            m4843c();
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f17405g;
    }
}
