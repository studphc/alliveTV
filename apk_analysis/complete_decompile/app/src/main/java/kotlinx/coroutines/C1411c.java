package kotlinx.coroutines;

import kotlinx.coroutines.EventLoopImplBase;

/* renamed from: kotlinx.coroutines.c */
/* loaded from: classes2.dex */
public final class C1411c extends EventLoopImplBase.DelayedTask {

    /* renamed from: b */
    public final Runnable f21444b;

    public C1411c(long j, Runnable runnable) {
        super(j);
        this.f21444b = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f21444b.run();
    }

    @Override // kotlinx.coroutines.EventLoopImplBase.DelayedTask
    public final String toString() {
        return super.toString() + this.f21444b;
    }
}
