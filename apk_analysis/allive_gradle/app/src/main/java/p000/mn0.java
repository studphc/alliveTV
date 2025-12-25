package p000;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class mn0 extends AtomicInteger implements Subscription, vm0 {
    private static final long serialVersionUID = -6071216598687999801L;

    /* renamed from: a */
    public final Subscriber f22992a;

    /* renamed from: h */
    public final Function f22999h;

    /* renamed from: i */
    public final Function f23000i;

    /* renamed from: j */
    public final BiFunction f23001j;

    /* renamed from: l */
    public int f23003l;

    /* renamed from: m */
    public int f23004m;

    /* renamed from: n */
    public volatile boolean f23005n;

    /* renamed from: b */
    public final AtomicLong f22993b = new AtomicLong();

    /* renamed from: d */
    public final CompositeDisposable f22995d = new CompositeDisposable();

    /* renamed from: c */
    public final SpscLinkedArrayQueue f22994c = new SpscLinkedArrayQueue(Flowable.bufferSize());

    /* renamed from: e */
    public final LinkedHashMap f22996e = new LinkedHashMap();

    /* renamed from: f */
    public final LinkedHashMap f22997f = new LinkedHashMap();

    /* renamed from: g */
    public final AtomicReference f22998g = new AtomicReference();

    /* renamed from: k */
    public final AtomicInteger f23002k = new AtomicInteger(2);

    public mn0(Subscriber subscriber, Function function, Function function2, BiFunction biFunction) {
        this.f22992a = subscriber;
        this.f22999h = function;
        this.f23000i = function2;
        this.f23001j = biFunction;
    }

    @Override // p000.vm0
    /* renamed from: a */
    public final void mo6191a(Throwable th) {
        if (ExceptionHelper.addThrowable(this.f22998g, th)) {
            this.f23002k.decrementAndGet();
            m6197g();
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // p000.vm0
    /* renamed from: b */
    public final void mo6192b(Throwable th) {
        if (ExceptionHelper.addThrowable(this.f22998g, th)) {
            m6197g();
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // p000.vm0
    /* renamed from: c */
    public final void mo6193c(Object obj, boolean z) {
        int i;
        synchronized (this) {
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f22994c;
            if (z) {
                i = 1;
            } else {
                i = 2;
            }
            spscLinkedArrayQueue.offer(i, obj);
        }
        m6197g();
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (this.f23005n) {
            return;
        }
        this.f23005n = true;
        m6196f();
        if (getAndIncrement() == 0) {
            this.f22994c.clear();
        }
    }

    @Override // p000.vm0
    /* renamed from: d */
    public final void mo6194d(xm0 xm0Var) {
        this.f22995d.delete(xm0Var);
        this.f23002k.decrementAndGet();
        m6197g();
    }

    @Override // p000.vm0
    /* renamed from: e */
    public final void mo6195e(boolean z, wm0 wm0Var) {
        int i;
        synchronized (this) {
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f22994c;
            if (z) {
                i = 3;
            } else {
                i = 4;
            }
            spscLinkedArrayQueue.offer(i, wm0Var);
        }
        m6197g();
    }

    /* renamed from: f */
    public final void m6196f() {
        this.f22995d.dispose();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: g */
    public final void m6197g() {
        Object[] objArr;
        Object[] objArr2;
        if (getAndIncrement() != 0) {
            return;
        }
        SpscLinkedArrayQueue spscLinkedArrayQueue = this.f22994c;
        Subscriber subscriber = this.f22992a;
        boolean z = true;
        int i = 1;
        while (!this.f23005n) {
            if (((Throwable) this.f22998g.get()) != null) {
                spscLinkedArrayQueue.clear();
                m6196f();
                m6198h(subscriber);
                return;
            }
            if (this.f23002k.get() == 0) {
                objArr = z ? 1 : 0;
            } else {
                objArr = false;
            }
            Integer num = (Integer) spscLinkedArrayQueue.poll();
            if (num == null) {
                objArr2 = z ? 1 : 0;
            } else {
                objArr2 = false;
            }
            if (objArr != false && objArr2 != false) {
                this.f22996e.clear();
                this.f22997f.clear();
                this.f22995d.dispose();
                subscriber.onComplete();
                return;
            }
            if (objArr2 != false) {
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else {
                Object poll = spscLinkedArrayQueue.poll();
                if (num == Integer.valueOf(z ? 1 : 0)) {
                    int i2 = this.f23003l;
                    this.f23003l = i2 + 1;
                    this.f22996e.put(Integer.valueOf(i2), poll);
                    try {
                        Object apply = this.f22999h.apply(poll);
                        Objects.requireNonNull(apply, "The leftEnd returned a null Publisher");
                        Publisher publisher = (Publisher) apply;
                        wm0 wm0Var = new wm0(this, z, i2);
                        this.f22995d.add(wm0Var);
                        publisher.subscribe(wm0Var);
                        if (((Throwable) this.f22998g.get()) != null) {
                            spscLinkedArrayQueue.clear();
                            m6196f();
                            m6198h(subscriber);
                            return;
                        }
                        long j = this.f22993b.get();
                        Iterator it = this.f22997f.values().iterator();
                        long j2 = 0;
                        while (it.hasNext()) {
                            try {
                                Object apply2 = this.f23001j.apply(poll, it.next());
                                Objects.requireNonNull(apply2, "The resultSelector returned a null value");
                                if (j2 != j) {
                                    subscriber.onNext(apply2);
                                    j2++;
                                } else {
                                    ExceptionHelper.addThrowable(this.f22998g, new MissingBackpressureException("Could not emit value due to lack of requests"));
                                    spscLinkedArrayQueue.clear();
                                    m6196f();
                                    m6198h(subscriber);
                                    return;
                                }
                            } catch (Throwable th) {
                                m6199i(th, subscriber, spscLinkedArrayQueue);
                                return;
                            }
                        }
                        if (j2 != 0) {
                            BackpressureHelper.produced(this.f22993b, j2);
                        }
                    } catch (Throwable th2) {
                        m6199i(th2, subscriber, spscLinkedArrayQueue);
                        return;
                    }
                } else if (num == 2) {
                    int i3 = this.f23004m;
                    this.f23004m = i3 + 1;
                    this.f22997f.put(Integer.valueOf(i3), poll);
                    try {
                        Object apply3 = this.f23000i.apply(poll);
                        Objects.requireNonNull(apply3, "The rightEnd returned a null Publisher");
                        Publisher publisher2 = (Publisher) apply3;
                        wm0 wm0Var2 = new wm0(this, false, i3);
                        this.f22995d.add(wm0Var2);
                        publisher2.subscribe(wm0Var2);
                        if (((Throwable) this.f22998g.get()) != null) {
                            spscLinkedArrayQueue.clear();
                            m6196f();
                            m6198h(subscriber);
                            return;
                        }
                        long j3 = this.f22993b.get();
                        Iterator it2 = this.f22996e.values().iterator();
                        long j4 = 0;
                        while (it2.hasNext()) {
                            try {
                                Object apply4 = this.f23001j.apply(it2.next(), poll);
                                Objects.requireNonNull(apply4, "The resultSelector returned a null value");
                                if (j4 != j3) {
                                    subscriber.onNext(apply4);
                                    j4++;
                                } else {
                                    ExceptionHelper.addThrowable(this.f22998g, new MissingBackpressureException("Could not emit value due to lack of requests"));
                                    spscLinkedArrayQueue.clear();
                                    m6196f();
                                    m6198h(subscriber);
                                    return;
                                }
                            } catch (Throwable th3) {
                                m6199i(th3, subscriber, spscLinkedArrayQueue);
                                return;
                            }
                        }
                        if (j4 != 0) {
                            BackpressureHelper.produced(this.f22993b, j4);
                        }
                    } catch (Throwable th4) {
                        m6199i(th4, subscriber, spscLinkedArrayQueue);
                        return;
                    }
                } else if (num == 3) {
                    wm0 wm0Var3 = (wm0) poll;
                    this.f22996e.remove(Integer.valueOf(wm0Var3.f28241c));
                    this.f22995d.remove(wm0Var3);
                } else {
                    wm0 wm0Var4 = (wm0) poll;
                    this.f22997f.remove(Integer.valueOf(wm0Var4.f28241c));
                    this.f22995d.remove(wm0Var4);
                }
                z = true;
            }
        }
        spscLinkedArrayQueue.clear();
    }

    /* renamed from: h */
    public final void m6198h(Subscriber subscriber) {
        Throwable terminate = ExceptionHelper.terminate(this.f22998g);
        this.f22996e.clear();
        this.f22997f.clear();
        subscriber.onError(terminate);
    }

    /* renamed from: i */
    public final void m6199i(Throwable th, Subscriber subscriber, SimpleQueue simpleQueue) {
        Exceptions.throwIfFatal(th);
        ExceptionHelper.addThrowable(this.f22998g, th);
        simpleQueue.clear();
        m6196f();
        m6198h(subscriber);
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this.f22993b, j);
        }
    }
}
