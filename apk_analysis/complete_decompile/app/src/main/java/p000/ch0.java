package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.C1443xdf1aa1b6;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.flow.internal.FlowExceptions_commonKt;

/* loaded from: classes2.dex */
public final class ch0 extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f8365e;

    /* renamed from: f */
    public /* synthetic */ Object f8366f;

    /* renamed from: g */
    public final /* synthetic */ Flow f8367g;

    /* renamed from: h */
    public final /* synthetic */ Function3 f8368h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ch0(Flow flow, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.f8367g = flow;
        this.f8368h = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ch0 ch0Var = new ch0(this.f8367g, this.f8368h, continuation);
        ch0Var.f8366f = obj;
        return ch0Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ch0) create((FlowCollector) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        C1443xdf1aa1b6 c1443xdf1aa1b6;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f8365e;
        if (i != 0) {
            if (i == 1) {
                c1443xdf1aa1b6 = (C1443xdf1aa1b6) this.f8366f;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (AbortFlowException e) {
                    e = e;
                    FlowExceptions_commonKt.checkOwnership(e, c1443xdf1aa1b6);
                    return Unit.INSTANCE;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.f8366f;
            Flow flow = this.f8367g;
            C1443xdf1aa1b6 c1443xdf1aa1b62 = new C1443xdf1aa1b6(this.f8368h, flowCollector);
            try {
                this.f8366f = c1443xdf1aa1b62;
                this.f8365e = 1;
                if (flow.collect(c1443xdf1aa1b62, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (AbortFlowException e2) {
                e = e2;
                c1443xdf1aa1b6 = c1443xdf1aa1b62;
                FlowExceptions_commonKt.checkOwnership(e, c1443xdf1aa1b6);
                return Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }
}
