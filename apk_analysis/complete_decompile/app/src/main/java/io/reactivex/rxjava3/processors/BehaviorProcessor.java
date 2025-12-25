package io.reactivex.rxjava3.processors;

import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p000.C1157eg;

/* loaded from: classes2.dex */
public final class BehaviorProcessor<T> extends FlowableProcessor<T> {

    /* renamed from: h */
    public static final Object[] f20042h = new Object[0];

    /* renamed from: i */
    public static final C1157eg[] f20043i = new C1157eg[0];

    /* renamed from: j */
    public static final C1157eg[] f20044j = new C1157eg[0];

    /* renamed from: b */
    public final AtomicReference f20045b;

    /* renamed from: c */
    public final Lock f20046c;

    /* renamed from: d */
    public final Lock f20047d;

    /* renamed from: e */
    public final AtomicReference f20048e = new AtomicReference();

    /* renamed from: f */
    public final AtomicReference f20049f;

    /* renamed from: g */
    public long f20050g;

    public BehaviorProcessor() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f20046c = reentrantReadWriteLock.readLock();
        this.f20047d = reentrantReadWriteLock.writeLock();
        this.f20045b = new AtomicReference(f20043i);
        this.f20049f = new AtomicReference();
    }

    @CheckReturnValue
    @NonNull
    public static <T> BehaviorProcessor<T> create() {
        return new BehaviorProcessor<>();
    }

    @CheckReturnValue
    @NonNull
    public static <T> BehaviorProcessor<T> createDefault(T t) {
        Objects.requireNonNull(t, "defaultValue is null");
        BehaviorProcessor<T> behaviorProcessor = new BehaviorProcessor<>();
        behaviorProcessor.f20048e.lazySet(t);
        return behaviorProcessor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: e */
    public final void m5310e(C1157eg c1157eg) {
        C1157eg[] c1157egArr;
        while (true) {
            AtomicReference atomicReference = this.f20045b;
            C1157eg[] c1157egArr2 = (C1157eg[]) atomicReference.get();
            int length = c1157egArr2.length;
            if (length == 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i < length) {
                    if (c1157egArr2[i] == c1157eg) {
                        break;
                    } else {
                        i++;
                    }
                } else {
                    i = -1;
                    break;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                c1157egArr = f20043i;
            } else {
                C1157eg[] c1157egArr3 = new C1157eg[length - 1];
                System.arraycopy(c1157egArr2, 0, c1157egArr3, 0, i);
                System.arraycopy(c1157egArr2, i + 1, c1157egArr3, i, (length - i) - 1);
                c1157egArr = c1157egArr3;
            }
            while (!atomicReference.compareAndSet(c1157egArr2, c1157egArr)) {
                if (atomicReference.get() != c1157egArr2) {
                    break;
                }
            }
            return;
        }
    }

    /* renamed from: f */
    public final void m5311f(Object obj) {
        Lock lock = this.f20047d;
        lock.lock();
        this.f20050g++;
        this.f20048e.lazySet(obj);
        lock.unlock();
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    @Nullable
    public Throwable getThrowable() {
        Object obj = this.f20048e.get();
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    @CheckReturnValue
    @Nullable
    public T getValue() {
        Object obj = this.f20048e.get();
        if (!NotificationLite.isComplete(obj) && !NotificationLite.isError(obj)) {
            return (T) NotificationLite.getValue(obj);
        }
        return null;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasComplete() {
        return NotificationLite.isComplete(this.f20048e.get());
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasSubscribers() {
        if (((C1157eg[]) this.f20045b.get()).length != 0) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasThrowable() {
        return NotificationLite.isError(this.f20048e.get());
    }

    @CheckReturnValue
    public boolean hasValue() {
        Object obj = this.f20048e.get();
        if (obj != null && !NotificationLite.isComplete(obj) && !NotificationLite.isError(obj)) {
            return true;
        }
        return false;
    }

    @CheckReturnValue
    public boolean offer(@NonNull T t) {
        ExceptionHelper.nullCheck(t, "offer called with a null value.");
        C1157eg[] c1157egArr = (C1157eg[]) this.f20045b.get();
        for (C1157eg c1157eg : c1157egArr) {
            if (c1157eg.get() == 0) {
                return false;
            }
        }
        Object next = NotificationLite.next(t);
        m5311f(next);
        for (C1157eg c1157eg2 : c1157egArr) {
            c1157eg2.m4719b(next, this.f20050g);
        }
        return true;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        AtomicReference atomicReference = this.f20049f;
        Throwable th = ExceptionHelper.TERMINATED;
        while (!atomicReference.compareAndSet(null, th)) {
            if (atomicReference.get() != null) {
                return;
            }
        }
        Object complete = NotificationLite.complete();
        m5311f(complete);
        for (C1157eg c1157eg : (C1157eg[]) this.f20045b.getAndSet(f20044j)) {
            c1157eg.m4719b(complete, this.f20050g);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(@NonNull Throwable th) {
        ExceptionHelper.nullCheck(th, "onError called with a null Throwable.");
        AtomicReference atomicReference = this.f20049f;
        while (!atomicReference.compareAndSet(null, th)) {
            if (atomicReference.get() != null) {
                RxJavaPlugins.onError(th);
                return;
            }
        }
        Object error = NotificationLite.error(th);
        m5311f(error);
        for (C1157eg c1157eg : (C1157eg[]) this.f20045b.getAndSet(f20044j)) {
            c1157eg.m4719b(error, this.f20050g);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(@NonNull T t) {
        ExceptionHelper.nullCheck(t, "onNext called with a null value.");
        if (this.f20049f.get() != null) {
            return;
        }
        Object next = NotificationLite.next(t);
        m5311f(next);
        for (C1157eg c1157eg : (C1157eg[]) this.f20045b.get()) {
            c1157eg.m4719b(next, this.f20050g);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(@NonNull Subscription subscription) {
        if (this.f20049f.get() != null) {
            subscription.cancel();
        } else {
            subscription.request(Long.MAX_VALUE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(@NonNull Subscriber<? super T> subscriber) {
        C1157eg c1157eg = new C1157eg(subscriber, this);
        subscriber.onSubscribe(c1157eg);
        while (true) {
            AtomicReference atomicReference = this.f20045b;
            C1157eg[] c1157egArr = (C1157eg[]) atomicReference.get();
            if (c1157egArr == f20044j) {
                Throwable th = (Throwable) this.f20049f.get();
                if (th == ExceptionHelper.TERMINATED) {
                    subscriber.onComplete();
                    return;
                } else {
                    subscriber.onError(th);
                    return;
                }
            }
            int length = c1157egArr.length;
            C1157eg[] c1157egArr2 = new C1157eg[length + 1];
            boolean z = false;
            System.arraycopy(c1157egArr, 0, c1157egArr2, 0, length);
            c1157egArr2[length] = c1157eg;
            while (!atomicReference.compareAndSet(c1157egArr, c1157egArr2)) {
                if (atomicReference.get() != c1157egArr) {
                    break;
                }
            }
            if (c1157eg.f16806g) {
                m5310e(c1157eg);
                return;
            }
            if (!c1157eg.f16806g) {
                synchronized (c1157eg) {
                    try {
                        if (!c1157eg.f16806g) {
                            if (!c1157eg.f16802c) {
                                BehaviorProcessor behaviorProcessor = c1157eg.f16801b;
                                Lock lock = behaviorProcessor.f20046c;
                                lock.lock();
                                c1157eg.f16807h = behaviorProcessor.f20050g;
                                Object obj = behaviorProcessor.f20048e.get();
                                lock.unlock();
                                if (obj != null) {
                                    z = true;
                                }
                                c1157eg.f16803d = z;
                                c1157eg.f16802c = true;
                                if (obj != null && !c1157eg.test(obj)) {
                                    c1157eg.m4718a();
                                }
                            }
                        }
                    } finally {
                    }
                }
                return;
            }
            return;
        }
    }
}
