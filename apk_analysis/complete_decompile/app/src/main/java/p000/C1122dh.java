package p000;

import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.observers.DefaultObserver;

/* renamed from: dh */
/* loaded from: classes2.dex */
public final class C1122dh extends DefaultObserver {

    /* renamed from: b */
    public volatile Object f16374b;

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        this.f16374b = NotificationLite.complete();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        this.f16374b = NotificationLite.error(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        this.f16374b = NotificationLite.next(obj);
    }
}
