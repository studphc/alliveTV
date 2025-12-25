package p000;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.PausingDispatcherKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
public final class z71 extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f29264e;

    /* renamed from: f */
    public final /* synthetic */ LifecycleCoroutineScope f29265f;

    /* renamed from: g */
    public final /* synthetic */ Function2 f29266g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z71(LifecycleCoroutineScope lifecycleCoroutineScope, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f29265f = lifecycleCoroutineScope;
        this.f29266g = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new z71(this.f29265f, this.f29266g, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((z71) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f29264e;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            Lifecycle lifecycle = this.f29265f.getLifecycle();
            this.f29264e = 1;
            if (PausingDispatcherKt.whenCreated(lifecycle, this.f29266g, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
