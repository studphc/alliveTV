package p000;

import androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager;
import androidx.privacysandbox.ads.adservices.adselection.UpdateAdCounterHistogramRequest;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* renamed from: k6 */
/* loaded from: classes.dex */
public final class C1380k6 extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f20756e;

    /* renamed from: f */
    public final /* synthetic */ C1500l6 f20757f;

    /* renamed from: g */
    public final /* synthetic */ UpdateAdCounterHistogramRequest f20758g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1380k6(C1500l6 c1500l6, UpdateAdCounterHistogramRequest updateAdCounterHistogramRequest, Continuation continuation) {
        super(2, continuation);
        this.f20757f = c1500l6;
        this.f20758g = updateAdCounterHistogramRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C1380k6(this.f20757f, this.f20758g, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1380k6) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f20756e;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            AdSelectionManager adSelectionManager = this.f20757f.f22354a;
            Intrinsics.checkNotNull(adSelectionManager);
            this.f20756e = 1;
            if (adSelectionManager.updateAdCounterHistogram(this.f20758g, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
