package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.time.Duration;
import kotlinx.coroutines.TimeoutCancellationException;

/* loaded from: classes2.dex */
public final class ig0 extends SuspendLambda implements Function1 {

    /* renamed from: e */
    public final /* synthetic */ long f18402e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ig0(long j, Continuation continuation) {
        super(1, continuation);
        this.f18402e = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new ig0(this.f18402e, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ((ig0) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
        throw null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        b51.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        throw new TimeoutCancellationException("Timed out waiting for " + ((Object) Duration.m8763toStringimpl(this.f18402e)));
    }
}
