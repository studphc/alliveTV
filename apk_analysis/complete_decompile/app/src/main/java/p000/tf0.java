package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes2.dex */
public final class tf0 implements FlowCollector {

    /* renamed from: a */
    public final /* synthetic */ Function2 f26800a;

    /* renamed from: b */
    public final /* synthetic */ Ref.IntRef f26801b;

    public tf0(Function2 function2, Ref.IntRef intRef) {
        this.f26800a = function2;
        this.f26801b = intRef;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(Object obj, Continuation continuation) {
        sf0 sf0Var;
        Object obj2;
        int i;
        tf0 tf0Var;
        if (continuation instanceof sf0) {
            sf0Var = (sf0) continuation;
            int i2 = sf0Var.f26406g;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                sf0Var.f26406g = i2 - Integer.MIN_VALUE;
                obj2 = sf0Var.f26404e;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = sf0Var.f26406g;
                if (i == 0) {
                    if (i == 1) {
                        tf0Var = sf0Var.f26403d;
                        ResultKt.throwOnFailure(obj2);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj2);
                    sf0Var.f26403d = this;
                    sf0Var.f26406g = 1;
                    obj2 = this.f26800a.invoke(obj, sf0Var);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    tf0Var = this;
                }
                if (((Boolean) obj2).booleanValue()) {
                    tf0Var.f26801b.element++;
                }
                return Unit.INSTANCE;
            }
        }
        sf0Var = new sf0(this, continuation);
        obj2 = sf0Var.f26404e;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = sf0Var.f26406g;
        if (i == 0) {
        }
        if (((Boolean) obj2).booleanValue()) {
        }
        return Unit.INSTANCE;
    }
}
