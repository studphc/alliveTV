package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.flowables.ConnectableFlowable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.lo0;
import p000.mo0;

/* loaded from: classes2.dex */
public final class FlowablePublish<T> extends ConnectableFlowable<T> implements HasUpstreamPublisher<T> {

    /* renamed from: b */
    public final Publisher f18957b;

    /* renamed from: c */
    public final int f18958c;

    /* renamed from: d */
    public final AtomicReference f18959d = new AtomicReference();

    public FlowablePublish(Publisher<T> publisher, int i) {
        this.f18957b = publisher;
        this.f18958c = i;
    }

    @Override // io.reactivex.rxjava3.flowables.ConnectableFlowable
    public void connect(Consumer<? super Disposable> consumer) {
        mo0 mo0Var;
        loop0: while (true) {
            AtomicReference atomicReference = this.f18959d;
            mo0Var = (mo0) atomicReference.get();
            if (mo0Var != null && !mo0Var.isDisposed()) {
                break;
            }
            mo0 mo0Var2 = new mo0(atomicReference, this.f18958c);
            while (!atomicReference.compareAndSet(mo0Var, mo0Var2)) {
                if (atomicReference.get() != mo0Var) {
                    break;
                }
            }
            mo0Var = mo0Var2;
            break loop0;
        }
        AtomicBoolean atomicBoolean = mo0Var.f23015c;
        boolean z = false;
        if (!atomicBoolean.get() && atomicBoolean.compareAndSet(false, true)) {
            z = true;
        }
        try {
            consumer.accept(mo0Var);
            if (z) {
                this.f18957b.subscribe(mo0Var);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    @Override // io.reactivex.rxjava3.flowables.ConnectableFlowable
    public void reset() {
        AtomicReference atomicReference = this.f18959d;
        mo0 mo0Var = (mo0) atomicReference.get();
        if (mo0Var == null || !mo0Var.isDisposed()) {
            return;
        }
        while (!atomicReference.compareAndSet(mo0Var, null) && atomicReference.get() == mo0Var) {
        }
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.HasUpstreamPublisher
    public Publisher<T> source() {
        return this.f18957b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        mo0 mo0Var;
        loop0: while (true) {
            AtomicReference atomicReference = this.f18959d;
            mo0Var = (mo0) atomicReference.get();
            if (mo0Var != null) {
                break;
            }
            mo0 mo0Var2 = new mo0(atomicReference, this.f18958c);
            while (!atomicReference.compareAndSet(mo0Var, mo0Var2)) {
                if (atomicReference.get() != mo0Var) {
                    break;
                }
            }
            mo0Var = mo0Var2;
            break loop0;
        }
        lo0 lo0Var = new lo0(subscriber, mo0Var);
        subscriber.onSubscribe(lo0Var);
        while (true) {
            AtomicReference atomicReference2 = mo0Var.f23016d;
            lo0[] lo0VarArr = (lo0[]) atomicReference2.get();
            if (lo0VarArr == mo0.f23012l) {
                Throwable th = mo0Var.f23021i;
                Subscriber subscriber2 = lo0Var.f22593a;
                if (th != null) {
                    subscriber2.onError(th);
                    return;
                } else {
                    subscriber2.onComplete();
                    return;
                }
            }
            int length = lo0VarArr.length;
            lo0[] lo0VarArr2 = new lo0[length + 1];
            System.arraycopy(lo0VarArr, 0, lo0VarArr2, 0, length);
            lo0VarArr2[length] = lo0Var;
            while (!atomicReference2.compareAndSet(lo0VarArr, lo0VarArr2)) {
                if (atomicReference2.get() != lo0VarArr) {
                    break;
                }
            }
            if (lo0Var.m5961a()) {
                mo0Var.m6202c(lo0Var);
                return;
            } else {
                mo0Var.m6201b();
                return;
            }
        }
    }
}
