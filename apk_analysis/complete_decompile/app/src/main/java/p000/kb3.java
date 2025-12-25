package p000;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzcs;
import com.google.android.gms.internal.measurement.zzff;

/* loaded from: classes.dex */
public final class kb3 implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    public final /* synthetic */ zzff f20816a;

    public kb3(zzff zzffVar) {
        this.f20816a = zzffVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        this.f20816a.m3294b(new za3(this, bundle, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        this.f20816a.m3294b(new gb3(this, activity, 4));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        this.f20816a.m3294b(new gb3(this, activity, 2));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        this.f20816a.m3294b(new gb3(this, activity, 1));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzcs zzcsVar = new zzcs();
        this.f20816a.m3294b(new za3(this, activity, zzcsVar));
        Bundle zzb = zzcsVar.zzb(50L);
        if (zzb != null) {
            bundle.putAll(zzb);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        this.f20816a.m3294b(new gb3(this, activity, 0));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        this.f20816a.m3294b(new gb3(this, activity, 3));
    }
}
