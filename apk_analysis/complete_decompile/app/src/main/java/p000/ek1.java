package p000;

import androidx.privacysandbox.ads.adservices.measurement.DeletionRequest;
import androidx.privacysandbox.ads.adservices.measurement.MeasurementManager;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
public final class ek1 extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f16856e;

    /* renamed from: f */
    public final /* synthetic */ lk1 f16857f;

    /* renamed from: g */
    public final /* synthetic */ DeletionRequest f16858g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ek1(lk1 lk1Var, DeletionRequest deletionRequest, Continuation continuation) {
        super(2, continuation);
        this.f16857f = lk1Var;
        this.f16858g = deletionRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ek1(this.f16857f, this.f16858g, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ek1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f16856e;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            MeasurementManager measurementManager = this.f16857f.f22548a;
            this.f16856e = 1;
            if (measurementManager.deleteRegistrations(this.f16858g, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
