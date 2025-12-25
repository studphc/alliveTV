package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes2.dex */
public final class ji0 implements FlowCollector {

    /* renamed from: a */
    public final /* synthetic */ FlowCollector f20508a;

    /* renamed from: b */
    public final /* synthetic */ Ref.IntRef f20509b;

    public ji0(FlowCollector flowCollector, Ref.IntRef intRef) {
        this.f20508a = flowCollector;
        this.f20509b = intRef;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(Object obj, Continuation continuation) {
        ii0 ii0Var;
        int i;
        if (continuation instanceof ii0) {
            ii0Var = (ii0) continuation;
            int i2 = ii0Var.f18420f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                ii0Var.f18420f = i2 - Integer.MIN_VALUE;
                Object obj2 = ii0Var.f18418d;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = ii0Var.f18420f;
                if (i == 0) {
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj2);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj2);
                    Ref.IntRef intRef = this.f20509b;
                    int i3 = intRef.element;
                    intRef.element = i3 + 1;
                    if (i3 >= 0) {
                        IndexedValue indexedValue = new IndexedValue(i3, obj);
                        ii0Var.f18420f = 1;
                        if (this.f20508a.emit(indexedValue, ii0Var) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        throw new ArithmeticException("Index overflow has happened");
                    }
                }
                return Unit.INSTANCE;
            }
        }
        ii0Var = new ii0(this, continuation);
        Object obj22 = ii0Var.f18418d;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = ii0Var.f18420f;
        if (i == 0) {
        }
        return Unit.INSTANCE;
    }
}
