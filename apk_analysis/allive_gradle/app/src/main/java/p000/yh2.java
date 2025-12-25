package p000;

import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.flow.SharedFlowImpl;

/* loaded from: classes2.dex */
public final class yh2 implements DisposableHandle {

    /* renamed from: a */
    public final SharedFlowImpl f28958a;

    /* renamed from: b */
    public final long f28959b;

    /* renamed from: c */
    public final Object f28960c;

    /* renamed from: d */
    public final CancellableContinuationImpl f28961d;

    public yh2(SharedFlowImpl sharedFlowImpl, long j, Object obj, CancellableContinuationImpl cancellableContinuationImpl) {
        this.f28958a = sharedFlowImpl;
        this.f28959b = j;
        this.f28960c = obj;
        this.f28961d = cancellableContinuationImpl;
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public final void dispose() {
        SharedFlowImpl.access$cancelEmitter(this.f28958a, this);
    }
}
