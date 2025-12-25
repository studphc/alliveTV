package p000;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobSupport;

/* loaded from: classes2.dex */
public final class p61 extends CancellableContinuationImpl {

    /* renamed from: f */
    public final JobSupport f25046f;

    public p61(JobSupport jobSupport, Continuation continuation) {
        super(continuation, 1);
        this.f25046f = jobSupport;
    }

    @Override // kotlinx.coroutines.CancellableContinuationImpl
    public final Throwable getContinuationCancellationCause(Job job) {
        Throwable m7222b;
        Object state$kotlinx_coroutines_core = this.f25046f.getState$kotlinx_coroutines_core();
        if ((state$kotlinx_coroutines_core instanceof r61) && (m7222b = ((r61) state$kotlinx_coroutines_core).m7222b()) != null) {
            return m7222b;
        }
        if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            return ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
        }
        return job.getCancellationException();
    }

    @Override // kotlinx.coroutines.CancellableContinuationImpl
    public final String nameString() {
        return "AwaitContinuation";
    }
}
