package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
/* loaded from: classes.dex */
public abstract class RegisterListenerMethod<A extends Api.AnyClient, L> {

    /* renamed from: a */
    public final ListenerHolder f13145a;

    /* renamed from: b */
    public final Feature[] f13146b;

    /* renamed from: c */
    public final boolean f13147c;

    /* renamed from: d */
    public final int f13148d;

    @KeepForSdk
    public RegisterListenerMethod(@NonNull ListenerHolder<L> listenerHolder, @Nullable Feature[] featureArr, boolean z, int i) {
        this.f13145a = listenerHolder;
        this.f13146b = featureArr;
        this.f13147c = z;
        this.f13148d = i;
    }

    @KeepForSdk
    public void clearListener() {
        this.f13145a.clear();
    }

    @Nullable
    @KeepForSdk
    public ListenerHolder.ListenerKey<L> getListenerKey() {
        return this.f13145a.getListenerKey();
    }

    @Nullable
    @KeepForSdk
    public Feature[] getRequiredFeatures() {
        return this.f13146b;
    }

    @KeepForSdk
    public abstract void registerListener(@NonNull A a, @NonNull TaskCompletionSource<Void> taskCompletionSource);

    public final int zaa() {
        return this.f13148d;
    }

    public final boolean zab() {
        return this.f13147c;
    }

    @KeepForSdk
    public RegisterListenerMethod(@NonNull ListenerHolder<L> listenerHolder) {
        this(listenerHolder, null, false, 0);
    }

    @KeepForSdk
    public RegisterListenerMethod(@NonNull ListenerHolder<L> listenerHolder, @NonNull Feature[] featureArr, boolean z) {
        this(listenerHolder, featureArr, z, 0);
    }
}
