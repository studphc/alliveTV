package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.exoplayer2.C0643C;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import p000.c93;
import p000.sn1;

/* renamed from: com.google.android.gms.common.api.internal.a */
/* loaded from: classes.dex */
public final class C0743a implements zaca {

    /* renamed from: a */
    public final Context f13165a;

    /* renamed from: b */
    public final zabe f13166b;

    /* renamed from: c */
    public final Looper f13167c;

    /* renamed from: d */
    public final zabi f13168d;

    /* renamed from: e */
    public final zabi f13169e;

    /* renamed from: f */
    public final Map f13170f;

    /* renamed from: h */
    public final Api.Client f13172h;

    /* renamed from: i */
    public Bundle f13173i;

    /* renamed from: m */
    public final Lock f13177m;

    /* renamed from: g */
    public final Set f13171g = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: j */
    public ConnectionResult f13174j = null;

    /* renamed from: k */
    public ConnectionResult f13175k = null;

    /* renamed from: l */
    public boolean f13176l = false;

    /* renamed from: n */
    public int f13178n = 0;

    public C0743a(Context context, zabe zabeVar, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, ArrayMap arrayMap, ArrayMap arrayMap2, ClientSettings clientSettings, Api.AbstractClientBuilder abstractClientBuilder, Api.Client client, ArrayList arrayList, ArrayList arrayList2, ArrayMap arrayMap3, ArrayMap arrayMap4) {
        this.f13165a = context;
        this.f13166b = zabeVar;
        this.f13177m = lock;
        this.f13167c = looper;
        this.f13172h = client;
        this.f13168d = new zabi(context, zabeVar, lock, looper, googleApiAvailabilityLight, arrayMap2, null, arrayMap4, null, arrayList2, new c93(this, 0));
        this.f13169e = new zabi(context, zabeVar, lock, looper, googleApiAvailabilityLight, arrayMap, clientSettings, arrayMap3, abstractClientBuilder, arrayList, new c93(this, 1));
        ArrayMap arrayMap5 = new ArrayMap();
        Iterator it = arrayMap2.keySet().iterator();
        while (it.hasNext()) {
            arrayMap5.put((Api.AnyClientKey) it.next(), this.f13168d);
        }
        Iterator it2 = arrayMap.keySet().iterator();
        while (it2.hasNext()) {
            arrayMap5.put((Api.AnyClientKey) it2.next(), this.f13169e);
        }
        this.f13170f = Collections.unmodifiableMap(arrayMap5);
    }

