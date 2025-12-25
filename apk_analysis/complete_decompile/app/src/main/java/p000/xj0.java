package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.operators.mixed.ConcatMapXMainSubscriber;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import io.reactivex.rxjava3.operators.SimpleQueue;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class xj0 extends ConcatMapXMainSubscriber implements Disposable {
    private static final long serialVersionUID = 3610901111000061034L;

    /* renamed from: i */
    public final CompletableObserver f28585i;

    /* renamed from: j */
    public final Function f28586j;

    /* renamed from: k */
    public final wj0 f28587k;

    /* renamed from: l */
    public volatile boolean f28588l;

    /* renamed from: m */
    public int f28589m;

    public xj0(CompletableObserver completableObserver, Function function, ErrorMode errorMode, int i) {
        super(i, errorMode);
        this.f28585i = completableObserver;
        this.f28586j = function;
        this.f28587k = new wj0(this);
    }

    @Override // io.reactivex.rxjava3.internal.operators.mixed.ConcatMapXMainSubscriber
    /* renamed from: b */
    public final void mo110b() {
        wj0 wj0Var = this.f28587k;
        wj0Var.getClass();
        DisposableHelper.dispose(wj0Var);
    }

    @Override // io.reactivex.rxjava3.internal.operators.mixed.ConcatMapXMainSubscriber
    /* renamed from: c */
    public final void mo111c() {
        boolean z;
        if (getAndIncrement() != 0) {
            return;
        }
        ErrorMode errorMode = this.f19243c;
        SimpleQueue simpleQueue = this.f19244d;
        AtomicThrowable atomicThrowable = this.f19241a;
        boolean z2 = this.f19248h;
        while (!this.f19247g) {
            if (atomicThrowable.get() != null && (errorMode == ErrorMode.IMMEDIATE || (errorMode == ErrorMode.BOUNDARY && !this.f28588l))) {
                simpleQueue.clear();
                atomicThrowable.tryTerminateConsumer(this.f28585i);
                return;
            }
            if (!this.f28588l) {
                boolean z3 = this.f19246f;
                try {
                    Object poll = simpleQueue.poll();
                    if (poll == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z3 && z) {
                        atomicThrowable.tryTerminateConsumer(this.f28585i);
                        return;
                    }
                    if (!z) {
                        int i = this.f19242b;
                        int i2 = i - (i >> 1);
                        if (!z2) {
                            int i3 = this.f28589m + 1;
                            if (i3 == i2) {
                                this.f28589m = 0;
                                this.f19245e.request(i2);
                            } else {
                                this.f28589m = i3;
                            }
                        }
                        try {
                            Object apply = this.f28586j.apply(poll);
                            Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
                            CompletableSource completableSource = (CompletableSource) apply;
                            this.f28588l = true;
                            completableSource.subscribe(this.f28587k);
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            simpleQueue.clear();
                            this.f19245e.cancel();
                            atomicThrowable.tryAddThrowableOrReport(th);
                            atomicThrowable.tryTerminateConsumer(this.f28585i);
                            return;
                        }
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f19245e.cancel();
                    atomicThrowable.tryAddThrowableOrReport(th2);
                    atomicThrowable.tryTerminateConsumer(this.f28585i);
                    return;
                }
            }
            if (decrementAndGet() == 0) {
                return;
            }
        }
        simpleQueue.clear();
    }

    @Override // io.reactivex.rxjava3.internal.operators.mixed.ConcatMapXMainSubscriber
    /* renamed from: d */
    public final void mo112d() {
        this.f28585i.onSubscribe(this);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f19247g;
    }
}
