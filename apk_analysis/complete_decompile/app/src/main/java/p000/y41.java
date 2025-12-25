package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.InterruptibleKt;

/* loaded from: classes2.dex */
public final class y41 extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public /* synthetic */ Object f28837e;

    /* renamed from: f */
    public final /* synthetic */ Function0 f28838f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y41(Function0 function0, Continuation continuation) {
        super(2, continuation);
        this.f28838f = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        y41 y41Var = new y41(this.f28838f, continuation);
        y41Var.f28837e = obj;
        return y41Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((y41) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        b51.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        return InterruptibleKt.access$runInterruptibleInExpectedContext(((CoroutineScope) this.f28837e).getCoroutineContext(), this.f28838f);
    }
}
