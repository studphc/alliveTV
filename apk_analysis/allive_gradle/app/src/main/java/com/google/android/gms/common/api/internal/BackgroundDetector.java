package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.ProcessUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

@KeepForSdk
/* loaded from: classes.dex */
public final class BackgroundDetector implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* renamed from: e */
    public static final BackgroundDetector f13081e = new BackgroundDetector();

    /* renamed from: a */
    public final AtomicBoolean f13082a = new AtomicBoolean();

    /* renamed from: b */
    public final AtomicBoolean f13083b = new AtomicBoolean();

    /* renamed from: c */
    public final ArrayList f13084c = new ArrayList();

    /* renamed from: d */
    public boolean f13085d = false;

    @KeepForSdk
    /* loaded from: classes.dex */
    public interface BackgroundStateChangeListener {
        @KeepForSdk
        void onBackgroundStateChanged(boolean z);
    }

    @NonNull
    @KeepForSdk
    public static BackgroundDetector getInstance() {
        return f13081e;
    }

    @KeepForSdk
    public static void initialize(@NonNull Application application) {
        BackgroundDetector backgroundDetector = f13081e;
        synchronized (backgroundDetector) {
            try {
                if (!backgroundDetector.f13085d) {
                    application.registerActivityLifecycleCallbacks(backgroundDetector);
                    application.registerComponentCallbacks(backgroundDetector);
                    backgroundDetector.f13085d = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: a */
    public final void m3083a(boolean z) {
        synchronized (f13081e) {
            try {
                Iterator it = this.f13084c.iterator();
                while (it.hasNext()) {
                    ((BackgroundStateChangeListener) it.next()).onBackgroundStateChanged(z);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @KeepForSdk
    public void addListener(@NonNull BackgroundStateChangeListener backgroundStateChangeListener) {
        synchronized (f13081e) {
            this.f13084c.add(backgroundStateChangeListener);
        }
    }

    @KeepForSdk
    public boolean isInBackground() {
        return this.f13082a.get();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        AtomicBoolean atomicBoolean = this.f13083b;
        boolean compareAndSet = this.f13082a.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (compareAndSet) {
            m3083a(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(@NonNull Activity activity) {
        AtomicBoolean atomicBoolean = this.f13083b;
        boolean compareAndSet = this.f13082a.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (compareAndSet) {
            m3083a(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(@NonNull Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(@NonNull Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        if (i == 20 && this.f13082a.compareAndSet(false, true)) {
            this.f13083b.set(true);
            m3083a(true);
        }
    }

    @KeepForSdk
    public boolean readCurrentStateIfPossible(boolean z) {
        AtomicBoolean atomicBoolean = this.f13083b;
        if (!atomicBoolean.get()) {
            if (!ProcessUtils.zza()) {
                ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                ActivityManager.getMyMemoryState(runningAppProcessInfo);
                if (!atomicBoolean.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                    this.f13082a.set(true);
                }
            } else {
                return z;
            }
        }
        return isInBackground();
    }
}
