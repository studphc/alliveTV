package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.AttributionSource;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.wrappers.AttributionSourceWrapper;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

@KeepForSdk
/* loaded from: classes.dex */
public abstract class BaseGmsClient<T extends IInterface> {

    @KeepForSdk
    public static final int CONNECT_STATE_CONNECTED = 4;

    @KeepForSdk
    public static final int CONNECT_STATE_DISCONNECTED = 1;

    @KeepForSdk
    public static final int CONNECT_STATE_DISCONNECTING = 5;

    @NonNull
    @KeepForSdk
    public static final String DEFAULT_ACCOUNT = "<<default account>>";

    @NonNull
    @KeepForSdk
    public static final String KEY_PENDING_INTENT = "pendingIntent";

    /* renamed from: A */
    public boolean f13368A;

    /* renamed from: B */
    public volatile zzk f13369B;

    /* renamed from: a */
    public int f13370a;

    /* renamed from: b */
    public long f13371b;

    /* renamed from: c */
    public long f13372c;

    /* renamed from: d */
    public int f13373d;

    /* renamed from: e */
    public long f13374e;

    /* renamed from: f */
    public volatile String f13375f;

    /* renamed from: g */
    public zzv f13376g;

    /* renamed from: h */
    public final Context f13377h;

    /* renamed from: i */
    public final Looper f13378i;

    /* renamed from: j */
    public final GmsClientSupervisor f13379j;

    /* renamed from: k */
    public final GoogleApiAvailabilityLight f13380k;

    /* renamed from: l */
    public final Handler f13381l;

    /* renamed from: m */
    public final Object f13382m;

    /* renamed from: n */
    public final Object f13383n;

    /* renamed from: o */
    public IGmsServiceBroker f13384o;

    /* renamed from: p */
    public IInterface f13385p;

    /* renamed from: q */
    public final ArrayList f13386q;

    /* renamed from: r */
    public zze f13387r;

    /* renamed from: s */
    public int f13388s;

    /* renamed from: t */
    public final BaseConnectionCallbacks f13389t;

    /* renamed from: u */
    public final BaseOnConnectionFailedListener f13390u;

    /* renamed from: v */
    public final int f13391v;

    /* renamed from: w */
    public final String f13392w;

    /* renamed from: x */
    public volatile String f13393x;

    /* renamed from: y */
    public volatile AttributionSourceWrapper f13394y;

    /* renamed from: z */
    public ConnectionResult f13395z;

    @NonNull
    @VisibleForTesting
    protected ConnectionProgressReportCallbacks zzc;

    @NonNull
    @VisibleForTesting
    protected AtomicInteger zzd;

    /* renamed from: C */
    public static final Feature[] f13367C = new Feature[0];

    @NonNull
    @KeepForSdk
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = {"service_esmobile", "service_googleme"};

    @KeepForSdk
    /* loaded from: classes.dex */
    public interface BaseConnectionCallbacks {

        @KeepForSdk
        public static final int CAUSE_DEAD_OBJECT_EXCEPTION = 3;

        @KeepForSdk
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        @KeepForSdk
        void onConnected(@Nullable Bundle bundle);

        @KeepForSdk
        void onConnectionSuspended(int i);
    }

    @KeepForSdk
    /* loaded from: classes.dex */
    public interface BaseOnConnectionFailedListener {
        @KeepForSdk
        void onConnectionFailed(@NonNull ConnectionResult connectionResult);
    }

    @KeepForSdk
    /* loaded from: classes.dex */
    public interface ConnectionProgressReportCallbacks {
        @KeepForSdk
        void onReportServiceBinding(@NonNull ConnectionResult connectionResult);
    }

