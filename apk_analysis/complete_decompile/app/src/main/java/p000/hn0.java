package p000;

import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.concurrent.Future;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class hn0 implements Action {

    /* renamed from: a */
    public final /* synthetic */ int f18104a;

    /* renamed from: b */
    public final Object f18105b;

    public /* synthetic */ hn0(int i, Object obj) {
        this.f18104a = i;
        this.f18105b = obj;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        switch (this.f18104a) {
            case 0:
                ((Subscriber) this.f18105b).onComplete();
                return;
            case 1:
                ((Future) this.f18105b).get();
                return;
            case 2:
                ((Consumer) this.f18105b).accept(Notification.createOnComplete());
                return;
            default:
                ((Observer) this.f18105b).onComplete();
                return;
        }
    }
}
