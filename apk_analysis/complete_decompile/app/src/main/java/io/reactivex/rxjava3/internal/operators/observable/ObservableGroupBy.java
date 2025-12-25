package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.observables.GroupedObservable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import p000.AbstractC1607o2;

/* loaded from: classes2.dex */
public final class ObservableGroupBy<T, K, V> extends AbstractC1607o2 {

    /* renamed from: a */
    public final Function f19451a;

    /* renamed from: b */
    public final Function f19452b;

    /* renamed from: c */
    public final int f19453c;

    /* renamed from: d */
    public final boolean f19454d;

    /* loaded from: classes2.dex */
    public static final class GroupByObserver<T, K, V> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: i */
        public static final Object f19455i = new Object();
        private static final long serialVersionUID = -3688291656102519502L;

        /* renamed from: a */
        public final Observer f19456a;

        /* renamed from: b */
        public final Function f19457b;

        /* renamed from: c */
        public final Function f19458c;

        /* renamed from: d */
        public final int f19459d;

        /* renamed from: e */
        public final boolean f19460e;

        /* renamed from: g */
        public Disposable f19462g;

        /* renamed from: h */
        public final AtomicBoolean f19463h = new AtomicBoolean();

        /* renamed from: f */
        public final ConcurrentHashMap f19461f = new ConcurrentHashMap();

        public GroupByObserver(Observer<? super GroupedObservable<K, V>> observer, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i, boolean z) {
            this.f19456a = observer;
            this.f19457b = function;
            this.f19458c = function2;
            this.f19459d = i;
            this.f19460e = z;
            lazySet(1);
        }

        public void cancel(K k) {
            if (k == null) {
                k = (K) f19455i;
            }
            this.f19461f.remove(k);
            if (decrementAndGet() == 0) {
                this.f19462g.dispose();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (this.f19463h.compareAndSet(false, true) && decrementAndGet() == 0) {
                this.f19462g.dispose();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.f19463h.get();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            ConcurrentHashMap concurrentHashMap = this.f19461f;
            ArrayList arrayList = new ArrayList(concurrentHashMap.values());
            concurrentHashMap.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C1320b c1320b = ((C1319a) it.next()).f19641b;
                c1320b.f19646e = true;
                c1320b.m5295a();
            }
            this.f19456a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            ArrayList arrayList = new ArrayList(this.f19461f.values());
            this.f19461f.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C1320b c1320b = ((C1319a) it.next()).f19641b;
                c1320b.f19647f = th;
                c1320b.f19646e = true;
                c1320b.m5295a();
            }
            this.f19456a.onError(th);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            Object obj;
            boolean z;
            Observer observer = this.f19456a;
            try {
                Object apply = this.f19457b.apply(t);
                if (apply != null) {
                    obj = apply;
                } else {
                    obj = f19455i;
                }
                ConcurrentHashMap concurrentHashMap = this.f19461f;
                C1319a c1319a = (C1319a) concurrentHashMap.get(obj);
                if (c1319a == null) {
                    if (this.f19463h.get()) {
                        return;
                    }
                    C1319a c1319a2 = new C1319a(apply, new C1320b(this.f19459d, this, apply, this.f19460e));
                    concurrentHashMap.put(obj, c1319a2);
                    getAndIncrement();
                    z = true;
                    c1319a = c1319a2;
                } else {
                    z = false;
                }
                try {
                    C1320b c1320b = c1319a.f19641b;
                    Object apply2 = this.f19458c.apply(t);
                    Objects.requireNonNull(apply2, "The value supplied is null");
                    c1320b.f19643b.offer(apply2);
                    c1320b.m5295a();
                    if (z) {
                        observer.onNext(c1319a);
                        AtomicInteger atomicInteger = c1320b.f19650i;
                        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 2)) {
                            cancel(apply);
                            C1320b c1320b2 = c1319a.f19641b;
                            c1320b2.f19646e = true;
                            c1320b2.m5295a();
                        }
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.f19462g.dispose();
                    if (z) {
                        observer.onNext(c1319a);
                    }
                    onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f19462g.dispose();
                onError(th2);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f19462g, disposable)) {
                this.f19462g = disposable;
                this.f19456a.onSubscribe(this);
            }
        }
    }

    public ObservableGroupBy(ObservableSource<T> observableSource, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i, boolean z) {
        super(observableSource);
        this.f19451a = function;
        this.f19452b = function2;
        this.f19453c = i;
        this.f19454d = z;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super GroupedObservable<K, V>> observer) {
        this.source.subscribe(new GroupByObserver(observer, this.f19451a, this.f19452b, this.f19453c, this.f19454d));
    }
}
