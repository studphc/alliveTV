package p000;

import androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager;
import androidx.privacysandbox.ads.adservices.adselection.ReportEventRequest;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* renamed from: g6 */
/* loaded from: classes.dex */
public final class C1221g6 extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f17552e;

    /* renamed from: f */
    public final /* synthetic */ C1500l6 f17553f;

    /* renamed from: g */
    public final /* synthetic */ ReportEventRequest f17554g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1221g6(C1500l6 c1500l6, ReportEventRequest reportEventRequest, Continuation continuation) {
        super(2, continuation);
        this.f17553f = c1500l6;
        this.f17554g = reportEventRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C1221g6(this.f17553f, this.f17554g, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1221g6) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f17552e;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            AdSelectionManager adSelectionManager = this.f17553f.f22354a;
            Intrinsics.checkNotNull(adSelectionManager);
            this.f17552e = 1;
            if (adSelectionManager.reportEvent(this.f17554g, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
