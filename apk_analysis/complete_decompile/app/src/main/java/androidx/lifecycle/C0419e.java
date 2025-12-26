package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import p000.b51;

/* renamed from: androidx.lifecycle.e */
/* loaded from: classes.dex */
public final class C0419e extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f6588e;

    /* renamed from: f */
    public /* synthetic */ Object f6589f;

    /* renamed from: g */
    public final /* synthetic */ Lifecycle f6590g;

    /* renamed from: h */
    public final /* synthetic */ Lifecycle.State f6591h;

    /* renamed from: i */
    public final /* synthetic */ Function2 f6592i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0419e(Lifecycle lifecycle, Lifecycle.State state, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f6590g = lifecycle;
        this.f6591h = state;
        this.f6592i = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C0419e c0419e = new C0419e(this.f6590g, this.f6591h, this.f6592i, continuation);
        c0419e.f6589f = obj;
        return c0419e;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C0419e) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        LifecycleController lifecycleController;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f6588e;
        if (i != 0) {
            if (i == 1) {
                lifecycleController = (LifecycleController) this.f6589f;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Throwable th) {
                    th = th;
                    lifecycleController.finish();
                    throw th;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            Job job = (Job) ((CoroutineScope) this.f6589f).getCoroutineContext().get(Job.INSTANCE);
            if (job != null) {
                PausingDispatcher pausingDispatcher = new PausingDispatcher();
                LifecycleController lifecycleController2 = new LifecycleController(this.f6590g, this.f6591h, pausingDispatcher.dispatchQueue, job);
                try {
                    Function2 function2 = this.f6592i;
                    this.f6589f = lifecycleController2;
                    this.f6588e = 1;
                    obj = BuildersKt.withContext(pausingDispatcher, function2, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    lifecycleController = lifecycleController2;
                } catch (Throwable th2) {
                    th = th2;
                    lifecycleController = lifecycleController2;
                    lifecycleController.finish();
                    throw th;
                }
            } else {
                throw new IllegalStateException("when[State] methods should have a parent job");
            }
        }
        lifecycleController.finish();
        return obj;
    }
}
