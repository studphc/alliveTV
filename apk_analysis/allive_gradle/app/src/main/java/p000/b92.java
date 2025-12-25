package p000;

import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.CancellableFlow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.flow.internal.FusibleFlow;

/* loaded from: classes2.dex */
public final class b92 implements StateFlow, CancellableFlow, FusibleFlow {

    /* renamed from: a */
    public final Job f7938a;

    /* renamed from: b */
    public final /* synthetic */ MutableStateFlow f7939b;

    public b92(MutableStateFlow mutableStateFlow, Job job) {
        this.f7938a = job;
        this.f7939b = mutableStateFlow;
    }

    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector, Continuation continuation) {
        return this.f7939b.collect(flowCollector, continuation);
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public final Flow fuse(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        return StateFlowKt.fuseStateFlow(this, coroutineContext, i, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.SharedFlow
    public final List getReplayCache() {
        return this.f7939b.getReplayCache();
    }

    @Override // kotlinx.coroutines.flow.StateFlow
    public final Object getValue() {
        return this.f7939b.getValue();
    }
}
