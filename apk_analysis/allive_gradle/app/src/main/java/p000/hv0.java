package p000;

import io.reactivex.rxjava3.exceptions.OnErrorNotImplementedException;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class hv0 implements Consumer {

    /* renamed from: a */
    public final /* synthetic */ int f18196a;

    public /* synthetic */ hv0(int i) {
        this.f18196a = i;
    }

    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Object obj) {
        switch (this.f18196a) {
            case 0:
                return;
            case 1:
                RxJavaPlugins.onError((Throwable) obj);
                return;
            case 2:
                ((Subscription) obj).request(Long.MAX_VALUE);
                return;
            default:
                RxJavaPlugins.onError(new OnErrorNotImplementedException((Throwable) obj));
                return;
        }
    }

    public String toString() {
        switch (this.f18196a) {
            case 0:
                return "EmptyConsumer";
            default:
                return super.toString();
        }
    }

    /* renamed from: a */
    private final void m5132a(Object obj) {
    }
}
