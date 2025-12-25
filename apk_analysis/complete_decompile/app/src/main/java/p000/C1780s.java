package p000;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;

/* renamed from: s */
/* loaded from: classes2.dex */
public final class C1780s extends AbstractRunnableC1854u {
    @Override // p000.AbstractRunnableC1854u
    /* renamed from: j */
    public final Object mo7313j(Object obj, Throwable th) {
        AsyncFunction asyncFunction = (AsyncFunction) obj;
        ListenableFuture apply = asyncFunction.apply(th);
        Preconditions.checkNotNull(apply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", asyncFunction);
        return apply;
    }

    @Override // p000.AbstractRunnableC1854u
    /* renamed from: k */
    public final void mo7314k(Object obj) {
        setFuture((ListenableFuture) obj);
    }
}
