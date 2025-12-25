package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes2.dex */
public final class yg0 implements FlowCollector {

    /* renamed from: a */
    public final /* synthetic */ Ref.BooleanRef f28944a;

    /* renamed from: b */
    public final /* synthetic */ FlowCollector f28945b;

    /* renamed from: c */
    public final /* synthetic */ Function2 f28946c;

    public yg0(Ref.BooleanRef booleanRef, FlowCollector flowCollector, Function2 function2) {
        this.f28944a = booleanRef;
        this.f28945b = flowCollector;
        this.f28946c = function2;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(Object obj, Continuation continuation) {
        xg0 xg0Var;
        int i;
        yg0 yg0Var;
        if (continuation instanceof xg0) {
            xg0Var = (xg0) continuation;
            int i2 = xg0Var.f28547h;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                xg0Var.f28547h = i2 - Integer.MIN_VALUE;
                Object obj2 = xg0Var.f28545f;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = xg0Var.f28547h;
                if (i == 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i == 3) {
                                ResultKt.throwOnFailure(obj2);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            obj = xg0Var.f28544e;
                            yg0Var = xg0Var.f28543d;
                            ResultKt.throwOnFailure(obj2);
                            if (((Boolean) obj2).booleanValue()) {
                                yg0Var.f28944a.element = true;
                                xg0Var.f28543d = null;
                                xg0Var.f28544e = null;
                                xg0Var.f28547h = 3;
                                if (yg0Var.f28945b.emit(obj, xg0Var) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                return Unit.INSTANCE;
                            }
                        }
                    } else {
                        ResultKt.throwOnFailure(obj2);
                        return Unit.INSTANCE;
                    }
                } else {
                    ResultKt.throwOnFailure(obj2);
                    if (this.f28944a.element) {
                        xg0Var.f28547h = 1;
                        if (this.f28945b.emit(obj, xg0Var) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    xg0Var.f28543d = this;
                    xg0Var.f28544e = obj;
                    xg0Var.f28547h = 2;
                    obj2 = this.f28946c.invoke(obj, xg0Var);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    yg0Var = this;
                    if (((Boolean) obj2).booleanValue()) {
                    }
                }
                return Unit.INSTANCE;
            }
        }
        xg0Var = new xg0(this, continuation);
        Object obj22 = xg0Var.f28545f;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = xg0Var.f28547h;
        if (i == 0) {
        }
        return Unit.INSTANCE;
    }
}
