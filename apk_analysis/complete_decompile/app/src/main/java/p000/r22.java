package p000;

import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import io.reactivex.rxjava3.parallel.ParallelFailureHandling;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.Optional;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class r22 implements ConditionalSubscriber, Subscription {

    /* renamed from: a */
    public final /* synthetic */ int f25840a;

    /* renamed from: b */
    public final ConditionalSubscriber f25841b;

    /* renamed from: c */
    public final Function f25842c;

    /* renamed from: d */
    public final BiFunction f25843d;

    /* renamed from: e */
    public Subscription f25844e;

    /* renamed from: f */
    public boolean f25845f;

    public /* synthetic */ r22(ConditionalSubscriber conditionalSubscriber, Function function, BiFunction biFunction, int i) {
        this.f25840a = i;
        this.f25841b = conditionalSubscriber;
        this.f25842c = function;
        this.f25843d = biFunction;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        switch (this.f25840a) {
            case 0:
                this.f25844e.cancel();
                return;
            default:
                this.f25844e.cancel();
                return;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        switch (this.f25840a) {
            case 0:
                if (!this.f25845f) {
                    this.f25845f = true;
                    this.f25841b.onComplete();
                    return;
                }
                return;
            default:
                if (!this.f25845f) {
                    this.f25845f = true;
                    this.f25841b.onComplete();
                    return;
                }
                return;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        switch (this.f25840a) {
            case 0:
                if (this.f25845f) {
                    RxJavaPlugins.onError(th);
                    return;
                } else {
                    this.f25845f = true;
                    this.f25841b.onError(th);
                    return;
                }
            default:
                if (this.f25845f) {
                    RxJavaPlugins.onError(th);
                    return;
                } else {
                    this.f25845f = true;
                    this.f25841b.onError(th);
                    return;
                }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        switch (this.f25840a) {
            case 0:
                if (!tryOnNext(obj) && !this.f25845f) {
                    this.f25844e.request(1L);
                    return;
                }
                return;
            default:
                if (!tryOnNext(obj) && !this.f25845f) {
                    this.f25844e.request(1L);
                    return;
                }
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        switch (this.f25840a) {
            case 0:
                if (SubscriptionHelper.validate(this.f25844e, subscription)) {
                    this.f25844e = subscription;
                    this.f25841b.onSubscribe(this);
                    return;
                }
                return;
            default:
                if (SubscriptionHelper.validate(this.f25844e, subscription)) {
                    this.f25844e = subscription;
                    this.f25841b.onSubscribe(this);
                    return;
                }
                return;
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        switch (this.f25840a) {
            case 0:
                this.f25844e.request(j);
                return;
            default:
                this.f25844e.request(j);
                return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0039, code lost:
    
        if (r8.tryOnNext(r0) != false) goto L14;
     */
    @Override // io.reactivex.rxjava3.operators.ConditionalSubscriber
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean tryOnNext(Object obj) {
        int i;
        int i2;
        boolean isPresent;
        Object obj2;
        BiFunction biFunction = this.f25843d;
        ConditionalSubscriber conditionalSubscriber = this.f25841b;
        Function function = this.f25842c;
        long j = 0;
        boolean z = true;
        switch (this.f25840a) {
            case 0:
                if (this.f25845f) {
                    return false;
                }
                do {
                    try {
                        Object apply = function.apply(obj);
                        Objects.requireNonNull(apply, "The mapper returned a null value");
                        return conditionalSubscriber.tryOnNext(apply);
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        j++;
                        try {
                            Object apply2 = biFunction.apply(Long.valueOf(j), th);
                            Objects.requireNonNull(apply2, "The errorHandler returned a null ParallelFailureHandling");
                            i = q22.f25416a[((ParallelFailureHandling) apply2).ordinal()];
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
            default:
                if (this.f25845f) {
                    return false;
                }
                do {
                    try {
                        Object apply3 = function.apply(obj);
                        Objects.requireNonNull(apply3, "The mapper returned a null Optional");
                        Optional m5540h = ki0.m5540h(apply3);
                        isPresent = m5540h.isPresent();
                        if (isPresent) {
                            obj2 = m5540h.get();
                            break;
                        }
                        z = false;
                        return z;
                    } catch (Throwable th3) {
                        Exceptions.throwIfFatal(th3);
                        j++;
                        try {
                            Object apply4 = biFunction.apply(Long.valueOf(j), th3);
                            Objects.requireNonNull(apply4, "The errorHandler returned a null ParallelFailureHandling");
                            i2 = t22.f26675a[((ParallelFailureHandling) apply4).ordinal()];
                        } catch (Throwable th4) {
                            Exceptions.throwIfFatal(th4);
                            cancel();
                            onError(new CompositeException(th3, th4));
                            return false;
                        }
                    }
                } while (i2 == 1);
                if (i2 == 2) {
                    return false;
                }
                if (i2 != 3) {
                    cancel();
                    onError(th3);
                    return false;
                }
                cancel();
                onComplete();
                return false;
        }
    }
}
