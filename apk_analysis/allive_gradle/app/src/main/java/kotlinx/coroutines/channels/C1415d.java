package kotlinx.coroutines.channels;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import p000.b51;

/* renamed from: kotlinx.coroutines.channels.d */
/* loaded from: classes2.dex */
public final class C1415d extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f21497e;

    /* renamed from: f */
    public /* synthetic */ Object f21498f;

    /* renamed from: g */
    public final /* synthetic */ SendChannel f21499g;

    /* renamed from: h */
    public final /* synthetic */ Object f21500h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1415d(SendChannel sendChannel, Object obj, Continuation continuation) {
        super(2, continuation);
        this.f21499g = sendChannel;
        this.f21500h = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C1415d c1415d = new C1415d(this.f21499g, this.f21500h, continuation);
        c1415d.f21498f = obj;
        return c1415d;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1415d) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m8512constructorimpl;
        Object m8880closedJP2dKIU;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f21497e;
        try {
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                SendChannel sendChannel = this.f21499g;
                Object obj2 = this.f21500h;
                Result.Companion companion = Result.INSTANCE;
                this.f21497e = 1;
                if (sendChannel.send(obj2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            m8512constructorimpl = Result.m8512constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m8512constructorimpl = Result.m8512constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m8518isSuccessimpl(m8512constructorimpl)) {
            m8880closedJP2dKIU = ChannelResult.INSTANCE.m8882successJP2dKIU(Unit.INSTANCE);
        } else {
            m8880closedJP2dKIU = ChannelResult.INSTANCE.m8880closedJP2dKIU(Result.m8515exceptionOrNullimpl(m8512constructorimpl));
        }
        return ChannelResult.m8867boximpl(m8880closedJP2dKIU);
    }
}
