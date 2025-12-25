package com.google.android.gms.common.api.internal;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import p000.v63;

@KeepForSdk
/* loaded from: classes.dex */
public abstract class ActivityLifecycleObserver {
    @NonNull
    @KeepForSdk
    /* renamed from: of */
    public static final ActivityLifecycleObserver m3082of(@NonNull Activity activity) {
        v63 v63Var;
        synchronized (activity) {
            try {
                LifecycleFragment fragment = LifecycleCallback.getFragment(activity);
                v63Var = (v63) fragment.getCallbackOrNull("LifecycleObserverOnStop", v63.class);
                if (v63Var == null) {
                    v63Var = new v63(fragment);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return new zab(v63Var);
    }

    @NonNull
    @KeepForSdk
    public abstract ActivityLifecycleObserver onStopCallOnce(@NonNull Runnable runnable);
}
