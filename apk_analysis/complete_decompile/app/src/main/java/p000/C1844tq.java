package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

/* renamed from: tq */
/* loaded from: classes2.dex */
public final class C1844tq extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public FlowCollector f26919e;

    /* renamed from: f */
    public int f26920f;

    /* renamed from: g */
    public final /* synthetic */ ReceiveChannel f26921g;

    /* renamed from: h */
    public final /* synthetic */ FlowCollector f26922h;

    /* renamed from: i */
    public final /* synthetic */ Function3 f26923i;

    /* renamed from: j */
    public final /* synthetic */ Object f26924j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1844tq(ReceiveChannel receiveChannel, FlowCollector flowCollector, Function3 function3, Object obj, Continuation continuation) {
        super(2, continuation);
        this.f26921g = receiveChannel;
        this.f26922h = flowCollector;
        this.f26923i = function3;
        this.f26924j = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C1844tq(this.f26921g, this.f26922h, this.f26923i, this.f26924j, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1844tq) create((Unit) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x006d A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object mo8860receiveCatchingJP2dKIU;
        FlowCollector flowCollector;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f26920f;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                flowCollector = this.f26919e;
                ResultKt.throwOnFailure(obj);
                this.f26919e = null;
                this.f26920f = 3;
                if (flowCollector.emit(obj, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            mo8860receiveCatchingJP2dKIU = ((ChannelResult) obj).getHolder();
        } else {
            ResultKt.throwOnFailure(obj);
            this.f26920f = 1;
            mo8860receiveCatchingJP2dKIU = this.f26921g.mo8860receiveCatchingJP2dKIU(this);
            if (mo8860receiveCatchingJP2dKIU == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        boolean z = mo8860receiveCatchingJP2dKIU instanceof ChannelResult.Failed;
        FlowCollector flowCollector2 = this.f26922h;
        if (z) {
            Throwable m8871exceptionOrNullimpl = ChannelResult.m8871exceptionOrNullimpl(mo8860receiveCatchingJP2dKIU);
            if (m8871exceptionOrNullimpl == null) {
                throw new AbortFlowException(flowCollector2);
            }
            throw m8871exceptionOrNullimpl;
        }
        if (mo8860receiveCatchingJP2dKIU == NullSurrogateKt.NULL) {
            mo8860receiveCatchingJP2dKIU = null;
        }
        this.f26919e = flowCollector2;
        this.f26920f = 2;
        obj = this.f26923i.invoke(this.f26924j, mo8860receiveCatchingJP2dKIU, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        flowCollector = flowCollector2;
        this.f26919e = null;
        this.f26920f = 3;
        if (flowCollector.emit(obj, this) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }
}
