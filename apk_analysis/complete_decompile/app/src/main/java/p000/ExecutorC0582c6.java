package p000;

import androidx.arch.core.executor.ArchTaskExecutor;
import java.util.concurrent.Executor;

/* renamed from: c6 */
/* loaded from: classes.dex */
public final /* synthetic */ class ExecutorC0582c6 implements Executor {

    /* renamed from: a */
    public final /* synthetic */ int f8266a;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f8266a) {
            case 0:
                runnable.run();
                return;
            case 1:
                runnable.run();
                return;
            case 2:
                ArchTaskExecutor.getInstance().postToMainThread(runnable);
                return;
            default:
                ArchTaskExecutor.getInstance().executeOnDiskIO(runnable);
                return;
        }
    }
}
