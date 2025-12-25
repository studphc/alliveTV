package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.internal.ChannelFlow;

/* renamed from: yl */
/* loaded from: classes2.dex */
public final class C2024yl extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f29008e;

    /* renamed from: f */
    public /* synthetic */ Object f29009f;

    /* renamed from: g */
    public final /* synthetic */ FlowCollector f29010g;

    /* renamed from: h */
    public final /* synthetic */ ChannelFlow f29011h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2024yl(FlowCollector flowCollector, ChannelFlow channelFlow, Continuation continuation) {
        super(2, continuation);
        this.f29010g = flowCollector;
        this.f29011h = channelFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C2024yl c2024yl = new C2024yl(this.f29010g, this.f29011h, continuation);
        c2024yl.f29009f = obj;
        return c2024yl;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C2024yl) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f29008e;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            ReceiveChannel produceImpl = this.f29011h.produceImpl((CoroutineScope) this.f29009f);
            this.f29008e = 1;
            if (FlowKt.emitAll(this.f29010g, produceImpl, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
