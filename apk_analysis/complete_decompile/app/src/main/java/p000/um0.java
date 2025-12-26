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
import io.reactivex.rxjava3.processors.UnicastProcessor;
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
public final class um0 extends AtomicInteger implements Subscription, vm0 {
    private static final long serialVersionUID = -6071216598687999801L;

    /* renamed from: a */
    public final Subscriber f27349a;

    /* renamed from: h */
    public final Function f27356h;

    /* renamed from: i */
    public final Function f27357i;

    /* renamed from: j */
    public final BiFunction f27358j;

    /* renamed from: l */
    public int f27360l;

    /* renamed from: m */
    public int f27361m;

    /* renamed from: n */
    public volatile boolean f27362n;

    /* renamed from: b */
    public final AtomicLong f27350b = new AtomicLong();

    /* renamed from: d */
    public final CompositeDisposable f27352d = new CompositeDisposable();

    /* renamed from: c */
    public final SpscLinkedArrayQueue f27351c = new SpscLinkedArrayQueue(Flowable.bufferSize());

    /* renamed from: e */
    public final LinkedHashMap f27353e = new LinkedHashMap();

    /* renamed from: f */
    public final LinkedHashMap f27354f = new LinkedHashMap();

    /* renamed from: g */
    public final AtomicReference f27355g = new AtomicReference();

    /* renamed from: k */
    public final AtomicInteger f27359k = new AtomicInteger(2);

    public um0(Subscriber subscriber, Function function, Function function2, BiFunction biFunction) {
        this.f27349a = subscriber;
        this.f27356h = function;
        this.f27357i = function2;
        this.f27358j = biFunction;
    }

