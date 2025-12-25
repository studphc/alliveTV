package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.observers.QueueDrainObserver;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.util.QueueDrainHelper;
import io.reactivex.rxjava3.observers.SerializedObserver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class zt1 extends QueueDrainObserver implements Runnable, Disposable {

    /* renamed from: g */
    public final Supplier f29514g;

    /* renamed from: h */
    public final long f29515h;

    /* renamed from: i */
    public final long f29516i;

    /* renamed from: j */
    public final TimeUnit f29517j;

    /* renamed from: k */
    public final Scheduler.Worker f29518k;

    /* renamed from: l */
    public final LinkedList f29519l;

    /* renamed from: m */
    public Disposable f29520m;

    public zt1(SerializedObserver serializedObserver, Supplier supplier, long j, long j2, TimeUnit timeUnit, Scheduler.Worker worker) {
        super(serializedObserver, new MpscLinkedQueue());
        this.f29514g = supplier;
        this.f29515h = j;
        this.f29516i = j2;
        this.f29517j = timeUnit;
        this.f29518k = worker;
        this.f29519l = new LinkedList();
    }

    @Override // io.reactivex.rxjava3.internal.observers.QueueDrainObserver, io.reactivex.rxjava3.internal.util.ObservableQueueDrain
    public final void accept(Observer observer, Object obj) {
        observer.onNext((Collection) obj);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (!this.cancelled) {
            this.cancelled = true;
            synchronized (this) {
                this.f29519l.clear();
            }
            this.f29520m.dispose();
            this.f29518k.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.cancelled;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.f29519l);
            this.f29519l.clear();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.queue.offer((Collection) it.next());
        }
        this.done = true;
        if (enter()) {
            QueueDrainHelper.drainLoop(this.queue, this.downstream, false, this.f29518k, this);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        this.done = true;
        synchronized (this) {
            this.f29519l.clear();
        }
        this.downstream.onError(th);
        this.f29518k.dispose();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        synchronized (this) {
            try {
                Iterator it = this.f29519l.iterator();
                while (it.hasNext()) {
                    ((Collection) it.next()).add(obj);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        Scheduler.Worker worker = this.f29518k;
        if (DisposableHelper.validate(this.f29520m, disposable)) {
            this.f29520m = disposable;
            try {
                Object obj = this.f29514g.get();
                Objects.requireNonNull(obj, "The buffer supplied is null");
                Collection collection = (Collection) obj;
                this.f29519l.add(collection);
                this.downstream.onSubscribe(this);
                TimeUnit timeUnit = this.f29517j;
                Scheduler.Worker worker2 = this.f29518k;
                long j = this.f29516i;
                worker2.schedulePeriodically(this, j, j, timeUnit);
                worker.schedule(new yt1(this, collection), this.f29515h, this.f29517j);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                disposable.dispose();
                EmptyDisposable.error(th, this.downstream);
                worker.dispose();
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.cancelled) {
            return;
        }
        try {
            Object obj = this.f29514g.get();
            Objects.requireNonNull(obj, "The bufferSupplier returned a null buffer");
            Collection collection = (Collection) obj;
            synchronized (this) {
                try {
                    if (this.cancelled) {
                        return;
                    }
                    this.f29519l.add(collection);
                    this.f29518k.schedule(new xt1(this, collection), this.f29515h, this.f29517j);
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            this.downstream.onError(th2);
            dispose();
        }
    }
}
