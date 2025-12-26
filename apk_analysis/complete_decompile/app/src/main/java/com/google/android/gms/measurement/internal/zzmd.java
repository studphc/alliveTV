package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzih;
import p000.mb3;

/* loaded from: classes.dex */
public final class zzmd extends mb3 {

    /* renamed from: b */
    public JobScheduler f14319b;

    public zzmd(zzio zzioVar) {
        super(zzioVar);
    }

    /* renamed from: a */
    public final zzih m3576a() {
        zza();
        zzg();
        zzio zzioVar = this.zzu;
        if (!zzioVar.zzf().zzx(null, zzgi.zzaR)) {
            return zzih.CLIENT_FLAG_OFF;
        }
        if (this.f14319b != null) {
            if (zzioVar.zzf().zzE()) {
                zzio zzioVar2 = this.zzu;
                if (zzioVar2.zzh().f14166i >= 119000) {
                    if (!zzqf.m3702H(zzioVar.zzaT(), "com.google.android.gms.measurement.AppMeasurementJobService")) {
                        return zzih.MEASUREMENT_SERVICE_NOT_ENABLED;
                    }
                    if (Build.VERSION.SDK_INT >= 24) {
                        if (!zzioVar2.zzu().m3586d()) {
                            return zzih.NON_PLAY_MODE;
                        }
                        return zzih.CLIENT_UPLOAD_ELIGIBLE;
                    }
                    return zzih.ANDROID_TOO_OLD;
                }
                return zzih.SDK_TOO_OLD;
            }
            return zzih.NOT_ENABLED_IN_MANIFEST;
        }
        return zzih.MISSING_JOB_SCHEDULER;
    }

    @Override // p000.mb3
    @TargetApi(24)
    @WorkerThread
    public final void zzd() {
        this.f14319b = (JobScheduler) this.zzu.zzaT().getSystemService("jobscheduler");
    }

    @Override // p000.mb3
    public final boolean zzf() {
        return true;
    }

    @TargetApi(24)
    @WorkerThread
    public final void zzj(long j) {
        String str;
        JobInfo pendingJob;
        zza();
        zzg();
        JobScheduler jobScheduler = this.f14319b;
        if (jobScheduler != null) {
            pendingJob = jobScheduler.getPendingJob("measurement-client".concat(String.valueOf(this.zzu.zzaT().getPackageName())).hashCode());
            if (pendingJob != null) {
                this.zzu.zzaW().zzj().zza("[sgtm] There's an existing pending job, skip this schedule.");
                return;
            }
        }
        zzih m3576a = m3576a();
        if (m3576a == zzih.CLIENT_UPLOAD_ELIGIBLE) {
            zzio zzioVar = this.zzu;
            zzioVar.zzaW().zzj().zzb("[sgtm] Scheduling Scion upload, millis", Long.valueOf(j));
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("action", "com.google.android.gms.measurement.SCION_UPLOAD");
            int schedule = ((JobScheduler) Preconditions.checkNotNull(this.f14319b)).schedule(new JobInfo.Builder("measurement-client".concat(String.valueOf(this.zzu.zzaT().getPackageName())).hashCode(), new ComponentName(zzioVar.zzaT(), "com.google.android.gms.measurement.AppMeasurementJobService")).setRequiredNetworkType(1).setMinimumLatency(j).setOverrideDeadline(j + j).setExtras(persistableBundle).build());
            zzhc zzj = zzioVar.zzaW().zzj();
            if (schedule == 1) {
                str = "SUCCESS";
            } else {
                str = "FAILURE";
            }
            zzj.zzb("[sgtm] Scion upload job scheduled with result", str);
            return;
        }
        this.zzu.zzaW().zzj().zzb("[sgtm] Not eligible for Scion upload", m3576a.name());
    }
}
