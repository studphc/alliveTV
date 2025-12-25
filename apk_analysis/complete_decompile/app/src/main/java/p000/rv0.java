package p000;

import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.functions.Consumer;

/* loaded from: classes2.dex */
public final class rv0 implements Consumer {

    /* renamed from: a */
    public final /* synthetic */ int f26158a;

    /* renamed from: b */
    public final Consumer f26159b;

    public /* synthetic */ rv0(Consumer consumer, int i) {
        this.f26158a = i;
        this.f26159b = consumer;
    }

    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Object obj) {
        switch (this.f26158a) {
            case 0:
                this.f26159b.accept(Notification.createOnError((Throwable) obj));
                return;
            default:
                this.f26159b.accept(Notification.createOnNext(obj));
                return;
        }
    }
}
