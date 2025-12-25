package p000;

import kotlin.KotlinNothingValueException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.internal.MainDispatchersKt;

/* loaded from: classes2.dex */
public final class io1 extends MainCoroutineDispatcher implements Delay {
    /* renamed from: a */
    public final void m5330a() {
        MainDispatchersKt.throwMissingMainDispatcherException();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.Delay
    public final Object delay(long j, Continuation continuation) {
        return Delay.DefaultImpls.delay(this, j, continuation);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        m5330a();
        throw null;
    }

    @Override // kotlinx.coroutines.Delay
    public final DisposableHandle invokeOnTimeout(long j, Runnable runnable, CoroutineContext coroutineContext) {
        m5330a();
        throw null;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        m5330a();
        throw null;
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher
    public final CoroutineDispatcher limitedParallelism(int i) {
        m5330a();
        throw null;
    }

    @Override // kotlinx.coroutines.Delay
    public final void scheduleResumeAfterDelay(long j, CancellableContinuation cancellableContinuation) {
        m5330a();
        throw null;
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        return "Dispatchers.Main[missing]";
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher
    public final MainCoroutineDispatcher getImmediate() {
        return this;
    }
}
