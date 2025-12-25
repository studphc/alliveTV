package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes2.dex */
public final class lf0 extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f22488e;

    /* renamed from: f */
    public /* synthetic */ Object f22489f;

    /* renamed from: g */
    public final /* synthetic */ Function3 f22490g;

    /* renamed from: h */
    public final /* synthetic */ FlowCollector f22491h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lf0(Function3 function3, FlowCollector flowCollector, Continuation continuation) {
        super(2, continuation);
        this.f22490g = function3;
        this.f22491h = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        lf0 lf0Var = new lf0(this.f22490g, this.f22491h, continuation);
        lf0Var.f22489f = obj;
        return lf0Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((lf0) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f22488e;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.f22489f;
            this.f22488e = 1;
            if (this.f22490g.invoke(coroutineScope, this.f22491h, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
