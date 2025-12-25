package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.ChannelFlowKt;

/* renamed from: vq */
/* loaded from: classes2.dex */
public final class C1918vq implements FlowCollector {

    /* renamed from: a */
    public final /* synthetic */ CoroutineContext f27914a;

    /* renamed from: b */
    public final /* synthetic */ Object f27915b;

    /* renamed from: c */
    public final /* synthetic */ ReceiveChannel f27916c;

    /* renamed from: d */
    public final /* synthetic */ FlowCollector f27917d;

    /* renamed from: e */
    public final /* synthetic */ Function3 f27918e;

    public C1918vq(CoroutineContext coroutineContext, Object obj, ReceiveChannel receiveChannel, FlowCollector flowCollector, Function3 function3) {
        this.f27914a = coroutineContext;
        this.f27915b = obj;
        this.f27916c = receiveChannel;
        this.f27917d = flowCollector;
        this.f27918e = function3;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(Object obj, Continuation continuation) {
        C1881uq c1881uq;
        int i;
        if (continuation instanceof C1881uq) {
            c1881uq = (C1881uq) continuation;
            int i2 = c1881uq.f27408f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c1881uq.f27408f = i2 - Integer.MIN_VALUE;
                Object obj2 = c1881uq.f27406d;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c1881uq.f27408f;
                if (i == 0) {
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj2);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj2);
                    Unit unit = Unit.INSTANCE;
                    C1844tq c1844tq = new C1844tq(this.f27916c, this.f27917d, this.f27918e, obj, null);
                    c1881uq.f27408f = 1;
                    if (ChannelFlowKt.withContextUndispatched(this.f27914a, unit, this.f27915b, c1844tq, c1881uq) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        c1881uq = new C1881uq(this, continuation);
        Object obj22 = c1881uq.f27406d;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c1881uq.f27408f;
        if (i == 0) {
        }
        return Unit.INSTANCE;
    }
}
