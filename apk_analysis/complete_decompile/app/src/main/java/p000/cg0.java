package p000;

import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChildCancelledException;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

/* loaded from: classes2.dex */
public final class cg0 extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public /* synthetic */ Object f8354e;

    /* renamed from: f */
    public final /* synthetic */ Ref.ObjectRef f8355f;

    /* renamed from: g */
    public final /* synthetic */ ReceiveChannel f8356g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cg0(Ref.ObjectRef objectRef, ReceiveChannel receiveChannel, Continuation continuation) {
        super(2, continuation);
        this.f8355f = objectRef;
        this.f8356g = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        cg0 cg0Var = new cg0(this.f8355f, this.f8356g, continuation);
        cg0Var.f8354e = obj;
        return cg0Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((cg0) create(ChannelResult.m8867boximpl(((ChannelResult) obj).getHolder()), (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v7, types: [kotlinx.coroutines.internal.Symbol, T] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        b51.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        ?? holder = ((ChannelResult) this.f8354e).getHolder();
        boolean z = holder instanceof ChannelResult.Failed;
        Ref.ObjectRef objectRef = this.f8355f;
        if (!z) {
            objectRef.element = holder;
        }
        if (z) {
            Throwable m8871exceptionOrNullimpl = ChannelResult.m8871exceptionOrNullimpl(holder);
            if (m8871exceptionOrNullimpl == null) {
                this.f8356g.cancel((CancellationException) new ChildCancelledException());
                objectRef.element = NullSurrogateKt.DONE;
            } else {
                throw m8871exceptionOrNullimpl;
            }
        }
        return Unit.INSTANCE;
    }
}
