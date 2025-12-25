package p000;

import androidx.privacysandbox.ads.adservices.customaudience.CustomAudienceManager;
import androidx.privacysandbox.ads.adservices.customaudience.FetchAndJoinCustomAudienceRequest;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* renamed from: cx */
/* loaded from: classes.dex */
public final class C1101cx extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f16161e;

    /* renamed from: f */
    public final /* synthetic */ C1211fx f16162f;

    /* renamed from: g */
    public final /* synthetic */ FetchAndJoinCustomAudienceRequest f16163g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1101cx(C1211fx c1211fx, FetchAndJoinCustomAudienceRequest fetchAndJoinCustomAudienceRequest, Continuation continuation) {
        super(2, continuation);
        this.f16162f = c1211fx;
        this.f16163g = fetchAndJoinCustomAudienceRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C1101cx(this.f16162f, this.f16163g, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1101cx) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f16161e;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CustomAudienceManager customAudienceManager = this.f16162f.f17424a;
            Intrinsics.checkNotNull(customAudienceManager);
            this.f16161e = 1;
            if (customAudienceManager.fetchAndJoinCustomAudience(this.f16163g, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
