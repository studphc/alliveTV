package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* renamed from: ym */
/* loaded from: classes2.dex */
public final class C2025ym extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public /* synthetic */ Object f29016e;

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.coroutines.Continuation, ym, kotlin.coroutines.jvm.internal.SuspendLambda] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ?? suspendLambda = new SuspendLambda(2, continuation);
        suspendLambda.f29016e = obj;
        return suspendLambda;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C2025ym) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z;
        b51.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        if (this.f29016e != null) {
            z = true;
        } else {
            z = false;
        }
        return Boxing.boxBoolean(z);
    }
}
