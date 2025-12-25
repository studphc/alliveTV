package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes2.dex */
public final class rg0 implements FlowCollector {

    /* renamed from: a */
    public final /* synthetic */ FlowCollector f25957a;

    /* renamed from: b */
    public final /* synthetic */ Ref.ObjectRef f25958b;

    public rg0(FlowCollector flowCollector, Ref.ObjectRef objectRef) {
        this.f25957a = flowCollector;
        this.f25958b = objectRef;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.Throwable, T] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.Throwable] */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(Object obj, Continuation continuation) {
        qg0 qg0Var;
        int i;
        rg0 rg0Var;
        if (continuation instanceof qg0) {
            qg0Var = (qg0) continuation;
            int i2 = qg0Var.f25575g;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                qg0Var.f25575g = i2 - Integer.MIN_VALUE;
                Object obj2 = qg0Var.f25573e;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = qg0Var.f25575g;
                if (i == 0) {
                    if (i == 1) {
                        rg0Var = qg0Var.f25572d;
                        try {
                            ResultKt.throwOnFailure(obj2);
                        } catch (Throwable th) {
                            th = th;
                            rg0Var.f25958b.element = th;
                            throw th;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj2);
                    try {
                        FlowCollector flowCollector = this.f25957a;
                        qg0Var.f25572d = this;
                        qg0Var.f25575g = 1;
                        if (flowCollector.emit(obj, qg0Var) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        rg0Var = this;
                        rg0Var.f25958b.element = th;
                        throw th;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        qg0Var = new qg0(this, continuation);
        Object obj22 = qg0Var.f25573e;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = qg0Var.f25575g;
        if (i == 0) {
        }
        return Unit.INSTANCE;
    }
}
