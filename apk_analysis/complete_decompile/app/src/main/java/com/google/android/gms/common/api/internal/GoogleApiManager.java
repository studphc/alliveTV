package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.collection.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.RootTelemetryConfigManager;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLogging;
import com.google.android.gms.common.internal.TelemetryLoggingClient;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import p000.a83;
import p000.b83;
import p000.u73;
import p000.ye0;
import p000.z63;

@ShowFirstParty
@KeepForSdk
/* loaded from: classes.dex */
public class GoogleApiManager implements Handler.Callback {

    /* renamed from: r */
    public static GoogleApiManager f13105r;

    /* renamed from: c */
    public TelemetryData f13108c;

    /* renamed from: d */
    public TelemetryLoggingClient f13109d;

    /* renamed from: e */
    public final Context f13110e;

    /* renamed from: f */
    public final GoogleApiAvailability f13111f;

    /* renamed from: g */
    public final com.google.android.gms.common.internal.zal f13112g;

    /* renamed from: n */
    public final com.google.android.gms.internal.base.zau f13119n;

    /* renamed from: o */
    public volatile boolean f13120o;

    @NonNull
    public static final Status zaa = new Status(4, "Sign-out occurred while this API call was in progress.");

    /* renamed from: p */
    public static final Status f13103p = new Status(4, "The user must be signed in to make this API call.");

    /* renamed from: q */
    public static final Object f13104q = new Object();

    /* renamed from: a */
    public long f13106a = 10000;

    /* renamed from: b */
    public boolean f13107b = false;

    /* renamed from: h */
    public final AtomicInteger f13113h = new AtomicInteger(1);

    /* renamed from: i */
    public final AtomicInteger f13114i = new AtomicInteger(0);

    /* renamed from: j */
    public final ConcurrentHashMap f13115j = new ConcurrentHashMap(5, 0.75f, 1);

    /* renamed from: k */
    public zaae f13116k = null;

    /* renamed from: l */
    public final ArraySet f13117l = new ArraySet();

    /* renamed from: m */
    public final ArraySet f13118m = new ArraySet();

    public GoogleApiManager(Context context, Looper looper, GoogleApiAvailability googleApiAvailability) {
        this.f13120o = true;
        this.f13110e = context;
        com.google.android.gms.internal.base.zau zauVar = new com.google.android.gms.internal.base.zau(looper, this);
        this.f13119n = zauVar;
        this.f13111f = googleApiAvailability;
        this.f13112g = new com.google.android.gms.common.internal.zal(googleApiAvailability);
        if (DeviceProperties.isAuto(context)) {
            this.f13120o = false;
        }
        zauVar.sendMessage(zauVar.obtainMessage(6));
    }

    /* renamed from: b */
    public static Status m3086b(ApiKey apiKey, ConnectionResult connectionResult) {
        return new Status(connectionResult, "API: " + apiKey.zaa() + " is not available on this device. Connection failed with: " + String.valueOf(connectionResult));
    }

