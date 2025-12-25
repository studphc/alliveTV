package p000;

import kotlinx.coroutines.flow.internal.ChildCancelledException;
import kotlinx.coroutines.internal.ScopeCoroutine;

/* loaded from: classes2.dex */
public final class kf0 extends ScopeCoroutine {
    @Override // kotlinx.coroutines.JobSupport
    public final boolean childCancelled(Throwable th) {
        if (th instanceof ChildCancelledException) {
            return true;
        }
        return cancelImpl$kotlinx_coroutines_core(th);
    }
}
