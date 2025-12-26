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
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class wt1 extends QueueDrainObserver implements Runnable, Disposable {

    /* renamed from: g */
    public final Supplier f28322g;

    /* renamed from: h */
    public final long f28323h;

    /* renamed from: i */
    public final TimeUnit f28324i;

    /* renamed from: j */
    public final Scheduler f28325j;

    /* renamed from: k */
    public Disposable f28326k;

    /* renamed from: l */
    public Collection f28327l;

    /* renamed from: m */
    public final AtomicReference f28328m;

    public wt1(SerializedObserver serializedObserver, Supplier supplier, long j, TimeUnit timeUnit, Scheduler scheduler) {
        super(serializedObserver, new MpscLinkedQueue());
        this.f28328m = new AtomicReference();
        this.f28322g = supplier;
        this.f28323h = j;
        this.f28324i = timeUnit;
        this.f28325j = scheduler;
    }

    @Override // io.reactivex.rxjava3.internal.observers.QueueDrainObserver, io.reactivex.rxjava3.internal.util.ObservableQueueDrain
    public final void accept(Observer observer, Object obj) {
        this.downstream.onNext((Collection) obj);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this.f28328m);
        this.f28326k.dispose();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        if (this.f28328m.get() == DisposableHelper.DISPOSED) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        Collection collection;
        synchronized (this) {
            collection = this.f28327l;
            this.f28327l = null;
        }
        if (collection != null) {
            this.queue.offer(collection);
            this.done = true;
            if (enter()) {
                QueueDrainHelper.drainLoop(this.queue, this.downstream, false, null, this);
            }
        }
        DisposableHelper.dispose(this.f28328m);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        synchronized (this) {
            this.f28327l = null;
        }
        this.downstream.onError(th);
        DisposableHelper.dispose(this.f28328m);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        synchronized (this) {
            try {
                Collection collection = this.f28327l;
                if (collection == null) {
                    return;
                }
                collection.add(obj);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f28326k, disposable)) {
            this.f28326k = disposable;
            try {
                Object obj = this.f28322g.get();
                Objects.requireNonNull(obj, "The buffer supplied is null");
                this.f28327l = (Collection) obj;
                this.downstream.onSubscribe(this);
                AtomicReference atomicReference = this.f28328m;
                if (!DisposableHelper.isDisposed((Disposable) atomicReference.get())) {
                    TimeUnit timeUnit = this.f28324i;
                    Scheduler scheduler = this.f28325j;
                    long j = this.f28323h;
                    DisposableHelper.set(atomicReference, scheduler.schedulePeriodicallyDirect(this, j, j, timeUnit));
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                dispose();
                EmptyDisposable.error(th, this.downstream);
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Collection collection;
        try {
            Object obj = this.f28322g.get();
            Objects.requireNonNull(obj, "The bufferSupplier returned a null buffer");
            Collection collection2 = (Collection) obj;
            synchronized (this) {
                try {
                    collection = this.f28327l;
                    if (collection != null) {
                        this.f28327l = collection2;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (collection == null) {
                DisposableHelper.dispose(this.f28328m);
            } else {
                fastPathEmit(collection, false, this);
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            this.downstream.onError(th2);
            dispose();
        }
    }
}
