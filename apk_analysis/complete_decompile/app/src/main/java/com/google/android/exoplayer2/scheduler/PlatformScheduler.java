package com.google.android.exoplayer2.scheduler;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import com.google.android.exoplayer2.offline.DownloadService;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import p000.AbstractC1726qj;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class PlatformScheduler implements Scheduler {

    /* renamed from: d */
    public static final int f10887d;

    /* renamed from: a */
    public final int f10888a;

    /* renamed from: b */
    public final ComponentName f10889b;

    /* renamed from: c */
    public final JobScheduler f10890c;

    /* loaded from: classes.dex */
    public static final class PlatformSchedulerService extends JobService {
        @Override // android.app.job.JobService
        public boolean onStartJob(JobParameters jobParameters) {
            PersistableBundle extras = jobParameters.getExtras();
            int notMetRequirements = new Requirements(extras.getInt(DownloadService.KEY_REQUIREMENTS)).getNotMetRequirements(this);
            if (notMetRequirements == 0) {
                String str = (String) Assertions.checkNotNull(extras.getString("service_action"));
                Util.startForegroundService(this, new Intent(str).setPackage((String) Assertions.checkNotNull(extras.getString("service_package"))));
                return false;
            }
            AbstractC1726qj.m7036A(notMetRequirements, "Requirements not met: ", "PlatformScheduler");
            jobFinished(jobParameters, true);
            return false;
        }

        @Override // android.app.job.JobService
        public boolean onStopJob(JobParameters jobParameters) {
            return false;
        }
    }

    static {
        int i;
        if (Util.SDK_INT >= 26) {
            i = 16;
        } else {
            i = 0;
        }
        f10887d = i | 15;
    }

    @RequiresPermission("android.permission.RECEIVE_BOOT_COMPLETED")
    public PlatformScheduler(Context context, int i) {
        Context applicationContext = context.getApplicationContext();
        this.f10888a = i;
        this.f10889b = new ComponentName(applicationContext, (Class<?>) PlatformSchedulerService.class);
        this.f10890c = (JobScheduler) Assertions.checkNotNull((JobScheduler) applicationContext.getSystemService("jobscheduler"));
    }

    @Override // com.google.android.exoplayer2.scheduler.Scheduler
    public boolean cancel() {
        this.f10890c.cancel(this.f10888a);
        return true;
    }

    @Override // com.google.android.exoplayer2.scheduler.Scheduler
    public Requirements getSupportedRequirements(Requirements requirements) {
        return requirements.filterRequirements(f10887d);
    }

    @Override // com.google.android.exoplayer2.scheduler.Scheduler
    public boolean schedule(Requirements requirements, String str, String str2) {
        Requirements filterRequirements = requirements.filterRequirements(f10887d);
        if (!filterRequirements.equals(requirements)) {
            Log.m3027w("PlatformScheduler", "Ignoring unsupported requirements: " + (filterRequirements.getRequirements() ^ requirements.getRequirements()));
        }
        JobInfo.Builder builder = new JobInfo.Builder(this.f10888a, this.f10889b);
        if (requirements.isUnmeteredNetworkRequired()) {
            builder.setRequiredNetworkType(2);
        } else if (requirements.isNetworkRequired()) {
            builder.setRequiredNetworkType(1);
        }
        builder.setRequiresDeviceIdle(requirements.isIdleRequired());
        builder.setRequiresCharging(requirements.isChargingRequired());
        if (Util.SDK_INT >= 26 && requirements.isStorageNotLowRequired()) {
            builder.setRequiresStorageNotLow(true);
        }
        builder.setPersisted(true);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("service_action", str2);
        persistableBundle.putString("service_package", str);
        persistableBundle.putInt(DownloadService.KEY_REQUIREMENTS, requirements.getRequirements());
        builder.setExtras(persistableBundle);
        if (this.f10890c.schedule(builder.build()) == 1) {
            return true;
        }
        return false;
    }
}
