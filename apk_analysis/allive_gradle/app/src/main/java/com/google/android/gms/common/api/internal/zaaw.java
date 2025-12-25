package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import p000.AbstractC1726qj;
import p000.b73;
import p000.e73;
import p000.f73;
import p000.h73;
import p000.sn1;

/* loaded from: classes.dex */
public final class zaaw implements zabf {

    /* renamed from: a */
    public final zabi f13195a;

    /* renamed from: b */
    public final Lock f13196b;

    /* renamed from: c */
    public final Context f13197c;

    /* renamed from: d */
    public final GoogleApiAvailabilityLight f13198d;

    /* renamed from: e */
    public ConnectionResult f13199e;

    /* renamed from: f */
    public int f13200f;

    /* renamed from: h */
    public int f13202h;

    /* renamed from: k */
    public com.google.android.gms.signin.zae f13205k;

    /* renamed from: l */
    public boolean f13206l;

    /* renamed from: m */
    public boolean f13207m;

    /* renamed from: n */
    public boolean f13208n;

    /* renamed from: o */
    public IAccountAccessor f13209o;

    /* renamed from: p */
    public boolean f13210p;

    /* renamed from: q */
    public boolean f13211q;

    /* renamed from: r */
    public final ClientSettings f13212r;

    /* renamed from: s */
    public final Map f13213s;

    /* renamed from: t */
    public final Api.AbstractClientBuilder f13214t;

    /* renamed from: g */
    public int f13201g = 0;

    /* renamed from: i */
    public final Bundle f13203i = new Bundle();

    /* renamed from: j */
    public final HashSet f13204j = new HashSet();

    /* renamed from: u */
    public final ArrayList f13215u = new ArrayList();

    public zaaw(zabi zabiVar, @Nullable ClientSettings clientSettings, Map map, GoogleApiAvailabilityLight googleApiAvailabilityLight, @Nullable Api.AbstractClientBuilder abstractClientBuilder, Lock lock, Context context) {
        this.f13195a = zabiVar;
        this.f13212r = clientSettings;
        this.f13213s = map;
        this.f13198d = googleApiAvailabilityLight;
        this.f13214t = abstractClientBuilder;
        this.f13196b = lock;
        this.f13197c = context;
    }

    /* renamed from: a */
    public final void m3098a() {
        this.f13207m = false;
        zabi zabiVar = this.f13195a;
        zabiVar.f13255n.f13233p = Collections.emptySet();
        Iterator it = this.f13204j.iterator();
        while (it.hasNext()) {
            Api.AnyClientKey anyClientKey = (Api.AnyClientKey) it.next();
            HashMap hashMap = zabiVar.f13248g;
            if (!hashMap.containsKey(anyClientKey)) {
                hashMap.put(anyClientKey, new ConnectionResult(17, null));
            }
        }
    }

    /* renamed from: b */
    public final void m3099b(boolean z) {
        com.google.android.gms.signin.zae zaeVar = this.f13205k;
        if (zaeVar != null) {
            if (zaeVar.isConnected() && z) {
                zaeVar.zaa();
            }
            zaeVar.disconnect();
            this.f13209o = null;
        }
    }

    /* renamed from: c */
    public final void m3100c() {
        Bundle bundle;
        zabi zabiVar = this.f13195a;
        zabiVar.f13242a.lock();
        try {
            zabiVar.f13255n.m3108c();
            zabiVar.f13252k = new zaaj(zabiVar);
            zabiVar.f13252k.zad();
            zabiVar.f13243b.signalAll();
            zabiVar.f13242a.unlock();
            zabj.zaa().execute(new sn1(17, this));
            com.google.android.gms.signin.zae zaeVar = this.f13205k;
            if (zaeVar != null) {
                if (this.f13210p) {
                    zaeVar.zac((IAccountAccessor) Preconditions.checkNotNull(this.f13209o), this.f13211q);
                }
                m3099b(false);
            }
            Iterator it = this.f13195a.f13248g.keySet().iterator();
            while (it.hasNext()) {
                ((Api.Client) Preconditions.checkNotNull((Api.Client) this.f13195a.f13247f.get((Api.AnyClientKey) it.next()))).disconnect();
            }
            if (this.f13203i.isEmpty()) {
                bundle = null;
            } else {
                bundle = this.f13203i;
            }
            this.f13195a.f13256o.zab(bundle);
        } catch (Throwable th) {
            zabiVar.f13242a.unlock();
            throw th;
        }
    }

