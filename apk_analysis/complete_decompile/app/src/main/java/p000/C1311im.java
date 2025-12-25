package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.internal.SendingCollector;

/* renamed from: im */
/* loaded from: classes2.dex */
public final class C1311im extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f18460e;

    /* renamed from: f */
    public final /* synthetic */ Flow f18461f;

    /* renamed from: g */
    public final /* synthetic */ SendingCollector f18462g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1311im(Flow flow, SendingCollector sendingCollector, Continuation continuation) {
        super(2, continuation);
        this.f18461f = flow;
        this.f18462g = sendingCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C1311im(this.f18461f, this.f18462g, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1311im) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f18460e;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            this.f18460e = 1;
            if (this.f18461f.collect(this.f18462g, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
