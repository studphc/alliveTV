package p000;

import java.util.Collection;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* renamed from: al */
/* loaded from: classes2.dex */
public final class C0022al implements FlowCollector {

    /* renamed from: a */
    public final /* synthetic */ int f251a;

    /* renamed from: b */
    public final /* synthetic */ Object f252b;

    public /* synthetic */ C0022al(int i, Object obj) {
        this.f251a = i;
        this.f252b = obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object m113a(Flow flow, Continuation continuation) {
        eh0 eh0Var;
        int i;
        if (continuation instanceof eh0) {
            eh0Var = (eh0) continuation;
            int i2 = eh0Var.f16824f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                eh0Var.f16824f = i2 - Integer.MIN_VALUE;
                Object obj = eh0Var.f16822d;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = eh0Var.f16824f;
                if (i == 0) {
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    eh0Var.f16824f = 1;
                    if (FlowKt.emitAll((FlowCollector) this.f252b, flow, eh0Var) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        eh0Var = new eh0(this, continuation);
        Object obj2 = eh0Var.f16822d;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = eh0Var.f16824f;
        if (i == 0) {
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0047  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(Object obj, Continuation continuation) {
        C2060zk c2060zk;
        int i;
        switch (this.f251a) {
            case 0:
                if (continuation instanceof C2060zk) {
                    c2060zk = (C2060zk) continuation;
                    int i2 = c2060zk.f29405f;
                    if ((i2 & Integer.MIN_VALUE) != 0) {
                        c2060zk.f29405f = i2 - Integer.MIN_VALUE;
                        Object obj2 = c2060zk.f29403d;
                        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                        i = c2060zk.f29405f;
                        if (i == 0) {
                            if (i == 1) {
                                ResultKt.throwOnFailure(obj2);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            ResultKt.throwOnFailure(obj2);
                            JobKt.ensureActive(c2060zk.getContext());
                            c2060zk.f29405f = 1;
                            if (((FlowCollector) this.f252b).emit(obj, c2060zk) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }
                c2060zk = new C2060zk(this, continuation);
                Object obj22 = c2060zk.f29403d;
                Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
                i = c2060zk.f29405f;
                if (i == 0) {
                }
                return Unit.INSTANCE;
            case 1:
                return m113a((Flow) obj, continuation);
            default:
                ((Collection) this.f252b).add(obj);
                return Unit.INSTANCE;
        }
    }
}
