package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.selects.SelectOldKt;
import kotlinx.coroutines.selects.UnbiasedSelectBuilderImpl;

/* loaded from: classes2.dex */
public final class vz2 extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f28019e;

    /* renamed from: f */
    public final /* synthetic */ UnbiasedSelectBuilderImpl f28020f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vz2(UnbiasedSelectBuilderImpl unbiasedSelectBuilderImpl, Continuation continuation) {
        super(2, continuation);
        this.f28020f = unbiasedSelectBuilderImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new vz2(this.f28020f, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((vz2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CancellableContinuationImpl cancellableContinuationImpl;
        CancellableContinuationImpl cancellableContinuationImpl2;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f28019e;
        UnbiasedSelectBuilderImpl unbiasedSelectBuilderImpl = this.f28020f;
        try {
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                this.f28019e = 1;
                obj = unbiasedSelectBuilderImpl.doSelect(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            cancellableContinuationImpl2 = unbiasedSelectBuilderImpl.f22108h;
            SelectOldKt.access$resumeUndispatched(cancellableContinuationImpl2, obj);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            cancellableContinuationImpl = unbiasedSelectBuilderImpl.f22108h;
            SelectOldKt.access$resumeUndispatchedWithException(cancellableContinuationImpl, th);
            return Unit.INSTANCE;
        }
    }
}
