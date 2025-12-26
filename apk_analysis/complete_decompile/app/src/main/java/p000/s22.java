package p000;

import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class s22 implements ConditionalSubscriber, Subscription {

    /* renamed from: a */
    public final /* synthetic */ int f26213a;

    /* renamed from: b */
    public final Subscriber f26214b;

    /* renamed from: c */
    public final Function f26215c;

    /* renamed from: d */
    public final BiFunction f26216d;

    /* renamed from: e */
    public Subscription f26217e;

    /* renamed from: f */
    public boolean f26218f;

    public /* synthetic */ s22(Subscriber subscriber, Function function, BiFunction biFunction, int i) {
        this.f26213a = i;
        this.f26214b = subscriber;
        this.f26215c = function;
        this.f26216d = biFunction;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        switch (this.f26213a) {
            case 0:
                this.f26217e.cancel();
                return;
            default:
                this.f26217e.cancel();
                return;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        switch (this.f26213a) {
            case 0:
                if (!this.f26218f) {
                    this.f26218f = true;
                    this.f26214b.onComplete();
                    return;
                }
                return;
            default:
                if (!this.f26218f) {
                    this.f26218f = true;
                    this.f26214b.onComplete();
                    return;
                }
                return;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        switch (this.f26213a) {
            case 0:
                if (this.f26218f) {
                    RxJavaPlugins.onError(th);
                    return;
                } else {
                    this.f26218f = true;
                    this.f26214b.onError(th);
                    return;
                }
            default:
                if (this.f26218f) {
                    RxJavaPlugins.onError(th);
                    return;
                } else {
                    this.f26218f = true;
                    this.f26214b.onError(th);
                    return;
                }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        switch (this.f26213a) {
            case 0:
                if (!tryOnNext(obj) && !this.f26218f) {
                    this.f26217e.request(1L);
                    return;
                }
                return;
            default:
                if (!tryOnNext(obj) && !this.f26218f) {
                    this.f26217e.request(1L);
                    return;
                }
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        switch (this.f26213a) {
            case 0:
                if (SubscriptionHelper.validate(this.f26217e, subscription)) {
                    this.f26217e = subscription;
                    this.f26214b.onSubscribe(this);
                    return;
                }
                return;
            default:
                if (SubscriptionHelper.validate(this.f26217e, subscription)) {
                    this.f26217e = subscription;
                    this.f26214b.onSubscribe(this);
                    return;
                }
                return;
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        switch (this.f26213a) {
            case 0:
                this.f26217e.request(j);
                return;
            default:
                this.f26217e.request(j);
                return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002c, code lost:
    
        r2 = r0.isPresent();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0030, code lost:
    
        if (r2 == false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:
    
        r0 = r0.get();
        r8.onNext(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003b, code lost:
    
        io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r0);
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0040, code lost:
    
        r0 = r7.apply(java.lang.Long.valueOf(r10), r0);
        java.util.Objects.requireNonNull(r0, "The errorHandler returned a null ParallelFailureHandling");
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004d, code lost:
    
        r0 = p000.t22.f26675a[((io.reactivex.rxjava3.parallel.ParallelFailureHandling) r0).ordinal()];
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0055, code lost:
    
        if (r0 != 1) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0057, code lost:
    
        if (r0 != 2) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0059, code lost:
    
        if (r0 != 3) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005b, code lost:
    
        cancel();
        onError(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0062, code lost:
    
        cancel();
        onComplete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0069, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006a, code lost:
    
        io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r0);
        cancel();
        onError(new io.reactivex.rxjava3.exceptions.CompositeException(r0, r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0082, code lost:
    
        if (r17.f26218f != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00d8, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0086, code lost:
    
        r0 = r9.apply(r18);
        java.util.Objects.requireNonNull(r0, "The mapper returned a null value");
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008f, code lost:
    
        r8.onNext(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:?, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0093, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0094, code lost:
    
        io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r0);
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0099, code lost:
    
        r0 = r7.apply(java.lang.Long.valueOf(r10), r0);
        java.util.Objects.requireNonNull(r0, "The errorHandler returned a null ParallelFailureHandling");
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a6, code lost:
    
        r0 = p000.q22.f25416a[((io.reactivex.rxjava3.parallel.ParallelFailureHandling) r0).ordinal()];
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ae, code lost:
    
        if (r0 != 1) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b0, code lost:
    
        if (r0 != 2) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b2, code lost:
    
        if (r0 != 3) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x001b, code lost:
    
        if (r17.f26218f != false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b4, code lost:
    
        cancel();
        onError(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00bb, code lost:
    
        cancel();
        onComplete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00c2, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00c3, code lost:
    
        io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r0);
        cancel();
        onError(new io.reactivex.rxjava3.exceptions.CompositeException(r0, r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001f, code lost:
    
        r0 = r9.apply(r18);
        java.util.Objects.requireNonNull(r0, "The mapper returned a null Optional");
        r0 = p000.ki0.m5540h(r0);
     */
    @Override // io.reactivex.rxjava3.operators.ConditionalSubscriber
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean tryOnNext(Object obj) {
        BiFunction biFunction = this.f26216d;
        Subscriber subscriber = this.f26214b;
        Function function = this.f26215c;
        long j = 0;
        switch (this.f26213a) {
        }
        return false;
    }
}
