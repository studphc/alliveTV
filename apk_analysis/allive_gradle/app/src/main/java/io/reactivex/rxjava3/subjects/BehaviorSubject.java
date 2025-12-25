package io.reactivex.rxjava3.subjects;

import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import p000.C1194fg;

/* loaded from: classes2.dex */
public final class BehaviorSubject<T> extends Subject<T> {

    /* renamed from: g */
    public static final C1194fg[] f20102g = new C1194fg[0];

    /* renamed from: h */
    public static final C1194fg[] f20103h = new C1194fg[0];

    /* renamed from: a */
    public final AtomicReference f20104a;

    /* renamed from: b */
    public final AtomicReference f20105b;

    /* renamed from: c */
    public final Lock f20106c;

    /* renamed from: d */
    public final Lock f20107d;

    /* renamed from: e */
    public final AtomicReference f20108e;

    /* renamed from: f */
    public long f20109f;

    public BehaviorSubject(Object obj) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f20106c = reentrantReadWriteLock.readLock();
        this.f20107d = reentrantReadWriteLock.writeLock();
        this.f20105b = new AtomicReference(f20102g);
        this.f20104a = new AtomicReference(obj);
        this.f20108e = new AtomicReference();
    }

    @CheckReturnValue
    @NonNull
    public static <T> BehaviorSubject<T> create() {
        return new BehaviorSubject<>(null);
    }

    @CheckReturnValue
    @NonNull
    public static <T> BehaviorSubject<T> createDefault(T t) {
        Objects.requireNonNull(t, "defaultValue is null");
        return new BehaviorSubject<>(t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d */
    public final void m5321d(C1194fg c1194fg) {
        C1194fg[] c1194fgArr;
        while (true) {
            AtomicReference atomicReference = this.f20105b;
            C1194fg[] c1194fgArr2 = (C1194fg[]) atomicReference.get();
            int length = c1194fgArr2.length;
            if (length == 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i < length) {
                    if (c1194fgArr2[i] == c1194fg) {
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
                c1194fgArr = f20102g;
            } else {
                C1194fg[] c1194fgArr3 = new C1194fg[length - 1];
                System.arraycopy(c1194fgArr2, 0, c1194fgArr3, 0, i);
                System.arraycopy(c1194fgArr2, i + 1, c1194fgArr3, i, (length - i) - 1);
                c1194fgArr = c1194fgArr3;
            }
            while (!atomicReference.compareAndSet(c1194fgArr2, c1194fgArr)) {
                if (atomicReference.get() != c1194fgArr2) {
                    break;
                }
            }
            return;
        }
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    @CheckReturnValue
    @Nullable
    public Throwable getThrowable() {
        Object obj = this.f20104a.get();
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    @CheckReturnValue
    @Nullable
    public T getValue() {
        Object obj = this.f20104a.get();
        if (!NotificationLite.isComplete(obj) && !NotificationLite.isError(obj)) {
            return (T) NotificationLite.getValue(obj);
        }
        return null;
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    @CheckReturnValue
    public boolean hasComplete() {
        return NotificationLite.isComplete(this.f20104a.get());
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    @CheckReturnValue
    public boolean hasObservers() {
        if (((C1194fg[]) this.f20105b.get()).length != 0) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    @CheckReturnValue
    public boolean hasThrowable() {
        return NotificationLite.isError(this.f20104a.get());
    }

    @CheckReturnValue
    public boolean hasValue() {
        Object obj = this.f20104a.get();
        if (obj != null && !NotificationLite.isComplete(obj) && !NotificationLite.isError(obj)) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onComplete() {
        AtomicReference atomicReference = this.f20108e;
        Throwable th = ExceptionHelper.TERMINATED;
        while (!atomicReference.compareAndSet(null, th)) {
            if (atomicReference.get() != null) {
                return;
            }
        }
        Object complete = NotificationLite.complete();
        Lock lock = this.f20107d;
        lock.lock();
        this.f20109f++;
        this.f20104a.lazySet(complete);
        lock.unlock();
        for (C1194fg c1194fg : (C1194fg[]) this.f20105b.getAndSet(f20103h)) {
            c1194fg.m4808b(complete, this.f20109f);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onError(Throwable th) {
        ExceptionHelper.nullCheck(th, "onError called with a null Throwable.");
        AtomicReference atomicReference = this.f20108e;
        while (!atomicReference.compareAndSet(null, th)) {
            if (atomicReference.get() != null) {
                RxJavaPlugins.onError(th);
                return;
            }
        }
        Object error = NotificationLite.error(th);
        Lock lock = this.f20107d;
        lock.lock();
        this.f20109f++;
        this.f20104a.lazySet(error);
        lock.unlock();
        for (C1194fg c1194fg : (C1194fg[]) this.f20105b.getAndSet(f20103h)) {
            c1194fg.m4808b(error, this.f20109f);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onNext(T t) {
        ExceptionHelper.nullCheck(t, "onNext called with a null value.");
        if (this.f20108e.get() != null) {
            return;
        }
        Object next = NotificationLite.next(t);
        Lock lock = this.f20107d;
        lock.lock();
        this.f20109f++;
        this.f20104a.lazySet(next);
        lock.unlock();
        for (C1194fg c1194fg : (C1194fg[]) this.f20105b.get()) {
            c1194fg.m4808b(next, this.f20109f);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onSubscribe(Disposable disposable) {
        if (this.f20108e.get() != null) {
            disposable.dispose();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        C1194fg c1194fg = new C1194fg(observer, this);
        observer.onSubscribe(c1194fg);
        while (true) {
            AtomicReference atomicReference = this.f20105b;
            C1194fg[] c1194fgArr = (C1194fg[]) atomicReference.get();
            if (c1194fgArr == f20103h) {
                Throwable th = (Throwable) this.f20108e.get();
                if (th == ExceptionHelper.TERMINATED) {
                    observer.onComplete();
                    return;
                } else {
                    observer.onError(th);
                    return;
                }
            }
            int length = c1194fgArr.length;
            C1194fg[] c1194fgArr2 = new C1194fg[length + 1];
            boolean z = false;
            System.arraycopy(c1194fgArr, 0, c1194fgArr2, 0, length);
            c1194fgArr2[length] = c1194fg;
            while (!atomicReference.compareAndSet(c1194fgArr, c1194fgArr2)) {
                if (atomicReference.get() != c1194fgArr) {
                    break;
                }
            }
            if (c1194fg.f17253g) {
                m5321d(c1194fg);
                return;
            }
            if (!c1194fg.f17253g) {
                synchronized (c1194fg) {
                    try {
                        if (!c1194fg.f17253g) {
                            if (!c1194fg.f17249c) {
                                BehaviorSubject behaviorSubject = c1194fg.f17248b;
                                Lock lock = behaviorSubject.f20106c;
                                lock.lock();
                                c1194fg.f17254h = behaviorSubject.f20109f;
                                Object obj = behaviorSubject.f20104a.get();
                                lock.unlock();
                                if (obj != null) {
                                    z = true;
                                }
                                c1194fg.f17250d = z;
                                c1194fg.f17249c = true;
                                if (obj != null && !c1194fg.test(obj)) {
                                    c1194fg.m4807a();
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
