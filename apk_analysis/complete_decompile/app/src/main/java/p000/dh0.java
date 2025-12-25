package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$collector$1;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.flow.internal.FlowExceptions_commonKt;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class dh0 {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m4583a(FlowCollector flowCollector, Object obj, ContinuationImpl continuationImpl) {
        zg0 zg0Var;
        int i;
        FlowCollector flowCollector2;
        if (continuationImpl instanceof zg0) {
            zg0 zg0Var2 = (zg0) continuationImpl;
            int i2 = zg0Var2.f29370f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                zg0Var2.f29370f = i2 - Integer.MIN_VALUE;
                zg0Var = zg0Var2;
                Object obj2 = zg0Var.f29369e;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = zg0Var.f29370f;
                if (i == 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    FlowCollector flowCollector3 = zg0Var.f29368d;
                    ResultKt.throwOnFailure(obj2);
                    flowCollector2 = flowCollector3;
                } else {
                    ResultKt.throwOnFailure(obj2);
                    zg0Var.f29368d = flowCollector;
                    zg0Var.f29370f = 1;
                    Object emit = flowCollector.emit(obj, zg0Var);
                    flowCollector2 = flowCollector;
                    if (emit == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                throw new AbortFlowException(flowCollector2);
            }
        }
        zg0Var = new ContinuationImpl(continuationImpl);
        Object obj22 = zg0Var.f29369e;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = zg0Var.f29370f;
        if (i == 0) {
        }
        throw new AbortFlowException(flowCollector2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m4584b(Flow flow, Function2 function2, Continuation continuation) {
        ug0 ug0Var;
        int i;
        FlowKt__LimitKt$collectWhile$collector$1 flowKt__LimitKt$collectWhile$collector$1;
        if (continuation instanceof ug0) {
            ug0 ug0Var2 = (ug0) continuation;
            int i2 = ug0Var2.f27255f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                ug0Var2.f27255f = i2 - Integer.MIN_VALUE;
                ug0Var = ug0Var2;
                Object obj = ug0Var.f27254e;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = ug0Var.f27255f;
                if (i == 0) {
                    if (i == 1) {
                        flowKt__LimitKt$collectWhile$collector$1 = ug0Var.f27253d;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (AbortFlowException e) {
                            e = e;
                            FlowExceptions_commonKt.checkOwnership(e, flowKt__LimitKt$collectWhile$collector$1);
                            return Unit.INSTANCE;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    FlowKt__LimitKt$collectWhile$collector$1 flowKt__LimitKt$collectWhile$collector$12 = new FlowKt__LimitKt$collectWhile$collector$1(function2);
                    try {
                        ug0Var.f27253d = flowKt__LimitKt$collectWhile$collector$12;
                        ug0Var.f27255f = 1;
                        if (flow.collect(flowKt__LimitKt$collectWhile$collector$12, ug0Var) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } catch (AbortFlowException e2) {
                        e = e2;
                        flowKt__LimitKt$collectWhile$collector$1 = flowKt__LimitKt$collectWhile$collector$12;
                        FlowExceptions_commonKt.checkOwnership(e, flowKt__LimitKt$collectWhile$collector$1);
                        return Unit.INSTANCE;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        ug0Var = new ContinuationImpl(continuation);
        Object obj2 = ug0Var.f27254e;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = ug0Var.f27255f;
        if (i == 0) {
        }
        return Unit.INSTANCE;
    }
}
