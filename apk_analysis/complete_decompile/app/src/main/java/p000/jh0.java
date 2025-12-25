package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes2.dex */
public final class jh0 extends SuspendLambda implements Function3 {

    /* renamed from: e */
    public int f20501e;

    /* renamed from: f */
    public /* synthetic */ FlowCollector f20502f;

    /* renamed from: g */
    public /* synthetic */ Throwable f20503g;

    /* renamed from: h */
    public final /* synthetic */ Function1 f20504h;

    /* renamed from: i */
    public final /* synthetic */ Object f20505i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jh0(Continuation continuation, Object obj, Function1 function1) {
        super(3, continuation);
        this.f20504h = function1;
        this.f20505i = obj;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        jh0 jh0Var = new jh0((Continuation) obj3, this.f20505i, this.f20504h);
        jh0Var.f20502f = (FlowCollector) obj;
        jh0Var.f20503g = (Throwable) obj2;
        return jh0Var.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f20501e;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = this.f20502f;
            Throwable th = this.f20503g;
            if (((Boolean) this.f20504h.invoke(th)).booleanValue()) {
                this.f20502f = null;
                this.f20501e = 1;
                if (flowCollector.emit(this.f20505i, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                throw th;
            }
        }
        return Unit.INSTANCE;
    }
}
