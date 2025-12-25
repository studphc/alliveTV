package p000;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.CancellableFlow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: bl */
/* loaded from: classes2.dex */
public final class C0561bl implements CancellableFlow {

    /* renamed from: a */
    public final Flow f8058a;

    public C0561bl(Flow flow) {
        this.f8058a = flow;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector, Continuation continuation) {
        Object collect = this.f8058a.collect(new C0022al(0, flowCollector), continuation);
        if (collect == b51.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
