package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import p000.e93;

/* loaded from: classes.dex */
public final class zzf extends e93 {

    /* renamed from: e */
    public final /* synthetic */ BaseGmsClient f13525e;

    @Nullable
    public final IBinder zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @BinderThread
    public zzf(BaseGmsClient baseGmsClient, @Nullable int i, @Nullable IBinder iBinder, Bundle bundle) {
        super(baseGmsClient, i, bundle);
        this.f13525e = baseGmsClient;
        this.zze = iBinder;
    }

    @Override // p000.e93
    public final void zzb(ConnectionResult connectionResult) {
        BaseGmsClient baseGmsClient = this.f13525e;
        BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener = baseGmsClient.f13390u;
        if (baseOnConnectionFailedListener != null) {
            baseOnConnectionFailedListener.onConnectionFailed(connectionResult);
        }
        baseGmsClient.onConnectionFailed(connectionResult);
    }

    @Override // p000.e93
    public final boolean zzd() {
        try {
            IBinder iBinder = this.zze;
            Preconditions.checkNotNull(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            BaseGmsClient baseGmsClient = this.f13525e;
            if (!baseGmsClient.getServiceDescriptor().equals(interfaceDescriptor)) {
                Log.w("GmsClient", "service descriptor mismatch: " + baseGmsClient.getServiceDescriptor() + " vs. " + interfaceDescriptor);
                return false;
            }
            IInterface createServiceInterface = baseGmsClient.createServiceInterface(this.zze);
            if (createServiceInterface == null || (!BaseGmsClient.m3137b(baseGmsClient, 2, 4, createServiceInterface) && !BaseGmsClient.m3137b(baseGmsClient, 3, 4, createServiceInterface))) {
                return false;
            }
            baseGmsClient.f13395z = null;
            Bundle connectionHint = baseGmsClient.getConnectionHint();
            if (baseGmsClient.f13389t != null) {
                baseGmsClient.f13389t.onConnected(connectionHint);
                return true;
            }
            return true;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}
