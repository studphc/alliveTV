package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.internal.common.zzh;
import p000.ye0;

/* renamed from: com.google.android.gms.common.internal.g */
/* loaded from: classes.dex */
public final class HandlerC0760g extends zzh {

    /* renamed from: a */
    public final /* synthetic */ BaseGmsClient f13483a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC0760g(BaseGmsClient baseGmsClient, Looper looper) {
        super(looper);
        this.f13483a = baseGmsClient;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        BaseGmsClient baseGmsClient = this.f13483a;
        if (baseGmsClient.zzd.get() != message.arg1) {
            int i = message.what;
            if (i != 2 && i != 1 && i != 7) {
                return;
            }
            zzc zzcVar = (zzc) message.obj;
            zzcVar.zzc();
            zzcVar.zzg();
            return;
        }
        int i2 = message.what;
        if ((i2 != 1 && i2 != 7 && ((i2 != 4 || baseGmsClient.enableLocalFallback()) && message.what != 5)) || baseGmsClient.isConnecting()) {
            int i3 = message.what;
            PendingIntent pendingIntent = null;
            if (i3 == 4) {
                baseGmsClient.f13395z = new ConnectionResult(message.arg2);
                if (BaseGmsClient.m3138c(baseGmsClient) && !baseGmsClient.f13368A) {
                    baseGmsClient.m3139d(null, 3);
                    return;
                }
                ConnectionResult connectionResult = baseGmsClient.f13395z;
                if (connectionResult == null) {
                    connectionResult = new ConnectionResult(8);
                }
                baseGmsClient.zzc.onReportServiceBinding(connectionResult);
                baseGmsClient.onConnectionFailed(connectionResult);
                return;
            }
            if (i3 == 5) {
                ConnectionResult connectionResult2 = baseGmsClient.f13395z;
                if (connectionResult2 == null) {
                    connectionResult2 = new ConnectionResult(8);
                }
                baseGmsClient.zzc.onReportServiceBinding(connectionResult2);
                baseGmsClient.onConnectionFailed(connectionResult2);
                return;
            }
            if (i3 == 3) {
                Object obj = message.obj;
                if (obj instanceof PendingIntent) {
                    pendingIntent = (PendingIntent) obj;
                }
                ConnectionResult connectionResult3 = new ConnectionResult(message.arg2, pendingIntent);
                baseGmsClient.zzc.onReportServiceBinding(connectionResult3);
                baseGmsClient.onConnectionFailed(connectionResult3);
                return;
            }
            if (i3 == 6) {
                baseGmsClient.m3139d(null, 5);
                BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks = baseGmsClient.f13389t;
                if (baseConnectionCallbacks != null) {
                    baseConnectionCallbacks.onConnectionSuspended(message.arg2);
                }
                baseGmsClient.onConnectionSuspended(message.arg2);
                BaseGmsClient.m3137b(baseGmsClient, 5, 1, null);
                return;
            }
            if (i3 == 2 && !baseGmsClient.isConnected()) {
                zzc zzcVar2 = (zzc) message.obj;
                zzcVar2.zzc();
                zzcVar2.zzg();
                return;
            }
            int i4 = message.what;
            if (i4 != 2 && i4 != 1 && i4 != 7) {
                Log.wtf("GmsClient", ye0.m8291k(i4, "Don't know how to handle message: "), new Exception());
                return;
            } else {
                ((zzc) message.obj).zze();
                return;
            }
        }
        zzc zzcVar3 = (zzc) message.obj;
        zzcVar3.zzc();
        zzcVar3.zzg();
    }
}
