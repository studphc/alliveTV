package p000;

import io.reactivex.rxjava3.core.Emitter;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class sm0 extends AtomicLong implements Emitter, Subscription {
    private static final long serialVersionUID = 7565982551505011832L;

    /* renamed from: a */
    public final Subscriber f26482a;

    /* renamed from: b */
    public final BiFunction f26483b;

    /* renamed from: c */
    public final Consumer f26484c;

    /* renamed from: d */
    public Object f26485d;

    /* renamed from: e */
    public volatile boolean f26486e;

    /* renamed from: f */
    public boolean f26487f;

    /* renamed from: g */
    public boolean f26488g;

    public sm0(Subscriber subscriber, BiFunction biFunction, Consumer consumer, Object obj) {
        this.f26482a = subscriber;
        this.f26483b = biFunction;
        this.f26484c = consumer;
        this.f26485d = obj;
    }

    /* renamed from: a */
    public final void m7381a(Object obj) {
        try {
            this.f26484c.accept(obj);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (!this.f26486e) {
            this.f26486e = true;
            if (BackpressureHelper.add(this, 1L) == 0) {
                Object obj = this.f26485d;
                this.f26485d = null;
                m7381a(obj);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Emitter
    public final void onComplete() {
        if (!this.f26487f) {
            this.f26487f = true;
            this.f26482a.onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.core.Emitter
    public final void onError(Throwable th) {
        if (this.f26487f) {
            RxJavaPlugins.onError(th);
            return;
        }
        if (th == null) {
            th = ExceptionHelper.createNullPointerException("onError called with a null Throwable.");
        }
        this.f26487f = true;
        this.f26482a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Emitter
    public final void onNext(Object obj) {
        if (!this.f26487f) {
            if (this.f26488g) {
                onError(new IllegalStateException("onNext already called in this generate turn"));
            } else if (obj == null) {
                onError(ExceptionHelper.createNullPointerException("onNext called with a null value."));
            } else {
                this.f26488g = true;
                this.f26482a.onNext(obj);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0055, code lost:
    
        r9.f26485d = r0;
        r10 = addAndGet(-r4);
     */
    @Override // org.reactivestreams.Subscription
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void request(long j) {
        if (!SubscriptionHelper.validate(j) || BackpressureHelper.add(this, j) != 0) {
            return;
        }
        Object obj = this.f26485d;
        BiFunction biFunction = this.f26483b;
        do {
            long j2 = 0;
            while (true) {
                if (j2 != j) {
                    if (this.f26486e) {
                        this.f26485d = null;
                        m7381a(obj);
                        return;
                    }
                    this.f26488g = false;
                    try {
                        obj = biFunction.apply(obj, this);
                        if (this.f26487f) {
                            this.f26486e = true;
                            this.f26485d = null;
                            m7381a(obj);
                            return;
                        }
                        j2++;
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.f26486e = true;
                        this.f26485d = null;
                        onError(th);
                        m7381a(obj);
                        return;
                    }
                } else {
                    j = get();
                    if (j2 == j) {
                        break;
                    }
                }
            }
        } while (j != 0);
    }
}
