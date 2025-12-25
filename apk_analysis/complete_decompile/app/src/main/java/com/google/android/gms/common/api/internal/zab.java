package com.google.android.gms.common.api.internal;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.ref.WeakReference;
import p000.v63;

/* loaded from: classes.dex */
public final class zab extends ActivityLifecycleObserver {

    /* renamed from: a */
    public final WeakReference f13217a;

    public zab(v63 v63Var) {
        this.f13217a = new WeakReference(v63Var);
    }

    @Override // com.google.android.gms.common.api.internal.ActivityLifecycleObserver
    @CanIgnoreReturnValue
    public final ActivityLifecycleObserver onStopCallOnce(Runnable runnable) {
        v63 v63Var = (v63) this.f13217a.get();
        if (v63Var != null) {
            synchronized (v63Var) {
                v63Var.f27662a.add(runnable);
            }
            return this;
        }
        throw new IllegalStateException("The target activity has already been GC'd");
    }
}
