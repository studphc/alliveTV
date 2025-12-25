package p000;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.ChannelFlowKt;
import kotlinx.coroutines.internal.ThreadContextKt;

/* loaded from: classes2.dex */
public final class a03 implements FlowCollector {

    /* renamed from: a */
    public final CoroutineContext f9a;

    /* renamed from: b */
    public final Object f10b;

    /* renamed from: c */
    public final zz2 f11c;

    public a03(FlowCollector flowCollector, CoroutineContext coroutineContext) {
        this.f9a = coroutineContext;
        this.f10b = ThreadContextKt.threadContextElements(coroutineContext);
        this.f11c = new zz2(flowCollector, null);
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        Object withContextUndispatched = ChannelFlowKt.withContextUndispatched(this.f9a, obj, this.f10b, this.f11c, continuation);
        if (withContextUndispatched == b51.getCOROUTINE_SUSPENDED()) {
            return withContextUndispatched;
        }
        return Unit.INSTANCE;
    }
}
