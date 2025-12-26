package io.reactivex.rxjava3.processors;

import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p000.h82;

/* loaded from: classes2.dex */
public final class PublishProcessor<T> extends FlowableProcessor<T> {

    /* renamed from: d */
    public static final h82[] f20064d = new h82[0];

    /* renamed from: e */
    public static final h82[] f20065e = new h82[0];

    /* renamed from: b */
    public final AtomicReference f20066b = new AtomicReference(f20065e);

    /* renamed from: c */
    public Throwable f20067c;

    @CheckReturnValue
    @NonNull
    public static <T> PublishProcessor<T> create() {
        return new PublishProcessor<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: e */
    public final void m5314e(h82 h82Var) {
        h82[] h82VarArr;
        while (true) {
            AtomicReference atomicReference = this.f20066b;
            h82[] h82VarArr2 = (h82[]) atomicReference.get();
            if (h82VarArr2 != f20064d && h82VarArr2 != (h82VarArr = f20065e)) {
                int length = h82VarArr2.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        if (h82VarArr2[i] == h82Var) {
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
                    h82VarArr = new h82[length - 1];
                    System.arraycopy(h82VarArr2, 0, h82VarArr, 0, i);
                    System.arraycopy(h82VarArr2, i + 1, h82VarArr, i, (length - i) - 1);
                }
                while (!atomicReference.compareAndSet(h82VarArr2, h82VarArr)) {
                    if (atomicReference.get() != h82VarArr2) {
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
        if (this.f20066b.get() == f20064d) {
            return this.f20067c;
        }
        return null;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasComplete() {
        if (this.f20066b.get() == f20064d && this.f20067c == null) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasSubscribers() {
        if (((h82[]) this.f20066b.get()).length != 0) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasThrowable() {
        if (this.f20066b.get() == f20064d && this.f20067c != null) {
            return true;
        }
        return false;
    }

    @CheckReturnValue
    public boolean offer(@NonNull T t) {
        ExceptionHelper.nullCheck(t, "offer called with a null value.");
        h82[] h82VarArr = (h82[]) this.f20066b.get();
        for (h82 h82Var : h82VarArr) {
            if (h82Var.get() == 0) {
                return false;
            }
        }
        for (h82 h82Var2 : h82VarArr) {
            h82Var2.m5046a(t);
        }
        return true;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        AtomicReference atomicReference = this.f20066b;
        Object obj = atomicReference.get();
        Object obj2 = f20064d;
        if (obj == obj2) {
            return;
        }
        h82[] h82VarArr = (h82[]) atomicReference.getAndSet(obj2);
        for (h82 h82Var : h82VarArr) {
            if (h82Var.get() != Long.MIN_VALUE) {
                h82Var.f17975a.onComplete();
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(@NonNull Throwable th) {
        ExceptionHelper.nullCheck(th, "onError called with a null Throwable.");
        AtomicReference atomicReference = this.f20066b;
        Object obj = atomicReference.get();
        Object obj2 = f20064d;
        if (obj == obj2) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f20067c = th;
        h82[] h82VarArr = (h82[]) atomicReference.getAndSet(obj2);
        for (h82 h82Var : h82VarArr) {
            if (h82Var.get() != Long.MIN_VALUE) {
                h82Var.f17975a.onError(th);
            } else {
                RxJavaPlugins.onError(th);
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(@NonNull T t) {
        ExceptionHelper.nullCheck(t, "onNext called with a null value.");
        for (h82 h82Var : (h82[]) this.f20066b.get()) {
            h82Var.m5046a(t);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(@NonNull Subscription subscription) {
        if (this.f20066b.get() == f20064d) {
            subscription.cancel();
        } else {
            subscription.request(Long.MAX_VALUE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(@NonNull Subscriber<? super T> subscriber) {
        h82 h82Var = new h82(subscriber, this);
        subscriber.onSubscribe(h82Var);
        while (true) {
            AtomicReference atomicReference = this.f20066b;
            h82[] h82VarArr = (h82[]) atomicReference.get();
            if (h82VarArr == f20064d) {
                Throwable th = this.f20067c;
                if (th != null) {
                    subscriber.onError(th);
                    return;
                } else {
                    subscriber.onComplete();
                    return;
                }
            }
            int length = h82VarArr.length;
            h82[] h82VarArr2 = new h82[length + 1];
            System.arraycopy(h82VarArr, 0, h82VarArr2, 0, length);
            h82VarArr2[length] = h82Var;
            while (!atomicReference.compareAndSet(h82VarArr, h82VarArr2)) {
                if (atomicReference.get() != h82VarArr) {
                    break;
                }
            }
            if (h82Var.get() == Long.MIN_VALUE) {
                m5314e(h82Var);
                return;
            }
            return;
        }
    }
}
