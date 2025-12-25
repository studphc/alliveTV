package p000;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
public final class n61 extends o61 {

    /* renamed from: d */
    public final JobInfo f23246d;

    /* renamed from: e */
    public final JobScheduler f23247e;

    public n61(Context context, ComponentName componentName, int i) {
        super(componentName);
        m6445b(i);
        this.f23246d = new JobInfo.Builder(i, componentName).setOverrideDeadline(0L).build();
        this.f23247e = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
    }

    @Override // p000.o61
    /* renamed from: a */
    public final void mo5164a(Intent intent) {
        this.f23247e.enqueue(this.f23246d, ra0.m7245h(intent));
    }
}
