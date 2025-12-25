package p000;

import androidx.privacysandbox.ads.adservices.topics.GetTopicsRequest;
import androidx.privacysandbox.ads.adservices.topics.TopicsManager;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
public final class uu2 extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f27456e;

    /* renamed from: f */
    public final /* synthetic */ vu2 f27457f;

    /* renamed from: g */
    public final /* synthetic */ GetTopicsRequest f27458g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uu2(vu2 vu2Var, GetTopicsRequest getTopicsRequest, Continuation continuation) {
        super(2, continuation);
        this.f27457f = vu2Var;
        this.f27458g = getTopicsRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new uu2(this.f27457f, this.f27458g, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((uu2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f27456e;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            TopicsManager topicsManager = this.f27457f.f27975a;
            this.f27456e = 1;
            obj = topicsManager.getTopics(this.f27458g, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }
}
