package p000;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.selects.SelectClause1;

/* renamed from: js */
/* loaded from: classes2.dex */
public final class C1365js extends JobSupport implements CompletableDeferred {
    public C1365js(Job job) {
        super(true);
        initParentJob(job);
    }

    @Override // kotlinx.coroutines.Deferred
    public final Object await(Continuation continuation) {
        Object awaitInternal = awaitInternal(continuation);
        b51.getCOROUTINE_SUSPENDED();
        return awaitInternal;
    }

    @Override // kotlinx.coroutines.CompletableDeferred
    public final boolean completeExceptionally(Throwable th) {
        return makeCompleting$kotlinx_coroutines_core(new CompletedExceptionally(th, false, 2, null));
    }

    @Override // kotlinx.coroutines.Deferred
    public final SelectClause1 getOnAwait() {
        SelectClause1<?> onAwaitInternal = getOnAwaitInternal();
        Intrinsics.checkNotNull(onAwaitInternal, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectClause1<T of kotlinx.coroutines.CompletableDeferredImpl>");
        return onAwaitInternal;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return true;
    }
}
