package kotlinx.coroutines.flow.internal;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import p000.C1274hm;
import p000.b51;

/* renamed from: kotlinx.coroutines.flow.internal.a */
/* loaded from: classes2.dex */
public final class C1480a extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f21999e;

    /* renamed from: f */
    public /* synthetic */ Object f22000f;

    /* renamed from: g */
    public final /* synthetic */ ChannelFlowTransformLatest f22001g;

    /* renamed from: h */
    public final /* synthetic */ FlowCollector f22002h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1480a(ChannelFlowTransformLatest channelFlowTransformLatest, FlowCollector flowCollector, Continuation continuation) {
        super(2, continuation);
        this.f22001g = channelFlowTransformLatest;
        this.f22002h = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C1480a c1480a = new C1480a(this.f22001g, this.f22002h, continuation);
        c1480a.f22000f = obj;
        return c1480a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1480a) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f21999e;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.f22000f;
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ChannelFlowTransformLatest channelFlowTransformLatest = this.f22001g;
            Flow<S> flow = channelFlowTransformLatest.flow;
            C1274hm c1274hm = new C1274hm(objectRef, coroutineScope, channelFlowTransformLatest, this.f22002h);
            this.f21999e = 1;
            if (flow.collect(c1274hm, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
