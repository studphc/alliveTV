package p000;

import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$2;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class zh0 {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m8416a(Flow flow, Object obj, Function3 function3, Continuation continuation) {
        oh0 oh0Var;
        int i;
        Ref.ObjectRef objectRef;
        if (continuation instanceof oh0) {
            oh0 oh0Var2 = (oh0) continuation;
            int i2 = oh0Var2.f23808f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                oh0Var2.f23808f = i2 - Integer.MIN_VALUE;
                oh0Var = oh0Var2;
                Object obj2 = oh0Var.f23807e;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = oh0Var.f23808f;
                if (i == 0) {
                    if (i == 1) {
                        objectRef = oh0Var.f23806d;
                        ResultKt.throwOnFailure(obj2);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj2);
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    objectRef2.element = obj;
                    FlowKt__ReduceKt$fold$2 flowKt__ReduceKt$fold$2 = new FlowKt__ReduceKt$fold$2(objectRef2, function3);
                    oh0Var.f23806d = objectRef2;
                    oh0Var.f23808f = 1;
                    if (flow.collect(flowKt__ReduceKt$fold$2, oh0Var) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef = objectRef2;
                }
                return objectRef.element;
            }
        }
        oh0Var = new ContinuationImpl(continuation);
        Object obj22 = oh0Var.f23807e;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = oh0Var.f23808f;
        if (i == 0) {
        }
        return objectRef.element;
    }
}