    /* renamed from: d */
    public static void m3092d(C0743a c0743a) {
        boolean z;
        ConnectionResult connectionResult;
        ConnectionResult connectionResult2;
        boolean z2;
        ConnectionResult connectionResult3 = c0743a.f13174j;
        if (connectionResult3 != null && connectionResult3.isSuccess()) {
            z = true;
        } else {
            z = false;
        }
        zabi zabiVar = c0743a.f13168d;
        if (z) {
            ConnectionResult connectionResult4 = c0743a.f13175k;
            if (connectionResult4 != null && connectionResult4.isSuccess()) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 && !c0743a.m3095c()) {
                ConnectionResult connectionResult5 = c0743a.f13175k;
                if (connectionResult5 != null) {
                    if (c0743a.f13178n == 1) {
                        c0743a.m3094b();
                        return;
                    } else {
                        c0743a.m3093a(connectionResult5);
                        zabiVar.zar();
                        return;
                    }
                }
                return;
            }
            int i = c0743a.f13178n;
            if (i != 1) {
                if (i != 2) {
                    Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                    c0743a.f13178n = 0;
                    return;
                }
                ((zabe) Preconditions.checkNotNull(c0743a.f13166b)).zab(c0743a.f13173i);
            }
            c0743a.m3094b();
            c0743a.f13178n = 0;
            return;
        }
        ConnectionResult connectionResult6 = c0743a.f13174j;
        zabi zabiVar2 = c0743a.f13169e;
        if (connectionResult6 != null && (connectionResult2 = c0743a.f13175k) != null && connectionResult2.isSuccess()) {
            zabiVar2.zar();
            c0743a.m3093a((ConnectionResult) Preconditions.checkNotNull(c0743a.f13174j));
            return;
        }
        ConnectionResult connectionResult7 = c0743a.f13174j;
        if (connectionResult7 != null && (connectionResult = c0743a.f13175k) != null) {
            if (zabiVar2.f13254m < zabiVar.f13254m) {
                connectionResult7 = connectionResult;
            }
            c0743a.m3093a(connectionResult7);
        }
    }

    /* renamed from: a */
    public final void m3093a(ConnectionResult connectionResult) {
        int i = this.f13178n;
        if (i != 1) {
            if (i != 2) {
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                this.f13178n = 0;
            }
            this.f13166b.zaa(connectionResult);
        }
        m3094b();
        this.f13178n = 0;
    }

    /* renamed from: b */
    public final void m3094b() {
        Set set = this.f13171g;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((SignInConnectionListener) it.next()).onComplete();
        }
        set.clear();
    }

    /* renamed from: c */
    public final boolean m3095c() {
        ConnectionResult connectionResult = this.f13175k;
        if (connectionResult != null && connectionResult.getErrorCode() == 4) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    public final PendingIntent m3096e() {
        Api.Client client = this.f13172h;
        if (client == null) {
            return null;
        }
        return PendingIntent.getActivity(this.f13165a, System.identityHashCode(this.f13166b), client.getSignInIntent(), com.google.android.gms.internal.base.zap.zaa | C0643C.BUFFER_FLAG_FIRST_SAMPLE);
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final ConnectionResult zab() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final ConnectionResult zac(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final ConnectionResult zad(Api api) {
        Object obj = this.f13170f.get(api.zab());
        zabi zabiVar = this.f13169e;
        if (Objects.equal(obj, zabiVar)) {
            if (m3095c()) {
                return new ConnectionResult(4, m3096e());
            }
            return zabiVar.zad(api);
        }
        return this.f13168d.zad(api);
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final BaseImplementation.ApiMethodImpl zae(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        zabi zabiVar = (zabi) this.f13170f.get(apiMethodImpl.getClientKey());
        Preconditions.checkNotNull(zabiVar, "GoogleApiClient is not configured to use the API required for this call.");
        zabi zabiVar2 = this.f13169e;
        if (zabiVar.equals(zabiVar2)) {
            if (m3095c()) {
                apiMethodImpl.setFailedResult(new Status(4, (String) null, m3096e()));
                return apiMethodImpl;
            }
            zabiVar2.zae(apiMethodImpl);
            return apiMethodImpl;
        }
        this.f13168d.zae(apiMethodImpl);
        return apiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final BaseImplementation.ApiMethodImpl zaf(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        zabi zabiVar = (zabi) this.f13170f.get(apiMethodImpl.getClientKey());
        Preconditions.checkNotNull(zabiVar, "GoogleApiClient is not configured to use the API required for this call.");
        zabi zabiVar2 = this.f13169e;
        if (zabiVar.equals(zabiVar2)) {
            if (m3095c()) {
                apiMethodImpl.setFailedResult(new Status(4, (String) null, m3096e()));
                return apiMethodImpl;
            }
            return zabiVar2.zaf(apiMethodImpl);
        }
        return this.f13168d.zaf(apiMethodImpl);
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void zaq() {
        this.f13178n = 2;
        this.f13176l = false;
        this.f13175k = null;
        this.f13174j = null;
        this.f13168d.zaq();
        this.f13169e.zaq();
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void zar() {
        this.f13175k = null;
        this.f13174j = null;
        this.f13178n = 0;
        this.f13168d.zar();
        this.f13169e.zar();
        m3094b();
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void zas(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("authClient").println(":");
        this.f13169e.zas(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append((CharSequence) str).append("anonClient").println(":");
        this.f13168d.zas(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void zat() {
        this.f13168d.zat();
        this.f13169e.zat();
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void zau() {
        Lock lock = this.f13177m;
        lock.lock();
        try {
            boolean zax = zax();
            this.f13169e.zar();
            this.f13175k = new ConnectionResult(4);
            if (zax) {
                new com.google.android.gms.internal.base.zau(this.f13167c).post(new sn1(20, this));
            } else {
                m3094b();
            }
            lock.unlock();
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001f, code lost:
    
        if (r4.f13178n == 1) goto L11;
     */
    @Override // com.google.android.gms.common.api.internal.zaca
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zaw() {
        Lock lock = this.f13177m;
        lock.lock();
        try {
            boolean z = false;
            if (this.f13168d.zaw()) {
                if (!this.f13169e.zaw() && !m3095c()) {
                }
                z = true;
            }
            return z;
        } finally {
            lock.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final boolean zax() {
        boolean z;
        Lock lock = this.f13177m;
        lock.lock();
        try {
            if (this.f13178n == 2) {
                z = true;
            } else {
                z = false;
            }
            return z;
        } finally {
            lock.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final boolean zay(SignInConnectionListener signInConnectionListener) {
        zabi zabiVar = this.f13169e;
        Lock lock = this.f13177m;
        lock.lock();
        try {
            boolean z = false;
            if (!zax()) {
                if (zaw()) {
                }
                lock.unlock();
                return z;
            }
            if (!zabiVar.zaw()) {
                this.f13171g.add(signInConnectionListener);
                z = true;
                if (this.f13178n == 0) {
                    this.f13178n = 1;
                }
                this.f13175k = null;
                zabiVar.zaq();
            }
            lock.unlock();
            return z;
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }
}
