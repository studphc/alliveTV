package p000;

import java.util.concurrent.locks.LockSupport;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.AbstractTimeSource;
import kotlinx.coroutines.AbstractTimeSourceKt;
import kotlinx.coroutines.EventLoop;

/* renamed from: ug */
/* loaded from: classes2.dex */
public final class C1871ug extends AbstractCoroutine {

    /* renamed from: d */
    public final Thread f27251d;

    /* renamed from: e */
    public final EventLoop f27252e;

    public C1871ug(CoroutineContext coroutineContext, Thread thread, EventLoop eventLoop) {
        super(coroutineContext, true, true);
        this.f27251d = thread;
        this.f27252e = eventLoop;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void afterCompletion(Object obj) {
        Unit unit;
        Thread currentThread = Thread.currentThread();
        Thread thread = this.f27251d;
        if (!Intrinsics.areEqual(currentThread, thread)) {
            AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
            if (timeSource != null) {
                timeSource.unpark(thread);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                LockSupport.unpark(thread);
            }
        }
    }

    @Override // kotlinx.coroutines.JobSupport
    public final boolean isScopedCoroutine() {
        return true;
    }
}
