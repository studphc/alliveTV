package p000;

import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: eh */
/* loaded from: classes2.dex */
public final class C1158eh extends DisposableObserver {

    /* renamed from: b */
    public final ArrayBlockingQueue f16820b = new ArrayBlockingQueue(1);

    /* renamed from: c */
    public final AtomicInteger f16821c = new AtomicInteger();

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        RxJavaPlugins.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        Notification notification = (Notification) obj;
        if (this.f16821c.getAndSet(0) != 1 && notification.isOnNext()) {
            return;
        }
        while (true) {
            ArrayBlockingQueue arrayBlockingQueue = this.f16820b;
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

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
    }
}
