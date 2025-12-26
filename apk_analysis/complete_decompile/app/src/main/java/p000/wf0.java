package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;

/* loaded from: classes2.dex */
public final class wf0 extends SuspendLambda implements Function1 {

    /* renamed from: e */
    public int f28168e;

    /* renamed from: f */
    public final /* synthetic */ FlowCollector f28169f;

    /* renamed from: g */
    public final /* synthetic */ Ref.ObjectRef f28170g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wf0(Continuation continuation, Ref.ObjectRef objectRef, FlowCollector flowCollector) {
        super(1, continuation);
        this.f28169f = flowCollector;
        this.f28170g = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new wf0(continuation, this.f28170g, this.f28169f);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((wf0) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f28168e;
        Ref.ObjectRef objectRef = this.f28170g;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            Symbol symbol = NullSurrogateKt.NULL;
            Object obj2 = objectRef.element;
            if (obj2 == symbol) {
                obj2 = null;
            }
            this.f28168e = 1;
            if (this.f28169f.emit(obj2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        objectRef.element = null;
        return Unit.INSTANCE;
    }
}
