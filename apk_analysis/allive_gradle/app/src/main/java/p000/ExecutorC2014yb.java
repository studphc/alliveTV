package p000;

import android.os.Handler;
import android.os.Looper;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* renamed from: yb */
/* loaded from: classes.dex */
public final class ExecutorC2014yb implements Executor {

    /* renamed from: a */
    public final /* synthetic */ int f28883a;

    /* renamed from: b */
    public final Handler f28884b;

    public ExecutorC2014yb(int i, Handler handler) {
        this.f28883a = i;
        switch (i) {
            case 2:
                this.f28884b = (Handler) Preconditions.checkNotNull(handler);
                return;
            case 3:
                this.f28884b = (Handler) Preconditions.checkNotNull(handler);
                return;
            default:
                this.f28884b = (Handler) Preconditions.checkNotNull(handler);
                return;
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f28883a) {
            case 0:
                this.f28884b.post(runnable);
                return;
            case 1:
                Runnable runnable2 = (Runnable) Preconditions.checkNotNull(runnable);
                Handler handler = this.f28884b;
                if (handler.post(runnable2)) {
                    return;
                }
                throw new RejectedExecutionException(handler + " is shutting down");
            case 2:
                Looper myLooper = Looper.myLooper();
                Handler handler2 = this.f28884b;
                if (myLooper == handler2.getLooper()) {
                    runnable.run();
                    return;
                } else {
                    if (handler2.post((Runnable) Preconditions.checkNotNull(runnable))) {
                        return;
                    }
                    throw new RejectedExecutionException(handler2 + " is shutting down");
                }
            default:
                Runnable runnable3 = (Runnable) Preconditions.checkNotNull(runnable);
                Handler handler3 = this.f28884b;
                if (handler3.post(runnable3)) {
                    return;
                }
                throw new RejectedExecutionException(handler3 + " is shutting down");
        }
    }

    public ExecutorC2014yb() {
        this.f28883a = 0;
        this.f28884b = new Handler(Looper.getMainLooper());
    }
}
