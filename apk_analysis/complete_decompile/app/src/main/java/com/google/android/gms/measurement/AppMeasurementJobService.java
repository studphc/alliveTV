package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.google.android.gms.measurement.internal.zzof;
import com.google.android.gms.measurement.internal.zzog;

@TargetApi(24)
/* loaded from: classes.dex */
public final class AppMeasurementJobService extends JobService implements zzof {

    /* renamed from: a */
    public zzog f13967a;

    /* renamed from: a */
    public final zzog m3480a() {
        if (this.f13967a == null) {
            this.f13967a = new zzog(this);
        }
        return this.f13967a;
    }

    @Override // android.app.Service
    @MainThread
    public void onCreate() {
        super.onCreate();
        m3480a().zzf();
    }

    @Override // android.app.Service
    @MainThread
    public void onDestroy() {
        m3480a().zzg();
        super.onDestroy();
    }

    @Override // android.app.Service
    @MainThread
    public void onRebind(@NonNull Intent intent) {
        m3480a();
        zzog.zzi(intent);
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(@NonNull JobParameters jobParameters) {
        m3480a().zzh(jobParameters);
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(@NonNull JobParameters jobParameters) {
        return false;
    }

    @Override // android.app.Service
    @MainThread
    public boolean onUnbind(@NonNull Intent intent) {
        m3480a();
        zzog.zzj(intent);
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.zzof
    public final void zza(@NonNull Intent intent) {
    }

    @Override // com.google.android.gms.measurement.internal.zzof
    @TargetApi(24)
    public final void zzb(@NonNull JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }

    @Override // com.google.android.gms.measurement.internal.zzof
    public final boolean zzc(int i) {
        throw new UnsupportedOperationException();
    }
}
