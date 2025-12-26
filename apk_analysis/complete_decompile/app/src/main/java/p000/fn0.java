package p000;

import io.reactivex.rxjava3.core.Emitter;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.BiFunction;

/* loaded from: classes2.dex */
public final class fn0 implements BiFunction {

    /* renamed from: a */
    public final /* synthetic */ int f17341a;

    /* renamed from: b */
    public final BiConsumer f17342b;

    public /* synthetic */ fn0(BiConsumer biConsumer, int i) {
        this.f17341a = i;
        this.f17342b = biConsumer;
    }

    @Override // io.reactivex.rxjava3.functions.BiFunction
    public final Object apply(Object obj, Object obj2) {
        switch (this.f17341a) {
            case 0:
                this.f17342b.accept(obj, (Emitter) obj2);
                return obj;
            default:
                this.f17342b.accept(obj, (Emitter) obj2);
                return obj;
        }
    }
}
