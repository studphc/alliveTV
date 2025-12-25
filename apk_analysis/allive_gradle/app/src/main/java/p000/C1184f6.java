package p000;

import androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager;
import androidx.privacysandbox.ads.adservices.adselection.PersistAdSelectionResultRequest;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* renamed from: f6 */
/* loaded from: classes.dex */
public final class C1184f6 extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f17136e;

    /* renamed from: f */
    public final /* synthetic */ C1500l6 f17137f;

    /* renamed from: g */
    public final /* synthetic */ PersistAdSelectionResultRequest f17138g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1184f6(C1500l6 c1500l6, PersistAdSelectionResultRequest persistAdSelectionResultRequest, Continuation continuation) {
        super(2, continuation);
        this.f17137f = c1500l6;
        this.f17138g = persistAdSelectionResultRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C1184f6(this.f17137f, this.f17138g, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1184f6) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f17136e;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            AdSelectionManager adSelectionManager = this.f17137f.f22354a;
            Intrinsics.checkNotNull(adSelectionManager);
            this.f17136e = 1;
            obj = adSelectionManager.persistAdSelectionResult(this.f17138g, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }
}
