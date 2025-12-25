package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.BinderThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;

@VisibleForTesting
/* loaded from: classes.dex */
public final class zzd extends zzac {

    /* renamed from: a */
    public BaseGmsClient f13521a;

    /* renamed from: b */
    public final int f13522b;

    public zzd(@NonNull BaseGmsClient baseGmsClient, int i) {
        this.f13521a = baseGmsClient;
        this.f13522b = i;
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    @BinderThread
    public final void onPostInitComplete(int i, @NonNull IBinder iBinder, @Nullable Bundle bundle) {
        Preconditions.checkNotNull(this.f13521a, "onPostInitComplete can be called only once per call to getRemoteService");
        this.f13521a.onPostInitHandler(i, iBinder, bundle, this.f13522b);
        this.f13521a = null;
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    @BinderThread
    public final void zzb(int i, @Nullable Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    @BinderThread
    public final void zzc(int i, @NonNull IBinder iBinder, @NonNull zzk zzkVar) {
        RootTelemetryConfiguration zza;
        BaseGmsClient baseGmsClient = this.f13521a;
        Preconditions.checkNotNull(baseGmsClient, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        Preconditions.checkNotNull(zzkVar);
        baseGmsClient.f13369B = zzkVar;
        if (baseGmsClient.usesClientTelemetry()) {
            ConnectionTelemetryConfiguration connectionTelemetryConfiguration = zzkVar.f13530d;
            RootTelemetryConfigManager rootTelemetryConfigManager = RootTelemetryConfigManager.getInstance();
            if (connectionTelemetryConfiguration == null) {
                zza = null;
            } else {
                zza = connectionTelemetryConfiguration.zza();
            }
            rootTelemetryConfigManager.zza(zza);
        }
        onPostInitComplete(i, iBinder, zzkVar.f13527a);
    }
}
