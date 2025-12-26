package kotlinx.coroutines;

import kotlin.Unit;
import kotlinx.coroutines.EventLoopImplBase;

/* renamed from: kotlinx.coroutines.b */
/* loaded from: classes2.dex */
public final class C1410b extends EventLoopImplBase.DelayedTask {

    /* renamed from: b */
    public final CancellableContinuation f21442b;

    /* renamed from: c */
    public final /* synthetic */ EventLoopImplBase f21443c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1410b(EventLoopImplBase eventLoopImplBase, long j, CancellableContinuation cancellableContinuation) {
        super(j);
        this.f21443c = eventLoopImplBase;
        this.f21442b = cancellableContinuation;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f21442b.resumeUndispatched(this.f21443c, Unit.INSTANCE);
    }

    @Override // kotlinx.coroutines.EventLoopImplBase.DelayedTask
    public final String toString() {
        return super.toString() + this.f21442b;
    }
}
