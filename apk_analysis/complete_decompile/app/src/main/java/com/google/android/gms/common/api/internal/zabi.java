package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import p000.p73;

/* loaded from: classes.dex */
public final class zabi implements zaca, zau {

    /* renamed from: a */
    public final Lock f13242a;

    /* renamed from: b */
    public final Condition f13243b;

    /* renamed from: c */
    public final Context f13244c;

    /* renamed from: d */
    public final GoogleApiAvailabilityLight f13245d;

    /* renamed from: e */
    public final p73 f13246e;

    /* renamed from: f */
    public final Map f13247f;

    /* renamed from: h */
    public final ClientSettings f13249h;

    /* renamed from: i */
    public final Map f13250i;

    /* renamed from: j */
    public final Api.AbstractClientBuilder f13251j;

    /* renamed from: k */
    public volatile zabf f13252k;

    /* renamed from: m */
    public int f13254m;

    /* renamed from: n */
    public final zabe f13255n;

    /* renamed from: o */
    public final zabz f13256o;

    /* renamed from: g */
    public final HashMap f13248g = new HashMap();

    /* renamed from: l */
    public ConnectionResult f13253l = null;

    public zabi(Context context, zabe zabeVar, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map map, @Nullable ClientSettings clientSettings, Map map2, @Nullable Api.AbstractClientBuilder abstractClientBuilder, ArrayList arrayList, zabz zabzVar) {
        this.f13244c = context;
        this.f13242a = lock;
        this.f13245d = googleApiAvailabilityLight;
        this.f13247f = map;
        this.f13249h = clientSettings;
        this.f13250i = map2;
        this.f13251j = abstractClientBuilder;
        this.f13255n = zabeVar;
        this.f13256o = zabzVar;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((zat) arrayList.get(i)).zaa(this);
        }
        this.f13246e = new p73(this, looper, 1);
        this.f13243b = lock.newCondition();
        this.f13252k = new zaax(this);
    }

    /* renamed from: a */
    public final void m3111a(ConnectionResult connectionResult) {
        this.f13242a.lock();
        try {
            this.f13253l = connectionResult;
            this.f13252k = new zaax(this);
            this.f13252k.zad();
            this.f13243b.signalAll();
        } finally {
            this.f13242a.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(@Nullable Bundle bundle) {
        this.f13242a.lock();
        try {
            this.f13252k.zag(bundle);
        } finally {
            this.f13242a.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        this.f13242a.lock();
        try {
            this.f13252k.zai(i);
        } finally {
            this.f13242a.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zau
    public final void zaa(@NonNull ConnectionResult connectionResult, @NonNull Api api, boolean z) {
        this.f13242a.lock();
        try {
            this.f13252k.zah(connectionResult, api, z);
        } finally {
            this.f13242a.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    @GuardedBy("lock")
    public final ConnectionResult zab() {
        zaq();
        while (this.f13252k instanceof zaaw) {
            try {
                this.f13243b.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        if (this.f13252k instanceof zaaj) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        ConnectionResult connectionResult = this.f13253l;
        if (connectionResult != null) {
            return connectionResult;
        }
        return new ConnectionResult(13, null);
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    @GuardedBy("lock")
    public final ConnectionResult zac(long j, TimeUnit timeUnit) {
        zaq();
        long nanos = timeUnit.toNanos(j);
        while (this.f13252k instanceof zaaw) {
            if (nanos <= 0) {
                zar();
                return new ConnectionResult(14, null);
            }
            try {
                nanos = this.f13243b.awaitNanos(nanos);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
            Thread.currentThread().interrupt();
            return new ConnectionResult(15, null);
        }
        if (this.f13252k instanceof zaaj) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        ConnectionResult connectionResult = this.f13253l;
        if (connectionResult != null) {
            return connectionResult;
        }
        return new ConnectionResult(13, null);
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    @Nullable
    @GuardedBy("lock")
    public final ConnectionResult zad(@NonNull Api api) {
        Api.AnyClientKey zab = api.zab();
        Map map = this.f13247f;
        if (map.containsKey(zab)) {
            if (((Api.Client) map.get(zab)).isConnected()) {
                return ConnectionResult.RESULT_SUCCESS;
            }
            HashMap hashMap = this.f13248g;
            if (hashMap.containsKey(zab)) {
                return (ConnectionResult) hashMap.get(zab);
            }
            return null;
        }
        return null;
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    @GuardedBy("lock")
    public final BaseImplementation.ApiMethodImpl zae(@NonNull BaseImplementation.ApiMethodImpl apiMethodImpl) {
        apiMethodImpl.zak();
        this.f13252k.zaa(apiMethodImpl);
        return apiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    @GuardedBy("lock")
    public final BaseImplementation.ApiMethodImpl zaf(@NonNull BaseImplementation.ApiMethodImpl apiMethodImpl) {
        apiMethodImpl.zak();
        return this.f13252k.zab(apiMethodImpl);
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    @GuardedBy("lock")
    public final void zaq() {
        this.f13252k.zae();
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    @GuardedBy("lock")
    public final void zar() {
        if (this.f13252k.zaj()) {
            this.f13248g.clear();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void zas(String str, @Nullable FileDescriptor fileDescriptor, PrintWriter printWriter, @Nullable String[] strArr) {
        printWriter.append((CharSequence) str).append("mState=").println(this.f13252k);
        for (Api api : this.f13250i.keySet()) {
            String valueOf = String.valueOf(str);
            printWriter.append((CharSequence) str).append((CharSequence) api.zad()).println(":");
            ((Api.Client) Preconditions.checkNotNull((Api.Client) this.f13247f.get(api.zab()))).dump(valueOf.concat("  "), fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    @GuardedBy("lock")
    public final void zat() {
        if (this.f13252k instanceof zaaj) {
            zaaj zaajVar = (zaaj) this.f13252k;
            if (zaajVar.f13194b) {
                zaajVar.f13194b = false;
                zaajVar.f13193a.f13255n.f13241x.zab();
                zaajVar.zaj();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void zau() {
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final boolean zaw() {
        return this.f13252k instanceof zaaj;
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final boolean zax() {
        return this.f13252k instanceof zaaw;
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final boolean zay(SignInConnectionListener signInConnectionListener) {
        return false;
    }
}