    @KeepForSdk
    public static void reportSignOut() {
        synchronized (f13104q) {
            try {
                GoogleApiManager googleApiManager = f13105r;
                if (googleApiManager != null) {
                    googleApiManager.f13114i.incrementAndGet();
                    com.google.android.gms.internal.base.zau zauVar = googleApiManager.f13119n;
                    zauVar.sendMessageAtFrontOfQueue(zauVar.obtainMessage(10));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    public static GoogleApiManager zaj() {
        GoogleApiManager googleApiManager;
        synchronized (f13104q) {
            Preconditions.checkNotNull(f13105r, "Must guarantee manager is non-null before using getInstance");
            googleApiManager = f13105r;
        }
        return googleApiManager;
    }

    @NonNull
    @ResultIgnorabilityUnspecified
    public static GoogleApiManager zak(@NonNull Context context) {
        GoogleApiManager googleApiManager;
        synchronized (f13104q) {
            try {
                if (f13105r == null) {
                    f13105r = new GoogleApiManager(context.getApplicationContext(), GmsClientSupervisor.getOrStartHandlerThread().getLooper(), GoogleApiAvailability.getInstance());
                }
                googleApiManager = f13105r;
            } catch (Throwable th) {
                throw th;
            }
        }
        return googleApiManager;
    }

    /* renamed from: a */
    public final boolean m3087a() {
        if (this.f13107b) {
            return false;
        }
        RootTelemetryConfiguration config = RootTelemetryConfigManager.getInstance().getConfig();
        if (config != null && !config.getMethodInvocationTelemetryEnabled()) {
            return false;
        }
        int zaa2 = this.f13112g.zaa(this.f13110e, 203400000);
        if (zaa2 != -1 && zaa2 != 0) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    public final zabq m3088c(GoogleApi googleApi) {
        ConcurrentHashMap concurrentHashMap = this.f13115j;
        ApiKey apiKey = googleApi.getApiKey();
        zabq zabqVar = (zabq) concurrentHashMap.get(apiKey);
        if (zabqVar == null) {
            zabqVar = new zabq(this, googleApi);
            concurrentHashMap.put(apiKey, zabqVar);
        }
        if (zabqVar.zaA()) {
            this.f13118m.add(apiKey);
        }
        zabqVar.zao();
        return zabqVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m3089d(TaskCompletionSource taskCompletionSource, int i, GoogleApi googleApi) {
        a83 a83Var;
        long j;
        long j2;
        if (i != 0) {
            ApiKey apiKey = googleApi.getApiKey();
            if (m3087a()) {
                RootTelemetryConfiguration config = RootTelemetryConfigManager.getInstance().getConfig();
                boolean z = true;
                if (config != null) {
                    if (config.getMethodInvocationTelemetryEnabled()) {
                        boolean methodTimingTelemetryEnabled = config.getMethodTimingTelemetryEnabled();
                        zabq zabqVar = (zabq) this.f13115j.get(apiKey);
                        if (zabqVar != null) {
                            if (zabqVar.zaf() instanceof BaseGmsClient) {
                                BaseGmsClient baseGmsClient = (BaseGmsClient) zabqVar.zaf();
                                if (baseGmsClient.hasConnectionInfo() && !baseGmsClient.isConnecting()) {
                                    ConnectionTelemetryConfiguration m41a = a83.m41a(zabqVar, baseGmsClient, i);
                                    if (m41a != null) {
                                        zabqVar.f13269l++;
                                        z = m41a.getMethodTimingTelemetryEnabled();
                                    }
                                }
                            }
                        }
                        z = methodTimingTelemetryEnabled;
                    }
                }
                if (z) {
                    j = System.currentTimeMillis();
                } else {
                    j = 0;
                }
                if (z) {
                    j2 = SystemClock.elapsedRealtime();
                } else {
                    j2 = 0;
                }
                a83Var = new a83(this, i, apiKey, j, j2);
                if (a83Var == null) {
                    Task task = taskCompletionSource.getTask();
                    final com.google.android.gms.internal.base.zau zauVar = this.f13119n;
                    zauVar.getClass();
                    task.addOnCompleteListener(new Executor() { // from class: com.google.android.gms.common.api.internal.zabk
                        @Override // java.util.concurrent.Executor
                        public final void execute(Runnable runnable) {
                            zauVar.post(runnable);
                        }
                    }, a83Var);
                    return;
                }
                return;
            }
            a83Var = null;
            if (a83Var == null) {
            }
        }
    }

    @Override // android.os.Handler.Callback
    @WorkerThread
    public final boolean handleMessage(@NonNull Message message) {
        Feature[] zab;
        int i = message.what;
        com.google.android.gms.internal.base.zau zauVar = this.f13119n;
        ConcurrentHashMap concurrentHashMap = this.f13115j;
        Context context = this.f13110e;
        long j = 300000;
        zabq zabqVar = null;
        switch (i) {
            case 1:
                if (true == ((Boolean) message.obj).booleanValue()) {
                    j = 10000;
                }
                this.f13106a = j;
                zauVar.removeMessages(12);
                Iterator it = concurrentHashMap.keySet().iterator();
                while (it.hasNext()) {
                    zauVar.sendMessageDelayed(zauVar.obtainMessage(12, (ApiKey) it.next()), this.f13106a);
                }
                return true;
            case 2:
                zal zalVar = (zal) message.obj;
                Iterator it2 = zalVar.zab().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        ApiKey apiKey = (ApiKey) it2.next();
                        zabq zabqVar2 = (zabq) concurrentHashMap.get(apiKey);
                        if (zabqVar2 == null) {
                            zalVar.zac(apiKey, new ConnectionResult(13), null);
                        } else if (zabqVar2.f13259b.isConnected()) {
                            zalVar.zac(apiKey, ConnectionResult.RESULT_SUCCESS, zabqVar2.zaf().getEndpointPackageName());
                        } else {
                            ConnectionResult zad = zabqVar2.zad();
                            if (zad != null) {
                                zalVar.zac(apiKey, zad, null);
                            } else {
                                zabqVar2.zat(zalVar);
                                zabqVar2.zao();
                            }
                        }
                    }
                }
                return true;
            case 3:
                for (zabq zabqVar3 : concurrentHashMap.values()) {
                    zabqVar3.zan();
                    zabqVar3.zao();
                }
                return true;
            case 4:
            case 8:
            case 13:
                zach zachVar = (zach) message.obj;
                zabq zabqVar4 = (zabq) concurrentHashMap.get(zachVar.zac.getApiKey());
                if (zabqVar4 == null) {
                    zabqVar4 = m3088c(zachVar.zac);
                }
                if (zabqVar4.zaA() && this.f13114i.get() != zachVar.zab) {
                    zachVar.zaa.zad(zaa);
                    zabqVar4.zav();
                } else {
                    zabqVar4.zap(zachVar.zaa);
                }
                return true;
            case 5:
                int i2 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                Iterator it3 = concurrentHashMap.values().iterator();
                while (true) {
                    if (it3.hasNext()) {
                        zabq zabqVar5 = (zabq) it3.next();
                        if (zabqVar5.zab() == i2) {
                            zabqVar = zabqVar5;
                        }
                    }
                }
                if (zabqVar != null) {
                    if (connectionResult.getErrorCode() == 13) {
                        zabqVar.m3114c(new Status(17, "Error resolution was canceled by the user, original error message: " + this.f13111f.getErrorString(connectionResult.getErrorCode()) + ": " + connectionResult.getErrorMessage()));
                    } else {
                        zabqVar.m3114c(m3086b(zabqVar.f13260c, connectionResult));
                    }
                } else {
                    Log.wtf("GoogleApiManager", ye0.m8292l(i2, "Could not find API instance ", " while trying to fail enqueued calls."), new Exception());
                }
                return true;
            case 6:
                if (context.getApplicationContext() instanceof Application) {
                    BackgroundDetector.initialize((Application) context.getApplicationContext());
                    BackgroundDetector.getInstance().addListener(new C0745c(this));
                    if (!BackgroundDetector.getInstance().readCurrentStateIfPossible(true)) {
                        this.f13106a = 300000L;
                    }
                }
                return true;
            case 7:
                m3088c((GoogleApi) message.obj);
                return true;
            case 9:
                if (concurrentHashMap.containsKey(message.obj)) {
                    ((zabq) concurrentHashMap.get(message.obj)).zau();
                }
                return true;
            case 10:
                ArraySet arraySet = this.f13118m;
                Iterator<E> it4 = arraySet.iterator();
                while (it4.hasNext()) {
                    zabq zabqVar6 = (zabq) concurrentHashMap.remove((ApiKey) it4.next());
                    if (zabqVar6 != null) {
                        zabqVar6.zav();
                    }
                }
                arraySet.clear();
                return true;
            case 11:
                if (concurrentHashMap.containsKey(message.obj)) {
                    ((zabq) concurrentHashMap.get(message.obj)).zaw();
                }
                return true;
            case 12:
                if (concurrentHashMap.containsKey(message.obj)) {
                    ((zabq) concurrentHashMap.get(message.obj)).zaB();
                }
                return true;
            case 14:
                z63 z63Var = (z63) message.obj;
                ApiKey apiKey2 = z63Var.f29260a;
                boolean containsKey = concurrentHashMap.containsKey(apiKey2);
                TaskCompletionSource taskCompletionSource = z63Var.f29261b;
                if (!containsKey) {
                    taskCompletionSource.setResult(Boolean.FALSE);
                } else {
                    taskCompletionSource.setResult(Boolean.valueOf(((zabq) concurrentHashMap.get(apiKey2)).m3122k(false)));
                }
                return true;
            case 15:
                u73 u73Var = (u73) message.obj;
                if (concurrentHashMap.containsKey(u73Var.f27143a)) {
                    zabq zabqVar7 = (zabq) concurrentHashMap.get(u73Var.f27143a);
                    if (zabqVar7.f13267j.contains(u73Var) && !zabqVar7.f13266i) {
                        if (!zabqVar7.f13259b.isConnected()) {
                            zabqVar7.zao();
                        } else {
                            zabqVar7.m3116e();
                        }
                    }
                }
                return true;
            case 16:
                u73 u73Var2 = (u73) message.obj;
                if (concurrentHashMap.containsKey(u73Var2.f27143a)) {
                    zabq zabqVar8 = (zabq) concurrentHashMap.get(u73Var2.f27143a);
                    if (zabqVar8.f13267j.remove(u73Var2)) {
                        GoogleApiManager googleApiManager = zabqVar8.f13270m;
                        googleApiManager.f13119n.removeMessages(15, u73Var2);
                        googleApiManager.f13119n.removeMessages(16, u73Var2);
                        LinkedList linkedList = zabqVar8.f13258a;
                        ArrayList arrayList = new ArrayList(linkedList.size());
                        Iterator it5 = linkedList.iterator();
                        while (true) {
                            boolean hasNext = it5.hasNext();
                            Feature feature = u73Var2.f27144b;
                            if (hasNext) {
                                zai zaiVar = (zai) it5.next();
                                if ((zaiVar instanceof zac) && (zab = ((zac) zaiVar).zab(zabqVar8)) != null && ArrayUtils.contains(zab, feature)) {
                                    arrayList.add(zaiVar);
                                }
                            } else {
                                int size = arrayList.size();
                                for (int i3 = 0; i3 < size; i3++) {
                                    zai zaiVar2 = (zai) arrayList.get(i3);
                                    linkedList.remove(zaiVar2);
                                    zaiVar2.zae(new UnsupportedApiCallException(feature));
                                }
                            }
                        }
                    }
                }
                return true;
            case 17:
                TelemetryData telemetryData = this.f13108c;
                if (telemetryData != null) {
                    if (telemetryData.zaa() > 0 || m3087a()) {
                        if (this.f13109d == null) {
                            this.f13109d = TelemetryLogging.getClient(context);
                        }
                        this.f13109d.log(telemetryData);
                    }
                    this.f13108c = null;
                }
                return true;
            case 18:
                b83 b83Var = (b83) message.obj;
                long j2 = b83Var.f7930c;
                MethodInvocation methodInvocation = b83Var.f7928a;
                int i4 = b83Var.f7929b;
                if (j2 == 0) {
                    TelemetryData telemetryData2 = new TelemetryData(i4, Arrays.asList(methodInvocation));
                    if (this.f13109d == null) {
                        this.f13109d = TelemetryLogging.getClient(context);
                    }
                    this.f13109d.log(telemetryData2);
                } else {
                    TelemetryData telemetryData3 = this.f13108c;
                    if (telemetryData3 != null) {
                        List zab2 = telemetryData3.zab();
                        if (telemetryData3.zaa() == i4 && (zab2 == null || zab2.size() < b83Var.f7931d)) {
                            this.f13108c.zac(methodInvocation);
                        } else {
                            zauVar.removeMessages(17);
                            TelemetryData telemetryData4 = this.f13108c;
                            if (telemetryData4 != null) {
                                if (telemetryData4.zaa() > 0 || m3087a()) {
                                    if (this.f13109d == null) {
                                        this.f13109d = TelemetryLogging.getClient(context);
                                    }
                                    this.f13109d.log(telemetryData4);
                                }
                                this.f13108c = null;
                            }
                        }
                    }
                    if (this.f13108c == null) {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(methodInvocation);
                        this.f13108c = new TelemetryData(i4, arrayList2);
                        zauVar.sendMessageDelayed(zauVar.obtainMessage(17), b83Var.f7930c);
                    }
                }
                return true;
            case 19:
                this.f13107b = false;
                return true;
            default:
                Log.w("GoogleApiManager", "Unknown message id: " + i);
                return false;
        }
    }

    public final void zaA(@NonNull zaae zaaeVar) {
        synchronized (f13104q) {
            try {
                if (this.f13116k != zaaeVar) {
                    this.f13116k = zaaeVar;
                    this.f13117l.clear();
                }
                this.f13117l.addAll((Collection) zaaeVar.f13190b);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final int zaa() {
        return this.f13113h.getAndIncrement();
    }

    @NonNull
    public final Task zam(@NonNull Iterable iterable) {
        zal zalVar = new zal(iterable);
        com.google.android.gms.internal.base.zau zauVar = this.f13119n;
        zauVar.sendMessage(zauVar.obtainMessage(2, zalVar));
        return zalVar.zaa();
    }

    @NonNull
    @ResultIgnorabilityUnspecified
    public final Task zan(@NonNull GoogleApi googleApi) {
        z63 z63Var = new z63(googleApi.getApiKey());
        com.google.android.gms.internal.base.zau zauVar = this.f13119n;
        zauVar.sendMessage(zauVar.obtainMessage(14, z63Var));
        return z63Var.f29261b.getTask();
    }

    @NonNull
    public final Task zao(@NonNull GoogleApi googleApi, @NonNull RegisterListenerMethod registerListenerMethod, @NonNull UnregisterListenerMethod unregisterListenerMethod, @NonNull Runnable runnable) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        m3089d(taskCompletionSource, registerListenerMethod.zaa(), googleApi);
        zach zachVar = new zach(new zaf(new zaci(registerListenerMethod, unregisterListenerMethod, runnable), taskCompletionSource), this.f13114i.get(), googleApi);
        com.google.android.gms.internal.base.zau zauVar = this.f13119n;
        zauVar.sendMessage(zauVar.obtainMessage(8, zachVar));
        return taskCompletionSource.getTask();
    }

    @NonNull
    public final Task zap(@NonNull GoogleApi googleApi, @NonNull ListenerHolder.ListenerKey listenerKey, int i) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        m3089d(taskCompletionSource, i, googleApi);
        zach zachVar = new zach(new zah(listenerKey, taskCompletionSource), this.f13114i.get(), googleApi);
        com.google.android.gms.internal.base.zau zauVar = this.f13119n;
        zauVar.sendMessage(zauVar.obtainMessage(13, zachVar));
        return taskCompletionSource.getTask();
    }

    public final void zau(@NonNull GoogleApi googleApi, int i, @NonNull BaseImplementation.ApiMethodImpl apiMethodImpl) {
        zach zachVar = new zach(new zae(i, apiMethodImpl), this.f13114i.get(), googleApi);
        com.google.android.gms.internal.base.zau zauVar = this.f13119n;
        zauVar.sendMessage(zauVar.obtainMessage(4, zachVar));
    }

    public final void zav(@NonNull GoogleApi googleApi, int i, @NonNull TaskApiCall taskApiCall, @NonNull TaskCompletionSource taskCompletionSource, @NonNull StatusExceptionMapper statusExceptionMapper) {
        m3089d(taskCompletionSource, taskApiCall.zaa(), googleApi);
        zach zachVar = new zach(new zag(i, taskApiCall, taskCompletionSource, statusExceptionMapper), this.f13114i.get(), googleApi);
        com.google.android.gms.internal.base.zau zauVar = this.f13119n;
        zauVar.sendMessage(zauVar.obtainMessage(4, zachVar));
    }

    public final void zax(@NonNull ConnectionResult connectionResult, int i) {
        if (!this.f13111f.zah(this.f13110e, connectionResult, i)) {
            com.google.android.gms.internal.base.zau zauVar = this.f13119n;
            zauVar.sendMessage(zauVar.obtainMessage(5, i, 0, connectionResult));
        }
    }

    public final void zay() {
        com.google.android.gms.internal.base.zau zauVar = this.f13119n;
        zauVar.sendMessage(zauVar.obtainMessage(3));
    }

    public final void zaz(@NonNull GoogleApi googleApi) {
        com.google.android.gms.internal.base.zau zauVar = this.f13119n;
        zauVar.sendMessage(zauVar.obtainMessage(7, googleApi));
    }
}
