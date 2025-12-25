package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes2.dex */
public final class ng0 implements FlowCollector {

    /* renamed from: a */
    public final /* synthetic */ Ref.BooleanRef f23351a;

    /* renamed from: b */
    public final /* synthetic */ FlowCollector f23352b;

    public ng0(Ref.BooleanRef booleanRef, FlowCollector flowCollector) {
        this.f23351a = booleanRef;
        this.f23352b = flowCollector;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(Object obj, Continuation continuation) {
        mg0 mg0Var;
        int i;
        if (continuation instanceof mg0) {
            mg0Var = (mg0) continuation;
            int i2 = mg0Var.f22929f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                mg0Var.f22929f = i2 - Integer.MIN_VALUE;
                Object obj2 = mg0Var.f22927d;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = mg0Var.f22929f;
                if (i == 0) {
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj2);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj2);
                    this.f23351a.element = false;
                    mg0Var.f22929f = 1;
                    if (this.f23352b.emit(obj, mg0Var) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        mg0Var = new mg0(this, continuation);
        Object obj22 = mg0Var.f22927d;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = mg0Var.f22929f;
        if (i == 0) {
        }
        return Unit.INSTANCE;
    }
}
