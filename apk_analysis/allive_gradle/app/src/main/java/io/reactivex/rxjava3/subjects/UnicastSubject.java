package io.reactivex.rxjava3.subjects;

import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p000.d03;

/* loaded from: classes2.dex */
public final class UnicastSubject<T> extends Subject<T> {

    /* renamed from: a */
    public final SpscLinkedArrayQueue f20137a;

    /* renamed from: c */
    public final AtomicReference f20139c;

    /* renamed from: d */
    public final boolean f20140d;

    /* renamed from: e */
    public volatile boolean f20141e;

    /* renamed from: f */
    public volatile boolean f20142f;

    /* renamed from: g */
    public Throwable f20143g;

    /* renamed from: j */
    public boolean f20146j;

    /* renamed from: b */
    public final AtomicReference f20138b = new AtomicReference();

    /* renamed from: h */
    public final AtomicBoolean f20144h = new AtomicBoolean();

    /* renamed from: i */
    public final d03 f20145i = new d03(this);

    public UnicastSubject(int i, Runnable runnable, boolean z) {
        this.f20137a = new SpscLinkedArrayQueue(i);
        this.f20139c = new AtomicReference(runnable);
        this.f20140d = z;
    }

    @CheckReturnValue
    @NonNull
    public static <T> UnicastSubject<T> create() {
        return new UnicastSubject<>(Observable.bufferSize(), null, true);
    }

    /* renamed from: d */
    public final void m5327d() {
        AtomicReference atomicReference = this.f20139c;
        Runnable runnable = (Runnable) atomicReference.get();
        if (runnable == null) {
            return;
        }
        while (!atomicReference.compareAndSet(runnable, null)) {
            if (atomicReference.get() != runnable) {
                return;
            }
        }
        runnable.run();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: e */
    public final void m5328e() {
        boolean z;
        Throwable th;
        if (this.f20145i.getAndIncrement() != 0) {
            return;
        }
        int i = 1;
        int i2 = 1;
        Observer observer = (Observer) this.f20138b.get();
        while (observer == 0) {
            i2 = this.f20145i.addAndGet(-i2);
            if (i2 == 0) {
                return;
            } else {
                observer = (Observer) this.f20138b.get();
            }
        }
        if (this.f20146j) {
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f20137a;
            boolean z2 = this.f20140d;
            while (!this.f20141e) {
                boolean z3 = this.f20142f;
                if (!z2 && z3 && (th = this.f20143g) != null) {
                    this.f20138b.lazySet(null);
                    spscLinkedArrayQueue.clear();
                    observer.onError(th);
                    return;
                }
                observer.onNext(null);
                if (z3) {
                    this.f20138b.lazySet(null);
                    Throwable th2 = this.f20143g;
                    if (th2 != null) {
                        observer.onError(th2);
                        return;
                    } else {
                        observer.onComplete();
                        return;
                    }
                }
                i = this.f20145i.addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
            this.f20138b.lazySet(null);
            return;
        }
        SpscLinkedArrayQueue spscLinkedArrayQueue2 = this.f20137a;
        boolean z4 = this.f20140d;
        boolean z5 = true;
        int i3 = 1;
        while (!this.f20141e) {
            boolean z6 = this.f20142f;
            Object poll = this.f20137a.poll();
            if (poll == null) {
                z = true;
            } else {
                z = false;
            }
            if (z6) {
                if (!z4 && z5) {
                    Throwable th3 = this.f20143g;
                    if (th3 != null) {
                        this.f20138b.lazySet(null);
                        spscLinkedArrayQueue2.clear();
                        observer.onError(th3);
                        return;
                    }
                    z5 = false;
                }
                if (z) {
                    this.f20138b.lazySet(null);
                    Throwable th4 = this.f20143g;
                    if (th4 != null) {
                        observer.onError(th4);
                        return;
                    } else {
                        observer.onComplete();
                        return;
                    }
                }
            }
            if (z) {
                i3 = this.f20145i.addAndGet(-i3);
                if (i3 == 0) {
                    return;
                }
            } else {
                observer.onNext(poll);
            }
        }
        this.f20138b.lazySet(null);
        spscLinkedArrayQueue2.clear();
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    @CheckReturnValue
    @Nullable
    public Throwable getThrowable() {
        if (this.f20142f) {
            return this.f20143g;
        }
        return null;
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    @CheckReturnValue
    public boolean hasComplete() {
        if (this.f20142f && this.f20143g == null) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    @CheckReturnValue
    public boolean hasObservers() {
        if (this.f20138b.get() != null) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    @CheckReturnValue
    public boolean hasThrowable() {
        if (this.f20142f && this.f20143g != null) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onComplete() {
        if (!this.f20142f && !this.f20141e) {
            this.f20142f = true;
            m5327d();
            m5328e();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onError(Throwable th) {
        ExceptionHelper.nullCheck(th, "onError called with a null Throwable.");
        if (!this.f20142f && !this.f20141e) {
            this.f20143g = th;
            this.f20142f = true;
            m5327d();
            m5328e();
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onNext(T t) {
        ExceptionHelper.nullCheck(t, "onNext called with a null value.");
        if (!this.f20142f && !this.f20141e) {
            this.f20137a.offer(t);
            m5328e();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onSubscribe(Disposable disposable) {
        if (this.f20142f || this.f20141e) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        if (!this.f20144h.get() && this.f20144h.compareAndSet(false, true)) {
            observer.onSubscribe(this.f20145i);
            this.f20138b.lazySet(observer);
            if (this.f20141e) {
                this.f20138b.lazySet(null);
                return;
            } else {
                m5328e();
                return;
            }
        }
        EmptyDisposable.error(new IllegalStateException("Only a single observer allowed."), observer);
    }

    @CheckReturnValue
    @NonNull
    public static <T> UnicastSubject<T> create(int i) {
        ObjectHelper.verifyPositive(i, "capacityHint");
        return new UnicastSubject<>(i, null, true);
    }

    @CheckReturnValue
    @NonNull
    public static <T> UnicastSubject<T> create(int i, @NonNull Runnable runnable) {
        ObjectHelper.verifyPositive(i, "capacityHint");
        Objects.requireNonNull(runnable, "onTerminate");
        return new UnicastSubject<>(i, runnable, true);
    }

    @CheckReturnValue
    @NonNull
    public static <T> UnicastSubject<T> create(int i, @NonNull Runnable runnable, boolean z) {
        ObjectHelper.verifyPositive(i, "capacityHint");
        Objects.requireNonNull(runnable, "onTerminate");
        return new UnicastSubject<>(i, runnable, z);
    }

    @CheckReturnValue
    @NonNull
    public static <T> UnicastSubject<T> create(boolean z) {
        return new UnicastSubject<>(Observable.bufferSize(), null, z);
    }
}
