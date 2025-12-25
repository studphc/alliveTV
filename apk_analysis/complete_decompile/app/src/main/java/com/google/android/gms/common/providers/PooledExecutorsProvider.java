package com.google.android.gms.common.providers;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.ScheduledExecutorService;

@KeepForSdk
@Deprecated
/* loaded from: classes.dex */
public class PooledExecutorsProvider {

    /* renamed from: a */
    public static C0761a f13567a;

    /* loaded from: classes.dex */
    public interface PooledExecutorFactory {
        @NonNull
        @KeepForSdk
        @Deprecated
        ScheduledExecutorService newSingleThreadScheduledExecutor();
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [com.google.android.gms.common.providers.a, java.lang.Object] */
    @NonNull
    @KeepForSdk
    @Deprecated
    public static synchronized PooledExecutorFactory getInstance() {
        C0761a c0761a;
        synchronized (PooledExecutorsProvider.class) {
            try {
                if (f13567a == null) {
                    f13567a = new Object();
                }
                c0761a = f13567a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c0761a;
    }
}
