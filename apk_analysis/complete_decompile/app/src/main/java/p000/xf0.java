package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

/* loaded from: classes2.dex */
public final class xf0 extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public Ref.ObjectRef f28532e;

    /* renamed from: f */
    public int f28533f;

    /* renamed from: g */
    public /* synthetic */ Object f28534g;

    /* renamed from: h */
    public final /* synthetic */ Ref.ObjectRef f28535h;

    /* renamed from: i */
    public final /* synthetic */ FlowCollector f28536i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xf0(Continuation continuation, Ref.ObjectRef objectRef, FlowCollector flowCollector) {
        super(2, continuation);
        this.f28535h = objectRef;
        this.f28536i = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        xf0 xf0Var = new xf0(continuation, this.f28535h, this.f28536i);
        xf0Var.f28534g = obj;
        return xf0Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((xf0) create(ChannelResult.m8867boximpl(((ChannelResult) obj).getHolder()), (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v7, types: [kotlinx.coroutines.internal.Symbol, T] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f28533f;
        if (i != 0) {
            if (i == 1) {
                objectRef2 = this.f28532e;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            ?? holder = ((ChannelResult) this.f28534g).getHolder();
            boolean z = holder instanceof ChannelResult.Failed;
            objectRef = this.f28535h;
            if (!z) {
                objectRef.element = holder;
            }
            if (z) {
                Throwable m8871exceptionOrNullimpl = ChannelResult.m8871exceptionOrNullimpl(holder);
                if (m8871exceptionOrNullimpl == null) {
                    Object obj2 = objectRef.element;
                    if (obj2 != null) {
                        if (obj2 == NullSurrogateKt.NULL) {
                            obj2 = null;
                        }
                        this.f28534g = holder;
                        this.f28532e = objectRef;
                        this.f28533f = 1;
                        if (this.f28536i.emit(obj2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        objectRef2 = objectRef;
                    }
                    objectRef.element = NullSurrogateKt.DONE;
                } else {
                    throw m8871exceptionOrNullimpl;
                }
            }
            return Unit.INSTANCE;
        }
        objectRef = objectRef2;
        objectRef.element = NullSurrogateKt.DONE;
        return Unit.INSTANCE;
    }
}
