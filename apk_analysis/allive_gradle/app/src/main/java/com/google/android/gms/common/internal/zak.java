package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import p000.ye0;

/* loaded from: classes.dex */
public final class zak implements Handler.Callback {

    /* renamed from: a */
    public final zaj f13488a;

    /* renamed from: h */
    public final com.google.android.gms.internal.base.zau f13495h;

    /* renamed from: b */
    public final ArrayList f13489b = new ArrayList();

    /* renamed from: c */
    public final ArrayList f13490c = new ArrayList();

    /* renamed from: d */
    public final ArrayList f13491d = new ArrayList();

    /* renamed from: e */
    public volatile boolean f13492e = false;

    /* renamed from: f */
    public final AtomicInteger f13493f = new AtomicInteger(0);

    /* renamed from: g */
    public boolean f13494g = false;

    /* renamed from: i */
    public final Object f13496i = new Object();

    public zak(Looper looper, zaj zajVar) {
        this.f13488a = zajVar;
        this.f13495h = new com.google.android.gms.internal.base.zau(looper, this);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) message.obj;
            synchronized (this.f13496i) {
                try {
                    if (this.f13492e && this.f13488a.isConnected() && this.f13489b.contains(connectionCallbacks)) {
                        connectionCallbacks.onConnected(null);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return true;
        }
        Log.wtf("GmsClientEvents", ye0.m8291k(i, "Don't know how to handle message: "), new Exception());
        return false;
    }

    public final void zaa() {
        this.f13492e = false;
        this.f13493f.incrementAndGet();
    }

    public final void zab() {
        this.f13492e = true;
    }

    @VisibleForTesting
    public final void zac(ConnectionResult connectionResult) {
        Preconditions.checkHandlerThread(this.f13495h, "onConnectionFailure must only be called on the Handler thread");
        this.f13495h.removeMessages(1);
        synchronized (this.f13496i) {
            try {
                ArrayList arrayList = new ArrayList(this.f13491d);
                int i = this.f13493f.get();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = (GoogleApiClient.OnConnectionFailedListener) it.next();
                    if (this.f13492e && this.f13493f.get() == i) {
                        if (this.f13491d.contains(onConnectionFailedListener)) {
                            onConnectionFailedListener.onConnectionFailed(connectionResult);
                        }
                    }
                    return;
                }
            } finally {
            }
        }
    }

    @VisibleForTesting
    public final void zad(@Nullable Bundle bundle) {
        Preconditions.checkHandlerThread(this.f13495h, "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.f13496i) {
            try {
                Preconditions.checkState(!this.f13494g);
                this.f13495h.removeMessages(1);
                this.f13494g = true;
                Preconditions.checkState(this.f13490c.isEmpty());
                ArrayList arrayList = new ArrayList(this.f13489b);
                int i = this.f13493f.get();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) it.next();
                    if (!this.f13492e || !this.f13488a.isConnected() || this.f13493f.get() != i) {
                        break;
                    } else if (!this.f13490c.contains(connectionCallbacks)) {
                        connectionCallbacks.onConnected(bundle);
                    }
                }
                this.f13490c.clear();
                this.f13494g = false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @VisibleForTesting
    public final void zae(int i) {
        Preconditions.checkHandlerThread(this.f13495h, "onUnintentionalDisconnection must only be called on the Handler thread");
        this.f13495h.removeMessages(1);
        synchronized (this.f13496i) {
            try {
                this.f13494g = true;
                ArrayList arrayList = new ArrayList(this.f13489b);
                int i2 = this.f13493f.get();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) it.next();
                    if (!this.f13492e || this.f13493f.get() != i2) {
                        break;
                    } else if (this.f13489b.contains(connectionCallbacks)) {
                        connectionCallbacks.onConnectionSuspended(i);
                    }
                }
                this.f13490c.clear();
                this.f13494g = false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zaf(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        Preconditions.checkNotNull(connectionCallbacks);
        synchronized (this.f13496i) {
            try {
                if (this.f13489b.contains(connectionCallbacks)) {
                    Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + String.valueOf(connectionCallbacks) + " is already registered");
                } else {
                    this.f13489b.add(connectionCallbacks);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (this.f13488a.isConnected()) {
            com.google.android.gms.internal.base.zau zauVar = this.f13495h;
            zauVar.sendMessage(zauVar.obtainMessage(1, connectionCallbacks));
        }
    }

    public final void zag(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.checkNotNull(onConnectionFailedListener);
        synchronized (this.f13496i) {
            try {
                if (this.f13491d.contains(onConnectionFailedListener)) {
                    Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + String.valueOf(onConnectionFailedListener) + " is already registered");
                } else {
                    this.f13491d.add(onConnectionFailedListener);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zah(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        Preconditions.checkNotNull(connectionCallbacks);
        synchronized (this.f13496i) {
            try {
                if (!this.f13489b.remove(connectionCallbacks)) {
                    Log.w("GmsClientEvents", "unregisterConnectionCallbacks(): listener " + String.valueOf(connectionCallbacks) + " not found");
                } else if (this.f13494g) {
                    this.f13490c.add(connectionCallbacks);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zai(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.checkNotNull(onConnectionFailedListener);
        synchronized (this.f13496i) {
            try {
                if (!this.f13491d.remove(onConnectionFailedListener)) {
                    Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + String.valueOf(onConnectionFailedListener) + " not found");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean zaj(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        boolean contains;
        Preconditions.checkNotNull(connectionCallbacks);
        synchronized (this.f13496i) {
            contains = this.f13489b.contains(connectionCallbacks);
        }
        return contains;
    }

    public final boolean zak(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        boolean contains;
        Preconditions.checkNotNull(onConnectionFailedListener);
        synchronized (this.f13496i) {
            contains = this.f13491d.contains(onConnectionFailedListener);
        }
        return contains;
    }
}
