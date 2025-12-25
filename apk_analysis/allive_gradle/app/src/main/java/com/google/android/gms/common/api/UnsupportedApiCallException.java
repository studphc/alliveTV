package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;

/* loaded from: classes.dex */
public final class UnsupportedApiCallException extends UnsupportedOperationException {

    /* renamed from: a */
    public final Feature f13075a;

    @KeepForSdk
    public UnsupportedApiCallException(@NonNull Feature feature) {
        this.f13075a = feature;
    }

    @Override // java.lang.Throwable
    @NonNull
    public String getMessage() {
        return "Missing ".concat(String.valueOf(this.f13075a));
    }
}
