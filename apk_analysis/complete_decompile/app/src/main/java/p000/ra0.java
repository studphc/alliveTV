package p000;

import android.app.NotificationChannel;
import android.app.job.JobWorkItem;
import android.content.Intent;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class ra0 {
    /* renamed from: f */
    public static /* synthetic */ NotificationChannel m7243f(String str) {
        return new NotificationChannel("com.google.android.gms.availability", str, 4);
    }

    /* renamed from: h */
    public static /* synthetic */ JobWorkItem m7245h(Intent intent) {
        return new JobWorkItem(intent);
    }
}
