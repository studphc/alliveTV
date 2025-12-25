package p000;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class rt1 extends AtomicInteger implements Observer, Disposable {
    private static final long serialVersionUID = -8466418554264089604L;

    /* renamed from: a */
    public final Observer f26129a;

    /* renamed from: b */
    public final Supplier f26130b;

    /* renamed from: c */
    public final ObservableSource f26131c;

    /* renamed from: d */
    public final Function f26132d;

    /* renamed from: h */
    public volatile boolean f26136h;

    /* renamed from: j */
    public volatile boolean f26138j;

    /* renamed from: k */
    public long f26139k;

    /* renamed from: i */
    public final SpscLinkedArrayQueue f26137i = new SpscLinkedArrayQueue(Observable.bufferSize());

    /* renamed from: e */
    public final CompositeDisposable f26133e = new CompositeDisposable();

    /* renamed from: f */
    public final AtomicReference f26134f = new AtomicReference();

    /* renamed from: l */
    public LinkedHashMap f26140l = new LinkedHashMap();

    /* renamed from: g */
    public final AtomicThrowable f26135g = new AtomicThrowable();

    public rt1(Observer observer, ObservableSource observableSource, Function function, Supplier supplier) {
        this.f26129a = observer;
        this.f26130b = supplier;
        this.f26131c = observableSource;
        this.f26132d = function;
    }

    /* renamed from: a */
    public final void m7300a(st1 st1Var, long j) {
        boolean z;
        this.f26133e.delete(st1Var);
        if (this.f26133e.size() == 0) {
            DisposableHelper.dispose(this.f26134f);
            z = true;
        } else {
            z = false;
        }
        synchronized (this) {
            try {
                LinkedHashMap linkedHashMap = this.f26140l;
                if (linkedHashMap == null) {
                    return;
                }
                this.f26137i.offer(linkedHashMap.remove(Long.valueOf(j)));
                if (z) {
                    this.f26136h = true;
                }
                m7301b();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: b */
    public final void m7301b() {
        boolean z;
        if (getAndIncrement() != 0) {
            return;
        }
        Observer<?> observer = this.f26129a;
        SpscLinkedArrayQueue spscLinkedArrayQueue = this.f26137i;
        int i = 1;
        while (!this.f26138j) {
            boolean z2 = this.f26136h;
            if (z2 && this.f26135g.get() != null) {
                spscLinkedArrayQueue.clear();
                this.f26135g.tryTerminateConsumer(observer);
                return;
            }
            Collection collection = (Collection) spscLinkedArrayQueue.poll();
            if (collection == null) {
                z = true;
            } else {
                z = false;
            }
            if (z2 && z) {
                observer.onComplete();
                return;
            } else if (z) {
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else {
                observer.onNext(collection);
            }
        }
        spscLinkedArrayQueue.clear();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (DisposableHelper.dispose(this.f26134f)) {
            this.f26138j = true;
            this.f26133e.dispose();
            synchronized (this) {
                this.f26140l = null;
            }
            if (getAndIncrement() != 0) {
                this.f26137i.clear();
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) this.f26134f.get());
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        this.f26133e.dispose();
        synchronized (this) {
            try {
                LinkedHashMap linkedHashMap = this.f26140l;
                if (linkedHashMap == null) {
                    return;
                }
                Iterator it = linkedHashMap.values().iterator();
                while (it.hasNext()) {
                    this.f26137i.offer((Collection) it.next());
                }
                this.f26140l = null;
                this.f26136h = true;
                m7301b();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        if (this.f26135g.tryAddThrowableOrReport(th)) {
            this.f26133e.dispose();
            synchronized (this) {
                this.f26140l = null;
            }
            this.f26136h = true;
            m7301b();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        synchronized (this) {
            try {
                LinkedHashMap linkedHashMap = this.f26140l;
                if (linkedHashMap == null) {
                    return;
                }
                Iterator it = linkedHashMap.values().iterator();
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
        if (DisposableHelper.setOnce(this.f26134f, disposable)) {
            qt1 qt1Var = new qt1(this);
            this.f26133e.add(qt1Var);
            this.f26131c.subscribe(qt1Var);
        }
    }
}
