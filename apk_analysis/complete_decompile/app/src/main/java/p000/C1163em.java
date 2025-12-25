package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.ChannelFlowOperator;

/* renamed from: em */
/* loaded from: classes2.dex */
public final class C1163em extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f16891e;

    /* renamed from: f */
    public /* synthetic */ Object f16892f;

    /* renamed from: g */
    public final /* synthetic */ ChannelFlowOperator f16893g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1163em(ChannelFlowOperator channelFlowOperator, Continuation continuation) {
        super(2, continuation);
        this.f16893g = channelFlowOperator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C1163em c1163em = new C1163em(this.f16893g, continuation);
        c1163em.f16892f = obj;
        return c1163em;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1163em) create((FlowCollector) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f16891e;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.f16892f;
            this.f16891e = 1;
            if (this.f16893g.flowCollect(flowCollector, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
