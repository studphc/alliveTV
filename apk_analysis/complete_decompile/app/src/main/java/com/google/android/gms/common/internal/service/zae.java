package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* loaded from: classes.dex */
public final class zae {
    public final PendingResult zaa(GoogleApiClient googleApiClient) {
        return googleApiClient.execute(new BaseImplementation.ApiMethodImpl(Common.API, googleApiClient));
    }
}
