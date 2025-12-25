package p000;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.JobNode;
import kotlinx.coroutines.JobSupportKt;

/* loaded from: classes2.dex */
public final class jc2 extends JobNode {

    /* renamed from: d */
    public final p61 f20459d;

    public jc2(p61 p61Var) {
        this.f20459d = p61Var;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        Object state$kotlinx_coroutines_core = getJob().getState$kotlinx_coroutines_core();
        boolean z = state$kotlinx_coroutines_core instanceof CompletedExceptionally;
        p61 p61Var = this.f20459d;
        if (z) {
            Result.Companion companion = Result.INSTANCE;
            p61Var.resumeWith(Result.m8512constructorimpl(ResultKt.createFailure(((CompletedExceptionally) state$kotlinx_coroutines_core).cause)));
        } else {
            Result.Companion companion2 = Result.INSTANCE;
            p61Var.resumeWith(Result.m8512constructorimpl(JobSupportKt.unboxState(state$kotlinx_coroutines_core)));
        }
    }
}
