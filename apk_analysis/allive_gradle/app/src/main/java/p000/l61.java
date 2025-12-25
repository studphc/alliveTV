package p000;

import android.app.job.JobParameters;
import android.app.job.JobWorkItem;
import android.content.Intent;

/* loaded from: classes.dex */
public final class l61 implements k61 {

    /* renamed from: a */
    public final JobWorkItem f22355a;

    /* renamed from: b */
    public final /* synthetic */ m61 f22356b;

    public l61(m61 m61Var, JobWorkItem jobWorkItem) {
        this.f22356b = m61Var;
        this.f22355a = jobWorkItem;
    }

    @Override // p000.k61
    public final void complete() {
        synchronized (this.f22356b.f22824b) {
            try {
                JobParameters jobParameters = this.f22356b.f22825c;
                if (jobParameters != null) {
                    jobParameters.completeWork(this.f22355a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p000.k61
    public final Intent getIntent() {
        Intent intent;
        intent = this.f22355a.getIntent();
        return intent;
    }
}
