package p000;

import kotlin.Function;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes2.dex */
public final class fh0 extends SuspendLambda implements Function3 {

    /* renamed from: e */
    public final /* synthetic */ int f17267e;

    /* renamed from: f */
    public int f17268f;

    /* renamed from: g */
    public /* synthetic */ FlowCollector f17269g;

    /* renamed from: h */
    public /* synthetic */ Object f17270h;

    /* renamed from: i */
    public final /* synthetic */ Function f17271i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ fh0(Function function, Continuation continuation, int i) {
        super(3, continuation);
        this.f17267e = i;
        this.f17271i = function;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        FlowCollector flowCollector = (FlowCollector) obj;
        switch (this.f17267e) {
            case 0:
                fh0 fh0Var = new fh0((Function2) this.f17271i, (Continuation) obj3, 0);
                fh0Var.f17269g = flowCollector;
                fh0Var.f17270h = obj2;
                return fh0Var.invokeSuspend(Unit.INSTANCE);
            default:
                fh0 fh0Var2 = new fh0((Function3) this.f17271i, (Continuation) obj3, 1);
                fh0Var2.f17269g = flowCollector;
                fh0Var2.f17270h = (Object[]) obj2;
                return fh0Var2.invokeSuspend(Unit.INSTANCE);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector;
        FlowCollector flowCollector2;
        switch (this.f17267e) {
            case 0:
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                int i = this.f17268f;
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    flowCollector = this.f17269g;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    flowCollector = this.f17269g;
                    Object obj2 = this.f17270h;
                    this.f17269g = flowCollector;
                    this.f17268f = 1;
                    obj = ((Function2) this.f17271i).invoke(obj2, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                this.f17269g = null;
                this.f17268f = 2;
                if (flowCollector.emit(obj, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            default:
                Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
                int i2 = this.f17268f;
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    flowCollector2 = this.f17269g;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    flowCollector2 = this.f17269g;
                    Object[] objArr = (Object[]) this.f17270h;
                    Object obj3 = objArr[0];
                    Object obj4 = objArr[1];
                    this.f17269g = flowCollector2;
                    this.f17268f = 1;
                    obj = ((Function3) this.f17271i).invoke(obj3, obj4, this);
                    if (obj == coroutine_suspended2) {
                        return coroutine_suspended2;
                    }
                }
                this.f17269g = null;
                this.f17268f = 2;
                if (flowCollector2.emit(obj, this) == coroutine_suspended2) {
                    return coroutine_suspended2;
                }
                return Unit.INSTANCE;
        }
    }
}
