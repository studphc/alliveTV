package p000;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFromIterable;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableTakePublisher;
import io.reactivex.rxjava3.internal.operators.observable.ObservableFromIterable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableTake;
import java.util.Objects;
import org.reactivestreams.Publisher;

/* loaded from: classes2.dex */
public final class bn0 implements Function {

    /* renamed from: a */
    public final /* synthetic */ int f8100a;

    /* renamed from: b */
    public final Function f8101b;

    public /* synthetic */ bn0(Function function, int i) {
        this.f8100a = i;
        this.f8101b = function;
    }

    @Override // io.reactivex.rxjava3.functions.Function
    public final Object apply(Object obj) {
        switch (this.f8100a) {
            case 0:
                Object apply = this.f8101b.apply(obj);
                Objects.requireNonNull(apply, "The mapper returned a null Iterable");
                return new FlowableFromIterable((Iterable) apply);
            case 1:
                Object apply2 = this.f8101b.apply(obj);
                Objects.requireNonNull(apply2, "The itemDelay returned a null Publisher");
                return new FlowableTakePublisher((Publisher) apply2, 1L).map(Functions.justFunction(obj)).defaultIfEmpty(obj);
            case 2:
                Object apply3 = this.f8101b.apply(obj);
                Objects.requireNonNull(apply3, "The mapper returned a null Iterable");
                return new ObservableFromIterable((Iterable) apply3);
            default:
                Object apply4 = this.f8101b.apply(obj);
                Objects.requireNonNull(apply4, "The itemDelay returned a null ObservableSource");
                return new ObservableTake((ObservableSource) apply4, 1L).map(Functions.justFunction(obj)).defaultIfEmpty(obj);
        }
    }
}
