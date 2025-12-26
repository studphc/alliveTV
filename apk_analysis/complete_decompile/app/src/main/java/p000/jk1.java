package p000;

import androidx.privacysandbox.ads.adservices.measurement.MeasurementManager;
import androidx.privacysandbox.ads.adservices.measurement.WebSourceRegistrationRequest;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
public final class jk1 extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f20530e;

    /* renamed from: f */
    public final /* synthetic */ lk1 f20531f;

    /* renamed from: g */
    public final /* synthetic */ WebSourceRegistrationRequest f20532g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jk1(lk1 lk1Var, WebSourceRegistrationRequest webSourceRegistrationRequest, Continuation continuation) {
        super(2, continuation);
        this.f20531f = lk1Var;
        this.f20532g = webSourceRegistrationRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new jk1(this.f20531f, this.f20532g, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((jk1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f20530e;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            MeasurementManager measurementManager = this.f20531f.f22548a;
            this.f20530e = 1;
            if (measurementManager.registerWebSource(this.f20532g, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
