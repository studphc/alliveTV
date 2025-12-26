package p000;

import androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManager;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* renamed from: ra */
/* loaded from: classes.dex */
public final class C1754ra extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f25913e;

    /* renamed from: f */
    public final /* synthetic */ C1791sa f25914f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1754ra(C1791sa c1791sa, Continuation continuation) {
        super(2, continuation);
        this.f25914f = c1791sa;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C1754ra(this.f25914f, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1754ra) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f25913e;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            AppSetIdManager appSetIdManager = this.f25914f.f26341a;
            this.f25913e = 1;
            obj = appSetIdManager.getAppSetId(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }
}
