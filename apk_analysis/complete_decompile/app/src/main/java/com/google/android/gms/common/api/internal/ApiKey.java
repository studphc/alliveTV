package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.internal.Objects;

@KeepForSdk
/* loaded from: classes.dex */
public final class ApiKey<O extends Api.ApiOptions> {

    /* renamed from: a */
    public final int f13077a;

    /* renamed from: b */
    public final Api f13078b;

    /* renamed from: c */
    public final Api.ApiOptions f13079c;

    /* renamed from: d */
    public final String f13080d;

    public ApiKey(Api api, Api.ApiOptions apiOptions, String str) {
        this.f13078b = api;
        this.f13079c = apiOptions;
        this.f13080d = str;
        this.f13077a = Objects.hashCode(api, apiOptions, str);
    }

    @NonNull
    @KeepForSdk
    public static <O extends Api.ApiOptions> ApiKey<O> getSharedApiKey(@NonNull Api<O> api, @Nullable O o, @Nullable String str) {
        return new ApiKey<>(api, o, str);
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApiKey)) {
            return false;
        }
        ApiKey apiKey = (ApiKey) obj;
        if (!Objects.equal(this.f13078b, apiKey.f13078b) || !Objects.equal(this.f13079c, apiKey.f13079c) || !Objects.equal(this.f13080d, apiKey.f13080d)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f13077a;
    }

    @NonNull
    public final String zaa() {
        return this.f13078b.zad();
    }
}
