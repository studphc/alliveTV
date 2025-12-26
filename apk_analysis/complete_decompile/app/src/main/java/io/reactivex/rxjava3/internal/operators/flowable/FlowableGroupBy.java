package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.flowables.GroupedFlowable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.EmptyComponent;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p000.AbstractC1215g0;
import p000.tm0;

/* loaded from: classes2.dex */
public final class FlowableGroupBy<T, K, V> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Function f18883b;

    /* renamed from: c */
    public final Function f18884c;

    /* renamed from: d */
    public final int f18885d;

    /* renamed from: e */
    public final boolean f18886e;

    /* renamed from: f */
    public final Function f18887f;

    public FlowableGroupBy(Flowable<T> flowable, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i, boolean z, Function<? super Consumer<Object>, ? extends Map<K, Object>> function3) {
        super(flowable);
        this.f18883b = function;
        this.f18884c = function2;
        this.f18885d = i;
        this.f18886e = z;
        this.f18887f = function3;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super GroupedFlowable<K, V>> subscriber) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        Map map;
        Function function = this.f18887f;
        try {
            if (function == null) {
                map = new ConcurrentHashMap();
                concurrentLinkedQueue = null;
            } else {
                concurrentLinkedQueue = new ConcurrentLinkedQueue();
                map = (Map) function.apply(new tm0(0, concurrentLinkedQueue));
            }
            this.source.subscribe((FlowableSubscriber<? super Object>) new GroupBySubscriber(subscriber, this.f18883b, this.f18884c, this.f18885d, this.f18886e, map, concurrentLinkedQueue));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            subscriber.onSubscribe(EmptyComponent.INSTANCE);
            subscriber.onError(th);
        }
    }

    /* loaded from: classes2.dex */
    public static final class GroupBySubscriber<T, K, V> extends AtomicLong implements FlowableSubscriber<T>, Subscription {

        /* renamed from: o */
        public static final Object f18888o = new Object();
        private static final long serialVersionUID = -3688291656102519502L;

        /* renamed from: a */
        public final Subscriber f18889a;

        /* renamed from: b */
        public final Function f18890b;

        /* renamed from: c */
        public final Function f18891c;

        /* renamed from: d */
        public final int f18892d;

        /* renamed from: e */
        public final int f18893e;

        /* renamed from: f */
        public final boolean f18894f;

        /* renamed from: g */
        public final Map f18895g;

        /* renamed from: h */
        public final Queue f18896h;

        /* renamed from: i */
        public Subscription f18897i;

        /* renamed from: k */
        public long f18899k;

        /* renamed from: n */
        public boolean f18902n;

        /* renamed from: j */
        public final AtomicBoolean f18898j = new AtomicBoolean();

        /* renamed from: l */
        public final AtomicInteger f18900l = new AtomicInteger(1);

        /* renamed from: m */
        public final AtomicLong f18901m = new AtomicLong();

        public GroupBySubscriber(Subscriber<? super GroupedFlowable<K, V>> subscriber, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i, boolean z, Map<Object, C1317a> map, Queue<C1317a> queue) {
            this.f18889a = subscriber;
            this.f18890b = function;
            this.f18891c = function2;
            this.f18892d = i;
            this.f18893e = i - (i >> 2);
            this.f18894f = z;
            this.f18895g = map;
            this.f18896h = queue;
        }

        /* renamed from: a */
        public final void m5275a() {
            if (this.f18896h != null) {
                int i = 0;
                while (true) {
                    C1317a c1317a = (C1317a) this.f18896h.poll();
                    if (c1317a == null) {
                        break;
                    }
                    C1318b c1318b = c1317a.f19100c;
                    boolean compareAndSet = c1318b.f19112l.compareAndSet(false, true);
                    c1318b.f19106f = true;
                    c1318b.drain();
                    if (compareAndSet) {
                        i++;
                    }
                }
                if (i != 0) {
                    this.f18900l.addAndGet(-i);
                }
            }
        }

        /* renamed from: b */
        public final void m5276b(long j) {
            long j2;
            long addCap;
            AtomicLong atomicLong = this.f18901m;
            do {
                j2 = atomicLong.get();
                addCap = BackpressureHelper.addCap(j2, j);
            } while (!atomicLong.compareAndSet(j2, addCap));
            while (true) {
                long j3 = this.f18893e;
                if (addCap < j3) {
                    return;
                }
                if (atomicLong.compareAndSet(addCap, addCap - j3)) {
                    this.f18897i.request(j3);
                }
                addCap = atomicLong.get();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.f18898j.compareAndSet(false, true)) {
                m5275a();
                if (this.f18900l.decrementAndGet() == 0) {
                    this.f18897i.cancel();
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.f18902n) {
                Map map = this.f18895g;
                Iterator<V> it = map.values().iterator();
                while (it.hasNext()) {
                    C1318b c1318b = ((C1317a) it.next()).f19100c;
                    c1318b.f19106f = true;
                    c1318b.drain();
                }
                map.clear();
                m5275a();
                this.f18902n = true;
                this.f18889a.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f18902n) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.f18902n = true;
            Iterator<V> it = this.f18895g.values().iterator();
            while (it.hasNext()) {
                C1318b c1318b = ((C1317a) it.next()).f19100c;
                c1318b.f19107g = th;
                c1318b.f19106f = true;
                c1318b.drain();
            }
            this.f18895g.clear();
            m5275a();
            this.f18889a.onError(th);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            Object obj;
            boolean z;
            Subscriber subscriber = this.f18889a;
            if (this.f18902n) {
                return;
            }
            try {
                Object apply = this.f18890b.apply(t);
                if (apply != null) {
                    obj = apply;
                } else {
                    obj = f18888o;
                }
                Map map = this.f18895g;
                C1317a c1317a = (C1317a) map.get(obj);
                if (c1317a == null) {
                    if (this.f18898j.get()) {
                        return;
                    }
                    int i = C1317a.f19099d;
                    C1317a c1317a2 = new C1317a(apply, new C1318b(this.f18892d, this, apply, this.f18894f));
                    map.put(obj, c1317a2);
                    this.f18900l.getAndIncrement();
                    z = true;
                    c1317a = c1317a2;
                } else {
                    z = false;
                }
                try {
                    C1318b c1318b = c1317a.f19100c;
                    c1318b.f19102b.offer(ExceptionHelper.nullCheck(this.f18891c.apply(t), "The valueSelector returned a null value."));
                    c1318b.drain();
                    m5275a();
                    if (z) {
                        if (this.f18899k != get()) {
                            this.f18899k++;
                            subscriber.onNext(c1317a);
                            AtomicInteger atomicInteger = c1318b.f19111k;
                            if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 2)) {
                                cancel(apply);
                                C1318b c1318b2 = c1317a.f19100c;
                                c1318b2.f19106f = true;
                                c1318b2.drain();
                                m5276b(1L);
                                return;
                            }
                            return;
                        }
                        this.f18897i.cancel();
                        onError(new MissingBackpressureException("Unable to emit a new group (#" + this.f18899k + ") due to lack of requests. Please make sure the downstream can always accept a new group as well as each group is consumed in order for the whole operator to be able to proceed."));
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.f18897i.cancel();
                    if (z) {
                        if (this.f18899k != get()) {
                            subscriber.onNext(c1317a);
                        } else {
                            MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Unable to emit a new group (#" + this.f18899k + ") due to lack of requests. Please make sure the downstream can always accept a new group as well as each group is consumed in order for the whole operator to be able to proceed.");
                            missingBackpressureException.initCause(th);
                            onError(missingBackpressureException);
                            return;
                        }
                    }
                    onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f18897i.cancel();
                onError(th2);
            }
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f18897i, subscription)) {
                this.f18897i = subscription;
                this.f18889a.onSubscribe(this);
                subscription.request(this.f18892d);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this, j);
            }
        }

        public void cancel(K k) {
            if (k == null) {
                k = (K) f18888o;
            }
            if (this.f18895g.remove(k) == null || this.f18900l.decrementAndGet() != 0) {
                return;
            }
            this.f18897i.cancel();
        }
    }
}