    @Override // p000.vm0
    /* renamed from: a */
    public final void mo6191a(Throwable th) {
        if (ExceptionHelper.addThrowable(this.f27355g, th)) {
            this.f27359k.decrementAndGet();
            m7746f();
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // p000.vm0
    /* renamed from: b */
    public final void mo6192b(Throwable th) {
        if (ExceptionHelper.addThrowable(this.f27355g, th)) {
            m7746f();
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // p000.vm0
    /* renamed from: c */
    public final void mo6193c(Object obj, boolean z) {
        int i;
        synchronized (this) {
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f27351c;
            if (z) {
                i = 1;
            } else {
                i = 2;
            }
            spscLinkedArrayQueue.offer(i, obj);
        }
        m7746f();
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (this.f27362n) {
            return;
        }
        this.f27362n = true;
        this.f27352d.dispose();
        if (getAndIncrement() == 0) {
            this.f27351c.clear();
        }
    }

    @Override // p000.vm0
    /* renamed from: d */
    public final void mo6194d(xm0 xm0Var) {
        this.f27352d.delete(xm0Var);
        this.f27359k.decrementAndGet();
        m7746f();
    }

    @Override // p000.vm0
    /* renamed from: e */
    public final void mo6195e(boolean z, wm0 wm0Var) {
        int i;
        synchronized (this) {
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f27351c;
            if (z) {
                i = 3;
            } else {
                i = 4;
            }
            spscLinkedArrayQueue.offer(i, wm0Var);
        }
        m7746f();
    }

    /* renamed from: f */
    public final void m7746f() {
        boolean z;
        boolean z2;
        if (getAndIncrement() != 0) {
            return;
        }
        SpscLinkedArrayQueue spscLinkedArrayQueue = this.f27351c;
        Subscriber subscriber = this.f27349a;
        int i = 1;
        while (!this.f27362n) {
            if (((Throwable) this.f27355g.get()) != null) {
                spscLinkedArrayQueue.clear();
                this.f27352d.dispose();
                m7747g(subscriber);
                return;
            }
            if (this.f27359k.get() == 0) {
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
                Iterator it = this.f27353e.values().iterator();
                while (it.hasNext()) {
                    ((UnicastProcessor) it.next()).onComplete();
                }
                this.f27353e.clear();
                this.f27354f.clear();
                this.f27352d.dispose();
                subscriber.onComplete();
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
                    UnicastProcessor create = UnicastProcessor.create();
                    int i2 = this.f27360l;
                    this.f27360l = i2 + 1;
                    this.f27353e.put(Integer.valueOf(i2), create);
                    try {
                        Object apply = this.f27356h.apply(poll);
                        Objects.requireNonNull(apply, "The leftEnd returned a null Publisher");
                        Publisher publisher = (Publisher) apply;
                        wm0 wm0Var = new wm0(this, true, i2);
                        this.f27352d.add(wm0Var);
                        publisher.subscribe(wm0Var);
                        if (((Throwable) this.f27355g.get()) != null) {
                            spscLinkedArrayQueue.clear();
                            this.f27352d.dispose();
                            m7747g(subscriber);
                            return;
                        }
                        try {
                            Object apply2 = this.f27358j.apply(poll, create);
                            Objects.requireNonNull(apply2, "The resultSelector returned a null value");
                            if (this.f27350b.get() != 0) {
                                subscriber.onNext(apply2);
                                BackpressureHelper.produced(this.f27350b, 1L);
                                Iterator it2 = this.f27354f.values().iterator();
                                while (it2.hasNext()) {
                                    create.onNext(it2.next());
                                }
                            } else {
                                m7748h(new MissingBackpressureException("Could not emit value due to lack of requests"), subscriber, spscLinkedArrayQueue);
                                return;
                            }
                        } catch (Throwable th) {
                            m7748h(th, subscriber, spscLinkedArrayQueue);
                            return;
                        }
                    } catch (Throwable th2) {
                        m7748h(th2, subscriber, spscLinkedArrayQueue);
                        return;
                    }
                } else if (num == 2) {
                    int i3 = this.f27361m;
                    this.f27361m = i3 + 1;
                    this.f27354f.put(Integer.valueOf(i3), poll);
                    try {
                        Object apply3 = this.f27357i.apply(poll);
                        Objects.requireNonNull(apply3, "The rightEnd returned a null Publisher");
                        Publisher publisher2 = (Publisher) apply3;
                        wm0 wm0Var2 = new wm0(this, false, i3);
                        this.f27352d.add(wm0Var2);
                        publisher2.subscribe(wm0Var2);
                        if (((Throwable) this.f27355g.get()) != null) {
                            spscLinkedArrayQueue.clear();
                            this.f27352d.dispose();
                            m7747g(subscriber);
                            return;
                        } else {
                            Iterator it3 = this.f27353e.values().iterator();
                            while (it3.hasNext()) {
                                ((UnicastProcessor) it3.next()).onNext(poll);
                            }
                        }
                    } catch (Throwable th3) {
                        m7748h(th3, subscriber, spscLinkedArrayQueue);
                        return;
                    }
                } else if (num == 3) {
                    wm0 wm0Var3 = (wm0) poll;
                    UnicastProcessor unicastProcessor = (UnicastProcessor) this.f27353e.remove(Integer.valueOf(wm0Var3.f28241c));
                    this.f27352d.remove(wm0Var3);
                    if (unicastProcessor != null) {
                        unicastProcessor.onComplete();
                    }
                } else {
                    wm0 wm0Var4 = (wm0) poll;
                    this.f27354f.remove(Integer.valueOf(wm0Var4.f28241c));
                    this.f27352d.remove(wm0Var4);
                }
            }
        }
        spscLinkedArrayQueue.clear();
    }

    /* renamed from: g */
    public final void m7747g(Subscriber subscriber) {
        Throwable terminate = ExceptionHelper.terminate(this.f27355g);
        LinkedHashMap linkedHashMap = this.f27353e;
        Iterator it = linkedHashMap.values().iterator();
        while (it.hasNext()) {
            ((UnicastProcessor) it.next()).onError(terminate);
        }
        linkedHashMap.clear();
        this.f27354f.clear();
        subscriber.onError(terminate);
    }

    /* renamed from: h */
    public final void m7748h(Throwable th, Subscriber subscriber, SimpleQueue simpleQueue) {
        Exceptions.throwIfFatal(th);
        ExceptionHelper.addThrowable(this.f27355g, th);
        simpleQueue.clear();
        this.f27352d.dispose();
        m7747g(subscriber);
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this.f27350b, j);
        }
    }
}
