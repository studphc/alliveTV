package p000;

import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import io.reactivex.rxjava3.parallel.ParallelFailureHandling;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class i22 implements ConditionalSubscriber, Subscription {

    /* renamed from: a */
    public final Predicate f18270a;

    /* renamed from: b */
    public final BiFunction f18271b;

    /* renamed from: c */
    public Subscription f18272c;

    /* renamed from: d */
    public boolean f18273d;

    /* renamed from: e */
    public final /* synthetic */ int f18274e;

    /* renamed from: f */
    public final Subscriber f18275f;

    public i22(Subscriber subscriber, Predicate predicate, BiFunction biFunction, int i) {
        this.f18274e = i;
        this.f18270a = predicate;
        this.f18271b = biFunction;
        this.f18275f = subscriber;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f18272c.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        switch (this.f18274e) {
            case 0:
                if (!this.f18273d) {
                    this.f18273d = true;
                    ((ConditionalSubscriber) this.f18275f).onComplete();
                    return;
                }
                return;
            default:
                if (!this.f18273d) {
                    this.f18273d = true;
                    this.f18275f.onComplete();
                    return;
                }
                return;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        switch (this.f18274e) {
            case 0:
                if (this.f18273d) {
                    RxJavaPlugins.onError(th);
                    return;
                } else {
                    this.f18273d = true;
                    ((ConditionalSubscriber) this.f18275f).onError(th);
                    return;
                }
            default:
                if (this.f18273d) {
                    RxJavaPlugins.onError(th);
                    return;
                } else {
                    this.f18273d = true;
                    this.f18275f.onError(th);
                    return;
                }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (!tryOnNext(obj) && !this.f18273d) {
            this.f18272c.request(1L);
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        switch (this.f18274e) {
            case 0:
                if (SubscriptionHelper.validate(this.f18272c, subscription)) {
                    this.f18272c = subscription;
                    ((ConditionalSubscriber) this.f18275f).onSubscribe(this);
                    return;
                }
                return;
            default:
                if (SubscriptionHelper.validate(this.f18272c, subscription)) {
                    this.f18272c = subscription;
                    this.f18275f.onSubscribe(this);
                    return;
                }
                return;
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        this.f18272c.request(j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
    
        if (r9.test(r18) == false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
    
        r8.onNext(r18);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x006e, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002a, code lost:
    
        io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r0);
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
    
        r0 = r7.apply(java.lang.Long.valueOf(r10), r0);
        java.util.Objects.requireNonNull(r0, "The errorHandler returned a null ParallelFailureHandling");
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003c, code lost:
    
        r0 = p000.h22.f17934a[((io.reactivex.rxjava3.parallel.ParallelFailureHandling) r0).ordinal()];
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0044, code lost:
    
        if (r0 != 1) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0046, code lost:
    
        if (r0 != 2) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0048, code lost:
    
        if (r0 != 3) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004a, code lost:
    
        cancel();
        onError(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0051, code lost:
    
        cancel();
        onComplete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0058, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0059, code lost:
    
        io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r0);
        cancel();
        onError(new io.reactivex.rxjava3.exceptions.CompositeException(r0, r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x001b, code lost:
    
        if (r17.f18273d == false) goto L49;
     */
    @Override // io.reactivex.rxjava3.operators.ConditionalSubscriber
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean tryOnNext(Object obj) {
        int i;
        BiFunction biFunction = this.f18271b;
        Subscriber subscriber = this.f18275f;
        Predicate predicate = this.f18270a;
        long j = 0;
        boolean z = true;
        switch (this.f18274e) {
            case 0:
                if (this.f18273d) {
                    return false;
                }
                do {
                    try {
                        if (!predicate.test(obj) || !((ConditionalSubscriber) subscriber).tryOnNext(obj)) {
                            z = false;
                        }
                        return z;
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        j++;
                        try {
                            Object apply = biFunction.apply(Long.valueOf(j), th);
                            Objects.requireNonNull(apply, "The errorHandler returned a null ParallelFailureHandling");
                            i = h22.f17934a[((ParallelFailureHandling) apply).ordinal()];
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
        return false;
    }
}
