package io.reactivex.rxjava3.processors;

import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p000.c03;

/* loaded from: classes2.dex */
public final class UnicastProcessor<T> extends FlowableProcessor<T> {

    /* renamed from: b */
    public final SpscLinkedArrayQueue f20074b;

    /* renamed from: c */
    public final AtomicReference f20075c;

    /* renamed from: d */
    public final boolean f20076d;

    /* renamed from: e */
    public volatile boolean f20077e;

    /* renamed from: f */
    public Throwable f20078f;

    /* renamed from: h */
    public volatile boolean f20080h;

    /* renamed from: l */
    public boolean f20084l;

    /* renamed from: g */
    public final AtomicReference f20079g = new AtomicReference();

    /* renamed from: i */
    public final AtomicBoolean f20081i = new AtomicBoolean();

    /* renamed from: j */
    public final c03 f20082j = new c03(this);

    /* renamed from: k */
    public final AtomicLong f20083k = new AtomicLong();

    public UnicastProcessor(int i, Runnable runnable, boolean z) {
        this.f20074b = new SpscLinkedArrayQueue(i);
        this.f20075c = new AtomicReference(runnable);
        this.f20076d = z;
    }

    @CheckReturnValue
    @NonNull
    public static <T> UnicastProcessor<T> create() {
        return new UnicastProcessor<>(Flowable.bufferSize(), null, true);
    }

    /* renamed from: e */
    public final boolean m5316e(boolean z, boolean z2, boolean z3, Subscriber subscriber, SpscLinkedArrayQueue spscLinkedArrayQueue) {
        if (this.f20080h) {
            spscLinkedArrayQueue.clear();
            this.f20079g.lazySet(null);
            return true;
        }
        if (z2) {
            if (z && this.f20078f != null) {
                spscLinkedArrayQueue.clear();
                this.f20079g.lazySet(null);
                subscriber.onError(this.f20078f);
                return true;
            }
            if (z3) {
                Throwable th = this.f20078f;
                this.f20079g.lazySet(null);
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: f */
    public final void m5317f() {
        long j;
        int i;
        if (this.f20082j.getAndIncrement() != 0) {
            return;
        }
        int i2 = 1;
        Subscriber subscriber = (Subscriber) this.f20079g.get();
        int i3 = 1;
        while (subscriber == 0) {
            i3 = this.f20082j.addAndGet(-i3);
            if (i3 == 0) {
                return;
            }
            i2 = 1;
            subscriber = (Subscriber) this.f20079g.get();
        }
        if (this.f20084l) {
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f20074b;
            boolean z = this.f20076d;
            while (!this.f20080h) {
                boolean z2 = this.f20077e;
                if (!z && z2 && this.f20078f != null) {
                    spscLinkedArrayQueue.clear();
                    this.f20079g.lazySet(null);
                    subscriber.onError(this.f20078f);
                    return;
                }
                subscriber.onNext(null);
                if (z2) {
                    this.f20079g.lazySet(null);
                    Throwable th = this.f20078f;
                    if (th != null) {
                        subscriber.onError(th);
                        return;
                    } else {
                        subscriber.onComplete();
                        return;
                    }
                }
                i2 = this.f20082j.addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
            this.f20079g.lazySet(null);
            return;
        }
        SpscLinkedArrayQueue spscLinkedArrayQueue2 = this.f20074b;
        boolean z3 = !this.f20076d;
        int i4 = i2;
        while (true) {
            long j2 = this.f20083k.get();
            long j3 = 0;
            while (true) {
                if (j2 != j3) {
                    boolean z4 = this.f20077e;
                    Object poll = spscLinkedArrayQueue2.poll();
                    if (poll == null) {
                        i = i2;
                    } else {
                        i = 0;
                    }
                    j = j3;
                    if (!m5316e(z3, z4, i, subscriber, spscLinkedArrayQueue2)) {
                        if (i != 0) {
                            break;
                        }
                        subscriber.onNext(poll);
                        j3 = j + 1;
                        i2 = 1;
                    } else {
                        return;
                    }
                } else {
                    j = j3;
                    break;
                }
            }
            if (j2 != j3 || !m5316e(z3, this.f20077e, spscLinkedArrayQueue2.isEmpty(), subscriber, spscLinkedArrayQueue2)) {
                if (j != 0 && j2 != Long.MAX_VALUE) {
                    this.f20083k.addAndGet(-j);
                }
                i4 = this.f20082j.addAndGet(-i4);
                if (i4 == 0) {
                    return;
                } else {
                    i2 = 1;
                }
            } else {
                return;
            }
        }
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    @Nullable
    public Throwable getThrowable() {
        if (this.f20077e) {
            return this.f20078f;
        }
        return null;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasComplete() {
        if (this.f20077e && this.f20078f == null) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasSubscribers() {
        if (this.f20079g.get() != null) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasThrowable() {
        if (this.f20077e && this.f20078f != null) {
            return true;
        }
        return false;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (!this.f20077e && !this.f20080h) {
            this.f20077e = true;
            Runnable runnable = (Runnable) this.f20075c.getAndSet(null);
            if (runnable != null) {
                runnable.run();
            }
            m5317f();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        ExceptionHelper.nullCheck(th, "onError called with a null Throwable.");
        if (!this.f20077e && !this.f20080h) {
            this.f20078f = th;
            this.f20077e = true;
            Runnable runnable = (Runnable) this.f20075c.getAndSet(null);
            if (runnable != null) {
                runnable.run();
            }
            m5317f();
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        ExceptionHelper.nullCheck(t, "onNext called with a null value.");
        if (!this.f20077e && !this.f20080h) {
            this.f20074b.offer(t);
            m5317f();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (!this.f20077e && !this.f20080h) {
            subscription.request(Long.MAX_VALUE);
        } else {
            subscription.cancel();
        }
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (!this.f20081i.get() && this.f20081i.compareAndSet(false, true)) {
            subscriber.onSubscribe(this.f20082j);
            this.f20079g.set(subscriber);
            if (this.f20080h) {
                this.f20079g.lazySet(null);
                return;
            } else {
                m5317f();
                return;
            }
        }
        EmptySubscription.error(new IllegalStateException("This processor allows only a single Subscriber"), subscriber);
    }

    @CheckReturnValue
    @NonNull
    public static <T> UnicastProcessor<T> create(int i) {
        ObjectHelper.verifyPositive(i, "capacityHint");
        return new UnicastProcessor<>(i, null, true);
    }

    @CheckReturnValue
    @NonNull
    public static <T> UnicastProcessor<T> create(boolean z) {
        return new UnicastProcessor<>(Flowable.bufferSize(), null, z);
    }

    @CheckReturnValue
    @NonNull
    public static <T> UnicastProcessor<T> create(int i, @NonNull Runnable runnable) {
        return create(i, runnable, true);
    }

    @CheckReturnValue
    @NonNull
    public static <T> UnicastProcessor<T> create(int i, @NonNull Runnable runnable, boolean z) {
        Objects.requireNonNull(runnable, "onTerminate");
        ObjectHelper.verifyPositive(i, "capacityHint");
        return new UnicastProcessor<>(i, runnable, z);
    }
}
