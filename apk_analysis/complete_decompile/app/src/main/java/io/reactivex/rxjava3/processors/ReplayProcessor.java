package io.reactivex.rxjava3.processors;

import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p000.sa2;
import p000.ta2;
import p000.ua2;
import p000.va2;
import p000.xa2;

/* loaded from: classes2.dex */
public final class ReplayProcessor<T> extends FlowableProcessor<T> {

    /* renamed from: e */
    public static final Object[] f20068e = new Object[0];

    /* renamed from: f */
    public static final ta2[] f20069f = new ta2[0];

    /* renamed from: g */
    public static final ta2[] f20070g = new ta2[0];

    /* renamed from: b */
    public final sa2 f20071b;

    /* renamed from: c */
    public boolean f20072c;

    /* renamed from: d */
    public final AtomicReference f20073d = new AtomicReference(f20069f);

    public ReplayProcessor(sa2 sa2Var) {
        this.f20071b = sa2Var;
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplayProcessor<T> create() {
        return new ReplayProcessor<>(new xa2(16));
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplayProcessor<T> createWithSize(int i) {
        ObjectHelper.verifyPositive(i, "maxSize");
        return new ReplayProcessor<>(new va2(i));
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplayProcessor<T> createWithTime(long j, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        ObjectHelper.verifyPositive(j, "maxAge");
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return new ReplayProcessor<>(new ua2(Integer.MAX_VALUE, j, timeUnit, scheduler));
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplayProcessor<T> createWithTimeAndSize(long j, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, int i) {
        ObjectHelper.verifyPositive(i, "maxSize");
        ObjectHelper.verifyPositive(j, "maxAge");
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return new ReplayProcessor<>(new ua2(i, j, timeUnit, scheduler));
    }

    public void cleanupBuffer() {
        this.f20071b.mo7351c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: e */
    public final void m5315e(ta2 ta2Var) {
        ta2[] ta2VarArr;
        while (true) {
            AtomicReference atomicReference = this.f20073d;
            ta2[] ta2VarArr2 = (ta2[]) atomicReference.get();
            if (ta2VarArr2 != f20070g && ta2VarArr2 != (ta2VarArr = f20069f)) {
                int length = ta2VarArr2.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        if (ta2VarArr2[i] == ta2Var) {
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
                    ta2VarArr = new ta2[length - 1];
                    System.arraycopy(ta2VarArr2, 0, ta2VarArr, 0, i);
                    System.arraycopy(ta2VarArr2, i + 1, ta2VarArr, i, (length - i) - 1);
                }
                while (!atomicReference.compareAndSet(ta2VarArr2, ta2VarArr)) {
                    if (atomicReference.get() != ta2VarArr2) {
                        break;
                    }
                }
                return;
            }
            return;
        }
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    @Nullable
    public Throwable getThrowable() {
        sa2 sa2Var = this.f20071b;
        if (sa2Var.isDone()) {
            return sa2Var.getError();
        }
        return null;
    }

    @CheckReturnValue
    public T getValue() {
        return (T) this.f20071b.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckReturnValue
    public Object[] getValues() {
        Object[] objArr = f20068e;
        Object[] values = getValues(objArr);
        return values == objArr ? new Object[0] : values;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasComplete() {
        sa2 sa2Var = this.f20071b;
        if (sa2Var.isDone() && sa2Var.getError() == null) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasSubscribers() {
        if (((ta2[]) this.f20073d.get()).length != 0) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasThrowable() {
        sa2 sa2Var = this.f20071b;
        if (sa2Var.isDone() && sa2Var.getError() != null) {
            return true;
        }
        return false;
    }

    @CheckReturnValue
    public boolean hasValue() {
        if (this.f20071b.size() != 0) {
            return true;
        }
        return false;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.f20072c) {
            return;
        }
        this.f20072c = true;
        sa2 sa2Var = this.f20071b;
        sa2Var.complete();
        for (ta2 ta2Var : (ta2[]) this.f20073d.getAndSet(f20070g)) {
            sa2Var.mo7353e(ta2Var);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        ExceptionHelper.nullCheck(th, "onError called with a null Throwable.");
        if (this.f20072c) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f20072c = true;
        sa2 sa2Var = this.f20071b;
        sa2Var.mo7350b(th);
        for (ta2 ta2Var : (ta2[]) this.f20073d.getAndSet(f20070g)) {
            sa2Var.mo7353e(ta2Var);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        ExceptionHelper.nullCheck(t, "onNext called with a null value.");
        if (this.f20072c) {
            return;
        }
        sa2 sa2Var = this.f20071b;
        sa2Var.mo7349a(t);
        for (ta2 ta2Var : (ta2[]) this.f20073d.get()) {
            sa2Var.mo7353e(ta2Var);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (this.f20072c) {
            subscription.cancel();
        } else {
            subscription.request(Long.MAX_VALUE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        ta2 ta2Var = new ta2(subscriber, this);
        subscriber.onSubscribe(ta2Var);
        while (true) {
            AtomicReference atomicReference = this.f20073d;
            ta2[] ta2VarArr = (ta2[]) atomicReference.get();
            if (ta2VarArr == f20070g) {
                break;
            }
            int length = ta2VarArr.length;
            ta2[] ta2VarArr2 = new ta2[length + 1];
            System.arraycopy(ta2VarArr, 0, ta2VarArr2, 0, length);
            ta2VarArr2[length] = ta2Var;
            while (!atomicReference.compareAndSet(ta2VarArr, ta2VarArr2)) {
                if (atomicReference.get() != ta2VarArr) {
                    break;
                }
            }
            if (ta2Var.f26754e) {
                m5315e(ta2Var);
                return;
            }
        }
        this.f20071b.mo7353e(ta2Var);
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplayProcessor<T> create(int i) {
        ObjectHelper.verifyPositive(i, "capacityHint");
        return new ReplayProcessor<>(new xa2(i));
    }

    @CheckReturnValue
    public T[] getValues(T[] tArr) {
        return (T[]) this.f20071b.mo7352d(tArr);
    }
}
