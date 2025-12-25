package p000;

import java.util.concurrent.ThreadFactory;

/* renamed from: p4 */
/* loaded from: classes.dex */
public final class ThreadFactoryC1674p4 implements ThreadFactory {

    /* renamed from: a */
    public final /* synthetic */ int f25025a;

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        switch (this.f25025a) {
            case 0:
                return new Thread(new RunnableC1609o4(0, runnable), "glide-active-resources");
            default:
                return new lb2(runnable);
        }
    }
}
