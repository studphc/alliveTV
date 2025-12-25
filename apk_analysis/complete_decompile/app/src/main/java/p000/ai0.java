package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* loaded from: classes2.dex */
public final class ai0 extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public /* synthetic */ int f207e;

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.coroutines.Continuation, kotlin.coroutines.jvm.internal.SuspendLambda, ai0] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ?? suspendLambda = new SuspendLambda(2, continuation);
        suspendLambda.f207e = ((Number) obj).intValue();
        return suspendLambda;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ai0) create(Integer.valueOf(((Number) obj).intValue()), (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z;
        b51.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        if (this.f207e > 0) {
            z = true;
        } else {
            z = false;
        }
        return Boxing.boxBoolean(z);
    }
}
