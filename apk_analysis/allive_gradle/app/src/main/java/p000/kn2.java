package p000;

import kotlin.KotlinNothingValueException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

/* loaded from: classes2.dex */
public final class kn2 extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f20914e;

    /* renamed from: f */
    public /* synthetic */ Object f20915f;

    /* renamed from: g */
    public final /* synthetic */ StateFlow f20916g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kn2(StateFlow stateFlow, Continuation continuation) {
        super(2, continuation);
        this.f20916g = stateFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        kn2 kn2Var = new kn2(this.f20916g, continuation);
        kn2Var.f20915f = obj;
        return kn2Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((kn2) create((FlowCollector) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f20914e;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            jn2 jn2Var = new jn2(new Ref.BooleanRef(), (FlowCollector) this.f20915f);
            this.f20914e = 1;
            if (this.f20916g.collect(jn2Var, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        throw new KotlinNothingValueException();
    }
}
