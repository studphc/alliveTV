package p000;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.flowables.ConnectableFlowable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscribers.SubscriberResourceWrapper;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.ScalarSubscription;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.processors.FlowableProcessor;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class hp0 extends Flowable {

    /* renamed from: b */
    public final /* synthetic */ int f18122b;

    /* renamed from: c */
    public final Object f18123c;

    /* renamed from: d */
    public final Object f18124d;

    public /* synthetic */ hp0(Object obj, Function function, int i) {
        this.f18122b = i;
        this.f18124d = obj;
        this.f18123c = function;
    }

    /* renamed from: e */
    public boolean m5121e() {
        AtomicBoolean atomicBoolean = (AtomicBoolean) this.f18123c;
        if (atomicBoolean.get() || !atomicBoolean.compareAndSet(false, true)) {
            return false;
        }
        return true;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public final void subscribeActual(Subscriber subscriber) {
        switch (this.f18122b) {
            case 0:
                try {
                    ConnectableFlowable connectableFlowable = (ConnectableFlowable) ExceptionHelper.nullCheck(((Supplier) this.f18124d).get(), "The connectableFactory returned a null ConnectableFlowable.");
                    try {
                        Publisher publisher = (Publisher) ExceptionHelper.nullCheck(((Function) this.f18123c).apply(connectableFlowable), "The selector returned a null Publisher.");
                        SubscriberResourceWrapper subscriberResourceWrapper = new SubscriberResourceWrapper(subscriber);
                        publisher.subscribe(subscriberResourceWrapper);
                        connectableFlowable.connect(new tm0(1, subscriberResourceWrapper));
                        return;
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        EmptySubscription.error(th, subscriber);
                        return;
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    EmptySubscription.error(th2, subscriber);
                    return;
                }
            case 1:
                try {
                    Object apply = ((Function) this.f18123c).apply(this.f18124d);
                    Objects.requireNonNull(apply, "The mapper returned a null Publisher");
                    Publisher publisher2 = (Publisher) apply;
                    if (publisher2 instanceof Supplier) {
                        try {
                            Object obj = ((Supplier) publisher2).get();
                            if (obj == null) {
                                EmptySubscription.complete(subscriber);
                                return;
                            } else {
                                subscriber.onSubscribe(new ScalarSubscription(subscriber, obj));
                                return;
                            }
                        } catch (Throwable th3) {
                            Exceptions.throwIfFatal(th3);
                            EmptySubscription.error(th3, subscriber);
                            return;
                        }
                    }
                    publisher2.subscribe(subscriber);
                    return;
                } catch (Throwable th4) {
                    Exceptions.throwIfFatal(th4);
                    EmptySubscription.error(th4, subscriber);
                    return;
                }
            default:
                ((FlowableProcessor) this.f18124d).subscribe(subscriber);
                ((AtomicBoolean) this.f18123c).set(true);
                return;
        }
    }

    public hp0(FlowableProcessor flowableProcessor) {
        this.f18122b = 2;
        this.f18124d = flowableProcessor;
        this.f18123c = new AtomicBoolean();
    }
}
