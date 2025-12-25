package p000;

import android.os.Handler;
import java.util.concurrent.Executor;

/* renamed from: pu */
/* loaded from: classes.dex */
public final /* synthetic */ class ExecutorC1700pu implements Executor {

    /* renamed from: a */
    public final /* synthetic */ Handler f25298a;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f25298a.post(runnable);
    }
}
