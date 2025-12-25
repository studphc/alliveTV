package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.BinderThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.signin.zad;
import java.util.Set;
import p000.sn1;
import p000.xy1;

/* loaded from: classes.dex */
public final class zact extends com.google.android.gms.signin.internal.zac implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: h */
    public static final Api.AbstractClientBuilder f13277h = zad.zac;

    /* renamed from: a */
    public final Context f13278a;

    /* renamed from: b */
    public final Handler f13279b;

    /* renamed from: c */
    public final Api.AbstractClientBuilder f13280c = f13277h;

    /* renamed from: d */
    public final Set f13281d;

    /* renamed from: e */
    public final ClientSettings f13282e;

    /* renamed from: f */
    public com.google.android.gms.signin.zae f13283f;

    /* renamed from: g */
    public zacs f13284g;

    @WorkerThread
    public zact(Context context, Handler handler, @NonNull ClientSettings clientSettings) {
        this.f13278a = context;
        this.f13279b = handler;
        this.f13282e = (ClientSettings) Preconditions.checkNotNull(clientSettings, "ClientSettings must not be null");
        this.f13281d = clientSettings.getRequiredScopes();
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    @WorkerThread
    public final void onConnected(@Nullable Bundle bundle) {
        this.f13283f.zad(this);
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    @WorkerThread
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        this.f13284g.zae(connectionResult);
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    @WorkerThread
    public final void onConnectionSuspended(int i) {
        this.f13284g.zag(i);
    }

    @Override // com.google.android.gms.signin.internal.zac, com.google.android.gms.signin.internal.zae
    @BinderThread
    public final void zab(com.google.android.gms.signin.internal.zak zakVar) {
        this.f13279b.post(new xy1(20, this, zakVar));
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.gms.common.api.Api$Client, com.google.android.gms.signin.zae] */
    @WorkerThread
    public final void zae(zacs zacsVar) {
        com.google.android.gms.signin.zae zaeVar = this.f13283f;
        if (zaeVar != null) {
            zaeVar.disconnect();
        }
        Integer valueOf = Integer.valueOf(System.identityHashCode(this));
        ClientSettings clientSettings = this.f13282e;
        clientSettings.zae(valueOf);
        Handler handler = this.f13279b;
        this.f13283f = this.f13280c.buildClient(this.f13278a, handler.getLooper(), clientSettings, (ClientSettings) clientSettings.zaa(), (GoogleApiClient.ConnectionCallbacks) this, (GoogleApiClient.OnConnectionFailedListener) this);
        this.f13284g = zacsVar;
        Set set = this.f13281d;
        if (set != null && !set.isEmpty()) {
            this.f13283f.zab();
        } else {
            handler.post(new sn1(19, this));
        }
    }

    public final void zaf() {
        com.google.android.gms.signin.zae zaeVar = this.f13283f;
        if (zaeVar != null) {
            zaeVar.disconnect();
        }
    }
}
