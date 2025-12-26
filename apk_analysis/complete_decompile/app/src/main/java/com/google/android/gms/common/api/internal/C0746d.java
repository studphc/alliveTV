package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.common.api.internal.d */
/* loaded from: classes.dex */
public final class C0746d extends RegisterListenerMethod {

    /* renamed from: e */
    public final /* synthetic */ RegistrationMethods.Builder f13181e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0746d(RegistrationMethods.Builder builder, ListenerHolder listenerHolder, Feature[] featureArr, boolean z, int i) {
        super(listenerHolder, featureArr, z, i);
        this.f13181e = builder;
    }

    @Override // com.google.android.gms.common.api.internal.RegisterListenerMethod
    public final void registerListener(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) {
        this.f13181e.f13149a.accept(anyClient, taskCompletionSource);
    }
}
