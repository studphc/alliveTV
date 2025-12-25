package p000;

import androidx.privacysandbox.ads.adservices.measurement.MeasurementManager;
import androidx.privacysandbox.ads.adservices.measurement.WebTriggerRegistrationRequest;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
public final class kk1 extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f20884e;

    /* renamed from: f */
    public final /* synthetic */ lk1 f20885f;

    /* renamed from: g */
    public final /* synthetic */ WebTriggerRegistrationRequest f20886g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kk1(lk1 lk1Var, WebTriggerRegistrationRequest webTriggerRegistrationRequest, Continuation continuation) {
        super(2, continuation);
        this.f20885f = lk1Var;
        this.f20886g = webTriggerRegistrationRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new kk1(this.f20885f, this.f20886g, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((kk1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f20884e;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            MeasurementManager measurementManager = this.f20885f.f22548a;
            this.f20884e = 1;
            if (measurementManager.registerWebTrigger(this.f20886g, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
