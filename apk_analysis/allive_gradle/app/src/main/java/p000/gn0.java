package p000;

import io.reactivex.rxjava3.core.Emitter;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;

/* loaded from: classes2.dex */
public final class gn0 implements BiFunction {

    /* renamed from: a */
    public final /* synthetic */ int f17773a;

    /* renamed from: b */
    public final Consumer f17774b;

    public /* synthetic */ gn0(Consumer consumer, int i) {
        this.f17773a = i;
        this.f17774b = consumer;
    }

    @Override // io.reactivex.rxjava3.functions.BiFunction
    public final Object apply(Object obj, Object obj2) {
        switch (this.f17773a) {
            case 0:
                this.f17774b.accept((Emitter) obj2);
                return obj;
            default:
                this.f17774b.accept((Emitter) obj2);
                return obj;
        }
    }
}
