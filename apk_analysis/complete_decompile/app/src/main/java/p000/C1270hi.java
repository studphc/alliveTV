package p000;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.Segment;

/* renamed from: hi */
/* loaded from: classes2.dex */
public final class C1270hi implements Waiter {

    /* renamed from: a */
    public final CancellableContinuationImpl f18061a;

    /* renamed from: b */
    public final /* synthetic */ CancellableContinuationImpl f18062b;

    public C1270hi(CancellableContinuationImpl cancellableContinuationImpl) {
        this.f18061a = cancellableContinuationImpl;
        Intrinsics.checkNotNull(cancellableContinuationImpl, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlin.Boolean>");
        this.f18062b = cancellableContinuationImpl;
    }

    @Override // kotlinx.coroutines.Waiter
    public final void invokeOnCancellation(Segment segment, int i) {
        this.f18062b.invokeOnCancellation(segment, i);
    }
}
