package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

/* loaded from: classes2.dex */
public final class dg0 extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f16367e;

    /* renamed from: f */
    public final /* synthetic */ Ref.ObjectRef f16368f;

    /* renamed from: g */
    public final /* synthetic */ FlowCollector f16369g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dg0(Continuation continuation, Ref.ObjectRef objectRef, FlowCollector flowCollector) {
        super(2, continuation);
        this.f16368f = objectRef;
        this.f16369g = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new dg0(continuation, this.f16368f, this.f16369g);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((dg0) create((Unit) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f16367e;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef = this.f16368f;
            Object obj2 = objectRef.element;
            if (obj2 == null) {
                return Unit.INSTANCE;
            }
            objectRef.element = null;
            if (obj2 == NullSurrogateKt.NULL) {
                obj2 = null;
            }
            this.f16367e = 1;
            if (this.f16369g.emit(obj2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
