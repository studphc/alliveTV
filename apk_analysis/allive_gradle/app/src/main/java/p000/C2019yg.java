package p000;

import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.subscribers.DefaultSubscriber;

/* renamed from: yg */
/* loaded from: classes2.dex */
public final class C2019yg extends DefaultSubscriber {

    /* renamed from: b */
    public volatile Object f28943b;

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f28943b = NotificationLite.complete();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.f28943b = NotificationLite.error(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        this.f28943b = NotificationLite.next(obj);
    }
}
