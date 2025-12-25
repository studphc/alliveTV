package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
/* loaded from: classes.dex */
public abstract class UnregisterListenerMethod<A extends Api.AnyClient, L> {

    /* renamed from: a */
    public final ListenerHolder.ListenerKey f13164a;

    @KeepForSdk
    public UnregisterListenerMethod(@NonNull ListenerHolder.ListenerKey<L> listenerKey) {
        this.f13164a = listenerKey;
    }

    @NonNull
    @KeepForSdk
    public ListenerHolder.ListenerKey<L> getListenerKey() {
        return this.f13164a;
    }

    @KeepForSdk
    public abstract void unregisterListener(@NonNull A a, @NonNull TaskCompletionSource<Boolean> taskCompletionSource);
}
