package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzqk implements zzqj {
    public static final zzki zza;

    static {
        zzkf zza2 = new zzkf(zzjx.zza("com.google.android.gms.measurement")).zzb().zza();
        zza2.zzf("measurement.gmscore_feature_tracking", true);
        zza = zza2.zzf("measurement.gmscore_client_telemetry", false);
    }

    @Override // com.google.android.gms.internal.measurement.zzqj
    public final boolean zza() {
        return ((Boolean) zza.zzb()).booleanValue();
    }
}
