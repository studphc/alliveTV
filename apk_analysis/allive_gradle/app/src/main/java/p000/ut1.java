package p000;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
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

/* loaded from: classes2.dex */
public final class ut1 extends QueueDrainObserver implements Disposable {

    /* renamed from: g */
    public final Supplier f27436g;

    /* renamed from: h */
    public final ObservableSource f27437h;

    /* renamed from: i */
    public Disposable f27438i;

    /* renamed from: j */
    public tt1 f27439j;

    /* renamed from: k */
    public Collection f27440k;

    public ut1(SerializedObserver serializedObserver, Supplier supplier, ObservableSource observableSource) {
        super(serializedObserver, new MpscLinkedQueue());
        this.f27436g = supplier;
        this.f27437h = observableSource;
    }

    /* renamed from: S */
    public final void m7768S() {
        try {
            Object obj = this.f27436g.get();
            Objects.requireNonNull(obj, "The buffer supplied is null");
            Collection collection = (Collection) obj;
            synchronized (this) {
                try {
                    Collection collection2 = this.f27440k;
                    if (collection2 == null) {
                        return;
                    }
                    this.f27440k = collection;
                    fastPathEmit(collection2, false, this);
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            dispose();
            this.downstream.onError(th2);
        }
    }

    @Override // io.reactivex.rxjava3.internal.observers.QueueDrainObserver, io.reactivex.rxjava3.internal.util.ObservableQueueDrain
    public final void accept(Observer observer, Object obj) {
        this.downstream.onNext((Collection) obj);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (!this.cancelled) {
            this.cancelled = true;
            this.f27439j.dispose();
            this.f27438i.dispose();
            if (enter()) {
                this.queue.clear();
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.cancelled;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        synchronized (this) {
            try {
                Collection collection = this.f27440k;
                if (collection == null) {
                    return;
                }
                this.f27440k = null;
                this.queue.offer(collection);
                this.done = true;
                if (enter()) {
                    QueueDrainHelper.drainLoop(this.queue, this.downstream, false, this, this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        dispose();
        this.downstream.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        synchronized (this) {
            try {
                Collection collection = this.f27440k;
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
        if (DisposableHelper.validate(this.f27438i, disposable)) {
            this.f27438i = disposable;
            try {
                Object obj = this.f27436g.get();
                Objects.requireNonNull(obj, "The buffer supplied is null");
                this.f27440k = (Collection) obj;
                tt1 tt1Var = new tt1(this);
                this.f27439j = tt1Var;
                this.downstream.onSubscribe(this);
                if (!this.cancelled) {
                    this.f27437h.subscribe(tt1Var);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.cancelled = true;
                disposable.dispose();
                EmptyDisposable.error(th, this.downstream);
            }
        }
    }
}
