package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient;

/* renamed from: com.google.android.gms.common.internal.a */
/* loaded from: classes.dex */
public final class C0754a implements BaseGmsClient.BaseConnectionCallbacks {

    /* renamed from: a */
    public final /* synthetic */ ConnectionCallbacks f13476a;

    public C0754a(ConnectionCallbacks connectionCallbacks) {
        this.f13476a = connectionCallbacks;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        this.f13476a.onConnected(bundle);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        this.f13476a.onConnectionSuspended(i);
    }
}
