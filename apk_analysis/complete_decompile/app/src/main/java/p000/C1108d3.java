package p000;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;

/* renamed from: d3 */
/* loaded from: classes2.dex */
public final class C1108d3 extends AbstractRunnableC1181f3 {
    @Override // p000.AbstractRunnableC1181f3
    /* renamed from: j */
    public final Object mo4515j(Object obj, Object obj2) {
        AsyncFunction asyncFunction = (AsyncFunction) obj;
        ListenableFuture apply = asyncFunction.apply(obj2);
        Preconditions.checkNotNull(apply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", asyncFunction);
        return apply;
    }

    @Override // p000.AbstractRunnableC1181f3
    /* renamed from: k */
    public final void mo4516k(Object obj) {
        setFuture((ListenableFuture) obj);
    }
}
