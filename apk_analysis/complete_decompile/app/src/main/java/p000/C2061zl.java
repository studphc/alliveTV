package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.internal.ChannelFlow;

/* renamed from: zl */
/* loaded from: classes2.dex */
public final class C2061zl extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f29415e;

    /* renamed from: f */
    public /* synthetic */ Object f29416f;

    /* renamed from: g */
    public final /* synthetic */ ChannelFlow f29417g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2061zl(ChannelFlow channelFlow, Continuation continuation) {
        super(2, continuation);
        this.f29417g = channelFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C2061zl c2061zl = new C2061zl(this.f29417g, continuation);
        c2061zl.f29416f = obj;
        return c2061zl;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C2061zl) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f29415e;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope = (ProducerScope) this.f29416f;
            this.f29415e = 1;
            if (this.f29417g.collectTo(producerScope, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
