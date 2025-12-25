package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;

/* renamed from: fm */
/* loaded from: classes2.dex */
public final class C1200fm extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f17315e;

    /* renamed from: f */
    public final /* synthetic */ ChannelFlowTransformLatest f17316f;

    /* renamed from: g */
    public final /* synthetic */ FlowCollector f17317g;

    /* renamed from: h */
    public final /* synthetic */ Object f17318h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1200fm(ChannelFlowTransformLatest channelFlowTransformLatest, FlowCollector flowCollector, Object obj, Continuation continuation) {
        super(2, continuation);
        this.f17316f = channelFlowTransformLatest;
        this.f17317g = flowCollector;
        this.f17318h = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C1200fm(this.f17316f, this.f17317g, this.f17318h, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1200fm) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f17315e;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            Function3 access$getTransform$p = ChannelFlowTransformLatest.access$getTransform$p(this.f17316f);
            this.f17315e = 1;
            if (access$getTransform$p.invoke(this.f17317g, this.f17318h, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
