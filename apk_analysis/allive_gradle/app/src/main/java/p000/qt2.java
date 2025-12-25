package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.channels.TickerChannelsKt;
import kotlinx.coroutines.channels.TickerChannelsKt$ticker$3$WhenMappings;
import kotlinx.coroutines.channels.TickerMode;

/* loaded from: classes2.dex */
public final class qt2 extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f25745e;

    /* renamed from: f */
    public /* synthetic */ Object f25746f;

    /* renamed from: g */
    public final /* synthetic */ TickerMode f25747g;

    /* renamed from: h */
    public final /* synthetic */ long f25748h;

    /* renamed from: i */
    public final /* synthetic */ long f25749i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qt2(TickerMode tickerMode, long j, long j2, Continuation continuation) {
        super(2, continuation);
        this.f25747g = tickerMode;
        this.f25748h = j;
        this.f25749i = j2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        qt2 qt2Var = new qt2(this.f25747g, this.f25748h, this.f25749i, continuation);
        qt2Var.f25746f = obj;
        return qt2Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((qt2) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f25745e;
        if (i != 0) {
            if (i == 1 || i == 2) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope = (ProducerScope) this.f25746f;
            int i2 = TickerChannelsKt$ticker$3$WhenMappings.$EnumSwitchMapping$0[this.f25747g.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    SendChannel channel = producerScope.getChannel();
                    this.f25745e = 2;
                    if (TickerChannelsKt.access$fixedDelayTicker(this.f25748h, this.f25749i, channel, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                SendChannel channel2 = producerScope.getChannel();
                this.f25745e = 1;
                if (TickerChannelsKt.access$fixedPeriodTicker(this.f25748h, this.f25749i, channel2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        return Unit.INSTANCE;
    }
}
