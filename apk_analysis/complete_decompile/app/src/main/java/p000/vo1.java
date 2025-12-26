package p000;

import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class vo1 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f27897a = 1;

    /* renamed from: b */
    public final long f27898b;

    /* renamed from: c */
    public final Object f27899c;

    /* renamed from: d */
    public final Object f27900d;

    public vo1(Runnable runnable, jv2 jv2Var, long j) {
        this.f27899c = runnable;
        this.f27900d = jv2Var;
        this.f27898b = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f27897a) {
            case 0:
                ExecutorService executorService = (ExecutorService) this.f27899c;
                try {
                    executorService.shutdown();
                    executorService.awaitTermination(this.f27898b, (TimeUnit) this.f27900d);
                    return;
                } catch (InterruptedException unused) {
                    return;
                }
            default:
                if (!((jv2) this.f27900d).f20654d) {
                    long now = ((jv2) this.f27900d).now(TimeUnit.MILLISECONDS);
                    long j = this.f27898b;
                    if (j > now) {
                        try {
                            Thread.sleep(j - now);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            RxJavaPlugins.onError(e);
                            return;
                        }
                    }
                    if (!((jv2) this.f27900d).f20654d) {
                        ((Runnable) this.f27899c).run();
                        return;
                    }
                    return;
                }
                return;
        }
    }

    public vo1(ExecutorService executorService, long j, TimeUnit timeUnit) {
        this.f27899c = executorService;
        this.f27898b = j;
        this.f27900d = timeUnit;
    }
}
