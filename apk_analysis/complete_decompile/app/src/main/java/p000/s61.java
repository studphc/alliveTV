package p000;

import kotlin.Unit;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.JobNode;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.JobSupportKt;
import kotlinx.coroutines.selects.SelectInstance;

/* loaded from: classes2.dex */
public final class s61 extends JobNode {

    /* renamed from: d */
    public final SelectInstance f26254d;

    /* renamed from: e */
    public final /* synthetic */ JobSupport f26255e;

    public s61(JobSupport jobSupport, SelectInstance selectInstance) {
        this.f26255e = jobSupport;
        this.f26254d = selectInstance;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        JobSupport jobSupport = this.f26255e;
        Object state$kotlinx_coroutines_core = jobSupport.getState$kotlinx_coroutines_core();
        if (!(state$kotlinx_coroutines_core instanceof CompletedExceptionally)) {
            state$kotlinx_coroutines_core = JobSupportKt.unboxState(state$kotlinx_coroutines_core);
        }
        this.f26254d.trySelect(jobSupport, state$kotlinx_coroutines_core);
    }
}
