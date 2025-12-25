package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes2.dex */
public final class zf0 extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f29346e;

    /* renamed from: f */
    public /* synthetic */ Object f29347f;

    /* renamed from: g */
    public final /* synthetic */ Flow f29348g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zf0(Flow flow, Continuation continuation) {
        super(2, continuation);
        this.f29348g = flow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        zf0 zf0Var = new zf0(this.f29348g, continuation);
        zf0Var.f29347f = obj;
        return zf0Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((zf0) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f29346e;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            C2029yq c2029yq = new C2029yq((ProducerScope) this.f29347f, 1);
            this.f29346e = 1;
            if (this.f29348g.collect(c2029yq, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
