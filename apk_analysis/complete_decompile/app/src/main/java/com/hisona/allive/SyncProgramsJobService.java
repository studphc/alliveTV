package com.hisona.allive;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;

/* loaded from: classes2.dex */
public class SyncProgramsJobService extends JobService {
    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        Log.e("SyncProgramsJobService", "Starting channel creation job");
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
