package p000;

import android.os.Build;
import android.os.StrictMode;
import com.google.firebase.components.Lazy;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.inject.Provider;
import java.util.Collections;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: zt */
/* loaded from: classes2.dex */
public final /* synthetic */ class C2069zt implements Provider {

    /* renamed from: a */
    public final /* synthetic */ int f29513a;

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        switch (this.f29513a) {
            case 0:
                return Collections.emptySet();
            case 1:
                Lazy lazy = ExecutorsRegistrar.f15549a;
                StrictMode.ThreadPolicy.Builder detectNetwork = new StrictMode.ThreadPolicy.Builder().detectNetwork();
                int i = Build.VERSION.SDK_INT;
                detectNetwork.detectResourceMismatches();
                if (i >= 26) {
                    detectNetwork.detectUnbufferedIo();
                }
                return new z10(Executors.newFixedThreadPool(4, new ThreadFactoryC1490kx("Firebase Background", 10, detectNetwork.penaltyLog().build())), (ScheduledExecutorService) ExecutorsRegistrar.f15552d.get());
            case 2:
                Lazy lazy2 = ExecutorsRegistrar.f15549a;
                return new z10(Executors.newFixedThreadPool(Math.max(2, Runtime.getRuntime().availableProcessors()), new ThreadFactoryC1490kx("Firebase Lite", 0, new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build())), (ScheduledExecutorService) ExecutorsRegistrar.f15552d.get());
            case 3:
                Lazy lazy3 = ExecutorsRegistrar.f15549a;
                return new z10(Executors.newCachedThreadPool(new ThreadFactoryC1490kx("Firebase Blocking", 11, null)), (ScheduledExecutorService) ExecutorsRegistrar.f15552d.get());
            case 4:
                Lazy lazy4 = ExecutorsRegistrar.f15549a;
                return Executors.newSingleThreadScheduledExecutor(new ThreadFactoryC1490kx("Firebase Scheduler", 0, null));
            default:
                return null;
        }
    }
}
