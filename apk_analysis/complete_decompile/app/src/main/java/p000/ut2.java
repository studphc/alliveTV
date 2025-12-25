package p000;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.internal.ScopeCoroutine;

/* loaded from: classes2.dex */
public final class ut2 extends ScopeCoroutine implements Runnable {

    /* renamed from: d */
    public final long f27441d;

    public ut2(long j, Continuation continuation) {
        super(continuation.getContext(), continuation);
        this.f27441d = j;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine, kotlinx.coroutines.JobSupport
    public final String nameString$kotlinx_coroutines_core() {
        return super.nameString$kotlinx_coroutines_core() + "(timeMillis=" + this.f27441d + ')';
    }

    @Override // java.lang.Runnable
    public final void run() {
        cancelCoroutine(TimeoutKt.TimeoutCancellationException(this.f27441d, DelayKt.getDelay(getContext()), this));
    }
}
