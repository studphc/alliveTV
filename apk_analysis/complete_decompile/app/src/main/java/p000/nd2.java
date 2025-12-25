package p000;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes2.dex */
public final class nd2 extends od2 {

    /* renamed from: d */
    public final JobInfo f23334d;

    /* renamed from: e */
    public final JobScheduler f23335e;

    public nd2(Context context, ComponentName componentName, int i) {
        super(componentName);
        m6563b(i);
        this.f23334d = new JobInfo.Builder(i, componentName).setOverrideDeadline(0L).build();
        this.f23335e = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
    }

    @Override // p000.od2
    /* renamed from: a */
    public final void mo5437a(Intent intent) {
        this.f23335e.enqueue(this.f23334d, ra0.m7245h(intent));
    }
}
