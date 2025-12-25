package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes2.dex */
public final class fg0 extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f17255e;

    /* renamed from: f */
    public /* synthetic */ Object f17256f;

    /* renamed from: g */
    public final /* synthetic */ Flow f17257g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fg0(Flow flow, Continuation continuation) {
        super(2, continuation);
        this.f17257g = flow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        fg0 fg0Var = new fg0(this.f17257g, continuation);
        fg0Var.f17256f = obj;
        return fg0Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((fg0) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f17255e;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            C2029yq c2029yq = new C2029yq((ProducerScope) this.f17256f, 2);
            this.f17255e = 1;
            if (this.f17257g.collect(c2029yq, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
