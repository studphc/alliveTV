package p000;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.selects.SelectClause1;

/* loaded from: classes2.dex */
public class s10 extends AbstractCoroutine implements Deferred {
    @Override // kotlinx.coroutines.Deferred
    public final Object await(Continuation continuation) {
        Object awaitInternal = awaitInternal(continuation);
        b51.getCOROUTINE_SUSPENDED();
        return awaitInternal;
    }

    @Override // kotlinx.coroutines.Deferred
    public final SelectClause1 getOnAwait() {
        SelectClause1<?> onAwaitInternal = getOnAwaitInternal();
        Intrinsics.checkNotNull(onAwaitInternal, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectClause1<T of kotlinx.coroutines.DeferredCoroutine>");
        return onAwaitInternal;
    }
}
