package p000;

import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.operators.mixed.ConcatMapXMainObserver;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import io.reactivex.rxjava3.operators.SimpleQueue;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class ou1 extends ConcatMapXMainObserver {
    private static final long serialVersionUID = -9140123220065488293L;

    /* renamed from: h */
    public final Observer f24912h;

    /* renamed from: i */
    public final Function f24913i;

    /* renamed from: j */
    public final nu1 f24914j;

    /* renamed from: k */
    public Object f24915k;

    /* renamed from: l */
    public volatile int f24916l;

    public ou1(Observer observer, Function function, int i, ErrorMode errorMode) {
        super(i, errorMode);
        this.f24912h = observer;
        this.f24913i = function;
        this.f24914j = new nu1(this);
    }

    @Override // io.reactivex.rxjava3.internal.operators.mixed.ConcatMapXMainObserver
    /* renamed from: a */
    public final void mo5286a() {
        this.f24915k = null;
    }

    @Override // io.reactivex.rxjava3.internal.operators.mixed.ConcatMapXMainObserver
    /* renamed from: b */
    public final void mo5287b() {
        nu1 nu1Var = this.f24914j;
        nu1Var.getClass();
        DisposableHelper.dispose(nu1Var);
    }

    @Override // io.reactivex.rxjava3.internal.operators.mixed.ConcatMapXMainObserver
    /* renamed from: c */
    public final void mo5288c() {
        if (getAndIncrement() != 0) {
            return;
        }
        Observer<?> observer = this.f24912h;
        ErrorMode errorMode = this.f19236c;
        SimpleQueue simpleQueue = this.f19237d;
        AtomicThrowable atomicThrowable = this.f19234a;
        int i = 1;
        while (true) {
            if (this.f19240g) {
                simpleQueue.clear();
                this.f24915k = null;
            } else {
                int i2 = this.f24916l;
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
                                    Object apply = this.f24913i.apply(poll);
                                    Objects.requireNonNull(apply, "The mapper returned a null MaybeSource");
                                    MaybeSource maybeSource = (MaybeSource) apply;
                                    this.f24916l = 1;
                                    maybeSource.subscribe(this.f24914j);
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
                        Object obj = this.f24915k;
                        this.f24915k = null;
                        observer.onNext(obj);
                        this.f24916l = 0;
                    }
                }
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
        }
        simpleQueue.clear();
        this.f24915k = null;
        atomicThrowable.tryTerminateConsumer(observer);
    }

    @Override // io.reactivex.rxjava3.internal.operators.mixed.ConcatMapXMainObserver
    /* renamed from: d */
    public final void mo5289d() {
        this.f24912h.onSubscribe(this);
    }
}
