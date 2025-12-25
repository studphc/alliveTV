package io.reactivex.rxjava3.subjects;

import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p000.ab2;
import p000.bb2;
import p000.cb2;
import p000.eb2;
import p000.za2;

/* loaded from: classes2.dex */
public final class ReplaySubject<T> extends Subject<T> {

    /* renamed from: d */
    public static final ab2[] f20125d = new ab2[0];

    /* renamed from: e */
    public static final ab2[] f20126e = new ab2[0];

    /* renamed from: f */
    public static final Object[] f20127f = new Object[0];

    /* renamed from: a */
    public final AtomicReference f20128a;

    /* renamed from: b */
    public final AtomicReference f20129b = new AtomicReference(f20125d);

    /* renamed from: c */
    public boolean f20130c;

    /* JADX WARN: Multi-variable type inference failed */
    public ReplaySubject(za2 za2Var) {
        this.f20128a = (AtomicReference) za2Var;
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplaySubject<T> create() {
        return new ReplaySubject<>(new eb2(16));
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplaySubject<T> createWithSize(int i) {
        ObjectHelper.verifyPositive(i, "maxSize");
        return new ReplaySubject<>(new cb2(i));
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplaySubject<T> createWithTime(long j, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        ObjectHelper.verifyPositive(j, "maxAge");
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return new ReplaySubject<>(new bb2(Integer.MAX_VALUE, j, timeUnit, scheduler));
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplaySubject<T> createWithTimeAndSize(long j, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, int i) {
        ObjectHelper.verifyPositive(i, "maxSize");
        ObjectHelper.verifyPositive(j, "maxAge");
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return new ReplaySubject<>(new bb2(i, j, timeUnit, scheduler));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [za2, java.util.concurrent.atomic.AtomicReference] */
    public void cleanupBuffer() {
        this.f20128a.mo2077c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d */
    public final void m5325d(ab2 ab2Var) {
        ab2[] ab2VarArr;
        while (true) {
            AtomicReference atomicReference = this.f20129b;
            ab2[] ab2VarArr2 = (ab2[]) atomicReference.get();
            if (ab2VarArr2 != f20126e && ab2VarArr2 != (ab2VarArr = f20125d)) {
                int length = ab2VarArr2.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        if (ab2VarArr2[i] == ab2Var) {
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
                if (length != 1) {
                    ab2VarArr = new ab2[length - 1];
                    System.arraycopy(ab2VarArr2, 0, ab2VarArr, 0, i);
                    System.arraycopy(ab2VarArr2, i + 1, ab2VarArr, i, (length - i) - 1);
                }
                while (!atomicReference.compareAndSet(ab2VarArr2, ab2VarArr)) {
                    if (atomicReference.get() != ab2VarArr2) {
                        break;
                    }
                }
                return;
            }
            return;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [za2, java.util.concurrent.atomic.AtomicReference] */
    @Override // io.reactivex.rxjava3.subjects.Subject
    @CheckReturnValue
    @Nullable
    public Throwable getThrowable() {
        Object obj = this.f20128a.get();
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [za2, java.util.concurrent.atomic.AtomicReference] */
    @CheckReturnValue
    @Nullable
    public T getValue() {
        return (T) this.f20128a.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckReturnValue
    public Object[] getValues() {
        Object[] objArr = f20127f;
        Object[] values = getValues(objArr);
        return values == objArr ? new Object[0] : values;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [za2, java.util.concurrent.atomic.AtomicReference] */
    @Override // io.reactivex.rxjava3.subjects.Subject
    @CheckReturnValue
    public boolean hasComplete() {
        return NotificationLite.isComplete(this.f20128a.get());
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    @CheckReturnValue
    public boolean hasObservers() {
        if (((ab2[]) this.f20129b.get()).length != 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [za2, java.util.concurrent.atomic.AtomicReference] */
    @Override // io.reactivex.rxjava3.subjects.Subject
    @CheckReturnValue
    public boolean hasThrowable() {
        return NotificationLite.isError(this.f20128a.get());
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [za2, java.util.concurrent.atomic.AtomicReference] */
    @CheckReturnValue
    public boolean hasValue() {
        if (this.f20128a.size() != 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [za2, java.util.concurrent.atomic.AtomicReference] */
    @Override // io.reactivex.rxjava3.core.Observer
    public void onComplete() {
        if (this.f20130c) {
            return;
        }
        this.f20130c = true;
        Object complete = NotificationLite.complete();
        ?? r1 = this.f20128a;
        r1.mo2075a(complete);
        r1.compareAndSet(null, complete);
        for (ab2 ab2Var : (ab2[]) this.f20129b.getAndSet(f20126e)) {
            r1.mo2076b(ab2Var);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [za2, java.util.concurrent.atomic.AtomicReference] */
    @Override // io.reactivex.rxjava3.core.Observer
    public void onError(Throwable th) {
        ExceptionHelper.nullCheck(th, "onError called with a null Throwable.");
        if (this.f20130c) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f20130c = true;
        Object error = NotificationLite.error(th);
        ?? r0 = this.f20128a;
        r0.mo2075a(error);
        r0.compareAndSet(null, error);
        for (ab2 ab2Var : (ab2[]) this.f20129b.getAndSet(f20126e)) {
            r0.mo2076b(ab2Var);
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [za2, java.util.concurrent.atomic.AtomicReference] */
    @Override // io.reactivex.rxjava3.core.Observer
    public void onNext(T t) {
        ExceptionHelper.nullCheck(t, "onNext called with a null value.");
        if (this.f20130c) {
            return;
        }
        ?? r0 = this.f20128a;
        r0.add(t);
        for (ab2 ab2Var : (ab2[]) this.f20129b.get()) {
            r0.mo2076b(ab2Var);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onSubscribe(Disposable disposable) {
        if (this.f20130c) {
            disposable.dispose();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [za2, java.util.concurrent.atomic.AtomicReference] */
    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        ab2 ab2Var = new ab2(observer, this);
        observer.onSubscribe(ab2Var);
        while (true) {
            AtomicReference atomicReference = this.f20129b;
            ab2[] ab2VarArr = (ab2[]) atomicReference.get();
            if (ab2VarArr == f20126e) {
                break;
            }
            int length = ab2VarArr.length;
            ab2[] ab2VarArr2 = new ab2[length + 1];
            System.arraycopy(ab2VarArr, 0, ab2VarArr2, 0, length);
            ab2VarArr2[length] = ab2Var;
            while (!atomicReference.compareAndSet(ab2VarArr, ab2VarArr2)) {
                if (atomicReference.get() != ab2VarArr) {
                    break;
                }
            }
            if (ab2Var.f113d) {
                m5325d(ab2Var);
                return;
            }
        }
        this.f20128a.mo2076b(ab2Var);
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplaySubject<T> create(int i) {
        ObjectHelper.verifyPositive(i, "capacityHint");
        return new ReplaySubject<>(new eb2(i));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [za2, java.util.concurrent.atomic.AtomicReference] */
    @CheckReturnValue
    public T[] getValues(T[] tArr) {
        return (T[]) this.f20128a.mo2078d(tArr);
    }
}
