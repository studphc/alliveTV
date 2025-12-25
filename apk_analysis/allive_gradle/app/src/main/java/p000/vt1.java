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
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class vt1 extends QueueDrainObserver implements Runnable, Disposable {

    /* renamed from: g */
    public final Supplier f27954g;

    /* renamed from: h */
    public final long f27955h;

    /* renamed from: i */
    public final TimeUnit f27956i;

    /* renamed from: j */
    public final int f27957j;

    /* renamed from: k */
    public final boolean f27958k;

    /* renamed from: l */
    public final Scheduler.Worker f27959l;

    /* renamed from: m */
    public Collection f27960m;

    /* renamed from: n */
    public Disposable f27961n;

    /* renamed from: o */
    public Disposable f27962o;

    /* renamed from: p */
    public long f27963p;

    /* renamed from: q */
    public long f27964q;

    public vt1(SerializedObserver serializedObserver, Supplier supplier, long j, TimeUnit timeUnit, int i, boolean z, Scheduler.Worker worker) {
        super(serializedObserver, new MpscLinkedQueue());
        this.f27954g = supplier;
        this.f27955h = j;
        this.f27956i = timeUnit;
        this.f27957j = i;
        this.f27958k = z;
        this.f27959l = worker;
    }

    @Override // io.reactivex.rxjava3.internal.observers.QueueDrainObserver, io.reactivex.rxjava3.internal.util.ObservableQueueDrain
    public final void accept(Observer observer, Object obj) {
        observer.onNext((Collection) obj);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (!this.cancelled) {
            this.cancelled = true;
            this.f27962o.dispose();
            this.f27959l.dispose();
            synchronized (this) {
                this.f27960m = null;
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.cancelled;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        Collection collection;
        this.f27959l.dispose();
        synchronized (this) {
            collection = this.f27960m;
            this.f27960m = null;
        }
        if (collection != null) {
            this.queue.offer(collection);
            this.done = true;
            if (enter()) {
                QueueDrainHelper.drainLoop(this.queue, this.downstream, false, this, this);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        synchronized (this) {
            this.f27960m = null;
        }
        this.downstream.onError(th);
        this.f27959l.dispose();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        synchronized (this) {
            try {
                Collection collection = this.f27960m;
                if (collection == null) {
                    return;
                }
                collection.add(obj);
                if (collection.size() < this.f27957j) {
                    return;
                }
                this.f27960m = null;
                this.f27963p++;
                if (this.f27958k) {
                    this.f27961n.dispose();
                }
                fastPathOrderedEmit(collection, false, this);
                try {
                    Object obj2 = this.f27954g.get();
                    Objects.requireNonNull(obj2, "The buffer supplied is null");
                    Collection collection2 = (Collection) obj2;
                    synchronized (this) {
                        this.f27960m = collection2;
                        this.f27964q++;
                    }
                    if (this.f27958k) {
                        Scheduler.Worker worker = this.f27959l;
                        long j = this.f27955h;
                        this.f27961n = worker.schedulePeriodically(this, j, j, this.f27956i);
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.downstream.onError(th);
                    dispose();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f27962o, disposable)) {
            this.f27962o = disposable;
            try {
                Object obj = this.f27954g.get();
                Objects.requireNonNull(obj, "The buffer supplied is null");
                this.f27960m = (Collection) obj;
                this.downstream.onSubscribe(this);
                TimeUnit timeUnit = this.f27956i;
                Scheduler.Worker worker = this.f27959l;
                long j = this.f27955h;
                this.f27961n = worker.schedulePeriodically(this, j, j, timeUnit);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                disposable.dispose();
                EmptyDisposable.error(th, this.downstream);
                this.f27959l.dispose();
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Object obj = this.f27954g.get();
            Objects.requireNonNull(obj, "The bufferSupplier returned a null buffer");
            Collection collection = (Collection) obj;
            synchronized (this) {
                Collection collection2 = this.f27960m;
                if (collection2 != null && this.f27963p == this.f27964q) {
                    this.f27960m = collection;
                    fastPathOrderedEmit(collection2, false, this);
                }
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            dispose();
            this.downstream.onError(th);
        }
    }
}
