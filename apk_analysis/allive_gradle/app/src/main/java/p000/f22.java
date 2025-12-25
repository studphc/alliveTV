package p000;

import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import io.reactivex.rxjava3.parallel.ParallelFailureHandling;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class f22 implements ConditionalSubscriber, Subscription {

    /* renamed from: a */
    public final /* synthetic */ int f17090a;

    /* renamed from: b */
    public final Consumer f17091b;

    /* renamed from: c */
    public final BiFunction f17092c;

    /* renamed from: d */
    public Subscription f17093d;

    /* renamed from: e */
    public boolean f17094e;

    /* renamed from: f */
    public final Subscriber f17095f;

    public /* synthetic */ f22(Subscriber subscriber, Consumer consumer, BiFunction biFunction, int i) {
        this.f17090a = i;
        this.f17095f = subscriber;
        this.f17091b = consumer;
        this.f17092c = biFunction;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        switch (this.f17090a) {
            case 0:
                this.f17093d.cancel();
                return;
            default:
                this.f17093d.cancel();
                return;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        switch (this.f17090a) {
            case 0:
                if (!this.f17094e) {
                    this.f17094e = true;
                    ((ConditionalSubscriber) this.f17095f).onComplete();
                    return;
                }
                return;
            default:
                if (!this.f17094e) {
                    this.f17094e = true;
                    this.f17095f.onComplete();
                    return;
                }
                return;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        switch (this.f17090a) {
            case 0:
                if (this.f17094e) {
                    RxJavaPlugins.onError(th);
                    return;
                } else {
                    this.f17094e = true;
                    ((ConditionalSubscriber) this.f17095f).onError(th);
                    return;
                }
            default:
                if (this.f17094e) {
                    RxJavaPlugins.onError(th);
                    return;
                } else {
                    this.f17094e = true;
                    this.f17095f.onError(th);
                    return;
                }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        switch (this.f17090a) {
            case 0:
                if (!tryOnNext(obj) && !this.f17094e) {
                    this.f17093d.request(1L);
                    return;
                }
                return;
            default:
                if (!tryOnNext(obj)) {
                    this.f17093d.request(1L);
                    return;
                }
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        switch (this.f17090a) {
            case 0:
                if (SubscriptionHelper.validate(this.f17093d, subscription)) {
                    this.f17093d = subscription;
                    ((ConditionalSubscriber) this.f17095f).onSubscribe(this);
                    return;
                }
                return;
            default:
                if (SubscriptionHelper.validate(this.f17093d, subscription)) {
                    this.f17093d = subscription;
                    this.f17095f.onSubscribe(this);
                    return;
                }
                return;
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        switch (this.f17090a) {
            case 0:
                this.f17093d.request(j);
                return;
            default:
                this.f17093d.request(j);
                return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
    
        r8.onNext(r18);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:?, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
    
        io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r0);
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
    
        r0 = r7.apply(java.lang.Long.valueOf(r10), r0);
        java.util.Objects.requireNonNull(r0, "The errorHandler returned a null ParallelFailureHandling");
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
    
        r0 = p000.e22.f16660a[((io.reactivex.rxjava3.parallel.ParallelFailureHandling) r0).ordinal()];
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
    
        if (r0 != 1) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0043, code lost:
    
        if (r0 != 2) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0045, code lost:
    
        if (r0 != 3) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0047, code lost:
    
        cancel();
        onError(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004e, code lost:
    
        cancel();
        onComplete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0055, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0056, code lost:
    
        io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r0);
        cancel();
        onError(new io.reactivex.rxjava3.exceptions.CompositeException(r0, r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x001b, code lost:
    
        if (r17.f17094e != false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x006b, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001f, code lost:
    
        r9.accept(r18);
     */
    @Override // io.reactivex.rxjava3.operators.ConditionalSubscriber
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean tryOnNext(Object obj) {
        int i;
        BiFunction biFunction = this.f17092c;
        Subscriber subscriber = this.f17095f;
        Consumer consumer = this.f17091b;
        long j = 0;
        switch (this.f17090a) {
            case 0:
                if (this.f17094e) {
                    return false;
                }
                do {
                    try {
                        consumer.accept(obj);
                        return ((ConditionalSubscriber) subscriber).tryOnNext(obj);
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        j++;
                        try {
                            Object apply = biFunction.apply(Long.valueOf(j), th);
                            Objects.requireNonNull(apply, "The errorHandler returned a null ParallelFailureHandling");
                            i = e22.f16660a[((ParallelFailureHandling) apply).ordinal()];
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            cancel();
                            onError(new CompositeException(th, th2));
                            return false;
                        }
                    }
                } while (i == 1);
                if (i == 2) {
                    return false;
                }
                if (i != 3) {
                    cancel();
                    onError(th);
                    return false;
                }
                cancel();
                onComplete();
                return false;
        }
    }
}
