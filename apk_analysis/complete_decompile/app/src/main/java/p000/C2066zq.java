package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;

/* renamed from: zq */
/* loaded from: classes2.dex */
public final class C2066zq extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f29462e;

    /* renamed from: f */
    public /* synthetic */ Object f29463f;

    /* renamed from: g */
    public final /* synthetic */ Flow f29464g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2066zq(Flow flow, Continuation continuation) {
        super(2, continuation);
        this.f29464g = flow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C2066zq c2066zq = new C2066zq(this.f29464g, continuation);
        c2066zq.f29463f = obj;
        return c2066zq;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C2066zq) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f29462e;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            C2029yq c2029yq = new C2029yq((ProducerScope) this.f29463f, 0);
            this.f29462e = 1;
            if (this.f29464g.collect(c2029yq, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
