package p000;

import android.net.Uri;
import androidx.core.os.OutcomeReceiverKt;
import androidx.privacysandbox.ads.adservices.measurement.MeasurementManagerImplCommon;
import androidx.privacysandbox.ads.adservices.measurement.SourceRegistrationRequest;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
public final class nk1 extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f23387e;

    /* renamed from: f */
    public final /* synthetic */ MeasurementManagerImplCommon f23388f;

    /* renamed from: g */
    public final /* synthetic */ Uri f23389g;

    /* renamed from: h */
    public final /* synthetic */ SourceRegistrationRequest f23390h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nk1(MeasurementManagerImplCommon measurementManagerImplCommon, Uri uri, SourceRegistrationRequest sourceRegistrationRequest, Continuation continuation) {
        super(2, continuation);
        this.f23388f = measurementManagerImplCommon;
        this.f23389g = uri;
        this.f23390h = sourceRegistrationRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new nk1(this.f23388f, this.f23389g, this.f23390h, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((nk1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f23387e;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            MeasurementManagerImplCommon measurementManagerImplCommon = this.f23388f;
            Uri uri = this.f23389g;
            SourceRegistrationRequest sourceRegistrationRequest = this.f23390h;
            this.f23387e = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(this), 1);
            cancellableContinuationImpl.initCancellability();
            measurementManagerImplCommon.getMMeasurementManager().registerSource(uri, sourceRegistrationRequest.getInputEvent(), new ExecutorC0582c6(0), OutcomeReceiverKt.asOutcomeReceiver(cancellableContinuationImpl));
            Object result = cancellableContinuationImpl.getResult();
            if (result == b51.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(this);
            }
            if (result == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
