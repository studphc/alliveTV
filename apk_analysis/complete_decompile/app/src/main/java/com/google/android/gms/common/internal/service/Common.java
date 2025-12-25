package com.google.android.gms.common.internal.service;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;

/* loaded from: classes.dex */
public final class Common {

    @NonNull
    @KeepForSdk
    public static final Api<Api.ApiOptions.NoOptions> API;

    @NonNull
    @KeepForSdk
    public static final Api.ClientKey<zah> CLIENT_KEY;
    public static final zae zaa;

    static {
        Api.ClientKey<zah> clientKey = new Api.ClientKey<>();
        CLIENT_KEY = clientKey;
        API = new Api<>("Common.API", new Api.AbstractClientBuilder(), clientKey);
        zaa = new zae();
    }
}
