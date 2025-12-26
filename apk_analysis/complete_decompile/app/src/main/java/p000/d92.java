package p000;

import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.Segment;

/* loaded from: classes2.dex */
public final class d92 implements Waiter {

    /* renamed from: a */
    public final CancellableContinuationImpl f16302a;

    public d92(CancellableContinuationImpl cancellableContinuationImpl) {
        this.f16302a = cancellableContinuationImpl;
    }

    @Override // kotlinx.coroutines.Waiter
    public final void invokeOnCancellation(Segment segment, int i) {
        this.f16302a.invokeOnCancellation(segment, i);
    }
}
