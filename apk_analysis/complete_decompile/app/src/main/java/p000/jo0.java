package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class jo0 extends SubscriptionArbiter implements FlowableSubscriber {
    private static final long serialVersionUID = 4063763155303814625L;

    /* renamed from: h */
    public final Subscriber f20562h;

    /* renamed from: i */
    public final Function f20563i;

    /* renamed from: j */
    public boolean f20564j;

    /* renamed from: k */
    public boolean f20565k;

    /* renamed from: l */
    public long f20566l;

    public jo0(Subscriber subscriber, Function function) {
        super(false);
        this.f20562h = subscriber;
        this.f20563i = function;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (this.f20565k) {
            return;
        }
        this.f20565k = true;
        this.f20564j = true;
        this.f20562h.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        boolean z = this.f20564j;
        Subscriber subscriber = this.f20562h;
        if (z) {
            if (this.f20565k) {
                RxJavaPlugins.onError(th);
                return;
            } else {
                subscriber.onError(th);
                return;
            }
        }
        this.f20564j = true;
        try {
            Object apply = this.f20563i.apply(th);
            Objects.requireNonNull(apply, "The nextSupplier returned a null Publisher");
            Publisher publisher = (Publisher) apply;
            long j = this.f20566l;
            if (j != 0) {
                produced(j);
            }
            publisher.subscribe(this);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            subscriber.onError(new CompositeException(th, th2));
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (this.f20565k) {
            return;
        }
        if (!this.f20564j) {
            this.f20566l++;
        }
        this.f20562h.onNext(obj);
    }
}
