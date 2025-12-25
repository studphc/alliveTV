package p000;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class sw1 extends AtomicInteger implements Disposable, mw1 {
    private static final long serialVersionUID = -6071216598687999801L;

    /* renamed from: a */
    public final Observer f26594a;

    /* renamed from: g */
    public final Function f26600g;

    /* renamed from: h */
    public final Function f26601h;

    /* renamed from: i */
    public final BiFunction f26602i;

    /* renamed from: k */
    public int f26604k;

    /* renamed from: l */
    public int f26605l;

    /* renamed from: m */
    public volatile boolean f26606m;

    /* renamed from: c */
    public final CompositeDisposable f26596c = new CompositeDisposable();

    /* renamed from: b */
    public final SpscLinkedArrayQueue f26595b = new SpscLinkedArrayQueue(Observable.bufferSize());

    /* renamed from: d */
    public final LinkedHashMap f26597d = new LinkedHashMap();

    /* renamed from: e */
    public final LinkedHashMap f26598e = new LinkedHashMap();

    /* renamed from: f */
    public final AtomicReference f26599f = new AtomicReference();

    /* renamed from: j */
    public final AtomicInteger f26603j = new AtomicInteger(2);

    public sw1(Observer observer, Function function, Function function2, BiFunction biFunction) {
        this.f26594a = observer;
        this.f26600g = function;
        this.f26601h = function2;
        this.f26602i = biFunction;
    }

    @Override // p000.mw1
    /* renamed from: a */
    public final void mo5988a(Throwable th) {
        if (ExceptionHelper.addThrowable(this.f26599f, th)) {
            this.f26603j.decrementAndGet();
            m7419f();
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // p000.mw1
    /* renamed from: b */
    public final void mo5989b(Throwable th) {
        if (ExceptionHelper.addThrowable(this.f26599f, th)) {
            m7419f();
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // p000.mw1
    /* renamed from: c */
    public final void mo5990c(Object obj, boolean z) {
        int i;
        synchronized (this) {
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f26595b;
            if (z) {
                i = 1;
            } else {
                i = 2;
            }
            spscLinkedArrayQueue.offer(i, obj);
        }
        m7419f();
    }

    @Override // p000.mw1
    /* renamed from: d */
    public final void mo5991d(ow1 ow1Var) {
        this.f26596c.delete(ow1Var);
        this.f26603j.decrementAndGet();
        m7419f();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (!this.f26606m) {
            this.f26606m = true;
            this.f26596c.dispose();
            if (getAndIncrement() == 0) {
                this.f26595b.clear();
            }
        }
    }

    @Override // p000.mw1
    /* renamed from: e */
    public final void mo5992e(boolean z, nw1 nw1Var) {
        int i;
        synchronized (this) {
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f26595b;
            if (z) {
                i = 3;
            } else {
                i = 4;
            }
            spscLinkedArrayQueue.offer(i, nw1Var);
        }
        m7419f();
    }

    /* renamed from: f */
    public final void m7419f() {
        boolean z;
        boolean z2;
        if (getAndIncrement() != 0) {
            return;
        }
        SpscLinkedArrayQueue spscLinkedArrayQueue = this.f26595b;
        Observer observer = this.f26594a;
        int i = 1;
        while (!this.f26606m) {
            if (((Throwable) this.f26599f.get()) != null) {
                spscLinkedArrayQueue.clear();
                this.f26596c.dispose();
                m7420g(observer);
                return;
            }
            if (this.f26603j.get() == 0) {
                z = true;
            } else {
                z = false;
            }
            Integer num = (Integer) spscLinkedArrayQueue.poll();
            if (num == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z && z2) {
                this.f26597d.clear();
                this.f26598e.clear();
                this.f26596c.dispose();
                observer.onComplete();
                return;
            }
            if (z2) {
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else {
                Object poll = spscLinkedArrayQueue.poll();
                if (num == 1) {
                    int i2 = this.f26604k;
                    this.f26604k = i2 + 1;
                    this.f26597d.put(Integer.valueOf(i2), poll);
                    try {
                        Object apply = this.f26600g.apply(poll);
                        Objects.requireNonNull(apply, "The leftEnd returned a null ObservableSource");
                        ObservableSource observableSource = (ObservableSource) apply;
                        nw1 nw1Var = new nw1(this, true, i2);
                        this.f26596c.add(nw1Var);
                        observableSource.subscribe(nw1Var);
                        if (((Throwable) this.f26599f.get()) != null) {
                            spscLinkedArrayQueue.clear();
                            this.f26596c.dispose();
                            m7420g(observer);
                            return;
                        }
                        Iterator it = this.f26598e.values().iterator();
                        while (it.hasNext()) {
                            try {
                                Object apply2 = this.f26602i.apply(poll, it.next());
                                Objects.requireNonNull(apply2, "The resultSelector returned a null value");
                                observer.onNext(apply2);
                            } catch (Throwable th) {
                                m7421h(th, observer, spscLinkedArrayQueue);
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        m7421h(th2, observer, spscLinkedArrayQueue);
                        return;
                    }
                } else if (num == 2) {
                    int i3 = this.f26605l;
                    this.f26605l = i3 + 1;
                    this.f26598e.put(Integer.valueOf(i3), poll);
                    try {
                        Object apply3 = this.f26601h.apply(poll);
                        Objects.requireNonNull(apply3, "The rightEnd returned a null ObservableSource");
                        ObservableSource observableSource2 = (ObservableSource) apply3;
                        nw1 nw1Var2 = new nw1(this, false, i3);
                        this.f26596c.add(nw1Var2);
                        observableSource2.subscribe(nw1Var2);
                        if (((Throwable) this.f26599f.get()) != null) {
                            spscLinkedArrayQueue.clear();
                            this.f26596c.dispose();
                            m7420g(observer);
                            return;
                        }
                        Iterator it2 = this.f26597d.values().iterator();
                        while (it2.hasNext()) {
                            try {
                                Object apply4 = this.f26602i.apply(it2.next(), poll);
                                Objects.requireNonNull(apply4, "The resultSelector returned a null value");
                                observer.onNext(apply4);
                            } catch (Throwable th3) {
                                m7421h(th3, observer, spscLinkedArrayQueue);
                                return;
                            }
                        }
                    } catch (Throwable th4) {
                        m7421h(th4, observer, spscLinkedArrayQueue);
                        return;
                    }
                } else if (num == 3) {
                    nw1 nw1Var3 = (nw1) poll;
                    this.f26597d.remove(Integer.valueOf(nw1Var3.f23515c));
                    this.f26596c.remove(nw1Var3);
                } else {
                    nw1 nw1Var4 = (nw1) poll;
                    this.f26598e.remove(Integer.valueOf(nw1Var4.f23515c));
                    this.f26596c.remove(nw1Var4);
                }
            }
        }
        spscLinkedArrayQueue.clear();
    }

    /* renamed from: g */
    public final void m7420g(Observer observer) {
        Throwable terminate = ExceptionHelper.terminate(this.f26599f);
        this.f26597d.clear();
        this.f26598e.clear();
        observer.onError(terminate);
    }

    /* renamed from: h */
    public final void m7421h(Throwable th, Observer observer, SpscLinkedArrayQueue spscLinkedArrayQueue) {
        Exceptions.throwIfFatal(th);
        ExceptionHelper.addThrowable(this.f26599f, th);
        spscLinkedArrayQueue.clear();
        this.f26596c.dispose();
        m7420g(observer);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f26606m;
    }
}
