package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

/* loaded from: classes2.dex */
public final class k50 implements FlowCollector {

    /* renamed from: a */
    public final /* synthetic */ l50 f20748a;

    /* renamed from: b */
    public final /* synthetic */ Ref.ObjectRef f20749b;

    /* renamed from: c */
    public final /* synthetic */ FlowCollector f20750c;

    public k50(l50 l50Var, Ref.ObjectRef objectRef, FlowCollector flowCollector) {
        this.f20748a = l50Var;
        this.f20749b = objectRef;
        this.f20750c = flowCollector;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Type inference failed for: r2v2, types: [T, java.lang.Object] */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(Object obj, Continuation continuation) {
        j50 j50Var;
        int i;
        if (continuation instanceof j50) {
            j50Var = (j50) continuation;
            int i2 = j50Var.f20376f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                j50Var.f20376f = i2 - Integer.MIN_VALUE;
                Object obj2 = j50Var.f20374d;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = j50Var.f20376f;
                if (i == 0) {
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj2);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj2);
                    l50 l50Var = this.f20748a;
                    ?? invoke = l50Var.f22326b.invoke(obj);
                    Ref.ObjectRef objectRef = this.f20749b;
                    T t = objectRef.element;
                    if (t != NullSurrogateKt.NULL && ((Boolean) l50Var.f22327c.invoke(t, invoke)).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                    objectRef.element = invoke;
                    j50Var.f20376f = 1;
                    if (this.f20750c.emit(obj, j50Var) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        j50Var = new j50(this, continuation);
        Object obj22 = j50Var.f20374d;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = j50Var.f20376f;
        if (i == 0) {
        }
        return Unit.INSTANCE;
    }
}
