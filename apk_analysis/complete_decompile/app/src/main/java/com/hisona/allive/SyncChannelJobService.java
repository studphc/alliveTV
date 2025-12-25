package com.hisona.allive;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;

/* loaded from: classes2.dex */
public class SyncChannelJobService extends JobService {
    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        Log.d("SyncChannelJobService", "onStartJob(): " + jobParameters);
        jobParameters.getExtras();
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
