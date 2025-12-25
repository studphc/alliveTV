package p000;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.operators.flowable.C1317a;
import io.reactivex.rxjava3.internal.operators.observable.ObserverResourceWrapper;
import io.reactivex.rxjava3.internal.subscribers.SubscriberResourceWrapper;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes2.dex */
public final class tm0 implements Consumer {

    /* renamed from: a */
    public final /* synthetic */ int f26874a;

    /* renamed from: b */
    public final Object f26875b;

    public /* synthetic */ tm0(int i, Object obj) {
        this.f26874a = i;
        this.f26875b = obj;
    }

    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Object obj) {
        switch (this.f26874a) {
            case 0:
                ((ConcurrentLinkedQueue) this.f26875b).offer((C1317a) obj);
                return;
            case 1:
                ((SubscriberResourceWrapper) this.f26875b).setResource((Disposable) obj);
                return;
            case 2:
                ((Action) this.f26875b).run();
                return;
            default:
                ((ObserverResourceWrapper) this.f26875b).setResource((Disposable) obj);
                return;
        }
    }
}
