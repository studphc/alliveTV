package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import p000.b51;

/* renamed from: androidx.lifecycle.d */
/* loaded from: classes.dex */
public final class C0418d extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public /* synthetic */ Object f6586e;

    /* renamed from: f */
    public final /* synthetic */ LifecycleCoroutineScopeImpl f6587f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0418d(LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl, Continuation continuation) {
        super(2, continuation);
        this.f6587f = lifecycleCoroutineScopeImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C0418d c0418d = new C0418d(this.f6587f, continuation);
        c0418d.f6586e = obj;
        return c0418d;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C0418d) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        b51.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.f6586e;
        LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl = this.f6587f;
        if (lifecycleCoroutineScopeImpl.getLifecycle().getF6494d().compareTo(Lifecycle.State.INITIALIZED) >= 0) {
            lifecycleCoroutineScopeImpl.getLifecycle().addObserver(lifecycleCoroutineScopeImpl);
        } else {
            JobKt.cancel$default(coroutineScope.getCoroutineContext(), (CancellationException) null, 1, (Object) null);
        }
        return Unit.INSTANCE;
    }
}
