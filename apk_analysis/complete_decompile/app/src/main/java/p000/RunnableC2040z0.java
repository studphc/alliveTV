package p000;

import com.google.common.util.concurrent.AbstractIdleService;

/* renamed from: z0 */
/* loaded from: classes2.dex */
public final class RunnableC2040z0 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f29206a;

    /* renamed from: b */
    public final /* synthetic */ C1105d0 f29207b;

    public /* synthetic */ RunnableC2040z0(C1105d0 c1105d0, int i) {
        this.f29206a = i;
        this.f29207b = c1105d0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f29206a) {
            case 0:
                C1105d0 c1105d0 = this.f29207b;
                try {
                    ((AbstractIdleService) c1105d0.f16190q).startUp();
                    c1105d0.notifyStarted();
                    return;
                } catch (Throwable th) {
                    c1105d0.notifyFailed(th);
                    return;
                }
            default:
                C1105d0 c1105d02 = this.f29207b;
                try {
                    ((AbstractIdleService) c1105d02.f16190q).shutDown();
                    c1105d02.notifyStopped();
                    return;
                } catch (Throwable th2) {
                    c1105d02.notifyFailed(th2);
                    return;
                }
        }
    }
}
