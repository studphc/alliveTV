package com.bumptech.glide.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* renamed from: com.bumptech.glide.manager.a */
/* loaded from: classes.dex */
public final class C0635a extends BroadcastReceiver {

    /* renamed from: a */
    public final /* synthetic */ C0636b f8991a;

    public C0635a(C0636b c0636b) {
        this.f8991a = c0636b;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        C0636b c0636b = this.f8991a;
        boolean z = c0636b.f8994c;
        boolean m2375a = C0636b.m2375a(context);
        c0636b.f8994c = m2375a;
        if (z != m2375a) {
            if (Log.isLoggable("ConnectivityMonitor", 3)) {
                Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + c0636b.f8994c);
            }
            c0636b.f8993b.onConnectivityChanged(c0636b.f8994c);
        }
    }
}
