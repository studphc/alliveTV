package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzof;
import com.google.android.gms.measurement.internal.zzog;

/* loaded from: classes.dex */
public final class AppMeasurementService extends Service implements zzof {

    /* renamed from: a */
    public zzog f13969a;

    /* renamed from: a */
    public final zzog m3481a() {
        if (this.f13969a == null) {
            this.f13969a = new zzog(this);
        }
        return this.f13969a;
    }

    @Override // android.app.Service
    @Nullable
    @MainThread
    public IBinder onBind(@NonNull Intent intent) {
        return m3481a().zzb(intent);
    }

    @Override // android.app.Service
    @MainThread
    public void onCreate() {
        super.onCreate();
        m3481a().zzf();
    }

    @Override // android.app.Service
    @MainThread
    public void onDestroy() {
        m3481a().zzg();
        super.onDestroy();
    }

    @Override // android.app.Service
    @MainThread
    public void onRebind(@NonNull Intent intent) {
        m3481a();
        zzog.zzi(intent);
    }

    @Override // android.app.Service
    @MainThread
    public int onStartCommand(@NonNull Intent intent, int i, int i2) {
        m3481a().zza(intent, i, i2);
        return 2;
    }

    @Override // android.app.Service
    @MainThread
    public boolean onUnbind(@NonNull Intent intent) {
        m3481a();
        zzog.zzj(intent);
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.zzof
    public final void zza(@NonNull Intent intent) {
        WakefulBroadcastReceiver.completeWakefulIntent(intent);
    }

    @Override // com.google.android.gms.measurement.internal.zzof
    public final void zzb(@NonNull JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.measurement.internal.zzof
    public final boolean zzc(int i) {
        return stopSelfResult(i);
    }
}
