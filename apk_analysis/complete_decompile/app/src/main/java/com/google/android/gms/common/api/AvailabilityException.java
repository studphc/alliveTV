package com.google.android.gms.common.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import p000.ye0;

/* loaded from: classes.dex */
public class AvailabilityException extends Exception {

    /* renamed from: a */
    public final ArrayMap f13016a;

    public AvailabilityException(@NonNull ArrayMap arrayMap) {
        this.f13016a = arrayMap;
    }

    @NonNull
    public ConnectionResult getConnectionResult(@NonNull GoogleApi<? extends Api.ApiOptions> googleApi) {
        ApiKey<? extends Api.ApiOptions> apiKey = googleApi.getApiKey();
        ArrayMap arrayMap = this.f13016a;
        Object obj = arrayMap.get(apiKey);
        Preconditions.checkArgument(obj != null, ye0.m8296p("The given API (", apiKey.zaa(), ") was not part of the availability request."));
        return (ConnectionResult) Preconditions.checkNotNull((ConnectionResult) arrayMap.get(apiKey));
    }

    @Override // java.lang.Throwable
    @NonNull
    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        ArrayMap arrayMap = this.f13016a;
        boolean z = true;
        for (ApiKey apiKey : arrayMap.keySet()) {
            ConnectionResult connectionResult = (ConnectionResult) Preconditions.checkNotNull((ConnectionResult) arrayMap.get(apiKey));
            z &= !connectionResult.isSuccess();
            arrayList.add(apiKey.zaa() + ": " + String.valueOf(connectionResult));
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("None of the queried APIs are available. ");
        } else {
            sb.append("Some of the queried APIs are unavailable. ");
        }
        sb.append(TextUtils.join("; ", arrayList));
        return sb.toString();
    }

    @NonNull
    public ConnectionResult getConnectionResult(@NonNull HasApiKey<? extends Api.ApiOptions> hasApiKey) {
        ApiKey<? extends Api.ApiOptions> apiKey = hasApiKey.getApiKey();
        ArrayMap arrayMap = this.f13016a;
        Object obj = arrayMap.get(apiKey);
        Preconditions.checkArgument(obj != null, ye0.m8296p("The given API (", apiKey.zaa(), ") was not part of the availability request."));
        return (ConnectionResult) Preconditions.checkNotNull((ConnectionResult) arrayMap.get(apiKey));
    }
}
