package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.flowables.ConnectableFlowable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import p000.xo0;
import p000.yo0;

/* loaded from: classes2.dex */
public final class FlowableRefCount<T> extends Flowable<T> {

    /* renamed from: b */
    public final ConnectableFlowable f18976b;

    /* renamed from: c */
    public final int f18977c;

    /* renamed from: d */
    public final long f18978d;

    /* renamed from: e */
    public final TimeUnit f18979e;

    /* renamed from: f */
    public final Scheduler f18980f;

    /* renamed from: g */
    public xo0 f18981g;

    public FlowableRefCount(ConnectableFlowable<T> connectableFlowable) {
        this(connectableFlowable, 1, 0L, TimeUnit.NANOSECONDS, null);
    }

    /* renamed from: e */
    public final void m5277e(xo0 xo0Var) {
        synchronized (this) {
            try {
                if (this.f18981g == xo0Var) {
                    SequentialDisposable sequentialDisposable = xo0Var.f28667b;
                    if (sequentialDisposable != null) {
                        sequentialDisposable.dispose();
                        xo0Var.f28667b = null;
                    }
                    long j = xo0Var.f28668c - 1;
                    xo0Var.f28668c = j;
                    if (j == 0) {
                        this.f18981g = null;
                        this.f18976b.reset();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: f */
    public final void m5278f(xo0 xo0Var) {
        synchronized (this) {
            try {
                if (xo0Var.f28668c == 0 && xo0Var == this.f18981g) {
                    this.f18981g = null;
                    Disposable disposable = (Disposable) xo0Var.get();
                    DisposableHelper.dispose(xo0Var);
                    if (disposable == null) {
                        xo0Var.f28670e = true;
                    } else {
                        this.f18976b.reset();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        xo0 xo0Var;
        boolean z;
        SequentialDisposable sequentialDisposable;
        synchronized (this) {
            try {
                xo0Var = this.f18981g;
                if (xo0Var == null) {
                    xo0Var = new xo0(this);
                    this.f18981g = xo0Var;
                }
                long j = xo0Var.f28668c;
                if (j == 0 && (sequentialDisposable = xo0Var.f28667b) != null) {
                    sequentialDisposable.dispose();
                }
                long j2 = j + 1;
                xo0Var.f28668c = j2;
                if (!xo0Var.f28669d && j2 == this.f18977c) {
                    z = true;
                    xo0Var.f28669d = true;
                } else {
                    z = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f18976b.subscribe((FlowableSubscriber) new yo0(subscriber, this, xo0Var));
        if (z) {
            this.f18976b.connect(xo0Var);
        }
    }

    public FlowableRefCount(ConnectableFlowable<T> connectableFlowable, int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f18976b = connectableFlowable;
        this.f18977c = i;
        this.f18978d = j;
        this.f18979e = timeUnit;
        this.f18980f = scheduler;
    }
}
