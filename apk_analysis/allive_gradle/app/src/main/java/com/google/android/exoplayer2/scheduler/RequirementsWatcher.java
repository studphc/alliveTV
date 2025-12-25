package com.google.android.exoplayer2.scheduler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Handler;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import p000.C1150e9;
import p000.qb2;

/* loaded from: classes.dex */
public final class RequirementsWatcher {

    /* renamed from: a */
    public final Context f10892a;

    /* renamed from: b */
    public final Listener f10893b;

    /* renamed from: c */
    public final Requirements f10894c;

    /* renamed from: d */
    public final Handler f10895d = Util.createHandlerForCurrentOrMainLooper();

    /* renamed from: e */
    public C1150e9 f10896e;

    /* renamed from: f */
    public int f10897f;

    /* renamed from: g */
    public qb2 f10898g;

    /* loaded from: classes.dex */
    public interface Listener {
        void onRequirementsStateChanged(RequirementsWatcher requirementsWatcher, int i);
    }

    public RequirementsWatcher(Context context, Listener listener, Requirements requirements) {
        this.f10892a = context.getApplicationContext();
        this.f10893b = listener;
        this.f10894c = requirements;
    }

    /* renamed from: a */
    public final void m2725a() {
        int notMetRequirements = this.f10894c.getNotMetRequirements(this.f10892a);
        if (this.f10897f != notMetRequirements) {
            this.f10897f = notMetRequirements;
            this.f10893b.onRequirementsStateChanged(this, notMetRequirements);
        }
    }

    public Requirements getRequirements() {
        return this.f10894c;
    }

    public int start() {
        Requirements requirements = this.f10894c;
        Context context = this.f10892a;
        this.f10897f = requirements.getNotMetRequirements(context);
        IntentFilter intentFilter = new IntentFilter();
        if (requirements.isNetworkRequired()) {
            if (Util.SDK_INT >= 24) {
                ConnectivityManager connectivityManager = (ConnectivityManager) Assertions.checkNotNull((ConnectivityManager) context.getSystemService("connectivity"));
                qb2 qb2Var = new qb2(this);
                this.f10898g = qb2Var;
                connectivityManager.registerDefaultNetworkCallback(qb2Var);
            } else {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
        }
        if (requirements.isChargingRequired()) {
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        }
        if (requirements.isIdleRequired()) {
            if (Util.SDK_INT >= 23) {
                intentFilter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
            } else {
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
            }
        }
        if (requirements.isStorageNotLowRequired()) {
            intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
            intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        }
        C1150e9 c1150e9 = new C1150e9(4, this);
        this.f10896e = c1150e9;
        context.registerReceiver(c1150e9, intentFilter, null, this.f10895d);
        return this.f10897f;
    }

    public void stop() {
        BroadcastReceiver broadcastReceiver = (BroadcastReceiver) Assertions.checkNotNull(this.f10896e);
        Context context = this.f10892a;
        context.unregisterReceiver(broadcastReceiver);
        this.f10896e = null;
        if (Util.SDK_INT >= 24 && this.f10898g != null) {
            ((ConnectivityManager) Assertions.checkNotNull((ConnectivityManager) context.getSystemService("connectivity"))).unregisterNetworkCallback((ConnectivityManager.NetworkCallback) Assertions.checkNotNull(this.f10898g));
            this.f10898g = null;
        }
    }
}
