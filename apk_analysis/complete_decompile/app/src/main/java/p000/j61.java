package p000;

import android.content.Intent;
import androidx.core.app.JobIntentService;

/* loaded from: classes.dex */
public final class j61 implements k61 {

    /* renamed from: a */
    public final Intent f20386a;

    /* renamed from: b */
    public final int f20387b;

    /* renamed from: c */
    public final /* synthetic */ JobIntentService f20388c;

    public j61(JobIntentService jobIntentService, Intent intent, int i) {
        this.f20388c = jobIntentService;
        this.f20386a = intent;
        this.f20387b = i;
    }

    @Override // p000.k61
    public final void complete() {
        this.f20388c.stopSelf(this.f20387b);
    }

    @Override // p000.k61
    public final Intent getIntent() {
        return this.f20386a;
    }
}