    /* renamed from: d */
    public final void m3101d(ConnectionResult connectionResult) {
        ArrayList arrayList = this.f13215u;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((Future) arrayList.get(i)).cancel(true);
        }
        arrayList.clear();
        m3099b(!connectionResult.hasResolution());
        zabi zabiVar = this.f13195a;
        zabiVar.m3111a(connectionResult);
        zabiVar.f13256o.zaa(connectionResult);
    }

    /* renamed from: e */
    public final void m3102e(ConnectionResult connectionResult, Api api, boolean z) {
        int priority = api.zac().getPriority();
        if ((!z || connectionResult.hasResolution() || this.f13198d.getErrorResolutionIntent(connectionResult.getErrorCode()) != null) && (this.f13199e == null || priority < this.f13200f)) {
            this.f13199e = connectionResult;
            this.f13200f = priority;
        }
        this.f13195a.f13248g.put(api.zab(), connectionResult);
    }

    /* renamed from: f */
    public final void m3103f() {
        if (this.f13202h == 0) {
            if (!this.f13207m || this.f13208n) {
                ArrayList arrayList = new ArrayList();
                this.f13201g = 1;
                zabi zabiVar = this.f13195a;
                this.f13202h = zabiVar.f13247f.size();
                Map map = zabiVar.f13247f;
                for (Api.AnyClientKey anyClientKey : map.keySet()) {
                    if (zabiVar.f13248g.containsKey(anyClientKey)) {
                        if (m3105h()) {
                            m3100c();
                        }
                    } else {
                        arrayList.add((Api.Client) map.get(anyClientKey));
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.f13215u.add(zabj.zaa().submit(new f73(this, arrayList)));
                }
            }
        }
    }

    /* renamed from: g */
    public final boolean m3104g(int i) {
        String str;
        if (this.f13201g != i) {
            Log.w("GACConnecting", this.f13195a.f13255n.m3107a());
            Log.w("GACConnecting", "Unexpected callback in ".concat(toString()));
            Log.w("GACConnecting", "mRemainingConnections=" + this.f13202h);
            String str2 = "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
            if (this.f13201g == 0) {
                str = "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
            } else {
                str = "STEP_GETTING_REMOTE_SERVICE";
            }
            StringBuilder m7065u = AbstractC1726qj.m7065u("GoogleApiClient connecting is in step ", str, " but received callback for step ");
            if (i != 0) {
                str2 = "STEP_GETTING_REMOTE_SERVICE";
            }
            m7065u.append(str2);
            Log.e("GACConnecting", m7065u.toString(), new Exception());
            m3101d(new ConnectionResult(8, null));
            return false;
        }
        return true;
    }

    /* renamed from: h */
    public final boolean m3105h() {
        int i = this.f13202h - 1;
        this.f13202h = i;
        if (i > 0) {
            return false;
        }
        zabi zabiVar = this.f13195a;
        if (i < 0) {
            Log.w("GACConnecting", zabiVar.f13255n.m3107a());
            Log.wtf("GACConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            m3101d(new ConnectionResult(8, null));
            return false;
        }
        ConnectionResult connectionResult = this.f13199e;
        if (connectionResult != null) {
            zabiVar.f13254m = this.f13200f;
            m3101d(connectionResult);
            return false;
        }
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final BaseImplementation.ApiMethodImpl zaa(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        this.f13195a.f13255n.f13225h.add(apiMethodImpl);
        return apiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final BaseImplementation.ApiMethodImpl zab(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [com.google.android.gms.common.api.Api$Client, com.google.android.gms.signin.zae] */
    @Override // com.google.android.gms.common.api.internal.zabf
    @GuardedBy("lock")
    public final void zad() {
        Map map;
        boolean z;
        zabi zabiVar = this.f13195a;
        zabiVar.f13248g.clear();
        this.f13207m = false;
        this.f13199e = null;
        this.f13201g = 0;
        this.f13206l = true;
        this.f13208n = false;
        this.f13210p = false;
        HashMap hashMap = new HashMap();
        Map map2 = this.f13213s;
        Iterator it = map2.keySet().iterator();
        boolean z2 = false;
        while (true) {
            boolean hasNext = it.hasNext();
            map = zabiVar.f13247f;
            if (!hasNext) {
                break;
            }
            Api api = (Api) it.next();
            Api.Client client = (Api.Client) Preconditions.checkNotNull((Api.Client) map.get(api.zab()));
            if (api.zac().getPriority() == 1) {
                z = true;
            } else {
                z = false;
            }
            z2 |= z;
            boolean booleanValue = ((Boolean) map2.get(api)).booleanValue();
            if (client.requiresSignIn()) {
                this.f13207m = true;
                if (booleanValue) {
                    this.f13204j.add(api.zab());
                } else {
                    this.f13206l = false;
                }
            }
            hashMap.put(client, new b73(this, api, booleanValue));
        }
        if (z2) {
            this.f13207m = false;
        }
        if (this.f13207m) {
            ClientSettings clientSettings = this.f13212r;
            Preconditions.checkNotNull(clientSettings);
            Preconditions.checkNotNull(this.f13214t);
            zabe zabeVar = zabiVar.f13255n;
            clientSettings.zae(Integer.valueOf(System.identityHashCode(zabeVar)));
            h73 h73Var = new h73(this);
            this.f13205k = this.f13214t.buildClient(this.f13197c, zabeVar.getLooper(), clientSettings, (ClientSettings) clientSettings.zaa(), (GoogleApiClient.ConnectionCallbacks) h73Var, (GoogleApiClient.OnConnectionFailedListener) h73Var);
        }
        this.f13202h = map.size();
        this.f13215u.add(zabj.zaa().submit(new e73(this, hashMap)));
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void zae() {
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    @GuardedBy("lock")
    public final void zag(@Nullable Bundle bundle) {
        if (m3104g(1)) {
            if (bundle != null) {
                this.f13203i.putAll(bundle);
            }
            if (m3105h()) {
                m3100c();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    @GuardedBy("lock")
    public final void zah(ConnectionResult connectionResult, Api api, boolean z) {
        if (m3104g(1)) {
            m3102e(connectionResult, api, z);
            if (m3105h()) {
                m3100c();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    @GuardedBy("lock")
    public final void zai(int i) {
        m3101d(new ConnectionResult(8, null));
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    @GuardedBy("lock")
    public final boolean zaj() {
        ArrayList arrayList = this.f13215u;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((Future) arrayList.get(i)).cancel(true);
        }
        arrayList.clear();
        m3099b(true);
        this.f13195a.m3111a(null);
        return true;
    }
}
