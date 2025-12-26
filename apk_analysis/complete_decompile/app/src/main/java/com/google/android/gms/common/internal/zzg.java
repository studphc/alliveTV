package com.google.android.gms.common.internal;

import android.os.Bundle;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import p000.e93;

/* loaded from: classes.dex */
public final class zzg extends e93 {

    /* renamed from: e */
    public final /* synthetic */ BaseGmsClient f13526e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @BinderThread
    public zzg(BaseGmsClient baseGmsClient, @Nullable int i, Bundle bundle) {
        super(baseGmsClient, i, bundle);
        this.f13526e = baseGmsClient;
    }

    @Override // p000.e93
    public final void zzb(ConnectionResult connectionResult) {
        BaseGmsClient baseGmsClient = this.f13526e;
        if (baseGmsClient.enableLocalFallback() && BaseGmsClient.m3138c(baseGmsClient)) {
            BaseGmsClient.m3136a(baseGmsClient);
        } else {
            baseGmsClient.zzc.onReportServiceBinding(connectionResult);
            baseGmsClient.onConnectionFailed(connectionResult);
        }
    }

    @Override // p000.e93
    public final boolean zzd() {
        this.f13526e.zzc.onReportServiceBinding(ConnectionResult.RESULT_SUCCESS);
        return true;
    }
}