    /* loaded from: classes.dex */
    public class LegacyClientCallbackAdapter implements ConnectionProgressReportCallbacks {
        @KeepForSdk
        public LegacyClientCallbackAdapter() {
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
        public final void onReportServiceBinding(@NonNull ConnectionResult connectionResult) {
            boolean isSuccess = connectionResult.isSuccess();
            BaseGmsClient baseGmsClient = BaseGmsClient.this;
            if (isSuccess) {
                baseGmsClient.getRemoteService(null, baseGmsClient.getScopes());
                return;
            }
            BaseOnConnectionFailedListener baseOnConnectionFailedListener = baseGmsClient.f13390u;
            if (baseOnConnectionFailedListener != null) {
                baseOnConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
    }

    @KeepForSdk
    /* loaded from: classes.dex */
    public interface SignOutCallbacks {
        @KeepForSdk
        void onSignOutComplete();
    }

    @KeepForSdk
    @VisibleForTesting
    public BaseGmsClient(@NonNull Context context, @NonNull Handler handler, @NonNull GmsClientSupervisor gmsClientSupervisor, @NonNull GoogleApiAvailabilityLight googleApiAvailabilityLight, int i, @Nullable BaseConnectionCallbacks baseConnectionCallbacks, @Nullable BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        this.f13375f = null;
        this.f13382m = new Object();
        this.f13383n = new Object();
        this.f13386q = new ArrayList();
        this.f13388s = 1;
        this.f13395z = null;
        this.f13368A = false;
        this.f13369B = null;
        this.zzd = new AtomicInteger(0);
        Preconditions.checkNotNull(context, "Context must not be null");
        this.f13377h = context;
        Preconditions.checkNotNull(handler, "Handler must not be null");
        this.f13381l = handler;
        this.f13378i = handler.getLooper();
        Preconditions.checkNotNull(gmsClientSupervisor, "Supervisor must not be null");
        this.f13379j = gmsClientSupervisor;
        Preconditions.checkNotNull(googleApiAvailabilityLight, "API availability must not be null");
        this.f13380k = googleApiAvailabilityLight;
        this.f13391v = i;
        this.f13389t = baseConnectionCallbacks;
        this.f13390u = baseOnConnectionFailedListener;
        this.f13392w = null;
    }

    /* renamed from: a */
    public static /* bridge */ /* synthetic */ void m3136a(BaseGmsClient baseGmsClient) {
        int i;
        int i2;
        synchronized (baseGmsClient.f13382m) {
            i = baseGmsClient.f13388s;
        }
        if (i == 3) {
            baseGmsClient.f13368A = true;
            i2 = 5;
        } else {
            i2 = 4;
        }
        Handler handler = baseGmsClient.f13381l;
        handler.sendMessage(handler.obtainMessage(i2, baseGmsClient.zzd.get(), 16));
    }

    /* renamed from: b */
    public static /* bridge */ /* synthetic */ boolean m3137b(BaseGmsClient baseGmsClient, int i, int i2, IInterface iInterface) {
        synchronized (baseGmsClient.f13382m) {
            try {
                if (baseGmsClient.f13388s != i) {
                    return false;
                }
                baseGmsClient.m3139d(iInterface, i2);
                return true;
            } finally {
            }
        }
    }

    /*  JADX ERROR: NullPointerException in pass: RegionMakerVisitor
        java.lang.NullPointerException
        	at java.base/java.util.BitSet.or(BitSet.java:941)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:759)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:838)
        	at jadx.core.dex.visitors.regions.IfMakerHelper.restructureIf(IfMakerHelper.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:711)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* renamed from: c */
    public static /* bridge */ /* synthetic */ boolean m3138c(com.google.android.gms.common.internal.BaseGmsClient r2) {
        /*
            boolean r0 = r2.f13368A
            r1 = 0
            if (r0 == 0) goto L6
            goto L24
        L6:
            java.lang.String r0 = r2.getServiceDescriptor()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L11
            goto L24
        L11:
            java.lang.String r0 = r2.getLocalStartServiceAction()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L1c
            goto L24
        L1c:
            java.lang.String r2 = r2.getServiceDescriptor()     // Catch: java.lang.ClassNotFoundException -> L24
            java.lang.Class.forName(r2)     // Catch: java.lang.ClassNotFoundException -> L24
            r1 = 1
        L24:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.BaseGmsClient.m3138c(com.google.android.gms.common.internal.BaseGmsClient):boolean");
    }

    @KeepForSdk
    public void checkAvailabilityAndConnect() {
        int isGooglePlayServicesAvailable = this.f13380k.isGooglePlayServicesAvailable(this.f13377h, getMinApkVersion());
        if (isGooglePlayServicesAvailable != 0) {
            m3139d(null, 1);
            triggerNotAvailable(new LegacyClientCallbackAdapter(), isGooglePlayServicesAvailable, null);
        } else {
            connect(new LegacyClientCallbackAdapter());
        }
    }

    @KeepForSdk
    public final void checkConnected() {
        if (isConnected()) {
        } else {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    @KeepForSdk
    public void connect(@NonNull ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        Preconditions.checkNotNull(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        this.zzc = connectionProgressReportCallbacks;
        m3139d(null, 2);
    }

    @Nullable
    @KeepForSdk
    public abstract T createServiceInterface(@NonNull IBinder iBinder);

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d */
    public final void m3139d(IInterface iInterface, int i) {
        boolean z;
        boolean z2;
        zzv zzvVar;
        int errorCode;
        zzv zzvVar2;
        boolean z3 = false;
        if (i != 4) {
            z = false;
        } else {
            z = true;
        }
        if (iInterface == 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z == z2) {
            z3 = true;
        }
        Preconditions.checkArgument(z3);
        synchronized (this.f13382m) {
            try {
                this.f13388s = i;
                this.f13385p = iInterface;
                Bundle bundle = null;
                if (i != 1) {
                    if (i != 2 && i != 3) {
                        if (i == 4) {
                            Preconditions.checkNotNull(iInterface);
                            onConnectedLocked(iInterface);
                        }
                    } else {
                        zze zzeVar = this.f13387r;
                        if (zzeVar != null && (zzvVar2 = this.f13376g) != null) {
                            Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + zzvVar2.f13536a + " on " + zzvVar2.f13537b);
                            GmsClientSupervisor gmsClientSupervisor = this.f13379j;
                            String str = this.f13376g.f13536a;
                            Preconditions.checkNotNull(str);
                            gmsClientSupervisor.zzc(str, this.f13376g.f13537b, 4225, zzeVar, zze(), this.f13376g.f13538c);
                            this.zzd.incrementAndGet();
                        }
                        zze zzeVar2 = new zze(this, this.zzd.get());
                        this.f13387r = zzeVar2;
                        if (this.f13388s == 3 && getLocalStartServiceAction() != null) {
                            zzvVar = new zzv(getContext().getPackageName(), getLocalStartServiceAction(), true, 4225, false);
                        } else {
                            zzvVar = new zzv(getStartServicePackage(), getStartServiceAction(), false, 4225, getUseDynamicLookup());
                        }
                        this.f13376g = zzvVar;
                        if (zzvVar.f13538c && getMinApkVersion() < 17895000) {
                            throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.f13376g.f13536a)));
                        }
                        GmsClientSupervisor gmsClientSupervisor2 = this.f13379j;
                        String str2 = this.f13376g.f13536a;
                        Preconditions.checkNotNull(str2);
                        ConnectionResult zza = gmsClientSupervisor2.zza(new zzo(str2, this.f13376g.f13537b, 4225, this.f13376g.f13538c), zzeVar2, zze(), getBindServiceExecutor());
                        if (!zza.isSuccess()) {
                            zzv zzvVar3 = this.f13376g;
                            Log.w("GmsClient", "unable to connect to service: " + zzvVar3.f13536a + " on " + zzvVar3.f13537b);
                            if (zza.getErrorCode() == -1) {
                                errorCode = 16;
                            } else {
                                errorCode = zza.getErrorCode();
                            }
                            if (zza.getResolution() != null) {
                                bundle = new Bundle();
                                bundle.putParcelable(KEY_PENDING_INTENT, zza.getResolution());
                            }
                            zzl(errorCode, bundle, this.zzd.get());
                        }
                    }
                } else {
                    zze zzeVar3 = this.f13387r;
                    if (zzeVar3 != null) {
                        GmsClientSupervisor gmsClientSupervisor3 = this.f13379j;
                        String str3 = this.f13376g.f13536a;
                        Preconditions.checkNotNull(str3);
                        gmsClientSupervisor3.zzc(str3, this.f13376g.f13537b, 4225, zzeVar3, zze(), this.f13376g.f13538c);
                        this.f13387r = null;
                    }
                }
            } finally {
            }
        }
    }

