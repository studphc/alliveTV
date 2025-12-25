package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class v22 extends AtomicReference implements FlowableSubscriber {
    private static final long serialVersionUID = -7954444275102466525L;

    /* renamed from: a */
    public final w22 f27630a;

    /* renamed from: b */
    public final BiFunction f27631b;

    /* renamed from: c */
    public Object f27632c;

    /* renamed from: d */
    public boolean f27633d;

    public v22(w22 w22Var, BiFunction biFunction) {
        this.f27630a = w22Var;
        this.f27631b = biFunction;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (!this.f27633d) {
            this.f27633d = true;
            this.f27630a.m7966e(this.f27632c);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f27633d) {
            RxJavaPlugins.onError(th);
        } else {
            this.f27633d = true;
            this.f27630a.m7965a(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (!this.f27633d) {
            Object obj2 = this.f27632c;
            if (obj2 == null) {
                this.f27632c = obj;
                return;
            }
            try {
                Object apply = this.f27631b.apply(obj2, obj);
                Objects.requireNonNull(apply, "The reducer returned a null value");
                this.f27632c = apply;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                ((Subscription) get()).cancel();
                onError(th);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
    }
}
