package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes2.dex */
public final class fi0 implements FlowCollector {

    /* renamed from: a */
    public final /* synthetic */ Ref.ObjectRef f17274a;

    /* renamed from: b */
    public final /* synthetic */ Function3 f17275b;

    /* renamed from: c */
    public final /* synthetic */ FlowCollector f17276c;

    public fi0(Ref.ObjectRef objectRef, Function3 function3, FlowCollector flowCollector) {
        this.f17274a = objectRef;
        this.f17275b = function3;
        this.f17276c = flowCollector;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(Object obj, Continuation continuation) {
        ei0 ei0Var;
        Object coroutine_suspended;
        int i;
        fi0 fi0Var;
        T t;
        Ref.ObjectRef objectRef;
        FlowCollector flowCollector;
        T t2;
        if (continuation instanceof ei0) {
            ei0Var = (ei0) continuation;
            int i2 = ei0Var.f16834h;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                ei0Var.f16834h = i2 - Integer.MIN_VALUE;
                Object obj2 = ei0Var.f16832f;
                coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = ei0Var.f16834h;
                if (i == 0) {
                    if (i != 1) {
                        if (i == 2) {
                            ResultKt.throwOnFailure(obj2);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    objectRef = ei0Var.f16831e;
                    fi0Var = ei0Var.f16830d;
                    ResultKt.throwOnFailure(obj2);
                    t = obj2;
                } else {
                    ResultKt.throwOnFailure(obj2);
                    Ref.ObjectRef objectRef2 = this.f17274a;
                    T t3 = objectRef2.element;
                    ei0Var.f16830d = this;
                    ei0Var.f16831e = objectRef2;
                    ei0Var.f16834h = 1;
                    Object invoke = this.f17275b.invoke(t3, obj, ei0Var);
                    if (invoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    fi0Var = this;
                    t = invoke;
                    objectRef = objectRef2;
                }
                objectRef.element = t;
                flowCollector = fi0Var.f17276c;
                t2 = fi0Var.f17274a.element;
                ei0Var.f16830d = null;
                ei0Var.f16831e = null;
                ei0Var.f16834h = 2;
                if (flowCollector.emit(t2, ei0Var) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        ei0Var = new ei0(this, continuation);
        Object obj22 = ei0Var.f16832f;
        coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        i = ei0Var.f16834h;
        if (i == 0) {
        }
        objectRef.element = t;
        flowCollector = fi0Var.f17276c;
        t2 = fi0Var.f17274a.element;
        ei0Var.f16830d = null;
        ei0Var.f16831e = null;
        ei0Var.f16834h = 2;
        if (flowCollector.emit(t2, ei0Var) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }
}
