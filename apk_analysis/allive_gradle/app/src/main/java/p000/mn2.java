package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.SharingCommand;

/* loaded from: classes2.dex */
public final class mn2 extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public /* synthetic */ Object f23008e;

    /* JADX WARN: Type inference failed for: r0v0, types: [mn2, kotlin.coroutines.Continuation, kotlin.coroutines.jvm.internal.SuspendLambda] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ?? suspendLambda = new SuspendLambda(2, continuation);
        suspendLambda.f23008e = obj;
        return suspendLambda;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((mn2) create((SharingCommand) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z;
        b51.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        if (((SharingCommand) this.f23008e) != SharingCommand.START) {
            z = true;
        } else {
            z = false;
        }
        return Boxing.boxBoolean(z);
    }
}
