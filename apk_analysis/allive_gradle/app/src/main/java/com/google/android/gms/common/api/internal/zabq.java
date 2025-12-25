package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import p000.sn1;
import p000.t73;
import p000.u73;
import p000.w73;
import p000.xe2;

/* loaded from: classes.dex */
public final class zabq implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, zau {

    /* renamed from: b */
    public final Api.Client f13259b;

    /* renamed from: c */
    public final ApiKey f13260c;

    /* renamed from: d */
    public final zaad f13261d;

    /* renamed from: g */
    public final int f13264g;

    /* renamed from: h */
    public final zact f13265h;

    /* renamed from: i */
    public boolean f13266i;

    /* renamed from: m */
    public final /* synthetic */ GoogleApiManager f13270m;

    /* renamed from: a */
    public final LinkedList f13258a = new LinkedList();

    /* renamed from: e */
    public final HashSet f13262e = new HashSet();

    /* renamed from: f */
    public final HashMap f13263f = new HashMap();

    /* renamed from: j */
    public final ArrayList f13267j = new ArrayList();

    /* renamed from: k */
    public ConnectionResult f13268k = null;

    /* renamed from: l */
    public int f13269l = 0;

    @WorkerThread
    public zabq(GoogleApiManager googleApiManager, GoogleApi googleApi) {
        this.f13270m = googleApiManager;
        Api.Client zab = googleApi.zab(googleApiManager.f13119n.getLooper(), this);
        this.f13259b = zab;
        this.f13260c = googleApi.getApiKey();
        this.f13261d = new zaad();
        this.f13264g = googleApi.zaa();
        if (zab.requiresSignIn()) {
            this.f13265h = googleApi.zac(googleApiManager.f13110e, googleApiManager.f13119n);
        } else {
            this.f13265h = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public final Feature m3112a(Feature[] featureArr) {
        if (featureArr != null && featureArr.length != 0) {
            Feature[] availableFeatures = this.f13259b.getAvailableFeatures();
            if (availableFeatures == null) {
                availableFeatures = new Feature[0];
            }
            ArrayMap arrayMap = new ArrayMap(availableFeatures.length);
            for (Feature feature : availableFeatures) {
                arrayMap.put(feature.getName(), Long.valueOf(feature.getVersion()));
            }
            for (Feature feature2 : featureArr) {
                Long l = (Long) arrayMap.get(feature2.getName());
                if (l == null || l.longValue() < feature2.getVersion()) {
                    return feature2;
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    public final void m3113b(ConnectionResult connectionResult) {
        String str;
        HashSet hashSet = this.f13262e;
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            zal zalVar = (zal) it.next();
            if (Objects.equal(connectionResult, ConnectionResult.RESULT_SUCCESS)) {
                str = this.f13259b.getEndpointPackageName();
            } else {
                str = null;
            }
            zalVar.zac(this.f13260c, connectionResult, str);
        }
        hashSet.clear();
    }

    /* renamed from: c */
    public final void m3114c(Status status) {
        Preconditions.checkHandlerThread(this.f13270m.f13119n);
        m3115d(status, null, false);
    }

    /* renamed from: d */
    public final void m3115d(Status status, Exception exc, boolean z) {
        boolean z2;
        Preconditions.checkHandlerThread(this.f13270m.f13119n);
        boolean z3 = true;
        if (status != null) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (exc != null) {
            z3 = false;
        }
        if (z2 != z3) {
            Iterator it = this.f13258a.iterator();
            while (it.hasNext()) {
                zai zaiVar = (zai) it.next();
                if (!z || zaiVar.zac == 2) {
                    if (status != null) {
                        zaiVar.zad(status);
                    } else {
                        zaiVar.zae(exc);
                    }
                    it.remove();
                }
            }
            return;
        }
        throw new IllegalArgumentException("Status XOR exception should be null");
    }

    /* renamed from: e */
    public final void m3116e() {
        LinkedList linkedList = this.f13258a;
        ArrayList arrayList = new ArrayList(linkedList);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            zai zaiVar = (zai) arrayList.get(i);
            if (this.f13259b.isConnected()) {
                if (m3120i(zaiVar)) {
                    linkedList.remove(zaiVar);
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: f */
    public final void m3117f() {
        Api.Client client = this.f13259b;
        zan();
        m3113b(ConnectionResult.RESULT_SUCCESS);
        if (this.f13266i) {
            GoogleApiManager googleApiManager = this.f13270m;
            com.google.android.gms.internal.base.zau zauVar = googleApiManager.f13119n;
            ApiKey apiKey = this.f13260c;
            zauVar.removeMessages(11, apiKey);
            googleApiManager.f13119n.removeMessages(9, apiKey);
            this.f13266i = false;
        }
        Iterator it = this.f13263f.values().iterator();
        while (it.hasNext()) {
            zaci zaciVar = (zaci) it.next();
            if (m3112a(zaciVar.zaa.getRequiredFeatures()) != null) {
                it.remove();
            } else {
                try {
                    zaciVar.zaa.registerListener(client, new TaskCompletionSource<>());
                } catch (DeadObjectException unused) {
                    onConnectionSuspended(3);
                    client.disconnect("DeadObjectException thrown while calling register listener method.");
                } catch (RemoteException unused2) {
                    it.remove();
                }
            }
        }
        m3116e();
        m3119h();
    }

    /* renamed from: g */
    public final void m3118g(int i) {
        zan();
        this.f13266i = true;
        String lastDisconnectMessage = this.f13259b.getLastDisconnectMessage();
        zaad zaadVar = this.f13261d;
        zaadVar.getClass();
        StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
        if (i == 1) {
            sb.append(" due to service disconnection.");
        } else if (i == 3) {
            sb.append(" due to dead object exception.");
        }
        if (lastDisconnectMessage != null) {
            sb.append(" Last reason for disconnect: ");
            sb.append(lastDisconnectMessage);
        }
        zaadVar.m3097a(new Status(20, sb.toString()), true);
        GoogleApiManager googleApiManager = this.f13270m;
        com.google.android.gms.internal.base.zau zauVar = googleApiManager.f13119n;
        ApiKey apiKey = this.f13260c;
        zauVar.sendMessageDelayed(Message.obtain(zauVar, 9, apiKey), 5000L);
        com.google.android.gms.internal.base.zau zauVar2 = googleApiManager.f13119n;
        zauVar2.sendMessageDelayed(Message.obtain(zauVar2, 11, apiKey), 120000L);
        googleApiManager.f13112g.zac();
        Iterator it = this.f13263f.values().iterator();
        while (it.hasNext()) {
            ((zaci) it.next()).zac.run();
        }
    }

    /* renamed from: h */
    public final void m3119h() {
        GoogleApiManager googleApiManager = this.f13270m;
        com.google.android.gms.internal.base.zau zauVar = googleApiManager.f13119n;
        ApiKey apiKey = this.f13260c;
        zauVar.removeMessages(12, apiKey);
        com.google.android.gms.internal.base.zau zauVar2 = googleApiManager.f13119n;
        zauVar2.sendMessageDelayed(zauVar2.obtainMessage(12, apiKey), googleApiManager.f13106a);
    }

    /* renamed from: i */
    public final boolean m3120i(zai zaiVar) {
        if (!(zaiVar instanceof zac)) {
            zaiVar.zag(this.f13261d, zaA());
            try {
                zaiVar.zaf(this);
            } catch (DeadObjectException unused) {
                onConnectionSuspended(1);
                this.f13259b.disconnect("DeadObjectException thrown while running ApiCallRunner.");
            }
            return true;
        }
        zac zacVar = (zac) zaiVar;
        Feature m3112a = m3112a(zacVar.zab(this));
        if (m3112a == null) {
            zaiVar.zag(this.f13261d, zaA());
            try {
                zaiVar.zaf(this);
            } catch (DeadObjectException unused2) {
                onConnectionSuspended(1);
                this.f13259b.disconnect("DeadObjectException thrown while running ApiCallRunner.");
            }
            return true;
        }
        Log.w("GoogleApiManager", this.f13259b.getClass().getName() + " could not execute call because it requires feature (" + m3112a.getName() + ", " + m3112a.getVersion() + ").");
        if (this.f13270m.f13120o && zacVar.zaa(this)) {
            u73 u73Var = new u73(this.f13260c, m3112a);
            int indexOf = this.f13267j.indexOf(u73Var);
            if (indexOf >= 0) {
                u73 u73Var2 = (u73) this.f13267j.get(indexOf);
                this.f13270m.f13119n.removeMessages(15, u73Var2);
                com.google.android.gms.internal.base.zau zauVar = this.f13270m.f13119n;
                zauVar.sendMessageDelayed(Message.obtain(zauVar, 15, u73Var2), 5000L);
                return false;
            }
            this.f13267j.add(u73Var);
            com.google.android.gms.internal.base.zau zauVar2 = this.f13270m.f13119n;
            zauVar2.sendMessageDelayed(Message.obtain(zauVar2, 15, u73Var), 5000L);
            com.google.android.gms.internal.base.zau zauVar3 = this.f13270m.f13119n;
            zauVar3.sendMessageDelayed(Message.obtain(zauVar3, 16, u73Var), 120000L);
            ConnectionResult connectionResult = new ConnectionResult(2, null);
            if (!m3121j(connectionResult)) {
                GoogleApiManager googleApiManager = this.f13270m;
                googleApiManager.f13111f.zah(googleApiManager.f13110e, connectionResult, this.f13264g);
                return false;
            }
            return false;
        }
        zacVar.zae(new UnsupportedApiCallException(m3112a));
        return true;
    }

    /* renamed from: j */
    public final boolean m3121j(ConnectionResult connectionResult) {
        synchronized (GoogleApiManager.f13104q) {
            try {
                GoogleApiManager googleApiManager = this.f13270m;
                if (googleApiManager.f13116k != null && googleApiManager.f13117l.contains(this.f13260c)) {
                    this.f13270m.f13116k.zah(connectionResult, this.f13264g);
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: k */
    public final boolean m3122k(boolean z) {
        Preconditions.checkHandlerThread(this.f13270m.f13119n);
        Api.Client client = this.f13259b;
        if (client.isConnected() && this.f13263f.isEmpty()) {
            zaad zaadVar = this.f13261d;
            if (zaadVar.f13188a.isEmpty() && zaadVar.f13189b.isEmpty()) {
                client.disconnect("Timing out service connection.");
                return true;
            }
            if (z) {
                m3119h();
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(@Nullable Bundle bundle) {
        Looper myLooper = Looper.myLooper();
        GoogleApiManager googleApiManager = this.f13270m;
        if (myLooper == googleApiManager.f13119n.getLooper()) {
            m3117f();
        } else {
            googleApiManager.f13119n.post(new sn1(18, this));
        }
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    @WorkerThread
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        zar(connectionResult, null);
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        Looper myLooper = Looper.myLooper();
        GoogleApiManager googleApiManager = this.f13270m;
        if (myLooper == googleApiManager.f13119n.getLooper()) {
            m3118g(i);
        } else {
            googleApiManager.f13119n.post(new xe2(i, 1, this));
        }
    }

    public final boolean zaA() {
        return this.f13259b.requiresSignIn();
    }

    @ResultIgnorabilityUnspecified
    @WorkerThread
    public final boolean zaB() {
        return m3122k(true);
    }

    @Override // com.google.android.gms.common.api.internal.zau
    public final void zaa(ConnectionResult connectionResult, Api api, boolean z) {
        throw null;
    }

    public final int zab() {
        return this.f13264g;
    }

    @Nullable
    @WorkerThread
    public final ConnectionResult zad() {
        Preconditions.checkHandlerThread(this.f13270m.f13119n);
        return this.f13268k;
    }

    public final Api.Client zaf() {
        return this.f13259b;
    }

    public final Map zah() {
        return this.f13263f;
    }

    @WorkerThread
    public final void zan() {
        Preconditions.checkHandlerThread(this.f13270m.f13119n);
        this.f13268k = null;
    }

    @WorkerThread
    public final void zao() {
        GoogleApiManager googleApiManager = this.f13270m;
        Preconditions.checkHandlerThread(googleApiManager.f13119n);
        Api.Client client = this.f13259b;
        if (!client.isConnected() && !client.isConnecting()) {
            try {
                int zab = googleApiManager.f13112g.zab(googleApiManager.f13110e, client);
                if (zab != 0) {
                    ConnectionResult connectionResult = new ConnectionResult(zab, null);
                    Log.w("GoogleApiManager", "The service for " + client.getClass().getName() + " is not available: " + connectionResult.toString());
                    zar(connectionResult, null);
                    return;
                }
                w73 w73Var = new w73(googleApiManager, client, this.f13260c);
                if (client.requiresSignIn()) {
                    ((zact) Preconditions.checkNotNull(this.f13265h)).zae(w73Var);
                }
                try {
                    client.connect(w73Var);
                } catch (SecurityException e) {
                    zar(new ConnectionResult(10), e);
                }
            } catch (IllegalStateException e2) {
                zar(new ConnectionResult(10), e2);
            }
        }
    }

    @WorkerThread
    public final void zap(zai zaiVar) {
        Preconditions.checkHandlerThread(this.f13270m.f13119n);
        boolean isConnected = this.f13259b.isConnected();
        LinkedList linkedList = this.f13258a;
        if (isConnected) {
            if (m3120i(zaiVar)) {
                m3119h();
                return;
            } else {
                linkedList.add(zaiVar);
                return;
            }
        }
        linkedList.add(zaiVar);
        ConnectionResult connectionResult = this.f13268k;
        if (connectionResult != null && connectionResult.hasResolution()) {
            zar(this.f13268k, null);
        } else {
            zao();
        }
    }

    @WorkerThread
    public final void zar(@NonNull ConnectionResult connectionResult, @Nullable Exception exc) {
        Preconditions.checkHandlerThread(this.f13270m.f13119n);
        zact zactVar = this.f13265h;
        if (zactVar != null) {
            zactVar.zaf();
        }
        zan();
        this.f13270m.f13112g.zac();
        m3113b(connectionResult);
        if ((this.f13259b instanceof com.google.android.gms.common.internal.service.zap) && connectionResult.getErrorCode() != 24) {
            GoogleApiManager googleApiManager = this.f13270m;
            googleApiManager.f13107b = true;
            com.google.android.gms.internal.base.zau zauVar = googleApiManager.f13119n;
            zauVar.sendMessageDelayed(zauVar.obtainMessage(19), 300000L);
        }
        if (connectionResult.getErrorCode() == 4) {
            m3114c(GoogleApiManager.f13103p);
            return;
        }
        if (this.f13258a.isEmpty()) {
            this.f13268k = connectionResult;
            return;
        }
        if (exc != null) {
            Preconditions.checkHandlerThread(this.f13270m.f13119n);
            m3115d(null, exc, false);
            return;
        }
        if (this.f13270m.f13120o) {
            m3115d(GoogleApiManager.m3086b(this.f13260c, connectionResult), null, true);
            if (!this.f13258a.isEmpty() && !m3121j(connectionResult)) {
                GoogleApiManager googleApiManager2 = this.f13270m;
                if (!googleApiManager2.f13111f.zah(googleApiManager2.f13110e, connectionResult, this.f13264g)) {
                    if (connectionResult.getErrorCode() == 18) {
                        this.f13266i = true;
                    }
                    if (this.f13266i) {
                        GoogleApiManager googleApiManager3 = this.f13270m;
                        ApiKey apiKey = this.f13260c;
                        com.google.android.gms.internal.base.zau zauVar2 = googleApiManager3.f13119n;
                        zauVar2.sendMessageDelayed(Message.obtain(zauVar2, 9, apiKey), 5000L);
                        return;
                    }
                    m3114c(GoogleApiManager.m3086b(this.f13260c, connectionResult));
                    return;
                }
                return;
            }
            return;
        }
        m3114c(GoogleApiManager.m3086b(this.f13260c, connectionResult));
    }

    @WorkerThread
    public final void zas(@NonNull ConnectionResult connectionResult) {
        Preconditions.checkHandlerThread(this.f13270m.f13119n);
        Api.Client client = this.f13259b;
        client.disconnect("onSignInFailed for " + client.getClass().getName() + " with " + String.valueOf(connectionResult));
        zar(connectionResult, null);
    }

    @WorkerThread
    public final void zat(zal zalVar) {
        Preconditions.checkHandlerThread(this.f13270m.f13119n);
        this.f13262e.add(zalVar);
    }

    @WorkerThread
    public final void zau() {
        Preconditions.checkHandlerThread(this.f13270m.f13119n);
        if (this.f13266i) {
            zao();
        }
    }

    @WorkerThread
    public final void zav() {
        Preconditions.checkHandlerThread(this.f13270m.f13119n);
        m3114c(GoogleApiManager.zaa);
        this.f13261d.zaf();
        for (ListenerHolder.ListenerKey listenerKey : (ListenerHolder.ListenerKey[]) this.f13263f.keySet().toArray(new ListenerHolder.ListenerKey[0])) {
            zap(new zah(listenerKey, new TaskCompletionSource()));
        }
        m3113b(new ConnectionResult(4));
        Api.Client client = this.f13259b;
        if (client.isConnected()) {
            client.onUserSignOut(new t73(this));
        }
    }

    @WorkerThread
    public final void zaw() {
        Status status;
        GoogleApiManager googleApiManager = this.f13270m;
        Preconditions.checkHandlerThread(googleApiManager.f13119n);
        boolean z = this.f13266i;
        if (z) {
            if (z) {
                com.google.android.gms.internal.base.zau zauVar = googleApiManager.f13119n;
                ApiKey apiKey = this.f13260c;
                zauVar.removeMessages(11, apiKey);
                googleApiManager.f13119n.removeMessages(9, apiKey);
                this.f13266i = false;
            }
            if (googleApiManager.f13111f.isGooglePlayServicesAvailable(googleApiManager.f13110e) == 18) {
                status = new Status(21, "Connection timed out waiting for Google Play services update to complete.");
            } else {
                status = new Status(22, "API failed to connect while resuming due to an unknown error.");
            }
            m3114c(status);
            this.f13259b.disconnect("Timing out connection while resuming.");
        }
    }
}
