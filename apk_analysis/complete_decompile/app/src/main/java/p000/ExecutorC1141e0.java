package p000;

import android.os.Looper;
import com.google.android.gms.internal.tasks.zza;
import com.google.common.util.concurrent.AbstractExecutionThreadService;
import com.google.common.util.concurrent.AbstractIdleService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.Service;
import java.util.concurrent.Executor;

/* renamed from: e0 */
/* loaded from: classes2.dex */
public final class ExecutorC1141e0 implements Executor {

    /* renamed from: a */
    public final /* synthetic */ int f16628a;

    /* renamed from: b */
    public final Object f16629b;

    public /* synthetic */ ExecutorC1141e0(Service service, int i) {
        this.f16628a = i;
        this.f16629b = service;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f16628a) {
            case 0:
                MoreExecutors.m4336a(((AbstractExecutionThreadService) this.f16629b).serviceName(), runnable).start();
                return;
            case 1:
                MoreExecutors.m4336a((String) ((AbstractIdleService) this.f16629b).f15258a.get(), runnable).start();
                return;
            default:
                ((zza) this.f16629b).post(runnable);
                return;
        }
    }

    public ExecutorC1141e0() {
        this.f16628a = 2;
        this.f16629b = new zza(Looper.getMainLooper());
    }
}
