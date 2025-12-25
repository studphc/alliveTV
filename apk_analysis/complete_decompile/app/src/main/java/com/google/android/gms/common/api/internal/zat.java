package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
public final class zat implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: a */
    public final boolean f13306a;

    /* renamed from: b */
    public zau f13307b;
    public final Api zaa;

    public zat(Api api, boolean z) {
        this.zaa = api;
        this.f13306a = z;
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(@Nullable Bundle bundle) {
        Preconditions.checkNotNull(this.f13307b, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
        this.f13307b.onConnected(bundle);
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Api api = this.zaa;
        Preconditions.checkNotNull(this.f13307b, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
        this.f13307b.zaa(connectionResult, api, this.f13306a);
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        Preconditions.checkNotNull(this.f13307b, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
        this.f13307b.onConnectionSuspended(i);
    }

    public final void zaa(zau zauVar) {
        this.f13307b = zauVar;
    }
}
