package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.SendChannel;

/* renamed from: jm */
/* loaded from: classes2.dex */
public final class C1359jm extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f20543e;

    /* renamed from: f */
    public final /* synthetic */ SendChannel f20544f;

    /* renamed from: g */
    public final /* synthetic */ Object f20545g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1359jm(SendChannel sendChannel, Object obj, Continuation continuation) {
        super(2, continuation);
        this.f20544f = sendChannel;
        this.f20545g = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C1359jm(this.f20544f, this.f20545g, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1359jm) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f20543e;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            this.f20543e = 1;
            if (this.f20544f.send(this.f20545g, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
