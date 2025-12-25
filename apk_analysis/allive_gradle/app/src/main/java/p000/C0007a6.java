package p000;

import androidx.privacysandbox.ads.adservices.adid.AdIdManager;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* renamed from: a6 */
/* loaded from: classes.dex */
public final class C0007a6 extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f50e;

    /* renamed from: f */
    public final /* synthetic */ C0546b6 f51f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0007a6(C0546b6 c0546b6, Continuation continuation) {
        super(2, continuation);
        this.f51f = c0546b6;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C0007a6(this.f51f, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C0007a6) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f50e;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            AdIdManager adIdManager = this.f51f.f7905a;
            this.f50e = 1;
            obj = adIdManager.getAdId(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }
}
