package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

/* loaded from: classes2.dex */
public final class hi0 implements FlowCollector {

    /* renamed from: a */
    public final /* synthetic */ Ref.ObjectRef f18063a;

    /* renamed from: b */
    public final /* synthetic */ Function3 f18064b;

    /* renamed from: c */
    public final /* synthetic */ FlowCollector f18065c;

    public hi0(Ref.ObjectRef objectRef, Function3 function3, FlowCollector flowCollector) {
        this.f18063a = objectRef;
        this.f18064b = function3;
        this.f18065c = flowCollector;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0074 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(Object obj, Continuation continuation) {
        gi0 gi0Var;
        Object coroutine_suspended;
        int i;
        Ref.ObjectRef objectRef;
        hi0 hi0Var;
        Ref.ObjectRef objectRef2;
        T t;
        FlowCollector flowCollector;
        T t2;
        if (continuation instanceof gi0) {
            gi0Var = (gi0) continuation;
            int i2 = gi0Var.f17708h;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                gi0Var.f17708h = i2 - Integer.MIN_VALUE;
                Object obj2 = gi0Var.f17706f;
                coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = gi0Var.f17708h;
                if (i == 0) {
                    if (i != 1) {
                        if (i == 2) {
                            ResultKt.throwOnFailure(obj2);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    objectRef2 = gi0Var.f17705e;
                    hi0Var = gi0Var.f17704d;
                    ResultKt.throwOnFailure(obj2);
                } else {
                    ResultKt.throwOnFailure(obj2);
                    objectRef = this.f18063a;
                    T t3 = objectRef.element;
                    if (t3 == NullSurrogateKt.NULL) {
                        hi0Var = this;
                        t = obj;
                        objectRef.element = t;
                        flowCollector = hi0Var.f18065c;
                        t2 = hi0Var.f18063a.element;
                        gi0Var.f17704d = null;
                        gi0Var.f17705e = null;
                        gi0Var.f17708h = 2;
                        if (flowCollector.emit(t2, gi0Var) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    gi0Var.f17704d = this;
                    gi0Var.f17705e = objectRef;
                    gi0Var.f17708h = 1;
                    Object invoke = this.f18064b.invoke(t3, obj, gi0Var);
                    if (invoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    hi0Var = this;
                    obj2 = invoke;
                    objectRef2 = objectRef;
                }
                Object obj3 = obj2;
                objectRef = objectRef2;
                t = obj3;
                objectRef.element = t;
                flowCollector = hi0Var.f18065c;
                t2 = hi0Var.f18063a.element;
                gi0Var.f17704d = null;
                gi0Var.f17705e = null;
                gi0Var.f17708h = 2;
                if (flowCollector.emit(t2, gi0Var) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            }
        }
        gi0Var = new gi0(this, continuation);
        Object obj22 = gi0Var.f17706f;
        coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        i = gi0Var.f17708h;
        if (i == 0) {
        }
        Object obj32 = obj22;
        objectRef = objectRef2;
        t = obj32;
        objectRef.element = t;
        flowCollector = hi0Var.f18065c;
        t2 = hi0Var.f18063a.element;
        gi0Var.f17704d = null;
        gi0Var.f17705e = null;
        gi0Var.f17708h = 2;
        if (flowCollector.emit(t2, gi0Var) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }
}
