package p000;

import androidx.privacysandbox.ads.adservices.measurement.MeasurementManager;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
public final class fk1 extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f17301e;

    /* renamed from: f */
    public final /* synthetic */ lk1 f17302f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fk1(lk1 lk1Var, Continuation continuation) {
        super(2, continuation);
        this.f17302f = lk1Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new fk1(this.f17302f, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((fk1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f17301e;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            MeasurementManager measurementManager = this.f17302f.f22548a;
            this.f17301e = 1;
            obj = measurementManager.getMeasurementApiStatus(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }
}
