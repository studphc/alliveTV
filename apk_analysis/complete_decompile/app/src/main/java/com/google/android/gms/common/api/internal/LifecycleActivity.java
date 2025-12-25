package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
/* loaded from: classes.dex */
public class LifecycleActivity {

    /* renamed from: a */
    public final Activity f13127a;

    public LifecycleActivity(@NonNull Activity activity) {
        Preconditions.checkNotNull(activity, "Activity must not be null");
        this.f13127a = activity;
    }

    @NonNull
    public final Activity zza() {
        return this.f13127a;
    }

    @NonNull
    public final FragmentActivity zzb() {
        return (FragmentActivity) this.f13127a;
    }

    public final boolean zzc() {
        return this.f13127a instanceof Activity;
    }

    public final boolean zzd() {
        return this.f13127a instanceof FragmentActivity;
    }

    @KeepForSdk
    @Deprecated
    public LifecycleActivity(@NonNull ContextWrapper contextWrapper) {
        throw new UnsupportedOperationException();
    }
}
