package p000;

import android.net.Uri;
import android.view.InputEvent;
import androidx.privacysandbox.ads.adservices.measurement.MeasurementManager;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
public final class gk1 extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f17738e;

    /* renamed from: f */
    public final /* synthetic */ lk1 f17739f;

    /* renamed from: g */
    public final /* synthetic */ Uri f17740g;

    /* renamed from: h */
    public final /* synthetic */ InputEvent f17741h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gk1(lk1 lk1Var, Uri uri, InputEvent inputEvent, Continuation continuation) {
        super(2, continuation);
        this.f17739f = lk1Var;
        this.f17740g = uri;
        this.f17741h = inputEvent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new gk1(this.f17739f, this.f17740g, this.f17741h, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((gk1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f17738e;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            MeasurementManager measurementManager = this.f17739f.f22548a;
            this.f17738e = 1;
            if (measurementManager.registerSource(this.f17740g, this.f17741h, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
