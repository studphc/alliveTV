package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Consumer;

/* loaded from: classes2.dex */
public final class pw1 implements Consumer {

    /* renamed from: a */
    public final /* synthetic */ int f25323a;

    /* renamed from: b */
    public final Observer f25324b;

    public /* synthetic */ pw1(Observer observer, int i) {
        this.f25323a = i;
        this.f25324b = observer;
    }

    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Object obj) {
        switch (this.f25323a) {
            case 0:
                this.f25324b.onError((Throwable) obj);
                return;
            default:
                this.f25324b.onNext(obj);
                return;
        }
    }
}
