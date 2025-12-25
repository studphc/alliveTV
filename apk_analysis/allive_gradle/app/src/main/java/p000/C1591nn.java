package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ReceiveChannel;

/* renamed from: nn */
/* loaded from: classes2.dex */
public final class C1591nn extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public /* synthetic */ Object f23418e;

    /* renamed from: f */
    public final /* synthetic */ ReceiveChannel f23419f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1591nn(ReceiveChannel receiveChannel, Continuation continuation) {
        super(2, continuation);
        this.f23419f = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C1591nn c1591nn = new C1591nn(this.f23419f, continuation);
        c1591nn.f23418e = obj;
        return c1591nn;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1591nn) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        b51.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        Object obj2 = this.f23418e;
        if (obj2 != null) {
            return obj2;
        }
        throw new IllegalArgumentException("null element found in " + this.f23419f + '.');
    }
}
