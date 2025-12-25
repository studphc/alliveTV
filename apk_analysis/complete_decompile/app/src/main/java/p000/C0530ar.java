package p000;

import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.flow.internal.ChannelFlowKt;
import kotlinx.coroutines.flow.internal.FlowExceptions_commonKt;
import kotlinx.coroutines.internal.ThreadContextKt;

/* renamed from: ar */
/* loaded from: classes2.dex */
public final class C0530ar extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f7715e;

    /* renamed from: f */
    public /* synthetic */ Object f7716f;

    /* renamed from: g */
    public final /* synthetic */ FlowCollector f7717g;

    /* renamed from: h */
    public final /* synthetic */ Flow f7718h;

    /* renamed from: i */
    public final /* synthetic */ Flow f7719i;

    /* renamed from: j */
    public final /* synthetic */ Function3 f7720j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0530ar(FlowCollector flowCollector, Flow flow, Flow flow2, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.f7717g = flowCollector;
        this.f7718h = flow;
        this.f7719i = flow2;
        this.f7720j = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C0530ar c0530ar = new C0530ar(this.f7717g, this.f7718h, this.f7719i, this.f7720j, continuation);
        c0530ar.f7716f = obj;
        return c0530ar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C0530ar) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ReceiveChannel receiveChannel;
        ReceiveChannel receiveChannel2;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f7715e;
        FlowCollector flowCollector = this.f7717g;
        if (i != 0) {
            if (i == 1) {
                receiveChannel2 = (ReceiveChannel) this.f7716f;
                try {
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (AbortFlowException e) {
                        e = e;
                        FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                        ReceiveChannel.DefaultImpls.cancel$default(receiveChannel2, (CancellationException) null, 1, (Object) null);
                        return Unit.INSTANCE;
                    }
                } catch (Throwable th) {
                    th = th;
                    ReceiveChannel.DefaultImpls.cancel$default(receiveChannel2, (CancellationException) null, 1, (Object) null);
                    throw th;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.f7716f;
            ReceiveChannel produce$default = ProduceKt.produce$default(coroutineScope, null, 0, new C2066zq(this.f7718h, null), 3, null);
            CompletableJob Job$default = JobKt.Job$default((Job) null, 1, (Object) null);
            Intrinsics.checkNotNull(produce$default, "null cannot be cast to non-null type kotlinx.coroutines.channels.SendChannel<*>");
            ((SendChannel) produce$default).invokeOnClose(new C1807sq(0, Job$default, flowCollector));
            try {
                CoroutineContext coroutineContext = coroutineScope.getCoroutineContext();
                Object threadContextElements = ThreadContextKt.threadContextElements(coroutineContext);
                CoroutineContext plus = coroutineScope.getCoroutineContext().plus(Job$default);
                Unit unit = Unit.INSTANCE;
                C1955wq c1955wq = new C1955wq(this.f7719i, coroutineContext, threadContextElements, produce$default, this.f7717g, this.f7720j, null);
                this.f7716f = produce$default;
                this.f7715e = 1;
                receiveChannel = produce$default;
                try {
                    if (ChannelFlowKt.withContextUndispatched$default(plus, unit, null, c1955wq, this, 4, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    receiveChannel2 = receiveChannel;
                } catch (AbortFlowException e2) {
                    e = e2;
                    receiveChannel2 = receiveChannel;
                    FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                    ReceiveChannel.DefaultImpls.cancel$default(receiveChannel2, (CancellationException) null, 1, (Object) null);
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    receiveChannel2 = receiveChannel;
                    ReceiveChannel.DefaultImpls.cancel$default(receiveChannel2, (CancellationException) null, 1, (Object) null);
                    throw th;
                }
            } catch (AbortFlowException e3) {
                e = e3;
                receiveChannel = produce$default;
            } catch (Throwable th3) {
                th = th3;
                receiveChannel = produce$default;
            }
        }
        ReceiveChannel.DefaultImpls.cancel$default(receiveChannel2, (CancellationException) null, 1, (Object) null);
        return Unit.INSTANCE;
    }
}
