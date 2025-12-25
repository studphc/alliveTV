package p000;

import androidx.privacysandbox.ads.adservices.customaudience.CustomAudienceManager;
import androidx.privacysandbox.ads.adservices.customaudience.JoinCustomAudienceRequest;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* renamed from: dx */
/* loaded from: classes.dex */
public final class C1137dx extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f16570e;

    /* renamed from: f */
    public final /* synthetic */ C1211fx f16571f;

    /* renamed from: g */
    public final /* synthetic */ JoinCustomAudienceRequest f16572g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1137dx(C1211fx c1211fx, JoinCustomAudienceRequest joinCustomAudienceRequest, Continuation continuation) {
        super(2, continuation);
        this.f16571f = c1211fx;
        this.f16572g = joinCustomAudienceRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C1137dx(this.f16571f, this.f16572g, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1137dx) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f16570e;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CustomAudienceManager customAudienceManager = this.f16571f.f17424a;
            Intrinsics.checkNotNull(customAudienceManager);
            this.f16570e = 1;
            if (customAudienceManager.joinCustomAudience(this.f16572g, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
