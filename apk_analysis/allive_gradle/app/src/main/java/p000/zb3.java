package p000;

import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.common.zzg;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class zb3 {

    /* renamed from: a */
    public static final ExecutorService f29305a;

    static {
        zzg.zza();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("CallbackExecutor"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f29305a = Executors.unconfigurableExecutorService(threadPoolExecutor);
    }
}
