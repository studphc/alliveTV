package p000;

import androidx.privacysandbox.ads.adservices.signals.ProtectedSignalsManager;
import androidx.privacysandbox.ads.adservices.signals.UpdateSignalsRequest;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
public final class b82 extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f7925e;

    /* renamed from: f */
    public final /* synthetic */ c82 f7926f;

    /* renamed from: g */
    public final /* synthetic */ UpdateSignalsRequest f7927g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b82(c82 c82Var, UpdateSignalsRequest updateSignalsRequest, Continuation continuation) {
        super(2, continuation);
        this.f7926f = c82Var;
        this.f7927g = updateSignalsRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new b82(this.f7926f, this.f7927g, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((b82) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f7925e;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            ProtectedSignalsManager protectedSignalsManager = this.f7926f.f8287a;
            Intrinsics.checkNotNull(protectedSignalsManager);
            this.f7925e = 1;
            if (protectedSignalsManager.updateSignals(this.f7927g, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
