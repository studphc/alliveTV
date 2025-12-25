package p000;

import androidx.privacysandbox.ads.adservices.adselection.AdSelectionConfig;
import androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* renamed from: i6 */
/* loaded from: classes.dex */
public final class C1295i6 extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f18313e;

    /* renamed from: f */
    public final /* synthetic */ C1500l6 f18314f;

    /* renamed from: g */
    public final /* synthetic */ AdSelectionConfig f18315g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1295i6(C1500l6 c1500l6, AdSelectionConfig adSelectionConfig, Continuation continuation) {
        super(2, continuation);
        this.f18314f = c1500l6;
        this.f18315g = adSelectionConfig;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C1295i6(this.f18314f, this.f18315g, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1295i6) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f18313e;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            AdSelectionManager adSelectionManager = this.f18314f.f22354a;
            Intrinsics.checkNotNull(adSelectionManager);
            this.f18313e = 1;
            obj = adSelectionManager.selectAds(this.f18315g, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }
}
