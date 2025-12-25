package p000;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.Intent;
import androidx.core.app.JobIntentService;
import com.hisona.allive.RxJobIntentService;

/* loaded from: classes.dex */
public final class m61 extends JobServiceEngine {

    /* renamed from: a */
    public final /* synthetic */ int f22823a = 0;

    /* renamed from: b */
    public final Object f22824b;

    /* renamed from: c */
    public JobParameters f22825c;

    /* renamed from: d */
    public final Service f22826d;

    public m61(RxJobIntentService rxJobIntentService) {
        super(rxJobIntentService);
        this.f22824b = new Object();
        this.f22826d = rxJobIntentService;
    }

    /* renamed from: c */
    private final boolean m6083c(JobParameters jobParameters) {
        JobIntentService jobIntentService = (JobIntentService) this.f22826d;
        AsyncTaskC1822t4 asyncTaskC1822t4 = jobIntentService.f3280c;
        if (asyncTaskC1822t4 != null) {
            asyncTaskC1822t4.cancel(jobIntentService.f3281d);
        }
        jobIntentService.f3282e = true;
        boolean onStopCurrentWork = jobIntentService.onStopCurrentWork();
        synchronized (this.f22824b) {
            this.f22825c = null;
        }
        return onStopCurrentWork;
    }

    /* renamed from: a */
    public l61 m6084a() {
        JobWorkItem dequeueWork;
        Intent intent;
        synchronized (this.f22824b) {
            try {
                JobParameters jobParameters = this.f22825c;
                if (jobParameters != null) {
                    dequeueWork = jobParameters.dequeueWork();
                    if (dequeueWork != null) {
                        intent = dequeueWork.getIntent();
                        intent.setExtrasClassLoader(((JobIntentService) this.f22826d).getClassLoader());
                        return new l61(this, dequeueWork);
                    }
                    return null;
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: b */
    public md2 m6085b() {
        JobWorkItem dequeueWork;
        Intent intent;
        synchronized (this.f22824b) {
            try {
                JobParameters jobParameters = this.f22825c;
                if (jobParameters != null) {
                    dequeueWork = jobParameters.dequeueWork();
                    if (dequeueWork != null) {
                        intent = dequeueWork.getIntent();
                        intent.setExtrasClassLoader(((RxJobIntentService) this.f22826d).getClassLoader());
                        return new md2(this, dequeueWork);
                    }
                    return null;
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean onStartJob(JobParameters jobParameters) {
        switch (this.f22823a) {
            case 0:
                this.f22825c = jobParameters;
                ((JobIntentService) this.f22826d).m690a(false);
                return true;
            default:
                this.f22825c = jobParameters;
                ((RxJobIntentService) this.f22826d).m4467a(false);
                return true;
        }
    }

    public final boolean onStopJob(JobParameters jobParameters) {
        switch (this.f22823a) {
            case 0:
                return m6083c(jobParameters);
            default:
                RxJobIntentService rxJobIntentService = (RxJobIntentService) this.f22826d;
                C1540m9 c1540m9 = rxJobIntentService.f15923c;
                if (c1540m9 != null) {
                    boolean z = rxJobIntentService.f15924d;
                    tt1 tt1Var = (tt1) c1540m9.f22854b;
                    if (tt1Var != null && !tt1Var.isDisposed() && z) {
                        ((tt1) c1540m9.f22854b).dispose();
                    }
                    ((RxJobIntentService) c1540m9.f22855c).m4468c();
                }
                rxJobIntentService.f15925e = true;
                boolean onStopCurrentWork = rxJobIntentService.onStopCurrentWork();
                synchronized (this.f22824b) {
                    this.f22825c = null;
                }
                return onStopCurrentWork;
        }
    }

    public m61(JobIntentService jobIntentService) {
        super(jobIntentService);
        this.f22824b = new Object();
        this.f22826d = jobIntentService;
    }
}
