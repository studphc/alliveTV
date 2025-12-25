package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.selects.SelectBuilderImpl;
import kotlinx.coroutines.selects.SelectOldKt;

/* loaded from: classes2.dex */
public final class xf2 extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f28538e;

    /* renamed from: f */
    public final /* synthetic */ SelectBuilderImpl f28539f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xf2(SelectBuilderImpl selectBuilderImpl, Continuation continuation) {
        super(2, continuation);
        this.f28539f = selectBuilderImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new xf2(this.f28539f, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((xf2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CancellableContinuationImpl cancellableContinuationImpl;
        CancellableContinuationImpl cancellableContinuationImpl2;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f28538e;
        SelectBuilderImpl selectBuilderImpl = this.f28539f;
        try {
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                this.f28538e = 1;
                obj = selectBuilderImpl.doSelect(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            cancellableContinuationImpl2 = selectBuilderImpl.f22077g;
            SelectOldKt.access$resumeUndispatched(cancellableContinuationImpl2, obj);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            cancellableContinuationImpl = selectBuilderImpl.f22077g;
            SelectOldKt.access$resumeUndispatchedWithException(cancellableContinuationImpl, th);
            return Unit.INSTANCE;
        }
    }
}
