package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

/* loaded from: classes2.dex */
public final class vh0 implements FlowCollector {

    /* renamed from: a */
    public final /* synthetic */ Ref.ObjectRef f27784a;

    /* renamed from: b */
    public final /* synthetic */ Function3 f27785b;

    public vh0(Ref.ObjectRef objectRef, Function3 function3) {
        this.f27784a = objectRef;
        this.f27785b = function3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(Object obj, Continuation continuation) {
        uh0 uh0Var;
        int i;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        T t;
        if (continuation instanceof uh0) {
            uh0Var = (uh0) continuation;
            int i2 = uh0Var.f27267g;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                uh0Var.f27267g = i2 - Integer.MIN_VALUE;
                Object obj2 = uh0Var.f27265e;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = uh0Var.f27267g;
                if (i == 0) {
                    if (i == 1) {
                        objectRef2 = uh0Var.f27264d;
                        ResultKt.throwOnFailure(obj2);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj2);
                    objectRef = this.f27784a;
                    T t2 = objectRef.element;
                    t = obj;
                    if (t2 != NullSurrogateKt.NULL) {
                        uh0Var.f27264d = objectRef;
                        uh0Var.f27267g = 1;
                        Object invoke = this.f27785b.invoke(t2, obj, uh0Var);
                        if (invoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj2 = invoke;
                        objectRef2 = objectRef;
                    }
                    objectRef.element = t;
                    return Unit.INSTANCE;
                }
                Object obj3 = obj2;
                objectRef = objectRef2;
                t = obj3;
                objectRef.element = t;
                return Unit.INSTANCE;
            }
        }
        uh0Var = new uh0(this, continuation);
        Object obj22 = uh0Var.f27265e;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = uh0Var.f27267g;
        if (i == 0) {
        }
        Object obj32 = obj22;
        objectRef = objectRef2;
        t = obj32;
        objectRef.element = t;
        return Unit.INSTANCE;
    }
}
