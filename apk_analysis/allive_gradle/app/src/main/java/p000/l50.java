package p000;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

/* loaded from: classes2.dex */
public final class l50 implements Flow {

    /* renamed from: a */
    public final Flow f22325a;

    /* renamed from: b */
    public final Function1 f22326b;

    /* renamed from: c */
    public final Function2 f22327c;

    public l50(Flow flow, Function1 function1, Function2 function2) {
        this.f22325a = flow;
        this.f22326b = function1;
        this.f22327c = function2;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlinx.coroutines.internal.Symbol, T] */
    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector, Continuation continuation) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = NullSurrogateKt.NULL;
        Object collect = this.f22325a.collect(new k50(this, objectRef, flowCollector), continuation);
        if (collect == b51.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
