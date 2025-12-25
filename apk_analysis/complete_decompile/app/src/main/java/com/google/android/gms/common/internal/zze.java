package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import androidx.annotation.VisibleForTesting;

@VisibleForTesting
/* loaded from: classes.dex */
public final class zze implements ServiceConnection {

    /* renamed from: a */
    public final int f13523a;

    /* renamed from: b */
    public final /* synthetic */ BaseGmsClient f13524b;

    public zze(BaseGmsClient baseGmsClient, int i) {
        this.f13524b = baseGmsClient;
        this.f13523a = i;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        IGmsServiceBroker c0759f;
        BaseGmsClient baseGmsClient = this.f13524b;
        if (iBinder == null) {
            BaseGmsClient.m3136a(baseGmsClient);
            return;
        }
        synchronized (baseGmsClient.f13383n) {
            try {
                BaseGmsClient baseGmsClient2 = this.f13524b;
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                if (queryLocalInterface != null && (queryLocalInterface instanceof IGmsServiceBroker)) {
                    c0759f = (IGmsServiceBroker) queryLocalInterface;
                } else {
                    c0759f = new C0759f(iBinder);
                }
                baseGmsClient2.f13384o = c0759f;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f13524b.zzl(0, null, this.f13523a);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        BaseGmsClient baseGmsClient;
        synchronized (this.f13524b.f13383n) {
            baseGmsClient = this.f13524b;
            baseGmsClient.f13384o = null;
        }
        int i = this.f13523a;
        Handler handler = baseGmsClient.f13381l;
        handler.sendMessage(handler.obtainMessage(6, i, 1));
    }
}
