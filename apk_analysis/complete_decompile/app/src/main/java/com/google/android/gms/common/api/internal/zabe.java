package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.service.Common;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import p000.ai2;
import p000.j73;
import p000.n73;
import p000.o73;
import p000.p73;
import p000.q73;

/* loaded from: classes.dex */
public final class zabe extends GoogleApiClient implements zabz {

    /* renamed from: y */
    public static final /* synthetic */ int f13218y = 0;

    /* renamed from: b */
    public final Lock f13219b;

    /* renamed from: c */
    public final com.google.android.gms.common.internal.zak f13220c;

    /* renamed from: e */
    public final int f13222e;

    /* renamed from: f */
    public final Context f13223f;

    /* renamed from: g */
    public final Looper f13224g;

    /* renamed from: i */
    public volatile boolean f13226i;

    /* renamed from: j */
    public final long f13227j;

    /* renamed from: k */
    public final long f13228k;

    /* renamed from: l */
    public final p73 f13229l;

    /* renamed from: m */
    public final GoogleApiAvailability f13230m;

    /* renamed from: n */
    public zabx f13231n;

    /* renamed from: o */
    public final Map f13232o;

    /* renamed from: p */
    public Set f13233p;

    /* renamed from: q */
    public final ClientSettings f13234q;

    /* renamed from: r */
    public final Map f13235r;

    /* renamed from: s */
    public final Api.AbstractClientBuilder f13236s;

    /* renamed from: t */
    public final ListenerHolders f13237t;

    /* renamed from: u */
    public final ArrayList f13238u;

    /* renamed from: v */
    public Integer f13239v;

    /* renamed from: w */
    public HashSet f13240w;

    /* renamed from: x */
    public final zadc f13241x;

    /* renamed from: d */
    public zaca f13221d = null;

    /* renamed from: h */
    public final LinkedList f13225h = new LinkedList();

