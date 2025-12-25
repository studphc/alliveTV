package p000;

import android.app.job.JobParameters;
import android.app.job.JobWorkItem;
import android.content.Intent;

/* loaded from: classes2.dex */
public final class md2 implements ld2 {

    /* renamed from: a */
    public final JobWorkItem f22899a;

    /* renamed from: b */
    public final /* synthetic */ m61 f22900b;

    public md2(m61 m61Var, JobWorkItem jobWorkItem) {
        this.f22900b = m61Var;
        this.f22899a = jobWorkItem;
    }

    @Override // p000.ld2
    public final void complete() {
        synchronized (this.f22900b.f22824b) {
            try {
                JobParameters jobParameters = this.f22900b.f22825c;
                if (jobParameters != null) {
                    jobParameters.completeWork(this.f22899a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p000.ld2
    public final Intent getIntent() {
        Intent intent;
        intent = this.f22899a.getIntent();
        return intent;
    }
}
