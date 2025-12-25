package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes2.dex */
public final class zz2 extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f29587e;

    /* renamed from: f */
    public /* synthetic */ Object f29588f;

    /* renamed from: g */
    public final /* synthetic */ FlowCollector f29589g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zz2(FlowCollector flowCollector, Continuation continuation) {
        super(2, continuation);
        this.f29589g = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        zz2 zz2Var = new zz2(this.f29589g, continuation);
        zz2Var.f29588f = obj;
        return zz2Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((zz2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f29587e;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            Object obj2 = this.f29588f;
            this.f29587e = 1;
            if (this.f29589g.emit(obj2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
