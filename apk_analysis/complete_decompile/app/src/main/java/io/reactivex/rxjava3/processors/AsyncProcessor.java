package io.reactivex.rxjava3.processors;

import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p000.C2051zb;

/* loaded from: classes2.dex */
public final class AsyncProcessor<T> extends FlowableProcessor<T> {

    /* renamed from: e */
    public static final C2051zb[] f20037e = new C2051zb[0];

    /* renamed from: f */
    public static final C2051zb[] f20038f = new C2051zb[0];

    /* renamed from: b */
    public final AtomicReference f20039b = new AtomicReference(f20037e);

    /* renamed from: c */
    public Throwable f20040c;

    /* renamed from: d */
    public Object f20041d;

    @CheckReturnValue
    @NonNull
    public static <T> AsyncProcessor<T> create() {
        return new AsyncProcessor<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: e */
    public final void m5309e(C2051zb c2051zb) {
        C2051zb[] c2051zbArr;
        while (true) {
            AtomicReference atomicReference = this.f20039b;
            C2051zb[] c2051zbArr2 = (C2051zb[]) atomicReference.get();
            int length = c2051zbArr2.length;
            if (length == 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i < length) {
                    if (c2051zbArr2[i] == c2051zb) {
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
                c2051zbArr = f20037e;
            } else {
                C2051zb[] c2051zbArr3 = new C2051zb[length - 1];
                System.arraycopy(c2051zbArr2, 0, c2051zbArr3, 0, i);
                System.arraycopy(c2051zbArr2, i + 1, c2051zbArr3, i, (length - i) - 1);
                c2051zbArr = c2051zbArr3;
            }
            while (!atomicReference.compareAndSet(c2051zbArr2, c2051zbArr)) {
                if (atomicReference.get() != c2051zbArr2) {
                    break;
                }
            }
            return;
        }
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    @Nullable
    public Throwable getThrowable() {
        if (this.f20039b.get() == f20038f) {
            return this.f20040c;
        }
        return null;
    }

    @CheckReturnValue
    @Nullable
    public T getValue() {
        if (this.f20039b.get() == f20038f) {
            return (T) this.f20041d;
        }
        return null;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasComplete() {
        if (this.f20039b.get() == f20038f && this.f20040c == null) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasSubscribers() {
        if (((C2051zb[]) this.f20039b.get()).length != 0) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasThrowable() {
        if (this.f20039b.get() == f20038f && this.f20040c != null) {
            return true;
        }
        return false;
    }

    @CheckReturnValue
    public boolean hasValue() {
        if (this.f20039b.get() == f20038f && this.f20041d != null) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        AtomicReference atomicReference = this.f20039b;
        Object obj = atomicReference.get();
        Object obj2 = f20038f;
        if (obj == obj2) {
            return;
        }
        Object obj3 = this.f20041d;
        C2051zb[] c2051zbArr = (C2051zb[]) atomicReference.getAndSet(obj2);
        int i = 0;
        if (obj3 == null) {
            int length = c2051zbArr.length;
            while (i < length) {
                c2051zbArr[i].onComplete();
                i++;
            }
            return;
        }
        int length2 = c2051zbArr.length;
        while (i < length2) {
            c2051zbArr[i].complete(obj3);
            i++;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(@NonNull Throwable th) {
        ExceptionHelper.nullCheck(th, "onError called with a null Throwable.");
        AtomicReference atomicReference = this.f20039b;
        Object obj = atomicReference.get();
        Object obj2 = f20038f;
        if (obj == obj2) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f20041d = null;
        this.f20040c = th;
        C2051zb[] c2051zbArr = (C2051zb[]) atomicReference.getAndSet(obj2);
        for (C2051zb c2051zb : c2051zbArr) {
            c2051zb.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(@NonNull T t) {
        ExceptionHelper.nullCheck(t, "onNext called with a null value.");
        if (this.f20039b.get() == f20038f) {
            return;
        }
        this.f20041d = t;
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(@NonNull Subscription subscription) {
        if (this.f20039b.get() == f20038f) {
            subscription.cancel();
        } else {
            subscription.request(Long.MAX_VALUE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(@NonNull Subscriber<? super T> subscriber) {
        C2051zb c2051zb = new C2051zb(subscriber, this);
        subscriber.onSubscribe(c2051zb);
        while (true) {
            AtomicReference atomicReference = this.f20039b;
            C2051zb[] c2051zbArr = (C2051zb[]) atomicReference.get();
            if (c2051zbArr == f20038f) {
                Throwable th = this.f20040c;
                if (th != null) {
                    subscriber.onError(th);
                    return;
                }
                Object obj = this.f20041d;
                if (obj != null) {
                    c2051zb.complete(obj);
                    return;
                } else {
                    c2051zb.onComplete();
                    return;
                }
            }
            int length = c2051zbArr.length;
            C2051zb[] c2051zbArr2 = new C2051zb[length + 1];
            System.arraycopy(c2051zbArr, 0, c2051zbArr2, 0, length);
            c2051zbArr2[length] = c2051zb;
            while (!atomicReference.compareAndSet(c2051zbArr, c2051zbArr2)) {
                if (atomicReference.get() != c2051zbArr) {
                    break;
                }
            }
            if (c2051zb.isCancelled()) {
                m5309e(c2051zb);
                return;
            }
            return;
        }
    }
}
