package p000;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

/* renamed from: p5 */
/* loaded from: classes.dex */
public final class C1675p5 implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    public Object f25035a;

    /* renamed from: b */
    public Activity f25036b;

    /* renamed from: c */
    public final int f25037c;

    /* renamed from: d */
    public boolean f25038d = false;

    /* renamed from: e */
    public boolean f25039e = false;

    /* renamed from: f */
    public boolean f25040f = false;

    public C1675p5(Activity activity) {
        this.f25036b = activity;
        this.f25037c = activity.hashCode();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        if (this.f25036b == activity) {
            this.f25036b = null;
            this.f25039e = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        if (this.f25039e && !this.f25040f && !this.f25038d) {
            Object obj = this.f25035a;
            try {
                Object obj2 = AbstractC1712q5.f25448c.get(activity);
                if (obj2 == obj && activity.hashCode() == this.f25037c) {
                    AbstractC1712q5.f25452g.postAtFrontOfQueue(new xy1(4, AbstractC1712q5.f25447b.get(activity), obj2, false));
                    this.f25040f = true;
                    this.f25035a = null;
                }
            } catch (Throwable th) {
                Log.e("ActivityRecreator", "Exception while fetching field values", th);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        if (this.f25036b == activity) {
            this.f25038d = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
