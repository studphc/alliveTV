package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.operators.mixed.ConcatMapXMainObserver;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import io.reactivex.rxjava3.operators.SimpleQueue;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class uu1 extends ConcatMapXMainObserver {
    private static final long serialVersionUID = -9140123220065488293L;

    /* renamed from: h */
    public final Observer f27451h;

    /* renamed from: i */
    public final Function f27452i;

    /* renamed from: j */
    public final tu1 f27453j;

    /* renamed from: k */
    public Object f27454k;

    /* renamed from: l */
    public volatile int f27455l;

    public uu1(Observer observer, Function function, int i, ErrorMode errorMode) {
        super(i, errorMode);
        this.f27451h = observer;
        this.f27452i = function;
        this.f27453j = new tu1(this);
    }

    @Override // io.reactivex.rxjava3.internal.operators.mixed.ConcatMapXMainObserver
    /* renamed from: a */
    public final void mo5286a() {
        this.f27454k = null;
    }

    @Override // io.reactivex.rxjava3.internal.operators.mixed.ConcatMapXMainObserver
    /* renamed from: b */
    public final void mo5287b() {
        tu1 tu1Var = this.f27453j;
        tu1Var.getClass();
        DisposableHelper.dispose(tu1Var);
    }

    @Override // io.reactivex.rxjava3.internal.operators.mixed.ConcatMapXMainObserver
    /* renamed from: c */
    public final void mo5288c() {
        if (getAndIncrement() != 0) {
            return;
        }
        Observer<?> observer = this.f27451h;
        ErrorMode errorMode = this.f19236c;
        SimpleQueue simpleQueue = this.f19237d;
        AtomicThrowable atomicThrowable = this.f19234a;
        int i = 1;
        while (true) {
            if (this.f19240g) {
                simpleQueue.clear();
                this.f27454k = null;
            } else {
                int i2 = this.f27455l;
                if (atomicThrowable.get() == null || (errorMode != ErrorMode.IMMEDIATE && (errorMode != ErrorMode.BOUNDARY || i2 != 0))) {
                    boolean z = false;
                    if (i2 == 0) {
                        boolean z2 = this.f19239f;
                        try {
                            Object poll = simpleQueue.poll();
                            if (poll == null) {
                                z = true;
                            }
                            if (z2 && z) {
                                atomicThrowable.tryTerminateConsumer(observer);
                                return;
                            }
                            if (!z) {
                                try {
                                    Object apply = this.f27452i.apply(poll);
                                    Objects.requireNonNull(apply, "The mapper returned a null SingleSource");
                                    SingleSource singleSource = (SingleSource) apply;
                                    this.f27455l = 1;
                                    singleSource.subscribe(this.f27453j);
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    this.f19238e.dispose();
                                    simpleQueue.clear();
                                    atomicThrowable.tryAddThrowableOrReport(th);
                                    atomicThrowable.tryTerminateConsumer(observer);
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            this.f19240g = true;
                            this.f19238e.dispose();
                            atomicThrowable.tryAddThrowableOrReport(th2);
                            atomicThrowable.tryTerminateConsumer(observer);
                            return;
                        }
                    } else if (i2 == 2) {
                        Object obj = this.f27454k;
                        this.f27454k = null;
                        observer.onNext(obj);
                        this.f27455l = 0;
                    }
                }
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
        }
        simpleQueue.clear();
        this.f27454k = null;
        atomicThrowable.tryTerminateConsumer(observer);
    }

    @Override // io.reactivex.rxjava3.internal.operators.mixed.ConcatMapXMainObserver
    /* renamed from: d */
    public final void mo5289d() {
        this.f27451h.onSubscribe(this);
    }
}
