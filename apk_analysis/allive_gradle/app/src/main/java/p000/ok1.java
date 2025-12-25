package p000;

import android.net.Uri;
import androidx.privacysandbox.ads.adservices.measurement.MeasurementManagerImplCommon;
import androidx.privacysandbox.ads.adservices.measurement.SourceRegistrationRequest;
import java.util.Iterator;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
public final class ok1 extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public /* synthetic */ Object f23841e;

    /* renamed from: f */
    public final /* synthetic */ SourceRegistrationRequest f23842f;

    /* renamed from: g */
    public final /* synthetic */ MeasurementManagerImplCommon f23843g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ok1(MeasurementManagerImplCommon measurementManagerImplCommon, SourceRegistrationRequest sourceRegistrationRequest, Continuation continuation) {
        super(2, continuation);
        this.f23842f = sourceRegistrationRequest;
        this.f23843g = measurementManagerImplCommon;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ok1 ok1Var = new ok1(this.f23843g, this.f23842f, continuation);
        ok1Var.f23841e = obj;
        return ok1Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ok1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        b51.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.f23841e;
        SourceRegistrationRequest sourceRegistrationRequest = this.f23842f;
        Iterator<T> it = sourceRegistrationRequest.getRegistrationUris().iterator();
        while (it.hasNext()) {
            BuildersKt.launch$default(coroutineScope, null, null, new nk1(this.f23843g, (Uri) it.next(), sourceRegistrationRequest, null), 3, null);
        }
        return Unit.INSTANCE;
    }
}
