package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharingCommand;

/* loaded from: classes2.dex */
public final class jn2 implements FlowCollector {

    /* renamed from: a */
    public final /* synthetic */ Ref.BooleanRef f20560a;

    /* renamed from: b */
    public final /* synthetic */ FlowCollector f20561b;

    public jn2(Ref.BooleanRef booleanRef, FlowCollector flowCollector) {
        this.f20560a = booleanRef;
        this.f20561b = flowCollector;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m5445a(int i, Continuation continuation) {
        in2 in2Var;
        int i2;
        if (continuation instanceof in2) {
            in2Var = (in2) continuation;
            int i3 = in2Var.f18478f;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                in2Var.f18478f = i3 - Integer.MIN_VALUE;
                Object obj = in2Var.f18476d;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i2 = in2Var.f18478f;
                if (i2 == 0) {
                    if (i2 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (i > 0) {
                        Ref.BooleanRef booleanRef = this.f20560a;
                        if (!booleanRef.element) {
                            booleanRef.element = true;
                            SharingCommand sharingCommand = SharingCommand.START;
                            in2Var.f18478f = 1;
                            if (this.f20561b.emit(sharingCommand, in2Var) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    }
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            }
        }
        in2Var = new in2(this, continuation);
        Object obj2 = in2Var.f18476d;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i2 = in2Var.f18478f;
        if (i2 == 0) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
        return m5445a(((Number) obj).intValue(), continuation);
    }
}
