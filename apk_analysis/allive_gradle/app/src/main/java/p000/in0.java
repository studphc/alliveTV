package p000;

import io.reactivex.rxjava3.functions.Consumer;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class in0 implements Consumer {

    /* renamed from: a */
    public final /* synthetic */ int f18474a;

    /* renamed from: b */
    public final Subscriber f18475b;

    public /* synthetic */ in0(Subscriber subscriber, int i) {
        this.f18474a = i;
        this.f18475b = subscriber;
    }

    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Object obj) {
        switch (this.f18474a) {
            case 0:
                this.f18475b.onError((Throwable) obj);
                return;
            default:
                this.f18475b.onNext(obj);
                return;
        }
    }
}
