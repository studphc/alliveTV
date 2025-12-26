package p000;

import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.subscribers.DisposableSubscriber;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: ah */
/* loaded from: classes2.dex */
public final class C0018ah extends DisposableSubscriber {

    /* renamed from: b */
    public final ArrayBlockingQueue f183b = new ArrayBlockingQueue(1);

    /* renamed from: c */
    public final AtomicInteger f184c = new AtomicInteger();

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        RxJavaPlugins.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        Notification notification = (Notification) obj;
        if (this.f184c.getAndSet(0) != 1 && notification.isOnNext()) {
            return;
        }
        while (true) {
            ArrayBlockingQueue arrayBlockingQueue = this.f183b;
            if (!arrayBlockingQueue.offer(notification)) {
                Notification notification2 = (Notification) arrayBlockingQueue.poll();
                if (notification2 != null && !notification2.isOnNext()) {
                    notification = notification2;
                }
            } else {
                return;
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
    }
}
