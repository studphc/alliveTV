package p000;

import androidx.privacysandbox.ads.adservices.customaudience.CustomAudienceManager;
import androidx.privacysandbox.ads.adservices.customaudience.LeaveCustomAudienceRequest;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* renamed from: ex */
/* loaded from: classes.dex */
public final class C1174ex extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f17012e;

    /* renamed from: f */
    public final /* synthetic */ C1211fx f17013f;

    /* renamed from: g */
    public final /* synthetic */ LeaveCustomAudienceRequest f17014g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1174ex(C1211fx c1211fx, LeaveCustomAudienceRequest leaveCustomAudienceRequest, Continuation continuation) {
        super(2, continuation);
        this.f17013f = c1211fx;
        this.f17014g = leaveCustomAudienceRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C1174ex(this.f17013f, this.f17014g, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1174ex) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f17012e;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CustomAudienceManager customAudienceManager = this.f17013f.f17424a;
            Intrinsics.checkNotNull(customAudienceManager);
            this.f17012e = 1;
            if (customAudienceManager.leaveCustomAudience(this.f17014g, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
