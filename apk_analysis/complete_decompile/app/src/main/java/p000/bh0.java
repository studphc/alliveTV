package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes2.dex */
public final class bh0 implements FlowCollector {

    /* renamed from: a */
    public final /* synthetic */ Ref.IntRef f8014a;

    /* renamed from: b */
    public final /* synthetic */ int f8015b;

    /* renamed from: c */
    public final /* synthetic */ FlowCollector f8016c;

    public bh0(Ref.IntRef intRef, int i, FlowCollector flowCollector) {
        this.f8014a = intRef;
        this.f8015b = i;
        this.f8016c = flowCollector;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(Object obj, Continuation continuation) {
        ah0 ah0Var;
        int i;
        if (continuation instanceof ah0) {
            ah0Var = (ah0) continuation;
            int i2 = ah0Var.f187f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                ah0Var.f187f = i2 - Integer.MIN_VALUE;
                Object obj2 = ah0Var.f185d;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = ah0Var.f187f;
                if (i == 0) {
                    if (i != 1) {
                        if (i == 2) {
                            ResultKt.throwOnFailure(obj2);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj2);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj2);
                Ref.IntRef intRef = this.f8014a;
                int i3 = intRef.element + 1;
                intRef.element = i3;
                int i4 = this.f8015b;
                FlowCollector flowCollector = this.f8016c;
                if (i3 < i4) {
                    ah0Var.f187f = 1;
                    if (flowCollector.emit(obj, ah0Var) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                ah0Var.f187f = 2;
                if (dh0.m4583a(flowCollector, obj, ah0Var) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        ah0Var = new ah0(this, continuation);
        Object obj22 = ah0Var.f185d;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = ah0Var.f187f;
        if (i == 0) {
        }
    }
}
