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
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class lw1 extends AtomicInteger implements Disposable, mw1 {
    private static final long serialVersionUID = -6071216598687999801L;

    /* renamed from: a */
    public final Observer f22686a;

    /* renamed from: g */
    public final Function f22692g;

    /* renamed from: h */
    public final Function f22693h;

    /* renamed from: i */
    public final BiFunction f22694i;

    /* renamed from: k */
    public int f22696k;

    /* renamed from: l */
    public int f22697l;

    /* renamed from: m */
    public volatile boolean f22698m;

    /* renamed from: c */
    public final CompositeDisposable f22688c = new CompositeDisposable();

    /* renamed from: b */
    public final SpscLinkedArrayQueue f22687b = new SpscLinkedArrayQueue(Observable.bufferSize());

    /* renamed from: d */
    public final LinkedHashMap f22689d = new LinkedHashMap();

    /* renamed from: e */
    public final LinkedHashMap f22690e = new LinkedHashMap();

    /* renamed from: f */
    public final AtomicReference f22691f = new AtomicReference();

    /* renamed from: j */
    public final AtomicInteger f22695j = new AtomicInteger(2);

    public lw1(Observer observer, Function function, Function function2, BiFunction biFunction) {
        this.f22686a = observer;
        this.f22692g = function;
        this.f22693h = function2;
        this.f22694i = biFunction;
    }

    @Override // p000.mw1
    /* renamed from: a */
    public final void mo5988a(Throwable th) {
        if (ExceptionHelper.addThrowable(this.f22691f, th)) {
            this.f22695j.decrementAndGet();
            m5993f();
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // p000.mw1
    /* renamed from: b */
    public final void mo5989b(Throwable th) {
        if (ExceptionHelper.addThrowable(this.f22691f, th)) {
            m5993f();
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // p000.mw1
    /* renamed from: c */
    public final void mo5990c(Object obj, boolean z) {
        int i;
        synchronized (this) {
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f22687b;
            if (z) {
                i = 1;
            } else {
                i = 2;
            }
            spscLinkedArrayQueue.offer(i, obj);
        }
        m5993f();
    }

    @Override // p000.mw1
    /* renamed from: d */
    public final void mo5991d(ow1 ow1Var) {
        this.f22688c.delete(ow1Var);
        this.f22695j.decrementAndGet();
        m5993f();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (this.f22698m) {
            return;
        }
        this.f22698m = true;
        this.f22688c.dispose();
        if (getAndIncrement() == 0) {
            this.f22687b.clear();
        }
    }

    @Override // p000.mw1
    /* renamed from: e */
    public final void mo5992e(boolean z, nw1 nw1Var) {
        int i;
        synchronized (this) {
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f22687b;
            if (z) {
                i = 3;
            } else {
                i = 4;
            }
            spscLinkedArrayQueue.offer(i, nw1Var);
        }
        m5993f();
    }

    /* renamed from: f */
    public final void m5993f() {
        boolean z;
        boolean z2;
        if (getAndIncrement() != 0) {
            return;
        }
        SpscLinkedArrayQueue spscLinkedArrayQueue = this.f22687b;
        Observer observer = this.f22686a;
        int i = 1;
        while (!this.f22698m) {
            if (((Throwable) this.f22691f.get()) != null) {
                spscLinkedArrayQueue.clear();
                this.f22688c.dispose();
                m5994g(observer);
                return;
            }
            if (this.f22695j.get() == 0) {
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
                Iterator it = this.f22689d.values().iterator();
                while (it.hasNext()) {
                    ((UnicastSubject) it.next()).onComplete();
                }
                this.f22689d.clear();
                this.f22690e.clear();
                this.f22688c.dispose();
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
                    UnicastSubject create = UnicastSubject.create();
                    int i2 = this.f22696k;
                    this.f22696k = i2 + 1;
                    this.f22689d.put(Integer.valueOf(i2), create);
                    try {
                        Object apply = this.f22692g.apply(poll);
                        Objects.requireNonNull(apply, "The leftEnd returned a null ObservableSource");
                        ObservableSource observableSource = (ObservableSource) apply;
                        nw1 nw1Var = new nw1(this, true, i2);
                        this.f22688c.add(nw1Var);
                        observableSource.subscribe(nw1Var);
                        if (((Throwable) this.f22691f.get()) != null) {
                            spscLinkedArrayQueue.clear();
                            this.f22688c.dispose();
                            m5994g(observer);
                            return;
                        }
                        try {
                            Object apply2 = this.f22694i.apply(poll, create);
                            Objects.requireNonNull(apply2, "The resultSelector returned a null value");
                            observer.onNext(apply2);
                            Iterator it2 = this.f22690e.values().iterator();
                            while (it2.hasNext()) {
                                create.onNext(it2.next());
                            }
                        } catch (Throwable th) {
                            m5995h(th, observer, spscLinkedArrayQueue);
                            return;
                        }
                    } catch (Throwable th2) {
                        m5995h(th2, observer, spscLinkedArrayQueue);
                        return;
                    }
                } else if (num == 2) {
                    int i3 = this.f22697l;
                    this.f22697l = i3 + 1;
                    this.f22690e.put(Integer.valueOf(i3), poll);
                    try {
                        Object apply3 = this.f22693h.apply(poll);
                        Objects.requireNonNull(apply3, "The rightEnd returned a null ObservableSource");
                        ObservableSource observableSource2 = (ObservableSource) apply3;
                        nw1 nw1Var2 = new nw1(this, false, i3);
                        this.f22688c.add(nw1Var2);
                        observableSource2.subscribe(nw1Var2);
                        if (((Throwable) this.f22691f.get()) != null) {
                            spscLinkedArrayQueue.clear();
                            this.f22688c.dispose();
                            m5994g(observer);
                            return;
                        } else {
                            Iterator it3 = this.f22689d.values().iterator();
                            while (it3.hasNext()) {
                                ((UnicastSubject) it3.next()).onNext(poll);
                            }
                        }
                    } catch (Throwable th3) {
                        m5995h(th3, observer, spscLinkedArrayQueue);
                        return;
                    }
                } else if (num == 3) {
                    nw1 nw1Var3 = (nw1) poll;
                    UnicastSubject unicastSubject = (UnicastSubject) this.f22689d.remove(Integer.valueOf(nw1Var3.f23515c));
                    this.f22688c.remove(nw1Var3);
                    if (unicastSubject != null) {
                        unicastSubject.onComplete();
                    }
                } else {
                    nw1 nw1Var4 = (nw1) poll;
                    this.f22690e.remove(Integer.valueOf(nw1Var4.f23515c));
                    this.f22688c.remove(nw1Var4);
                }
            }
        }
        spscLinkedArrayQueue.clear();
    }

    /* renamed from: g */
    public final void m5994g(Observer observer) {
        Throwable terminate = ExceptionHelper.terminate(this.f22691f);
        LinkedHashMap linkedHashMap = this.f22689d;
        Iterator it = linkedHashMap.values().iterator();
        while (it.hasNext()) {
            ((UnicastSubject) it.next()).onError(terminate);
        }
        linkedHashMap.clear();
        this.f22690e.clear();
        observer.onError(terminate);
    }

    /* renamed from: h */
    public final void m5995h(Throwable th, Observer observer, SpscLinkedArrayQueue spscLinkedArrayQueue) {
        Exceptions.throwIfFatal(th);
        ExceptionHelper.addThrowable(this.f22691f, th);
        spscLinkedArrayQueue.clear();
        this.f22688c.dispose();
        m5994g(observer);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f22698m;
    }
}