    public zabe(Context context, Lock lock, Looper looper, ClientSettings clientSettings, GoogleApiAvailability googleApiAvailability, Api.AbstractClientBuilder abstractClientBuilder, Map map, List list, List list2, Map map2, int i, int i2, ArrayList arrayList) {
        long j;
        if (true != ClientLibraryUtils.isPackageSide()) {
            j = 120000;
        } else {
            j = 10000;
        }
        this.f13227j = j;
        this.f13228k = 5000L;
        this.f13233p = new HashSet();
        this.f13237t = new ListenerHolders();
        this.f13239v = null;
        this.f13240w = null;
        ai2 ai2Var = new ai2(16, this);
        this.f13223f = context;
        this.f13219b = lock;
        this.f13220c = new com.google.android.gms.common.internal.zak(looper, ai2Var);
        this.f13224g = looper;
        this.f13229l = new p73(this, looper, 0);
        this.f13230m = googleApiAvailability;
        this.f13222e = i;
        if (i >= 0) {
            this.f13239v = Integer.valueOf(i2);
        }
        this.f13235r = map;
        this.f13232o = map2;
        this.f13238u = arrayList;
        this.f13241x = new zadc();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.f13220c.zaf((GoogleApiClient.ConnectionCallbacks) it.next());
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            this.f13220c.zag((GoogleApiClient.OnConnectionFailedListener) it2.next());
        }
        this.f13234q = clientSettings;
        this.f13236s = abstractClientBuilder;
    }

    /* renamed from: b */
    public static /* bridge */ /* synthetic */ void m3106b(zabe zabeVar) {
        zabeVar.f13219b.lock();
        try {
            if (zabeVar.f13226i) {
                zabeVar.m3110e();
            }
        } finally {
            zabeVar.f13219b.unlock();
        }
    }

    public static int zad(Iterable iterable, boolean z) {
        Iterator it = iterable.iterator();
        boolean z2 = false;
        boolean z3 = false;
        while (it.hasNext()) {
            Api.Client client = (Api.Client) it.next();
            z2 |= client.requiresSignIn();
            z3 |= client.providesSignIn();
        }
        if (z2) {
            if (z3 && z) {
                return 2;
            }
            return 1;
        }
        return 3;
    }

    /* renamed from: a */
    public final String m3107a() {
        StringWriter stringWriter = new StringWriter();
        dump("", null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    @ResultIgnorabilityUnspecified
    public final ConnectionResult blockingConnect() {
        boolean z = true;
        Preconditions.checkState(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        Lock lock = this.f13219b;
        lock.lock();
        try {
            if (this.f13222e >= 0) {
                if (this.f13239v == null) {
                    z = false;
                }
                Preconditions.checkState(z, "Sign-in mode should have been set explicitly by auto-manage.");
            } else {
                Integer num = this.f13239v;
                if (num == null) {
                    this.f13239v = Integer.valueOf(zad(this.f13232o.values(), false));
                } else if (num.intValue() == 2) {
                    throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            m3109d(((Integer) Preconditions.checkNotNull(this.f13239v)).intValue());
            this.f13220c.zab();
            ConnectionResult zab = ((zaca) Preconditions.checkNotNull(this.f13221d)).zab();
            lock.unlock();
            return zab;
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }

    /* renamed from: c */
    public final boolean m3108c() {
        if (!this.f13226i) {
            return false;
        }
        this.f13226i = false;
        this.f13229l.removeMessages(2);
        this.f13229l.removeMessages(1);
        zabx zabxVar = this.f13231n;
        if (zabxVar != null) {
            zabxVar.zab();
            this.f13231n = null;
        }
        return true;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final PendingResult<Status> clearDefaultAccountAndReconnect() {
        Preconditions.checkState(isConnected(), "GoogleApiClient is not connected yet.");
        Integer num = this.f13239v;
        boolean z = true;
        if (num != null && num.intValue() == 2) {
            z = false;
        }
        Preconditions.checkState(z, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        StatusPendingResult statusPendingResult = new StatusPendingResult(this);
        if (this.f13232o.containsKey(Common.CLIENT_KEY)) {
            Common.zaa.zaa(this).setResultCallback(new o73(this, statusPendingResult, false, this));
        } else {
            AtomicReference atomicReference = new AtomicReference();
            j73 j73Var = new j73(this, atomicReference, statusPendingResult);
            n73 n73Var = new n73(statusPendingResult);
            GoogleApiClient.Builder builder = new GoogleApiClient.Builder(this.f13223f);
            builder.addApi(Common.API);
            builder.addConnectionCallbacks(j73Var);
            builder.addOnConnectionFailedListener(n73Var);
            builder.setHandler(this.f13229l);
            GoogleApiClient build = builder.build();
            atomicReference.set(build);
            build.connect();
        }
        return statusPendingResult;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void connect() {
        Lock lock = this.f13219b;
        lock.lock();
        try {
            int i = 2;
            boolean z = false;
            if (this.f13222e >= 0) {
                Preconditions.checkState(this.f13239v != null, "Sign-in mode should have been set explicitly by auto-manage.");
            } else {
                Integer num = this.f13239v;
                if (num == null) {
                    this.f13239v = Integer.valueOf(zad(this.f13232o.values(), false));
                } else if (num.intValue() == 2) {
                    throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            int intValue = ((Integer) Preconditions.checkNotNull(this.f13239v)).intValue();
            lock.lock();
            try {
                if (intValue == 3 || intValue == 1) {
                    i = intValue;
                } else if (intValue != 2) {
                    i = intValue;
                    Preconditions.checkArgument(z, "Illegal sign-in mode: " + i);
                    m3109d(i);
                    m3110e();
                    lock.unlock();
                    return;
                }
                Preconditions.checkArgument(z, "Illegal sign-in mode: " + i);
                m3109d(i);
                m3110e();
                lock.unlock();
                return;
            } finally {
                lock.unlock();
            }
            z = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* renamed from: d */
    public final void m3109d(int i) {
        String str;
        Integer num = this.f13239v;
        if (num == null) {
            this.f13239v = Integer.valueOf(i);
        } else if (num.intValue() != i) {
            int intValue = this.f13239v.intValue();
            String str2 = "SIGN_IN_MODE_REQUIRED";
            if (intValue == 1) {
                str = "SIGN_IN_MODE_REQUIRED";
            } else if (intValue == 2) {
                str = "SIGN_IN_MODE_OPTIONAL";
            } else if (intValue == 3) {
                str = "SIGN_IN_MODE_NONE";
            } else {
                str = "UNKNOWN";
            }
            StringBuilder sb = new StringBuilder("Cannot use sign-in mode: ");
            if (i != 1) {
                if (i == 2) {
                    str2 = "SIGN_IN_MODE_OPTIONAL";
                } else if (i == 3) {
                    str2 = "SIGN_IN_MODE_NONE";
                } else {
                    str2 = "UNKNOWN";
                }
            }
            sb.append(str2);
            sb.append(". Mode was already set to ");
            sb.append(str);
            throw new IllegalStateException(sb.toString());
        }
        if (this.f13221d != null) {
            return;
        }
        Map map = this.f13232o;
        boolean z = false;
        boolean z2 = false;
        for (Api.Client client : map.values()) {
            z |= client.requiresSignIn();
            z2 |= client.providesSignIn();
        }
        int intValue2 = this.f13239v.intValue();
        if (intValue2 != 1) {
            if (intValue2 == 2 && z) {
                ArrayMap arrayMap = new ArrayMap();
                ArrayMap arrayMap2 = new ArrayMap();
                Api.Client client2 = null;
                for (Map.Entry entry : map.entrySet()) {
                    Api.Client client3 = (Api.Client) entry.getValue();
                    if (true == client3.providesSignIn()) {
                        client2 = client3;
                    }
                    if (client3.requiresSignIn()) {
                        arrayMap.put((Api.AnyClientKey) entry.getKey(), client3);
                    } else {
                        arrayMap2.put((Api.AnyClientKey) entry.getKey(), client3);
                    }
                }
                Preconditions.checkState(!arrayMap.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
                ArrayMap arrayMap3 = new ArrayMap();
                ArrayMap arrayMap4 = new ArrayMap();
                Map map2 = this.f13235r;
                for (Api api : map2.keySet()) {
                    Api.AnyClientKey zab = api.zab();
                    if (arrayMap.containsKey(zab)) {
                        arrayMap3.put(api, (Boolean) map2.get(api));
                    } else if (arrayMap2.containsKey(zab)) {
                        arrayMap4.put(api, (Boolean) map2.get(api));
                    } else {
                        throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
                    }
                }
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = this.f13238u;
                int size = arrayList3.size();
                for (int i2 = 0; i2 < size; i2++) {
                    zat zatVar = (zat) arrayList3.get(i2);
                    if (arrayMap3.containsKey(zatVar.zaa)) {
                        arrayList.add(zatVar);
                    } else if (arrayMap4.containsKey(zatVar.zaa)) {
                        arrayList2.add(zatVar);
                    } else {
                        throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
                    }
                }
                this.f13221d = new C0743a(this.f13223f, this, this.f13219b, this.f13224g, this.f13230m, arrayMap, arrayMap2, this.f13234q, this.f13236s, client2, arrayList, arrayList2, arrayMap3, arrayMap4);
                return;
            }
        } else if (z) {
            if (z2) {
                throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
        } else {
            throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
        }
        this.f13221d = new zabi(this.f13223f, this, this.f13219b, this.f13224g, this.f13230m, this.f13232o, this.f13234q, this.f13235r, this.f13236s, this.f13238u, this);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void disconnect() {
        Lock lock = this.f13219b;
        lock.lock();
        try {
            this.f13241x.zab();
            zaca zacaVar = this.f13221d;
            if (zacaVar != null) {
                zacaVar.zar();
            }
            this.f13237t.zab();
            LinkedList<BaseImplementation.ApiMethodImpl> linkedList = this.f13225h;
            for (BaseImplementation.ApiMethodImpl apiMethodImpl : linkedList) {
                apiMethodImpl.zan(null);
                apiMethodImpl.cancel();
            }
            linkedList.clear();
            if (this.f13221d != null) {
                m3108c();
                this.f13220c.zaa();
            }
            lock.unlock();
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void dump(String str, @Nullable FileDescriptor fileDescriptor, PrintWriter printWriter, @Nullable String[] strArr) {
        printWriter.append((CharSequence) str).append("mContext=").println(this.f13223f);
        printWriter.append((CharSequence) str).append("mResuming=").print(this.f13226i);
        printWriter.append(" mWorkQueue.size()=").print(this.f13225h.size());
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.f13241x.f13294a.size());
        zaca zacaVar = this.f13221d;
        if (zacaVar != null) {
            zacaVar.zas(str, fileDescriptor, printWriter, strArr);
        }
    }

    /* renamed from: e */
    public final void m3110e() {
        this.f13220c.zab();
        ((zaca) Preconditions.checkNotNull(this.f13221d)).zaq();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    @ResultIgnorabilityUnspecified
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(@NonNull T t) {
        String str;
        Api<?> api = t.getApi();
        boolean containsKey = this.f13232o.containsKey(t.getClientKey());
        if (api != null) {
            str = api.zad();
        } else {
            str = "the API";
        }
        Preconditions.checkArgument(containsKey, "GoogleApiClient is not configured to use " + str + " required for this call.");
        Lock lock = this.f13219b;
        lock.lock();
        try {
            zaca zacaVar = this.f13221d;
            if (zacaVar == null) {
                this.f13225h.add(t);
            } else {
                t = (T) zacaVar.zae(t);
            }
            lock.unlock();
            return t;
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    @ResultIgnorabilityUnspecified
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(@NonNull T t) {
        String str;
        Map map = this.f13232o;
        Api<?> api = t.getApi();
        boolean containsKey = map.containsKey(t.getClientKey());
        if (api != null) {
            str = api.zad();
        } else {
            str = "the API";
        }
        Preconditions.checkArgument(containsKey, "GoogleApiClient is not configured to use " + str + " required for this call.");
        this.f13219b.lock();
        try {
            zaca zacaVar = this.f13221d;
            if (zacaVar != null) {
                if (this.f13226i) {
                    this.f13225h.add(t);
                    while (!this.f13225h.isEmpty()) {
                        BaseImplementation.ApiMethodImpl apiMethodImpl = (BaseImplementation.ApiMethodImpl) this.f13225h.remove();
                        zadc zadcVar = this.f13241x;
                        zadcVar.f13294a.add(apiMethodImpl);
                        apiMethodImpl.zan(zadcVar.f13295b);
                        apiMethodImpl.setFailedResult(Status.RESULT_INTERNAL_ERROR);
                    }
                } else {
                    t = (T) zacaVar.zaf(t);
                }
                this.f13219b.unlock();
                return t;
            }
            throw new IllegalStateException("GoogleApiClient is not connected yet.");
        } catch (Throwable th) {
            this.f13219b.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    @NonNull
    public final <C extends Api.Client> C getClient(@NonNull Api.AnyClientKey<C> anyClientKey) {
        C c = (C) this.f13232o.get(anyClientKey);
        Preconditions.checkNotNull(c, "Appropriate Api was not requested.");
        return c;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    @NonNull
    public final ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        ConnectionResult connectionResult;
        this.f13219b.lock();
        try {
            if (!isConnected() && !this.f13226i) {
                throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
            }
            if (this.f13232o.containsKey(api.zab())) {
                ConnectionResult zad = ((zaca) Preconditions.checkNotNull(this.f13221d)).zad(api);
                if (zad == null) {
                    if (this.f13226i) {
                        connectionResult = ConnectionResult.RESULT_SUCCESS;
                    } else {
                        Log.w("GoogleApiClientImpl", m3107a());
                        Log.wtf("GoogleApiClientImpl", api.zad() + " requested in getConnectionResult is not connected but is not present in the failed  connections map", new Exception());
                        connectionResult = new ConnectionResult(8, null);
                    }
                    this.f13219b.unlock();
                    return connectionResult;
                }
                this.f13219b.unlock();
                return zad;
            }
            throw new IllegalArgumentException(api.zad() + " was never registered with GoogleApiClient");
        } catch (Throwable th) {
            this.f13219b.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final Context getContext() {
        return this.f13223f;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final Looper getLooper() {
        return this.f13224g;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean hasApi(@NonNull Api<?> api) {
        return this.f13232o.containsKey(api.zab());
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean hasConnectedApi(@NonNull Api<?> api) {
        Api.Client client;
        if (!isConnected() || (client = (Api.Client) this.f13232o.get(api.zab())) == null || !client.isConnected()) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean isConnected() {
        zaca zacaVar = this.f13221d;
        if (zacaVar != null && zacaVar.zaw()) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean isConnecting() {
        zaca zacaVar = this.f13221d;
        if (zacaVar != null && zacaVar.zax()) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean isConnectionCallbacksRegistered(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        return this.f13220c.zaj(connectionCallbacks);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean isConnectionFailedListenerRegistered(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return this.f13220c.zak(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        zaca zacaVar = this.f13221d;
        if (zacaVar != null && zacaVar.zay(signInConnectionListener)) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void maybeSignOut() {
        zaca zacaVar = this.f13221d;
        if (zacaVar != null) {
            zacaVar.zau();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void reconnect() {
        disconnect();
        connect();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void registerConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.f13220c.zaf(connectionCallbacks);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void registerConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f13220c.zag(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <L> ListenerHolder<L> registerListener(@NonNull L l) {
        Lock lock = this.f13219b;
        lock.lock();
        try {
            return this.f13237t.zaa(l, this.f13224g, "NO_TYPE");
        } finally {
            lock.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void stopAutoManage(@NonNull FragmentActivity fragmentActivity) {
        LifecycleActivity lifecycleActivity = new LifecycleActivity((Activity) fragmentActivity);
        int i = this.f13222e;
        if (i >= 0) {
            zak.zaa(lifecycleActivity).zae(i);
            return;
        }
        throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void unregisterConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.f13220c.zah(connectionCallbacks);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void unregisterConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f13220c.zai(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    @GuardedBy("lock")
    public final void zaa(ConnectionResult connectionResult) {
        if (!this.f13230m.isPlayServicesPossiblyUpdating(this.f13223f, connectionResult.getErrorCode())) {
            m3108c();
        }
        if (!this.f13226i) {
            this.f13220c.zac(connectionResult);
            this.f13220c.zaa();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    @GuardedBy("lock")
    public final void zab(@Nullable Bundle bundle) {
        while (true) {
            LinkedList linkedList = this.f13225h;
            if (!linkedList.isEmpty()) {
                execute((BaseImplementation.ApiMethodImpl) linkedList.remove());
            } else {
                this.f13220c.zad(bundle);
                return;
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    @GuardedBy("lock")
    public final void zac(int i, boolean z) {
        if (i == 1) {
            if (!z && !this.f13226i) {
                this.f13226i = true;
                if (this.f13231n == null && !ClientLibraryUtils.isPackageSide()) {
                    try {
                        this.f13231n = this.f13230m.zac(this.f13223f.getApplicationContext(), new q73(this));
                    } catch (SecurityException unused) {
                    }
                }
                p73 p73Var = this.f13229l;
                p73Var.sendMessageDelayed(p73Var.obtainMessage(1), this.f13227j);
                p73 p73Var2 = this.f13229l;
                p73Var2.sendMessageDelayed(p73Var2.obtainMessage(2), this.f13228k);
            }
            i = 1;
        }
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.f13241x.f13294a.toArray(new BasePendingResult[0])) {
            basePendingResult.forceFailureUnlessReady(zadc.zaa);
        }
        this.f13220c.zae(i);
        this.f13220c.zaa();
        if (i == 2) {
            m3110e();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void zao(zada zadaVar) {
        Lock lock = this.f13219b;
        lock.lock();
        try {
            if (this.f13240w == null) {
                this.f13240w = new HashSet();
            }
            this.f13240w.add(zadaVar);
            lock.unlock();
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003b, code lost:
    
        if (r4 != false) goto L20;
     */
    @Override // com.google.android.gms.common.api.GoogleApiClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zap(zada zadaVar) {
        Lock lock = this.f13219b;
        lock.lock();
        try {
            HashSet hashSet = this.f13240w;
            if (hashSet == null) {
                Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
            } else if (!hashSet.remove(zadaVar)) {
                Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
            } else {
                lock.lock();
                try {
                    HashSet hashSet2 = this.f13240w;
                    if (hashSet2 == null) {
                        lock.unlock();
                    } else {
                        boolean isEmpty = hashSet2.isEmpty();
                        lock.unlock();
                    }
                    zaca zacaVar = this.f13221d;
                    if (zacaVar != null) {
                        zacaVar.zat();
                    }
                } finally {
                    lock.unlock();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final ConnectionResult blockingConnect(long j, @NonNull TimeUnit timeUnit) {
        Preconditions.checkState(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        Preconditions.checkNotNull(timeUnit, "TimeUnit must not be null");
        Lock lock = this.f13219b;
        lock.lock();
        try {
            Integer num = this.f13239v;
            if (num == null) {
                this.f13239v = Integer.valueOf(zad(this.f13232o.values(), false));
            } else if (num.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            m3109d(((Integer) Preconditions.checkNotNull(this.f13239v)).intValue());
            this.f13220c.zab();
            ConnectionResult zac = ((zaca) Preconditions.checkNotNull(this.f13221d)).zac(j, timeUnit);
            lock.unlock();
            return zac;
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void connect(int i) {
        Lock lock = this.f13219b;
        lock.lock();
        boolean z = true;
        if (i != 3 && i != 1) {
            if (i == 2) {
                i = 2;
            } else {
                z = false;
            }
        }
        try {
            Preconditions.checkArgument(z, "Illegal sign-in mode: " + i);
            m3109d(i);
            m3110e();
        } finally {
            lock.unlock();
        }
    }
}
