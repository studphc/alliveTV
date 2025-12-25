package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.ThrowingCollector;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class og0 {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m6571a(ThrowingCollector throwingCollector, Function3 function3, Throwable th, ContinuationImpl continuationImpl) {
        lg0 lg0Var;
        int i;
        try {
            if (continuationImpl instanceof lg0) {
                lg0 lg0Var2 = (lg0) continuationImpl;
                int i2 = lg0Var2.f22497f;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    lg0Var2.f22497f = i2 - Integer.MIN_VALUE;
                    lg0Var = lg0Var2;
                    Object obj = lg0Var.f22496e;
                    Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                    i = lg0Var.f22497f;
                    if (i == 0) {
                        if (i == 1) {
                            th = lg0Var.f22495d;
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        lg0Var.f22495d = th;
                        lg0Var.f22497f = 1;
                        if (function3.invoke(throwingCollector, th, lg0Var) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                }
            }
            if (i == 0) {
            }
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            if (th != null && th != th2) {
                ha0.addSuppressed(th2, th);
            }
            throw th2;
        }
        lg0Var = new ContinuationImpl(continuationImpl);
        Object obj2 = lg0Var.f22496e;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = lg0Var.f22497f;
    }
}
