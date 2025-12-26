package p000;

import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class rn0 extends SinglePostCompleteSubscriber {
    private static final long serialVersionUID = -3740826063558713822L;

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        complete(Notification.createOnComplete());
    }

    @Override // io.reactivex.rxjava3.internal.subscribers.SinglePostCompleteSubscriber
    public final void onDrop(Object obj) {
        Notification notification = (Notification) obj;
        if (notification.isOnError()) {
            RxJavaPlugins.onError(notification.getError());
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        complete(Notification.createOnError(th));
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        this.produced++;
        this.downstream.onNext(Notification.createOnNext(obj));
    }
}
