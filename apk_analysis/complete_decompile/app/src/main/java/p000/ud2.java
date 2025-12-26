package p000;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.AbstractFlow;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes2.dex */
public final class ud2 extends AbstractFlow {

    /* renamed from: a */
    public final Function2 f27229a;

    public ud2(Function2 function2) {
        this.f27229a = function2;
    }

    @Override // kotlinx.coroutines.flow.AbstractFlow
    public final Object collectSafely(FlowCollector flowCollector, Continuation continuation) {
        Object invoke = this.f27229a.invoke(flowCollector, continuation);
        if (invoke == b51.getCOROUTINE_SUSPENDED()) {
            return invoke;
        }
        return Unit.INSTANCE;
    }
}
