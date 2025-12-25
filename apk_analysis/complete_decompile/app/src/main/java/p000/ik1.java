package p000;

import android.net.Uri;
import androidx.privacysandbox.ads.adservices.measurement.MeasurementManager;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
public final class ik1 extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f18445e;

    /* renamed from: f */
    public final /* synthetic */ lk1 f18446f;

    /* renamed from: g */
    public final /* synthetic */ Uri f18447g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ik1(lk1 lk1Var, Uri uri, Continuation continuation) {
        super(2, continuation);
        this.f18446f = lk1Var;
        this.f18447g = uri;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ik1(this.f18446f, this.f18447g, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ik1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f18445e;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            MeasurementManager measurementManager = this.f18446f.f22548a;
            this.f18445e = 1;
            if (measurementManager.registerTrigger(this.f18447g, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
