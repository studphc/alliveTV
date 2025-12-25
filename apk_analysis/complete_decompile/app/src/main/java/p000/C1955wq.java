package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: wq */
/* loaded from: classes2.dex */
public final class C1955wq extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f28275e;

    /* renamed from: f */
    public final /* synthetic */ Flow f28276f;

    /* renamed from: g */
    public final /* synthetic */ CoroutineContext f28277g;

    /* renamed from: h */
    public final /* synthetic */ Object f28278h;

    /* renamed from: i */
    public final /* synthetic */ ReceiveChannel f28279i;

    /* renamed from: j */
    public final /* synthetic */ FlowCollector f28280j;

    /* renamed from: k */
    public final /* synthetic */ Function3 f28281k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1955wq(Flow flow, CoroutineContext coroutineContext, Object obj, ReceiveChannel receiveChannel, FlowCollector flowCollector, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.f28276f = flow;
        this.f28277g = coroutineContext;
        this.f28278h = obj;
        this.f28279i = receiveChannel;
        this.f28280j = flowCollector;
        this.f28281k = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C1955wq(this.f28276f, this.f28277g, this.f28278h, this.f28279i, this.f28280j, this.f28281k, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1955wq) create((Unit) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f28275e;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            C1918vq c1918vq = new C1918vq(this.f28277g, this.f28278h, this.f28279i, this.f28280j, this.f28281k);
            this.f28275e = 1;
            if (this.f28276f.collect(c1918vq, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