    @KeepForSdk
    public void disconnect() {
        this.zzd.incrementAndGet();
        synchronized (this.f13386q) {
            try {
                int size = this.f13386q.size();
                for (int i = 0; i < size; i++) {
                    ((zzc) this.f13386q.get(i)).zzf();
                }
                this.f13386q.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.f13383n) {
            this.f13384o = null;
        }
        m3139d(null, 1);
    }

    @KeepForSdk
    public void dump(@NonNull String str, @NonNull FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @NonNull String[] strArr) {
        int i;
        IInterface iInterface;
        IGmsServiceBroker iGmsServiceBroker;
        synchronized (this.f13382m) {
            i = this.f13388s;
            iInterface = this.f13385p;
        }
        synchronized (this.f13383n) {
            iGmsServiceBroker = this.f13384o;
        }
        printWriter.append((CharSequence) str).append("mConnectState=");
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            printWriter.print("UNKNOWN");
                        } else {
                            printWriter.print("DISCONNECTING");
                        }
                    } else {
                        printWriter.print("CONNECTED");
                    }
                } else {
                    printWriter.print("LOCAL_CONNECTING");
                }
            } else {
                printWriter.print("REMOTE_CONNECTING");
            }
        } else {
            printWriter.print("DISCONNECTED");
        }
        printWriter.append(" mService=");
        if (iInterface == null) {
            printWriter.append("null");
        } else {
            printWriter.append((CharSequence) getServiceDescriptor()).append("@").append((CharSequence) Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (iGmsServiceBroker == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(iGmsServiceBroker.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.f13372c > 0) {
            PrintWriter append = printWriter.append((CharSequence) str).append("lastConnectedTime=");
            long j = this.f13372c;
            append.println(j + " " + simpleDateFormat.format(new Date(j)));
        }
        if (this.f13371b > 0) {
            printWriter.append((CharSequence) str).append("lastSuspendedCause=");
            int i2 = this.f13370a;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        printWriter.append((CharSequence) String.valueOf(i2));
                    } else {
                        printWriter.append("CAUSE_DEAD_OBJECT_EXCEPTION");
                    }
                } else {
                    printWriter.append("CAUSE_NETWORK_LOST");
                }
            } else {
                printWriter.append("CAUSE_SERVICE_DISCONNECTED");
            }
            PrintWriter append2 = printWriter.append(" lastSuspendedTime=");
            long j2 = this.f13371b;
            append2.println(j2 + " " + simpleDateFormat.format(new Date(j2)));
        }
        if (this.f13374e > 0) {
            printWriter.append((CharSequence) str).append("lastFailedStatus=").append((CharSequence) CommonStatusCodes.getStatusCodeString(this.f13373d));
            PrintWriter append3 = printWriter.append(" lastFailedTime=");
            long j3 = this.f13374e;
            append3.println(j3 + " " + simpleDateFormat.format(new Date(j3)));
        }
    }

    @KeepForSdk
    public boolean enableLocalFallback() {
        return false;
    }

    @Nullable
    @KeepForSdk
    public Account getAccount() {
        return null;
    }

    @NonNull
    @KeepForSdk
    public Feature[] getApiFeatures() {
        return f13367C;
    }

    @Nullable
    @KeepForSdk
    public AttributionSourceWrapper getAttributionSourceWrapper() {
        return this.f13394y;
    }

    @Nullable
    @KeepForSdk
    public final Feature[] getAvailableFeatures() {
        zzk zzkVar = this.f13369B;
        if (zzkVar == null) {
            return null;
        }
        return zzkVar.f13528b;
    }

    @Nullable
    @KeepForSdk
    public Executor getBindServiceExecutor() {
        return null;
    }

    @Nullable
    @KeepForSdk
    public Bundle getConnectionHint() {
        return null;
    }

    @NonNull
    @KeepForSdk
    public final Context getContext() {
        return this.f13377h;
    }

    @NonNull
    @KeepForSdk
    public String getEndpointPackageName() {
        zzv zzvVar;
        if (isConnected() && (zzvVar = this.f13376g) != null) {
            return zzvVar.f13537b;
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    @KeepForSdk
    public int getGCoreServiceId() {
        return this.f13391v;
    }

    @NonNull
    @KeepForSdk
    public Bundle getGetServiceRequestExtraArgs() {
        return new Bundle();
    }

    @Nullable
    @KeepForSdk
    public String getLastDisconnectMessage() {
        return this.f13375f;
    }

    @Nullable
    @KeepForSdk
    public String getLocalStartServiceAction() {
        return null;
    }

    @NonNull
    @KeepForSdk
    public final Looper getLooper() {
        return this.f13378i;
    }

    @KeepForSdk
    public int getMinApkVersion() {
        return GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    @KeepForSdk
    @WorkerThread
    public void getRemoteService(@Nullable IAccountAccessor iAccountAccessor, @NonNull Set<Scope> set) {
        String attributionTag;
        String attributionTag2;
        Bundle getServiceRequestExtraArgs = getGetServiceRequestExtraArgs();
        if (Build.VERSION.SDK_INT < 31) {
            attributionTag2 = this.f13393x;
        } else if (this.f13394y == null) {
            attributionTag2 = this.f13393x;
        } else {
            AttributionSource attributionSource = this.f13394y.getAttributionSource();
            if (attributionSource != null) {
                attributionTag = attributionSource.getAttributionTag();
                if (attributionTag != null) {
                    attributionTag2 = attributionSource.getAttributionTag();
                } else {
                    attributionTag2 = this.f13393x;
                }
            } else {
                attributionTag2 = this.f13393x;
            }
        }
        String str = attributionTag2;
        int i = this.f13391v;
        int i2 = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        Scope[] scopeArr = GetServiceRequest.f13421o;
        Bundle bundle = new Bundle();
        Feature[] featureArr = GetServiceRequest.f13422p;
        GetServiceRequest getServiceRequest = new GetServiceRequest(6, i, i2, null, null, scopeArr, bundle, null, featureArr, featureArr, true, 0, false, str);
        getServiceRequest.f13426d = this.f13377h.getPackageName();
        getServiceRequest.f13429g = getServiceRequestExtraArgs;
        if (set != null) {
            getServiceRequest.f13428f = (Scope[]) set.toArray(new Scope[0]);
        }
        if (requiresSignIn()) {
            Account account = getAccount();
            if (account == null) {
                account = new Account("<<default account>>", AccountType.GOOGLE);
            }
            getServiceRequest.f13430h = account;
            if (iAccountAccessor != null) {
                getServiceRequest.f13427e = iAccountAccessor.asBinder();
            }
        } else if (requiresAccount()) {
            getServiceRequest.f13430h = getAccount();
        }
        getServiceRequest.f13431i = f13367C;
        getServiceRequest.f13432j = getApiFeatures();
        if (usesClientTelemetry()) {
            getServiceRequest.f13435m = true;
        }
        try {
            synchronized (this.f13383n) {
                try {
                    IGmsServiceBroker iGmsServiceBroker = this.f13384o;
                    if (iGmsServiceBroker != null) {
                        iGmsServiceBroker.getService(new zzd(this, this.zzd.get()), getServiceRequest);
                    } else {
                        Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                    }
                } finally {
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            triggerConnectionSuspended(3);
        } catch (RemoteException e2) {
            e = e2;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            onPostInitHandler(8, null, null, this.zzd.get());
        } catch (SecurityException e3) {
            throw e3;
        } catch (RuntimeException e4) {
            e = e4;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            onPostInitHandler(8, null, null, this.zzd.get());
        }
    }

    @NonNull
    @KeepForSdk
    public Set<Scope> getScopes() {
        return Collections.emptySet();
    }

    @NonNull
    @KeepForSdk
    public final T getService() {
        T t;
        synchronized (this.f13382m) {
            try {
                if (this.f13388s != 5) {
                    checkConnected();
                    t = (T) this.f13385p;
                    Preconditions.checkNotNull(t, "Client is connected but service is null");
                } else {
                    throw new DeadObjectException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return t;
    }

    @Nullable
    @KeepForSdk
    public IBinder getServiceBrokerBinder() {
        synchronized (this.f13383n) {
            try {
                IGmsServiceBroker iGmsServiceBroker = this.f13384o;
                if (iGmsServiceBroker == null) {
                    return null;
                }
                return iGmsServiceBroker.asBinder();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    @KeepForSdk
    public abstract String getServiceDescriptor();

    @NonNull
    @KeepForSdk
    public Intent getSignInIntent() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    @NonNull
    @KeepForSdk
    public abstract String getStartServiceAction();

    @NonNull
    @KeepForSdk
    public String getStartServicePackage() {
        return "com.google.android.gms";
    }

    @Nullable
    @KeepForSdk
    public ConnectionTelemetryConfiguration getTelemetryConfiguration() {
        zzk zzkVar = this.f13369B;
        if (zzkVar == null) {
            return null;
        }
        return zzkVar.f13530d;
    }

    @KeepForSdk
    public boolean getUseDynamicLookup() {
        if (getMinApkVersion() >= 211700000) {
            return true;
        }
        return false;
    }

    @KeepForSdk
    public boolean hasConnectionInfo() {
        return this.f13369B != null;
    }

    @KeepForSdk
    public boolean isConnected() {
        boolean z;
        synchronized (this.f13382m) {
            if (this.f13388s == 4) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    @KeepForSdk
    public boolean isConnecting() {
        boolean z;
        synchronized (this.f13382m) {
            int i = this.f13388s;
            z = true;
            if (i != 2 && i != 3) {
                z = false;
            }
        }
        return z;
    }

    @KeepForSdk
    @CallSuper
    public void onConnectedLocked(@NonNull T t) {
        this.f13372c = System.currentTimeMillis();
    }

    @KeepForSdk
    @CallSuper
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        this.f13373d = connectionResult.getErrorCode();
        this.f13374e = System.currentTimeMillis();
    }

    @KeepForSdk
    @CallSuper
    public void onConnectionSuspended(int i) {
        this.f13370a = i;
        this.f13371b = System.currentTimeMillis();
    }

    @KeepForSdk
    public void onPostInitHandler(int i, @Nullable IBinder iBinder, @Nullable Bundle bundle, int i2) {
        zzf zzfVar = new zzf(this, i, iBinder, bundle);
        Handler handler = this.f13381l;
        handler.sendMessage(handler.obtainMessage(1, i2, -1, zzfVar));
    }

    @KeepForSdk
    public void onUserSignOut(@NonNull SignOutCallbacks signOutCallbacks) {
        signOutCallbacks.onSignOutComplete();
    }

    @KeepForSdk
    public boolean providesSignIn() {
        return false;
    }

    @KeepForSdk
    public boolean requiresAccount() {
        return false;
    }

    @KeepForSdk
    public boolean requiresGooglePlayServices() {
        return true;
    }

    @KeepForSdk
    public boolean requiresSignIn() {
        return false;
    }

    @KeepForSdk
    public void setAttributionSourceWrapper(@NonNull AttributionSourceWrapper attributionSourceWrapper) {
        this.f13394y = attributionSourceWrapper;
    }

    @KeepForSdk
    public void setAttributionTag(@NonNull String str) {
        this.f13393x = str;
    }

    @KeepForSdk
    public void triggerConnectionSuspended(int i) {
        int i2 = this.zzd.get();
        Handler handler = this.f13381l;
        handler.sendMessage(handler.obtainMessage(6, i2, i));
    }

    @KeepForSdk
    @VisibleForTesting
    public void triggerNotAvailable(@NonNull ConnectionProgressReportCallbacks connectionProgressReportCallbacks, int i, @Nullable PendingIntent pendingIntent) {
        Preconditions.checkNotNull(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        this.zzc = connectionProgressReportCallbacks;
        int i2 = this.zzd.get();
        Handler handler = this.f13381l;
        handler.sendMessage(handler.obtainMessage(3, i2, i, pendingIntent));
    }

    @KeepForSdk
    public boolean usesClientTelemetry() {
        return false;
    }

    @NonNull
    public final String zze() {
        String str = this.f13392w;
        if (str == null) {
            return this.f13377h.getClass().getName();
        }
        return str;
    }

    public final void zzl(int i, @Nullable Bundle bundle, int i2) {
        zzg zzgVar = new zzg(this, i, bundle);
        Handler handler = this.f13381l;
        handler.sendMessage(handler.obtainMessage(7, i2, -1, zzgVar));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BaseGmsClient(@NonNull Context context, @NonNull Looper looper, int i, @Nullable BaseConnectionCallbacks baseConnectionCallbacks, @Nullable BaseOnConnectionFailedListener baseOnConnectionFailedListener, @Nullable String str) {
        this(context, looper, r3, r4, i, baseConnectionCallbacks, baseOnConnectionFailedListener, str);
        GmsClientSupervisor gmsClientSupervisor = GmsClientSupervisor.getInstance(context);
        GoogleApiAvailabilityLight googleApiAvailabilityLight = GoogleApiAvailabilityLight.getInstance();
        Preconditions.checkNotNull(baseConnectionCallbacks);
        Preconditions.checkNotNull(baseOnConnectionFailedListener);
    }

    @KeepForSdk
    public void disconnect(@NonNull String str) {
        this.f13375f = str;
        disconnect();
    }

    @KeepForSdk
    @VisibleForTesting
    public BaseGmsClient(@NonNull Context context, @NonNull Looper looper, @NonNull GmsClientSupervisor gmsClientSupervisor, @NonNull GoogleApiAvailabilityLight googleApiAvailabilityLight, int i, @Nullable BaseConnectionCallbacks baseConnectionCallbacks, @Nullable BaseOnConnectionFailedListener baseOnConnectionFailedListener, @Nullable String str) {
        this.f13375f = null;
        this.f13382m = new Object();
        this.f13383n = new Object();
        this.f13386q = new ArrayList();
        this.f13388s = 1;
        this.f13395z = null;
        this.f13368A = false;
        this.f13369B = null;
        this.zzd = new AtomicInteger(0);
        Preconditions.checkNotNull(context, "Context must not be null");
        this.f13377h = context;
        Preconditions.checkNotNull(looper, "Looper must not be null");
        this.f13378i = looper;
        Preconditions.checkNotNull(gmsClientSupervisor, "Supervisor must not be null");
        this.f13379j = gmsClientSupervisor;
        Preconditions.checkNotNull(googleApiAvailabilityLight, "API availability must not be null");
        this.f13380k = googleApiAvailabilityLight;
        this.f13381l = new HandlerC0760g(this, looper);
        this.f13391v = i;
        this.f13389t = baseConnectionCallbacks;
        this.f13390u = baseOnConnectionFailedListener;
        this.f13392w = str;
    }
}
