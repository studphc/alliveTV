package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.IStatusCallback;

@KeepForSdk
/* loaded from: classes.dex */
public class StatusCallback extends IStatusCallback.Stub {

    /* renamed from: a */
    public final BaseImplementation.ResultHolder f13156a;

    @KeepForSdk
    public StatusCallback(@NonNull BaseImplementation.ResultHolder<Status> resultHolder) {
        this.f13156a = resultHolder;
    }

    @Override // com.google.android.gms.common.api.internal.IStatusCallback
    @KeepForSdk
    public void onResult(@NonNull Status status) {
        this.f13156a.setResult(status);
    }
}
