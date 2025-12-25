package p000;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.api.internal.zabe;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.service.Common;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class j73 implements GoogleApiClient.ConnectionCallbacks {

    /* renamed from: a */
    public final /* synthetic */ AtomicReference f20405a;

    /* renamed from: b */
    public final /* synthetic */ StatusPendingResult f20406b;

    /* renamed from: c */
    public final /* synthetic */ zabe f20407c;

    public j73(zabe zabeVar, AtomicReference atomicReference, StatusPendingResult statusPendingResult) {
        this.f20407c = zabeVar;
        this.f20405a = atomicReference;
        this.f20406b = statusPendingResult;
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        GoogleApiClient googleApiClient = (GoogleApiClient) Preconditions.checkNotNull((GoogleApiClient) this.f20405a.get());
        int i = zabe.f13218y;
        StatusPendingResult statusPendingResult = this.f20406b;
        zabe zabeVar = this.f20407c;
        zabeVar.getClass();
        Common.zaa.zaa(googleApiClient).setResultCallback(new o73(zabeVar, statusPendingResult, true, googleApiClient));
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }
}
