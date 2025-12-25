package p000;

import androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager;
import androidx.privacysandbox.ads.adservices.adselection.GetAdSelectionDataRequest;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* renamed from: e6 */
/* loaded from: classes.dex */
public final class C1147e6 extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f16679e;

    /* renamed from: f */
    public final /* synthetic */ C1500l6 f16680f;

    /* renamed from: g */
    public final /* synthetic */ GetAdSelectionDataRequest f16681g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1147e6(C1500l6 c1500l6, GetAdSelectionDataRequest getAdSelectionDataRequest, Continuation continuation) {
        super(2, continuation);
        this.f16680f = c1500l6;
        this.f16681g = getAdSelectionDataRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C1147e6(this.f16680f, this.f16681g, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1147e6) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f16679e;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            AdSelectionManager adSelectionManager = this.f16680f.f22354a;
            Intrinsics.checkNotNull(adSelectionManager);
            this.f16679e = 1;
            obj = adSelectionManager.getAdSelectionData(this.f16681g, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }
}
