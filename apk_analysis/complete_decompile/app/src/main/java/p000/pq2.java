package p000;

import kotlinx.coroutines.JobImpl;

/* loaded from: classes2.dex */
public final class pq2 extends JobImpl {
    @Override // kotlinx.coroutines.JobSupport
    public final boolean childCancelled(Throwable th) {
        return false;
    }
}
