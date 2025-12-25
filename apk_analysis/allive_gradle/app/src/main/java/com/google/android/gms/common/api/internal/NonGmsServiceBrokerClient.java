package com.google.android.gms.common.api.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Set;

@KeepForSdk
/* loaded from: classes.dex */
public final class NonGmsServiceBrokerClient implements Api.Client, ServiceConnection {

    /* renamed from: a */
    public final String f13134a;

    /* renamed from: b */
    public final String f13135b;

    /* renamed from: c */
    public final ComponentName f13136c;

    /* renamed from: d */
    public final Context f13137d;

    /* renamed from: e */
    public final ConnectionCallbacks f13138e;

    /* renamed from: f */
    public final com.google.android.gms.internal.base.zau f13139f;

    /* renamed from: g */
    public final OnConnectionFailedListener f13140g;

    /* renamed from: h */
    public IBinder f13141h;

    /* renamed from: i */
    public boolean f13142i;

    /* renamed from: j */
    public String f13143j;

    @KeepForSdk
    public NonGmsServiceBrokerClient(@NonNull Context context, @NonNull Looper looper, @NonNull ComponentName componentName, @NonNull ConnectionCallbacks connectionCallbacks, @NonNull OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, null, null, componentName, connectionCallbacks, onConnectionFailedListener);
    }

    /* renamed from: a */
    public final void m3091a() {
        if (Thread.currentThread() == this.f13139f.getLooper().getThread()) {
        } else {
            throw new IllegalStateException("This method should only run on the NonGmsServiceBrokerClient's handler thread.");
        }
    }

    @Override // com.google.android.gms.common.api.Api.Client
    @WorkerThread
    public final void connect(@NonNull BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        m3091a();
        String.valueOf(this.f13141h);
        if (isConnected()) {
            try {
                disconnect("connect() called when already connected");
            } catch (Exception unused) {
            }
        }
        try {
            Intent intent = new Intent();
            ComponentName componentName = this.f13136c;
            if (componentName != null) {
                intent.setComponent(componentName);
            } else {
                intent.setPackage(this.f13134a).setAction(this.f13135b);
            }
            boolean bindService = this.f13137d.bindService(intent, this, GmsClientSupervisor.getDefaultBindFlags());
            this.f13142i = bindService;
            if (!bindService) {
                this.f13141h = null;
                this.f13140g.onConnectionFailed(new ConnectionResult(16));
            }
            String.valueOf(this.f13141h);
        } catch (SecurityException e) {
            this.f13142i = false;
            this.f13141h = null;
            throw e;
        }
    }

    @Override // com.google.android.gms.common.api.Api.Client
    @WorkerThread
    public final void disconnect() {
        m3091a();
        String.valueOf(this.f13141h);
        try {
            this.f13137d.unbindService(this);
        } catch (IllegalArgumentException unused) {
        }
        this.f13142i = false;
        this.f13141h = null;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final void dump(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
    }

    @Override // com.google.android.gms.common.api.Api.Client
    @NonNull
    public final Feature[] getAvailableFeatures() {
        return new Feature[0];
    }

    @Nullable
    @KeepForSdk
    @WorkerThread
    public IBinder getBinder() {
        m3091a();
        return this.f13141h;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    @NonNull
    public final String getEndpointPackageName() {
        String str = this.f13134a;
        if (str != null) {
            return str;
        }
        ComponentName componentName = this.f13136c;
        Preconditions.checkNotNull(componentName);
        return componentName.getPackageName();
    }

    @Override // com.google.android.gms.common.api.Api.Client
    @Nullable
    public final String getLastDisconnectMessage() {
        return this.f13143j;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 0;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final void getRemoteService(@Nullable IAccountAccessor iAccountAccessor, @Nullable Set<Scope> set) {
    }

    @Override // com.google.android.gms.common.api.Api.Client
    @NonNull
    public final Feature[] getRequiredFeatures() {
        return new Feature[0];
    }

    @Override // com.google.android.gms.common.api.Api.Client
    @NonNull
    public final Set<Scope> getScopesForConnectionlessNonSignIn() {
        return Collections.emptySet();
    }

    @Override // com.google.android.gms.common.api.Api.Client
    @Nullable
    public final IBinder getServiceBrokerBinder() {
        return null;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    @NonNull
    public final Intent getSignInIntent() {
        return new Intent();
    }

    @Override // com.google.android.gms.common.api.Api.Client
    @WorkerThread
    public final boolean isConnected() {
        m3091a();
        if (this.f13141h != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    @WorkerThread
    public final boolean isConnecting() {
        m3091a();
        return this.f13142i;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(@NonNull ComponentName componentName, @NonNull final IBinder iBinder) {
        this.f13139f.post(new Runnable() { // from class: com.google.android.gms.common.api.internal.zacg
            @Override // java.lang.Runnable
            public final void run() {
                NonGmsServiceBrokerClient nonGmsServiceBrokerClient = NonGmsServiceBrokerClient.this;
                IBinder iBinder2 = iBinder;
                nonGmsServiceBrokerClient.f13142i = false;
                nonGmsServiceBrokerClient.f13141h = iBinder2;
                String.valueOf(iBinder2);
                nonGmsServiceBrokerClient.f13138e.onConnected(new Bundle());
            }
        });
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(@NonNull ComponentName componentName) {
        this.f13139f.post(new Runnable() { // from class: com.google.android.gms.common.api.internal.zacf
            @Override // java.lang.Runnable
            public final void run() {
                NonGmsServiceBrokerClient nonGmsServiceBrokerClient = NonGmsServiceBrokerClient.this;
                nonGmsServiceBrokerClient.f13142i = false;
                nonGmsServiceBrokerClient.f13141h = null;
                nonGmsServiceBrokerClient.f13138e.onConnectionSuspended(1);
            }
        });
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final void onUserSignOut(@NonNull BaseGmsClient.SignOutCallbacks signOutCallbacks) {
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final boolean providesSignIn() {
        return false;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final boolean requiresAccount() {
        return false;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final boolean requiresGooglePlayServices() {
        return false;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final boolean requiresSignIn() {
        return false;
    }

    public final void zac(@Nullable String str) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001e, code lost:
    
        if (r6 != null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public NonGmsServiceBrokerClient(Context context, Looper looper, String str, String str2, ComponentName componentName, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        this.f13142i = false;
        this.f13143j = null;
        this.f13137d = context;
        this.f13139f = new com.google.android.gms.internal.base.zau(looper);
        this.f13138e = connectionCallbacks;
        this.f13140g = onConnectionFailedListener;
        if (str != null && str2 != null) {
            if (componentName == null) {
                componentName = null;
                this.f13134a = str;
                this.f13135b = str2;
                this.f13136c = componentName;
                return;
            }
            throw new AssertionError("Must specify either package or component, but not both");
        }
    }

    @KeepForSdk
    public NonGmsServiceBrokerClient(@NonNull Context context, @NonNull Looper looper, @NonNull String str, @NonNull String str2, @NonNull ConnectionCallbacks connectionCallbacks, @NonNull OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, str, str2, null, connectionCallbacks, onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.Api.Client
    @WorkerThread
    public final void disconnect(@NonNull String str) {
        m3091a();
        this.f13143j = str;
        disconnect();
    }
}
