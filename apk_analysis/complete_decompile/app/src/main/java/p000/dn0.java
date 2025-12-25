package p000;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableMapPublisher;
import io.reactivex.rxjava3.internal.operators.observable.ObservableMap;
import java.util.Objects;
import org.reactivestreams.Publisher;

/* loaded from: classes2.dex */
public final class dn0 implements Function {

    /* renamed from: a */
    public final /* synthetic */ int f16439a;

    /* renamed from: b */
    public final BiFunction f16440b;

    /* renamed from: c */
    public final Function f16441c;

    public /* synthetic */ dn0(Function function, BiFunction biFunction, int i) {
        this.f16439a = i;
        this.f16440b = biFunction;
        this.f16441c = function;
    }

    @Override // io.reactivex.rxjava3.functions.Function
    public final Object apply(Object obj) {
        switch (this.f16439a) {
            case 0:
                Object apply = this.f16441c.apply(obj);
                Objects.requireNonNull(apply, "The mapper returned a null Publisher");
                return new FlowableMapPublisher((Publisher) apply, new cn0(0, this.f16440b, obj));
            default:
                Object apply2 = this.f16441c.apply(obj);
                Objects.requireNonNull(apply2, "The mapper returned a null ObservableSource");
                return new ObservableMap((ObservableSource) apply2, new cn0(1, this.f16440b, obj));
        }
    }
}
