package p000;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SubscribedFlowCollector;

/* loaded from: classes2.dex */
public final class yp2 implements SharedFlow {

    /* renamed from: a */
    public final SharedFlow f29059a;

    /* renamed from: b */
    public final Function2 f29060b;

    public yp2(SharedFlow sharedFlow, Function2 function2) {
        this.f29059a = sharedFlow;
        this.f29060b = function2;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object collect(FlowCollector flowCollector, Continuation continuation) {
        xp2 xp2Var;
        int i;
        if (continuation instanceof xp2) {
            xp2Var = (xp2) continuation;
            int i2 = xp2Var.f28681f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                xp2Var.f28681f = i2 - Integer.MIN_VALUE;
                Object obj = xp2Var.f28679d;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = xp2Var.f28681f;
                if (i == 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    SubscribedFlowCollector subscribedFlowCollector = new SubscribedFlowCollector(flowCollector, this.f29060b);
                    xp2Var.f28681f = 1;
                    if (this.f29059a.collect(subscribedFlowCollector, xp2Var) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                throw new KotlinNothingValueException();
            }
        }
        xp2Var = new xp2(this, continuation);
        Object obj2 = xp2Var.f28679d;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = xp2Var.f28681f;
        if (i == 0) {
        }
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.flow.SharedFlow
    public final List getReplayCache() {
        return this.f29059a.getReplayCache();
    }
}
