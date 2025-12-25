package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes2.dex */
public final class wg0 implements FlowCollector {

    /* renamed from: a */
    public final /* synthetic */ Ref.IntRef f28177a;

    /* renamed from: b */
    public final /* synthetic */ int f28178b;

    /* renamed from: c */
    public final /* synthetic */ FlowCollector f28179c;

    public wg0(Ref.IntRef intRef, int i, FlowCollector flowCollector) {
        this.f28177a = intRef;
        this.f28178b = i;
        this.f28179c = flowCollector;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(Object obj, Continuation continuation) {
        vg0 vg0Var;
        int i;
        if (continuation instanceof vg0) {
            vg0Var = (vg0) continuation;
            int i2 = vg0Var.f27774f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                vg0Var.f27774f = i2 - Integer.MIN_VALUE;
                Object obj2 = vg0Var.f27772d;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = vg0Var.f27774f;
                if (i == 0) {
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj2);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj2);
                    Ref.IntRef intRef = this.f28177a;
                    int i3 = intRef.element;
                    if (i3 >= this.f28178b) {
                        vg0Var.f27774f = 1;
                        if (this.f28179c.emit(obj, vg0Var) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        intRef.element = i3 + 1;
                        return Unit.INSTANCE;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        vg0Var = new vg0(this, continuation);
        Object obj22 = vg0Var.f27772d;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = vg0Var.f27774f;
        if (i == 0) {
        }
        return Unit.INSTANCE;
    }
}
