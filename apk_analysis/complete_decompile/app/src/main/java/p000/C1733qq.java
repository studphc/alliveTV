package p000;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;

/* renamed from: qq */
/* loaded from: classes2.dex */
public final class C1733qq extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f25717e;

    /* renamed from: f */
    public final /* synthetic */ Flow[] f25718f;

    /* renamed from: g */
    public final /* synthetic */ int f25719g;

    /* renamed from: h */
    public final /* synthetic */ AtomicInteger f25720h;

    /* renamed from: i */
    public final /* synthetic */ Channel f25721i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1733qq(Flow[] flowArr, int i, AtomicInteger atomicInteger, Channel channel, Continuation continuation) {
        super(2, continuation);
        this.f25718f = flowArr;
        this.f25719g = i;
        this.f25720h = atomicInteger;
        this.f25721i = channel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C1733qq(this.f25718f, this.f25719g, this.f25720h, this.f25721i, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1733qq) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f25717e;
        AtomicInteger atomicInteger = this.f25720h;
        Channel channel = this.f25721i;
        try {
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                Flow[] flowArr = this.f25718f;
                int i2 = this.f25719g;
                Flow flow = flowArr[i2];
                C1696pq c1696pq = new C1696pq(channel, i2);
                this.f25717e = 1;
                if (flow.collect(c1696pq, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            if (atomicInteger.decrementAndGet() == 0) {
                SendChannel.DefaultImpls.close$default(channel, null, 1, null);
            }
            return Unit.INSTANCE;
        } finally {
            if (atomicInteger.decrementAndGet() == 0) {
                SendChannel.DefaultImpls.close$default(channel, null, 1, null);
            }
        }
    }
}
