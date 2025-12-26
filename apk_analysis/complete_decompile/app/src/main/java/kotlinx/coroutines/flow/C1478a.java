package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.SharingStarted;
import p000.b51;
import p000.bi0;

/* renamed from: kotlinx.coroutines.flow.a */
/* loaded from: classes2.dex */
public final class C1478a extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f21973e;

    /* renamed from: f */
    public final /* synthetic */ SharingStarted f21974f;

    /* renamed from: g */
    public final /* synthetic */ Flow f21975g;

    /* renamed from: h */
    public final /* synthetic */ MutableSharedFlow f21976h;

    /* renamed from: i */
    public final /* synthetic */ Object f21977i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1478a(SharingStarted sharingStarted, Flow flow, MutableSharedFlow mutableSharedFlow, Object obj, Continuation continuation) {
        super(2, continuation);
        this.f21974f = sharingStarted;
        this.f21975g = flow;
        this.f21976h = mutableSharedFlow;
        this.f21977i = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C1478a(this.f21974f, this.f21975g, this.f21976h, this.f21977i, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1478a) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0060 A[RETURN] */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f21973e;
        Flow flow = this.f21975g;
        MutableSharedFlow mutableSharedFlow = this.f21976h;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3 && i != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    this.f21973e = 3;
                    if (flow.collect(mutableSharedFlow, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        SharingStarted.Companion companion = SharingStarted.INSTANCE;
        SharingStarted eagerly = companion.getEagerly();
        SharingStarted sharingStarted = this.f21974f;
        if (sharingStarted == eagerly) {
            this.f21973e = 1;
            if (flow.collect(mutableSharedFlow, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (sharingStarted == companion.getLazily()) {
            StateFlow<Integer> subscriptionCount = mutableSharedFlow.getSubscriptionCount();
            ?? suspendLambda = new SuspendLambda(2, null);
            this.f21973e = 2;
            if (FlowKt.first(subscriptionCount, suspendLambda, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            this.f21973e = 3;
            if (flow.collect(mutableSharedFlow, this) == coroutine_suspended) {
            }
        } else {
            Flow distinctUntilChanged = FlowKt.distinctUntilChanged(sharingStarted.command(mutableSharedFlow.getSubscriptionCount()));
            bi0 bi0Var = new bi0(flow, mutableSharedFlow, this.f21977i, null);
            this.f21973e = 4;
            if (FlowKt.collectLatest(distinctUntilChanged, bi0Var, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
