package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2$WhenMappings;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.SharingCommand;
import kotlinx.coroutines.internal.Symbol;

/* loaded from: classes2.dex */
public final class bi0 extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f8018e;

    /* renamed from: f */
    public /* synthetic */ Object f8019f;

    /* renamed from: g */
    public final /* synthetic */ Flow f8020g;

    /* renamed from: h */
    public final /* synthetic */ MutableSharedFlow f8021h;

    /* renamed from: i */
    public final /* synthetic */ Object f8022i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bi0(Flow flow, MutableSharedFlow mutableSharedFlow, Object obj, Continuation continuation) {
        super(2, continuation);
        this.f8020g = flow;
        this.f8021h = mutableSharedFlow;
        this.f8022i = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        bi0 bi0Var = new bi0(this.f8020g, this.f8021h, this.f8022i, continuation);
        bi0Var.f8019f = obj;
        return bi0Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((bi0) create((SharingCommand) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f8018e;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            int i2 = FlowKt__ShareKt$launchSharing$1$2$WhenMappings.$EnumSwitchMapping$0[((SharingCommand) this.f8019f).ordinal()];
            MutableSharedFlow mutableSharedFlow = this.f8021h;
            if (i2 != 1) {
                if (i2 == 3) {
                    Symbol symbol = SharedFlowKt.NO_VALUE;
                    Object obj2 = this.f8022i;
                    if (obj2 == symbol) {
                        mutableSharedFlow.resetReplayCache();
                    } else {
                        mutableSharedFlow.tryEmit(obj2);
                    }
                }
            } else {
                this.f8018e = 1;
                if (this.f8020g.collect(mutableSharedFlow, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        return Unit.INSTANCE;
    }
}
