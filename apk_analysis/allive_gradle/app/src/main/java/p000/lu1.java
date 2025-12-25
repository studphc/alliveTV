package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.operators.mixed.ConcatMapXMainObserver;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import io.reactivex.rxjava3.operators.SimpleQueue;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class lu1 extends ConcatMapXMainObserver {
    private static final long serialVersionUID = 3610901111000061034L;

    /* renamed from: h */
    public final CompletableObserver f22670h;

    /* renamed from: i */
    public final Function f22671i;

    /* renamed from: j */
    public final ku1 f22672j;

    /* renamed from: k */
    public volatile boolean f22673k;

    public lu1(CompletableObserver completableObserver, Function function, ErrorMode errorMode, int i) {
        super(i, errorMode);
        this.f22670h = completableObserver;
        this.f22671i = function;
        this.f22672j = new ku1(this);
    }

    @Override // io.reactivex.rxjava3.internal.operators.mixed.ConcatMapXMainObserver
    /* renamed from: b */
    public final void mo5287b() {
        ku1 ku1Var = this.f22672j;
        ku1Var.getClass();
        DisposableHelper.dispose(ku1Var);
    }

    @Override // io.reactivex.rxjava3.internal.operators.mixed.ConcatMapXMainObserver
    /* renamed from: c */
    public final void mo5288c() {
        CompletableSource completableSource;
        boolean z;
        if (getAndIncrement() != 0) {
            return;
        }
        AtomicThrowable atomicThrowable = this.f19234a;
        ErrorMode errorMode = this.f19236c;
        SimpleQueue simpleQueue = this.f19237d;
        while (!this.f19240g) {
            if (atomicThrowable.get() != null && (errorMode == ErrorMode.IMMEDIATE || (errorMode == ErrorMode.BOUNDARY && !this.f22673k))) {
                this.f19240g = true;
                simpleQueue.clear();
                atomicThrowable.tryTerminateConsumer(this.f22670h);
                return;
            }
            if (!this.f22673k) {
                boolean z2 = this.f19239f;
                try {
                    Object poll = simpleQueue.poll();
                    if (poll != null) {
                        Object apply = this.f22671i.apply(poll);
                        Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
                        completableSource = (CompletableSource) apply;
                        z = false;
                    } else {
                        completableSource = null;
                        z = true;
                    }
                    if (z2 && z) {
                        this.f19240g = true;
                        atomicThrowable.tryTerminateConsumer(this.f22670h);
                        return;
                    } else if (!z) {
                        this.f22673k = true;
                        completableSource.subscribe(this.f22672j);
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.f19240g = true;
                    simpleQueue.clear();
                    this.f19238e.dispose();
                    atomicThrowable.tryAddThrowableOrReport(th);
                    atomicThrowable.tryTerminateConsumer(this.f22670h);
                    return;
                }
            }
            if (decrementAndGet() == 0) {
                return;
            }
        }
        simpleQueue.clear();
    }

    @Override // io.reactivex.rxjava3.internal.operators.mixed.ConcatMapXMainObserver
    /* renamed from: d */
    public final void mo5289d() {
        this.f22670h.onSubscribe(this);
    }
}
