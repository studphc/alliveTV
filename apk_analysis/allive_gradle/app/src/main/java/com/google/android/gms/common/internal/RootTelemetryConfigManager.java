package com.google.android.gms.common.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* loaded from: classes.dex */
public final class RootTelemetryConfigManager {

    /* renamed from: b */
    public static RootTelemetryConfigManager f13462b;

    /* renamed from: c */
    public static final RootTelemetryConfiguration f13463c = new RootTelemetryConfiguration(0, false, false, 0, 0);

    /* renamed from: a */
    public RootTelemetryConfiguration f13464a;

    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, com.google.android.gms.common.internal.RootTelemetryConfigManager] */
    @NonNull
    @KeepForSdk
    public static synchronized RootTelemetryConfigManager getInstance() {
        RootTelemetryConfigManager rootTelemetryConfigManager;
        synchronized (RootTelemetryConfigManager.class) {
            try {
                if (f13462b == null) {
                    f13462b = new Object();
                }
                rootTelemetryConfigManager = f13462b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return rootTelemetryConfigManager;
    }

    @Nullable
    @KeepForSdk
    public RootTelemetryConfiguration getConfig() {
        return this.f13464a;
    }

    @VisibleForTesting
    public final synchronized void zza(@Nullable RootTelemetryConfiguration rootTelemetryConfiguration) {
        if (rootTelemetryConfiguration == null) {
            this.f13464a = f13463c;
            return;
        }
        RootTelemetryConfiguration rootTelemetryConfiguration2 = this.f13464a;
        if (rootTelemetryConfiguration2 != null && rootTelemetryConfiguration2.getVersion() >= rootTelemetryConfiguration.getVersion()) {
            return;
        }
        this.f13464a = rootTelemetryConfiguration;
    }
}
