package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.selects.SelectImplementation;

/* loaded from: classes2.dex */
public final class gg0 extends SuspendLambda implements Function3 {

    /* renamed from: e */
    public Ref.ObjectRef f17681e;

    /* renamed from: f */
    public ReceiveChannel f17682f;

    /* renamed from: g */
    public int f17683g;

    /* renamed from: h */
    public /* synthetic */ Object f17684h;

    /* renamed from: i */
    public /* synthetic */ Object f17685i;

    /* renamed from: j */
    public final /* synthetic */ long f17686j;

    /* renamed from: k */
    public final /* synthetic */ Flow f17687k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gg0(long j, Flow flow, Continuation continuation) {
        super(3, continuation);
        this.f17686j = j;
        this.f17687k = flow;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        gg0 gg0Var = new gg0(this.f17686j, this.f17687k, (Continuation) obj3);
        gg0Var.f17684h = (CoroutineScope) obj;
        gg0Var.f17685i = (FlowCollector) obj2;
        return gg0Var.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector;
        ReceiveChannel receiveChannel;
        Ref.ObjectRef objectRef;
        ReceiveChannel fixedPeriodTicker$default;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f17683g;
        if (i != 0) {
            if (i == 1) {
                fixedPeriodTicker$default = this.f17682f;
                objectRef = this.f17681e;
                receiveChannel = (ReceiveChannel) this.f17685i;
                flowCollector = (FlowCollector) this.f17684h;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.f17684h;
            FlowCollector flowCollector2 = (FlowCollector) this.f17685i;
            ReceiveChannel produce$default = ProduceKt.produce$default(coroutineScope, null, -1, new fg0(this.f17687k, null), 1, null);
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            flowCollector = flowCollector2;
            receiveChannel = produce$default;
            objectRef = objectRef2;
            fixedPeriodTicker$default = FlowKt.fixedPeriodTicker$default(coroutineScope, this.f17686j, 0L, 2, null);
        }
        while (objectRef.element != NullSurrogateKt.DONE) {
            SelectImplementation selectImplementation = new SelectImplementation(getContext());
            selectImplementation.invoke(receiveChannel.getOnReceiveCatching(), new cg0(objectRef, fixedPeriodTicker$default, null));
            selectImplementation.invoke(fixedPeriodTicker$default.getOnReceive(), new dg0(null, objectRef, flowCollector));
            this.f17684h = flowCollector;
            this.f17685i = receiveChannel;
            this.f17681e = objectRef;
            this.f17682f = fixedPeriodTicker$default;
            this.f17683g = 1;
            if (selectImplementation.doSelect(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
