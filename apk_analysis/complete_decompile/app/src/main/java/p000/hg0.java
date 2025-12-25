package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes2.dex */
public final class hg0 extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f18052e;

    /* renamed from: f */
    public /* synthetic */ Object f18053f;

    /* renamed from: g */
    public final /* synthetic */ FlowCollector f18054g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hg0(FlowCollector flowCollector, Continuation continuation) {
        super(2, continuation);
        this.f18054g = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        hg0 hg0Var = new hg0(this.f18054g, continuation);
        hg0Var.f18053f = obj;
        return hg0Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((hg0) create(ChannelResult.m8867boximpl(((ChannelResult) obj).getHolder()), (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x003c  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object holder;
        Object obj2;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f18052e;
        if (i != 0) {
            if (i == 1) {
                obj2 = this.f18053f;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            holder = ((ChannelResult) this.f18053f).getHolder();
            if (!(holder instanceof ChannelResult.Failed)) {
                this.f18053f = holder;
                this.f18052e = 1;
                if (this.f18054g.emit(holder, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj2 = holder;
            }
            if (!(holder instanceof ChannelResult.Closed)) {
                ChannelResult.m8871exceptionOrNullimpl(holder);
                return Boxing.boxBoolean(false);
            }
            return Boxing.boxBoolean(true);
        }
        holder = obj2;
        if (!(holder instanceof ChannelResult.Closed)) {
        }
    }
}
