package com.google.android.gms.measurement.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.core.app.NotificationCompat;
import p000.re3;
import p000.w93;

/* loaded from: classes.dex */
public final class zzoy extends re3 {

    /* renamed from: b */
    public final AlarmManager f14351b;

    /* renamed from: c */
    public C0812m0 f14352c;

    /* renamed from: d */
    public Integer f14353d;

    public zzoy(zzpv zzpvVar) {
        super(zzpvVar);
        this.f14351b = (AlarmManager) this.zzu.zzaT().getSystemService(NotificationCompat.CATEGORY_ALARM);
    }

    /* renamed from: a */
    public final int m3605a() {
        if (this.f14353d == null) {
            this.f14353d = Integer.valueOf("measurement".concat(String.valueOf(this.zzu.zzaT().getPackageName())).hashCode());
        }
        return this.f14353d.intValue();
    }

    /* renamed from: b */
    public final PendingIntent m3606b() {
        Context zzaT = this.zzu.zzaT();
        return PendingIntent.getBroadcast(zzaT, 0, new Intent().setClassName(zzaT, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), com.google.android.gms.internal.measurement.zzcj.zza);
    }

    /* renamed from: c */
    public final w93 m3607c() {
        if (this.f14352c == null) {
            this.f14352c = new C0812m0(1, this, this.zzg.f14380l);
        }
        return this.f14352c;
    }

    public final void zza() {
        JobScheduler jobScheduler;
        zzav();
        this.zzu.zzaW().zzj().zza("Unscheduling upload");
        AlarmManager alarmManager = this.f14351b;
        if (alarmManager != null) {
            alarmManager.cancel(m3606b());
        }
        m3607c().m8015a();
        if (Build.VERSION.SDK_INT >= 24 && (jobScheduler = (JobScheduler) this.zzu.zzaT().getSystemService("jobscheduler")) != null) {
            jobScheduler.cancel(m3605a());
        }
    }

    @Override // p000.re3
    public final boolean zzb() {
        JobScheduler jobScheduler;
        AlarmManager alarmManager = this.f14351b;
        if (alarmManager != null) {
            alarmManager.cancel(m3606b());
        }
        if (Build.VERSION.SDK_INT >= 24 && (jobScheduler = (JobScheduler) this.zzu.zzaT().getSystemService("jobscheduler")) != null) {
            jobScheduler.cancel(m3605a());
            return false;
        }
        return false;
    }

    public final void zzd(long j) {
        zzav();
        zzio zzioVar = this.zzu;
        zzioVar.zzaV();
        Context zzaT = zzioVar.zzaT();
        if (!zzqf.m3701G(zzaT)) {
            zzioVar.zzaW().zzd().zza("Receiver not registered/enabled");
        }
        if (!zzqf.m3703I(zzaT)) {
            zzioVar.zzaW().zzd().zza("Service not registered/enabled");
        }
        zza();
        zzioVar.zzaW().zzj().zzb("Scheduling upload, millis", Long.valueOf(j));
        long elapsedRealtime = zzioVar.zzaU().elapsedRealtime() + j;
        zzioVar.zzf();
        if (j < Math.max(0L, ((Long) zzgi.zzK.zza(null)).longValue()) && m3607c().f28111c == 0) {
            m3607c().m8016c(j);
        }
        zzioVar.zzaV();
        if (Build.VERSION.SDK_INT >= 24) {
            Context zzaT2 = zzioVar.zzaT();
            ComponentName componentName = new ComponentName(zzaT2, "com.google.android.gms.measurement.AppMeasurementJobService");
            int m3605a = m3605a();
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
            com.google.android.gms.internal.measurement.zzck.zza(zzaT2, new JobInfo.Builder(m3605a, componentName).setMinimumLatency(j).setOverrideDeadline(j + j).setExtras(persistableBundle).build(), "com.google.android.gms", "UploadAlarm");
            return;
        }
        AlarmManager alarmManager = this.f14351b;
        if (alarmManager != null) {
            zzioVar.zzf();
            alarmManager.setInexactRepeating(2, elapsedRealtime, Math.max(((Long) zzgi.zzF.zza(null)).longValue(), j), m3606b());
        }
    }
}
