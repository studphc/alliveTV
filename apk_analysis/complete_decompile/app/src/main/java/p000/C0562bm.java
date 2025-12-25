package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.internal.SendingCollector;
import kotlinx.coroutines.sync.Semaphore;

/* renamed from: bm */
/* loaded from: classes2.dex */
public final class C0562bm extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f8069e;

    /* renamed from: f */
    public final /* synthetic */ Flow f8070f;

    /* renamed from: g */
    public final /* synthetic */ SendingCollector f8071g;

    /* renamed from: h */
    public final /* synthetic */ Semaphore f8072h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0562bm(Flow flow, SendingCollector sendingCollector, Semaphore semaphore, Continuation continuation) {
        super(2, continuation);
        this.f8070f = flow;
        this.f8071g = sendingCollector;
        this.f8072h = semaphore;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C0562bm(this.f8070f, this.f8071g, this.f8072h, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C0562bm) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f8069e;
        Semaphore semaphore = this.f8072h;
        try {
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                Flow flow = this.f8070f;
                SendingCollector sendingCollector = this.f8071g;
                this.f8069e = 1;
                if (flow.collect(sendingCollector, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            semaphore.release();
            return Unit.INSTANCE;
        } catch (Throwable th) {
            semaphore.release();
            throw th;
        }
    }
}
