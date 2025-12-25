package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.common.api.internal.f */
/* loaded from: classes.dex */
public final class C0748f extends TaskApiCall {

    /* renamed from: d */
    public final /* synthetic */ TaskApiCall.Builder f13183d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0748f(TaskApiCall.Builder builder, Feature[] featureArr, boolean z, int i) {
        super(featureArr, z, i);
        this.f13183d = builder;
    }

    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final void doExecute(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) {
        this.f13183d.f13160a.accept(anyClient, taskCompletionSource);
    }
}
