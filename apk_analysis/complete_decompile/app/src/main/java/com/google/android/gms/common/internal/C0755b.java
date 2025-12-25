package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.BaseGmsClient;

/* renamed from: com.google.android.gms.common.internal.b */
/* loaded from: classes.dex */
public final class C0755b implements BaseGmsClient.BaseOnConnectionFailedListener {

    /* renamed from: a */
    public final /* synthetic */ OnConnectionFailedListener f13477a;

    public C0755b(OnConnectionFailedListener onConnectionFailedListener) {
        this.f13477a = onConnectionFailedListener;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.f13477a.onConnectionFailed(connectionResult);
    }
}
