package p000;

import com.google.common.util.concurrent.AbstractScheduledService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* renamed from: x2 */
/* loaded from: classes2.dex */
public final class ThreadFactoryC1968x2 implements ThreadFactory {

    /* renamed from: a */
    public final /* synthetic */ int f28424a;

    /* renamed from: b */
    public final Object f28425b;

    public ThreadFactoryC1968x2() {
        this.f28424a = 1;
        this.f28425b = Executors.defaultThreadFactory();
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        switch (this.f28424a) {
            case 0:
                return MoreExecutors.m4336a(((AbstractScheduledService) this.f28425b).serviceName(), runnable);
            default:
                Thread newThread = ((ThreadFactory) this.f28425b).newThread(runnable);
                newThread.setName("ScionFrontendApi");
                return newThread;
        }
    }

    public ThreadFactoryC1968x2(AbstractScheduledService abstractScheduledService) {
        this.f28424a = 0;
        this.f28425b = abstractScheduledService;
    }
}
